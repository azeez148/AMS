package com.experion.ams.dao.hibernate;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.experion.ams.dao.ReplicationDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.Role;

public class ReplicationHibernateDAO implements ReplicationDAO {
	@Inject
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asset> getAllAssetDetails() {
/*
		Session session = sessionFactory.openSession();
		List<String> assetNumber = session
				.createQuery(
						"select DISTINCT SUBSTRING(aset.assetNumber, 1,locate('-', aset.assetNumber, 1)-1 ) from Asset aset")
				.list();*/
		Session session = sessionFactory.openSession();
		List<Asset> assetNumber = null;
		try {
			String hql = "FROM Asset A";
			Query query = session.createQuery(hql);
			assetNumber = query.list();
		} catch (Exception e) {
			System.out.println(e);
		}
		session.close();
		return assetNumber;

	}

	@Override
	public Asset getSelectedAssetDetaills(String assetNumber) {
		Asset assetReal = null;
		Session session = sessionFactory.openSession();
		/*Query query = session
				.createQuery("from Asset where assetNumber like :assetNumber");
		query.setString("assetNumber", "%" + assetNumber + "%");*/
		System.out.println("libin befor query :"+assetNumber);
		Query query = session.createQuery("from Asset where assetNumber =:assetNo");
		query.setString("assetNo", assetNumber);
		List<Asset> asset = query.list();
		for (Asset assetList : asset) {
			assetReal = (Asset) asset.get(0);	
		}
		System.out.println("libin check asset "+assetReal.getAssetModel());
		return assetReal;
	}

	@Override
	public Integer saveAssetReplication(String assetNumber,
			Integer numberOfReplication) {
		Integer value = null;
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			Query query = session
					.createQuery("from Asset aset where aset.assetNumber =:assetNumber");
			query.setString("assetNumber", assetNumber);

			Asset asset = (Asset) query.list().get(0);
			Query queryExp = session
					.createQuery("select max( SUBSTRING(aset.assetNumber,locate('-', aset.assetNumber, 1)+1,4)) from Asset aset where aset.assetNumber =:assetNumber");
			queryExp.setString("assetNumber", assetNumber);
			Integer assetNumberExp = (Integer) Integer
					.parseInt((String) queryExp.uniqueResult());
			while (numberOfReplication > 0) {

				Asset newAsset = new Asset();
				assetNumberExp++;
				newAsset.setAssetId(asset.getAssetId());
				newAsset.setAssetNumber(assetNumberCorrection(assetNumber,
						assetNumberExp));
				newAsset.setAssetMake(asset.getAssetMake());
				newAsset.setAssetModel(asset.getAssetModel());
				newAsset.setAssetModelNumber(asset.getAssetModelNumber());
				newAsset.setAssetSerialNumber(asset.getAssetSerialNumber());
				newAsset.setAssetDescription(asset.getAssetDescription());
				newAsset.setAssetNotes(asset.getAssetNotes());
				newAsset.setAssetGroupCode(asset.getAssetGroupCode());
				newAsset.setAssetType(asset.getAssetType());
				newAsset.setAssetCondition(asset.getAssetCondition());
				newAsset.setAssetCurrentlyAt(asset.getAssetCurrentlyAt());
				newAsset.setAssetLocationCode(asset.getAssetLocationCode());
				newAsset.setAssetDeptCode(asset.getAssetDeptCode());
				newAsset.setAssetProjectCode(asset.getAssetProjectCode());
				newAsset.setAssetCustodianCode(asset.getAssetCustodianCode());
				newAsset.setAssetPurchaseReqName(asset
						.getAssetPurchaseReqName());
				newAsset.setAssetPurchaseReqNumber(asset
						.getAssetPurchaseReqNumber());
				newAsset.setAssetPurchaseReqDate(asset
						.getAssetPurchaseReqDate());
				newAsset.setAssetCapitalizationDate(asset
						.getAssetCapitalizationDate());

				newAsset.setAssetCreatedBy(asset.getAssetCreatedBy());
				newAsset.setAssetCreatedDate(asset.getAssetCreatedDate());
				newAsset.setAssetUpdatedBy(asset.getAssetUpdatedBy());
				newAsset.setAssetUpdatedDate(asset.getAssetUpdatedDate());
				newAsset.setAssetStatus(asset.getAssetStatus());

				value = (Integer) session.save(newAsset);

				numberOfReplication--;
			}
			tx.commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {

			session.close();
		}

		return value;

	}

	@Override
	public Asset getAssetDetailsToSave(String assetNumber) {
		Session session = sessionFactory.openSession();
		Query query = session
				.createQuery("from Asset where assetNumber like :Number");
		query.setString("Number", "%" + assetNumber + "%");
		Asset asset = (Asset) query.list().get(0);
		Query queryExp = session
				.createQuery("select max( SUBSTRING(aset.assetNumber,locate('-', aset.assetNumber, 1)+1,4)) from Asset aset where assetNumber like :assetNumber");
		queryExp.setString("assetNumber", "%" + assetNumber + "%");
		Integer assetNumberExp = -000;
		try{assetNumberExp = (Integer) Integer.parseInt((String) queryExp
				.uniqueResult());}catch(Exception e){assetNumberExp = -001;}
		asset.setAssetNumber(assetNumberCorrection(assetNumber, assetNumberExp));
		return asset;
	}

	/**
	 * Function used to adjusting asset number.
	 * 
	 * @param assetNumber
	 * @param assetNumberExp
	 * @return correctedAssetNumber	Returns corrected asset number.
	 */
	private String assetNumberCorrection(String assetNumber,
			Integer assetNumberExp) {
		String newAssetNumber[] = assetNumber.split("-");
		String correctedAssetNumber = newAssetNumber[0];
		if (assetNumberExp < 10) {
			correctedAssetNumber += "-00" + assetNumberExp;
		} else if (assetNumberExp < 100) {
			correctedAssetNumber += "-0" + assetNumberExp;
		} else {
			correctedAssetNumber += "-" + assetNumberExp;
		}
		return correctedAssetNumber;
	}

}
