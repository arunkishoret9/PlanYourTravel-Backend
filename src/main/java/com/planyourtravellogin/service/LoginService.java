package com.planyourtravellogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planyourtravellogin.model.User;
import com.planyourtravellogin.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;

	public User saveUser(User user) {
		return loginRepository.save(user);
	}

	public User getUserByEmailId(String emailId) {
		return loginRepository.findByEmailId(emailId);
	}

	public User getUserByEmailIdAndPassword(String email, String password) {
		return loginRepository.findByEmaildAndPassword(email, password);
	}

}
