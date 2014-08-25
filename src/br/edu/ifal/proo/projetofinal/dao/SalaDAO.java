package br.edu.ifal.proo.projetofinal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.bd.ConexaoBD;
import br.edu.ifal.proo.projetofinal.model.Aluno;
import br.edu.ifal.proo.projetofinal.model.Sala;

public class SalaDAO {
	
	public void save(Sala sala){
		String sql = "INSERT INTO sala(numero,cadeiras,ocupada) VALUES ('"+sala.getNumero()+"','"+sala.getQtdCadeiras()+"','1')";
		System.out.println(sql);
		ConexaoBD.executa(sql);
	}
	
	public ArrayList findAll(){
		ArrayList salas = new ArrayList();
		try {
			ResultSet resultado = ConexaoBD.consulta("SELECT * FROM sala ORDER by numero");
			while(resultado.next()){
				int numero = resultado.getInt("numero");
				int cadeiras = resultado.getInt("cadeiras");
				int ocupada = resultado.getInt("ocupada");
				Sala aux = new Sala(numero, cadeiras);
				aux.ocupada = ocupada;
				salas.add(aux);
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return salas;
	}
	
	public boolean update(Sala sala){
		String sql = "UPDATE sala SET numero = '"+sala.getNumero()+"', cadeiras ='"+sala.getQtdCadeiras()+"', ocupada = '"+sala.getOcupada()+"' WHERE numero = "+sala.getNumero();
		System.out.println(sql);
		return ConexaoBD.executa(sql);
	}
	
	public boolean find(int numero) {
		String sql = "SELECT * FROM sala WHERE numero="+numero;
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
	
}
