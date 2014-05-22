package br.ingles.curso;

import java.util.Scanner;

public class Secretaria {

	private static Scanner leitor;
	
	public static void main(String[]args) {
		
		//cadastrarAluno();
		
		leitor = new Scanner (System.in);
		
		System.out.println("Digite o nome: ");
		String nome = leitor.next();
		System.out.println("Digite a matricula: ");
		int matricula = leitor.nextInt();
		
		
		Aluno aluno = new Aluno(nome, matricula);
					
		//aluno.imprimir();
			
		//inserirNota();
		
		System.out.println("Digite a nota da primeira prova: ");
		float nota1 = leitor.nextFloat();
		System.out.println("Digite a nota da segunda prova: ");
		float nota2 = leitor.nextFloat();
		
		Boletim boletim = new Boletim(aluno.nome, aluno.matricula, nota1, nota2);
		
		boletim.imprimirBoletim();
	}
	
		

}
