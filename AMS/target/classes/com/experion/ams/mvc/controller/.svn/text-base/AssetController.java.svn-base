/**
 * 
 */
package com.experion.ams.mvc.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetGroup;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.ServiceInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.mvc.data.AssetForm;
import com.experion.ams.mvc.data.LoginForm;
import com.experion.ams.mvc.vo.AssetFormVO;
import com.experion.ams.service.AssetService;
import com.experion.ams.service.DashboardService;

/**
 * @author Abdul Azeez 28-07-2015
 *
 */

@Controller
@RequestMapping("/login/*")
public class AssetController {
	private static final String LOGIN_PAGE = "/login";

	private static final String ASSET_PAGE = "/asset";
	private static final String STATUS_ACTIVE = "Active";
	private static final String COM_MAKE = "MK";
	private static final String COM_DEPT = "DPT";
	private static final String COM_TYPE = "AST";
	private static final String COM_CONDITION = "CND";
	private static final String COM_CURRENTLYAT = "CAT";
	private static final String COM_LOCATION = "LC";
	private static final String COM_PROJECT = "PRJ";

	// private static final String STATUS_INACTIVE = "InActive";
	// private static String roleName = "";
	private static long roleId;

	private static final Log log = LogFactory.getLog(AssetController.class);

	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;

	@Inject
	@Named(value = "messageSource")
	MessageSource messageSource;

	@Inject
	@Named("assetService")
	public AssetService assetService;

	public List<Employee> getAuthScreens(long employeeCode) {
		List<Employee> authScreens = dashboardService
				.checkAuthorizedEmp(employeeCode);
		return authScreens;
	}

	// get asset page
	@RequestMapping(value = "/asset")
	public ModelAndView showRolePage(HttpServletRequest request,
			@ModelAttribute(value = "assetForm") AssetForm assetForm,
			Model model) {
		log.info("asset page laoding...");

		// checking currently at value is In-Project or not, currently
		// for In-Project comId=25..

		List<SystemParametersCodeMaster> inProjectId = assetService
				.getProjectIdByName(COM_PROJECT);

		request.setAttribute("inProjectId", inProjectId.get(0).getComId());

		List<Asset> assets = assetService.getAllAssetDetails();
		//System.out.println(assets);
		model.addAttribute("availableAssetDetails",
				assetService.getAllAssetDetails());
		model.addAttribute("allMakeList",
				assetService.getAllCodeValuesByType(COM_MAKE));
		model.addAttribute("allDepartmentList",
				assetService.getAllCodeValuesByType(COM_DEPT));
		model.addAttribute("allAssetTypeList",
				assetService.getAllCodeValuesByType(COM_TYPE));
		model.addAttribute("allConditionList",
				assetService.getAllCodeValuesByType(COM_CONDITION));
		model.addAttribute("allCurrentlyAtList",
				assetService.getAllCodeValuesByType(COM_CURRENTLYAT));
		model.addAttribute("allLocationList",
				assetService.getAllCodeValuesByType(COM_LOCATION));
		model.addAttribute("allProjectList",
				assetService.getAllCodeValuesByType(COM_PROJECT));
		model.addAttribute("allGroupDetails", assetService.getAllGroupDetails());
		model.addAttribute("allCustodianDetails",
				assetService.getAllCustodianDetails());

		request.setAttribute("section", "Asset List");
		try {
			long EmployeeCode = Long.parseLong(request.getSession()
					.getAttribute("empCode").toString());
			model.addAttribute("AuthScreens", getAuthScreens(EmployeeCode));
		} catch (Exception e) {
			log.info("seesion expired.....login again....");
			return new ModelAndView(LOGIN_PAGE, "", new LoginForm());
		}
		return new ModelAndView(ASSET_PAGE, "", new AssetForm());
	}

