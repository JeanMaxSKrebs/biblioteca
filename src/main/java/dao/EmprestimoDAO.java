package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Emprestimo;

public class EmprestimoDAO extends BaseDAO {
	public static List<Emprestimo> selectEmprestimos() {
		final String sql = "SELECT * FROM emprestimo";
		try //try with resource
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
			)
		{	

			List<Emprestimo> emprestimos = new ArrayList<>();
			while(rs.next()) {
				emprestimos.add(resultsetToEmprestimos(rs));
			}
			return emprestimos;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean insertEmprestimo(int id_exemplar, int id_cliente) {
		final String sql = "INSERT INTO emprestimo(dataEmprestimo, dataDevolucao, id_exemplar, id_cliente) VALUES (?, ?, ?, ?)";	
		try
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) 
		{
            pstmt.setDate(1, new Date(new java.util.Date().getTime()));
            pstmt.setDate(2, new Date(new java.util.Date().getTime()));
            pstmt.setInt(3, id_exemplar);
            pstmt.setInt(4, id_cliente);

			int count = pstmt.executeUpdate();
			return count > 0;

		}  catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	
	}
	
	private static Emprestimo resultsetToEmprestimos(ResultSet rs) throws SQLException {
		Emprestimo e = new Emprestimo();
		e.setId(rs.getInt("id"));
		
		e.setDataEmprestimo(dateToCalendar(rs.getDate("dataEmprestimo")));

		e.setDataDevolucao(dateToCalendar(rs.getDate("dataDevolucao")));
		
		e.setId_cliente(rs.getInt("id_cliente"));
		e.setId_exemplar(rs.getInt("id_exemplar"));
		
		return e;
	}
	
	private static Calendar dateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
    public static void main(String[] args) {
//    	System.out.println(insertEmprestimo(1,1));
    	System.out.println(selectEmprestimos());
//    	System.out.println(softDeleteExemplar(2, "Perdido"));
    }

	public static int countIdCliente(int id_cliente) {
		final String sql = "Select count(id_cliente) from emprestimo where id_cliente = ? and situacao = true";	
		try
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) 
		{
            pstmt.setInt(1, id_cliente);
            
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            
            return rs.getInt("count(id_cliente)");
		}  catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public static boolean softDeleteEmprestimo(int id, boolean situacao) {
		final String sql = "UPDATE emprestimo SET situacao=? WHERE id_exemplar=?";	
		try
			(
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
			) 
		{
			pstmt.setBoolean(1, situacao);
			pstmt.setInt(2, id);
			int count = pstmt.executeUpdate();
			return count > 0;

		}  catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
