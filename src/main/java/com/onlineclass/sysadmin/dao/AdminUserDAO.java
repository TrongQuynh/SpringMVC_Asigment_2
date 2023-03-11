package com.onlineclass.sysadmin.dao;

import java.util.List;
import java.util.Map;

import com.onlineclass.sysadmin.entity.AdminUser;
import com.onlineclass.sysadmin.entity.AdminUser_CommonCode;

public interface AdminUserDAO {
	
	public List<AdminUser> getAllUser();
	
	public List<AdminUser_CommonCode> getAllUser_CommonCode();
	
	public List<AdminUser_CommonCode> getAllUserInRage(Map<String, Object> params);

	public AdminUser getUserByID(Integer ID);
	
	public AdminUser getuserByEmail(String email);

	public void addNewUser(AdminUser adminUser);

	public void updateUser(AdminUser adminUser);

	public void deleteUser(AdminUser adminUser);
	
	public int getTotalUser();
}
