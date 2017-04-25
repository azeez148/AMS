package com.experion.ams.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpRequest;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.MessageSource;















import com.experion.ams.dao.PhysicalVerificationDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetGroup;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.PhysicalVerification;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.service.PhysicalVerificationService;
import com.experion.ams.util.AMSUtil;
import com.experion.ams.util.AssetVerificationJson;

public class PhysicalVerificationServiceImpl implements PhysicalVerificationService {
	
	MessageSource messageSource;
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	
	@Inject
	PhysicalVerificationDAO physicalverificationdao;
	public PhysicalVerificationDAO getPhysicalverificationdao() {
		return physicalverificationdao;
	}

	public void setPhysicalverificationdao(
			PhysicalVerificationDAO physicalverificationdao) {
		this.physicalverificationdao = physicalverificationdao;
	}

	@Override
	public List<PhysicalVerification> getAllVerifications() {
		// TODO Auto-generated method stub
		return physicalverificationdao.getAllVerifications();
	}

	@Override
	public AssetVerificationJson getVerifiedAssetDetail(String assetnumber) {
		// TODO Auto-generated method stub
		return physicalverificationdao.getVerifiedAssetDetail(assetnumber);
	}

	@Override
	public void addPhysicalVerification(PhysicalVerification phyveri,Employee sessionid) {
	
		PhysicalVerification phyver=new PhysicalVerification();
		phyver.setPhysicalverificationAsset(phyveri.getPhysicalverificationAsset());
		
		
		
		phyver.setPhysicalverificationcreatedby(getEmpSessionId(sessionid.getEmpId()));
		phyver.setPhysicalverificationupdatedby(getEmpSessionId(sessionid.getEmpId()));
		phyver.setRemarks(phyveri.getRemarks());
		phyver.setVerified("yes");
		
//		Date d=new Date();
//		DateFormat targetFormat = new SimpleDateFormat("yyyy-MM-dd");
//		String formattedDate = targetFormat.format(d);
		
		phyver.setVerifiedDate(AMSUtil.getSimpleDate(phyveri.getVerifiedtrans()));
		phyver.setLastDate(AMSUtil.getSimpleDate(phyveri.getLastdatetrans()));
		physicalverificationdao.addPhysicalVerification(phyver, sessionid);
		
	
		
		
	}

	@Override
	public Employee getEmpSessionId(long sessionId) {
		// TODO Auto-generated method stub
		return physicalverificationdao.getEmpSessionId(sessionId);
	}

	@Override
	public List<SystemParametersCodeMaster> getAllCodeValuesByType(String type) {
		// TODO Auto-generated method stub
		return physicalverificationdao.getAllCodeValuesByType(type);
	}

	@Override
	public List<AssetGroup> getAllGroupDetails() {
		// TODO Auto-generated method stub
		return physicalverificationdao.getAllGroupDetails();
	}

	@Override
	public List<Employee> getAllCustodianDetails() {
		// TODO Auto-generated method stub
		return physicalverificationdao.getAllCustodianDetails();
	}

//	@Override
//	public List<PhysicalVerification> getSearchResults(String assetNumber,
//			Employee custodianId, AssetGroup groupCode,
//			SystemParametersCodeMaster deptCode,
//			SystemParametersCodeMaster locationCode,
//			SystemParametersCodeMaster projectCode) {
//		// TODO Auto-generated method stub
//		return physicalverificationdao.getSearchResults(assetNumber, custodianId, groupCode,
//				deptCode, locationCode, projectCode);
//	}

	@Override
	public List<SystemParametersCodeMaster> getProjectIdByName(String comProject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhysicalVerification> getSearchResultsAssetnumber(
			String assetnumber) {
		// TODO Auto-generated method stub
		return physicalverificationdao.getSearchResultsAssetnumber(assetnumber);
	}

	

	

}
