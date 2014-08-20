package br.edu.ifal.proo.projetofinal.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.model.Contratante;
import br.edu.ifal.proo.projetofinal.bd.ConexaoBD;

public class ContratanteDAO {
	
	public void save(Contratante contratante){
		String sql = "INSERT INTO contratante(nome,cpf,sexo,idade," +
				"endereco,cidade,estado, situacao) VALUES ('"+contratante.getNome()+"','"+contratante.getCpf()+"','"+contratante.getSexo()+"',"+contratante.getIdade()+",'"+contratante.getEndereco()+"','"+contratante.getCidade()+"','"+contratante.getEstado()+"',"+contratante.getPagamento()+")";
		System.out.println(sql);
		ConexaoBD.executa(sql);
	}
	
	//listarContratantes()
	public int count(){
		String sql = "SELECT count(*) AS quant FROM contratante";
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
		ArrayList contratantes = new ArrayList();
		try {
			ResultSet resultado = ConexaoBD.consulta("SELECT * FROM contratante ORDER by nome");
			while(resultado.next()){
				String nome = resultado.getString("nome");
				String cpf = resultado.getString("cpf");
				String sexo = resultado.getString("sexo");
				int idade = resultado.getInt("idade");
				String endereco = resultado.getString("endereco");
				String cidade = resultado.getString("cidade");
				String estado = resultado.getString("estado");
				int pago = resultado.getInt("situacao");
 				Contratante aux = new Contratante(nome, cpf, sexo, idade, endereco, cidade, estado, pago);
				contratantes.add(aux);
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return contratantes;

	}
	
	public boolean updatePgto(Contratante contratante){
		String sql = "UPDATE contratante SET situacao = "+contratante.getPagamento()+" WHERE cpf = "+contratante.getCpf();
		System.out.println(sql);
		return ConexaoBD.executa(sql);
	}
	
	public boolean update(Contratante contratante){
		String sql = "UPDATE contratante SET nome = '"+contratante.getNome()+"', sexo ='"+contratante.getSexo()+", idade = "+contratante.getIdade()+"', endereco ='"+contratante.getEndereco()+"', cidade ='"+contratante.getCidade()+ "', estado ='"+contratante.getEstado()+"' WHERE cpf = "+contratante.getCpf();
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
	
	public boolean mostrar(String cpf){
		String sql = "SELECT * FROM contratante WHERE cpf="+cpf;
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


}
