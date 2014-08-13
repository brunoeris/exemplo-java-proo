package br.edu.ifal.proo.projetofinal;

import java.util.Date;

public class Avaliação extends Aluno{
	Date data = new Date();
	private String nomeDaProva;
	private int nivel;
	private double nota;
	private String tipo;
	
	public Avaliação(String nome, String cpf, String sexo, int idade,
			String endereco, String cidade, String estado, String matricula,
			int rg, int nivel, Date data, String nomeDaProva, int nivel2,
			double nota, String tipo) {
		super(nome, cpf, sexo, idade, endereco, cidade, estado, matricula, rg,
				nivel);
		this.data = data;
		this.nomeDaProva = nomeDaProva;
		nivel = nivel2;
		this.nota = nota;
		this.tipo = tipo;
	}
	
	
	
}
