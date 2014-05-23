package br.ingles.curso;
import javax.swing.JOptionPane;

public class Secretaria_GUI_beta {
	
	public static void main(String[] args) {
		

		Aluno_GUI aluno = new Aluno_GUI();
		Boletim_GUI boletim = new Boletim_GUI();
		
		int opcaoMenu;
		
		do{
			
		String opcao = JOptionPane.showInputDialog("CURSO DE INGLÊS 'HOW ARE YOU LEARNING?'\nMENU\n1- PARA INSERIR ALUNO\n2- PARA PROCURAR UM ALUNO\n3- PARA INSERIR NOTAS DE UM ALUNO\n4- PARA EDITAR A NOTA DE UM ALUNO\n5- PARA MOSTRAR O BOLETIM DE UM ALUNO\n6- PARA EXCLUIR UM ALUNO\n7- PARA FECHAR O PROGORAMA");
		opcaoMenu = Integer.parseInt(opcao);
		
			switch (opcaoMenu){
			
				case 1:
				//inserirAluno()
				
					String nome = JOptionPane.showInputDialog("Digite o nome: ");
					aluno.setNome(nome);
					String matricula = JOptionPane.showInputDialog("Digite a matricula: ");
					int matric = Integer.parseInt(matricula);
					aluno.setMatricula(matric);
					
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
						}
						
						if(escolha == 2){
							nota_2 = JOptionPane.showInputDialog("Digite a nova nota do aluno: ");
							nota2 = Float.parseFloat(nota_2);
							boletim.setNota2(nota2);
							boletim.setNotaFinal((boletim.getNota1()+boletim.getNota2())/2);
						}
							
					}else{
						JOptionPane.showMessageDialog(null,"Aluno nao encontrado!");
					}
				break;
				
				
				case 5:
				//mostrarBoletim
					
						JOptionPane.showMessageDialog(null,"NOTAS\nNome: "+aluno.getNome()+"\nMatricula: "+aluno.getMatricula()+"\nNota da primeira prova: "+boletim.getNota1()+"\nNota da segunda prova: "+boletim.getNota2()+"\n\nMÉDIA FINAL: "+boletim.getNotaFinal());
				break;
				
				case 6:
				//excluirAluno()
					
					String excluir =JOptionPane.showInputDialog("Digite a matrícula do aluno que voce deseja excluir: ");
					int delete = Integer.parseInt(excluir);
					
					if(delete == aluno.matricula){
						int escolha= JOptionPane.showConfirmDialog(null, "Aluno Encontrado!\nNome: "+aluno.nome+"\nMatricula: "+aluno.matricula+"\nVoce tem certeza de que quer excluir o aluno?");
			
						if(escolha == JOptionPane.YES_OPTION){
							aluno = new Aluno_GUI();
							JOptionPane.showMessageDialog(null, "Aluno Excluído!");
						}
						
					}
				break;
			}
		
		}while (opcaoMenu != 7);
	
	
	}


}
