package com.onlineclass.sysadmin.api;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineclass.sysadmin.entity.APIRespone_UserList;
import com.onlineclass.sysadmin.entity.AdminUser;
import com.onlineclass.sysadmin.entity.AdminUser_CommonCode;
import com.onlineclass.sysadmin.entity.CommonCode;
import com.onlineclass.sysadmin.entity.ErrorMessage;
import com.onlineclass.sysadmin.helper.Helper;
import com.onlineclass.sysadmin.helper.ValidateData;
import com.onlineclass.sysadmin.service.AdminUserService;
import com.onlineclass.sysadmin.service.CommonCodeService;

@RestController
public class AdminUserAPI {
	
	@Autowired
	AdminUserService userService;
	
	
	@Autowired
	CommonCodeService codeService;

	@GetMapping("/api/users")
	public APIRespone_UserList<List<AdminUser_CommonCode>> getUsers(
			@RequestParam(name = "page", required = false, defaultValue = "1") String strPage,
			@RequestParam(name = "col", required = false, defaultValue = "ID") String column,
			@RequestParam(name = "sort", required = false) String sort){
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("D:\\Code\\Java\\Sping\\Assingment\\Assignment_2\\src\\main\\java\\com\\onlineclass\\sysadmin\\config\\config.properties"));
			
			int itemPerPage = Integer.parseInt(properties.getProperty("itemPerPage"));
			int totalUsers = userService.getTotalUser();
			int currentPage = Integer.parseInt(strPage);
			int totalPage = (int) Math.ceil((float)totalUsers/(float)itemPerPage);
			int skip = (itemPerPage * currentPage) - itemPerPage;

			sort = sort == null ? "DESC" : (sort.equals("asc") ? "desc" : "asc");

			Map<String, Object> params = new HashMap<>();
			params.put("limit", itemPerPage);
			params.put("skip", skip);
			params.put("sort", sort);
			params.put("column", column);
			
			return new APIRespone_UserList<List<AdminUser_CommonCode>>(totalPage, currentPage, sort,userService.getAllUserInRage(params));
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}

	}
	
	@GetMapping("/api/user")
	public AdminUser getUserByID(@RequestParam(name = "id", required = true) Integer ID) {
		return userService.getUserByID(ID);
	}
	
	@PostMapping("/api/user")
	public ErrorMessage addNewUser(@RequestBody AdminUser adminUser) {
		try {
			ErrorMessage resultValidate = ValidateData.validateNewUserData(adminUser, userService);
			if(resultValidate != null && resultValidate.getErrorCode() == 0) {
				if(!adminUser.getPassword().equals("")) {
					adminUser.setPassword(Helper.encryptPassword(adminUser.getPassword()));
				}
				userService.addNewUser(adminUser);
				return new ErrorMessage(200, "Success");
			}
			return resultValidate;

		} catch (Exception e) {
			System.out.println(e.toString());
			return new ErrorMessage(200, -1,"Error when add new user");
		}
	}
	
	@PatchMapping("/api/user/{id}")
	public ErrorMessage updateUserData(@PathVariable Integer id, @RequestBody AdminUser adminUser) {
		try {
			System.out.println("Call API update user");
			System.out.println(adminUser.toString());
			ErrorMessage resultValidate = ValidateData.validateUpdateUserData(adminUser);
			if(resultValidate != null && resultValidate.getErrorCode() == 0) {
				userService.updateUser(adminUser);
				return new ErrorMessage(200, "Success");
			}
			return resultValidate;
		} catch (Exception e) {
			 System.out.println(e.toString());
			return new ErrorMessage(200, -1,"Error when Update user");
		}
	}
	
	// Status for selection
	@GetMapping("/api/status")
	public List<CommonCode> getAllStatus(){
		return codeService.getAllCommonCodes();
	}
	
	@DeleteMapping("/api/user/{id}")
	public ErrorMessage deleteUser(@PathVariable Integer id){
		try {
			System.out.println("Call API Delete " + id);
			java.util.Date date= new java.util.Date();
			AdminUser adminUser = userService.getUserByID(id);
			if(adminUser == null) {
				return new ErrorMessage(200, -1,"Error when delete user");
			}
			
			adminUser.setDeletedAt((new Timestamp(date.getTime())));
			System.out.println(adminUser.toString());
			userService.deleteUser(adminUser);
			return new ErrorMessage(200, 0,"Delete user " + id + " success!");
		} catch (Exception e) {
			System.out.println(e.toString());
			return new ErrorMessage(200, -1,"Error when delete user");
		}
	}
	
	@GetMapping("/api/error-message")
	public ErrorMessage getErrorMeaage(@RequestParam("errorCode") Integer errorCode,@RequestParam("language") String language,@RequestParam("msg") String err_msg){
		try {
			/* 
			 * -1 - getError
			 * 0 - Success
			 * 1 - username_not_fill
			 * 2 - email_not_fill
			 * 3 - email_already_exsit
			 * 4 - email_error_format
			 * 5 - confirm_password
			 * 6 - error_select_status
			 * */
			System.out.println("/api/error-message");
			System.out.println(errorCode + " - " + language + " - " + err_msg);
			
			if(language.equals("vi") || language.equals("en")) {
				Properties en_properties = new Properties();
				en_properties.load(new FileInputStream("D:\\Code\\Java\\Sping\\Assingment\\Assignment_2\\src\\main\\java\\com\\onlineclass\\sysadmin\\properties\\en_ErrorMessage.properties"));
				
				Properties vi_properties = new Properties();
				vi_properties.load(new FileInputStream("D:\\Code\\Java\\Sping\\Assingment\\Assignment_2\\src\\main\\java\\com\\onlineclass\\sysadmin\\properties\\vi_ErrorMessage.properties"));
				
				return new ErrorMessage(200, errorCode,language.equals("en") ? en_properties.getProperty(err_msg) : vi_properties.getProperty(err_msg));
				/*
				switch(errorCode) {
					case 1:
						return new ErrorMessage(200, language.equals("en") ? en_properties.getProperty("email_not_fill") : vi_properties.getProperty("email_not_fill"));
					case 2:
						return new ErrorMessage(200, language.equals("en") ? en_properties.getProperty("username_not_fill") : vi_properties.getProperty("username_not_fill"));
					case 3:
						return new ErrorMessage(200, language.equals("en") ? en_properties.getProperty("email_already_exsit") : vi_properties.getProperty("email_already_exsit"));
					case 4:
						return new ErrorMessage(200, language.equals("en") ? en_properties.getProperty("email_error_format") : vi_properties.getProperty("email_error_format"));
					case 5: 
						return new ErrorMessage(200, language.equals("en") ? en_properties.getProperty("confirm_password") : vi_properties.getProperty("confirm_password"));					
				}
				*/
			}
			return new ErrorMessage(200, "Error");
		} catch (Exception e) {
			return new ErrorMessage(200, "Success");
		}
	}
	
	// Can Delete
	
	@GetMapping("/api/test")
	public String test(){
		try {
			Properties en_properties = new Properties();
			en_properties.load(new InputStreamReader(new FileInputStream("D:\\Code\\Java\\Sping\\Assingment\\Assignment_2\\src\\main\\java\\com\\onlineclass\\sysadmin\\properties\\en_vi_Navbar_Language.properties"), "UTF-8"));
			return en_properties.getProperty("data_vi");
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
	
	
	
}
