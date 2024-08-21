package fr.diginamic.digiHello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	 @Autowired
	 public HelloService() {
		 
	 }
	 
	 public String salutations() {
		 return "Je suis la classe de service et je vous dis Bonjour";
	 }

}
