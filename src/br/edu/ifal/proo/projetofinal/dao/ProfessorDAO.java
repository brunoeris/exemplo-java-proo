package br.edu.ifal.proo.projetofinal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.model.Aluno;
import br.edu.ifal.proo.projetofinal.model.Professor;
import br.edu.ifal.proo.projetofinal.bd.ConexaoBD;

public class ProfessorDAO {
	
	public void save(Professor professor){
		String sql = "INSERT INTO professor(nome,cpf,sexo,idade," +
				"endereco,cidade,estado,ministrando) VALUES ('"+professor.getNome()+"','"+professor.getCpf()+"','"+professor.getSexo()+"','"+professor.getIdade()+"','"+professor.getEndereco()+"','"+professor.getCidade()+"','"+professor.getEstado()+"','"+professor.getMinistrandoAula()+"')";
		System.out.println(sql);
		ConexaoBD.executa(sql);
		return;
	}

	//contaProfessores()
	public int count(){
		String sql = "SELECT count(*) AS quant FROM professor";
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
		ArrayList professores = new ArrayList();
		try {
			ResultSet resultado = ConexaoBD.consulta("SELECT * FROM professor ORDER by nome");
			while(resultado.next()){
				String nome = resultado.getString("nome");
				String cpf = resultado.getString("cpf");
				String sexo = resultado.getString("sexo");
				int idade = resultado.getInt("idade");
				String endereco = resultado.getString("endereco");
				String cidade = resultado.getString("cidade");
				String estado = resultado.getString("estado");
				int ministrandoAula = resultado.getInt("ministrando");
 				Professor aux = new Professor(nome, cpf, sexo, idade, endereco, cidade, estado,ministrandoAula);
				professores.add(aux);
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return professores;

	}
	
	
	public boolean update(Professor professor){
		String sql = "UPDATE professor SET nome = '"+professor.getNome()+"', sexo ='"+professor.getSexo()+"', idade ='"+professor.getIdade()+"', endereco ='"+professor.getEndereco()+"', cidade ='"+professor.getCidade()+ "', estado ='"+professor.getEstado()+"' WHERE cpf = "+professor.getCpf();
		System.out.println(sql);
		return ConexaoBD.executa(sql);
	}
	
	public boolean updatePresenca(Professor professor){
		String sql = "UPDATE professor SET ministrando = '"+professor.getMinistrandoAula()+"' WHERE cpf = "+professor.getCpf();
		System.out.println(sql);
		return ConexaoBD.executa(sql);
	}

	public boolean find(String cpf) {
		String sql = "SELECT * FROM professor WHERE cpf="+cpf;
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
	
	public boolean mostrar(String cpf){
		String sql = "SELECT * FROM professor WHERE cpf="+cpf;
		ResultSet resultado = ConexaoBD.consulta(sql);
		try {
			if (resultado.next()){
				String nome = resultado.getString("nome");
				cpf = resultado.getString("cpf");
				System.out.println("Nome: "+nome);
				System.out.println("CPF: "+cpf);
				return true;
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;
	}
	
	public boolean delete(String cpf){
		String sql = "DELETE FROM professor WHERE cpf="+cpf;
		return ConexaoBD.executa(sql);
	}
}
