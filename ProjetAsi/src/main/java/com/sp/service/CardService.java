package com.sp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;

@Service
public class CardService {
    
	@Autowired
	CardRepository cRepository;
	public void addCard(Card c) {
		Card createdCard=cRepository.save(c);
		System.out.println(createdCard);
	}
	
	public Card getCardbyId(int id) {
		java.util.Optional<Card> cOpt = cRepository.findById(id);
		if (cOpt.isPresent()) {
			return cOpt.get();
		}else {
			return null;
		}
	}
	
	public Iterable<Card> getCardsList() {
		Iterable<Card> cOpt =cRepository.findAll();

		return cOpt;
	}

	public Iterable<Card> getBuyedCard() {
		Iterable<Card> cOpt =cRepository.findByIdUser(null);
		return cOpt;
	}

	public Iterable<Card> getSelledCard(int idUser) {
		Iterable<Card> cOpt =cRepository.findByIdUser(idUser);
		return cOpt;
	}
	
		
}
