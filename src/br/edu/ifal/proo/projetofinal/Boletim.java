package br.edu.ifal.proo.projetofinal;

public class Boletim extends Aluno{
	private double notaA;
	private double notaB;
	private double media;
	public Boletim(String nome, String cpf, String sexo, int idade,
			String endereco, String cidade, String estado, String matricula,
			int rg, int nivel, double notaA, double notaB, double media) {
		super(nome, cpf, sexo, idade, endereco, cidade, estado, matricula, rg,
				nivel);
		this.notaA = notaA;
		this.notaB = notaB;
		this.media = media;
	}
	
	//getters and setters
	public double getNotaA() {
		return notaA;
	}
	public void setNotaA(double notaA) {
		this.notaA = notaA;
	}
	public double getNotaB() {
		return notaB;
	}
	public void setNotaB(double notaB) {
		this.notaB = notaB;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}
	
	
}

