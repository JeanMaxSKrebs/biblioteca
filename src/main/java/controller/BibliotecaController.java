package controller;

import java.util.Scanner;

import dao.ClientesDAO;
import model.Clientes;

public class BibliotecaController {

	public static void main(String[] args) throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		char sair = 'N';
		int cliente;

		do {
		System.out.print("\n ___________________________________ \n");
		System.out.print("\n ________|   Biblioteca    |________ \n");
		System.out.print("\n ___________________________________\n");

		System.out.println("\n");
		System.out.print(
				  "1 ------------------- Atualiza Alunos\n"
				+ "2 ------------------- Atualiza Pais\n"
				+ "3 ------------------- Atualiza Livros\n"
				+ "4 ------------------- Voltar\n"

				+ "\n"
				+ "--> ");
		opcao = input.nextInt();
		input.nextLine();

		switch(opcao) {
		
		case 1:
			System.out.print("\n ________|   Atualiza Alunos   |________ \n");
			System.out.print("Se deseja voltar --> 0\n"
					+ "Qual código do cliente?\n");
			cliente = input.nextInt();
			if(cliente != 0) {
				if(verificaTipoClienteById("Alunos", cliente)) {					
					menuCliente("Alunos", cliente);
				}
			}

			break;
		case 2:
			System.out.print("\n ________|  Atualiza Pais   |________ \n");
			System.out.print("Se deseja voltar --> 0\n"
					+ "Qual código do cliente?\n");
			cliente = input.nextInt();
			if(cliente != 0) {
				if(verificaTipoClienteById("Pais", cliente)) {					
					menuCliente("Pais", cliente);
				}
			}
			break;
		case 3:
			System.out.print("\n ________|   Atualiza Livros   |________ \n");
			ExemplaresController.main(null);
			break;
		default:
			if(opcao != 0) {
				System.out.println("Deseja Voltar? S/N");
				sair = input.next().charAt(0);
				if(sair == 'S')
					opcao = 0;
			}
		}
		} while(opcao != 0);
		
		System.out.print("Até");
		
	}

	private static boolean verificaTipoClienteById(String tipoCliente, int id) {
		
		return ClientesDAO.verificaTipoClienteById(tipoCliente, id);
	}

	public static void menuCliente(String TC, int cliente) throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
				
		String nome;
		int idade;
		Long telefone;
		String endereco;
		String tipoCliente = TC;
		char update = 'N';
		char conferir = 'N';

		System.out.println("\n");
		System.out.print("Nome: ");
		nome = input.nextLine();
		System.out.print("Idade: ");
		idade = input.nextInt();
		input.nextLine();
		System.out.print("Telefone: ");
		telefone = input.nextLong();
		input.nextLine();
		System.out.print("Endereço: ");
		endereco = input.nextLine();
		
		boolean next = false;
		
		
		do {
			System.out.print("Deseja Conferir? S/N -> ");
			conferir = input.next().charAt(0);
			if(conferir == 'S' || conferir == 'N') {
				next = true;
			}
		} while(next == false);
//		System.out.println(conferir + " " + update + " " + next);

		if(conferir == 'S') {
			System.out.print(
					  "\nNome: " + nome +
					  "\nIdade: " + idade +
					  "\nTelefone: " + telefone +
					  "\nEndereço: " + endereco +
					  "\nTipoCliente: "+ tipoCliente);
			
			do {
				System.out.print("\nTudo Certo? S/N -> ");
				conferir = input.next().charAt(0);
				if(conferir == 'S' || conferir == 'N') {
					next = true;
				}
			} while(next == false);
			if(conferir == 'S') {
				update = 'S';
			} else if(conferir == 'N') {
				System.out.println("\nReiniciando a aplicação!");
			}
		} else if(conferir == 'N'){
			update = 'S';
		}
		
		
		if(update == 'S') {
			Clientes c = new Clientes();
			
			c.setId(cliente);
			c.setNome(nome);
			c.setIdade(idade);
			c.setTelefone(telefone);
			c.setEndereco(endereco);
			c.setTipoCliente(tipoCliente);
			
			if(ClientesDAO.updateClientes(c))
				System.out.println("Sucesso");
			else
				System.out.println("Erro");
		}

		Thread.sleep(2000);
	}
	
}
