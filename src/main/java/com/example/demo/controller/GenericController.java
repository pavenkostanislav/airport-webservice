package com.example.demo.controller;


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

import com.example.demo.dao.ICleanAndId;
import com.example.demo.service.GenericService;


public class GenericController<T extends ICleanAndId, U extends CrudRepository<T, Long>> {
	@Autowired
	private U crudRepository;
	private GenericService<T,U> srv;
	
	public GenericController(GenericService<T,U> _srv) {
		this.srv = _srv;
	}
	
	@PostMapping(value = "",
            produces={MediaType.APPLICATION_JSON_VALUE,
            		  MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> postItem(
			@RequestParam(value = "format", defaultValue = "json") String format,
			@RequestBody T body) {
		try {
			return new ResponseEntity<>(srv.set(this.crudRepository, body), Utility.setMediaType(format), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity
					.badRequest()
					.body(Vocabulary.dictionary.get(VocabularyKeys.badRequest));
		}
	}

	@PutMapping(value = "/{id:\\d+}",
            produces={MediaType.APPLICATION_JSON_VALUE,
            		  MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> putItem(
			@RequestParam(value = "format", defaultValue = "json") String format,
			@PathVariable("id") Long id,
			@RequestBody T body) {
		try { 
			return new ResponseEntity<>(srv.put(this.crudRepository, id, body), Utility.setMediaType(format), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity
					.badRequest()
			        .body(Vocabulary.dictionary.get(VocabularyKeys.badRequest));
		}
	}

	@GetMapping(value = "/{id:\\d+}",
            produces={MediaType.APPLICATION_JSON_VALUE, 
                      MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> getItem(
			@RequestParam(value = "format", defaultValue = "json") String format,
			@PathVariable("id") Long id) {	
		try {
			return new ResponseEntity<>(srv.get(this.crudRepository, id), Utility.setMediaType(format), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity
					.badRequest()
					.body(Vocabulary.dictionary.get(VocabularyKeys.badRequest));
		}
	}
	
	@DeleteMapping(value = "/{id:\\d+}")
	public ResponseEntity<Object> deleteItem(@PathVariable("id") Long id) {	
		try { 	
			srv.delete(this.crudRepository, id);
			return ResponseEntity.noContent().build();
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity
					.badRequest()
					.body(Vocabulary.dictionary.get(VocabularyKeys.badRequest));
		}
	}
	
	@PostMapping(value = "/all",
            produces={MediaType.APPLICATION_JSON_VALUE, 
                      MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> getAll(
			@RequestParam(value = "format", defaultValue = "json") String format) {
		try {
			return new ResponseEntity<>(srv.getAll(this.crudRepository), Utility.setMediaType(format), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity
					.badRequest()
					.body(Vocabulary.dictionary.get(VocabularyKeys.badRequest));
		}
	}

}
