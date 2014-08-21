package br.edu.ifal.proo.projetofinal.model;


import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.dao.ContratanteDAO;

public class Contratante extends Pessoa {

	private int situacao;
	
	public Contratante(String nome, String cpf, String sexo, int idade,
			String endereco, String cidade, String estado, int situacao) {
		super(nome, cpf, sexo, idade, endereco, cidade, estado);
		this.situacao = situacao;
	}
	
	
	public Contratante(){
	}
	
	public void cadastrarContratante (){
		ContratanteDAO contratantedao = new ContratanteDAO();
		contratantedao.save(this);
	}
	
	public int obterQuantidade(){
		ContratanteDAO dao = new ContratanteDAO();
		return dao.count();
	}
	
	public ArrayList listar(){
		ContratanteDAO dao = new ContratanteDAO();
		return dao.findAll();
	}
	
	public boolean buscar(String cpf){
		ContratanteDAO dao = new ContratanteDAO();
		return dao.find(cpf);
	}
	
	public boolean mostrar(String cpf){
		ContratanteDAO dao = new ContratanteDAO();
		return dao.mostrar(cpf);
	}
	
	public boolean alterar(){
		ContratanteDAO dao = new ContratanteDAO();
		return dao.update(this);
	}
	
	public boolean alterarPgto(){
		ContratanteDAO dao = new ContratanteDAO();
		return dao.updatePgto(this);
	}
	
	public boolean excluir(String cpf){
		ContratanteDAO dao = new ContratanteDAO();
		return dao.delete(cpf);
	}

	public int getSituacao() {
		return situacao;
	}


	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}
	
	
	
}
