package com.example.connect.restcontrollerimpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.connect.constants.ConnectConstants;
import com.example.connect.restcontroller.UserRestController;
import com.example.connect.service.UserService;
import com.example.connect.utils.ConnectUtils;

@RestController
public class UserRestControllerImpl implements UserRestController{

	@Autowired
	UserService userService;
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		
		try {
			return userService.signUp(requestMap);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ConnectUtils.getResponseEntity(ConnectConstants.Some_Thing_Went_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
