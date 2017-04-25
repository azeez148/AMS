package com.experion.ams.mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.Employee;
import com.experion.ams.mvc.data.ReplicationForm;
import com.experion.ams.service.DashboardService;
import com.experion.ams.service.ReplicationService;
import com.experion.ams.util.AMSUtil;
import com.google.gson.Gson;

@Controller
@RequestMapping("/login/*")
public class ReplicationController {
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;
	
	@Inject
	@Named(value = "replicationService")
	private ReplicationService replicationService;
	private static final String REPLICATION_PAGE = "/replicationpage";
	private String message="";

	public ReplicationService getReplicationService() {
		return replicationService;
	}

	public void setReplicationService(ReplicationService replicationService) {
		this.replicationService = replicationService;
	}

	/**
	 * Controller to load REPLICATION_PAGE on get request. This controller is
	 * invoked first in the Replication module.
	 * 
	 * @param replicationForm
	 * @return
	 */
	
	@RequestMapping("/amsReplication")
	public ModelAndView getAllAssetDetails(HttpServletRequest request, HttpSession session,
			@ModelAttribute("replicationForm") ReplicationForm replicationForm,Model model) {
		String statusMessage ="";
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		if(this.message.equals("")){
		return new ModelAndView(REPLICATION_PAGE);
		}else{
			statusMessage= this.message;
			this.message="";
			if("Asset replicated successfully".trim().equals(statusMessage)){
				return new ModelAndView(REPLICATION_PAGE,"successMessage",statusMessage);	
			}else{
			return new ModelAndView(REPLICATION_PAGE,"failureMessage",statusMessage);
			}
		}
		

	}

	/**
	 * Controller invoked on the Ajax call of the popup. To fetch all the asset
	 * number.
	 * 
	 * @param replicationForm
	 * @return json Returns a jSON of all the asset number.
	 */
	
	@RequestMapping("/AMS_FetchData")
	public @ResponseBody String fetchData(
			@ModelAttribute("replicationForm") ReplicationForm replicationForm) {
		Gson gson = new Gson();
		List<Asset> assetNumber = replicationService.getAllAssetDetails();
		//String json = gson.toJson(assetNumber);
		String json = "";
		try {
			json = objectMapper.writeValueAsString(assetNumber);
		} catch (Exception e) {
			System.out.println(e);
		} 
		return json;

	}

	/**
	 * Controller invoked on the submit of the form to save asset replication
	 * details.
	 * 
	 * @param replicationForm
	 * @param result
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/AMS_Replication")
	public ModelAndView saveAssetReplication(
			@Valid @ModelAttribute("replicationForm") ReplicationForm replicationForm,
			BindingResult result, HttpServletRequest request,HttpSession session,Model model) {
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		
		if (result.hasErrors()) {
			return new ModelAndView(REPLICATION_PAGE);
		} else if(!replicationForm.getAssetRepeat().matches("\\d+")){
			return new ModelAndView(REPLICATION_PAGE,"message","Not valid a number");
		}else {
			Integer numerOfReplication = Integer.parseInt(replicationForm
					.getAssetRepeat());
			String assetNumber = replicationForm.getAssetNumber();
			try{
			replicationService.saveAssetReplication(assetNumber,
					numerOfReplication);
			model.addAttribute("successMsg", "<span style='color:green'>Asset replicated successfully</span>");
			//setMessage("Asset replicated successfully");
			}catch(Exception e){
				model.addAttribute("successMsg", "<span style='color:red'>Replication Failed</span>");
				//setMessage("Replication Failed.");
			}
			
			return new ModelAndView(REPLICATION_PAGE);
		}
	}

	/**
	 * This controller is invoke as an Ajax call on change in the select box.
	 * Controller will return the details of the selected asset number.
	 * 
	 * @param replicationForm
	 * @param request
	 * @param response
	 * @return json Returns a jSON with all the details of asset.
	 */
	@RequestMapping(value = "/SelectReplicationAsset",method = RequestMethod.GET)
	public @ResponseBody String getSelectedAssetDetaillsMain(
			@ModelAttribute("command") ReplicationForm replicationForm,
			HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		response.setContentType("application/json");
		Gson gson = new Gson();
		String assetNumber = request.getParameter("assetNumber");
		ReplicationForm repli = prepareModel(replicationService
				.getSelectedAssetDetaills(assetNumber));
		repli = startNoConvertion(repli);
		//Asset repli = replicationService.getSelectedAssetDetaills(assetNumber);
		
		//String json = gson.toJson(repli);
		String json = "";
		try {
			json = objectMapper.writeValueAsString(repli);
		} catch (Exception e) {
			System.out.println(e);
		} 
		return json;
		

	}

