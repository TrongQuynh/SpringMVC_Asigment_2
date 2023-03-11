package com.onlineclass.sysadmin.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineclass.sysadmin.entity.AdminUser;
import com.onlineclass.sysadmin.entity.ErrorMessage;
import com.onlineclass.sysadmin.service.AdminUserService;

public class ValidateData {
	
	public static Boolean isEmailValidateRFC5322(String email) {
		// Return true if email is validate

		String regex = "^[a-zA-Z0-9_!#$%&amp;'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	public static boolean isEmailHasFilled(String email) {
		// Return True if email has filled
		return email.equals("") ? false : true;
	}
	 
	public static boolean isUserNameHasFilled(String name) {
		// Return True if name has filled
		return name.equals("") ? false : true;
	}
	
	public static boolean isConfirmPasswordIsSame(String pwd,String cfm_pwd) {
		// Return True if pwd is SAME with cfm_pwd
		return pwd.equals(cfm_pwd);
	}
	
	public static boolean isStatusSelected(int status) {
		// Return True if Status is select
		return status >=1 && status <=5;
	}
	
	public static ErrorMessage validateData(AdminUser adminUser, AdminUserService userService) {
		try {
			
			String email = adminUser.getEmail();
			String name = adminUser.getName();
			String pwd = adminUser.getPassword();
			String cfm_pwd = adminUser.getConfirm_password();
			int status = adminUser.getStatusCD();
			
			if(!ValidateData.isUserNameHasFilled(name)) {
				return new ErrorMessage(200, 1,"username_not_fill");
			}
			
			if(!ValidateData.isEmailHasFilled(email)) {
				return new ErrorMessage(200, 2,"email_not_fill");
			}
			
			if(userService.getuserByEmail(email) != null) {
				return new ErrorMessage(200, 3,"email_already_exsit"); 
			}
			
			if(!ValidateData.isEmailValidateRFC5322(email)) {
				return new ErrorMessage(200, 4,"email_error_format");
			}
			
			if(!ValidateData.isConfirmPasswordIsSame(pwd, cfm_pwd)) {
				return new ErrorMessage(200, 5,"confirm_password");
			}
			
			if(!ValidateData.isStatusSelected(status)) {
				return new ErrorMessage(200, 6,"error_select_status");
			}
			return new ErrorMessage(200, 0,"Success"); 
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
}