	// save asset details
	@SuppressWarnings("unused")
	@RequestMapping(value = "/saveAsset")
	public ModelAndView saveAsset(
			@ModelAttribute(value = "assetForm") @Valid AssetForm assetForm,
			BindingResult result, Model model, HttpServletRequest request,
			@RequestParam("file") MultipartFile file) {

		log.info("saving asset details...........");

		// AssetValidator assetValidator = new AssetValidator();
		// assetValidator.validate(assetForm, result);

		request.setAttribute("section", "Manage Asset");
		try{
		long EmployeeCode = Long.parseLong(request.getSession()
				.getAttribute("empCode").toString());
		model.addAttribute("AuthScreens", getAuthScreens(EmployeeCode));

		long empId = assetService.getEmpIdByCode(EmployeeCode);
		
		
		// checking currently at value is In-Project or not, currently
		// for In-Project comId=25..

		List<SystemParametersCodeMaster> inProjectId = assetService
				.getProjectIdByName(COM_PROJECT);

		request.setAttribute("inProjectId", inProjectId.get(0).getComId());
		String imageName = file.getOriginalFilename();

		// image upload... to server/attachments folder...
		if (!file.isEmpty()) {
			try {
				String fileName = file.getOriginalFilename();
				System.out.println(fileName);
				byte[] bytes = file.getBytes();

				// Creating the directory to store file

				String rootPath = System.getProperty("catalina.home");
				// System.out.println(rootPath);
				File dir = new File(rootPath + File.separator + "attachments");
				// System.out.println(dir);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + fileName);
				// System.out.println(serverFile);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				log.info("Server File Location=" + serverFile.getAbsolutePath());

				log.info("You successfully uploaded file=" + fileName);
			} catch (Exception e) {
				log.error("You failed to upload " + e.getMessage());
			}
		} else {
			log.error("empty file ");

		}

		//

		// date convert from string to util.Date
		if (!assetForm.getAssetPurchaseReqDate().equals("")
				&& !assetForm.getAssetWarrantyEndDate().equals("")) {
			String strRequestDate = assetForm.getAssetPurchaseReqDate();
			String strwarrantyEndDate = assetForm.getAssetWarrantyEndDate();
			java.util.Date purchaseRequestDate = dateFormatter(strRequestDate);
			java.util.Date warrantyEndDate = dateFormatter(strwarrantyEndDate);

			if (!result.hasErrors()) {
				AssetFormVO assetFormVO = new AssetFormVO();
				if (!imageName.equals(null)) {
					assetFormVO.setFilename(imageName);
				} else {
					assetFormVO.setFilename(null);

				}
				assetFormVO.setAssetNumber(assetForm.getAssetNumber());
				assetFormVO
						.setAssetDescription(assetForm.getAssetDescription());
				assetFormVO.setAssociatedAssetId(assetForm
						.getAssociatedAssetId());
				assetFormVO.setAssetModel(assetForm.getAssetModel());
				assetFormVO
						.setAssetModelNumber(assetForm.getAssetModelNumber());
				assetFormVO.setAssetNotes(assetForm.getAssetNotes());

				if (assetForm.getAssetStatus().equals(STATUS_ACTIVE)) {
					assetFormVO.setAssetStatus("yes");
				} else {
					assetFormVO.setAssetStatus("no");
				}

				assetFormVO.setAssetPurchaseReqName(assetForm
						.getAssetPurchaseReqName());
				assetFormVO.setAssetPurchaseReqNumber(assetForm
						.getAssetPurchaseReqNumber());
				assetFormVO.setAssetSerialNumber(assetForm
						.getAssetSerialNumber());
				assetFormVO.setAssetStatus(assetForm.getAssetStatus());
				assetFormVO.setAssetWarrantyPeriod(assetForm
						.getAssetWarrantyPeriod());

				assetFormVO.setAssetPurchaseReqDate(purchaseRequestDate);
				assetFormVO.setAssetWarrantyEndDate(warrantyEndDate);

				assetFormVO.setAssetGroupCode(assetForm.getAssetGroupCode());
				assetFormVO.setAssetCondition(assetForm.getAssetCondition());
				assetFormVO
						.setAssetCurrentlyAt(assetForm.getAssetCurrentlyAt());

				// checking currently at value is In-Project or not, currently
				// for In-Project comId=26..

				if (!(assetForm.getAssetCurrentlyAt().getComId() == inProjectId
						.get(0).getComId())) {
					assetFormVO.setAssetCustodianCode(null);
					assetFormVO.setAssetDeptCode(null);
					assetFormVO.setAssetProjectCode(null);
					assetFormVO.setAssetLocationCode(null);

				}

				else {
					log.info("else");
log.info("user....."+empId);
					log.info("emp...."+assetForm
							.getAssetCustodianCode().getEmpId());
					log.info("dept......"+assetForm.getAssetDeptCode().getComId());
					
				

					assetFormVO.setAssetCustId(assetForm
							.getAssetCustodianCode().getEmpId());
					assetFormVO.setAssetDeptCodeInt(assetForm.getAssetDeptCode().getComId());
					assetFormVO.setAssetLocCode(assetForm
							.getAssetLocationCode().getComId());
					assetFormVO.setAssetProjectCodeInt(assetForm
							.getAssetProjectCode().getComId());
				}

				assetFormVO.setAssetMake(assetForm.getAssetMake());

				assetFormVO.setAssetType(assetForm.getAssetType());

				assetFormVO.setAssetCreatedBy(empId);
				assetFormVO.setAssetCreatedDate(new java.util.Date());
				assetFormVO.setAssetUpdatedBy(empId);
				assetFormVO.setAssetUpdatedDate(new java.util.Date());


				boolean added = assetService.addAsset(assetFormVO);
			
				// assetService.addAsset(assetFormVO);

					
					
					model.addAttribute("succes","New Role Added");


				List<Asset> assets = assetService.getAllAssetDetails();
				model.addAttribute("availableAssetDetails",
						assetService.getAllAssetDetails());
				model.addAttribute("allMakeList",
						assetService.getAllCodeValuesByType(COM_MAKE));
				model.addAttribute("allDepartmentList",
						assetService.getAllCodeValuesByType(COM_DEPT));
				model.addAttribute("allAssetTypeList",
						assetService.getAllCodeValuesByType(COM_TYPE));
				model.addAttribute("allConditionList",
						assetService.getAllCodeValuesByType(COM_CONDITION));
				model.addAttribute("allCurrentlyAtList",
						assetService.getAllCodeValuesByType(COM_CURRENTLYAT));
				model.addAttribute("allLocationList",
						assetService.getAllCodeValuesByType(COM_LOCATION));
				model.addAttribute("allProjectList",
						assetService.getAllCodeValuesByType(COM_PROJECT));
				model.addAttribute("allGroupDetails",
						assetService.getAllGroupDetails());
				model.addAttribute("allCustodianDetails",
						assetService.getAllCustodianDetails());

				
				if (!added) {
					log.error("not added error " + result);
					model.addAttribute("error",
							"Ooops... Something Happend Please Try Again");

					return new ModelAndView(ASSET_PAGE, "assetForm",
							new AssetForm());
				}
				

				/*
				 * else{ System.out.println("else.............."); boolean
				 * addAssetTransfer =
				 * assetService.addAssetTransfer(assetFormVO);
				 * 
				 * }
				 */
				model.addAttribute("succes", "New Asset Added");

			} 
			else {
				log.info(result);
				log.error("error in binding result");
				model.addAttribute("error", "All Feilds are Mandatory");
				return new ModelAndView(ASSET_PAGE, "assetForm",
						new AssetForm());
			}
		} else {
			model.addAttribute("error", "All Feilds are Mandatory");

			log.error("date is null");
		}

		// model.addAttribute("error", "All Feilds are Mandatory");
		}catch(Exception Ne){
			log.error(Ne);
			log.info("seesion expired.....login again....");

			Ne.printStackTrace();
			return new ModelAndView(LOGIN_PAGE, "LoginForm", new LoginForm());
		}
		return new ModelAndView(ASSET_PAGE, "assetForm", new AssetForm());
	}

