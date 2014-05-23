package br.ingles.curso;

import java.util.Scanner;


public class Secretaria {
	private static Scanner leitor;
	
	public static void main(String[]args) {
		
		Aluno aluno = new Aluno("",0);
		
		Boletim boletim = new Boletim(aluno.nome, aluno.matricula, 0, 0);
		
		
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
			
			
			
			switch (opcaoMenu){
			//inserirAluno()
			
				case 1:
				
					System.out.println("Digite o nome: ");
					String nome = leitor.next();
					System.out.println("Digite a matricula: ");
					int matricula = leitor.nextInt();
					aluno.setNome(nome);
					aluno.setMatricula(matricula);
					System.out.print("\n");
				break;
				
				case 2:
				//procurarAluno();
					
					
					System.out.println("Digite o nome do aluno que voce deseja encontrar: ");
					String procura = leitor.next();
					
					if(procura.equals(aluno.nome)){
						System.out.println("Aluno Encontrado");
						aluno.imprimir();	
					}else{
						System.out.println("Aluno nao encontrado!");
					}
					System.out.print("\n");
				break;
				
				case 3:	
				//inserirNotas()
				
					System.out.println("Digite a nota da primeira prova: ");
					float nota1 = leitor.nextFloat();
					System.out.println("Digite a nota da segunda prova: ");
					float nota2 = leitor.nextFloat();
					boletim.setNota1(nota1);
					boletim.setNota2(nota2);
					boletim.setNotaFinal((boletim.getNota1()+boletim.getNota2())/2);
					System.out.print("\n");
					
				break;
				
				case 4:
				//editarNotas()
					System.out.println("Digite o nome do aluno que voce deseja editar a nota: ");
					procura = leitor.next();
					
					if(procura.equals(aluno.nome)){
						System.out.println("Aluno Encontrado!");
						System.out.println("Você deseja editar qual das notas do aluno? Digite");
						System.out.println("1- A primeira nota \n2-A segunda nota");
						int escolha = leitor.nextInt();
						
						if(escolha == 1){
							System.out.println("Digite a nova nota do aluno: ");
							nota1 = leitor.nextFloat();
							boletim.setNota1(nota1);
							boletim.setNotaFinal((boletim.getNota1()+boletim.getNota2())/2);
							boletim.imprimirBoletim();
						}
						
						if(escolha == 2){
							System.out.println("Digite a nova nota do aluno: ");
							nota2 = leitor.nextFloat();
							boletim.setNota2(nota2);
							boletim.setNotaFinal((boletim.getNota1()+boletim.getNota2())/2);
							boletim.imprimirBoletim();
						}
							
					}else{
						System.out.println("Aluno nao encontrado!");
					}
					System.out.print("\n");
				break;
				
				case 5:
				//mostrarBoletim
						boletim.imprimirBoletim();
				break;
					
				case 6:
				//excluirAluno()
					String excluir;
					
					System.out.println("Digite o nome do aluno que voce deseja excluir: ");
					excluir = leitor.next();
					
					if(excluir.equals(aluno.nome)){
						System.out.println("Aluno Encontrado");
						aluno.imprimir();
						System.out.println("\nVoce tem certeza de que quer excluir o aluno?");
						System.out.println("1- SIM\n2- NAO");
						int escolha = leitor.nextInt();
						
						if(escolha == 1){
							aluno.excluirAluno();
							aluno.imprimir();
						}
						
					}
					System.out.print("\n");
				break;
	
			}
			
		}while (opcaoMenu != 7);
		
		
	}

}
