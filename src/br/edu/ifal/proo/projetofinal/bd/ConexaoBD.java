package br.edu.ifal.proo.projetofinal.bd;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class ConexaoBD{
    
    public static Connection con = null;
    
    private ConexaoBD(){
        
        //Access
        //String URL = "jdbc:odbc:aula";

        //MySQL
        String URL = "jdbc:mysql://localhost/cursodeingles";
        
        try {
            //Access
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
            //MySQL
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.out.println("Erro no Driver: "+e);
            return;
        }
        
        try {
            if(con==null)
                con = DriverManager.getConnection(URL,"root","");
        } catch (Exception e) {
            System.out.println("Erro na conexao: "+e);
        }
    }
    
    public static boolean executa(String sql){
        ConexaoBD bd = new ConexaoBD();
        Statement stmt = null;
        
        try{
            stmt = bd.con.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("executando "+sql);
            //bd.con.close();
        }
        catch(Exception e){
            System.out.println("Erro="+e);
            return false;
        }
        return true;
    }
    
    public static ResultSet consulta(String query){

        ConexaoBD bd = new ConexaoBD();
        Statement stmt = null;
        ResultSet result = null;
        
        try{
            stmt = bd.con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            result = stmt.executeQuery(query);
        }
        catch(Exception e){
            System.out.println("Erro na consulta = "+e.getMessage());
        }
        return result;
    }
    
    /*
    public static void main(String[] args){
        //Exemplo de uso:
    	System.out.println("Tentando conectar...");
        new ConexaoBD();
        System.out.println("Fim!");
        
        //Inserindo dados
        ConexaoBD.executa("INSERT INTO Produto(cod, descricao, preco, data) VALUES(1, 'Livro Harry Potter',130.90,'2012-01-24')");
        
        //Consultando os dados
        ResultSet result = ConexaoBD.consulta("SELECT * FROM Produto");
        
        try{
        	while (result.next()){
        		String descricao = result.getString("descricao"); 
        		double preco = result.getDouble("preco");
        		Date data = result.getDate("data");
        		System.out.println("Descricao = "+descricao+" Preco = "+preco+" Data "+data);
        	}
        }
        catch(Exception e){
            System.out.println(e);
        }
    }*/
}
