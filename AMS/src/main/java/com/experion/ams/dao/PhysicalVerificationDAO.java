package com.experion.ams.dao;

import java.util.Date;
import java.util.List;

import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetGroup;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.PhysicalVerification;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.util.AssetVerificationJson;

public interface PhysicalVerificationDAO {
	List<PhysicalVerification> getAllVerifications();
	List<PhysicalVerification> getSearchResults();
	AssetVerificationJson getVerifiedAssetDetail(String assetnumber);
	void addPhysicalVerification(PhysicalVerification phyveri,Employee sessionid);
	Employee getEmpSessionId(long sessionId);
	List<SystemParametersCodeMaster> getAllCodeValuesByType(String type);
	List<AssetGroup> getAllGroupDetails();

	List<Employee> getAllCustodianDetails();
//	List<PhysicalVerification> getSearchResults(String assetNumber, Employee custodianId,
//			AssetGroup groupCode, SystemParametersCodeMaster deptCode,
//			SystemParametersCodeMaster locationCode,
//			SystemParametersCodeMaster projectCode);

	List<PhysicalVerification>getSearchResultsAssetnumber(String assetnumber);

}
