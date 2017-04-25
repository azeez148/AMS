package com.experion.ams.mvc.controller;


import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.AssetGroupDepreciationMap;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.PurchaseInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.service.AmsPurchaseInfoService;
import com.experion.ams.service.DashboardService;
import com.experion.ams.util.AMSUtil;

@Transactional
@Controller
@RequestMapping("/login/*")
public class PurchaseInfoController {
	public static final String PURCHASE_INFO_PAGE = "/purchaseInfo";

	@SuppressWarnings("unused")
	private static final Log log = LogFactory
			.getLog(PurchaseInfoController.class);

	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;

	@Inject
	@Named(value = "messageSource")
	MessageSource messageSource;

	@Inject
	@Named(value = "amsPurchaseService")
	private AmsPurchaseInfoService amsPurchaseService;

	public AmsPurchaseInfoService getAmsPurchaseService() {
		return amsPurchaseService;
	}

	public void setAmsPurchaseService(AmsPurchaseInfoService amsPurchaseService) {
		this.amsPurchaseService = amsPurchaseService;
	}

	@RequestMapping(value = "/PurchaseInfo")
    public ModelAndView listAllAssets(@ModelAttribute("command") Asset asset,HttpServletRequest request,HttpSession session,
			Model model,Employee employee) {
	model.addAttribute("section", "Purchase List");
	request.setAttribute("section", "Purchase List");
	List<Asset> assetGroup =amsPurchaseService.getPurchaseInfo();
	model.addAttribute("assetgroup",assetGroup);
	long employeeCode = new AMSUtil().getEmployeeCode(session);
	if (employeeCode > 0) {
		model.addAttribute("AuthScreens",
				dashboardService.checkAuthorizedEmp(employeeCode));
	} else {
		return new ModelAndView("redirect:/login/index");
	}
		return new ModelAndView(PURCHASE_INFO_PAGE);

	}

	@RequestMapping(value = "/purchaseInfo")
	public ModelAndView purchaseinfo(@ModelAttribute("command") Asset asset,
			HttpServletRequest request, HttpSession session, Model model, Employee employee,
			PurchaseInfo info, SystemParametersCodeMaster master) {
		List<Asset> assetGroup = amsPurchaseService.getPurchaseInfo();

		amsPurchaseService.getVendor("VNDR");
		model.addAttribute("vendor", amsPurchaseService.getVendor("VNDR"));
		model.addAttribute("assetgroup", assetGroup);
		model.addAttribute("section", "Purchase Info");
		request.setAttribute("section", "Purchase List");
		List<AssetDepreciation> depriciationList = amsPurchaseService
				.listDdepriciationDetails();
		model.addAttribute("deprlist", depriciationList);
	
		
		int assetId = Integer.parseInt(request.getSession()
				.getAttribute("assetPurchaseId").toString());
		if(assetId>0){
		
		List<Asset> lis = amsPurchaseService.getAssetbyId(assetId);
		List<AssetGroupDepreciationMap> depriciation = amsPurchaseService
				.getDepriciation(lis.get(0).getAssetGroupCode().getGroupId());
		model.addAttribute("depriciation", depriciation.get(0));
		List<PurchaseInfo> purchaseinfo = amsPurchaseService
				.getPurchaseInfoById(assetId);

		if (purchaseinfo.isEmpty()) {
			System.out.println("asset id........." + assetId);
			model.addAttribute("aid", assetId);
			model.addAttribute("assetPurchaseNo", lis.get(0).getAssetNumber());
			
		} else {
			model.addAttribute("aid", assetId);
			model.addAttribute("assetPurchaseNo", lis.get(0).getAssetNumber());
			model.addAttribute("info", purchaseinfo.get(0));
		}
		}
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		return new ModelAndView(PURCHASE_INFO_PAGE);

	}

	@RequestMapping(value = "/addPurchaseInfo")

