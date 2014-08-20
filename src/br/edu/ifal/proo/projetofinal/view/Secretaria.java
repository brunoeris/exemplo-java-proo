package br.edu.ifal.proo.projetofinal.view;

import java.util.Scanner;
import java.util.ArrayList;
import br.edu.ifal.proo.projetofinal.model.*;

public class Secretaria {
	private static Scanner leitor;
	private static Scanner leitorespaco;
	
	public static void main(String[]args) {
			
		leitor = new Scanner (System.in);
		leitorespaco = new Scanner (System.in);
		
		int opcaoMenu;
			
		do{
				
			//MENU
			System.out.println("CURSO DE INGLÊS 'HOW ARE YOU LEARNING?'");
			System.out.println("MENU");
			System.out.println("1- PARA INSERIR CONTRATANTE");
			System.out.println("2- PARA LISTAR OS CONTRATANTES");
			System.out.println("3- PARA ALTERAR UM CONTRATANTE");
			System.out.println("4- PARA ALTERAR SITUACAO DE PAGAMENTO");
			System.out.println("5- PARA MOSTRAR O BOLETIM DE UM ALUNO");
			System.out.println("6- PARA EXCLUIR UM ALUNO");
			System.out.println("7- PARA FECHAR O PROGORAMA");
			
			opcaoMenu = leitor.nextInt();

		switch (opcaoMenu){

			case 1:
			//inserirContratante() 
				System.out.println("Digite o nome do contratante: ");
				String nome = leitorespaco.next();
				System.out.println("Digite o cpf do contratante");
				String cpf = leitor.next();
				System.out.println("Digite o sexo do contratante: ");
				String sexo = leitor.next();
				System.out.println("Digite a idade do contratante: ");
				int idade = leitor.nextInt();
				System.out.println("Digite o endereco do contratante: ");
				String endereco = leitor.next();
				System.out.println("Digite a cidade do contratante: ");
				String cidade = leitor.next();
				System.out.println("Digite o estado do contratante: ");
				String estado = leitor.next();
				Contratante contratante = new Contratante(nome,cpf,sexo,idade,endereco,cidade,estado,0);
				contratante.cadastrarContratante();
			break;
			
			case 2:
			//listarContratante()	
			/*System.out.println("Digite o cpf do contratante que você deseja encontrar: ");
			cpf = leitor.next();*/
			int pago;
			contratante = new Contratante();
			System.out.println("Número de contratantes cadastrados: "+contratante.obterQuantidade()+"\n");
			ArrayList contratantes = contratante.listar();
			System.out.println("|------------ CONTRATANTES ------------|");
			for (int i = 0; i < contratantes.size(); i++) {
				Contratante aux = (Contratante) contratantes.get(i);
				System.out.println("  Nome = "+aux.getNome());
				System.out.println("  Matricula = "+aux.getCpf());
				pago = aux.getPagamento();
				if (pago == 1 )
					System.out.println("  Situação do pagamento = PAGO!");
				else
					System.out.println("  Situação do pagamento = EM DÉBITO");
				System.out.println("|--------------------------------------|");
			}
			System.out.println("\n");
			break;
			
			case 3:
			//alterarContratante()
				System.out.println("Digite o cpf do contratante no qual deseja alterar os dados: ");
				cpf = leitor.next();
				contratante = new Contratante();
				System.out.println("Contratante a ser alterado:"); 
				contratante.buscar(cpf);
				contratante.mostrar(cpf);
				if (contratante.buscar(cpf)){
		
					System.out.println("Digite o novo nome: \n");
					nome = leitorespaco.next();
					System.out.println("Digite o novo sexo: ");
					sexo = leitor.next();
					System.out.println("Digite a nova idade: ");
					idade = leitor.nextInt();
					System.out.println("Digite o novo endereço: ");
					endereco = leitor.next();
					System.out.println("Digite a nova cidade: ");
					cidade = leitor.next();
					System.out.println("Digite o novo estado: ");
					estado = leitor.next();
					contratante.setNome(nome);
					contratante.setCpf(cpf);
					contratante.setSexo(sexo);
					contratante.setIdade(idade);
					contratante.setEndereco(endereco);
					contratante.setCidade(cidade);
					contratante.setEstado(estado);
					if (contratante.alterar())
						System.out.println("Alterado com sucesso!");
					else
						System.out.println("Erro na alteração!");
				}
				else
					System.out.println("Contratante "+cpf+" não encontrado!");
				break;
			
			case 4:
			//alteraSituacao()
				
				System.out.println("Digite o cpf do contratante no qual " +
						"deseja alterar situação de pagamento: ");
				cpf = leitor.next();
				contratante = new Contratante();
				nome = contratante.getNome();
				System.out.println("Contratante a ser alterado:"); 
				contratante.buscar(cpf);
				contratante.mostrar(cpf);
				contratante.setCpf(cpf);
				contratante.setNome(nome);
				if(contratante.buscar(cpf)){
					
					System.out.println(contratante.getNome());
					
					System.out.println("Digite a nova situação de pagamento: (1- PAGO 2-EM DÉBITO)");
					pago = leitor.nextInt();
									
					if(pago == 1)
						contratante.setPagamento(1);
					
					System.out.println(contratante.getPagamento());
					
					if (contratante.alterarPgto())
						System.out.println("Alterado com sucesso!");
					else
						System.out.println("Erro na alteração!");
					
					System.out.println("Nova situação de pagamento de: "+contratante.getNome());
					
					if(contratante.getPagamento() == 1)
						System.out.println("PAGO!");
					else
						System.out.println("EM DÉBITO");			
				}
				else
					System.out.println("Contratante "+cpf+" não encontrado!");			
				
			break;
			
			case 5:
			
			//cadastrarAluno()
				System.out.println("Digite o nome do aluno: ");
				nome = leitorespaco.next();
				System.out.println("Digite o CPF do aluno: ");
				cpf = leitor.next();
				System.out.println("Digite o sexo do aluno: ");
				sexo = leitor.next();
				System.out.println("Digite a idade do aluno: ");
				idade = leitor.nextInt();
				System.out.println("Digite o endereco do aluno: ");
				endereco = leitor.next();
				System.out.println("Digite o cidade do aluno: ");
				cidade = leitor.next();
				System.out.println("Digite o estado aluno: ");
				estado = leitor.next();
				System.out.println("Digite a matricula do aluno: ");
				String matricula = leitor.next();
				System.out.println("Digite o RG do aluno");
				int rg = leitor.nextInt();
				System.out.println("Digite o nivel em que o aluno se encontra (ex: Basic 1; Basic 2, Inter 2)");
				String nivel = leitor.next();
				Aluno aluno = new Aluno(nome, cpf, sexo, idade, endereco, cidade, estado, matricula, rg, nivel);
			break;	
		}
		
		}
		while(opcaoMenu != 7);
	}
}
