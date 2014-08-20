package br.edu.ifal.proo.projetofinal.model;

import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.dao.ProfessorDAO;

public class Professor extends Pessoa{
	
	public boolean ministrandoAula = false;
	
	public Professor(String nome, String cpf, String sexo, int idade,
			String endereco, String cidade, String estado) {
		super(nome, cpf, sexo, idade, endereco, cidade, estado);
	}
	
	public Professor(){
	}
	
	public void cadastrarProfessor (){
		ProfessorDAO alunodao = new ProfessorDAO();
		alunodao.save(this);
	}
	
	public int obterQuantidade(){
		ProfessorDAO dao = new ProfessorDAO();
		return dao.count();
	}
	
	public ArrayList listar(){
		ProfessorDAO dao = new ProfessorDAO();
		return dao.findAll();
	}
	
	public boolean buscar(String cpf){
		ProfessorDAO dao = new ProfessorDAO();
		return dao.find(cpf);
	}
	
	public boolean mostrar(String cpf){
		ProfessorDAO dao = new ProfessorDAO();
		return dao.mostrar(cpf);
	}
	
	public boolean alterar(){
		ProfessorDAO dao = new ProfessorDAO();
		return dao.update(this);
	}
	
	public boolean excluir(String cpf){
		ProfessorDAO dao = new ProfessorDAO();
		return dao.delete(cpf);
	}
	
	public void ministrarAula(){
		if(ministrandoAula == true)
			System.out.println("Ministrando aula...");
		else			
			System.out.println("Ainda n�o est� em aula.");
	}
}
