package com.experion.ams.mvc.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.auth.params.AuthPNames;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.AuthPolicy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetTransfer;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.Employee;
import com.experion.ams.mvc.controller.pmo.PMONTLMSchemeFactory;
import com.experion.ams.mvc.data.AssetForm;
import com.experion.ams.mvc.data.LoginForm;
import com.experion.ams.mvc.data.RoleForm;
import com.experion.ams.mvc.data.ServiceInfoForm;
import com.experion.ams.service.AmsServiceInfoHistoryService;
import com.experion.ams.service.DashboardService;
import com.experion.ams.service.LoginService;
import com.experion.ams.service.ServiceInfoService;
import com.experion.ams.service.TransferHistService;
import com.experion.ams.util.AMSUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller
@RequestMapping("/login/*")
public class TransferHistController {

	private static final String TRANSFER_HISTORY = "/transferHistory";

	private static final Log log = LogFactory.getLog(LoginController.class);

	public static String assetNumber = "";

	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;

	@Inject
	@Named(value = "serviceinfoService")
	private ServiceInfoService serviceinfoService;

	@Inject
	@Named(value = "loginService")
	LoginService loginService;

	@Inject
	@Named(value = "messageSource")
	MessageSource messageSource;

	@Inject
	@Named(value = "transferHistService")
	private TransferHistService transferHistService;

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
	
	@RequestMapping(value = "/transferHistory")
	public ModelAndView showManagerInbox(HttpServletRequest request,HttpSession session) {
		ModelAndView mav = new ModelAndView(TRANSFER_HISTORY, "roleForm",
				new Asset());
		mav.addObject("availableAssetDetails",
				amsServiceHistoryService.getAssets());
		if (!"".equals(assetNumber)) {
			mav.addObject("availableAssetDetails",
					amsServiceHistoryService.searchAsset(assetNumber));
			assetNumber = "";
		}
		request.setAttribute("section", "List Asset");
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			mav.addObject("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		return mav;
	}

	@RequestMapping(value = "/searchAssetInTransfer", method = RequestMethod.POST)
	public ModelAndView searchAssetInTransfer(
			@ModelAttribute("Asset") Asset asset, HttpServletRequest request,HttpSession session,
			Model model) {
		assetNumber = asset.getAssetNumber();
		if (!"".equals(assetNumber)) {
			model.addAttribute("availableAssetDetails",
					amsServiceHistoryService.searchAsset(assetNumber));
		}
		request.setAttribute("section", "List Asset");
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		return new ModelAndView(TRANSFER_HISTORY, "roleForm", new Asset());
	}

	@RequestMapping(value = "/listAssetTransferHistory")
	public ModelAndView listAssetTranHist(@ModelAttribute("Asset") Asset asset,
			HttpServletRequest request, Model model, HttpSession session)
			throws ParseException {
		request.setAttribute("section", "Transfer History");
		model.addAttribute("availableAssetDetails",
				amsServiceHistoryService.getAssets());
		/*
		 * if (!"".equals(assetNumber)) {
		 * model.addAttribute("availableAssetDetails"
		 * ,serviceinfoService.getAssetByNumber(assetNumber)); assetNumber = "";
		 * }
		 */
		int assetId = 0;
		assetId = Integer.parseInt(request.getSession()
				.getAttribute("assetTranId").toString());
		if(assetId>0)
		{
		List<AssetTransfer> assetTransfer = transferHistService
				.getAllTranHistAssets(assetId);
		model.addAttribute("tranHistAssets", assetTransfer);
		if (!assetTransfer.isEmpty()) {
			model.addAttribute(
					"capitalDate",
					AMSUtil.getSimpleDateFormat(transferHistService
							.getAllTranHistAssets(assetId).get(0)
							.getTransferAssetCode()
							.getAssetCapitalizationDate()));
		}
		}
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		request.getSession().setAttribute("assetTranId",0);
		return new ModelAndView(TRANSFER_HISTORY, "roleForm", new Asset());
	}

	@RequestMapping(value = "/setAssetIdToSession", method = RequestMethod.GET)
	public void setAssetIdToSession(@ModelAttribute("roleForm") Asset asset,
			HttpServletRequest request, HttpSession session) {
		session.setAttribute("assetTranId", asset.getAssetId());
	}
}
