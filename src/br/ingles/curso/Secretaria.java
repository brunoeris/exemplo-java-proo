package br.ingles.curso;

import java.util.Scanner;

public class Secretaria {
	private static Scanner leitor;
	
	public static void main(String[]args) {
		
		leitor = new Scanner (System.in);
		
		//inserirAluno()
		
		System.out.println("Digite o nome: ");
		String nome = leitor.next();
		System.out.println("Digite a matricula: ");
		int matricula = leitor.nextInt();
		
		Aluno aluno = new Aluno(nome, matricula);
		
		//procurarAluno();
		
		System.out.println("Digite o nome do aluno que voce deseja encontrar: ");
		String procura = leitor.next();
		
		if(procura.equals(aluno.nome)){
			System.out.println("Aluno Encontrado");
			aluno.imprimir();	
		}else{
			System.out.println("Aluno nao encontrado!");
		}
		
		
		//inserirNotas()
		
		System.out.println("Digite a nota da primeira prova: ");
		float nota1 = leitor.nextFloat();
		System.out.println("Digite a nota da segunda prova: ");
		float nota2 = leitor.nextFloat();
		
		Boletim boletim = new Boletim(aluno.nome, aluno.matricula, nota1, nota2);
	
		//mostrarBoletim
		
		boletim.imprimirBoletim();
		
		//editarNotas()
		
		System.out.println("Digite o nome do aluno que voce deseja editar a nota: ");
		procura = leitor.next();
		
		if(procura.equals(aluno.nome)){
			System.out.println("Aluno Encontrado");
			System.out.println("Você deseja editar qual das notas do aluno? Digite");
			System.out.println("1- A primeira nota \n2-A segunda nota");
			int escolha = leitor.nextInt();
			
			if(escolha == 1){
				System.out.println("Digite a nova nota do aluno: ");
				nota1 = leitor.nextFloat();
				boletim.setNota1(nota1);
				boletim.setNotaFinal((nota1+nota2)/2);
				boletim.imprimirBoletim();
			}
			
			if(escolha == 2){
				System.out.println("Digite a nova nota do aluno: ");
				nota2 = leitor.nextFloat();
				boletim.setNota2(nota2);
				boletim.setNotaFinal((nota1+nota2)/2);
				boletim.imprimirBoletim();
			}
				
		}else{
			System.out.println("Aluno nao encontrado!");
		}
		
			
	}

}
