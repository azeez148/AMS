package com.experion.ams.mvc.controller;

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
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.ServiceInfo;
import com.experion.ams.service.AmsPurchaseInfoService;
import com.experion.ams.service.AmsServiceInfoHistoryService;
import com.experion.ams.service.DashboardService;
import com.experion.ams.util.AMSUtil;

@Transactional
@Controller
@RequestMapping("/login/*")
public class ServiceIfoHistoryController {
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(PurchaseInfoController.class);
	public static final String SERVICE_HISTORY_INFO_PAGE = "/serviceinfohistory";
	
	
	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;

	@Inject
	@Named(value = "messageSource")
	MessageSource messageSource;
	
	
	@Inject
	@Named(value = "amsServiceHistoryService")
	private AmsServiceInfoHistoryService amsServiceHistoryService;


	public AmsServiceInfoHistoryService getAmsServiceHistoryService() {
		return amsServiceHistoryService;
	}


	public void setAmsServiceHistoryService(
			AmsServiceInfoHistoryService amsServiceHistoryService) {
		this.amsServiceHistoryService = amsServiceHistoryService;
	}
	
	@RequestMapping(value = "/serviceInfoHistory")
	public ModelAndView listAllAssets(@ModelAttribute("command") Asset asset,HttpServletRequest request,HttpSession session,
			Model model,Employee employee) {
		model.addAttribute("section", "List Assets");
		request.setAttribute("section", "List Assets");
		List<AssetWorkflow> assetList=amsServiceHistoryService.getAssets();
		model.addAttribute("assetlist", assetList);
		//List Assets
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
			return new ModelAndView(SERVICE_HISTORY_INFO_PAGE);

	}
	
	
	@RequestMapping(value = "/historyInfo")
	public ModelAndView historyInfo(@ModelAttribute("command") Asset asset,HttpServletRequest request,HttpSession session,
			Model model,Employee employee) {
		model.addAttribute("section", "History");
		request.setAttribute("section", "History");
		int assetId = Integer.parseInt(request.getSession()
				.getAttribute("asseServceInfoId").toString());
		List<AssetWorkflow> assetList=amsServiceHistoryService.getAssets();
		System.out.println(assetList.isEmpty());
		model.addAttribute("assetlist", assetList);
		List<Asset> assetLst=amsServiceHistoryService.getHistoryById(assetId);
		//model.addAttribute("asset",assetLst.get(0));
		List<ServiceInfo> info=amsServiceHistoryService.getServiceinfoHistory(assetId);
		if(info.isEmpty()){
			System.out.println("ifsize");
			model.addAttribute("asset",assetLst.get(0));
		}
		else{
			List<ServiceInfo> historyinfo=amsServiceHistoryService.getServiceinfoHistory(assetId);
			//List<ServiceInfo> historyinfo=amsServiceHistoryService.getServiceinfoHistory();
			System.out.println("size"+historyinfo.size());
			model.addAttribute("asset",assetLst.get(0));
			model.addAttribute("history", historyinfo);
		}
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
				return new ModelAndView(SERVICE_HISTORY_INFO_PAGE);

	}
	
	@RequestMapping(value = "/setServiceInfAssetIdToSession", method = RequestMethod.GET)
	public void setAssetIdToSession(@ModelAttribute("command") Asset asset,
			HttpServletRequest request, HttpSession session) {
		session.setAttribute("asseServceInfoId", asset.getAssetId());
	}
	
	@RequestMapping(value = "/searchHistoryAsset")
	public ModelAndView searchAsset(@ModelAttribute("command") Asset asset,
			HttpServletRequest request,HttpSession session, Model model) {
		
		model.addAttribute("section", "List Assets");
		request.setAttribute("section", "List Assets");
		if (!"".equals(asset.getAssetNumber())) {
			
			List<AssetWorkflow> assetList=amsServiceHistoryService.searchAsset(asset.getAssetNumber());
			model.addAttribute("assetlist", assetList);
		}
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
				return new ModelAndView(SERVICE_HISTORY_INFO_PAGE);
}
	
}
