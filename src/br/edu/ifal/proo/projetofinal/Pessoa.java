package br.edu.ifal.proo.projetofinal;

abstract class Pessoa {

	protected String nome;
	protected String cpf;
	protected String sexo;
	protected int idade;
	protected String endereco;
	protected String cidade;
	protected String estado;
	
	public Pessoa(String nome, String cpf, String sexo,int idade,
			String endereco, String cidade, String estado){
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.idade = idade;
		this.endereco = endereco;
		this.cidade = cidade;
		this.estado = estado;
	}

	
}
