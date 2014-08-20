package br.edu.ifal.proo.projetofinal.model;

public class Aluno extends Pessoa{

	private String matricula;
	private int rg;
	private String nivel;
	private boolean assistindoAula = false;
	private Boletim boletim;
	
	public Aluno(String nome, String cpf, String sexo, int idade,
			String endereco, String cidade, String estado,
			String matricula, int rg, String nivel) {
		super(nome, cpf, sexo, idade, endereco, cidade, estado);
		this.matricula = matricula;
		this.rg = rg;
		this.nivel = nivel;
	}
	
	public Boletim getBoletim() {
		return boletim;
	}

	public void setBoletim(Boletim boletim) {
		this.boletim = boletim;
	}

	public void assistirAula(){
		if(assistindoAula == true)
			System.out.println("Assistindo aula...");
		else
			System.out.println("O aluno ainda não chegou.");
	}	
	
	//Teste
}
