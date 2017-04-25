package com.experion.ams.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.AssetGroup;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.PhysicalVerification;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.mvc.data.AssetForm;
import com.experion.ams.mvc.data.LoginForm;
import com.experion.ams.service.DashboardService;
import com.experion.ams.service.PhysicalVerificationService;
import com.experion.ams.service.SystemParameterService;
import com.experion.ams.util.AMSUtil;
import com.experion.ams.util.AssetVerificationJson;
import com.experion.ams.util.DepreciationCalculationsJson;

@Transactional
@Controller
@RequestMapping("/login/*")
public class PhysicalVerificationController {
	private static final String LOGIN_PAGE = "/login";
		private static final String ASSET_VERIFICATION = "/physicalverification";
		private static final Log log = LogFactory.getLog(PhysicalVerificationController.class);
		
		private static final String COM_MAKE = "MK";
		private static final String COM_DEPT = "DPT";
		

		private static final String COM_LOCATION = "LC";
		private static final String COM_PROJECT = "PRJ";
		
		@Inject
		@Named(value = "dashboardService")
		private DashboardService dashboardService;
		

		@Inject
		@Named(value = "messageSource")
		MessageSource messageSource;
		
		@Inject
		@Named(value = "physicalverificationservice")
		private PhysicalVerificationService physicalverificationservice;

		public PhysicalVerificationService getPhysicalverificationservice() {
			return physicalverificationservice;
		}

		public void setPhysicalverificationservice(
				PhysicalVerificationService physicalverificationservice) {
			this.physicalverificationservice = physicalverificationservice;
		}


		@RequestMapping(value = "/physVerification")
		public ModelAndView physicalVerification(@ModelAttribute("command") Asset assets,Model model,HttpServletRequest request, HttpSession session) {
			
			model.addAttribute("getverification",physicalverificationservice.getAllVerifications());
			model.addAttribute("allMakeList",
					physicalverificationservice.getAllCodeValuesByType(COM_MAKE));
		
			model.addAttribute("allDepartmentList",
					physicalverificationservice.getAllCodeValuesByType(COM_DEPT));
			

			model.addAttribute("allLocationList",
					physicalverificationservice.getAllCodeValuesByType(COM_LOCATION));
	
			model.addAttribute("allProjectList",
					physicalverificationservice.getAllCodeValuesByType(COM_PROJECT));
		
			
			model.addAttribute("allGroupDetails", physicalverificationservice.getAllGroupDetails());
			model.addAttribute("allCustodianDetails",
					physicalverificationservice.getAllCustodianDetails());

			
			long employeeCode = new AMSUtil().getEmployeeCode(session);
			if (employeeCode > 0) {
				model.addAttribute("AuthScreens",
						dashboardService.checkAuthorizedEmp(employeeCode));
			} else {
				return new ModelAndView("redirect:/login/index");
			}
			
			return new ModelAndView(ASSET_VERIFICATION);
		}
		
		
		@RequestMapping(value = "/getAssetVerification", method = RequestMethod.POST)
		public @ResponseBody String getAssetVerification(@ModelAttribute("command") PhysicalVerification physicalverification,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
			
			AssetVerificationJson assetverificationjson = physicalverificationservice.getVerifiedAssetDetail(physicalverification.getPhysicalverificationAsset().getAssetNumber());
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writeValueAsString(assetverificationjson));
			return mapper.writeValueAsString(assetverificationjson);
		}

		@RequestMapping(value = "/addAssetVerification")
		public  ModelAndView addPhysicalVerification(@ModelAttribute("command") PhysicalVerification physicalverification,Asset asset,HttpServletRequest request,Model model) throws JsonGenerationException, JsonMappingException, IOException {
			    
		Employee employee=new Employee();
		employee.setEmpId(Long.parseLong(request.getSession().getAttribute("empCode").toString()));
		physicalverificationservice.addPhysicalVerification(physicalverification,employee );
			 return new ModelAndView("redirect:physVerification");
		}
		
		
		// searching based on the asset details
