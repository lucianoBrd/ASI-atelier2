package com.sp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.User;
import com.sp.service.MarketService;
import com.sp.service.UserService;

 @RestController
 public class MarketRestCrt {
 	@Autowired
     MarketService mService;
     
 	@RequestMapping(method=RequestMethod.POST,value="/market/buy/{id}/{idUser}")
    public Boolean buyCard(@PathVariable String id, @PathVariable String idUser) {
   	 
        return mService.buyCard(Integer.valueOf(id), Integer.valueOf(idUser));
    }
     
     @RequestMapping(method=RequestMethod.POST,value="/market/sell/{id}/{idUser}")
     public Boolean sellCard(@PathVariable String id, @PathVariable String idUser) {
    	 
         return mService.sellCard(Integer.valueOf(id), Integer.valueOf(idUser));
     }

 }
