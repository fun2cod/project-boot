package com.fun2code.demo.spring.PersonController;

import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fun2code.demo.spring.entity.Person;
import com.fun2code.demo.spring.repository.PersonRepository;

@RestController
@RequestMapping("/")
@Controller
public class PersonController {
	private  Logger logger ;
	 @Autowired
	private PersonRepository p;
	
	//select all persons
	 @GetMapping("/person")
	    public ResponseEntity<List<Person>> findAll() {
	        return ResponseEntity.ok(p.findAll());
	    }
	 // insert new person
	 @PostMapping("/person")
	    public ResponseEntity<Person>create(@Valid @RequestBody Person person) {
	        return ResponseEntity.ok(p.save(person));
	    }
	 // getbyid
	    @GetMapping("/person/{id}")
	    public ResponseEntity<Person> findById(@PathVariable int id) {
	        Optional<Person> stock = p.findById(id);
	        if (!stock.isPresent()) {
	        	logger .error("Id " + id + " is not existed");
	            ResponseEntity.badRequest().build();
	        }

	        return ResponseEntity.ok(stock.get());
	    }


	 //delete person
	    @DeleteMapping("/person/{id}")
	    public ResponseEntity<Person>delete(@PathVariable int id) {
	        if (!p.findById(id).isPresent()) {
	        	logger.error("Id " + id + " is not existed");
	            ResponseEntity.badRequest().build();
	        }

	        p.deleteById(id);

	        return ResponseEntity.ok().build();
	    }
	 //update person
	    @PutMapping("/person/{id}")
	    public ResponseEntity<Person> update(@PathVariable int id, @Valid @RequestBody Person person) {
	        if (!p.findById(id).isPresent()) {
	        	logger.error("Id " + id + " is not existed");
	            ResponseEntity.badRequest().build();
	        }

	        return ResponseEntity.ok(p.save( person));
	    }
	    
	    
}
