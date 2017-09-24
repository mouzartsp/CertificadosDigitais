package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Certificado;
import model.Midia;

public class MySql {
	
	public static void getInsereCertificado(String descricao, int validade, double custo, double valor_comissao_contador, double valor_venda, double valor_a_vista, int idMidia) throws SQLException {

		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("insert into certificado (descricao,validade,custo, valor_venda, valor_comissao_contador, valor_a_vista, idMidia) values ('"+descricao+"','"+validade+"','"+custo+"','"+valor_venda+"','"+valor_comissao_contador+"','"+valor_a_vista+"','"+idMidia+"')");
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
	}
	
	public static void getInsereMidia(String descricao, int quantidade, double custo) throws SQLException {
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("insert into midia (descricao,quantidade,custo) values ('"+descricao+"','"+quantidade+"','"+custo+"')");
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
	}
	
	
	
	public static Midia buscaMidia (int id) throws SQLException {
		
		Midia m = new Midia();
		Connection connection = Database.getConnection();
		
		Statement statement = connection.createStatement();
		
//		PreparedStatement stmt = connection.prepareStatement("select * from midia where id ="+id);
//		ResultSet resultSet = stmt.executeQuery();
		
		boolean resultado = statement.execute("select * from midia where id ="+id);
		if (resultado == false) {
			JOptionPane.showMessageDialog(null, "PROBLEMA NO SELECT * MIDIA");
		}else {
			
			ResultSet resultSet = statement.getResultSet();
			
			resultSet.next();
			
			m.setId(resultSet.getInt("id"));
			m.setDescricao(resultSet.getString("descricao"));
			m.setQuantidade(resultSet.getInt("quantidade"));
			m.setCusto(resultSet.getDouble("custo"));
			
		}
		
		return m;
			
		
	}

	public static void editaMidia(Midia midiaEditar) throws SQLException {
		
		int id = midiaEditar.getId();
		String descricao = midiaEditar.getDescricao();
		int quantidade = midiaEditar.getQuantidade();
		double custo = midiaEditar.getCusto();
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("UPDATE midia SET descricao = '"+descricao+"', quantidade = '"+quantidade+"', custo = '"+custo+"' WHERE id = '"+id+"'");
	
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
		
	}

	public static void removeMidia(Midia m) throws SQLException {
		
		int id = m.getId();
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("DELETE FROM midia WHERE id = '"+id+"'");
	
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
		
		
	}

	public static Certificado buscaCertificado(int cod) throws SQLException {
		Certificado c = new Certificado();
		Connection connection = Database.getConnection();
		
		Statement statement = connection.createStatement();
		
		
		boolean resultado = statement.execute("select * from certificado where id ="+cod);
		if (resultado == false) {
			JOptionPane.showMessageDialog(null, "PROBLEMA NO SELECT * certificado");
		}else {
			
			ResultSet resultSet = statement.getResultSet();
			
			resultSet.next();
			
			c.setId(resultSet.getInt("id"));
			c.setDescricao(resultSet.getString("descricao"));
			c.setValidade(resultSet.getInt("validade"));
			c.setCusto(resultSet.getDouble("custo"));
			c.setPreco_prazo(resultSet.getDouble("valor_venda"));
			c.setComissao(resultSet.getDouble("valor_comissao_contador"));
			c.setPreco_vista(resultSet.getDouble("valor_a_vista"));
			
			
		} 

		
		return c;
	}

	public static void editaCertificado(Certificado certificadoEditar) throws SQLException {
		
		int id = certificadoEditar.getId();
		String descricao = certificadoEditar.getDescricao();
		int validade = certificadoEditar.getValidade();
		double custo = certificadoEditar.getCusto();
		double precoPrazo = certificadoEditar.getPreco_prazo();
		double precoVista = certificadoEditar.getPreco_vista();
		double comissao = certificadoEditar.getComissao();
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("UPDATE certificado SET descricao = '"+descricao+"', validade = '"+validade+"', custo = '"+custo+"', valor_venda= '"+precoPrazo+"', valor_comissao_contador = '"+comissao+"', valor_a_vista = '"+precoVista+"' WHERE id = '"+id+"'");
	
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
		
	}

	public static void removeCertificado(Certificado c) throws SQLException {
		
		int id = c.getId();
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("DELETE FROM certificado WHERE id = '"+id+"'");
	
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
		
	}

	public static void gravaData(String convDataBanco) throws SQLException {
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("insert into data (data) values ('"+convDataBanco+"')");
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
		
	}
	
	
}
