package br.edu.ifal.proo.projetofinal;

import java.util.Scanner;

public class Secretaria {
	private static Scanner leitor;
	
	public static void main(String[]args) {
			
		leitor = new Scanner (System.in);
		
		int opcaoMenu;
			
		do{
			
			//MENU
			System.out.println("CURSO DE INGLÊS 'HOW ARE YOU LEARNING?' ");
			System.out.println("MENU");
			System.out.println("1- PARA INSERIR ALUNO");
			System.out.println("2- PARA PROCURAR UM ALUNO");
			System.out.println("3- PARA INSERIR NOTAS DE UM ALUNO");
			System.out.println("4- PARA EDITAR A NOTA DE UM ALUNO");
			System.out.println("5- PARA MOSTRAR O BOLETIM DE UM ALUNO");
			System.out.println("6- PARA EXCLUIR UM ALUNO");
			System.out.println("7- PARA FECHAR O PROGORAMA");
			
			opcaoMenu = leitor.nextInt();

		}

	}

}