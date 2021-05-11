package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.repository.CardRepository;
import com.sp.repository.UserRepository;

@Service
public class MarketService {
    
	@Autowired
	CardRepository cRepository;
	@Autowired
	UserRepository uRepository;
	
	public Boolean buyCard(int id, int idUser) {
		Card c = this.getCard(id);
		User u = this.getUser(idUser);
		
		if (c != null && u != null && c.getIdUser() == -1 && (u.getSolde() - c.getPrice()) > 0) {
			c.setIdUser(idUser);
			cRepository.save(c);
			
			u.setSolde(u.getSolde() - c.getPrice());
			uRepository.save(u);
			return true;
		} else {
			return false;
		}
	}

	public Boolean sellCard(int id, int idUser) {
		Card c = this.getCard(id);
		User u = this.getUser(idUser);
		
		if (c != null && u != null && c.getIdUser() == idUser) {
			c.setIdUser(-1);
			cRepository.save(c);
			
			u.setSolde(u.getSolde() + c.getPrice());
			uRepository.save(u);
			return true;
		} else {
			return false;
		}
	}
	
	public User getUser(int id) {
		java.util.Optional<User> uOpt =uRepository.findById(id);
		if (uOpt.isPresent()) {
			return uOpt.get();
		}else {
			return null;
		}
	}
	
	public Card getCard(int id) {
		java.util.Optional<Card> cOpt =cRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		}else {
			return null;
		}
	}

}
