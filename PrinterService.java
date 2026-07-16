package br.edu.ifpb.isabelly.projetoweb.business.service;

import org.springframework.stereotype.Service;

@Service
public class PrinterService {
	public void print(String mensagem) {
		System.out.println(mensagem);
	}
}
