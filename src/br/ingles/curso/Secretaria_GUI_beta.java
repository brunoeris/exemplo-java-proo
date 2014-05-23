package br.ingles.curso;
import javax.swing.JOptionPane;

public class Secretaria_GUI_beta {
	
	public static void main(String[] args) {
		

		Aluno aluno = new Aluno("",0);
		
		Boletim boletim = new Boletim(aluno.nome, aluno.matricula, 0, 0);
		
		int opcaoMenu;
		
		do{
			
		String opcao = JOptionPane.showInputDialog("CURSO DE INGLÊS 'HOW ARE YOU LEARNING?'\nMENU\n1- PARA INSERIR ALUNO\n2- PARA PROCURAR UM ALUNO\n3- PARA INSERIR NOTAS DE UM ALUNO\n4- PARA EDITAR A NOTA DE UM ALUNO\n5- PARA MOSTRAR O BOLETIM DE UM ALUNO\n6- PARA EXCLUIR UM ALUNO\n7- PARA FECHAR O PROGORAMA");
		opcaoMenu = Integer.parseInt(opcao);
		
			switch (opcaoMenu){
			//inserirAluno()
			
				case 1:
				
					String nome = JOptionPane.showInputDialog("Digite o nome: ");
					aluno.setNome(nome);
					String matricula = JOptionPane.showInputDialog("Digite a matricula: ");
					int matricula1 = Integer.parseInt(matricula);
					aluno.setMatricula(matricula1);
					System.out.print("\n");
				break;
				
				case 2:
				//procurarAluno();
					
					int procurar;
					
					String procura = JOptionPane.showInputDialog("Digite o nome a matricula do aluno que voce deseja encontrar: ");
					procurar = Integer.parseInt(procura);
					
					if(procurar == aluno.matricula){
						JOptionPane.showMessageDialog(null, "Aluno encontrado!");
						aluno.imprimir();	
					}else{
						JOptionPane.showMessageDialog(null, "Aluno nao encontrado!");
					}
					System.out.print("\n");
				break;
				
				case 3:	
				//inserirNotas()
				
					String nota_1= JOptionPane.showInputDialog("Digite a nota da primeira prova: ");
					float nota1 = Float.parseFloat(nota_1);
					String nota_2 = JOptionPane.showInputDialog("Digite a nota da segunda prova: ");
					float nota2 = Float.parseFloat(nota_2);
					boletim.setNota1(nota1);
					boletim.setNota2(nota2);
					boletim.setNotaFinal((boletim.getNota1()+boletim.getNota2())/2);
				break;
				
				case 4:
				//editarNotas()
					String procura1 = JOptionPane.showInputDialog("Digite a matricula do aluno que voce deseja editar a nota: ");
					procurar = Integer.parseInt(procura1);
					
					if(procurar == aluno.matricula){
						String escolha1 = JOptionPane.showInputDialog("Aluno Encontrado!\nVocê deseja editar qual das notas do aluno? Digite:\n1- A primeira nota\n2-A segunda nota");
						int escolha = Integer.parseInt(escolha1);
						
						if(escolha == 1){
							nota_1 = JOptionPane.showInputDialog("Digite a nova nota do aluno: ");
							nota1 = Float.parseFloat(nota_1);
							boletim.setNota1(nota1);
							boletim.setNotaFinal((boletim.getNota1()+boletim.getNota2())/2);
							boletim.imprimirBoletim();
						}
						
						if(escolha == 2){
							nota_2 = JOptionPane.showInputDialog("Digite a nova nota do aluno: ");
							nota2 = Float.parseFloat(nota_2);
							boletim.setNota2(nota2);
							boletim.setNotaFinal((boletim.getNota1()+boletim.getNota2())/2);
							boletim.imprimirBoletim();
						}
							
					}else{
						JOptionPane.showMessageDialog(null,"Aluno nao encontrado!");
					}
				break;
				
				
				case 5:
				//mostrarBoletim
						boletim.imprimirBoletim();
				break;
				
				/*
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
				*/
			}
		
		}while (opcaoMenu != 7);
	
	
	}


}
