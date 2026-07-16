package br.edu.ifpb.isabelly.projetoweb.business.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
	public boolean validarNome(String nome) {
		return nome != null && !nome.trim().isEmpty();
	}

	public boolean validarIdade(int idade) {
		return idade > 0;
	}

	public boolean validarCargaHoraria(int cargaHoraria) {
		return cargaHoraria > 0;
	}
}
