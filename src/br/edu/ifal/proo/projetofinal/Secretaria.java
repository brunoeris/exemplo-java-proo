package br.edu.ifal.proo.projetofinal;

import java.util.Scanner;
import java.util.ArrayList;

public class Secretaria {
	private static Scanner leitor;
	
	public static void main(String[]args) {
			
		leitor = new Scanner (System.in);
		
		int opcaoMenu;
			
		do{
		
		
			
			//MENU
			System.out.println("CURSO DE INGLÊS 'HOW ARE YOU LEARNING?'");
			System.out.println("MENU");
			System.out.println("1- PARA INSERIR ALUNO");
			System.out.println("2- PARA PROCURAR UM ALUNO");
			System.out.println("3- PARA INSERIR NOTAS DE UM ALUNO");
			System.out.println("4- PARA EDITAR A NOTA DE UM ALUNO");
			System.out.println("5- PARA MOSTRAR O BOLETIM DE UM ALUNO");
			System.out.println("6- PARA EXCLUIR UM ALUNO");
			System.out.println("7- PARA FECHAR O PROGORAMA");
			
			opcaoMenu = leitor.nextInt();

		switch (opcaoMenu){
		

			case 1:
			//Inserir Aluno
				System.out.println("Digite o seu nome");
			break;
			case 2:
			//Procurar um aluno
				System.out.println("Digite o seu nome");
			break;
			case 3:
			//Inserir Notas
				System.out.println("Digite o seu nome");
			break;
			case 4:
			//Editar Nota
				System.out.println("Digite o seu nome");
			break;
			case 5:
			//Mostrar Boletim
				System.out.println("Digite o seu nome");
			break;
			case 6:
			//Excluir Aluno
				System.out.println("Digite o seu nome");
			break;
				
		}
		
		}
		while(opcaoMenu != 7);
	}
}
