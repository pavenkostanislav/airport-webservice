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


public class GenericController<T extends ICleanAndId> {
	@Autowired
	CrudRepository<T, Long> item;
	
	@PostMapping(value = "",
            produces={MediaType.APPLICATION_JSON_VALUE,
            		  MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Object> postItem(
			@RequestParam(value = "format", defaultValue = "json") String format,
			@RequestBody T row) {
		try { 
			T objFromDb = item.save(row);
		objFromDb.clean();
		return new ResponseEntity<>(objFromDb, Utility.setMediaType(format), HttpStatus.OK);
	} catch(Exception e) {
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
			T obj = item.findById(id).orElseThrow(null);
			if(obj == null) {
				throw new Exception("Data is not found");
			}
			T objFromDb = item.save(body);
			objFromDb.clean();
			return new ResponseEntity<>(objFromDb, Utility.setMediaType(format), HttpStatus.OK);
		} catch(Exception e) {
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
		T obj = item.findById(id).orElseThrow(null);
		obj.clean();
		return new ResponseEntity<>(obj, Utility.setMediaType(format), HttpStatus.OK);
	} catch(Exception e) {
		return ResponseEntity
				.badRequest()
		        .body(Vocabulary.dictionary.get(VocabularyKeys.badRequest));
	}
	}
	
	@DeleteMapping(value = "/{id:\\d+}")
	public ResponseEntity<Object> deleteItem(@PathVariable("id") Long id) {	
		try { 	
		item.deleteById(id);
		return ResponseEntity.noContent().build();
	} catch(Exception e) {
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
		Iterable<T> collection = item.findAll();
		
		collection.forEach(row -> {
		    row.clean();
		});
		return new ResponseEntity<>(item.findAll(), Utility.setMediaType(format), HttpStatus.OK);
	} catch(Exception e) {
		return ResponseEntity
				.badRequest()
		        .body(Vocabulary.dictionary.get(VocabularyKeys.badRequest));
	}
	}

}
