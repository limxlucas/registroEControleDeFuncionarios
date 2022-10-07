package controle.de.horas;
import java.sql.SQLException;
import java.util.*;

public class Funcionario {

	private String nome;
	private String cargo;
	private String cpf;
	private double salario;
	private String senha;
	
	public Funcionario(String nome, String cargo, String cpf, double salario, String senha) {
		this.nome = nome;
		this.cargo = cargo;
		this.cpf = cpf;
		this.salario = salario;
		this.senha = senha;
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
	
	public String getSenha(){
		return senha;
	}
}
