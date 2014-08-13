package br.edu.ifal.proo.projetofinal;

public class Aluno extends Pessoa{

	private String matricula;
	private int rg;
	private int nivel;
	private boolean assistindoAula = false;
	
	public Aluno(String nome, String cpf, String sexo, int idade,
			String endereco, String cidade, String estado,
			String matricula, int rg, int nivel) {
		super(nome, cpf, sexo, idade, endereco, cidade, estado);
		this.matricula = matricula;
		this.rg = rg;
		this.nivel = nivel;
	}
	
	public void assistirAula(){
		if(assistindoAula == true)
			System.out.println("Assistindo aula...");
		else
			System.out.println("O aluno ainda não chegou.");
	}	
	
	
}