//		@RequestMapping(value = "/searchResultForAssetVerification")
//		public ModelAndView searchEmployeeForAdd(
//				@ModelAttribute("command") AssetForm phyveri,
//				BindingResult result, Model model, HttpServletRequest request) {
//			log.info("searching the role details...........");
//			String assetNumber = phyveri.getAssetNumber();
//			System.out.println("sasiyaeeeeeeeeeeeeeee "+assetNumber);
//			AssetGroup groupCode = phyveri.getAssetGroupCode();
//			SystemParametersCodeMaster deptCode = phyveri.getAssetDeptCode();
//			SystemParametersCodeMaster locationCode = phyveri
//					.getAssetLocationCode();
//			SystemParametersCodeMaster projectCode = phyveri
//					.getAssetProjectCode();
//			Employee CustodianId = phyveri.getAssetCustodianCode();
//
//			// checking currently at value is In-Project or not, currently
//			// for In-Project comId=25..
//
////			List<SystemParametersCodeMaster> inProjectId = physicalverificationservice
////					.getProjectIdByName(COM_PROJECT);
////
////			request.setAttribute("inProjectId", inProjectId.get(0).getComId());
//
//			if (StringUtils.EMPTY.equals(assetNumber)
//					&& groupCode.getGroupId().equals(0)
//					&& deptCode.getComId().equals(0)
//					&& locationCode.getComId().equals(0)
//					&& projectCode.getComId().equals(0)
//					&& CustodianId.getEmpId() == 0) {
//
//				System.out.println("if");
//				model.addAttribute("getverification",physicalverificationservice.getAllVerifications());
//
//			} else {
//				System.out.println("else");
//				List<PhysicalVerification> assetsVeri = physicalverificationservice
//						.getSearchResults(assetNumber, CustodianId, groupCode,
//								deptCode, locationCode, projectCode);
//                
//				
//				System.out.println("getAssetzzzz.... "+assetsVeri.size());
//				model.addAttribute("getverification", physicalverificationservice
//						.getSearchResults(assetNumber, CustodianId, groupCode,
//								deptCode, locationCode, projectCode));
//				
//				
//				
//
//				
//			}
//			model.addAttribute("allMakeList",
//					physicalverificationservice.getAllCodeValuesByType(COM_MAKE));
//			model.addAttribute("allDepartmentList",
//					physicalverificationservice.getAllCodeValuesByType(COM_DEPT));
//			
//			model.addAttribute("allLocationList",
//					physicalverificationservice.getAllCodeValuesByType(COM_LOCATION));
//			model.addAttribute("allProjectList",
//					physicalverificationservice.getAllCodeValuesByType(COM_PROJECT));
//			model.addAttribute("allGroupDetails", physicalverificationservice.getAllGroupDetails());
//			model.addAttribute("allCustodianDetails",
//					physicalverificationservice.getAllCustodianDetails());
//
//			request.setAttribute("section", "Asset List");
//			try {
//				long EmployeeCode = Long.parseLong(request.getSession()
//						.getAttribute("empCode").toString());
//				model.addAttribute("AuthScreens", getAuthScreens(EmployeeCode));
//			} catch (Exception e) {
//				log.info("seesion expired.....login again....");
//				return new ModelAndView(LOGIN_PAGE, "", new LoginForm());
//			}
//
//			return new ModelAndView(ASSET_VERIFICATION);
//
//			
//		}
		
		
		// searching based on the asset details
		@RequestMapping(value = "/searchResultForAssetVerification")
		public ModelAndView searchEmployeeForAdd(
				@ModelAttribute("command") Asset physicalverAsset,
				BindingResult result, Model model, HttpServletRequest request, HttpSession session) {
			System.out.println();
			
			model.addAttribute("getverification",physicalverificationservice.getSearchResultsAssetnumber(physicalverAsset.getAssetNumber()));
			
			long employeeCode = new AMSUtil().getEmployeeCode(session);
			if (employeeCode > 0) {
				model.addAttribute("AuthScreens",
						dashboardService.checkAuthorizedEmp(employeeCode));
			} else {
				return new ModelAndView("redirect:/login/index");
			}
			
			   return new ModelAndView(ASSET_VERIFICATION);
			
		}
		

		
		

}
