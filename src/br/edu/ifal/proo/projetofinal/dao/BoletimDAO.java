package br.edu.ifal.proo.projetofinal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.ifal.proo.projetofinal.bd.ConexaoBD;
import br.edu.ifal.proo.projetofinal.model.Aluno;
import br.edu.ifal.proo.projetofinal.model.Boletim;

public class BoletimDAO {
	public void save(Boletim boletim){
		String sql = "INSERT INTO boletim(notaa, notab, media) VALUES ('"+boletim.getNotaA()+"','"+boletim.getNotaB()+"','"+boletim.getMedia()+"')";
		System.out.println(sql);
		ConexaoBD.executa(sql);
	}
	
	public boolean update(Boletim boletim){
		String sql = "UPDATE boletim SET matriculab = '"+boletim.getMatricula()+"', notaa ='"+boletim.getNotaA()+"', notab = '"+boletim.getNotaB()+"', media ='"+boletim.getMedia()+"' WHERE matriculab = "+boletim.getMatricula();
		System.out.println(sql);
		return ConexaoBD.executa(sql);
	}

	public boolean find(String matricula) {
		String sql = "SELECT * FROM boletim WHERE matriculab="+matricula;
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
	
	/*public boolean mostrar(String matricula){
		String sql = "SELECT * FROM aluno WHERE matricula="+matricula;
		ResultSet resultado = ConexaoBD.consulta(sql);
		try {
			if (resultado.next()){
				String nome = resultado.getString("nome");
				matricula = resultado.getString("matricula");
				System.out.println("Nome: "+nome);
				System.out.println("CPF: "+matricula);
				return true;
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;
	
	}
	*/
}