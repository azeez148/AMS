package com.experion.ams.mvc.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.AssetDisposal;
import com.experion.ams.entity.AssetRevalue;
import com.experion.ams.entity.AssetTransfer;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.PurchaseInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.mvc.data.AssetForm;
import com.experion.ams.mvc.data.AssetTransferForm;
import com.experion.ams.mvc.data.GroupMasterForm;
import com.experion.ams.service.AmsServiceInfoHistoryService;
import com.experion.ams.service.AssetDepreciationService;
import com.experion.ams.service.AssetTransferService;
import com.experion.ams.service.DashboardService;
import com.experion.ams.service.ServiceInfoService;
import com.experion.ams.service.TransferHistService;
import com.experion.ams.service.impl.AssetTransferServiceImpl;
import com.experion.ams.util.AMSUtil;

@Controller
@RequestMapping("/transfer/*")
public class AssetTransferController {

	@Inject
	@Named(value = "amsServiceHistoryService")
	private AmsServiceInfoHistoryService amsServiceHistoryService;
	
	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;

	@Inject
	@Named(value = "assetTransferService")
	private AssetTransferService assetTransferService;

	@Inject
	@Named(value = "serviceinfoService")
	private ServiceInfoService serviceInfoService;

	@Inject
	@Named(value = "assetdepreciationservice")
	private AssetDepreciationService assetDepreciationService;

	private static final String ASSET_TRANSFER = "/assetTransfer";

	@Inject
	@Named(value = "transferHistService")
	private TransferHistService transferHistService;

	// @RequestMapping(value = "/transferHistory")
	// public ModelAndView showManagerInbox(HttpServletRequest request) {
	// ModelAndView mav = new ModelAndView(TRANSFER_HISTORY,"roleForm",
	// new Asset());
	// mav.addObject("availableAssetDetails",
	// transferHistService.getAllAvailAssets());
	// request.setAttribute("section", "List Asset");
	// long EmployeeCode = Long.parseLong(request.getSession()
	// .getAttribute("empCode").toString());
	// mav.addObject("AuthScreens", getAuthScreens(EmployeeCode));
	// return mav;
	// }

	@RequestMapping(value = "/assettransfer")
	public ModelAndView ShowDepreciation(
			@ModelAttribute("assetTransfer") AssetTransferForm assetTransferForm,
			BindingResult result, Model model, HttpServletRequest request) {
		// AssetDepreciation depreciation =new AssetDepreciation();
		// int start=1, end=10;
		// model.addAttribute("assetList",assetDepreciationService.assetList(start,end));
		//
		// long EmployeeCode =
		// Long.parseLong(request.getSession().getAttribute("empCode").toString());
		//
		// model.addAttribute("AuthScreens", getAuthScreens(EmployeeCode));
		//
		//
		// // getPagination(depreciation,request);
		//
		// return new
		// ModelAndView(ASSET_TRANSFER,"assetTransfer",assetTransferForm);
		List<Asset> assetList = convertToAsset(assetTransferService
				.getAllAvailAssets());
		model.addAttribute("availableAssetDetails", assetList);
		request.setAttribute("section", "List Asset");
		long EmployeeCode = Long.parseLong(request.getSession()
				.getAttribute("empCode").toString());
		model.addAttribute("AuthScreens", getAuthScreens(EmployeeCode));
		return new ModelAndView(ASSET_TRANSFER, "assetTransfer",
				assetTransferForm);
	}

	private List<Asset> convertToAsset(List<AssetWorkflow> allAvailAssets) {
		List<Asset> asset = new ArrayList<Asset>(0);
		for (AssetWorkflow assetWorkflow : allAvailAssets) {
			asset.add(assetWorkflow.getWorkflowAssetCode());
		}
		return asset;
	}

	public DashboardService getDashboardService() {
		return dashboardService;
	}

	public void setDashboardService(DashboardService dashboardService) {
		this.dashboardService = dashboardService;
	}

	public ServiceInfoService getServiceInfoService() {
		return serviceInfoService;
	}

	public void setServiceInfoService(ServiceInfoService serviceInfoService) {
		this.serviceInfoService = serviceInfoService;
	}

	public TransferHistService getTransferHistService() {
		return transferHistService;
	}

	public void setTransferHistService(TransferHistService transferHistService) {
		this.transferHistService = transferHistService;
	}

	public static String getAssetTransfer() {
		return ASSET_TRANSFER;
	}