	// get all role details to edit page.
	@RequestMapping(value = "/setAssetId", method = RequestMethod.GET)
	public @ResponseBody String showEditTabDetails(
			@ModelAttribute("assetForm") AssetForm assetForm,
			BindingResult result, Model model, HttpServletRequest request,
			HttpSession httpSession) {
		log.info("geting response to ajax call for edit role details....");

		System.out.println(assetForm.getAssetID());
		httpSession.setAttribute("assetId", assetForm.getAssetID());

		request.setAttribute("section", "Manage Asset");
		String returnText = "";
		if (!(assetForm.getAssetID().equals("null"))) {
			String b = "true";
			if (b.equals("true")) {
				returnText = "true";
			} else {
				returnText = "false";
			}
		}
		return returnText;
	}

	// get all role details to edit page.
	@RequestMapping(value = "/editAssetDetails")
	public ModelAndView editRoleDetails(
			@ModelAttribute(value = "assetForm") AssetForm assetForm,
			BindingResult result, Model model, HttpServletRequest request,
			HttpSession httpSession) {
		request.setAttribute("section", "Manage Asset");
		log.info("INSIDE edit ASSET details....");

		try {
			long EmployeeCode = Long.parseLong(request.getSession()
					.getAttribute("empCode").toString());
			model.addAttribute("AuthScreens", getAuthScreens(EmployeeCode));
		} catch (NullPointerException Ne) {
			log.error(Ne);
			log.info("seesion expired.....login again....");
			return new ModelAndView(LOGIN_PAGE, "LoginForm", new LoginForm());

		}
		// checking currently at value is In-Project or not, currently
		// for In-Project comId=25..

		List<SystemParametersCodeMaster> inProjectId = assetService
				.getProjectIdByName(COM_PROJECT);

		request.setAttribute("inProjectId", inProjectId.get(0).getComId());
		Integer assetId = Integer.parseInt(request.getSession()
				.getAttribute("assetId").toString());
		/*
		 * System.out.println(assetId); List<Asset>
		 * list=assetService.getAssetsList(assetId); System.out.println(list);
		 */
		if (!(assetId == 0)) {
			Asset assets = assetService.getAssetsById(assetId);
		log.info(assets.getAssetCurrentlyAt().getComId());
			if (assets.getAssetCurrentlyAt().getComId() == inProjectId.get(0)
					.getComId()) {
				model.addAttribute("flag", "true");
			} else {
				model.addAttribute("flag", "false");

			}

			if (!assets.equals(null)) {
				model.addAttribute("assetList", assets);
			} else {
				log.error("null list returned");
			}

		} else {
			log.error("error in asset id....." + assetId);

			model.addAttribute("availableAssetDetails",
					assetService.getAllAssetDetails());
			model.addAttribute("allMakeList",
					assetService.getAllCodeValuesByType(COM_MAKE));
			model.addAttribute("allDepartmentList",
					assetService.getAllCodeValuesByType(COM_DEPT));
			model.addAttribute("allAssetTypeList",
					assetService.getAllCodeValuesByType(COM_TYPE));
			model.addAttribute("allConditionList",
					assetService.getAllCodeValuesByType(COM_CONDITION));
			model.addAttribute("allCurrentlyAtList",
					assetService.getAllCodeValuesByType(COM_CURRENTLYAT));
			model.addAttribute("allLocationList",
					assetService.getAllCodeValuesByType(COM_LOCATION));
			model.addAttribute("allProjectList",
					assetService.getAllCodeValuesByType(COM_PROJECT));
			model.addAttribute("allGroupDetails", assetService.getAllGroupDetails());
			model.addAttribute("allCustodianDetails",
					assetService.getAllCustodianDetails());
			try {
			long EmployeeCode = Long.parseLong(request.getSession()
						.getAttribute("empCode").toString());
				model.addAttribute("AuthScreens", getAuthScreens(EmployeeCode));
			} catch (Exception e) {
				log.info("seesion expired.....login again....");
				return new ModelAndView(LOGIN_PAGE, "", new LoginForm());
			}
			return new ModelAndView(ASSET_PAGE, "assetForm", new AssetForm());

		}

		model.addAttribute("availableAssetDetails",
				assetService.getAllAssetDetails());
		model.addAttribute("allMakeList",
				assetService.getAllCodeValuesByType(COM_MAKE));
		model.addAttribute("allDepartmentList",
				assetService.getAllCodeValuesByType(COM_DEPT));
		model.addAttribute("allAssetTypeList",
				assetService.getAllCodeValuesByType(COM_TYPE));
		model.addAttribute("allConditionList",
				assetService.getAllCodeValuesByType(COM_CONDITION));
		model.addAttribute("allCurrentlyAtList",
				assetService.getAllCodeValuesByType(COM_CURRENTLYAT));
		model.addAttribute("allLocationList",
				assetService.getAllCodeValuesByType(COM_LOCATION));
		model.addAttribute("allProjectList",
				assetService.getAllCodeValuesByType(COM_PROJECT));
		model.addAttribute("allGroupDetails", assetService.getAllGroupDetails());
		model.addAttribute("allCustodianDetails",
				assetService.getAllCustodianDetails());
		return new ModelAndView(ASSET_PAGE, "assetForm", new AssetForm());
	}

