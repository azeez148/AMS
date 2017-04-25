package com.experion.ams.dao.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.experion.ams.dao.AssetTransferDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetDisposal;
import com.experion.ams.entity.AssetRevalue;
import com.experion.ams.entity.AssetTransfer;
import com.experion.ams.entity.AssetWorkflow;
import com.experion.ams.entity.Employee;
import com.experion.ams.entity.PurchaseInfo;
import com.experion.ams.entity.SystemParametersCodeMaster;


public class AssetTransferHibernateDAO implements AssetTransferDAO{
	
	@Inject
	@Named(value = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public List<Employee> getCustodians() {
		Session session  = sessionFactory.openSession();
		List<Employee> employeeList =  session.createCriteria(Employee.class).list();
		session.close();
		return  employeeList;
	}


	public List<AssetWorkflow> getAssetByNumber(String assetNumber) {
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("from AssetWorkflow a where a.workflowAssetCode.assetNumber like :assetNumber");
				query.setString("assetNumber", "%" + assetNumber + "%");
		List<AssetWorkflow> asset = query.list();
		/*for (Asset a : asset) {
			Integer deptCode = a.getAssetDeptCodeInt();
			Integer projectCode = a.getAssetProjectCodeInt();
			Query queryProject = session
					.createQuery("SELECT comValue from SystemParametersCodeMaster as code where code.comType='PRJ' and code.comId=:projectCode ");
			Query queryDept = session
					.createQuery("SELECT comValue from SystemParametersCodeMaster as code where code.comType='DPT' and code.comId=:deptCode ");
			queryProject.setInteger("projectCode", projectCode);
			queryDept.setInteger("deptCode", deptCode);
			a.setComValuePrj((String) queryProject.uniqueResult());
			a.setComValueDpt((String) queryDept.uniqueResult());

		}*/
		session.close();
		return asset;
	}
	
	
	@Override
	public PurchaseInfo getAsset(int assetId) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(PurchaseInfo.class);
		criteria.add(Restrictions.eq("asset", getAssetId(assetId,session)));
		
		PurchaseInfo  purchaseInfo =(PurchaseInfo) criteria.list().get(0);
//		PurchaseInfo asset = (PurchaseInfo) session.get(PurchaseInfo.class, assetId);
		session.close();
		return purchaseInfo;
	}
	
	
	
	private Asset getAssetId(int assetId,Session session) {
		Asset asset = (Asset) session.get(Asset.class, assetId);
		return asset;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<SystemParametersCodeMaster> getSystemParameters(String condition) {
		Session session = sessionFactory.openSession();
		List<SystemParametersCodeMaster> systemParametersCodeMaster = session.createCriteria(SystemParametersCodeMaster.class).add(Restrictions.eq("comType", condition)).add(Restrictions.ne("comCode", 0)).list();
		session.close();
		return systemParametersCodeMaster;
	}
	@Override
	public void save(AssetTransfer assetTransfer) {
	
		Session session = sessionFactory.openSession();
		Asset asset = assetTransfer.getTransferAssetCode();
		Criteria criteria = session.createCriteria(AssetTransfer.class);
		criteria.add(Restrictions.eq("transferAssetCode", asset));
		List<AssetTransfer> assetTransferList = criteria.list();
		if(assetTransferList.size()>0)
		{
			
			AssetTransfer tempassetTransfer = assetTransferList.get(assetTransferList.size()-1);
			tempassetTransfer.setTransferTransferredUpto(assetTransfer.getTransferTransferredOn());
			session.merge(tempassetTransfer);
			session.flush();
		}
		session.save(assetTransfer);
		session.flush();
		session.close();
	}

	@Override
	public void save(Asset asset) {
		Session session = sessionFactory.openSession();
		session.merge(asset);
		session.flush();
		session.close();
		
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public SystemParametersCodeMaster getSystemPrameter(Integer deptTo) {
		Session session = sessionFactory.openSession();
		SystemParametersCodeMaster system = (SystemParametersCodeMaster) session.get(SystemParametersCodeMaster.class, deptTo);
		session.close();
		return system;
	}


	@Override
	public Employee getEmployee(Long custTo) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.get(Employee.class, custTo);
		session.close();
		return employee;
//		return null;
	}


	@Override
	public Employee getEmployeeByCode(Long empCode) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.createCriteria(Employee.class).add(Restrictions.eq("empCode", empCode)).list().get(0);
//		Employee employee = (Employee) session.get(Employee.class, empCode);
		session.close();
		return employee;
//		return null;
	}
	@Override
	public void save(AssetDisposal assetDisposal) {
		Session session = sessionFactory.openSession();
		updateWorkflow(assetDisposal.getAssetDispAssetCode(),session,true);
		session.merge(assetDisposal);
		session.flush();
		session.close();
		
	}


	private void updateWorkflow(Asset asset, Session session,boolean flag) {
		Criteria criteria = session.createCriteria(AssetWorkflow.class);
		criteria.add(Restrictions.eq("workflowAssetCode", asset));
		AssetWorkflow assetWorkflow = (AssetWorkflow) criteria.list().get(0);
		if(flag)
		{
			assetWorkflow.setWorkflowAssetStatus("Write-off Request");
			assetWorkflow.setWorkflowAssetType("Write Off Asset");	
		}
		else
		{
			assetWorkflow.setWorkflowAssetStatus("Re-Value Request");
			assetWorkflow.setWorkflowAssetType("Re-Value of Asset");
		}
		
		session.merge(assetWorkflow);
		session.flush();
		
	}


	@Override
	public void save(AssetRevalue assetRevalue) {
		Session session = sessionFactory.openSession();
		updateWorkflow(assetRevalue.getRevAssetCode(), session,false);
		session.merge(assetRevalue);
		session.flush();
		session.close();
	}


	@Override
	public List<AssetWorkflow> getAllAvailAssets() {
		Session session  = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		Criteria criteria = session.createCriteria(AssetWorkflow.class);
		criteria.add(Restrictions.eq("workflowAssetStatus", "Approved"));
		criteria.add(Restrictions.ne("workflowAssetType", "Write Off Asset"));
//		criteria.add(Restrictions.and(Restrictions.eq("workflowAssetStatus", "Approved"), Restrictions.ne("workflowAssetType", "Write Off Asset")));
		List<AssetWorkflow> assetWorkflow =  criteria.list();
		session.close();
		return  assetWorkflow;
	}




	
}