	@RequestMapping(value = "/transferasset/{assetId}", method = RequestMethod.GET)
	public ModelAndView transferAsset(
			@PathVariable Integer assetId,
			@ModelAttribute("assetTransfer") AssetTransferForm assetTransferForm,
			BindingResult result,
			@ModelAttribute GroupMasterForm groupMasterForm,
			HttpServletRequest request, Model model, HttpSession session) {
		return new ModelAndView("redirect:../getAsset");

	}

	@RequestMapping(value = "/getAsset")
	public ModelAndView getAsset(
			@ModelAttribute("assetTransfer") AssetTransferForm assetTransferForm,
			BindingResult result, Model model, HttpServletRequest request,
			HttpSession session) {

		long EmployeeCode = Long.parseLong(request.getSession()
				.getAttribute("empCode").toString());

		int assetId = Integer.parseInt((String) session
				.getAttribute("transferId"));

		PurchaseInfo purchaseInfo = assetTransferService.getAsset(assetId);
		Asset asset = purchaseInfo.getAsset();
		assetTransferForm.setAssetId(assetId);
		assetTransferForm.setAssetNo(asset.getAssetNumber());
		assetTransferForm.setModel(asset.getAssetModel());
		assetTransferForm.setDesc(asset.getAssetDescription());
		assetTransferForm.setCapitalDate(purchaseInfo.getPiCaptialDate());
		if (asset.getAssetDepreciation().size() > 0) {
			assetTransferForm.setBookValue(asset.getAssetDepreciation()
					.get(asset.getAssetDepreciation().size() - 1)
					.getDepreciationBookValue());
		} else {

			if (asset.getPurchaseinfo() == null) {
				assetTransferForm.setBookValue(0d);
				assetTransferForm.setPurchaseCost(0d);
			} else {
				assetTransferForm.setBookValue(asset.getPurchaseinfo()
						.getPiPurchasecost());
				assetTransferForm.setPurchaseCost(asset.getPurchaseinfo()
						.getPiPurchasecost());
			}

		}
		assetTransferForm.setLocationFrom(asset.getAssetLocationCode()
				.getComValue());
		assetTransferForm.setDeptFrom(asset.getAssetDeptCode().getComValue());
		assetTransferForm.setCustFrom(asset.getAssetCustodianCode()
				.getEmpName());

		model.addAttribute("location",
				assetTransferService.getSystemParameters("LC"));
		model.addAttribute("department",
				assetTransferService.getSystemParameters("DPT"));
		model.addAttribute("AuthScreens", getAuthScreens(EmployeeCode));
		model.addAttribute("section", "Modify Depreciation");
		model.addAttribute("custodian", assetTransferService.getCustodians());
		String errorMessage = (String) session.getAttribute("errorMessage");
		if (StringUtils.equals(errorMessage, null)) {
			session.setAttribute("transFerId", null);
			return new ModelAndView(ASSET_TRANSFER, "assetTransfer",
					assetTransferForm);
		} else {
			model.addAttribute("section", "Modify Depreciation");
			model.addAttribute("errorMessage", errorMessage);
			session.setAttribute("errorMessage", null);
			return new ModelAndView(ASSET_TRANSFER, "assetTransfer",
					assetTransferForm);
		}

	}

