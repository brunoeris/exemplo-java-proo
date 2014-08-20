package br.edu.ifal.proo.projetofinal.model;

import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.dao.ContratanteDAO;

public class Contratante extends Pessoa {

	private int pagamento;
	
	public Contratante(String nome, String cpf, String sexo, int idade,
			String endereco, String cidade, String estado, int pagamento) {
		super(nome, cpf, sexo, idade, endereco, cidade, estado);
		pagamento = this.pagamento;
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


	public int getPagamento() {
		return pagamento;
	}


	public void setPagamento(int pagamento) {
		this.pagamento = pagamento;
	}
	
	
	
}
