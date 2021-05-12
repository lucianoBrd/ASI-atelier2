package com.sp.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sp.model.User;
import com.sp.model.UserDto;
import com.sp.service.UserService;


@RestController
public class UserRestCrt {
	@Autowired
    UserService uService;
	
	@Autowired
    private ModelMapper modelMapper;
    
    @RequestMapping(method=RequestMethod.POST,value="/users")
    public void addUser(@RequestBody User user) {
    	uService.addUser(user);
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/users/{id}")
    public UserDto getUser(@PathVariable String id) {
    	User u=uService.getUser(Integer.valueOf(id));
        return convertToDto(u);
    }
    
    private UserDto convertToDto(User user) {
    	UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }
    
    private User convertToEntity(UserDto userDto) {
    	User user = modelMapper.map(userDto, User.class);
     
        
        return user;
    }

}

