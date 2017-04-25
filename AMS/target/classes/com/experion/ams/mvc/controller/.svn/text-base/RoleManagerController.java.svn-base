/**
 * 
 */
package com.experion.ams.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Role;
import com.experion.ams.entity.RoleToScreenMapping;
import com.experion.ams.entity.Screen;
import com.experion.ams.mvc.data.RoleForm;
import com.experion.ams.mvc.vo.RoleFormVO;
import com.experion.ams.service.DashboardService;
import com.experion.ams.service.RoleService;
import com.experion.ams.util.AMSUtil;

/**
 * @author Abdul Azeez 12-07-2015
 *
 */

@Controller
@RequestMapping("/login/*")
public class RoleManagerController {

	private static final String ROLE_PAGE = "/rolemanagement";
	private static final String STATUS_ACTIVE = "Active";
	// private static final String STATUS_INACTIVE = "InActive";
	// private static String roleName = "";
	private static long roleId;

	private static final Log log = LogFactory.getLog(LoginController.class);

	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;

	@Inject
	@Named(value = "messageSource")
	MessageSource messageSource;

	@Inject
	@Named("roleService")
	public RoleService roleService;

	// get role page
	@RequestMapping(value = "/role")
	public ModelAndView showRolePage(HttpServletRequest request,
			@ModelAttribute(value = "RoleForm") RoleForm roleForm, Model model,
			HttpSession session) {
		log.info("role page laoding...");
		model.addAttribute("availableRoleDetails", roleService.getAllRoles());
		model.addAttribute("availableScreens", roleService.getAllScreens());
		request.setAttribute("section", "Role List");
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}

