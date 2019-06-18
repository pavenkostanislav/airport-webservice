package com.example.demo.controller;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.IClean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class GenericController<T extends IClean> {
	@Autowired
	CrudRepository<T, Long> item;
	
	@PostMapping(value = "",
            produces={MediaType.APPLICATION_JSON_VALUE,
            		  MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> postItem(
			@RequestParam(value = "format", defaultValue = "json") String format,
			@RequestBody T row) {
		item.save(row);
		return new ResponseEntity<>("Ok", Utility.setMediaType(format), HttpStatus.OK);
	}

	@PutMapping(value = "/{id:\\d+}",
            produces={MediaType.APPLICATION_JSON_VALUE,
            		  MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<T> putItem(
			@RequestParam(value = "format", defaultValue = "json") String format,
			@PathVariable("id") Long id,
			@RequestBody T body) {
		item.save(body);
		return new ResponseEntity<>(body, Utility.setMediaType(format), HttpStatus.OK);
	}

	@GetMapping(value = "/{id:\\d+}",
            produces={MediaType.APPLICATION_JSON_VALUE, 
                      MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<T> getItem(
			@RequestParam(value = "format", defaultValue = "json") String format,
			@PathVariable("id") Long id) {		
		T obj = item.findById(id).orElseThrow(null);
		obj.clean();
		return new ResponseEntity<>(obj, Utility.setMediaType(format), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id:\\d+}")
	public ResponseEntity<Void> deleteItem(@PathVariable("id") Long id) {		
		item.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/all",
            produces={MediaType.APPLICATION_JSON_VALUE, 
                      MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Iterable<T>> getAll(
			@RequestParam(value = "format", defaultValue = "json") String format) {
		return new ResponseEntity<>(item.findAll(), Utility.setMediaType(format), HttpStatus.OK);
	}

}
