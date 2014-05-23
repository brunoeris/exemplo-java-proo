package br.ingles.curso;

public class Aluno {
	
		protected String nome;
		protected int matricula;
		
		public Aluno(String nome, int matricula) {
			this.nome = nome;
			this.matricula = matricula;
		}
	
		public void imprimir(){
			System.out.println("\nNome: "+this.nome);
			System.out.println("Matricula: "+this.matricula);	
		}
		
		public void excluirAluno(){
			this.nome = " ";
			this.matricula = 0;
		}

		//getters and setters
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int getMatricula() {
			return matricula;
		}

		public void setMatricula(int matricula) {
			this.matricula = matricula;
		}

}
		


