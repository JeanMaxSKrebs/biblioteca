package controller;

import java.util.Scanner;

public class BibliotecaController {

	public static void main(String[] args) throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		char sair = 'N';

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
			menuCliente("Alunos");

			break;
		case 2:
			System.out.print("\n ________|  Atualiza Pais   |________ \n");
			menuCliente("Pais");
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

	public static void menuCliente(String TC) throws InterruptedException {
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
		System.out.println(conferir + " " + update + "" + next);

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
			//update
			System.out.println("update");
		}

		Thread.sleep(2000);
	}
	
}
