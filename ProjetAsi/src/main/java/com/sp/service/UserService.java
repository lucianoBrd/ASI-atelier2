package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.repository.CardRepository;
import com.sp.repository.UserRepository;

@Service
public class UserService {
    
	@Autowired
	UserRepository uRepository;
	public void addUser(User u) {
		User createdCard=uRepository.save(u);
		System.out.println(createdCard);
	}
	
	public User getUser(int id) {
		java.util.Optional<User> uOpt =uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}

}

