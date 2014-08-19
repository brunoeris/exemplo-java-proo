package br.edu.ifal.proo.projetofinal.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.model.Contratante;
import br.edu.ifal.proo.projetofinal.bd.ConexaoBD;

public class ContratanteDAO {
	
	//inserirContratante()
	public void save(Contratante contratante){
		String sql = "INSERT INTO contratante(nome,cpf,sexo,idade," +
				"endereco,cidade,estado) VALUES ('"+contratante.getNome()+"','"+contratante.getCpf()+"','"+contratante.getSexo()+"',"+contratante.getIdade()+",'"+contratante.getEndereco()+"','"+contratante.getCidade()+"','"+contratante.getEstado()+"')";
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
				Contratante aux = new Contratante(nome, cpf, sexo, idade, endereco, cidade, estado);
				contratantes.add(aux);
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return contratantes;

	}
	
	public boolean update(Contratante contratante){
		String sql = "UPDATE contratante SET nome = '"+contratante.getNome()+"' WHERE cpf = "+contratante.getCpf();
		System.out.println(sql);
		return ConexaoBD.executa(sql);
	}


}
