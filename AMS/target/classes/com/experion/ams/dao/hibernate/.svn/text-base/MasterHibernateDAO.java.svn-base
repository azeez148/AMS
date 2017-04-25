package com.experion.ams.dao.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.management.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;

import com.experion.ams.dao.MasterDAO;
import com.experion.ams.entity.AssetGroup;

public class MasterHibernateDAO implements MasterDAO {

	@Inject
	@Named(value = "messageSource")
	private MessageSource messageSource;

	@Inject
	@Named(value = "sessionFactory")
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<AssetGroup> getAllGroupItems(Integer count) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(AssetGroup.class);
		//
		criteria.setFirstResult(count);
		criteria.setMaxResults(10);
		List<AssetGroup> groupMasterList = criteria.list();
		session.clear();
		session.close();
		return groupMasterList;
		// return
		// sessionFactory.getCurrentSession().createCriteria(GroupMaster.class).list();
	}

	public AssetGroup editItem(Integer masterId) {
		// TODO Auto-generated method stub
		// Session session = sessionFactory.openSession();
		// return (GroupMaster) session.get(GroupMaster.class,new
		// Integer(masterId));
		return null;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveOrUpdate(AssetGroup groupMaster) {
		Session session = sessionFactory.openSession();
//		session.beginTransaction();
		// groupMaster.setGroupId(3L);
		// groupMaster.getGroupDepreciation().setDeprecateId(3);

		try {
			if (groupMaster.getGroupId() == null) {
				System.out.println("inside null");
				session.persist(groupMaster);
				session.flush();
			} else {
				System.out.println("inside not null");
				session.merge(groupMaster);
				session.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.clear();
		session.close();
	}

	public AssetGroup getGroupById(Long groupId) {
		Session session = sessionFactory.openSession();
		AssetGroup groupMaster = (AssetGroup) session.get(AssetGroup.class,
				groupId);
		session.clear();
		session.close();
		return groupMaster;
	}

	public int getPageSize() {
		Session session = sessionFactory.openSession();
		int pageSize = session.createCriteria(AssetGroup.class).list().size();
		session.clear();
		session.close();
		return pageSize;
	}

}
