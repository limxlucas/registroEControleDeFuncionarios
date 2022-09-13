package controle.de.horas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	public static void adicionaFuncionario(Funcionario funcionario) throws SQLException {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		String salario = String.valueOf(funcionario.getSalario());
		
		PreparedStatement stm = connection.prepareStatement("INSERT INTO FUNCIONARIO (nome, cpf, cargo, salario) VALUES (?, ?, ?, ?)");
		stm.setString(1, funcionario.getNome());
		stm.setString(2, funcionario.getCpf());
		stm.setString(3, funcionario.getCargo());
		stm.setString(4, salario);
		stm.execute();
		connection.close();	
	}
	
	public static void getFuncionarios() throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("SELECT NOME FROM FUNCIONARIO");
		ResultSet rs = stm.executeQuery();
		while(rs.next()) {
			String nome = rs.getString("Nome");
			System.out.println(nome);
		}
		System.out.println();
		connection.close();
	}
	
	public static void removeFuncionario(String cpf) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM FUNCIONARIO WHERE CPF = ? ");
		stm.setString(1, cpf);
		stm.execute();
		
		connection.close();
	}

	public static void detalheFuncionario(String cpfSelecionado) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("SELECT * FROM FUNCIONARIO WHERE CPF = ? ");
		stm.setString(1, cpfSelecionado);
		ResultSet rs = stm.executeQuery();
		
		while(rs.next()) {
			String nome = rs.getString("Nome");
			String cpf = rs.getString("cpf");
			String cargo = rs.getString("cargo");
			String salario = rs.getString("salario");
			System.out.println("Nome: " + nome + "\n" + "CPF: " + cpf + "\n" + "Cargo: " + cargo + "\n" + "Salario: " + salario);
		}
		connection.close();
	}
	
	public static String getFuncionario(String cpf) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("SELECT NOME FROM FUNCIONARIO WHERE CPF = ? ");
		stm.setString(1, cpf);
		ResultSet rs = stm.executeQuery();
		
		String nome = null;
		if(rs.next()) {
			nome = rs.getString("Nome");
		}
		connection.close();
		return nome;
	}
}
