package com.experion.ams.mvc.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Employee;
import com.experion.ams.entity.AssetGroupDepreciationMap;
import com.experion.ams.entity.AssetGroup;
import com.experion.ams.mvc.data.GroupMasterForm;
import com.experion.ams.mvc.data.LoginForm;
import com.experion.ams.service.AmsService;
import com.experion.ams.service.AssetTransferService;
import com.experion.ams.service.DashboardService;
import com.experion.ams.service.MasterService;
import com.experion.ams.util.AMSUtil;
import com.google.gson.Gson;

@Controller
@RequestMapping("/master/*")
public class MasterController {

	
	@Inject
	@Named(value = "assetTransferService")
	private AssetTransferService assetTransferService;
	
	@Inject
	@Named(value = "messageSource")
	private MessageSource messageSource;
	@Inject
	@Named(value = "masterService")
	private MasterService masterService;

	private static final String MASTER_GROUP = "/groupmaster";
	private static final String MASTER_EDIT_GROUP = "/editGroupMaster";
	// private static final Logger logger =
	// Logger.getLogger(MasterController.class);

	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;

	@RequestMapping(value = "/group")
	public ModelAndView getGroupItems(
			@ModelAttribute GroupMasterForm groupMasterForm,
			BindingResult result, HttpServletRequest request, HttpSession session, Model model) {
		// logger.info("Entered group get method");

		model.addAttribute("groupList",
				masterService.getAllGroup(groupMasterForm.getCount()));
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		return new ModelAndView(MASTER_GROUP, "groupMasterForm",
				new GroupMasterForm());
	}

	@RequestMapping(value = "/group", method = RequestMethod.POST)
	public ModelAndView paginationControl(
			@ModelAttribute("groupMasterForm") GroupMasterForm groupMasterForm,
			BindingResult result, HttpServletRequest request,HttpSession session, Model model) {
		String next = request.getParameter("next");
		String prev = request.getParameter("pre");
		String last = request.getParameter("last");
		String first = request.getParameter("first");
		int i = groupMasterForm.getCount();
		int totalPage = getTotalPag();

		if (next != null) {
			i = i + 10;
			groupMasterForm.setPageNo(groupMasterForm.getPageNo() + 1);
			if (totalPage <= i) {

				i = i - 10;
				groupMasterForm.setPageNo(groupMasterForm.getPageNo() - 1);
			}

			// int currentPage = i/10+1;
			// System.out.println(currentPage+" = current Page");

			groupMasterForm.setCount(i);

		} else if (prev != null) {
			i = groupMasterForm.getCount();
			i = i - 10;
			groupMasterForm.setPageNo(groupMasterForm.getPageNo() - 1);
			if (i < 0) {
				i = 0;
				groupMasterForm.setPageNo(1);

			}
			int currentPage = i / 10 - 1;
			System.out.println(currentPage + " = current Page");

			groupMasterForm.setCount(i);

		} else if (last != null) {

			groupMasterForm.setCount(totalPage - 10);
			groupMasterForm.setPageNo(totalPage / 10);
		} else {
			groupMasterForm.setCount(0);
			groupMasterForm.setPageNo(1);
		}

		System.out.println("i is " + i);
		// logger.info("Entered paginatonControl method");
		// model.addAttribute("groupList", masterService.getAllGroup());
		// return new ModelAndView();
		return getGroupItems(groupMasterForm, result, request,session, model);
		// return new ModelAndView(MASTER_GROUP, "groupMasterForm",
		// new GroupMasterForm());
	}

	private int getTotalPag() {
		int totalPage = masterService.getTotalPage();
		totalPage = (int) Math.ceil((double) totalPage / 10);
		totalPage *= 10;
		return totalPage;
	}

	@RequestMapping(value = "/showLastPage")
	public ModelAndView showLastPage(
			@ModelAttribute GroupMasterForm groupMasterForm,
			BindingResult result, HttpServletRequest request, HttpSession session, Model model) {
		// logger.info("Entered group get method");

		model.addAttribute("groupList",
				masterService.getAllGroup(getTotalPag() - 10));
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		return new ModelAndView(MASTER_GROUP, "groupMasterForm",
				new GroupMasterForm());
	}

	@RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
	public @ResponseBody String saveGroupItem(
			@ModelAttribute GroupMasterForm groupMasterForm,
			BindingResult result, HttpServletRequest request, Model model,HttpSession session) {
		// logger.info("Entered save");
		Long id = Long.parseLong(request.getParameter("id"));
		String masterName = request.getParameter("name");
		String masterDepreType = request.getParameter("type");
		String masterPercentage = request.getParameter("percentage");
		String masterActive = request.getParameter("active");
		String empCode =  session.getAttribute("empCode").toString();
		AssetGroup groupMaster = convertToEntity(id, masterName, empCode,
				masterDepreType, masterPercentage, masterActive);
		String success = "";
		success = validateDatas(groupMaster);
		if (StringUtils.equals(success, "success")) {
			try {
				System.err.println("Group Id is " + groupMaster.getGroupId());
				if (groupMaster.getGroupId() != null) {
					// logger.info("Updated Succeesfully");
					success = "Successully Updated";
				} else {
					System.out.println(groupMaster.getGroupId()
							+ " GroupId is ");
					// logger.info("Save Success");
					success = "Successfully Saved";
				}
				masterService.saveOrUpdate(groupMaster);

			} catch (Exception e) {
				// logger.error("Error Saving");
				success = "Failed";
			}

			return success;

		} else {
			return success;
		}

	}

