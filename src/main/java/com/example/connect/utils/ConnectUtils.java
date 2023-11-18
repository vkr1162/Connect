package com.example.connect.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

public class ConnectUtils {

	private ConnectUtils(){
		
	}
	public static ResponseEntity<String> getResponseEntity(String responseMessage,HttpStatus httpstatus){
		return new ResponseEntity<String>("{\"message\":\""+responseMessage+"\"}" ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
