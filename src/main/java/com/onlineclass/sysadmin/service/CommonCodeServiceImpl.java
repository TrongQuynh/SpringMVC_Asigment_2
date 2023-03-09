package com.onlineclass.sysadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineclass.sysadmin.dao.CommonCodeDAO;
import com.onlineclass.sysadmin.entity.CommonCode;

@Service
@Transactional
public class CommonCodeServiceImpl implements CommonCodeService {
	
	@Autowired
	CommonCodeDAO codeDAO;
	
	@Override
	public List<CommonCode> getAllCommonCodes() {
		return codeDAO.getAllCommonCodes();
	}

}
