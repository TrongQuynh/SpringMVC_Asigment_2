package com.onlineclass.sysadmin.api;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountAPI {
	
	@GetMapping("/api/acc/curr-role")
	public String getCurrentRole() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String role = "";
		
		if (authentication != null) {
			role = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).findFirst().orElse("");
		}
		System.out.println("{'role' : '" + role + "'}");
		return '"' + role + '"';
	}
}
