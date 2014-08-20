package br.edu.ifal.proo.projetofinal.model;

import br.edu.ifal.proo.projetofinal.dao.AlunoDAO;

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
	
	public Aluno(){
	}
	
	public void cadastrarContratante (){
		AlunoDAO alunodao = new AlunoDAO();
		alunodao.save(this);
	}

	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
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
	
	
}
