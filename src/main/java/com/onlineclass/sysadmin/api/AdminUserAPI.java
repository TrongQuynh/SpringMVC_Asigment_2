package com.onlineclass.sysadmin.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineclass.sysadmin.entity.APIRespone_UserList;
import com.onlineclass.sysadmin.entity.AdminUser;
import com.onlineclass.sysadmin.entity.AdminUser_CommonCode;
import com.onlineclass.sysadmin.entity.CommonCode;
import com.onlineclass.sysadmin.entity.ErrorMessage;
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
			System.out.println("Before col: " + column);
			System.out.println("Before sort: " + sort);
			sort = sort == null ? "DESC" : (sort.equals("asc") ? "desc" : "asc");
			System.out.println("After col: " + column);
			System.out.println("After sort: " + sort);
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
	
	@GetMapping("/api/users_code")
	public List<AdminUser_CommonCode> getUsers_commonCode(){
		return userService.getAllUser_CommonCode();
	}
	
	// Status for selection
	@GetMapping("/api/status")
	public List<CommonCode> getAllStatus(){
		return codeService.getAllCommonCodes();
	}
	
	
	
	@GetMapping("/api/test")
	public APIRespone_UserList<List<AdminUser_CommonCode>> test(){
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream("D:\\Code\\Java\\Sping\\Assingment\\Assignment_2\\src\\main\\java\\com\\onlineclass\\sysadmin\\config\\config.properties"));
			int itemPerPage = Integer.parseInt(properties.getProperty("itemPerPage"));
			int currentPage = 1;
			int skip = (itemPerPage * currentPage) - itemPerPage;
			
			Map<String, Object> params = new HashMap<>();
			params.put("limit", itemPerPage);
			params.put("skip", skip);
			
			return new APIRespone_UserList<List<AdminUser_CommonCode>>(itemPerPage, 5,"ASC", userService.getAllUserInRage(params));
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	@DeleteMapping("/api/user")
	public ErrorMessage deleteUser(@RequestParam("id") Integer ID){
		List<String> t = new ArrayList<>();
		t.add("Test");
		return new ErrorMessage(200, "Delete user " + ID);
	}
	
}
