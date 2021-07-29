package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Exemplares;

public class ExemplaresDAO extends BaseDAO {
	public static List<Exemplares> selectExemplares() {
		final String sql = "SELECT * FROM exemplares";
		try //try with resource
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			)
		{	
			List<Exemplares> exemplares = new ArrayList<>();
			while(rs.next()) {
				exemplares.add(resultsetToExemplares(rs));
			}
			return exemplares;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Exemplares selectExemplarById(int id) {
		final String sql = "Select * from exemplares where id = ?";
		try
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			)
		{
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

//			Exemplares e = new Exemplares();
			Exemplares e = null;
			if(rs.next()) {
				e = resultsetToExemplares(rs);
			}
			rs.close();
			return e;
			
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean insertExemplar(Exemplares exemplar) {
		final String sql = "INSERT INTO exemplares(nome, tipoExemplar, edicao, autor, editora, situacao) VALUES (?, ?, ?, ?, ?, ?)";	
		try
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) 
		{
			pstmt.setString(1, exemplar.getNome());
			pstmt.setString(2, exemplar.getTipoExemplar());
			pstmt.setInt(3, exemplar.getEdicao());
			pstmt.setString(4, exemplar.getAutor());
			pstmt.setString(5, exemplar.getEditora());
			pstmt.setString(6, exemplar.getSituacao());
			int count = pstmt.executeUpdate();
			return count > 0;

		}  catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	
	}
	
	public static boolean updateExemplar(Exemplares exemplar) {
		final String sql = "UPDATE exemplares SET nome=?, tipoExemplar=?, edicao=?, autor=?, editora=?, situacao=? WHERE id=?";	
		try
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) 
		{
			System.out.println(exemplar);
			pstmt.setString(1, exemplar.getNome());
			pstmt.setString(2, exemplar.getTipoExemplar());
			pstmt.setInt(3, exemplar.getEdicao());
			pstmt.setString(4, exemplar.getAutor());
			pstmt.setString(5, exemplar.getEditora());
			pstmt.setString(6, exemplar.getSituacao());
			pstmt.setInt(7, exemplar.getId());
			int count = pstmt.executeUpdate();
			return count > 0;

		}  catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean softDeleteExemplar(int id, String situacao) {
		final String sql = "UPDATE exemplares SET situacao=? WHERE id=?";	
		try
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) 
		{
			pstmt.setString(1, situacao);
			pstmt.setInt(2, id);
			int count = pstmt.executeUpdate();
			return count > 0;

		}  catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static Exemplares resultsetToExemplares(ResultSet rs) throws SQLException {
		Exemplares p = new Exemplares();
		p.setId(rs.getInt("id"));
		p.setNome(rs.getString("nome"));
		p.setTipoExemplar(rs.getString("tipoExemplar"));
		p.setEdicao(rs.getInt("edicao"));
		p.setAutor(rs.getString("autor"));
		p.setEditora(rs.getString("editora"));

		return p;
	}
	
	public static boolean updateVariavel(String nomeCampo, String novoRegistro, int id) {
		final String sql = "UPDATE exemplares SET "+nomeCampo+"=? WHERE id=?";	
//		final String sql = "UPDATE exemplares SET ?=? WHERE id=?";	
		try
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) 
		{
//			pstmt.setString(1, nomeCampo);
//			pstmt.setString(2, novoRegistro);
//			pstmt.setInt(3, id);
			pstmt.setString(1, novoRegistro);
			pstmt.setInt(2, id);
			int count = pstmt.executeUpdate();
			return count > 0;

		}  catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
      
    
    public static void main(String[] args) {
//    	Exemplares exemplar = new Exemplares(2, "Mundo de Sofia", "Livro", 1, "Jostein Gaarder", "SCHWARCZ", "Estoque");
    	
    	System.out.println(updateVariavel("nome", "Mundo de Sofia", 2));
//    	System.out.println(softDeleteExemplar(2, "Perdido"));
    }


}
