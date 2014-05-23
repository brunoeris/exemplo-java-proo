package br.ingles.curso;

public class Boletim extends Aluno{
	
	private float nota1;
	private float nota2;
	private float notaFinal;
	
	
	public Boletim(String nome, int matricula,float nota1, float nota2){
		super (nome,matricula);
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.notaFinal = (this.nota1+this.nota2)/2;
	}
	
	public void imprimirBoletim(){
		System.out.println("NOTAS");
		System.out.println("Nome: "+super.nome);
		System.out.println("Matricula: "+super.matricula);
		System.out.println("Nota da primeira prova: "+getNota1());
		System.out.println("Nota da segunda prova: "+getNota2());
		System.out.println("\nMÉDIA FINAL: "+getNotaFinal());
		
	}
	
	
	//getters and setters
	
	public float getNota1() {
		return nota1;
	}
	public void setNota1(float nota1) {
		this.nota1 = nota1;
	}
	public float getNota2() {
		return nota2;
	}
	public void setNota2(float nota2) {
		this.nota2 = nota2;
	}
	public float getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(float notaFinal) {
		this.notaFinal = notaFinal;
	}
	
	
	

}
