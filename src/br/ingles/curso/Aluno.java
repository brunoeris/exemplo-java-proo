package br.ingles.curso;

public class Aluno {
	
		protected String nome;
		protected int matricula;
		
		public Aluno(String nome, int matricula) {
			super();
			this.nome = nome;
			this.matricula = matricula;
		}
		
		
		public void imprimir(){
			System.out.println("\nNome: "+this.nome);
			System.out.println("Matricula: "+this.matricula);	
		}
			 

}