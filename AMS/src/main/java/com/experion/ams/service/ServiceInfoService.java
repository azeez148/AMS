package com.experion.ams.service;

import java.util.List;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.ServiceInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;

/**
 * 
 * @author surya
 * 
 */

public interface ServiceInfoService {

	public List<Asset> getAssetList();

	public List<Asset> getAssetByNumber(String assetNumber);

	public ServiceInfo getServiceInfoByAssetCode(Integer assetCode);

	public void updateServiceInfo(ServiceInfo serviceinfo);

	public List<SystemParametersCodeMaster> getServiceProvider();
	
	public Long getEmployeeId(Long EmployeeCode);

}
