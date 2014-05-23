package br.ingles.curso;
import javax.swing.JOptionPane;

public class Secretaria_GUI_beta {
	
	public static void main(String[] args) {
		

		Aluno_GUI aluno = new Aluno_GUI("",0);
		Boletim_GUI boletim_GUI = new Boletim_GUI(aluno.nome, aluno.matricula, 0, 0);
		
		int opcaoMenu;
		
		do{
			
		String opcao = JOptionPane.showInputDialog("CURSO DE INGLÊS 'HOW ARE YOU LEARNING?'\nMENU\n1- PARA INSERIR ALUNO\n2- PARA PROCURAR UM ALUNO\n3- PARA INSERIR NOTAS DE UM ALUNO\n4- PARA EDITAR A NOTA DE UM ALUNO\n5- PARA MOSTRAR O BOLETIM DE UM ALUNO\n6- PARA EXCLUIR UM ALUNO\n7- PARA FECHAR O PROGORAMA");
		opcaoMenu = Integer.parseInt(opcao);
		
			switch (opcaoMenu){
			
				case 1:
				//inserirAluno()
				
					aluno.nome = JOptionPane.showInputDialog("Digite o nome: ");
					String matricula = JOptionPane.showInputDialog("Digite a matricula: ");
					aluno.matricula = Integer.parseInt(matricula);
					
				break;
				
				case 2:
				//procurarAluno();
					
					int procurar;
					
					String procura = JOptionPane.showInputDialog("Digite a matricula do aluno que voce deseja encontrar: ");
					procurar = Integer.parseInt(procura);
					
					if(procurar == aluno.matricula){
						JOptionPane.showMessageDialog(null, "Aluno encontrado!");
						aluno.imprimir();	
					}else{
						JOptionPane.showMessageDialog(null, "Aluno nao encontrado!");
					}
				break;
				
				case 3:	
				//inserirNotas()
				
					String nota_1= JOptionPane.showInputDialog("Digite a nota da primeira prova: ");
					float nota1 = Float.parseFloat(nota_1);
					String nota_2 = JOptionPane.showInputDialog("Digite a nota da segunda prova: ");
					float nota2 = Float.parseFloat(nota_2);
					boletim_GUI.setNota1(nota1);
					boletim_GUI.setNota2(nota2);
					boletim_GUI.setNotaFinal((boletim_GUI.getNota1()+boletim_GUI.getNota2())/2);
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
							boletim_GUI.setNota1(nota1);
							boletim_GUI.setNotaFinal((boletim_GUI.getNota1()+boletim_GUI.getNota2())/2);
							boletim_GUI.imprimir();
						}
						
						if(escolha == 2){
							nota_2 = JOptionPane.showInputDialog("Digite a nova nota do aluno: ");
							nota2 = Float.parseFloat(nota_2);
							boletim_GUI.setNota2(nota2);
							boletim_GUI.setNotaFinal((boletim_GUI.getNota1()+boletim_GUI.getNota2())/2);
							boletim_GUI.imprimirBoletim_GUI();
						}
							
					}else{
						JOptionPane.showMessageDialog(null,"Aluno nao encontrado!");
					}
				break;
				
				
				case 5:
				//mostrarBoletim
						boletim_GUI.imprimirBoletim_GUI();
				break;
				
				case 6:
				//excluirAluno()
					
					String excluir =JOptionPane.showInputDialog("Digite a matrícula do aluno que voce deseja excluir: ");
					int delete = Integer.parseInt(excluir);
					
					if(delete == aluno.matricula){
						int escolha= JOptionPane.showConfirmDialog(null, "Aluno Encontrado!\nNome: "+aluno.nome+"\nMatricula: "+aluno.matricula+"\nVoce tem certeza de que quer excluir o aluno?");
			
						if(escolha == JOptionPane.YES_OPTION){
							aluno.excluirAluno();
							aluno.imprimir();
						}
						
					}
				break;
			}
		
		}while (opcaoMenu != 7);
	
	
	}


}
