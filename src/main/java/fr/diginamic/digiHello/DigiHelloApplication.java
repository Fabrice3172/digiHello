package fr.diginamic.digiHello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.diginamic.digiHello.Config.Config;

@SpringBootApplication
public class DigiHelloApplication implements CommandLineRunner {
	
	@Autowired
	Config config;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DigiHelloApplication.class, args);
		System.out.println();
	}
	
	public void run(String... args) throws Exception {
		System.out.println(config);
	}

}
