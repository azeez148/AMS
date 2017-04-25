package com.experion.ams.mvc.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.AssetDisposal;
import com.experion.ams.entity.AssetGroupDepreciationMap;
import com.experion.ams.entity.AssetRevalue;
import com.experion.ams.entity.AssetTransfer;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.PurchaseInfo;
import com.experion.ams.entity.Role;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.mvc.data.AssetApproveForm;
import com.experion.ams.mvc.data.AssetForm;
import com.experion.ams.mvc.data.LoginForm;
import com.experion.ams.service.AmsPurchaseInfoService;
import com.experion.ams.service.AssetService;
import com.experion.ams.service.DashboardService;
import com.experion.ams.service.ManagerInboxService;
import com.experion.ams.service.TransferHistService;
import com.experion.ams.util.AMSUtil;

@Controller
@RequestMapping("/login/*")
public class ManagerInboxController {

	private static final String MANAGER_INBOX_PAGE = "/managerinbox";
	private static final String ASSET_APPROVE_PAGE = "/assetapprove";
	private static final String WRITE_REVALUE_PAGE = "/writerevalue";
	private static final String STATUS_ACTIVE = "Active";
	private static final String COM_MAKE = "MK";
	private static final String COM_DEPT = "DPT";
	private static final String COM_TYPE = "AST";
	private static final String COM_CONDITION = "CND";
	private static final String COM_CURRENTLYAT = "CAT";
	private static final String COM_LOCATION = "LC";
	private static final String COM_PROJECT = "PRJ";

	private static final Log log = LogFactory.getLog(LoginController.class);

	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;

	public DashboardService getDashboardService() {
		return dashboardService;
	}

	public void setDashboardService(DashboardService dashboardService) {
		this.dashboardService = dashboardService;
	}

	@Inject
	@Named(value = "managerInboxService")
	private ManagerInboxService managerInboxService;

	public ManagerInboxService getManagerInboxService() {
		return managerInboxService;
	}

	public void setManagerInboxService(ManagerInboxService managerInboxService) {
		this.managerInboxService = managerInboxService;
	}
	
	@Inject
	@Named("assetService")
	public AssetService assetService;
	
	@Inject
	@Named(value = "transferHistService")
	private TransferHistService transferHistService;

	@Inject
	@Named(value = "amsPurchaseService")
	private AmsPurchaseInfoService amsPurchaseService;

	public AmsPurchaseInfoService getAmsPurchaseService() {
		return amsPurchaseService;
	}

	public void setAmsPurchaseService(AmsPurchaseInfoService amsPurchaseService) {
		this.amsPurchaseService = amsPurchaseService;
	}