	/**
	 * Function to adjust Start number.
	 * 
	 * @param repli
	 * @return
	 */
	private ReplicationForm startNoConvertion(ReplicationForm repli) {
		String[] startNo = repli.getAssetNumber().split("-");
		repli.setStartNo(Integer.parseInt(startNo[1]) + 1);
		return repli;
	}

	/**
	 * Controller is invoked on the Ajax call of popup submission. The details
	 * of the selected asset will be populated to the main form.
	 * 
	 * @param replicationForm
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/AMS_ReplicationOK")
	public @ResponseBody String getAssetDetailsToSave(
			@ModelAttribute("command") ReplicationForm replicationForm,
			HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("application/json");
		Gson gson = new Gson();
		String assetNumber = request.getParameter("assetNumber");
		ReplicationForm repli = prepareModel(replicationService
				.getAssetDetailsToSave(assetNumber));
		repli = startNoConvertion(repli);
		//String json = gson.toJson(repli);
		String json = "";
		try {
			json = objectMapper.writeValueAsString(repli);
		} catch (Exception e) {
			System.out.println(e);
		} 
		return json;

	}

	/**
	 * Function to prepare a model class with Asset details.
	 * 
	 * @param asset
	 * @return
	 */
	private ReplicationForm prepareModel(Asset asset) {
		ReplicationForm assetBeans = new ReplicationForm();
		assetBeans.setAssetID(asset.getAssetId());
		assetBeans.setAssetNumber(asset.getAssetNumber());
		assetBeans.setAssetMake(asset.getAssetMake());
		assetBeans.setAssetModel(asset.getAssetModel());
		assetBeans.setAssetModelNumber(asset.getAssetModelNumber());
		assetBeans.setAssetSerialNumber(asset.getAssetSerialNumber());
		assetBeans.setAssetDescription(asset.getAssetDescription());
		assetBeans.setAssetNotes(asset.getAssetNotes());
		assetBeans.setAssetGroupCode(asset.getAssetGroupCode());
		assetBeans.setAssetType(asset.getAssetType());
		assetBeans.setAssetCondition(asset.getAssetCondition());
		assetBeans.setAssetCurrentlyAt(asset.getAssetCurrentlyAt());
		assetBeans.setAssetLocationCode(asset.getAssetLocationCode());
		assetBeans.setAssetDeptCode(asset.getAssetDeptCode());
		assetBeans.setAssetProjectCode(asset.getAssetProjectCode());
		assetBeans.setAssetCustodianCode(asset.getAssetCustodianCode());
		assetBeans.setAssetPurchaseReqName(asset.getAssetPurchaseReqName());
		assetBeans.setAssetPurchaseReqNumber(asset.getAssetPurchaseReqNumber());
		assetBeans.setAssetPurchaseReqDate(asset.getAssetPurchaseReqDate());
		assetBeans.setAssetCapitalizationDate(asset
				.getAssetCapitalizationDate());
		assetBeans.setAssetCreatedBy(asset.getAssetCreatedBy());
		assetBeans.setAssetCreatedDate(asset.getAssetCreatedDate());
		assetBeans.setAssetUpdatedBy(asset.getAssetUpdatedBy());
		assetBeans.setAssetUpdatedDate(asset.getAssetUpdatedDate());
		assetBeans.setAssetStatus(asset.getAssetStatus());

		return assetBeans;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
