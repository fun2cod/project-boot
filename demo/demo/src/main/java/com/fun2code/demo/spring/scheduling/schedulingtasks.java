package com.fun2code.demo.spring.scheduling;

import java.io.File;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fun2code.demo.spring.entity.Country;
import com.fun2code.demo.spring.repository.CountryRepository;
import com.fun2code.demo.spring.repository.PersonRepository;
@Component

public class schedulingtasks {
	
	 @Autowired
	 private CountryRepository r;
	 @Autowired
	 private PersonRepository p;
	 @Scheduled(fixedRate=86400000)
 public void unmarshall() {
	 
	 
	 try {
		  JAXBContext jc= JAXBContext.newInstance(Country.class);
		  Unmarshaller ums=jc.createUnmarshaller();
		 	 System.out.print(" insert the path of Your file xml ");
			 Scanner in = new Scanner(System.in);
			 String s = in. nextLine(); 
		    Country c=(Country)ums.unmarshal(new File(s));
		     r.save(c);
		     System.out.print(" done ");
	 }catch(Exception e) {
		  e.printStackTrace();
		  }
	 }
	 @Scheduled(fixedRate=86400000)
	 public void delete() {
		 p.delete_automatically();
	 }
	
	 
	 }
	 


