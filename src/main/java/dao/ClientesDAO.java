package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Clientes;

public class ClientesDAO extends BaseDAO {
	public static List<Clientes> selectClientes() {
		final String sql = "SELECT * FROM clientes";
		try //try with resource
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			)
		{	
			List<Clientes> clientes = new ArrayList<>();
			while(rs.next()) {
				clientes.add(resultsetToClientes(rs));
			}
			return clientes;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean insertClientes(Clientes clientes) {
		final String sql = "INSERT INTO clientes(nome, idade, telefone, endereco, tipoCliente, senha) VALUES (?, ?, ?, ?, ?, ?)";	
		try
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) 
		{
			pstmt.setString(1, clientes.getNome());
			pstmt.setInt(2, clientes.getIdade());
			pstmt.setLong(3, clientes.getTelefone());
			pstmt.setString(4, clientes.getEndereco());
			pstmt.setString(5, clientes.getTipoCliente());
			pstmt.setString(6, clientes.getSenha());
			int count = pstmt.executeUpdate();
			return count > 0;

		}  catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	
	}
	
	private static Clientes resultsetToClientes(ResultSet rs) throws SQLException {
		Clientes c = new Clientes();
		c.setId(rs.getInt("id"));
		c.setNome(rs.getString("nome"));
		c.setIdade(rs.getInt("idade"));
		c.setTelefone(rs.getLong("telefone"));
		c.setEndereco(rs.getString("endereco"));
		c.setTipoCliente(rs.getString("tipoCliente"));
		
		return c;
	}
	
    public static void main(String[] args) {
    	Clientes c = new Clientes(4, "rosa", 35, 995612321L, "Avenida Dom João", "Pais", "senha");
    
    	insertClientes(c);
    }
    
	@SuppressWarnings("unused")
	public static boolean verificaTipoCliente(String tipoCliente) {

		final String sql = "Select * from clientes where tipoCliente = ?";

		try
		(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		)
		{
			pstmt.setString(1, tipoCliente);
			ResultSet rs = pstmt.executeQuery();
			//contagem de linhas
			rs.last();
			int rows = rs.getRow();
			
			Clientes e = new Clientes();
	//		Clientes e = null;
			if(rs.next()) {
				e = resultsetToClientes(rs);
			}
	
			rs.close();
	
			return rows > 0;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	public static boolean verificaLogin(String nome, String senha) {
		final String sql = "Select * from clientes where nome = ? and senha = ?";

		try
		(
			Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
		)
		{
			pstmt.setString(1, nome);
			pstmt.setString(2, senha);
			ResultSet rs = pstmt.executeQuery();
			//contagem de linhas
			rs.last();
			int rows = rs.getRow();
			
			Clientes e = new Clientes();
	//		Clientes e = null;
			if(rs.next()) {
				e = resultsetToClientes(rs);
			}
	
			rs.close();
	
			return rows > 0;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