		return new ModelAndView(ROLE_PAGE, "roleForm", new RoleForm());
	}

	// save role details
	@RequestMapping(value = "/save")
	public ModelAndView saveRole(
			@ModelAttribute(value = "RoleForm") @Valid RoleForm roleForm,
			BindingResult result, Model model, HttpServletRequest request,
			HttpSession session) {
		log.info("saving role details...........");
		/*
		 * request.setAttribute("section", "Manage Role");
		 *//*
			 * RoleValidator roleValidator = new RoleValidator();
			 * roleValidator.validate(roleForm, result);
			 */
		model.addAttribute("availableRoleDetails", roleService.getAllRoles());
		model.addAttribute("availableScreens", roleService.getAllScreens());
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		if (!result.hasErrors()) {

			RoleFormVO roleFormVO = new RoleFormVO();

			roleFormVO.setName(roleForm.getName());
			roleFormVO.setDescription(roleForm.getDescription());
			if (roleForm.getStatus().equals(STATUS_ACTIVE)) {
				roleFormVO.setStatus("yes");
			} else {
				roleFormVO.setStatus("no");
			}
			String[] preveliages = roleForm.getPreviliages();
			if (!preveliages.equals(null)) {
				List<String> preveliagesList = Arrays.asList(preveliages);
				List<Screen> screenList = roleService
						.getScreenDeatails(preveliagesList);
				log.info(roleFormVO);
				boolean added = roleService.addRole(roleFormVO, screenList);

				if (!added) {
					request.setAttribute("section", "Manage Role");
					model.addAttribute("error",
							" Something Went Wrong Please Try Again..");

					return new ModelAndView(ROLE_PAGE, "roleForm",
							new RoleForm());
				}
				request.setAttribute("section", "Manage Role");

				model.addAttribute("succes", "New Role Added");
			} else {
				model.addAttribute("error", "All Feilds are Mandatory");

				return new ModelAndView(ROLE_PAGE, "roleForm", new RoleForm());
			}
		} else {

			log.info(result);
			log.error("error in binding result");
			request.setAttribute("section", "Manage Role");

			model.addAttribute("error", "All Feilds are Mandatory");
			return new ModelAndView(ROLE_PAGE, "roleForm", new RoleForm());

		}
		request.setAttribute("section", "Role List");

		return new ModelAndView(ROLE_PAGE, "roleForm", new RoleForm());

	}

	// get all role details to edit page.
	@RequestMapping(value = "/setRoleName", method = RequestMethod.GET)
	public @ResponseBody String showEditTabDetails(
			@ModelAttribute(value = "field") RoleForm roleForm,
			BindingResult result, Model model, HttpServletRequest request,
			HttpSession httpSession) {
		log.info("geting response to ajax call for edit role details....");

		System.out.println(roleForm.getSelectedItem());
		httpSession.setAttribute("roleId", roleForm.getSelectedItem());

		request.setAttribute("section", "Manage Role");
		// roleId = roleForm.getSelectedItem();
		log.info("roleId::......" + roleForm.getSelectedItem());
		String returnText = "";
		if (!(roleForm.getSelectedItem() == 0)) {
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
	@RequestMapping(value = "/editRoleDetails")
	public ModelAndView editRoleDetails(
			@ModelAttribute(value = "roleForm") RoleForm roleForm,
			BindingResult result, Model model, HttpServletRequest request,
			HttpSession session) {
		request.setAttribute("section", "Manage Role");
		log.info("geting response to ajax call for edit role details....");
		try {
			Integer roleId = Integer.parseInt(request.getSession()
					.getAttribute("roleId").toString());

			List<Role> allRoleDetails = roleService.getRoleDetailsById(roleId);
			model.addAttribute("role", roleService.getRoleDetailsById(roleId));

			model.addAttribute("availableRoleDetails",
					roleService.getAllRoles());
			model.addAttribute("screenlist", allRoleDetails.get(0)
					.getRoleScreenMap());

			// logic to show selected screens in right picklist and rest screens
			// in
			// left picklist
			List<Screen> scr = roleService.getAllScreens();
			List<RoleToScreenMapping> scr1 = allRoleDetails.get(0)
					.getRoleScreenMap();
			List<String> testing = new ArrayList<String>();
			List<Screen> uncommon = new ArrayList<Screen>();
			uncommon.addAll(scr);
			for (RoleToScreenMapping rolesc : scr1) {
				testing.add(rolesc.getScreen().getScreenName());
			}
			List<String> screeeee = new ArrayList<String>();
			for (int i = 0; i < uncommon.size(); i++) {
				for (int j = 0; j < testing.size(); j++) {
					if (!uncommon.get(i).getScreenName().equals(testing.get(j))) {
					} else {
					}
				}
				screeeee.add(uncommon.get(i).getScreenName());
			}
			screeeee.removeAll(testing);
			model.addAttribute("leftscreen", screeeee);

			long employeeCode = new AMSUtil().getEmployeeCode(session);
			if (employeeCode > 0) {
				model.addAttribute("AuthScreens",
						dashboardService.checkAuthorizedEmp(employeeCode));
			} else {
				return new ModelAndView("redirect:/login/index");
			}
			return new ModelAndView(ROLE_PAGE);
		} catch (NullPointerException Ne) {
			model.addAttribute("error",
					"Ooops... Something Happend Please Try Again");

			return new ModelAndView(ROLE_PAGE);

		}
	}

	// save the edited role details
	@RequestMapping(value = "/editRoleAction")
	public ModelAndView editRoleAction(
			@ModelAttribute(value = "RoleForm") @Valid RoleForm roleForm,
			BindingResult result, Model model, HttpServletRequest request,
			HttpSession session) {
		log.info("saving the edited role details...........");
		request.setAttribute("section", "Manage Role");
		Integer roleId = Integer.parseInt(request.getSession()
				.getAttribute("roleId").toString());
		/*
		 * RoleValidator roleValidator = new RoleValidator();
		 * roleValidator.validate(roleForm, result);
		 */
		System.out.println(roleForm.getStatus());
		if (!result.hasErrors()) {
			String[] preveliages = roleForm.getPreviliages();
			if (!preveliages.equals(null)) {

				List<String> preveliagesList = Arrays.asList(preveliages);
				List<Screen> screenList = roleService
						.getScreenDeatails(preveliagesList);
				log.info("INVOKING SERVICE LAYER...........");
				RoleFormVO roleFormVO = new RoleFormVO();

				roleFormVO.setName(roleForm.getName());
				roleFormVO.setDescription(roleForm.getDescription());
				if (roleForm.getStatus().equals(STATUS_ACTIVE)) {
					roleFormVO.setStatus("yes");
				} else {
					roleFormVO.setStatus("no");
				}

				boolean added = roleService.editRole(roleId, roleFormVO,
						screenList);

				model.addAttribute("availableRoleDetails",
						roleService.getAllRoles());
				model.addAttribute("availableScreens",
						roleService.getAllScreens());
				long employeeCode = new AMSUtil().getEmployeeCode(session);
				if (employeeCode > 0) {
					model.addAttribute("AuthScreens",
							dashboardService.checkAuthorizedEmp(employeeCode));
				} else {
					return new ModelAndView("redirect:/login/index");
				}
				if (!added) {
					model.addAttribute("error",
							" Something Went Wrong Please Try Again..");

					return new ModelAndView(ROLE_PAGE, "roleForm",
							new RoleForm());
				} else {
					model.addAttribute("succes", " Role Updated..");

					return new ModelAndView(ROLE_PAGE, "roleForm",
							new RoleForm());
				}
			}
		} else {

			log.info(result);
			log.error("error in binding result");
			model.addAttribute("error", "All Feilds are Mandatory");
		}

		return new ModelAndView(ROLE_PAGE, "roleForm", new RoleForm());
	}

	// searching based on the role name
	@RequestMapping(value = "/searchResultForRole")
	public ModelAndView searchEmployeeForAdd(
			@ModelAttribute(value = "roleForm") RoleForm roleForm,
			BindingResult result, Model model, HttpServletRequest request,
			HttpSession session) {
		log.info("searching the role details...........");
		String roleName = roleForm.getName();
		model.addAttribute("availableRoleDetails",
				roleService.getRoleDetailsByName(roleName));
		model.addAttribute("availableScreens", roleService.getAllScreens());
		request.setAttribute("section", "Role List");
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		return new ModelAndView(ROLE_PAGE, "roleForm", new RoleForm());
	}

	// check roleNumber is already saved
	@RequestMapping(value = "/checkRole", method = RequestMethod.POST)
	public @ResponseBody String checkRole(
			@ModelAttribute(value = "roleForm") RoleForm roleForm,
			BindingResult result, Model model) {

		String roleName = roleForm.getName();
		String returnText = "";
		if (!result.hasErrors()) {

			Boolean b = roleService.checkRole(roleName);
			if (b.equals(true)) {
				returnText = "true";
			} else {
				model.addAttribute("exists",
						"Role Name already exists.. try differnt one...");

				returnText = "false";
			}

		}
		return returnText;

	}

}
