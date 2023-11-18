package com.example.connect.serviceimpl;

import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.connect.constants.ConnectConstants;
import com.example.connect.dao.UserRepository;
import com.example.connect.model.UserDetails;
import com.example.connect.service.UserService;
import com.example.connect.utils.ConnectUtils;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	@Override
	public ResponseEntity<String> signUp(Map<String, String> requestMap) {
		log.info("Inside SignUp{}", requestMap);
		try {
		if(validateSignUp(requestMap)) {
			UserDetails userDetails = userRepo.findByEmailID(requestMap.get("email"));
			if(Objects.isNull(userDetails)) {
				userRepo.save(getUserFrmMap(requestMap));
				return ConnectUtils.getResponseEntity("Successfully Registered", HttpStatus.OK);
			}
			else {
				return ConnectUtils.getResponseEntity("Email Already Exists", HttpStatus.BAD_REQUEST);
			}
		}
		else {
			return ConnectUtils.getResponseEntity(ConnectConstants.INVALID_DATA, HttpStatus.BAD_REQUEST);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ConnectUtils.getResponseEntity(ConnectConstants.Some_Thing_Went_Wrong, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	private boolean validateSignUp(Map<String, String> requestMap) {
		if(requestMap.containsKey("name") && requestMap.containsKey("email") && requestMap.containsKey("password")) {
			return true;
		}
		else {
			return false;
		}
	}
	private UserDetails getUserFrmMap(Map<String, String> requestMap) {
		UserDetails userDetails = new UserDetails();
		userDetails.setEmail(requestMap.get("email"));
		userDetails.setName(requestMap.get("name"));
		userDetails.setPassword(requestMap.get("password"));
		userDetails.setRole("user");
		userDetails.setStatus("active");
		return userDetails;
	}

}
