package br.edu.ifal.proo.projetofinal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.bd.ConexaoBD;
import br.edu.ifal.proo.projetofinal.model.Aluno;

public class AlunoDAO {
	
	public void save(Aluno aluno){
		String sql = "INSERT INTO aluno(nome,cpf,sexo,idade," +
				"endereco,cidade,estado, matricula, identidade, nivel) VALUES ('"+aluno.getNome()+"','"+aluno.getCpf()+"','"+aluno.getSexo()+"',"+aluno.getIdade()+",'"+aluno.getEndereco()+"','"+aluno.getCidade()+"','"+aluno.getEstado()+"','"+aluno.getMatricula()+"','"+aluno.getRg()+"','"+aluno.getNivel()+"')";
		System.out.println(sql);
		ConexaoBD.executa(sql);
	}
	
	//listarContratantes()
	public int count(){
		String sql = "SELECT count(*) AS quant FROM aluno";
		ResultSet resultado = ConexaoBD.consulta(sql);
		int quant = 0;
		try {
			if (resultado.next()){
				quant = resultado.getInt("quant");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return quant; 
	}
	
	//listarContratantesFindALL()
	public ArrayList findAll(){
		ArrayList alunos = new ArrayList();
		try {
			ResultSet resultado = ConexaoBD.consulta("SELECT * FROM aluno ORDER by nome");
			while(resultado.next()){
				String nome = resultado.getString("nome");
				String cpf = resultado.getString("cpf");
				String sexo = resultado.getString("sexo");
				int idade = resultado.getInt("idade");
				String endereco = resultado.getString("endereco");
				String cidade = resultado.getString("cidade");
				String estado = resultado.getString("estado");
				String matricula = resultado.getString("matricula");
				int rg = resultado.getInt("identidade");
				String nivel = resultado.getString("nivel");
 				Aluno aux = new Aluno(nome, cpf, sexo, idade, endereco, cidade, estado, matricula, rg, nivel);
				alunos.add(aux);
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return alunos;

	}
	
	public boolean update(Aluno aluno){
		String sql = "UPDATE aluno SET nome = '"+aluno.getNome()+"', sexo ='"+aluno.getSexo()+", idade = "+aluno.getIdade()+"', endereco ='"+aluno.getEndereco()+"', cidade ='"+aluno.getCidade()+ "', estado ='"+aluno.getEstado()+"' WHERE matricula = "+aluno.getMatricula();
		System.out.println(sql);
		return ConexaoBD.executa(sql);
	}

	public boolean find(String cpf) {
		String sql = "SELECT * FROM contratante WHERE cpf="+cpf;
		ResultSet resultado = ConexaoBD.consulta(sql);
		try {
			if (resultado.next()){
				return true;
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;
	}
	
	public boolean mostrar(String matricula){
		String sql = "SELECT * FROM aluno WHERE matricula="+matricula;
		ResultSet resultado = ConexaoBD.consulta(sql);
		try {
			if (resultado.next()){
				String nome = resultado.getString("nome");
				matricula = resultado.getString("matricula");
				System.out.println("Nome: "+nome);
				System.out.println("Matricula: "+matricula);
				return true;
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;

	}
	
	public boolean mostrarBoletim(String matricula){
		String sql = "SELECT * FROM aluno WHERE matricula="+matricula;
		ResultSet resultado = ConexaoBD.consulta(sql);
		try {
			if (resultado.next()){
				String nome = resultado.getString("nome");
				matricula = resultado.getString("matricula");
				System.out.println("Nome: "+nome);
				System.out.println("Matricula: "+matricula);
				return true;
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;

	}


}
