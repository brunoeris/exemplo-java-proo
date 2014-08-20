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
			System.out.println("2- PARA LISTAR OS CONTRATANTES (INCOMPLETO)");
			System.out.println("3- PARA ALTERAR UM CONTRATANTE");
			System.out.println("4- PARA EXCLUIR UM CONTRATANTE");
			System.out.println("5- PARA ALTERAR SITUACAO DE PAGAMENTO");
			System.out.println("6- PARA INSERIR UM ALUNO");
			System.out.println("7- PARA LISTAR OS ALUNOS");
			System.out.println("8- PARA ALTERAR UM ALUNO");
			System.out.println("9- PARA EXCLUIRUM ALUNO");
			System.out.println("10- PARA INSERIR NOTAS NO BOLETIM DE UM ALUNO");
			System.out.println("11- PARA ALTERAR NOTAS NO BOLETIM DE UM ALUNO (INCOMPLETO)");
			System.out.println("12- PARA INSERIR UM PROFESSOR");
			System.out.println("13- PARA LISTAR OS PORFESSORES");
			System.out.println("14- PARA ALTERAR UM PROFESSOR");
			System.out.println("15- PARA EXCLUIR UM PROFESSOR");
			System.out.println("20- PARA SAIR");
			
			opcaoMenu = leitor.nextInt();

		switch (opcaoMenu){

			case 1:
			//inserirContratante() 
				System.out.println("Digite o nome do contratante: ");
				String nome = leitorespaco.nextLine();
				System.out.println("Digite o cpf do contratante");
				String cpf = leitor.next();
				System.out.println("Digite o sexo do contratante: ");
				String sexo = leitor.next();
				System.out.println("Digite a idade do contratante: ");
				int idade = leitor.nextInt();
				System.out.println("Digite o endereco do contratante: ");
				String endereco = leitorespaco.nextLine();
				System.out.println("Digite a cidade do contratante: ");
				String cidade = leitorespaco.nextLine();
				System.out.println("Digite o estado do contratante: ");
				String estado = leitorespaco.nextLine();
				int situacao = 0;
				Contratante contratante = new Contratante(nome,cpf,sexo,idade,endereco,cidade,estado,situacao);
				contratante.cadastrarContratante();
			break;
			
			case 2:
			//listarContratante()	
			int pago;
			contratante = new Contratante();
			System.out.println("Número de contratantes cadastrados: "+contratante.obterQuantidade()+"\n");
			ArrayList contratantes = contratante.listar();
			System.out.println("|------------ CONTRATANTES ------------|");
			for (int i = 0; i < contratantes.size(); i++) {
				Contratante aux = (Contratante) contratantes.get(i);
				System.out.println("  Nome = "+aux.getNome());
				System.out.println("  Matricula = "+aux.getCpf());
				if (aux.getPagamento() == 1 )
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
		
					System.out.println("Digite o novo nome: ");
					nome = leitorespaco.nextLine();
					System.out.println("Digite o sexo: ");
					sexo = leitor.next();
					System.out.println("Digite a nova idade: ");
					idade = leitor.nextInt();
					System.out.println("Digite o novo endereço: ");
					endereco = leitorespaco.nextLine();
					System.out.println("Digite a nova cidade: ");
					cidade = leitorespaco.nextLine();
					System.out.println("Digite o novo estado: ");
					estado = leitorespaco.nextLine();
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
			//excluirContratante()
				System.out.println("Digite o cpf do contratante que deseja excluir: ");
				cpf = leitor.next();
				contratante = new Contratante();
				if (contratante.buscar(cpf)){
					if (contratante.excluir(cpf))
						System.out.println("Excluído com sucesso!");
					else
						System.out.println("Erro na exclusão!");
				}
				else
					System.out.println("Professor "+cpf+" não encontrado!");
			break;
			
			case 5:
			//alteraSituacao()
				contratante = new Contratante();
				System.out.println("Digite o cpf do contratante no qual " +
						"deseja alterar situação de pagamento: ");
				cpf = leitor.next();
				contratantes = contratante.listar();
				System.out.println("Contratante a ser alterado:"); 
				contratante.buscar(cpf);
				contratante.mostrar(cpf);
				contratante.setCpf(cpf);
				if(contratante.buscar(cpf)){
					
					System.out.println(contratante.getNome());
					
					System.out.println("Digite a nova situação de pagamento: (1- PAGO 2-EM DÉBITO)");
					pago = leitor.nextInt();
									
					int pagto;
					if(pago == 1){
						pagto = 1;						
						contratante.setPagamento(pagto);
					}
					
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
			
			case 6:
			//cadastrarAluno()
				System.out.println("Digite o nome do aluno: ");
				nome = leitorespaco.nextLine();
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
				String nivel = leitorespaco.nextLine();
				Aluno aluno = new Aluno(nome, cpf, sexo, idade, endereco, cidade, estado, matricula, rg, nivel);
				Boletim boletim = new Boletim();
				boletim.setMatricula(matricula);
				aluno.cadastrarAluno();
				boletim.cadastrarBoletim();
			break;
			
			case 7:
				//listarAluno()	
				aluno = new Aluno();
				System.out.println("Número de alunos cadastrados: "+aluno.obterQuantidade()+"\n");
				ArrayList alunos = aluno.listar();
				System.out.println("|------------ ALUNOS ------------|");
				for (int i = 0; i < alunos.size(); i++) {
					Aluno aux = (Aluno) alunos.get(i);
					System.out.println("  Nome = "+aux.getNome());
					System.out.println("  Matricula = "+aux.getCpf());
					System.out.println("|--------------------------------------|");
				}
				System.out.println("\n");
				break;
				
			
			case 8:
				//alterarAluno()
				System.out.println("Digite a matricula do aluno qual deseja alterar os dados: ");
				matricula = leitor.next();
				aluno = new Aluno();
				boletim = new Boletim();
				System.out.println("Aluno a ser alterado:"); 
				aluno.buscar(matricula);
				aluno.mostrar(matricula);
				if (aluno.buscar(matricula)){
		
					System.out.println("Digite o novo nome: ");
					nome = leitorespaco.nextLine();
					System.out.println("Digite o sexo: ");
					sexo = leitor.next();
					System.out.println("Digite a nova idade: ");
					idade = leitor.nextInt();
					System.out.println("Digite o novo endereço: ");
					endereco = leitorespaco.nextLine();
					System.out.println("Digite a nova cidade: ");
					cidade = leitorespaco.nextLine();
					System.out.println("Digite o novo estado: ");
					estado = leitorespaco.nextLine();
					System.out.println("Digite o novo nivel: ");
					nivel = leitorespaco.nextLine();
					aluno.setNome(nome);
					aluno.setMatricula(matricula);
					aluno.setSexo(sexo);
					aluno.setIdade(idade);
					aluno.setEndereco(endereco);
					aluno.setCidade(cidade);
					aluno.setEstado(estado);
					aluno.setNivel(nivel);
					boletim.setMatricula(matricula);
					if (aluno.alterar())
						System.out.println("Alterado com sucesso!");
					else
						System.out.println("Erro na alteração!");
				}
				else
					System.out.println("Aluno "+matricula+" não encontrado!");
			break;
			
			case 9:
			//excluirAluno()
				System.out.println("Digite a matrícula do aluno que deseja excluir: ");
				matricula = leitor.next();
				aluno = new Aluno();
				if (aluno.buscar(matricula)){
					if (aluno.excluir(matricula))
						System.out.println("Excluído com sucesso!");
					else
						System.out.println("Erro na exclusão!");
				}
				else
					System.out.println("Aluno "+matricula+" não encontrado!");
				break;
				
			case 10:
				//cadastrarBoletim()
					System.out.println("Digite a matricula do aluno no qual deseja cadastrar notas: ");
					matricula = leitor.next();
					boletim = new Boletim();
					if (boletim.buscar(matricula)){
						System.out.println("Digite a Primeira nota do aluno: ");
						double notaA = leitor.nextDouble();
						System.out.println("Digite a Segunda nota do aluno: ");
						double notaB = leitor.nextDouble();
						double media = (notaA+notaB/2);
						boletim = new Boletim(notaA,notaB,media);
						boletim.setMatricula(matricula);
						boletim.cadastrarBoletim();
						if (boletim.alterar())
							System.out.println("Alterado com sucesso!");
						else
							System.out.println("Erro na alteração!");
					}
					else
						System.out.println("Aluno "+matricula+" não encontrado!");
				break;
				
			case 11:
				//alterarBoletim()
				System.out.println("Digite a matricula do aluno qual deseja alterar as notas: ");
				matricula = leitor.next();
				aluno = new Aluno();
				boletim = new Boletim();
				if (boletim.buscar(matricula)){
					System.out.println("Aluno a ser alterado:"); 
					boletim.buscar(matricula);
					aluno = aluno.mostrarBoletim(matricula);
					System.out.println("|----------------- BOLETIM -----------------|");
					System.out.println("Nome: "+aluno.getNome());
					System.out.println("Matricula: "+aluno.getMatricula());
					System.out.println("Nota da Primeira Prova: "+boletim.getNotaA());
					System.out.println("Nota da Segunda Prova: "+boletim.getNotaB());
					System.out.println("Media: "+boletim.getMedia());
					System.out.println("|-------------------------------------------|");
					System.out.println("Digite a nova Primeira nota do aluno: ");
					double notaA = leitor.nextDouble();
					System.out.println("Digite a Segunda nota do aluno: ");
					double notaB = leitor.nextDouble();
					double media = ((notaA+notaB)/2);
					boletim.setMatricula(matricula);
					boletim.setNotaA(notaA);
					boletim.setNotaB(notaB);
					boletim.setMedia(media);
					if (boletim.alterar())
						System.out.println("Alterado com sucesso!");
					else
						System.out.println("Erro na alteração!");
				}
				else
					System.out.println("Aluno "+matricula+" não encontrado!");
			break;
			
			case 12:
			//inserirProfessor() 
				System.out.println("Digite o nome do contratante: ");
				nome = leitorespaco.nextLine();
				System.out.println("Digite o cpf do contratante");
				cpf = leitor.next();
				System.out.println("Digite o sexo do contratante: ");
				sexo = leitor.next();
				System.out.println("Digite a idade do contratante: ");
				idade = leitor.nextInt();
				System.out.println("Digite o endereco do contratante: ");
				endereco = leitorespaco.nextLine();
				System.out.println("Digite a cidade do contratante: ");
				cidade = leitorespaco.nextLine();
				System.out.println("Digite o estado do contratante: ");
				estado = leitorespaco.nextLine();
				Professor professor = new Professor(nome,cpf,sexo,idade,endereco,cidade,estado);
				professor.cadastrarProfessor();
			break;
			
			case 13:
			//listarProfessor()	
				professor = new Professor();
				System.out.println("Número de contratantes cadastrados: "+professor.obterQuantidade()+"\n");
				ArrayList professores = professor.listar();
				System.out.println("|------------ CONTRATANTES ------------|");
				for (int i = 0; i < professores.size(); i++) {
					Professor aux = (Professor) professores.get(i);
					System.out.println("  Nome = "+aux.getNome());
					System.out.println("  Matricula = "+aux.getCpf());
					System.out.println("|--------------------------------------|");
				}
				System.out.println("\n");
			break;
			
			case 14:
			//alterarProfessor()
				System.out.println("Digite o cpf do professor no qual deseja alterar os dados: ");
				cpf = leitor.next();
				professor = new Professor();
				System.out.println("Contratante a ser alterado:"); 
				professor.buscar(cpf);
				professor.mostrar(cpf);
				if (professor.buscar(cpf)){
		
					System.out.println("Digite o novo nome: ");
					nome = leitorespaco.nextLine();
					System.out.println("Digite o sexo: ");
					sexo = leitor.next();
					System.out.println("Digite a nova idade: ");
					idade = leitor.nextInt();
					System.out.println("Digite o novo endereço: ");
					endereco = leitorespaco.nextLine();
					System.out.println("Digite a nova cidade: ");
					cidade = leitorespaco.nextLine();
					System.out.println("Digite o novo estado: ");
					estado = leitorespaco.nextLine();
					professor.setNome(nome);
					professor.setCpf(cpf);
					professor.setSexo(sexo);
					professor.setIdade(idade);
					professor.setEndereco(endereco);
					professor.setCidade(cidade);
					professor.setEstado(estado);
					if (professor.alterar())
						System.out.println("Alterado com sucesso!");
					else
						System.out.println("Erro na alteração!");
				}
				else
					System.out.println("Professor "+cpf+" não encontrado!");
			break;
			
			case 15:
			//excluirProfessor()
				System.out.println("Digite o cpf do professor que deseja excluir: ");
				cpf = leitor.next();
				professor = new Professor();
				if (professor.buscar(cpf)){
					if (professor.excluir(cpf))
						System.out.println("Excluído com sucesso!");
					else
						System.out.println("Erro na exclusão!");
				}
				else
					System.out.println("Professor "+cpf+" não encontrado!");
			break;
			
		}
		
		}
		while(opcaoMenu != 20);
	}
}
