package com.experion.ams.mvc.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.debug.JSONWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.util.JSONPObject;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDepreciation;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.service.AssetDepreciationService;
import com.experion.ams.service.DashboardService;
import com.experion.ams.service.SystemParameterService;
import com.experion.ams.util.AMSUtil;
import com.experion.ams.util.DepreciationCalculationsJson;
@Transactional
@Controller
@RequestMapping("/login/*")
public class AssetDepreciationController {
	private static final String ASSET_DEPRECIATION = "/assetdepreciation";
	private static final Log log = LogFactory.getLog(AssetDepreciationController.class);

	@Inject
	@Named(value = "dashboardService")
	private DashboardService dashboardService;
	
	@Inject
	@Named(value = "assetdepreciationservice")
	private AssetDepreciationService assetdepreciationservice;

	



	public AssetDepreciationService getAssetdepreciationservice() {
		return assetdepreciationservice;
	}


	public void setAssetdepreciationservice(
			AssetDepreciationService assetdepreciationservice) {
		this.assetdepreciationservice = assetdepreciationservice;
	}


	@Inject
	@Named(value = "messageSource")
	MessageSource messageSource;
	

	//pagination for list the asset
	
	public void getPagination(AssetDepreciation frmlocation,
			HttpServletRequest request) {

		String next = request.getParameter("next");
		String prev = request.getParameter("pre");
		String last = request.getParameter("last");
		String first = request.getParameter("first");

		int i = frmlocation.getPagecountHidden();
		int totalPage = assetdepreciationservice.getAssetSize();
		totalPage = (int) Math.ceil((double) totalPage / 5);
		totalPage *= 5;

		if (next != null) {
			i = i + 5;
			frmlocation.setPageNum(frmlocation.getPageNum() + 1);
			if (totalPage <= i) {
				i = i - 5;
				frmlocation.setPageNum(frmlocation.getPageNum() - 1);
			}
			frmlocation.setPagecountHidden(i);

		}

		else if (prev != null) {
			i = frmlocation.getPagecountHidden();
			i = i - 5;
			frmlocation.setPageNum(frmlocation.getPageNum() - 1);
			if (i < 0) {
				i = 0;
				frmlocation.setPageNum(1);

			}
			frmlocation.setPagecountHidden(i);
		}

		else if (last != null) {
			frmlocation.setPagecountHidden(totalPage - 5);
			frmlocation.setPageNum(totalPage / 5);
		} else {
			frmlocation.setPagecountHidden(0);
			frmlocation.setPageNum(1);
		}

	}
	
	
	
	
	
	//request for asset pagination list
	
	
	@RequestMapping(value = "/assetpagination")
	public ModelAndView ShowAssetpaginationaction(Model model,AssetDepreciation depreciation,HttpServletRequest request,HttpSession session) {
		
		
		
		
	   
		
		
		  getPagination(depreciation,request);
		
		return ShowDepreciation(model,depreciation,request,session);
	}
	
	
	
	
	//get assets list in page load  
	
	@RequestMapping(value = "/assetDepreciation")
	public ModelAndView ShowDepreciation(Model model,AssetDepreciation depreciation,HttpServletRequest request, HttpSession session) {
		
		
		
		
	    model.addAttribute("assetList",assetdepreciationservice.assetList(depreciation));
		
	    long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		
		
		
		  getPagination(depreciation,request);
		
		return new ModelAndView(ASSET_DEPRECIATION);
	}
	

	//get search assets list 
	
	
	
