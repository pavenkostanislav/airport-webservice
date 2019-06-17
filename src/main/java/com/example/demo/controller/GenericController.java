package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
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
import org.springframework.web.bind.annotation.RequestParam;


public class GenericController<T> {
	@Autowired
	CrudRepository<T, Integer> item;
	
	@PutMapping(value = "",
            produces={MediaType.APPLICATION_JSON_VALUE,
            		MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<String> putItem(
			@RequestParam(value = "format", defaultValue = "json") String format,
			@RequestBody T row) {
		item.save(row);
		return new ResponseEntity<>("Ok", Utility.setMediaType(format), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}",
            produces={MediaType.APPLICATION_JSON_VALUE, 
                      MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Optional<T>> getItem(
			@RequestParam(value = "format", defaultValue = "json") String format,
			@PathVariable("id") Integer id) {
        Optional<T> row = item.findById(id);
		return new ResponseEntity<>(row, Utility.setMediaType(format), HttpStatus.OK);
	}

	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteItem(@PathVariable("id") Integer id) {		
		item.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/all",
            produces={MediaType.APPLICATION_JSON_VALUE, 
                    MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Iterable<T>> getAll(
			@RequestParam(value = "format", defaultValue = "json") String format) {
        Iterable<T> rows = item.findAll();
		return new ResponseEntity<>(rows, Utility.setMediaType(format), HttpStatus.OK);
	}

}
