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
    public boolean addUser(@RequestBody User user) {
    	
    	uService.addUser(user);
    	
    	return true;
    }
    
    @RequestMapping(method=RequestMethod.GET,value="/users/{token}")
    public UserDto getUser(@PathVariable String token) {
    	User u=uService.getUser(token);
        return convertToDto(u);
    }
    
    private UserDto convertToDto(User user) {
    	if (user != null) {
	    	UserDto userDto = modelMapper.map(user, UserDto.class);
	        return userDto;
    	}
    	return new UserDto();
    }
    
    private User convertToEntity(UserDto userDto) {
    	User user = modelMapper.map(userDto, User.class);
     
        
        return user;
    }

}

