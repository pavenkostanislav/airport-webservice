package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class Utility {

	public static HttpHeaders setMediaType(String format) {
		HttpHeaders httpHeaders = new HttpHeaders();
        if(format.equals("xml")){
            httpHeaders.setContentType(MediaType.APPLICATION_XML);
        } else {
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        }
		return httpHeaders;
	}
}
