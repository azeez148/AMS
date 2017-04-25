package com.experion.ams.service.impl;

import java.util.List;
import java.util.Properties;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.experion.ams.dao.AmsDAO;
import com.experion.ams.dao.DashboardDao;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.EmployeeToRoleMapping;
import com.experion.ams.service.DashboardService;

/**
 * @author Libin Lougine L
 *
 */
public class DashboardServiceImpl implements DashboardService{
	
	@Inject
	private DashboardDao dashboardDao;
	public DashboardDao getDashboardDao() {
		return dashboardDao;
	}

	public void setDashboardDao(DashboardDao dashboardDao) {
		this.dashboardDao = dashboardDao;
	}

	MessageSource messageSource;

	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public Properties getAllAssetStatus(){
		Properties assetStatus = dashboardDao.getAllAssetStatusFromDB();
		return assetStatus;
	}
	
	public Properties getAllAvailableAsset(){
		Properties availableAsset = dashboardDao.getAllAvailableAssetFromDB();
		return availableAsset;
	}
	
	public Properties getAllServiceRemainder(){
		Properties serviceRemainder = dashboardDao.getAllServiceRemainderFromDB();
		return serviceRemainder;
	}
	
	public List<Employee> checkAuthorizedEmp(long EmployeeCode){
		List<Employee> emplRoleMap = dashboardDao.checkAuthorizedEmp(EmployeeCode);
		return emplRoleMap;
	}
	
}
