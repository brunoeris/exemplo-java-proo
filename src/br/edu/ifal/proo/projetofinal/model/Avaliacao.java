package br.edu.ifal.proo.projetofinal.model;

import java.util.Date;
import br.edu.ifal.proo.projetofinal.dao.AvaliacaoDAO;
import br.edu.ifal.proo.projetofinal.model.Verificavel;

public class Avaliacao implements Verificavel{
	
	Date data = new Date();
	private String nomeDaProva;
	private int nivel;
	private String tipo;
	private int situacao;

	public Avaliacao(){
	}
	
	public void marcarAvaliacao(){
		AvaliacaoDAO dao = new AvaliacaoDAO(); 
		dao.save(this);
	}
	
	//getters and setters
	public String getNomeDaProva() {
		return nomeDaProva;
	}

	public void setNomeDaProva(String nomeDaProva) {
		this.nomeDaProva = nomeDaProva;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getSituacao() {
		return situacao;
	}

	public void setSituacao(int situacao) {
		this.situacao = situacao;
	}

	@Override
	public int verifica(int situacao) {
		if(situacao == 1)
			System.out.println("Prova em andamento...");
		else
			System.out.println("Prova finalizada!");
		return situacao;
	}
	
	
	
}

	