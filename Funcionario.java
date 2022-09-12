package controle.de.horas;
import java.sql.SQLException;
import java.util.*;

public class Funcionario {

	private String nome;
	private String cargo;
	private String cpf;
	private double salario;
	
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	
	public Funcionario(String nome, String cargo, String cpf, double salario) {
		this.nome = nome;
		this.cargo = cargo;
		this.cpf = cpf;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}

	public String getCargo() {
		return cargo;
	}

	public String getCpf() {
		return cpf;
	}

	public double getSalario() {
		return salario;
	}
}
