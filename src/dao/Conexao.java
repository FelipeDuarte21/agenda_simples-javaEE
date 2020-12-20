package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private static final String sgbd = "mysql";
	private static final String porta = "3306";
	private static final String usuario = "root";
	private static final String senha = "1234";
	private static final String banco = "contatos";
	
	public static Connection getConnection() {
		
		String url = "jdbc:" + sgbd + "://localhost:" + porta + "/" + banco + "?useTimezone=true&serverTimezone=UTC";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection(url,usuario,senha);	
		
		} catch (ClassNotFoundException e) {
			System.out.println("Classe Driver não encontrada!");
			e.printStackTrace();
			return null;
			
		} catch (SQLException e) {
			System.out.println("Erro na conexão, verifique os parametros da conexão na classe conexão");
			e.printStackTrace();
			return null;
		} 
		
	}
	
}
