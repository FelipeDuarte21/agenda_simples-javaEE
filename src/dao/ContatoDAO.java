package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Contato;

public class ContatoDAO {
	
	private static ContatoDAO instance;
	
	private Connection conexao;
	
	private ContatoDAO() {
		
	}
	
	private void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public static ContatoDAO getInstancia(Connection conexao) {
		if(instance == null) {
			instance = new ContatoDAO();
		}
		instance.setConexao(conexao);
		return instance;
	}
	
	public boolean cadastrar(Contato contato) {
		
		String comando = "INSERT INTO contato VALUE(default,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(comando);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getCelular());
			stmt.setString(3, contato.getTelefone());
			stmt.setString(4, contato.getEmail());
			stmt.setInt(5, contato.getUsuario().getId());
			
			stmt.execute();
			
			stmt.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Erro ao inserir contato");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean alterar(Contato contato) {
		
		String comando = "UPDATE contato SET nome=?,celular=?,telefone=?,email=? WHERE id=?";
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(comando);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getCelular());
			stmt.setString(3, contato.getTelefone());
			stmt.setString(4, contato.getEmail());
			stmt.setInt(5, contato.getId());
			
			stmt.execute();
			
			stmt.close();
			
			return true;
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar contato");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Contato buscarPorId(int id) {
		
		String comando = "SELECT * FROM contato WHERE id = ?";
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(comando);
			
			stmt.setInt(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			Contato c = null;
			
			while(rs.next()) {
				c = new Contato();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setCelular(rs.getString("celular"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));
			}
			
			rs.close();
			stmt.close();
			
			return c;
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar contato pelo id");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Contato> listar(Integer idUsuario){
		
		String comando = "SELECT * FROM contato WHERE id_usuario = ? ORDER BY nome ASC";
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(comando);
			
			stmt.setInt(1, idUsuario);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Contato> contatos = new ArrayList<>();
			
			while(rs.next()) {
				
				Contato c = new Contato();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setCelular(rs.getString("celular"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));
				
				contatos.add(c);
				
			}
			
			rs.close();
			stmt.close();
			
			return contatos;
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar contatos");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public boolean excluir(int id) {
		
		String comando = "DELETE FROM contato WHERE id = ?";
		
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(comando);
			
			stmt.setInt(1, id);
			
			stmt.execute();
			
			stmt.close();
			
			return true;
			
		}catch(SQLException e) {
			System.out.println("Erro ao excluir contato");
			e.printStackTrace();
			return false;
		}
		
	}
	
	public int totalElementos(int idUsuario) {
		String comando = "SELECT count(*) as total  FROM contato WHERE id_usuario = ?";
		
		try {
			
			PreparedStatement stmt = this.conexao.prepareStatement(comando);
			
			stmt.setInt(1, idUsuario);
			
			ResultSet rs = stmt.executeQuery();
			rs.next();
			int total = rs.getInt("total");
			
			rs.close();
			stmt.close();
			
			return total;
		} catch (SQLException e) {
			System.out.println("Erro ao buscar o total de registros na tabela");
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public List<Contato> listarPorPagina(int idUsuario, int primeiro, int ultimo){
		
		String comando = "SELECT * FROM contato WHERE id_usuario = ? ORDER BY nome ASC LIMIT ?,?";
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(comando);
			
			stmt.setInt(1, idUsuario);
			stmt.setInt(2, primeiro);
			stmt.setInt(3, ultimo);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Contato> contatos = new ArrayList<>();
			
			while(rs.next()) {
				Contato c = new Contato();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setCelular(rs.getString("celular"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));
		
				contatos.add(c);		
			}
			
			rs.close();
			stmt.close();
			
			return contatos;
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar contatos por paginação");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<Contato> buscarPorNome(int idUsuario, String nome){
		
		String comando = "SELECT * FROM contato WHERE nome LIKE ? AND id_usuario = ?";
		
		try {
			PreparedStatement stmt = this.conexao.prepareStatement(comando);
			
			stmt.setString(1, "%" + nome + "%");
			stmt.setInt(2, idUsuario);
			
			ResultSet rs = stmt.executeQuery();
			
			List<Contato> contatos = new ArrayList<>();
			
			while(rs.next()) {
				
				Contato c = new Contato();
				c.setId(rs.getInt("id"));
				c.setNome(rs.getString("nome"));
				c.setCelular(rs.getString("celular"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));
				
				contatos.add(c);
				
			}
			
			rs.close();
			stmt.close();
			
			return contatos;
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar por nome");
			e.printStackTrace();
			return null;
		}
		
	}
}