	// @RequestMapping(value = "/edit.html",method=RequestMethod.POST)
	// public GroupMasterForm editGroupItem(@RequestBody final GroupMasterForm
	// groupMasterForm) {
	//
	// System.err.println("id is "+groupMasterForm.getGroupId());
	// // model.addAttribute("groupList", masterService.getAllGroup());
	// return groupMasterForm;
	// // return new ModelAndView(MASTER_GROUP, "groupMasterForm", new
	// GroupMasterForm());
	// }

	private String validateDatas(AssetGroup groupMaster) {
		String message = "";
		// Pattern pattern =Pattern.compile("\\d+(.\\d{2})?");
		String value = groupMaster.getGroupDepreciation().getDepriciateValue();
		// Matcher matcher = pattern.matcher(value);

		if (StringUtils.isEmpty(groupMaster.getGroupName())) {
			message = "Name is Blank";
		} else if (StringUtils.isEmpty(groupMaster.getGroupStatus())) {
			message = "Status is Blank";
		} else if (StringUtils.isEmpty(groupMaster.getGroupDepreciation()
				.getDeprecateType())) {
			message = "Depreciation Type is Blank";
		} else if (StringUtils.isEmpty(groupMaster.getGroupDepreciation()
				.getDepriciateValue())) {
			message = "Depreciation Percentage is Blank";
		} else {
			try {
				double val = Double.parseDouble(value);
			} catch (NumberFormatException e) {
				message = "Depreciation Percentage is  Not a Number";
				return message;
			}
			message = "success";
		}
		return message;
	}

	private AssetGroup convertToEntity(Long id, String masterName,String empCode,
			String masterDepreType, String masterPercentage, String masterActive) {
		AssetGroup groupMaster = new AssetGroup();
		long employeeCode = Long.parseLong(empCode);
		Employee employee = assetTransferService.getEmployeeByCode(employeeCode);
		groupMaster.setGroupCreatedBy(employee.getEmpId());
		if (id != 0) {

			groupMaster = masterService.getGroupById(id);
			groupMaster.setGroupName(masterName);
			groupMaster.setGroupCreatedDate(new Date());
			groupMaster.setGroupStatus(masterActive);
			AssetGroupDepreciationMap groupDepreciation = groupMaster
					.getGroupDepreciation();
			groupDepreciation.setDeprecateType(masterDepreType);
			groupDepreciation.setDepriciateValue(masterPercentage);
		} else {

			groupMaster.setGroupName(masterName);
			groupMaster.setGroupCreatedDate(new Date());
			groupMaster.setGroupStatus(masterActive);

			AssetGroupDepreciationMap groupDepreciation = new AssetGroupDepreciationMap();
			groupDepreciation.setDeprecateType(masterDepreType);
			groupDepreciation.setDepriciateValue(masterPercentage);
			groupMaster.setGroupDepreciation(groupDepreciation);
			groupDepreciation.setGroupMaster(groupMaster);

		}

		return groupMaster;
	}

	private AssetGroup convertEntity(GroupMasterForm groupMasterForm) {
		AssetGroup groupMaster = new AssetGroup();
		// groupMaster.setGroupId(groupMasterForm.getGroupId());
		return groupMaster;
	}

	@RequestMapping(value = "/edit/{masterId}", method = RequestMethod.GET)
	public ModelAndView editGroupItem(@PathVariable Integer masterId,
			@ModelAttribute GroupMasterForm groupMasterForm,
			BindingResult result, HttpServletRequest request, Model model,
			HttpSession session) {
		session.setAttribute("Id", masterId);
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		return new ModelAndView("redirect:/master/editPage");

	}

	@RequestMapping(value = "/editPage", method = RequestMethod.GET)
	public ModelAndView editItem(
			@ModelAttribute GroupMasterForm groupMasterForm,
			BindingResult result, HttpServletRequest request, Model model,
			HttpSession session) {
		Integer masterId = (Integer) session.getAttribute("Id");
		session.setAttribute("Id", null);
		AssetGroup master = masterService.editItem(masterId);
		System.err.println("master is " + master.getGroupDesc());
		model.addAttribute("editItem", masterService.editItem(masterId));
		// model.addAttribute("editItem",
		// convertToForm(masterService.editItem(masterId)));
		// model.addAttribute("groupList", masterService.getAllGroup());
		long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		return new ModelAndView(MASTER_EDIT_GROUP, "groupMasterForm",
				new GroupMasterForm());

	}

	private GroupMasterForm convertToForm(AssetGroup editItem) {
		GroupMasterForm groupMasterForm = new GroupMasterForm();
		groupMasterForm.setGroupDesc(editItem.getGroupDesc());
		groupMasterForm.setGroupId(editItem.getGroupId());
		groupMasterForm.setGroupName(editItem.getGroupName());
		groupMasterForm.setGroupStatus(editItem.getGroupStatus());
		return null;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public MasterService getMasterService() {
		return masterService;
	}

	public void setMasterService(MasterService masterService) {
		this.masterService = masterService;
	}

	public AssetTransferService getAssetTransferService() {
		return assetTransferService;
	}

	public void setAssetTransferService(AssetTransferService assetTransferService) {
		this.assetTransferService = assetTransferService;
	}
}
