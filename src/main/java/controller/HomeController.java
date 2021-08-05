package controller;

import java.util.Scanner;

import dao.ClientesDAO;
import model.Clientes;

public class HomeController {
	public static void main(String[] args) throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		char sair = 'N';
		String nome;
		String senha;
		
		do {
			System.out.print("\n ______________________________ \n");
			System.out.print("\n ________| Biblioteca |________ \n");
			System.out.print("\n ________|    Home    |________ \n");
			System.out.print("\n ______________________________ \n");
			System.out.println("\n");

			System.out.print(
					  "1 ------------------- Alunos\n"
					+ "2 ------------------- Pais\n"
					+ "3 ------------------- Bibliotecária\n"
					+ "0 ------------------- Sair\n"
					+ "\n"
					+ "--> ");
			opcao = input.nextInt();
			input.nextLine();
				
			
			switch(opcao) {
			case 1:
				System.out.print("\n ________|   Aluno   |________ \n");
				System.out.print("\n ________|   login: Jean senha: 'press enter'    |________ \n");
				System.out.print("Nome: ");
				nome = input.nextLine();
				System.out.print("Senha: ");
				senha = input.nextLine();
				Clientes clienteLogado = new Clientes();
				clienteLogado = retornaId(nome);
				if(LoginController.main(nome, senha)) {
						AlunosController.main(clienteLogado);
				} else {
					System.out.println("Usuário inexistente");
				}
					
				break;
			case 2:
				System.out.print("\n ________|   Pais   |________ \n");
				System.out.print("\n ________|   login: 1 senha: senha    |________ \n");
				System.out.print("Nome: ");
				nome = input.nextLine();
				System.out.print("Senha: ");
				senha = input.nextLine();
				if(LoginController.main(nome, senha)) {
					if(verificaPais()) {
						PaisController.main(null);
					} else {
						System.out.println("Função Indisponível para este usuário");
					}
				} else {
					System.out.println("Usuário inexistente");
				}			
				
				
				break;
			case 3:
				System.out.print("\n ________|   Bibliotecária   |________ \n");
				System.out.print("\n ________|   login: thais senha: here   |________ \n");
				System.out.print("Nome: ");
				nome = input.nextLine();
				System.out.print("Senha: ");
				senha = input.nextLine();
				if(LoginController.main(nome, senha)) {
					if(verificaBibliotecaria()) {
						BibliotecaController.main(null);						
					} else {
						System.out.println("Função Indisponível para este usuário");
					}
				} else {
					System.out.println("Usuário inexistente");
				}	
				break;
			default:
				if(opcao != 0) {
					System.out.println("Deseja Sair? S/N");
					sair = input.next().charAt(0);
					if(sair == 'S')
						opcao = 0;
				}
			}
		} while(opcao != 0);
			
			System.out.print("Até");
	}

	private static Clientes retornaId(String nome) {

		return ClientesDAO.selectClienteByNome(nome);

	}

	public static boolean verificaPais() {
		
		return ClientesDAO.verificaTipoCliente("Pais");
	}
	
	private static boolean verificaBibliotecaria() {
		
		return ClientesDAO.verificaTipoCliente("Bibliotecaria");
	}
}
