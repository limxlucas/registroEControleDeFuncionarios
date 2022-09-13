package controle.de.horas;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

	public static void main(String[] args) throws SQLException{
		while(true) {
			menu();
			Scanner teclado = new Scanner(System.in);
			String opcaoTemporaria = teclado.nextLine();
			int opcao = Integer.parseInt(opcaoTemporaria);
			if(opcao == 1) {
				System.out.print("Qual o nome do funcionario: ");
				String nome = teclado.nextLine();
				
				System.out.print("Qual o CPF do funcionario: ");
				String cpf = teclado.nextLine();

				System.out.print("Qual o cargo do funcionario: ");
				String cargo = teclado.nextLine();

				System.out.print("Qual o salario do funcionario: ");
				String salarioTemporario = teclado.nextLine();
				double salario = Double.parseDouble(salarioTemporario);
				
				Funcionario funcionario = new Funcionario(nome, cargo, cpf, salario);
				Database.adicionaFuncionario(funcionario);
			}
			
			if(opcao == 2) {
				System.out.println("Digite o CPF do funcionario para remover: ");
				String escolhaParaRemover = teclado.next();
				Database.removeFuncionario(escolhaParaRemover);
				System.out.println("Funcionario removido !\n");
			}
			
			if(opcao == 3) {
				Database.getFuncionarios();
				System.out.println();
			}
			
			if(opcao == 4) {
				System.out.println("Digite o CPF do funcionario para mais informacoes");
				String escolhaParaDetalhar = teclado.next();
				Database.detalheFuncionario(escolhaParaDetalhar);
				System.out.println();
			}
			
			if(opcao == 5) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("AVISO: QUANDO INICIADO, O PROGRAMA SO PARA NA HORA DA SAIDA DO FUNCIONARIO ");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Digite o cpf do funcionario para comecar a marcacao: ");
				String escolhaParaMarcar = teclado.next();
				marcacaoDePonto(escolhaParaMarcar);
			}
			
			if(opcao == 6) {
				System.out.println("Saindo...");
				break;
			}
		}
	}
	
	public static void marcacaoDePonto(String cpf) throws SQLException {
		ArrayList<String> horas = new ArrayList<String>();
		System.out.println("Para marcar a primeira hora aperte a tecla ENTER");
		Scanner teclado = new Scanner(System.in);
		int g = 0;
		
		while(true) {
			String entrada = teclado.nextLine();
			if(entrada.isEmpty()) {
				Date dataHora = new Date();
				String hora = new SimpleDateFormat("HH:mm:ss").format(dataHora);
				String data = new SimpleDateFormat("dd/MM/yy").format(dataHora);
				horas.add(hora);
				System.out.println("HORA ADICIONADA, ESPERANDO A PROXIMA HORA");
				g = 0;
				if(horas.size() == 4) {
					System.out.println("\nHoras de " + Database.getFuncionario(cpf) + " do dia " + data + ":");
					System.out.println("Entrada : " + horas.get(0));
					System.out.println("Entrada do almoco: " + horas.get(1));
					System.out.println("Volta do almoco: " + horas.get(2));
					System.out.println("Saida: " + horas.get(3) + "\n");
					break;
				}
			}else {
				g++;
				if(g == 3) {
					System.out.println("Cara, aperta ENTER por favor");
				}else {
					System.out.println("Tecla errada, tente novamente.");
				}
			}
		}
	}
	
	public static void menu() {
		System.out.println("Opcoes");
		System.out.println("[1] - Cadastrar novo funcionario\n[2] - Remover funcionario\n[3] - Mostrar funcionarios ativos\n[4] - Detalhar funcionario\n[5] - Marcar horas\n[6] - Sair");
	}
}
