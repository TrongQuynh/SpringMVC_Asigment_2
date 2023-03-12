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
		return userDAO.getUserByID(ID);
	}

	@Override
	public void addNewUser(AdminUser adminUser) {
		userDAO.addNewUser(adminUser);
	}

	@Override
	public void updateUser(AdminUser adminUser) {
		userDAO.updateUser(adminUser);
	}

	@Override
	public void deleteUser(AdminUser adminUser) {
		userDAO.deleteUser(adminUser);
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

	@Override
	public AdminUser getuserByEmail(String Email) {
		return userDAO.getuserByEmail(Email);
	}

}
