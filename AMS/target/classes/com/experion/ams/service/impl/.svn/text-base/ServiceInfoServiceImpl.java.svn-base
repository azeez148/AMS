package com.experion.ams.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Transactional;

import com.experion.ams.dao.ServiceInfoDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.ServiceInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.service.ServiceInfoService;

@Transactional
public class ServiceInfoServiceImpl implements ServiceInfoService {

	@Inject
	private ServiceInfoDAO serviceinfoDAO;

	public ServiceInfoDAO getServiceinfoDAO() {
		return serviceinfoDAO;
	}

	public void setServiceinfoDAO(ServiceInfoDAO serviceinfoDAO) {
		this.serviceinfoDAO = serviceinfoDAO;
	}

	@Inject
	private MessageSource messageSource;

	public List<Asset> getAssetByNumber(String assetNumber) {
		List<Asset> asset = serviceinfoDAO.getAssetByNumber(assetNumber);
		return asset;
	}

	public ServiceInfo getServiceInfoByAssetCode(Integer assetCode) {
		ServiceInfo serviceinfo = serviceinfoDAO
				.getServiceInfoByAssetCode(assetCode);
		return serviceinfo;

	}

	public void updateServiceInfo(ServiceInfo serviceinfo) {
		serviceinfoDAO.updateServiceInfo(serviceinfo);
	}

	public List<SystemParametersCodeMaster> getServiceProvider() {
		List<SystemParametersCodeMaster> codemaster = serviceinfoDAO.getServiceProvider();
		return codemaster;
	}

	public List<Asset> getAssetList() {
		List<Asset> asset = serviceinfoDAO.getAssetList();
		return asset;
	}
	
	public Long getEmployeeId(Long EmployeeCode){
		Long EmployeeId= serviceinfoDAO.getEmployeeId(EmployeeCode);
		return EmployeeId;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}