	@RequestMapping(value = "/managerInbox")
	public ModelAndView showManagerInbox(HttpServletRequest request,
			HttpSession session) {
		ModelAndView mav = new ModelAndView(MANAGER_INBOX_PAGE, "AssetForm",
				new AssetApproveForm());

		mav.addObject("assetDetails", managerInboxService.getAllPendingAssets());
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			mav.addObject("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}

		return mav;
	}

	@RequestMapping(value = "/searchManagerInbox")
	public ModelAndView SearchManagerInbox(
			@ModelAttribute("AssetForm") AssetApproveForm AssetForm,
			HttpServletRequest request, HttpSession session) {
		String assetNo = request.getParameter("assetNo");
		String assetStatus = request.getParameter("assetStatus");
		ModelAndView mav = new ModelAndView(MANAGER_INBOX_PAGE, "AssetForm",
				new AssetApproveForm());
		if (assetNo == "") {
			mav.addObject("assetDetails",
					managerInboxService.searchAssetManagerInbox(assetStatus));
		} else {
			mav.addObject("assetDetails", managerInboxService
					.searchAssetManagerInbox(assetStatus, assetNo));
		}
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			mav.addObject("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}

		return mav;
	}

	@RequestMapping(value = "/asssetApprove")
	public ModelAndView goToApproveAsset(HttpServletRequest request,
			HttpSession session, Asset asset) {
		ModelAndView mav = new ModelAndView(ASSET_APPROVE_PAGE, "AssetForm",
				new AssetApproveForm());
		
		/*Asset Information start*/
		List<SystemParametersCodeMaster> inProjectId = assetService
				.getProjectIdByName(COM_PROJECT);
		request.setAttribute("inProjectId", inProjectId.get(0).getComId());
		mav.addObject("availableAssetDetails",
				assetService.getAllAssetDetails());
		mav.addObject("allMakeList",
				assetService.getAllCodeValuesByType(COM_MAKE));
		mav.addObject("allDepartmentList",
				assetService.getAllCodeValuesByType(COM_DEPT));
		mav.addObject("allAssetTypeList",
				assetService.getAllCodeValuesByType(COM_TYPE));
		mav.addObject("allConditionList",
				assetService.getAllCodeValuesByType(COM_CONDITION));
		mav.addObject("allCurrentlyAtList",
				assetService.getAllCodeValuesByType(COM_CURRENTLYAT));
		mav.addObject("allLocationList",
				assetService.getAllCodeValuesByType(COM_LOCATION));
		mav.addObject("allProjectList",
				assetService.getAllCodeValuesByType(COM_PROJECT));
		mav.addObject("allGroupDetails", assetService.getAllGroupDetails());
		mav.addObject("allCustodianDetails",
				assetService.getAllCustodianDetails());
		/*Asset Information End*/
		
		/* Purchase Info Start */
		List<Asset> assetGroup = amsPurchaseService.getPurchaseInfo();
		amsPurchaseService.getVendor("VNDR");
		mav.addObject("vendor", amsPurchaseService.getVendor("VNDR"));
		mav.addObject("assetgroup", assetGroup);
		mav.addObject("section", "Purchase Info");
		request.setAttribute("section", "Purchase List");
		List<AssetDepreciation> depriciationList = amsPurchaseService
				.listDdepriciationDetails();
		mav.addObject("deprlist", depriciationList);
		List<Asset> lis = amsPurchaseService.getAssetbyId(asset.getAssetId());
		List<AssetGroupDepreciationMap> depriciation = amsPurchaseService
				.getDepriciation(lis.get(0).getAssetGroupCode().getGroupId());
		mav.addObject("depriciation", depriciation.get(0));
		List<PurchaseInfo> purchaseinfo = amsPurchaseService
				.getPurchaseInfoById(asset.getAssetId());
		mav.addObject("assetList",lis);
		if (purchaseinfo.isEmpty()) {
			mav.addObject("aid", asset.getAssetId());
		} else {
			mav.addObject("aid", asset.getAssetId());
			mav.addObject("info", purchaseinfo.get(0));
		}
		/* Purchase Info End */

		/* Approve/Reject Start */
		mav.addObject("ApprovedAsset",
				managerInboxService.getApprovedAssets(asset.getAssetId()));
		/* Approve/Reject End */
		
		/*Date conversion start*/
		try {
			mav.addObject("warDate", AMSUtil.getSimpleDateFormat(lis.get(0).getAssetWarrantyEndDate()));
			mav.addObject("purchaseDate", AMSUtil.getSimpleDateFormat(lis.get(0).getAssetPurchaseReqDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*Date conversion end*/
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			mav.addObject("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}

		return mav;
	}

	@RequestMapping(value = "/writeRevalue")
	public ModelAndView goToWriteRevalue(HttpServletRequest request,
			HttpSession session, Asset asset) {
		ModelAndView mav = new ModelAndView(WRITE_REVALUE_PAGE, "AssetForm",
				new AssetApproveForm());
		List<Asset> assetList = managerInboxService.getApprovedAssets(asset
				.getAssetId());
		List<AssetTransfer> assetTransferList = transferHistService
				.getAllTranHistAssets(asset.getAssetId());
		mav.addObject("WrAsset", assetList);
		try {
			mav.addObject("capitalDate", AMSUtil.getSimpleDateFormat(assetList
					.get(0).getAssetCapitalizationDate()));
			if (!assetTransferList.isEmpty()) {
				mav.addObject("transferDate", AMSUtil
							.getSimpleDateFormat(assetTransferList.get(
								assetTransferList.size() - 1)
								.getTransferTransferredOn()));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			mav.addObject("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}

		return mav;
	}

	@RequestMapping(value = "/approveAsset")
	public ModelAndView forApproveAsset(HttpServletRequest request,
			HttpSession session, @ModelAttribute("command") Asset asset,
			AssetDisposal assetDisposal, AssetRevalue assetRevalue,
			AssetWorkflow assetWorkflow) {
		if (assetRevalue.getRevRevalueAmount() == null) {
			managerInboxService.approveAssetForWrite(asset, assetDisposal);
		} else {
			managerInboxService.approveAssetForRevalue(asset, assetRevalue);
		}
		ModelAndView mav = showManagerInbox(request, session);
		return mav;
	}

	@RequestMapping(value = "/rejectAsset")
	public ModelAndView forRejectAsset(HttpServletRequest request,
			HttpSession session, @ModelAttribute("command") Asset asset,
			AssetWorkflow assetWorkflow) {
		managerInboxService.rejectAssetForWriteRevalue(asset, assetWorkflow);
		ModelAndView mav = showManagerInbox(request, session);
		return mav;
	}

	@RequestMapping(value = "/appReject")
	public ModelAndView forRejectApprove(HttpServletRequest request,
			HttpSession session, @ModelAttribute("command") Asset asset,
			AssetWorkflow assetWorkflow) {
		managerInboxService.approveRejectForAsset(asset, assetWorkflow);
		ModelAndView mav = showManagerInbox(request, session);
		return mav;
	}

	@RequestMapping(value = "/updateApproveAsset")
	public ModelAndView updateApproveAsset(
			@ModelAttribute("command") Asset asset, PurchaseInfo purchaseInfo,
			HttpServletRequest request, HttpSession session) {
		/*log.info("welcome : "+asset.getAssetPurchaseReqDate());*/
		int status = managerInboxService.updateAproveAssetValues(asset,
				purchaseInfo);
		ModelAndView mav = goToApproveAsset(request, session, asset);
		if (status == 0) {
			mav.addObject("MsgStatus",
					"<span style='color:red'>Updation failed</span>");
		} else {
			mav.addObject("MsgStatus",
					"<span style='color:green'>Updated successfully</span>");
		}
		return mav;
	}

}
