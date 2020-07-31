package com.planyourtravellogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.planyourtravellogin.model.User;

public interface LoginRepository extends JpaRepository<User, Integer> {

	public User findByEmailId(String emailId);

	public User findByEmaildAndPassword(String email, String password);

}
