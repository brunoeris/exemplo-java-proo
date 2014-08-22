package br.edu.ifal.proo.projetofinal.model;

import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.dao.AlunoDAO;
import br.edu.ifal.proo.projetofinal.dao.SalaDAO;

public class Sala 
{
	public int numero;
	public int qtdCadeiras;
	public int ocupada;
	
	public Sala(int numero, int qtdCadeiras) 
	{
		this.numero = numero;
		this.qtdCadeiras = qtdCadeiras;
	}
	
	public Sala(){
	}
	
	public void cadastrarSala(){
		SalaDAO dao = new SalaDAO();
		dao.save(this);
	}
	
	public ArrayList listar(){
		SalaDAO dao = new SalaDAO();
		return dao.findAll();
	}
	
	public void verificaSala()
	{
		if(ocupada == 1)
			System.out.println("Sala Ocupada");
		else
			System.out.println("Sala Vazia");
	}
	
	public boolean alterar(){
		SalaDAO dao = new SalaDAO();
		return dao.update(this);
	}
	
	public boolean buscar(int numero){
		SalaDAO dao = new SalaDAO();
		return dao.find(numero);
	}
	
	//getters and setters
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getQtdCadeiras() {
		return qtdCadeiras;
	}

	public void setQtdCadeiras(int qtdCadeiras) {
		this.qtdCadeiras = qtdCadeiras;
	}

	public int getOcupada() {
		return ocupada;
	}

	public void setOcupada(int ocupada) {
		this.ocupada = ocupada;
	}
	
	
	
}
