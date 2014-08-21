package br.edu.ifal.proo.projetofinal.model;

import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.dao.AlunoDAO;
import br.edu.ifal.proo.projetofinal.model.Boletim;

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
	this.boletim = new Boletim();
	}
	
	public Aluno(String nome, String matricula, double notaA, double notaB,
			double media) {
		this.nome = nome;
		this.matricula = matricula;
		this.boletim = new Boletim(notaA,notaB,media);
	}

	public void cadastrarAluno (){
		AlunoDAO alunodao = new AlunoDAO();
		alunodao.save(this);
	}
	
	public int obterQuantidade(){
		AlunoDAO dao = new AlunoDAO();
		return dao.count();
	}
	
	public ArrayList listar(){
		AlunoDAO dao = new AlunoDAO();
		return dao.findAll();
	}
	
	public boolean buscar(String matricula){
		AlunoDAO dao = new AlunoDAO();
		return dao.find(matricula);
	}
	
	public boolean mostrar(String matricula){
		AlunoDAO dao = new AlunoDAO();
		return dao.mostrar(matricula);
	}
	
	public Aluno mostrarBoletim(String matricula){
		AlunoDAO dao = new AlunoDAO();
		return dao.mostrarBoletim(matricula);
	}
	
	public boolean alterar(){
		AlunoDAO dao = new AlunoDAO();
		return dao.update(this);
	}
	
	public boolean excluir(String matricula){
		AlunoDAO dao = new AlunoDAO();
		return dao.delete(matricula);
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
