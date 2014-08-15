package br.edu.ifal.proo.projetofinal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.model.Contratante;
import br.edu.ifal.proo.projetofinal.bd.ConexaoBD;

public class ContratanteDAO {
	
	public void save(Contratante contratante){
		String sql = "INSERT INTO contratante(nome,cpf,sexo, idade," +
				"endereco,cidade,estado VALUES ('"+contratante.getNome()+"','"+contratante.getCpf()+"',"+contratante.getIdade()+"" +
						",'"+contratante.getEndereco()+"','"+contratante.getCidade()+"','"+contratante.getEstado()+"')";
		System.out.println(sql);
		ConexaoBD.executa(sql);
	}
	
}
