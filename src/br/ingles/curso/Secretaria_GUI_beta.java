package br.ingles.curso;
import javax.swing.JOptionPane;

public class Secretaria_GUI_beta {
	
	public static void main(String[] args) {
		
		final int TAMANHO = 50;
		int i = 0;
		int b = 0;
		
		Aluno_GUI[] aluno = new Aluno_GUI[TAMANHO];
		Boletim_GUI[] boletim = new Boletim_GUI[TAMANHO];
		
		int opcaoMenu;
		
		do{
			
		String opcao = JOptionPane.showInputDialog("CURSO DE INGLÊS 'HOW ARE YOU LEARNING?'\nMENU\n1- PARA INSERIR ALUNO\n2- PARA PROCURAR UM ALUNO\n3- PARA INSERIR NOTAS DE UM ALUNO\n4- PARA EDITAR A NOTA DE UM ALUNO\n5- PARA MOSTRAR O BOLETIM DE UM ALUNO\n6- PARA EXCLUIR UM ALUNO\n7- PARA FECHAR O PROGORAMA");
		opcaoMenu = Integer.parseInt(opcao);
		
			switch (opcaoMenu){
			
				case 1:
				//inserirAluno()
				aluno[i] = new Aluno_GUI();
					String nome = JOptionPane.showInputDialog("Digite o nome: ");
					aluno[i].setNome(nome);
					String matricula = JOptionPane.showInputDialog("Digite a matricula: ");
					int matric = Integer.parseInt(matricula);
					aluno[i].setMatricula(matric);
					i++;
					
				break;
				
				case 2:
				//procurarAluno();
					
					int j;
					int achou = 0;
					int procurar;
					
					String procura = JOptionPane.showInputDialog("Digite a matricula do aluno que voce deseja encontrar: ");
					procurar = Integer.parseInt(procura);
					
					for(j=0;j<=TAMANHO;j++){
						if(procurar == aluno[j].matricula){
							JOptionPane.showMessageDialog(null, "Aluno encontrado!");
							aluno[j].imprimir();
							achou = 1;
							break;
						}
						
						if (achou == 0){
							JOptionPane.showMessageDialog(null, "Aluno nao encontrado!");
						}
					}
				break;
				
				case 3:	
				//inserirNotas()				
				boletim[b] = new Boletim_GUI();
				
				String procura3 = JOptionPane.showInputDialog("Digite a matricula do aluno que voce deseja cadastrar notas: ");
				procurar = Integer.parseInt(procura3);
					
				for(b=0;b<=TAMANHO;b++){
					if(procurar == aluno[b].matricula){
						JOptionPane.showMessageDialog(null, "Aluno encontrado!");
						aluno[b].imprimir();
						break;
					}
				}
					
				String nota_1= JOptionPane.showInputDialog("Digite a nota da primeira prova: ");
				float nota1 = Float.parseFloat(nota_1);
				boletim[b].setNota1(nota1);
				String nota_2 = JOptionPane.showInputDialog("Digite a nota da segunda prova: ");
				float nota2 = Float.parseFloat(nota_2);
				boletim[b].setNota2(nota2);
				boletim[b].setNotaFinal((boletim[b].getNota1()+boletim[b].getNota2())/2);
				break;
	
				case 4:
				//editarNotas()
					int e;
					int encontrou = 0;
					
					String procura1 = JOptionPane.showInputDialog("Digite a matricula do aluno que voce deseja editar a nota: ");
					procurar = Integer.parseInt(procura1);
					
					for(e=0;e<=TAMANHO;e++){
						if(procurar == aluno[e].matricula){
							String escolha1 = JOptionPane.showInputDialog("Aluno Encontrado!\nVocê deseja editar qual das notas do aluno? Digite:\n1- A primeira nota\n2-A segunda nota");
							int escolha = Integer.parseInt(escolha1);
							String Nota1, Nota2;
							
							if(escolha == 1){
								Nota1 = JOptionPane.showInputDialog("Digite a nova nota do aluno: ");
								float nota11 = Float.parseFloat(Nota1);
								boletim[e].setNota1(nota11);
								boletim[e].setNotaFinal((boletim[e].getNota1()+boletim[e].getNota2())/2);
								break;
							}
							
							if(escolha == 2){
								Nota2 = JOptionPane.showInputDialog("Digite a nova nota do aluno: ");
								float nota21 = Float.parseFloat(Nota2);
								boletim[e].setNota2(nota21);
								boletim[e].setNotaFinal((boletim[e].getNota1()+boletim[e].getNota2())/2);
								break;
							}
						encontrou = 1;
						}	
						
					}
							
					if(encontrou == 0){
						JOptionPane.showMessageDialog(null,"Aluno nao encontrado!");
					}
				break;
				
				
				case 5:
				//mostrarBoletim
				int m;
				int checaboletim = 0;
					String procura2 = JOptionPane.showInputDialog("Digite a matricula do aluno que voce deseja editar a nota: ");
					procurar = Integer.parseInt(procura2);
					
					for(m=0;m<=TAMANHO;m++){
						if(procurar == aluno[m].matricula){
							JOptionPane.showMessageDialog(null,"NOTAS\nNome: "+aluno[m].getNome()+"\nMatricula: "+aluno[m].getMatricula()+"\nNota da primeira prova: "+boletim[m].getNota1()+"\nNota da segunda prova: "+boletim[m].getNota2()+"\n\nMÉDIA FINAL: "+boletim[m].getNotaFinal());
							checaboletim = 1;
							break;
						}
					}
					
					if(checaboletim == 0)
						JOptionPane.showMessageDialog(null,"Aluno nao encontrado!");
				break;
				
				case 6:
				//excluirAluno()
					
					String excluir =JOptionPane.showInputDialog("Digite a matrícula do aluno que voce deseja excluir: ");
					int delete = Integer.parseInt(excluir);
					
					if(delete == aluno[TAMANHO].matricula){
						int escolha= JOptionPane.showConfirmDialog(null, "Aluno Encontrado!\nNome: "+aluno[TAMANHO].nome+"\nMatricula: "+aluno[TAMANHO].matricula+"\nVoce tem certeza de que quer excluir o aluno?");
			
						if(escolha == JOptionPane.YES_OPTION){
							aluno[TAMANHO] = new Aluno_GUI();
							JOptionPane.showMessageDialog(null, "Aluno Excluído!");
						}
						
					}
				break;
			}
		
		}while (opcaoMenu != 7);
	
	
	}


}
