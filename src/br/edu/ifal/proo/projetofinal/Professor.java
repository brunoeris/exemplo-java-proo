package br.edu.ifal.proo.projetofinal;

public class Professor extends Pessoa{
	
	public boolean ministrandoAula = false;
	
	public Professor(String nome, String cpf, String sexo, int idade,
			String endereco, String cidade, String estado) {
		super(nome, cpf, sexo, idade, endereco, cidade, estado);
	}
	
	public void ministrarAula(){
		if(ministrandoAula == true)
			System.out.println("Ministrando aula...");
		else			
			System.out.println("Ainda não está em aula.");
	}
}
