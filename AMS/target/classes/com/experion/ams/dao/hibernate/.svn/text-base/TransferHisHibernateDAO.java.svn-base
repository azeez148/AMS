package com.experion.ams.dao.hibernate;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;

import com.experion.ams.dao.TransferHistDAO;
import com.experion.ams.entity.Asset;
import com.experion.ams.entity.AssetTransfer;
import com.experion.ams.entity.Role;

public class TransferHisHibernateDAO implements TransferHistDAO {
	@Inject
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Asset> getAllAvailAssets() {
		List<Asset> assetList = null;
		Session session = sessionFactory.openSession();
		try {
			String hql = "FROM Asset A";
			Query query = session.createQuery(hql);
			assetList = query.list();
		} catch (Exception e) {
			System.out.println(e);
		}
		session.close();
		return assetList;
	}

	@Override
	public List<AssetTransfer> getAllTranHistAssets(int assetId) {
		/*Asset asset = null;
		String hql1 = "FROM Asset A WHERE A.assetId="+assetId;
		Query query1 = this.sessionFactory.openSession().createQuery(hql1);
		List<Asset> list = query1.list();
		for (Asset asset1 : list) {
			asset = (Asset) list.get(0);
		}*/

		List<AssetTransfer> assetTranList = null;
		Session session = sessionFactory.openSession();
		try {
			String hql = "FROM AssetTransfer AT WHERE AT.transferAssetCode="+assetId;
			Query query = session.createQuery(hql);
			assetTranList = query.list();
		} catch (Exception e) {
			System.out.println("hai this is libin: "+e);
		}
		session.close();
		return assetTranList;
	}

}
