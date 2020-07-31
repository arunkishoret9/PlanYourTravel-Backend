package com.planyourtravellogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planyourtravellogin.model.User;
import com.planyourtravellogin.service.LoginService;

@RestController
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/register-user")
	public User login(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		User userEmail = null;
		if (!StringUtils.isEmpty(tempEmailId)) {
			userEmail = loginService.getUserByEmailId(tempEmailId);
			if (userEmail != null) {
				throw new Exception("User with " + tempEmailId + "already exist");
			}
		}
		User userResult = loginService.saveUser(user);
		return userResult;
	}

	@GetMapping
	public User loginUser(@RequestBody User user) {
		String userEmailId = user.getEmailId();
		String userPassword = user.getPassword();
		User userResult = null;
		if (!StringUtils.isEmpty(userEmailId) && !StringUtils.isEmpty(userPassword)) {
			userResult = loginService.getUserByEmailIdAndPassword(userEmailId, userPassword);
		}
		return userResult;
	}
}
