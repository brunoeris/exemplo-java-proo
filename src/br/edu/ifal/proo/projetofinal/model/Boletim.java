package br.edu.ifal.proo.projetofinal.model;

import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.dao.AlunoDAO;
import br.edu.ifal.proo.projetofinal.dao.BoletimDAO;

public class Boletim{
	private String matricula;
	private double notaA;
	private double notaB;
	private double media;
	
	public Boletim(double notaA, double notaB, double media) 
	{
		this.notaA = notaA;
		this.notaB = notaB;
		this.media = media;
	}
	
	public Boletim(){
	}
	
	public void cadastrarBoletim (){
		BoletimDAO dao = new BoletimDAO();
		dao.save(this);
	}
	
	public boolean buscar(String matricula){
		BoletimDAO dao = new BoletimDAO();
		return dao.find(matricula);
	}
	
	public boolean alterar(){
		BoletimDAO dao = new BoletimDAO();
		return dao.update(this);
	}
	
	//getters and setters
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getNotaA() 
	{
		return notaA;
	}
	public void setNotaA(double notaA) 
	{
		this.notaA = notaA;
	}
	public double getNotaB() 
	{
		return notaB;
	}
	public void setNotaB(double notaB) 
	{
		this.notaB = notaB;
	}
	public double getMedia() 
	{
		return media;
	}
	public void setMedia(double media) 
	{
		this.media = media;
	}
	
	
}