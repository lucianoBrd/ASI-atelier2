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
	@Autowired
    CardService cService;
	@Autowired
    UserService uService;
	
	public Boolean buyCard(int id, int idUser) {
		Card c = cService.getCardbyId(id);
		User u = uService.getUser(idUser);
		System.out.println( "  /// " + id + " ///  "+ idUser);
		if (c != null && u != null && c.getIdUser() == null && (u.getSolde() - c.getPrice()) >= 0) {
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
		Card c = cService.getCardbyId(id);
		User u = uService.getUser(idUser);
		
		if (c != null && u != null && c.getIdUser() == idUser) {
			c.setIdUser(null);
			cRepository.save(c);
			
			u.setSolde(u.getSolde() + c.getPrice());
			uRepository.save(u);
			return true;
		} else {
			return false;
		}
	}
	

}
