package com.onlineclass.sysadmin.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlineclass.sysadmin.dao.AdminUserDAO;
import com.onlineclass.sysadmin.entity.AdminUser;
import com.onlineclass.sysadmin.entity.AdminUser_CommonCode;

@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {
	
	@Autowired
	AdminUserDAO userDAO;
	
	@Override
	public List<AdminUser> getAllUser() {
		return userDAO.getAllUser();
	}

	@Override
	public AdminUser getUserByID(Integer ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNewUser(AdminUser adminUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(AdminUser adminUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Integer ID) {
		userDAO.deleteUser(ID);
	}

	@Override
	public List<AdminUser_CommonCode> getAllUser_CommonCode() {
		return userDAO.getAllUser_CommonCode();
	}

	@Override
	public int getTotalUser() {
		return userDAO.getTotalUser();
	}

	@Override
	public List<AdminUser_CommonCode> getAllUserInRage(Map<String, Object> params) {
		return userDAO.getAllUserInRage(params);
	}

}
