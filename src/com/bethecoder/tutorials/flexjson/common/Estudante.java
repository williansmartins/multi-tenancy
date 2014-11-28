package com.bethecoder.tutorials.flexjson.common;

import java.util.Date;

public class Estudante {

	private String nome;
	private String sobrenome;
	private int idade;
	private Date nascimento;
	
	public Estudante() {
	}

	
	public Estudante(String nome, String sobrenome, int idade, Date nascimento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		this.nascimento = nascimento;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	

}
