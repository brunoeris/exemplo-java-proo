package br.edu.ifal.proo.projetofinal.model;

public class Pessoa {

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
	
	//getters and setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
