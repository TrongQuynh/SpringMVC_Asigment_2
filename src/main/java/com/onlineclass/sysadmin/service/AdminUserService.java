package com.onlineclass.sysadmin.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.onlineclass.sysadmin.entity.AdminUser;
import com.onlineclass.sysadmin.entity.AdminUser_CommonCode;

@Service
public interface AdminUserService {
	
	// Can Delete
	public List<AdminUser> getAllUser();
	
	public List<AdminUser_CommonCode> getAllUserInRage(Map<String, Object> params);
	
	public List<AdminUser_CommonCode> getAllUser_CommonCode();
	
	public AdminUser getuserByEmail(String Email);
	
	public AdminUser getUserByID(Integer ID);
	
	public void addNewUser(AdminUser adminUser);
	
	public void updateUser(AdminUser adminUser);
	
	public void deleteUser(AdminUser adminUser);
	
	public int getTotalUser();
}
