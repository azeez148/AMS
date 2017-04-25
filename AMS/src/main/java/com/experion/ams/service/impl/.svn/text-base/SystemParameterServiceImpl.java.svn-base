package com.experion.ams.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.experion.ams.dao.SystemParameterDAO;
import com.experion.ams.entity.SystemParametersCodeMaster;
import com.experion.ams.service.SystemParameterService;
@Service
public class SystemParameterServiceImpl implements SystemParameterService {
	

	@Inject
	SystemParameterDAO sysstemparameterdao;

	public SystemParameterDAO getSysstemparameterdao() {
		return sysstemparameterdao;
	}

	public void setSysstemparameterdao(SystemParameterDAO sysstemparameterdao) {
		this.sysstemparameterdao = sysstemparameterdao;
	}
	MessageSource messageSource;

	

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	

	@Override
	public List<SystemParametersCodeMaster> getSystemParameterList(String type,int count) {
		// TODO Auto-generated method stub
		return sysstemparameterdao.getSystemParameterList(type,count);
	}

	@Override
	public void addSystemParameter(SystemParametersCodeMaster systemparametercodemaster) {
		// TODO Auto-generated method stub
		sysstemparameterdao.addSystemParameter(systemparametercodemaster);
	}



	@Override
	public List<SystemParametersCodeMaster> getMasterValue() {
		// TODO Auto-generated method stub
	
		return sysstemparameterdao.getMasterValue();
	}

	@Override
	public int getParameterSize(String type) {
		// TODO Auto-generated method stub
		return sysstemparameterdao.getParameterSize(type);
	}

	
	
}
