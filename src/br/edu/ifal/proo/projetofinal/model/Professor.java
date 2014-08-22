package br.edu.ifal.proo.projetofinal.model;

import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.dao.ProfessorDAO;

public class Professor extends Pessoa implements Verificavel{
	
	public int ministrandoAula;
	
	public Professor(String nome, String cpf, String sexo, int idade,
			String endereco, String cidade, String estado, int ministrandoAula) {
		super(nome, cpf, sexo, idade, endereco, cidade, estado);
		this.ministrandoAula = ministrandoAula;
	}
	
	public Professor(){
	}
	
	public void cadastrarProfessor (){
		ProfessorDAO dao= new ProfessorDAO();
		dao.save(this);
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
	
	public boolean alterarPresenca(){
		ProfessorDAO dao = new ProfessorDAO();
		return dao.updatePresenca(this);
	}
	
	public boolean excluir(String cpf){
		ProfessorDAO dao = new ProfessorDAO();
		return dao.delete(cpf);
	}
	
	@Override
	public int verifica(int ministrandoAula) {
		if(ministrandoAula == 1)
			System.out.println("  Ministrando aula...");
		else			
			System.out.println("  Ainda não está em aula.");
	return ministrandoAula;
	}

	public int getMinistrandoAula() {
		return ministrandoAula;
	}

	public void setMinistrandoAula(int ministrandoAula) {
		this.ministrandoAula = ministrandoAula;
	}
	
}
