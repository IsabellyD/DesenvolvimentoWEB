package br.edu.ifpb.isabelly.projetoweb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetowebApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ProjetowebApplication.class, args);
	}
  
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Oi, esse é o meu primeiro projeto!");
	}
}
