package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@RestController
@RequestMapping("/api")
public class AlienController{
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String main() {
		return "Ok!";
	}
	
	@PutMapping(value = "/alien",
            produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> addAlien(@RequestParam(value = "format", defaultValue = "json") String format, @RequestBody Alien alien) {
		HttpHeaders httpHeaders = new HttpHeaders();
        if(format.equals("xml")){
            httpHeaders.setContentType(MediaType.APPLICATION_XML);
        }
        else{
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        }
		repo.save(alien);
		return new ResponseEntity<>("Ok", httpHeaders, HttpStatus.OK);
	}
	
	@GetMapping(value = "/alien/{aid}",
            produces={MediaType.APPLICATION_JSON_VALUE, 
                      MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Optional<Alien>> getAlien(@RequestParam(value = "format", defaultValue = "json") String format,
											@PathVariable("aid") int aid) {
		HttpHeaders httpHeaders = new HttpHeaders();
        if(format.equals("xml")){
            httpHeaders.setContentType(MediaType.APPLICATION_XML);
        }
        else{
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        }
        Optional<Alien> al = repo.findById(aid);
		return new ResponseEntity<>(al, httpHeaders, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/alien/{aid}")
	public void delAlien(@PathVariable("aid") int aid) {
		repo.deleteById(aid);
		return;
	}
	
	@PostMapping("/aliens")
	public ResponseEntity<Iterable<Alien>> getAliens(@RequestParam(value = "format", defaultValue = "json") String format) {
		HttpHeaders httpHeaders = new HttpHeaders();
        if(format.equals("xml")){
            httpHeaders.setContentType(MediaType.APPLICATION_XML);
        }
        else{
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        }
        Iterable<Alien> als = repo.findAll();
		return new ResponseEntity<>(als, httpHeaders, HttpStatus.OK);
	}
}
