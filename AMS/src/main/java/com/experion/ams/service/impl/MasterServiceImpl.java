package com.experion.ams.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Transactional;

import com.experion.ams.dao.MasterDAO;
import com.experion.ams.entity.AssetGroup;
import com.experion.ams.service.MasterService;
@Transactional
public class MasterServiceImpl implements MasterService {

	@Inject
	@Named(value="masterDAO")
	private MasterDAO masterDAO;
	@Inject
	@Named(value="messageSource")
	private MessageSource messageSource;
	public List<AssetGroup> getAllGroup(Integer count) {
		List<AssetGroup> master = masterDAO.getAllGroupItems(count);
		return master;
		
	}
	
	
	
	public int getTotalPage() {
		// TODO Auto-generated method stub
		return masterDAO.getPageSize();
	}
	
	public AssetGroup getGroupById(Long groupId) {
		
		return masterDAO.getGroupById(groupId);
	}
	
	
	public AssetGroup editItem(Integer masterId) {
		// TODO Auto-generated method stub
		return masterDAO.editItem(masterId);
	}
	public MasterDAO getMasterDAO() {
		return masterDAO;
	}
	public void setMasterDAO(MasterDAO masterDAO) {
		this.masterDAO = masterDAO;
	}
	public MessageSource getMessageSource() {
		return messageSource;
	}
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void saveOrUpdate(AssetGroup groupMaster) {
		masterDAO.saveOrUpdate(groupMaster);
		
	}

	

	

}
