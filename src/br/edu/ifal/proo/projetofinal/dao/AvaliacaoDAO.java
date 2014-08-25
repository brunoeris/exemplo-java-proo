package br.edu.ifal.proo.projetofinal.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifal.proo.projetofinal.model.Avaliacao;
import br.edu.ifal.proo.projetofinal.model.Professor;
import br.edu.ifal.proo.projetofinal.bd.ConexaoBD;

public class AvaliacaoDAO {
	
	public void save(Avaliacao avaliacao){
		String sql = "INSERT INTO avaliacao(nomedaprova,nivel,data,situacao,cpfaplicador,codprova)" +
				" VALUES('"+avaliacao.getNomeDaProva()+"','"+avaliacao.getNivel()+"','"+avaliacao.getData()+"','"+avaliacao.getSituacao()+"','"+avaliacao.getCpfDoProfessor()+"','"+avaliacao.getCodigo()+"')";
		System.out.println(sql);
		ConexaoBD.executa(sql);
	}
	
	public boolean find(String codigo) {
		String sql = "SELECT * FROM avaliacao  WHERE codprova="+codigo;
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
	
	public Avaliacao findAndList(String codigo) {
		String sql = "SELECT * FROM avaliacao  WHERE codprova="+codigo;
		ResultSet resultado = ConexaoBD.consulta(sql);
		Avaliacao avaliacao = new Avaliacao();
		try {
			if (resultado.next()){
				String cpf = resultado.getString("cpfaplicador");
				int situacao = resultado.getInt("situacao");
				avaliacao.setSituacao(situacao);
				avaliacao.mostrar(cpf);
			}
		} catch (SQLException e) {	
			System.err.println(e);
		}
		return avaliacao;
	}
	
	public boolean update(Avaliacao avaliacao){
		String sql = "UPDATE avaliacao SET nomedaprova = '"+avaliacao.getNomeDaProva()+"', nivel ='"+avaliacao.getNivel()+", codprova ='"+avaliacao.getCodigo()+" WHERE codprova="+avaliacao.getCodigo();
		System.out.println(sql);
		return ConexaoBD.executa(sql);
	}
	
	public boolean updateSituacao(Avaliacao avaliacao){
		String sql = "UPDATE avaliacao SET situacao = '"+avaliacao.getSituacao()+"' WHERE codprova="+avaliacao.getCodigo();
		System.out.println(sql);
		return ConexaoBD.executa(sql);
	}
	
	public boolean mostrar(String cpfProfessor){
		String sql = "SELECT * FROM avaliacao INNER JOIN professor ON professor.cpf = cpfaplicador WHERE cpfaplicador="+cpfProfessor;
		ResultSet resultado = ConexaoBD.consulta(sql);
		try {
			if (resultado.next()){
				String nomeAplicador = resultado.getString("nome");
				cpfProfessor = resultado.getString("cpfaplicador");
				String nomeDaProva = resultado.getString("nomedaprova");
				String data = resultado.getString("data");
				String nivel = resultado.getString("nivel");
				String codigo = resultado.getString("codprova");
				System.out.println("  CÓDIGO DA PROVA: "+codigo);
				System.out.println("  NOME DA PROVA: "+nomeDaProva);
				System.out.println("  APLICADOR: "+nomeAplicador);
				System.out.println("  DATA: "+data);
				System.out.println("  NIVEL: "+nivel);
				return true;
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return false;
	}
	
	//contarProvas()
	public int count(){
		String sql = "SELECT count(*) AS quant FROM avaliacao";
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
	
	//listarAvaliacoesFindALL()
	public ArrayList findAll(){
		ArrayList avaliacoes = new ArrayList();
		try {
			ResultSet resultado = ConexaoBD.consulta("SELECT * FROM avaliacao ORDER by data");
			while(resultado.next()){
				String nome = resultado.getString("nomedaprova");
				String cpf = resultado.getString("cpfaplicador");
				String nivel = resultado.getString("nivel");
				String data = resultado.getString("data");
				int situacao = resultado.getInt("situacao");
				String codigo = resultado.getString("codprova");
				Avaliacao aux = new Avaliacao(data,nome,nivel,situacao,cpf,codigo);
				avaliacoes.add(aux);
			}
		}catch (SQLException e) {
			System.out.println(e);
		}
		return avaliacoes;

	}

}
