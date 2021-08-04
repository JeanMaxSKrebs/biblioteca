package controller;

import java.util.Scanner;

public class AlunosController {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("alunos");
		
		System.out.print("Senha: ");
		String senha = input.nextLine();
		System.out.println(senha);

	}

}
