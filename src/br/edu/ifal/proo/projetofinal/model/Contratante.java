package br.edu.ifal.proo.projetofinal.model;

import br.edu.ifal.proo.projetofinal.dao.ContratanteDAO;

public class Contratante extends Pessoa {

	private boolean pagamento;
	
	public Contratante(String nome, String cpf, String sexo, int idade,
			String endereco, String cidade, String estado) {
		super(nome, cpf, sexo, idade, endereco, cidade, estado);
	}
	
	public void cadastrarContratante (){
		ContratanteDAO contratantedao = new ContratanteDAO();
		contratantedao.save(this);
	}
	
	public void pago(){
		if (pagamento == true)
			System.out.println("Pagamento OK!");
		else
			System.out.println("Pagamento em atraso.");
	}
	
	//get e set
	public boolean isPagamento() {
		return pagamento;
	}

	public void setPagamento(boolean pagamento) {
		this.pagamento = pagamento;
	}
	
	
}
