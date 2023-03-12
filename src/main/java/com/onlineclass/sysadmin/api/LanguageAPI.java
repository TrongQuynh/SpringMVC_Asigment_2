package com.onlineclass.sysadmin.api;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineclass.sysadmin.service.AdminUserService;

@RestController
public class LanguageAPI {
	
	@Autowired
	AdminUserService userService;
	
	@GetMapping("/api/lan/nav-bar")
	public String lan_Navbar(@RequestParam(name = "lan", required = false, defaultValue = "en") String language){
		try {
			Properties en_properties = new Properties();
			en_properties.load(new InputStreamReader(new FileInputStream("D:\\Code\\Java\\Sping\\Assingment\\Assignment_2\\src\\main\\java\\com\\onlineclass\\sysadmin\\properties\\en_vi_Navbar_Language.properties"), StandardCharsets.UTF_8));
			if(language.equals("vi") || language.equals("en")) {
				return language.equals("vi") ? en_properties.getProperty("data_vi") : en_properties.getProperty("data_en");
			}
			return null;
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
	
	@GetMapping("/api/lan/user-list-view")
	public String lan_UserList_view(@RequestParam(name = "lan", required = false, defaultValue = "en") String language){
		try {
			Properties en_properties = new Properties();
			en_properties.load(new InputStreamReader(new FileInputStream("D:\\Code\\Java\\Sping\\Assingment\\Assignment_2\\src\\main\\java\\com\\onlineclass\\sysadmin\\properties\\en_vi_UserList_Language.properties"), StandardCharsets.UTF_8));
			if(language.equals("vi") || language.equals("en")) {
				return language.equals("vi") ? en_properties.getProperty("data_vi") : en_properties.getProperty("data_en");
			}
			return null;
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
	
	@GetMapping("/api/lan/new-update-view")
	public String lan_NewUser_view(@RequestParam(name = "lan", required = false, defaultValue = "en") String language){
		try {
			Properties en_properties = new Properties();
			en_properties.load(new InputStreamReader(new FileInputStream("D:\\Code\\Java\\Sping\\Assingment\\Assignment_2\\src\\main\\java\\com\\onlineclass\\sysadmin\\properties\\en_vi_NewUser_Language.properties"), StandardCharsets.UTF_8));
			if(language.equals("vi") || language.equals("en")) {
				return language.equals("vi") ? en_properties.getProperty("data_vi") : en_properties.getProperty("data_en");
			}
			return null;
		} catch (Exception e) {
			System.out.println(e.toString());
			return e.toString();
		}
	}
	
}
