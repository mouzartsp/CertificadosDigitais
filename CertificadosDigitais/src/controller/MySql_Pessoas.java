package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import model.Pessoa;

public class MySql_Pessoas {
	
	
	
	public static void getInserePessoa(String nome, String cpf, String telefone, String email) throws SQLException {
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("insert into pessoa (nome,cpf,telefone,email) values ('"+nome+"','"+cpf+"','"+telefone+"','"+email+"')");
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
	}
	
	public static Pessoa buscaPessoa (int id) throws SQLException {
		
		Pessoa p = new Pessoa();
		Connection connection = Database.getConnection();
		
		Statement statement = connection.createStatement();
		
//		PreparedStatement stmt = connection.prepareStatement("select * from midia where id ="+id);
//		ResultSet resultSet = stmt.executeQuery();
		
		boolean resultado = statement.execute("select * from pessoa where id ="+id);
		if (resultado == false) {
			JOptionPane.showMessageDialog(null, "PROBLEMA NO SELECT * pessoa");
		}else {
			
			ResultSet resultSet = statement.getResultSet();
			
			resultSet.next();
			
			p.setId(resultSet.getInt("id"));
			p.setNome(resultSet.getString("nome"));
			p.setCpf(resultSet.getString("cpf"));
			p.setTelefone(resultSet.getString("telefone"));
			p.setEmail(resultSet.getString("email"));
			
		}
		
		return p;
			
		
	}

	public static void editaPessoa(Pessoa pessoaEditar) throws SQLException {
		
		int id = pessoaEditar.getId();
		String nome = pessoaEditar.getNome();
		String cpf = pessoaEditar.getCpf();
		String telefone = pessoaEditar.getTelefone();
		String email = pessoaEditar.getEmail();
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("UPDATE pessoa SET nome = '"+nome+"', cpf = '"+cpf+"', telefone= '"+telefone+"', email = '"+email+"' WHERE id = '"+id+"'");
	
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
		
	}

	public static void removePessoa(Pessoa p) throws SQLException {
		
		int id = p.getId();
		
		Connection connection = Database.getConnection();
		Statement statement = connection.createStatement();
		boolean resultado = statement.execute("DELETE FROM pessoa WHERE id = '"+id+"'");
	
		System.out.println("Teve algum erro? "+resultado);
		statement.close();
		connection.close();
		
		
	}
	
	
}
