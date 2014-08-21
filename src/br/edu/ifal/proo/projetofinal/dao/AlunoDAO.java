package br.edu.ifal.proo.projetofinal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.bd.ConexaoBD;
import br.edu.ifal.proo.projetofinal.model.Aluno;
import br.edu.ifal.proo.projetofinal.model.Boletim;

public class AlunoDAO {
	
	public void save(Aluno aluno){
		String sql = "INSERT INTO aluno(nome,cpf,sexo,idade," +
				"endereco,cidade,estado, matricula, identidade, nivel, cpfcontratante) VALUES ('"+aluno.getNome()+"','"+aluno.getCpf()+"','"+aluno.getSexo()+"',"+aluno.getIdade()+",'"+aluno.getEndereco()+"','"+aluno.getCidade()+"','"+aluno.getEstado()+"','"+aluno.getMatricula()+"','"+aluno.getRg()+"','"+aluno.getNivel()+"','"+aluno.getContratanteCpf()+"')";
		String sql1 = "INSERT INTO boletim (matriculab) VALUES('"+aluno.getMatricula()+"')";
		System.out.println(sql);
		ConexaoBD.executa(sql);
		ConexaoBD.executa(sql1);
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
				String contratanteCpf = resultado.getString("cpfcontratante");
 				Aluno aux = new Aluno(nome, cpf, sexo, idade, endereco, cidade, estado, matricula, rg, nivel,contratanteCpf);
				alunos.add(aux);
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return alunos;

	}
	
	public boolean update(Aluno aluno){
		String sql = "UPDATE aluno SET nome = '"+aluno.getNome()+"', sexo ='"+aluno.getSexo()+"', idade = '"+aluno.getIdade()+"', endereco ='"+aluno.getEndereco()+"', cidade ='"+aluno.getCidade()+ "', estado ='"+aluno.getEstado()+"', nivel='"+aluno.getNivel()+"', cpfcontratante='"+aluno.getContratanteCpf()+"' WHERE matricula = "+aluno.getMatricula();
		System.out.println(sql);
		return ConexaoBD.executa(sql);
	}

	public boolean find(String matricula) {
		String sql = "SELECT * FROM aluno WHERE matricula="+matricula;
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
				String cpf = resultado.getString("cpf");
				String sexo = resultado.getString("sexo");
				int idade = resultado.getInt("idade");
				String endereco = resultado.getString("endereco");
				String cidade = resultado.getString("cidade");
				String estado = resultado.getString("estado");
				int rg = resultado.getInt("identidade");
				String nivel = resultado.getString("nivel");
				String contratanteCpf = resultado.getString("cpfcontratante");
				System.out.println("  Nome = "+nome);
				System.out.println("  Matricula: "+matricula);
				System.out.println("  CPF do Contratante: "+contratanteCpf);
				System.out.println("  Sexo: "+sexo);
				System.out.println("  Idade: "+idade);
				System.out.println("  Cidade: "+cidade);
				System.out.println("  Endereco: "+endereco);
				System.out.println("  Estado: "+estado);
				System.out.println("  RG: "+rg);
				System.out.println("  Nivel: "+nivel);
				return true;
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;

	}
	
	public Aluno mostrarBoletim(String matricula){	
		String sql = "SELECT * FROM aluno INNER JOIN boletim ON aluno.matricula = boletim.matriculab WHERE aluno.matricula="+matricula;
		ResultSet resultado = ConexaoBD.consulta(sql);
		Aluno aluno = new Aluno();
		Boletim boletim = new Boletim();
		try {
			if (resultado.next()){
				aluno.setNome(resultado.getString("nome"));
				aluno.setMatricula(resultado.getString("matricula"));
				aluno.getBoletim().setNotaA(resultado.getDouble("notaa"));
				aluno.getBoletim().setNotaB(resultado.getDouble("notab"));
				aluno.getBoletim().setMedia(resultado.getDouble("media"));
				System.out.println("|----------------- BOLETIM -----------------|");
				System.out.println("Nome: "+aluno.getNome());
				System.out.println("Matricula: "+aluno.getMatricula());
				boletim = aluno.getBoletim();
				boletim.setMatricula(resultado.getString("matricula"));
				System.out.println("Nota da Primeira Prova: "+aluno.getBoletim().getNotaA());
				System.out.println("Nota da Segunda Prova: "+aluno.getBoletim().getNotaB());
				System.out.println("Media: "+aluno.getBoletim().getMedia());
				System.out.println("|-------------------------------------------|");
				return aluno;
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return aluno;

	}
	
	public boolean delete(String matricula){
		String sql = "DELETE FROM aluno WHERE matricula="+matricula;
		String sql0 = "DELETE FROM boletim  WHERE matriculab="+matricula;
		ConexaoBD.executa(sql0);
		return ConexaoBD.executa(sql);
	}


}
