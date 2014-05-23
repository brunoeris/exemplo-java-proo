package br.ingles.curso;

	public class Boletim_GUI extends Aluno_GUI{
		
		private float nota1;
		private float nota2;
		private float notaFinal;
		
		
		
		public Boletim_GUI() {
			this.nota1 = 0;
			this.nota2 = 0;
			this.notaFinal = (this.nota1+this.nota2)/2;
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