	@RequestMapping(value = "/saveTransfer", method = RequestMethod.POST)
	public ModelAndView saveTransfer(
			@ModelAttribute("assetTransfer") AssetTransferForm assetTransferForm,
			BindingResult result, Model model, HttpServletRequest request,
			HttpSession session) {

		// System.err.println("transfer Submit is "+transferSubmit);
		// System.err.println("writeOffSubmit is "+writeOffSubmit);
		// System.err.println("reValSubmit is "+writeOffSubmit);
		System.err.println("Mahammood empId is "+request.getSession()
				.getAttribute("empCode"));
		long EmployeeCode = Long.parseLong(request.getSession()
				.getAttribute("empCode").toString());
		PurchaseInfo purchaseInfo = assetTransferService
				.getAsset(assetTransferForm.getAssetId());
		Asset asset = purchaseInfo.getAsset();
		Employee currentEmployee = assetTransferService
				.getEmployeeByCode(EmployeeCode);
		
		if (StringUtils.equals("", assetTransferForm.getTransferDate())) {
			session.setAttribute("errorMessage", "Transfer Date is Null");
			return new ModelAndView("redirect:/transfer/getAsset");
		} else {
			Date transferDate = null;
			Date today = new Date();
			try {
				transferDate = AMSUtil.formatStringToDate(
						assetTransferForm.getTransferDate(), "dd-MM-yyyy",
						"yyyy-MM-dd");
				if (transferDate.after(today)) {
					session.setAttribute("errorMessage",
							"Transfer Date is not Valid");
					return new ModelAndView("redirect:/transfer/getAsset");
				}
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (StringUtils.equals(assetTransferForm.getTransferType(),
					"Transfer Asset")) {
				asset.setAssetCustId(assetTransferForm.getCustTo());
				asset.setAssetLocCode(assetTransferForm.getLocationTo());
				asset.setAssetDeptCodeInt(assetTransferForm.getDeptTo());

				AssetTransfer assetTransfer = new AssetTransfer();
				long empId = currentEmployee.getEmpId();
				System.err.println("Emp Id is "+empId);
				assetTransfer.setTransferCreatedById(empId);
//				assetTransfer.setTransferCreatedBy(currentEmployee);
				assetTransfer.setTransferType(assetTransferForm
						.getTransferType());
				assetTransfer.setTransferLocId(assetTransferForm
						.getLocationTo());
				assetTransfer.setTransferDeptId(assetTransferForm.getDeptTo());
				assetTransfer.setTransferCustId(assetTransferForm.getCustTo());

				assetTransfer.setTransferTransferredOn(transferDate);
				assetTransfer.setTransferAssetCode(asset);

				assetTransferService.save(asset);
				assetTransferService.save(assetTransfer);
			} else if (StringUtils.equals(assetTransferForm.getTransferType(),
					"Write Off Asset")) {
				AssetDisposal assetDisposal = new AssetDisposal();
				assetDisposal.setAssetDispAssetCode(asset);
				Float writeValue = 0.0f;
				try {
					writeValue = Float.parseFloat(assetTransferForm
							.getWrittenDownVal());
				} catch (NumberFormatException exception) {
					session.setAttribute("errorMessage",
							"Entered Written Down Value is not Valid");
					return new ModelAndView("redirect:/transfer/getAsset");
				}
				assetDisposal.setAssetDispWriteOffAmount(writeValue);
				assetTransferService.save(assetDisposal);
				// return new ModelAndView("redirect:/transfer/getAsset");
			} else if (StringUtils.equals(assetTransferForm.getTransferType(),
					"Re-Value of Asset")) {
				AssetRevalue assetRevalue = new AssetRevalue();
				Double reValue = 0.0;
				try {
					reValue = assetTransferForm.getBookValueAfter();
				} catch (NumberFormatException exception) {
					session.setAttribute("errorMessage",
							"Book Value After Re-Valuation is not Valid");
					return new ModelAndView("redirect:/transfer/getAsset");
				}
				assetRevalue.setRevRevalueAmount(reValue);
				assetRevalue.setRevAssetCode(asset);
				assetTransferService.save(assetRevalue);
			}

			return new ModelAndView("redirect:/transfer/assettransfer");
		}

	}

	@RequestMapping(value = "/setAssetIdToSession", method = RequestMethod.GET)
	public void setAssetIdToSession(HttpServletRequest request,
			HttpSession session) {
		session.setAttribute("transferId", request.getParameter("assetId"));
	}

	public List<Employee> getAuthScreens(long employeeCode) {
		List<Employee> authScreens = dashboardService
				.checkAuthorizedEmp(employeeCode);
		return authScreens;
	}

	@RequestMapping(value = "/searchTransferAsset", method = RequestMethod.POST)
	public ModelAndView searchAssetInTransfer(
			@ModelAttribute("assetTransfer") AssetTransferForm assetTransferForm,
			HttpServletRequest request, HttpSession session, Model model) {
		String assetNumber = assetTransferForm.getSearchText();
		if (!"".equals(assetNumber)) {
			List<Asset> assetList = convertToAsset(amsServiceHistoryService.searchAsset(assetNumber));
			model.addAttribute("availableAssetDetails", assetList);
		}
		request.setAttribute("section", "List Asset");
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		return new ModelAndView(ASSET_TRANSFER, "roleForm", new Asset());
	}

	public AssetDepreciationService getAssetDepreciationService() {
		return assetDepreciationService;
	}

	public void setAssetDepreciationService(
			AssetDepreciationService assetDepreciationService) {
		this.assetDepreciationService = assetDepreciationService;
	}

	public AssetTransferService getAssetTransferService() {
		return assetTransferService;
	}

	public void setAssetTransferService(
			AssetTransferService assetTransferService) {
		this.assetTransferService = assetTransferService;
	}
}
