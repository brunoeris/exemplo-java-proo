package br.ingles.curso;

import javax.swing.JOptionPane;

public class Aluno_GUI {

	protected String nome;
	protected int matricula;
	
	public Aluno_GUI() {
		this.nome = "";
		this.matricula = 0;
	}

	public void imprimir(){
		JOptionPane.showMessageDialog(null, "Nome: "+this.nome+"\nMatricula: "+this.matricula);	
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
