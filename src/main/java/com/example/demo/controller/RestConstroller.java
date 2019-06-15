package com.example.demo.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestConstroller {
	
    @RequestMapping(value = "/helloWorld",
            method=RequestMethod.GET,
            produces={MediaType.APPLICATION_JSON_VALUE, 
                      MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Map<String, String>> getFormat(@RequestParam(value = "format", defaultValue = "json") String format){
        HttpHeaders httpHeaders = new HttpHeaders();
        if(format.equals("xml")){
            httpHeaders.setContentType(MediaType.APPLICATION_XML);
        }
        else{
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        }
        return new ResponseEntity<>(Collections.singletonMap("response", "Hello World"), httpHeaders, HttpStatus.OK);
    }
}