	// updating asset details
	@RequestMapping(value = "/editAsset")
	public ModelAndView editAsset(
			@ModelAttribute(value = "assetForm") @Valid AssetForm assetForm,
			BindingResult result, Model model, HttpServletRequest request,
			@RequestParam("file") MultipartFile file) {


		log.info("saving the edited asset details...........");
			request.setAttribute("section", "Manage Asset");
			

		log.info(assetForm);

		request.setAttribute("section", "Manage Asset");
try{
		long EmployeeCode = Long.parseLong(request.getSession()
				.getAttribute("empCode").toString());
		model.addAttribute("AuthScreens", getAuthScreens(EmployeeCode));

		long empId = assetService.getEmpIdByCode(EmployeeCode);

		int assetId = Integer.parseInt(request.getSession()
				.getAttribute("assetId").toString());

		
		
		//Asset assetsFFF = assetService.getAssetsById(assetId);
		//ServiceInfo serviceInfo=assetService.getServiceInfoByAsset(assetId);
		
//log.info("SERVICE..."+serviceInfo);		
		
		String imageName = file.getOriginalFilename();
		// image upload... to server/attachments folder...
		if (!file.isEmpty()) {
			try {
				String fileName = file.getOriginalFilename();
				// System.out.println(fileName);
				byte[] bytes = file.getBytes();

				// Creating the directory to store file

				String rootPath = System.getProperty("catalina.home");
				// System.out.println(rootPath);
				File dir = new File(rootPath + File.separator + "attachments");
				// System.out.println(dir);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + fileName);
				// System.out.println(serverFile);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				log.info("Server File Location=" + serverFile.getAbsolutePath());

				log.info("You successfully uploaded file=" + fileName);
			} catch (Exception e) {
				log.error("You failed to upload " + e.getMessage());
			}
		} else {
			log.error("empty file ");

		}

		// date convert from string to util.Date
		if (!assetForm.getAssetPurchaseReqDate().equals("null")
				&& !assetForm.getAssetWarrantyEndDate().equals("null")) {
			String strRequestDate = assetForm.getAssetPurchaseReqDate();
			String strwarrantyEndDate = assetForm.getAssetWarrantyEndDate();
			java.util.Date purchaseRequestDate = dateFormatter(strRequestDate);
			java.util.Date warrantyEndDate = dateFormatter(strwarrantyEndDate);

			if (!result.hasErrors()) {
				AssetFormVO assetFormVO = new AssetFormVO();

				if (!imageName.equals(null)) {
					assetFormVO.setFilename(imageName);
				} else {
					assetFormVO.setFilename(null);

				}

				assetFormVO.setAssetID(assetId);
				assetFormVO.setAssetNumber(assetForm.getAssetNumber());
				assetFormVO
						.setAssetDescription(assetForm.getAssetDescription());
				assetFormVO.setAssociatedAssetId(assetForm
						.getAssociatedAssetId());
				assetFormVO.setAssetModel(assetForm.getAssetModel());
				assetFormVO
						.setAssetModelNumber(assetForm.getAssetModelNumber());
				assetFormVO.setAssetNotes(assetForm.getAssetNotes());

				if (assetForm.getAssetStatus().equals(STATUS_ACTIVE)) {
					assetFormVO.setAssetStatus("yes");
				} else {
					assetFormVO.setAssetStatus("no");
				}

				assetFormVO.setAssetPurchaseReqName(assetForm
						.getAssetPurchaseReqName());
				assetFormVO.setAssetPurchaseReqNumber(assetForm
						.getAssetPurchaseReqNumber());
				assetFormVO.setAssetSerialNumber(assetForm
						.getAssetSerialNumber());
				assetFormVO.setAssetStatus(assetForm.getAssetStatus());
				assetFormVO.setAssetWarrantyPeriod(assetForm
						.getAssetWarrantyPeriod());

				assetFormVO.setAssetPurchaseReqDate(purchaseRequestDate);
				assetFormVO.setAssetWarrantyEndDate(warrantyEndDate);

				assetFormVO.setAssetGroupCode(assetForm.getAssetGroupCode());
				assetFormVO.setAssetCondition(assetForm.getAssetCondition());
				assetFormVO
						.setAssetCurrentlyAt(assetForm.getAssetCurrentlyAt());

				// checking currently at value is In-Project or not, currently
				// for In-Project comId=25..

				List<SystemParametersCodeMaster> inProjectId = assetService
						.getProjectIdByName(COM_PROJECT);

				request.setAttribute("inProjectId", inProjectId.get(0)
						.getComId());

				if (!(assetForm.getAssetCurrentlyAt().getComId() == inProjectId
						.get(0).getComId())) {
					assetFormVO.setAssetCustId(null);
					assetFormVO.setAssetDeptCodeInt(null);
					assetFormVO.setAssetProjectCode(null);
					assetFormVO.setAssetLocCode(null);

				}

				else {
					//Asset assets = assetService.getAssetsById(assetId);
					
					
					log.info("assetform"+assetForm);
					
					log.info(assetForm.getAssetLocationCode());
					
					/*
					 * Asset assets = assetService.getAssetsById(assetId);
					 * 
					 * log.info("empid......"+assetForm.getAssetCustodianCode());
					 * assetFormVO
					 * .setAssetCustodianCode(assets.getAssetCustodianCode());
					 * 
					 * 
					 * assetFormVO.setAssetDeptCode(assets.getAssetDeptCode());
					 * assetFormVO.setAssetLocationCode(assets
					 * .getAssetLocationCode());
					 * assetFormVO.setAssetProjectCode(assets
					 * .getAssetProjectCode());
					 */

					assetFormVO.setAssetCustId(assetForm
							.getAssetCustodianCode().getEmpId());
					assetFormVO.setAssetDeptCodeInt(assetForm
							.getAssetDeptCode().getComId());
					assetFormVO.setAssetLocCode(assetForm
							.getAssetLocationCode().getComId());
					assetFormVO.setAssetProjectCodeInt(assetForm
							.getAssetProjectCode().getComId());

				}

				assetFormVO.setAssetMake(assetForm.getAssetMake());
				assetFormVO.setAssetType(assetForm.getAssetType());

				assetFormVO.setAssetCreatedBy(empId);
				assetFormVO.setAssetCreatedDate(new java.util.Date());
				assetFormVO.setAssetUpdatedBy(empId);
				assetFormVO.setAssetUpdatedDate(new java.util.Date());
				log.info("id" + empId);
				// System.out.println(assetFormVO);
				log.info(assetFormVO);
				boolean edited = assetService.editAsset(assetFormVO);
				// assetService.addAsset(assetFormVO);

				List<Asset> assets = assetService.getAllAssetDetails();
				/*
				 * System.out.println(assets);
				 */
				model.addAttribute("availableAssetDetails",
						assetService.getAllAssetDetails());
				model.addAttribute("allMakeList",
						assetService.getAllCodeValuesByType(COM_MAKE));
				model.addAttribute("allDepartmentList",
						assetService.getAllCodeValuesByType(COM_DEPT));
				model.addAttribute("allAssetTypeList",
						assetService.getAllCodeValuesByType(COM_TYPE));
				model.addAttribute("allConditionList",
						assetService.getAllCodeValuesByType(COM_CONDITION));
				model.addAttribute("allCurrentlyAtList",
						assetService.getAllCodeValuesByType(COM_CURRENTLYAT));
				model.addAttribute("allLocationList",
						assetService.getAllCodeValuesByType(COM_LOCATION));
				model.addAttribute("allProjectList",
						assetService.getAllCodeValuesByType(COM_PROJECT));
				model.addAttribute("allGroupDetails",
						assetService.getAllGroupDetails());
				model.addAttribute("allCustodianDetails",
						assetService.getAllCustodianDetails());

				if (!edited) {
					log.error("not updated ");
					return new ModelAndView(ASSET_PAGE, "assetForm",
							new AssetForm());
				}
				model.addAttribute("succes", "Asset Updated...");

			} else {
				log.error("error in binding result" + result);
				model.addAttribute("error", "All Feilds Are Mandatory");

				return new ModelAndView(ASSET_PAGE, "assetForm",
						new AssetForm());
			}
		} else {
			log.error("date is null");
		}

		/*
		 * model.addAttribute("nameerror", "name could not be null");
		 */
		request.setAttribute("section", "List Asset");
}catch(Exception Ne){
	Ne.printStackTrace();
	log.error(Ne);
	log.info("seesion expired.....login again....");
	return new ModelAndView(LOGIN_PAGE, "", new LoginForm());
}
		
		return new ModelAndView(ASSET_PAGE, "assetForm", new AssetForm());
	}

