package controller;

import java.util.Scanner;

public class HomeController {
	public static void main(String[] args) throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		char sair = 'N';
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
				+ "4 ------------------- Voltar\n"
				+ "0 ------------------- Sair\n"
				+ "\n"
				+ "--> ");
		opcao = input.nextInt();
		input.nextLine();
		switch(opcao) {
		case 1:
			System.out.print("\n ________|   Aluno   |________ \n");
			AlunosController.main(null);
			break;
		case 2:
			System.out.print("\n ________|   Pais   |________ \n");
			PaisController.main(null);
			break;
		case 3:
			System.out.print("\n ________|   Bibliotecária   |________ \n");
			BibliotecaController.main(null);
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
}
