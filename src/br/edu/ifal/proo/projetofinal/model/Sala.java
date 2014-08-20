package br.edu.ifal.proo.projetofinal.model;

public class Sala 
{
	public int numero;
	public int qtdCadeiras;
	public boolean ocupada = false;
	
	public Sala(int numero, int qtdCadeiras) 
	{
		this.numero = numero;
		this.qtdCadeiras = qtdCadeiras;
	}
	
	public void verificaSala()
	{
		if(ocupada == true)
			System.out.println("Sala Ocupada");
		else
			System.out.println("Sala Vazia");
	}
	//commit
}
