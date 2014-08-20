package br.edu.ifal.proo.projetofinal.model;

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