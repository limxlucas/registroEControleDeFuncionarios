package controle.de.horas;

public class Funcionario {

	private String nome;
	private String cargo;
	private String cpf;
	private double salario;
	
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
