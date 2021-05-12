package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.User;
import com.sp.repository.UserRepository;

@Service
public class AuthService {
    
	@Autowired
	UserRepository uRepository;
	
	public Integer login(String surname, String password) {
		java.util.Optional<User> uOpt = uRepository.findBySurnameAndPassword(surname, password);
		if (uOpt.isPresent()) {
			return uOpt.get().getId();
		}else {
			return null;
		}
	}

}