	public ModelAndView addPurchaseinfo(@ModelAttribute("command") PurchaseInfo info,HttpServletRequest request,HttpSession session,
			Model model,Employee employee,Asset asset,AssetWorkflow assetWorkFlow) {
		
		int assetId = Integer.parseInt(request.getSession()
				.getAttribute("assetPurchaseId").toString());
		model.addAttribute("section", "Purchase List");
		request.setAttribute("section", "Purchase List");

		
		//get vendor ist


		// get vendor ist

		amsPurchaseService.getVendor("VNDR");
		model.addAttribute("vendor", amsPurchaseService.getVendor("VNDR"));
		 System.out.println("haii"+asset.getAssetId());
		// purchase list
		List<Asset> assetGroup = amsPurchaseService.getPurchaseInfo();
		model.addAttribute("assetgroup", assetGroup);
		model.addAttribute("aid", assetId);

		List<PurchaseInfo> purchaseinfo = amsPurchaseService
				.getPurchaseInfoById(assetId);

		
		
		if (purchaseinfo.isEmpty()) {
			System.out.println("save..............");
			Calendar calendar = Calendar.getInstance();
		    java.util.Date currentDate = calendar.getTime();
		    info.setPiDeliveryDate(AMSUtil.dateFormatter(info.getDeliveryDate()));
		    info.setPurchaseCreatedate(currentDate);
		    //System.out.println("pi vendor"+info.get);
			info.setPiVender(info.getPiVender());
			List<Asset> lis = amsPurchaseService.getAssetbyId(assetId);
		   // System.out.println(asset.getAssetCustodianCode());
			info.setPurchaseCreatedBy(lis.get(0).getAssetCustodianCode().getEmpCode());
            info.setAsset(asset);
		    amsPurchaseService.addPurchaseinfo(info);
		    assetWorkFlow.setWorkflowAssetCode(asset);
		    assetWorkFlow.setWorkflowAssetStatus("Pending Approval");
		    assetWorkFlow.setWorkflowAssetType("Asset Approve");
		    amsPurchaseService.assetApprove(assetWorkFlow);
		
		}
		else{
			 System.out.println("vendor.............."+info.getPiVender());

			model.addAttribute("aid", assetId);
			// set current date
			Calendar calendar = Calendar.getInstance();
			java.util.Date currentDate = calendar.getTime();
			System.out.println("update........"+assetId);
			info.setPiDeliveryDate(AMSUtil.dateFormatter(info.getDeliveryDate()));
			info.setPiVender(info.getPiVender());
		    info.setPiId(purchaseinfo.get(0).getPiId());
		    
		   // info.setPipoDate(AMSUtil.getSimpleDate(info.getPoDate()));
		    info.setPurchaseCreatedBy(purchaseinfo.get(0).getAsset().getAssetCustodianCode().getEmpCode());
		    info.setPurchaseUpdateBy(purchaseinfo.get(0).getAsset().getAssetCustodianCode().getEmpCode());
		    info.setPurchaseUpdateBy(purchaseinfo.get(0).getAsset().getAssetCustodianCode().getEmpCode());
		    info.setPurchaseCreatedate(purchaseinfo.get(0).getPurchaseCreatedate());
		    info.setPurchaseUpdateDate(currentDate);
		    info.setAsset(purchaseinfo.get(0).getAsset());
		   	amsPurchaseService.updateInfo(info);
		}
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		return new ModelAndView(PURCHASE_INFO_PAGE);
	}

	@RequestMapping(value = "/searchAsset")
	public ModelAndView searchAsset(@ModelAttribute("command") Asset asset,
			HttpServletRequest request,HttpSession session, Model model) {
		
		model.addAttribute("section", "Purchase List");
		request.setAttribute("section", "Purchase List");
		if (!"".equals(asset.getAssetNumber())) {
			List<Asset> assetGroup = amsPurchaseService.searchAsset(asset.getAssetNumber());
			model.addAttribute("assetgroup", assetGroup);
		}
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
				return new ModelAndView(PURCHASE_INFO_PAGE);
}
	@RequestMapping(value = "/setPurchaseAssetIdToSession", method = RequestMethod.GET)
	public void setAssetIdToSession(@ModelAttribute("command") Asset asset,
			HttpServletRequest request, HttpSession session) {
		session.setAttribute("assetPurchaseId", asset.getAssetId());
	}


}
