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
			System.out.println("|----------------------------------------------------|");
			System.out.println("|       CURSO DE INGLÊS 'HOW ARE YOU LEARNING?'      |");
			System.out.println("|----------------------------------------------------|");
			System.out.println("|                          MENU                      |");
			System.out.println("|----------------------------------------------------|");
			System.out.println("| 1- PARA ENTRAR NO MENU DE CONTRATANTES             |");
			System.out.println("| 2- PARA ENTRAR NO MENU DE ALUNOS                   |");
			System.out.println("| 3- PARA ENTRAR NO MENU DE PROFESSORES              |");
			System.out.println("| 4- PARA ENTRAR NO MENU DE SALAS                    |");
			System.out.println("| 5- PARA SAIR                                       |");
			System.out.println("|----------------------------------------------------|");
			opcaoMenu = leitor.nextInt();
			
			switch(opcaoMenu){
			case 1:
			int opcao;
			
				do{
					System.out.println("|----------------------------------------------------|");
					System.out.println("|       CURSO DE INGLÊS 'HOW ARE YOU LEARNING?'      |");
					System.out.println("|----------------------------------------------------|");
					System.out.println("|                  MENU CONTRATANTE                  |");
					System.out.println("|----------------------------------------------------|");
					System.out.println("| 1- PARA INSERIR CONTRATANTE                        |");
					System.out.println("| 2- PARA LISTAR OS CONTRATANTES                     |");
					System.out.println("| 3- PARA ALTERAR UM CONTRATANTE                     |");
					System.out.println("| 4- PARA EXCLUIR UM CONTRATANTE                     |");
					System.out.println("| 5- PARA ALTERAR SITUACAO DE PAGAMENTO              |");
					System.out.println("| 6- PARA VOLTAR AO MENU PRINCIPAL                   |");
					System.out.println("|----------------------------------------------------|");
					opcao = leitor.nextInt();
					
					switch(opcao){
					case 1:
					//inserirContratante()
						System.out.println(" ===== CADASTRO DE CONTRATANTE ==== ");
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
						contratante = new Contratante();
						System.out.println("Número de contratantes cadastrados: "+contratante.obterQuantidade()+"\n");
						ArrayList contratantes = contratante.listar();
						System.out.println("|------------ CONTRATANTES ------------|");
						for (int i = 0; i < contratantes.size(); i++) {
							Contratante aux = (Contratante) contratantes.get(i);
							Verificavel c = aux;
							contratante.mostrar(aux.getCpf());
							c.verifica(aux.getSituacao());
							System.out.println("|--------------------------------------|");
						}
						System.out.println("\n");
						break;
						
					case 3:
					//alterarContratante()
						System.out.println(" ===== ALTERAR UM CONTRATANTE ==== ");
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
							System.out.println(" ===== EXCLUIR UM CONTRANTANTE ==== ");
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
							System.out.println(" ===== ALTERAR SITUAÇÃO DE PAGAMENTO ==== ");
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
							int pago = leitor.nextInt();
													
							int pagto;
							
							if(pago == 1){
								pagto = 1;						
								contratante.setSituacao(pagto);
							}
									
							System.out.println(contratante.getSituacao());
									
							if (contratante.alterarPgto())
								System.out.println("Alterado com sucesso!");
							else
								System.out.println("Erro na alteração!");
									
							System.out.println("Nova situação de pagamento de: "+contratante.getNome());
									
							if(contratante.getSituacao() == 1)
								System.out.println("PAGO!");
							else
								System.out.println("EM DÉBITO");			
							}
							else
								System.out.println("Contratante "+cpf+" não encontrado!");			
								
							break;
					}
				}
				while(opcao!=6);
				
				break;
				
				case 2:
					do{
					System.out.println("|----------------------------------------------------|");
					System.out.println("|       CURSO DE INGLÊS 'HOW ARE YOU LEARNING?'      |");
					System.out.println("|----------------------------------------------------|");
					System.out.println("|                    MENU ALUNO                      |");
					System.out.println("|----------------------------------------------------|");
					System.out.println("| 1- PARA INSERIR UM ALUNO                           |");
					System.out.println("| 2- PARA LISTAR OS ALUNOS                           |");
					System.out.println("| 3- PARA ALTERAR UM ALUNO                           |");
					System.out.println("| 4- PARA ALTERAR PRESENCA DE ALUNO                  |");
					System.out.println("| 5- PARA EXCLUIR UM ALUNO E SEU BOLETIM             |");
					System.out.println("| 6- PARA INSERIR NOTAS NO BOLETIM DE UM ALUNO       |");
					System.out.println("| 7- PARA ALTERAR NOTAS NO BOLETIM DE UM ALUNO       |");
					System.out.println("| 8- PARA MOSTRAR NOTAS DE UM ALUNO                  |");
					System.out.println("| 9- PARA VOLTAR AO MENU PRINCIPAL                   |");
					System.out.println("|----------------------------------------------------|");
					opcao = leitor.nextInt();
					
						switch(opcao){
							case 1:
							//cadastrarAluno()
								System.out.println(" ===== CADASTRO DE ALUNOS ==== ");
								System.out.println("Digite o nome do aluno: ");
								String nome = leitorespaco.nextLine();
								System.out.println("Digite o CPF do aluno: ");
								String cpf = leitor.next();
								System.out.println("Digite o CPF do contratante relacionado ao aluno: ");
								String contratanteCpf = leitor.next();
								System.out.println("Digite o sexo do aluno: ");
								String sexo = leitor.next();
								System.out.println("Digite a idade do aluno: ");
								int idade = leitor.nextInt();
								System.out.println("Digite o endereco do aluno: ");
								String endereco = leitor.next();
								System.out.println("Digite o cidade do aluno: ");
								String cidade = leitor.next();
								System.out.println("Digite o estado aluno: ");
								String estado = leitor.next();
								System.out.println("Digite a matricula do aluno: ");
								String matricula = leitor.next();
								System.out.println("Digite o RG do aluno");
								int rg = leitor.nextInt();
								System.out.println("Digite o nivel em que o aluno se encontra (ex: Basic 1; Basic 2, Inter 2)");
								String nivel = leitorespaco.nextLine();
								int presenca = 0;
								Aluno aluno = new Aluno(nome, cpf, sexo, idade, endereco, cidade, estado, matricula, rg, nivel, contratanteCpf,presenca);
								Boletim boletim = new Boletim();
								boletim.setMatricula(matricula);
								aluno.cadastrarAluno();
								boletim.cadastrarBoletim();
							break;
							
							case 2:
								//listarAluno()	
								aluno = new Aluno();
								Verificavel a = aluno;
								System.out.println("Número de alunos cadastrados: "+aluno.obterQuantidade()+"\n");
								ArrayList alunos = aluno.listar();
								System.out.println("|------------ ALUNOS ------------|");
								for (int i = 0; i < alunos.size(); i++) {
									Aluno aux = (Aluno) alunos.get(i);
									aluno.mostrar(aux.getMatricula());
									a.verifica(aux.getPresenca());
									System.out.println("|--------------------------------|");
								}
								System.out.println("\n");
								break;
								
							
							case 3:
								//alterarAluno()
								System.out.println(" ===== ALTERAR DADOS DE UM ALUNO ==== ");
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
									System.out.println("Digite o novo CPF de contratante: ");
									contratanteCpf = leitorespaco.nextLine();
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
									aluno.setContratanteCpf(contratanteCpf);
									aluno.setMatricula(matricula);
									aluno.setSexo(sexo);
									aluno.setIdade(idade);
									aluno.setEndereco(endereco);
									aluno.setCidade(cidade);
									aluno.setEstado(estado);
									aluno.setNivel(nivel);
									aluno.setPresenca(0);
									boletim.setMatricula(matricula);
									if (aluno.alterar())
									System.out.println("Alterado com sucesso!");
									else
										System.out.println("Erro na alteração!");
								}
								else
									System.out.println("Aluno "+matricula+" não encontrado!");
							break;
							
							case 4:
								//alteraPresenca()
								System.out.println(" ===== ALTERAR PRESENÇA DE UM ALUNO ==== ");
									System.out.println("Digite a matricula do aluno qual deseja alterar os dados: ");
									matricula = leitor.next();
									aluno = new Aluno();
									System.out.println("Aluno a ser alterado:"); 
									aluno.buscar(matricula);
									aluno.mostrar(matricula);
									if(aluno.buscar(matricula)){
										System.out.println("Digite:\n1-SE O ALUNO ESTIVER PRESENTE\n0-SE O ALUNO ESTIVER AUSENTE");
										presenca = leitor.nextInt();
										aluno.setPresenca(presenca);
										aluno.setMatricula(matricula);
										if (aluno.alterarPresenca())
											System.out.println("Alterado com sucesso!");
										else
											System.out.println("Erro na alteração!");
									}
								else
									System.out.println("Aluno "+matricula+" não encontrado!");
								break;
							
							case 5:
							//excluirAluno()
								System.out.println(" ===== EXCLUIR UM ALUNO E SEU BOLETIM ==== ");
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
								
							case 6:
							//cadastrarBoletim()
								System.out.println(" ===== CADASTRAR NOVO BOLETIM DE ALUNO ==== ");
									System.out.println("Digite a matricula do aluno no qual deseja cadastrar notas: ");
									matricula = leitor.next();
									boletim = new Boletim();
									if (boletim.buscar(matricula)){
										System.out.println("Digite a Primeira nota do aluno: ");
										double notaA = leitor.nextDouble();
										System.out.println("Digite a Segunda nota do aluno: ");
										double notaB = leitor.nextDouble();
										double media = ((notaA+notaB)/2);
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
								
							case 7:
							//alterarBoletim()
								System.out.println(" ===== ALTERAR BOLETIM DE UM ALUNO ==== ");
								System.out.println("Digite a matricula do aluno qual deseja alterar as notas: ");
								matricula = leitor.next();
								aluno = new Aluno();
								boletim = new Boletim();
								System.out.println("Aluno a ser alterado:"); 
								aluno.buscar(matricula);
								aluno = aluno.mostrarBoletim(matricula);
								if (aluno.buscar(matricula)){		
									System.out.println("Digite a nova Primeira nota do aluno: ");
									double notaA = leitor.nextDouble();
									System.out.println("Digite a Segunda nota do aluno: ");
									double notaB = leitor.nextDouble();
									double media = ((notaA+notaB)/2);
									aluno.getBoletim().setMatricula(matricula);
									aluno.getBoletim().setNotaA(notaA);
									aluno.getBoletim().setNotaB(notaB);
									aluno.getBoletim().setMedia(media);
									System.out.println("|----------------- BOLETIM -----------------|");
									System.out.println("Nome: "+aluno.getNome());
									System.out.println("Matricula: "+aluno.getMatricula());
									boletim = aluno.getBoletim();
									System.out.println("Nota da Primeira Prova: "+aluno.getBoletim().getNotaA());
									System.out.println("Nota da Segunda Prova: "+aluno.getBoletim().getNotaB());
									System.out.println("Media: "+aluno.getBoletim().getMedia());
									System.out.println("|-------------------------------------------|");					
									
									if (boletim.alterar())
										System.out.println("Alterado com sucesso!");
									else
										System.out.println("Erro na alteração!");
								}
								else
									System.out.println("Aluno "+matricula+" não encontrado!");
							break;
							
							case 8:
							//mostrarBoletins()
								System.out.println(" ===== MOSTRAR BOLETIM DE UM ALUNO ==== ");
								System.out.println("Digite a matricula do aluno qual deseja ver o boletim: ");
								matricula = leitor.next();
								aluno = new Aluno();
								aluno.buscar(matricula);
								if(aluno.buscar(matricula))
									aluno = aluno.mostrarBoletim(matricula);
								else
									System.out.println("Aluno "+matricula+" não encontrado!");
							break;
							
						}
					}
					while(opcao!=9);
					break;
				
				case 3:
				do{
					System.out.println("|----------------------------------------------------|");
					System.out.println("|       CURSO DE INGLÊS 'HOW ARE YOU LEARNING?'      |");
					System.out.println("|----------------------------------------------------|");
					System.out.println("|                    MENU PROFESSOR                  |");
					System.out.println("|----------------------------------------------------|");
					System.out.println("| 1- PARA INSERIR UM PROFESSOR                       |");
					System.out.println("| 2- PARA LISTAR OS PROFESSORES                      |");
					System.out.println("| 3- PARA ALTERAR OS DADOS DE UM PROFESSOR           |");
					System.out.println("| 4- PARA EDITAR A PRESENCA UM PROFESSOR             |");
					System.out.println("| 5- PARA EXCLUIR UM PROFESSOR                       |");
					System.out.println("| 6- PARA MARCAR UMA AVALIAÇÃO                       |");
					System.out.println("| 7- PARA LISTAR AS AVALIAÇÕES MARCADAS              |");
					System.out.println("| 8- PARA ALTERAR OS DADOS DE UMA AVALIAÇÃO          |");
					System.out.println("| 9- PARA DEFINIR SE A AVALIAÇÃO ESTÁ ACONTECENDO    |");
					System.out.println("| 10- PARA VOLTAR AO MENU PRINCIPAL                  |");
					System.out.println("|----------------------------------------------------|");
					opcao = leitor.nextInt();
							
						switch(opcao){
						case 1:
							//inserirProfessor()
								System.out.println(" ==== CADASTRO DE PROFESSOR ==== ");
								System.out.println("Digite o nome do professor: ");
								String nome = leitorespaco.nextLine();
								System.out.println("Digite o cpf do professor");
								String cpf = leitor.next();
								System.out.println("Digite o sexo do professor: ");
								String sexo = leitor.next();
								System.out.println("Digite a idade do professor: ");
								int idade = leitor.nextInt();
								System.out.println("Digite o endereco do professor: ");
								String endereco = leitorespaco.nextLine();
								System.out.println("Digite a cidade do professor: ");
								String cidade = leitorespaco.nextLine();
								System.out.println("Digite o estado do professor: ");
								String estado = leitorespaco.nextLine();
								int ministrandoAula = 0;
								Professor professor = new Professor(nome,cpf,sexo,idade,endereco,cidade,estado, ministrandoAula);
								professor.cadastrarProfessor();
							break;
							
							case 2:
							//listarProfessor()	
								professor = new Professor();
								Verificavel p = professor;
								System.out.println("Número de professores cadastrados: "+professor.obterQuantidade()+"\n");
								ArrayList professores = professor.listar();
								System.out.println("|------------ PROFESSORES ------------|");
								for (int i = 0; i < professores.size(); i++) {
									Professor aux = (Professor) professores.get(i);
									System.out.println("  Nome = "+aux.getNome());
									System.out.println("  CPF do Professor = "+aux.getCpf());
									p.verifica(aux.getMinistrandoAula());
									System.out.println("|--------------------------------------|");
								}
								System.out.println("\n");
							break;
							
							case 3:
							//alterarProfessor()
								System.out.println(" ===== ALTERAR DADOS DE UM PROFESSOR ==== ");
								System.out.println("Digite o cpf do professor no qual deseja alterar os dados: ");
								cpf = leitor.next();
								professor = new Professor();
								System.out.println("Professor a ser alterado:"); 
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
							
							case 4:
							//alteraPresencaProfessor()
								System.out.println(" ===== ALTERAR PRESENÇA DE UM PROFESSOR ==== ");
								System.out.println("Digite o cpf do professor qual deseja alterar a presença:");
								cpf = leitor.next();
								professor = new Professor();
								System.out.println("Professor a ser alterado:"); 
								professor.buscar(cpf);
								professor.mostrar(cpf);
								if(professor.buscar(cpf)){
									System.out.println("Digite:\n1-SE O PROFESSOR ESTIVER MINISRTANDO AULA\n" +
											"0-SE O PROFESSOR ESTIVER AUSENTE");
									ministrandoAula = leitor.nextInt();
									professor.setMinistrandoAula(ministrandoAula);
									professor.setCpf(cpf);
									if (professor.alterarPresenca())
										System.out.println("Alterado com sucesso!");
									else
										System.out.println("Erro na alteração!");
								}
								else
									System.out.println("Professor "+cpf+" não encontrado!");
							break;
							
							case 5:
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
							
							case 6:
							//inserirProfessor()
								System.out.println(" ==== CADASTRO DE AVALIAÇÃO ==== ");
								System.out.println("Digite a codigo da avaliação (EX: AV01,AV03)");
								String codigo = leitor.next();
								System.out.println("Digite a data da avaliação: ");
								String data = leitor.next();
								System.out.println("Digite o nome da prova (EX: PRIMEIRA PROVA ESCRITA, SEGUNDA PROVA ORAL): ");
								nome = leitorespaco.nextLine();
								System.out.println("Digite o CPF do aplicador: ");
								cpf = leitor.next();
								System.out.println("Digite o nivel da avaliacao: ");
								String nivel = leitorespaco.nextLine();
								int situacao = 0;
								Avaliacao avaliacao = new Avaliacao(data,nome,nivel,situacao,cpf,codigo);
								avaliacao.marcarAvaliacao();
							break;
							
							case 7:
							//listarAvaliacoes()	
								avaliacao = new Avaliacao();
								Verificavel av = avaliacao;
								System.out.println("Número de avaliações marcadas: "+avaliacao.obterQuantidade()+"\n");
								ArrayList avaliacoes = avaliacao.listar();
								System.out.println("|------------ AVALIAÇÕES ------------|");
								for (int i = 0; i < avaliacoes.size(); i++) {
									Avaliacao aux = (Avaliacao) avaliacoes.get(i);
									avaliacao.mostrar(aux.getCpfDoProfessor());
									av.verifica(aux.getSituacao());
									System.out.println("|------------------------------------|");
								}
								System.out.println("\n");
							break;
								
							case 8:
							//alterarAvaliacao()
								System.out.println(" ===== ALTERAR DADOS DE UMA AVALIAÇÃO ==== ");
								System.out.println("Digite o código da avaliacao no qual deseja alterar os dados: ");
								String cod = "'"+leitor.next()+"'";
								avaliacao = new Avaliacao();
								av = avaliacao;
								System.out.println("Avaliacão a ser alterada:");
								avaliacao = avaliacao.buscarEListar(cod);
								av.verifica(avaliacao.getSituacao());
								if (avaliacao.buscar(cod)){
									System.out.println("Digite a nova data da avaliação: ");
									data = leitor.next();
									System.out.println("Digite o novo nome da prova (EX: PRIMEIRA PROVA ESCRITA, SEGUNDA PROVA ORAL): ");
									nome = leitorespaco.nextLine();
									System.out.println("Digite o nivel correto da avaliacao: ");
									nivel = leitorespaco.nextLine();
									avaliacao.setData(data);
									avaliacao.setData(data);
									avaliacao.setNomeDaProva(nome);
									avaliacao.setNivel(nivel);
									avaliacao.setCodigo(cod);
									if (avaliacao.alterar())
										System.out.println("Alterado com sucesso!");
									else
										System.out.println("Erro na alteração!");
								}
									else
										System.out.println("Avaliação "+cod+" não encontrada!");
							break;
								
							case 9:
								//alteraSituaçãoAvaliacao()
									System.out.println(" ===== ALTERAR A SITUAÇÃO DE UMA AVALIAÇÃO ==== ");
									System.out.println("Digite o código da avaliação na qual deseja alterar a situação:");
									codigo = "'"+leitor.next()+"'";
									avaliacao = new Avaliacao();
									av = avaliacao;
									System.out.println("Avaliacao a ser alterada:"); 
									avaliacao.buscar(codigo);
									//avaliacao.buscarEListar(codigo);
									avaliacao = avaliacao.buscarEListar(codigo);
									av.verifica(avaliacao.getSituacao());
									if(avaliacao.buscar(codigo)){
										System.out.println("Digite:\n1-SE O A AVALIAÇÃO ESTIVER SENDO APLICADA\n" +
												"0-SE O PROFESSOR ESTIVER FINALIZADA");
										situacao = leitor.nextInt();
										avaliacao.setSituacao(situacao);
										avaliacao.setCodigo(codigo);
										if (avaliacao.alterarSituacao())
											System.out.println("Alterado com sucesso!");
										else
											System.out.println("Erro na alteração!");
									}
									else
										System.out.println("Avaliação "+codigo+" não encontrada!");
								break;
							
						}	
					}
					while(opcao != 10);
			break;
			
			case 4:
				do{
					System.out.println("|----------------------------------------------------|");
					System.out.println("|       CURSO DE INGLÊS 'HOW ARE YOU LEARNING?'      |");
					System.out.println("|----------------------------------------------------|");
					System.out.println("|                    MENU DE SALAS                   |");
					System.out.println("|----------------------------------------------------|");
					System.out.println("| 1- PARA CADASTRAR NOVA SALA                        |");
					System.out.println("| 2- PARA LISTAR SALAS                               |");
					System.out.println("| 3- PARA ALTERAR DADOS DE UMA SALA                  |");
					System.out.println("| 4- PARA VOLTAR AO MENU PRINCIPAL                   |");
					System.out.println("|----------------------------------------------------|");
					opcao = leitor.nextInt();
					
					switch(opcao){
					case 1:
						//cadastrarSala()
							System.out.println(" ===== CADASTRO DE SALAS ==== ");
							System.out.println("Digite o número da sala a ser cadastrada:");
							int numero = leitor.nextInt();
							System.out.println("Especifique a quantidade de cadeiras que existem na sala: ");
							int qtdCadeiras = leitor.nextInt();
							Sala sala = new Sala(numero,qtdCadeiras);
							sala.cadastrarSala();
						break;
						
					case 2:
					//listarSala()
						sala = new Sala();
						Verificavel s = sala;
						ArrayList salas = sala.listar();
						System.out.println("|------------ SALAS ------------|");
						for (int i = 0; i < salas.size(); i++) {
							Sala aux = (Sala) salas.get(i);
							System.out.println("  Numero da Sala: "+aux.getNumero());
							System.out.println("  Quantidade de cadeiras: "+aux.getQtdCadeiras());	
							s.verifica(aux.getOcupada());
							System.out.println("|-------------------------------|");
						}
						System.out.println("\n");
					break;
							
					case 3:
					//alterarSala()
						System.out.println(" ===== ALTERAR DADOS DE UMA SALA ==== ");
						System.out.println("Digite o numero da sala no qual deseja alterar os dados: ");
						numero = leitor.nextInt();
						sala = new Sala();
						sala.buscar(numero);
						if (sala.buscar(numero)){
							System.out.println("Digite a nova quantidade de cadeiras: ");
							qtdCadeiras = leitorespaco.nextInt();
							System.out.println("Digite a nova situacao de ocupacao da sala: (1- OCUPADA 0- DESOCUPADA)");
							int situacao = leitor.nextInt();
							sala.setNumero(numero);
							sala.setQtdCadeiras(qtdCadeiras);
							sala.setOcupada(situacao);
							if (sala.alterar())
								System.out.println("Alterado com sucesso!");
							else
								System.out.println("Erro na alteração!");
						}
						else
							System.out.println("Sala "+numero+" não encontrado!");
					break;
					}
					
				}
				while(opcao != 8);
			break;		
			}
		}	
		while(opcaoMenu != 5);
	}
}