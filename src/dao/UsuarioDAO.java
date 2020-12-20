package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioDAO {
	
	private static UsuarioDAO instancia;
	
	private Connection conexao;
	
	private UsuarioDAO() {
	
	}
	
	private void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public static UsuarioDAO getInstancia(Connection conexao) {
		if(instancia == null) {
			instancia = new UsuarioDAO();
		}
		instancia.setConexao(conexao);
		return instancia;
	}
	
	public boolean cadastrar(Usuario usuario) {
		
		String comando = "INSERT INTO usuario VALUES(default,?,?,?)";
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(comando);
			
			stmt.setString(1, usuario.getNome());
			stmt.setString(2,usuario.getEmail());
			stmt.setString(3,usuario.getSenha());
			
			stmt.execute();
			
			stmt.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Erro ao cadastrar usuario");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Usuario buscarPorEmailESenha(Usuario usuario) {
		
		String comando = "SELECT * FROM usuario WHERE email=? AND senha=?";
		
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(comando);
			
			stmt.setString(1, usuario.getEmail());
			stmt.setString(2, usuario.getSenha());
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
			}
			
			rs.close();
			stmt.close();
			
			if(usuario.getId() == 0) return null;
			
			return usuario;
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar usuario");
			e.printStackTrace();
			return null;
		}
		
	}
	
}
