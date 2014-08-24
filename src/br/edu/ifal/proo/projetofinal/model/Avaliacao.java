package br.edu.ifal.proo.projetofinal.model;

import java.util.ArrayList;
import java.util.Date;
import br.edu.ifal.proo.projetofinal.dao.AvaliacaoDAO;
import br.edu.ifal.proo.projetofinal.dao.ProfessorDAO;
import br.edu.ifal.proo.projetofinal.model.Verificavel;

public class Avaliacao implements Verificavel{
	
	private String data;
	private String nomeDaProva;
	private String nivel;
	private int situacao;
	private String cpfDoProfessor;
	private String codigo;

	
	
	public Avaliacao(String data, String nomeDaProva, String nivel, int situacao,
			String cpfDoProfessor, String codigo) {	
		this.data = data;
		this.nomeDaProva = nomeDaProva;
		this.nivel = nivel;
		this.situacao = situacao;
		this.cpfDoProfessor = cpfDoProfessor;
		this.codigo = codigo;
	}
	
	public Avaliacao(){
	}
	
	public int obterQuantidade(){
		AvaliacaoDAO dao = new AvaliacaoDAO();
		return dao.count();
	}
	
	public ArrayList listar(){
		AvaliacaoDAO dao = new AvaliacaoDAO();
		return dao.findAll();
	}
	
	public void marcarAvaliacao(){
		AvaliacaoDAO dao = new AvaliacaoDAO(); 
		dao.save(this);
	}
	
	public boolean alterar(){
		AvaliacaoDAO dao = new AvaliacaoDAO();
		return dao.update(this);
	}
	
	public boolean buscar(String codigo){
		AvaliacaoDAO dao = new AvaliacaoDAO();
		return dao.find(codigo);
	}
	
	public boolean mostrar(String cpfAplicador){
		AvaliacaoDAO dao = new AvaliacaoDAO();
		return dao.mostrar(cpfAplicador);
	}
	
	@Override
	public int verifica(int situacao) {
		if(situacao == 1)
			System.out.println("  Prova em andamento...");
		else
			System.out.println("  Prova finalizada!");
		return situacao;
	}
	
	//getters and setters
	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	
	public String getCpfDoProfessor() {
		return cpfDoProfessor;
	}
	
	public void setCpfDoProfessor(String cpfDoProfessor) {
		this.cpfDoProfessor = cpfDoProfessor;
	}
	
	public String getNomeDaProva() {
		return nomeDaProva;
	}

	public void setNomeDaProva(String nomeDaProva) {
		this.nomeDaProva = nomeDaProva;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}


	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}	
	
	
	
}

	