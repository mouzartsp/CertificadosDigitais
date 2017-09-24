package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Parceria;

public class MySql_Parceria {
	
	
	
	public static void getInsereParceria(String nome, String empresa, String telefone,String codigoParceiro, String email) throws SQLException {
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("insert into parceria (nome,empresa,telefone,codigoParceiro,email) values ('"+nome+"','"+empresa+"','"+telefone+"','"+codigoParceiro+"','"+email+"')");
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
	}
	
	public static Parceria buscaParceria (int id) throws SQLException {
		
		Parceria p = new Parceria();
		Connection connection = Database.getConnection();
		
		Statement statement = connection.createStatement();
		
//		PreparedStatement stmt = connection.prepareStatement("select * from midia where id ="+id);
//		ResultSet resultSet = stmt.executeQuery();
		
		boolean resultado = statement.execute("select * from parceria where id ="+id);
		if (resultado == false) {
			JOptionPane.showMessageDialog(null, "PROBLEMA NO SELECT * parceria");
		}else {
			
			ResultSet resultSet = statement.getResultSet();
			
			resultSet.next();
			
			p.setId(resultSet.getInt("id"));
			p.setNome(resultSet.getString("nome"));
			p.setEmpresa(resultSet.getString("empresa"));
			p.setTelefone(resultSet.getString("telefone"));
			p.setCodParceiro(resultSet.getString("codigoParceiro"));
			p.setEmail(resultSet.getString("email"));
			
		}
		
		return p;
			
		
	}

	public static void editaParceria(Parceria parceriaEditar) throws SQLException {
		
		int id = parceriaEditar.getId();
		String nome = parceriaEditar.getNome();
		String empresa = parceriaEditar.getEmpresa();
		String telefone = parceriaEditar.getTelefone();
		String codigoParceiro = parceriaEditar.getCodParceiro();
		String email = parceriaEditar.getEmail();
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("UPDATE parceria SET nome = '"+nome+"', empresa = '"+empresa+"', telefone= '"+telefone+"',codigoParceiro= '"+codigoParceiro+"', email = '"+email+"' WHERE id = '"+id+"'");
	
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
		
	}

	public static void removeParceria(Parceria p) throws SQLException {
		
		int id = p.getId();
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("DELETE FROM parceria WHERE id = '"+id+"'");
	
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
		
		
	}
	
	
}
