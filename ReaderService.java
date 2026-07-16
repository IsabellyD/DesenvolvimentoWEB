package br.edu.ifpb.isabelly.projetoweb.business.service;

import java.util.Scanner;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {
	private final Scanner sc;

	public ReaderService() {
		super();
		this.sc = new Scanner(System.in);
	}

	public int lerInt() {
		return sc.nextInt();
	}

	public String lerString() {
		sc.nextLine();
		return sc.nextLine();
	}

	public String lerTexto() {
		return sc.nextLine();
	}
}