	@RequestMapping(value = "/searchAssetDep")
	public ModelAndView SearchAsset(@ModelAttribute("command") Asset asset, Model model,HttpServletRequest request, HttpSession session) {
		
		
		
	    
	    model.addAttribute("assetList",assetdepreciationservice.assetList(asset.getAssetNumber()));
		
	    long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		
		return new ModelAndView(ASSET_DEPRECIATION);
	}
	
	
	//click depreciation link and get details
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getdepreciation")
	public ModelAndView GetDepreciation(@ModelAttribute("command") AssetDepreciation depreciation,Model model,HttpServletRequest request,HttpSession session) {
		
		model.addAttribute("section", "Modify Depreciation");
		
		
	    model.addAttribute("assetList",assetdepreciationservice.assetList(depreciation));
	//  retrive asset depreciation list from Depreciation Table 
	    List<AssetDepreciation> listAssetDepreciations = assetdepreciationservice.asetdepreciationList(depreciation.getAsset().getAssetId(),depreciation.getPagecountHidden());
	    
	 //  if Asset Depreciation Table is empty

	    if(listAssetDepreciations.isEmpty())
	    {
	    	
	    	  
	    	  model.addAttribute("ifemptyassetdeprDetail", assetdepreciationservice.assetList(depreciation.getAsset().getAssetId()).get(0)); //asset depreciation common details from asset table
	    	//  model.addAttribute("assetdeprList",listAssetDepreciations);   //for check is empty in jsp 
	    	  try {
				model.addAttribute("deliverydate",AMSUtil.getSimpleDateFormat(assetdepreciationservice.assetList(depreciation.getAsset().getAssetId()).get(0).getPurchaseinfo().getPiDeliveryDate()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //  if Asset Depreciation Table is not empty
	    else
	    {
	    	
	    	for(int i=0;i<listAssetDepreciations.size();i++)
		    {
		    	try {
		    	listAssetDepreciations.get(i).setFromdate(AMSUtil.getSimpleDateFormat(listAssetDepreciations.get(i).getDepreciationTo()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	 model.addAttribute("assetdeprList",listAssetDepreciations);  //depreciation list
		    }
	    	
	    	 
	    	  try {
	  	    	
	    		  
	  	    	
	  	    	
	  	    	
	    			model.addAttribute("deliverydate",AMSUtil.getSimpleDateFormat(listAssetDepreciations.get(0).getAsset().getPurchaseinfo().getPiDeliveryDate())); //delivery date formatted
	    			model.addAttribute("assetdeprDetail",assetdepreciationservice.asetdepreciationList(depreciation.getAsset().getAssetId(),depreciation.getPagecountHidden()).get(0));  //asset depreciation common details from depreciation details
	    		} catch (ParseException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    	
	    }
	    
	   
	
	  
	  
		
	    long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		
		
		
		//getPaginationDepreciation(depreciation,asset,request);
		
		return new ModelAndView(ASSET_DEPRECIATION);
	}
	
	
	//get calculation for depreciation
	
	@RequestMapping(value = "/getdepreciationCalculation", method = RequestMethod.POST)
	public @ResponseBody String GetDepreciationCalculation(@ModelAttribute("command") AssetDepreciation depreciation,Asset asset,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
		
		DepreciationCalculationsJson depreciationCalculationsJson = assetdepreciationservice.depreciationAgeCalaculate(depreciation.getDate(),asset.getAssetId());
		ObjectMapper mapper = new ObjectMapper();
		 System.out.println(mapper.writeValueAsString(depreciationCalculationsJson));
		 return mapper.writeValueAsString(depreciationCalculationsJson);
	
		
		
		
		
		
	}
	
	//insert depreciation details  into db 
	
	
	@RequestMapping(value = "/addDepreciation")
	public ModelAndView addDepreciation(@ModelAttribute("command") AssetDepreciation assetdepr , HttpServletRequest request,HttpSession session,Model model) {
		 String submit= request.getParameter("Submit");
		
		 if(submit!=null)
		 {
		//AssetDepreciation assetDepr=new AssetDepreciation();
		  assetdepr.setAsset(assetdepr.getAsset());
		  assetdepr.setDepreciationFrom(AMSUtil.getSimpleDate(assetdepr.getFromdate()));
		  assetdepr.setDepreciationTo(AMSUtil.getSimpleDate(assetdepr.getTodate()));
		  assetdepr.setDepreciationBookValue(assetdepr.getDepreciationBookValue());
		  assetdepr.setDepreciationAmount(assetdepr.getDepreciationAmount());
		  assetdepr.setDepreciationAccumulatedAmount(assetdepr.getDepreciationAccumulatedAmount());
		  assetdepr.setDepreciationDaysAged(assetdepr.getDepreciationDaysAged());
		  assetdepreciationservice.addDepreciation(assetdepr);
		  
		  
		  long employeeCode = new AMSUtil().getEmployeeCode(session);
			if (employeeCode > 0) {
				model.addAttribute("AuthScreens",
						dashboardService.checkAuthorizedEmp(employeeCode));
			} else {
				return new ModelAndView("redirect:/login/index");
			}
			
			
		    model.addAttribute("assetList",assetdepreciationservice.assetList(assetdepr));
			
			
		return new ModelAndView(ASSET_DEPRECIATION) ;
		  
		 }
		 
		 // pagination after insert getting data
		 
		 String next = request.getParameter("next");
			String prev = request.getParameter("pre");
			String last = request.getParameter("last");
			String first = request.getParameter("first");

			int i = assetdepr.getPagecountHidden();
			int totalPage = assetdepreciationservice.getAssetDeprSize(assetdepr.getAssetpagnId());
			totalPage = (int) Math.ceil((double) totalPage / 3);
			totalPage *= 3;

			if (next != null) {
				i = i + 3;
				assetdepr.setPageNum(assetdepr.getPageNum() + 1);
				if (totalPage <= i) {
					i = i - 3;
					assetdepr.setPageNum(assetdepr.getPageNum() - 1);
				}
				assetdepr.setPagecountHidden(i);

			}

			else if (prev != null) {
				i = assetdepr.getPagecountHidden();
				i = i - 3;
				assetdepr.setPageNum(assetdepr.getPageNum() - 1);
				if (i < 0) {
					i = 0;
					assetdepr.setPageNum(1);

				}
				assetdepr.setPagecountHidden(i);
			}

			else if (last != null) {
				assetdepr.setPagecountHidden(totalPage - 3);
				assetdepr.setPageNum(totalPage / 3);
			} else {
				assetdepr.setPagecountHidden(0);
				assetdepr.setPageNum(1);
			}

		
		 return showDepreciationPagination(assetdepr,model,request,session);
		 
	}
	
	
	
	@RequestMapping(value = "/showDepreciationPagination")
	public ModelAndView showDepreciationPagination(@ModelAttribute("command") AssetDepreciation depreciation,Model model,HttpServletRequest request,HttpSession session) {
		
		model.addAttribute("section", "Modify Depreciation");
		
		
	    model.addAttribute("assetList",assetdepreciationservice.assetList(depreciation));
	//  retrive asset depreciation list from Depreciation Table 
	    List<AssetDepreciation> listAssetDepreciations = assetdepreciationservice.asetdepreciationList(depreciation.getAssetpagnId(),depreciation.getPagecountHidden());
	    
	 //  if Asset Depreciation Table is empty

	    if(listAssetDepreciations.isEmpty())
	    {
	    	
	    	  
	    	  model.addAttribute("ifemptyassetdeprDetail", assetdepreciationservice.assetList(depreciation.getAssetpagnId()).get(0)); //asset depreciation common details from asset table
	    	//  model.addAttribute("assetdeprList",listAssetDepreciations);   //for check is empty in jsp 
	    	  try {
				model.addAttribute("deliverydate",AMSUtil.getSimpleDateFormat(assetdepreciationservice.assetList(depreciation.getAssetpagnId()).get(0).getPurchaseinfo().getPiDeliveryDate()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    //  if Asset Depreciation Table is not empty
	    else
	    {
	    	
	    	for(int i=0;i<listAssetDepreciations.size();i++)
		    {
		    	try {
		    	listAssetDepreciations.get(i).setFromdate(AMSUtil.getSimpleDateFormat(listAssetDepreciations.get(i).getDepreciationTo()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	 model.addAttribute("assetdeprList",listAssetDepreciations);  //depreciation list
		    }
	    	
	    	 
	    	  try {
	  	    	
	    		  
	  	    	
	  	    	
	  	    	
	    			model.addAttribute("deliverydate",AMSUtil.getSimpleDateFormat(listAssetDepreciations.get(0).getAsset().getPurchaseinfo().getPiDeliveryDate())); //delivery date formatted
	    			model.addAttribute("assetdeprDetail",assetdepreciationservice.asetdepreciationList(depreciation.getAssetpagnId(),depreciation.getPagecountHidden()).get(0));  //asset depreciation common details from depreciation details
	    		} catch (ParseException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    	
	    }
	    
	   
	
	  
	  
		
	    long employeeCode = new AMSUtil().getEmployeeCode(session);
		if (employeeCode > 0) {
			model.addAttribute("AuthScreens",
					dashboardService.checkAuthorizedEmp(employeeCode));
		} else {
			return new ModelAndView("redirect:/login/index");
		}
		
		
		
		
		return new ModelAndView(ASSET_DEPRECIATION);
	}
	
	
	
	
	
	
}
