package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.Card;
import com.sp.model.User;
import com.sp.service.CardService;


@RestController
public class CardRestCrt {
	@Autowired
    CardService cService;
    
    @RequestMapping(method=RequestMethod.GET,value="/cards/{id}")
    public Card getCardbyId(@PathVariable String id) {
    	Card c=cService.getCardbyId(Integer.valueOf(id));
        return c;
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/cards")
    public Iterable<Card> getCardsList() {
    	Iterable<Card> c=cService.getCardsList();
        return c;
    }
    
    @RequestMapping(method=RequestMethod.POST,value="/cards")
    public void addCard(@RequestBody Card card) {
    	cService.addCard(card);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/cards/buy")
    public Iterable<Card> getBuyedCard() {
    	Iterable<Card> c=cService.getBuyedCard();
    	return c;
    	
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/cards/sell/{idUser}")
    public Iterable<Card> getSelledCard(@PathVariable String idUser) {
    	Iterable<Card> c=cService.getSelledCard(Integer.valueOf(idUser));
    	return c;
    	
    }
}
