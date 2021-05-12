package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.service.AuthService;
import com.sp.service.MarketService;

@RestController
public class AuthRestCrt {
	@Autowired
	AuthService aService;
    
	@RequestMapping(method=RequestMethod.GET,value="/login")
   public Integer login(@RequestParam String surname, @RequestParam String password) {
  	 
       return aService.login(surname, password);
   }

}