	// function for date format(string to Util.date)
	private java.util.Date dateFormatter(String strdate) {
		{
			// (1) create a SimpleDateFormat object with the desired format.
			// this is the format/pattern we're expecting to receive.
			String expectedPattern = "yyyy-MM-dd";
			SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
			try {
				// (2) give the formatter a String that matches the
				// SimpleDateFormat pattern
				String userInput = strdate;
				java.util.Date date = formatter.parse(userInput);

				// (3) prints out "Tue Sep 22 00:00:00 EDT 2009"
				// System.out.println(date);

				return date;
			} catch (ParseException e) {
				log.error("error in parsing", e);
				// execution will come here if the String that is given
				// does not match the expected format.
				// e.printStackTrace();
				return null;
			}
		}
	}

	// searching based on the asset details
	@RequestMapping(value = "/searchResultForAsset")
	public ModelAndView searchEmployeeForAdd(
			@ModelAttribute(value = "assetForm") AssetForm assetForm,
			BindingResult result, Model model, HttpServletRequest request) {
		log.info("searching the role details...........");
		String assetNumber = assetForm.getAssetNumber();
		AssetGroup groupCode = assetForm.getAssetGroupCode();
		SystemParametersCodeMaster deptCode = assetForm.getAssetDeptCode();
		SystemParametersCodeMaster locationCode = assetForm
				.getAssetLocationCode();
		SystemParametersCodeMaster projectCode = assetForm
				.getAssetProjectCode();
		Employee CustodianId = assetForm.getAssetCustodianCode();

		// checking currently at value is In-Project or not, currently
		// for In-Project comId=25..

		List<SystemParametersCodeMaster> inProjectId = assetService
				.getProjectIdByName(COM_PROJECT);

		request.setAttribute("inProjectId", inProjectId.get(0).getComId());

		if (StringUtils.EMPTY.equals(assetNumber)
				&& groupCode.getGroupId().equals(0)
				&& deptCode.getComId().equals(0)
				&& locationCode.getComId().equals(0)
				&& projectCode.getComId().equals(0)
				&& CustodianId.getEmpId() == 0) {

			System.out.println("if");
			model.addAttribute("availableAssetDetails",
					assetService.getAllAssetDetails());

		} else {
			System.out.println("else");
			List<Asset> assets = assetService
					.getSearchResults(assetNumber, CustodianId, groupCode,
							deptCode, locationCode, projectCode);
			System.out.println(assets);
			model.addAttribute("availableAssetDetails", assetService
					.getSearchResults(assetNumber, CustodianId, groupCode,
							deptCode, locationCode, projectCode));
		}
		model.addAttribute("allMakeList",
				assetService.getAllCodeValuesByType(COM_MAKE));
		model.addAttribute("allDepartmentList",
				assetService.getAllCodeValuesByType(COM_DEPT));
		model.addAttribute("allAssetTypeList",
				assetService.getAllCodeValuesByType(COM_TYPE));
		model.addAttribute("allConditionList",
				assetService.getAllCodeValuesByType(COM_CONDITION));
		model.addAttribute("allCurrentlyAtList",
				assetService.getAllCodeValuesByType(COM_CURRENTLYAT));
		model.addAttribute("allLocationList",
				assetService.getAllCodeValuesByType(COM_LOCATION));
		model.addAttribute("allProjectList",
				assetService.getAllCodeValuesByType(COM_PROJECT));
		model.addAttribute("allGroupDetails", assetService.getAllGroupDetails());
		model.addAttribute("allCustodianDetails",
				assetService.getAllCustodianDetails());

		request.setAttribute("section", "Asset List");
		try {
			long EmployeeCode = Long.parseLong(request.getSession()
					.getAttribute("empCode").toString());
			model.addAttribute("AuthScreens", getAuthScreens(EmployeeCode));
		} catch (Exception e) {
			log.info("seesion expired.....login again....");
			return new ModelAndView(LOGIN_PAGE, "", new LoginForm());
		}

		return new ModelAndView(ASSET_PAGE, "assetForm", new AssetForm());

	}
	// check assetnumber is already saved
		@RequestMapping(value = "/checkAsset", method = RequestMethod.POST)
		public @ResponseBody String checkAsset(
				@ModelAttribute(value = "assetForm") AssetForm assetForm,BindingResult result, Model model
				) {

			
			String assetNumber=assetForm.getAssetNumber();
			String returnText = "";
			if (!result.hasErrors()) {

				Boolean b = assetService.checkAsset(assetNumber);
				if (b.equals(true)) {
					returnText = "true";
				} else {
					model.addAttribute("exists",
							"Asset Number already exists.. try differnt one...");

					returnText = "false";
				}

			}
			return returnText;

		}

}
