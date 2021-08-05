package controller;

import java.util.Scanner;

import dao.ClientesDAO;
import dao.EmprestimoDAO;
import dao.ExemplaresDAO;
import model.Clientes;

public class PaisController {

	public static void main(Clientes clienteLogado) throws InterruptedException {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		char sair = 'N';
		int id;


		
		do {
			System.out.print("\n ________________________________ \n");
			System.out.print("\n ________|  Biblioteca  |________ \n");
			System.out.print("\n ________|    Pais    |________ \n");
			System.out.print("\n ________________________________ \n");
			System.out.println("\n");

			System.out.print(
					  "1 ------------------- Atualiza Senha\n"
					+ "2 ------------------- Atualiza Cadastro\n"
					+ "3 ------------------- Retira Livro\n"
					+ "4 ------------------- Devolve Livro\n"
					+ "5 ------------------- Informa Perdido\n"
					+ "6 ------------------- Verifica Empréstimos\n"
					+ "0 ------------------- Sair\n"
					+ "\n"
					+ "--> ");
			opcao = input.nextInt();
			input.nextLine();
				
			switch(opcao) {
			
			case 1:
				System.out.print("Informe Senha Nova: ");
				String senhaNova = input.nextLine();
				if(senhaNova != "0") {
					if(alteraSenha(senhaNova, clienteLogado.getId())) {
						System.out.println("Sucesso");
					} else {
						System.out.println("Erro");
					}
				}
				
				break;
			case 2:
				
				BibliotecaController.menuCliente("Pais", clienteLogado.getId());
				
				break;
				
			case 3:
				System.out.print("Se deseja voltar --> 0\n"
						+ "Qual código do exemplar?\n");
				id = input.nextInt();

				if(id != 0) {
					if(ExemplaresController.verificaEstoque(id)) {
						if(ExemplaresController.retiraLivro(id, clienteLogado.getId()))
							System.out.println("Sucesso");
						else {
							System.out.println("Erro");
						}
					} else {
						System.out.println("Sem Estoque");
					}
				}
				
				break;
			case 4:
				System.out.print("Se deseja voltar --> 0\n"
						+ "Qual código do exemplar?\n");
				id = input.nextInt();
				if(id != 0) {
					if(ExemplaresController.informaLivroDevolucao(id))
						System.out.println("Sucesso");
					else {
						System.out.println("Erro");
					}
				}
				break;
			case 5:
				System.out.println("Resolver com Bibliotecária");
				break;
			case 6:
				int count = EmprestimoDAO.countIdCliente(clienteLogado.getId());
				
				System.out.println(count+" empréstimo(s)");
				if(count > 0) {
					verificarExemplaresByCliente(clienteLogado.getId());
				}
			default:
				if(opcao != 0) {
					System.out.println("Deseja Voltar? S/N");
					sair = input.next().charAt(0);
					if(sair == 'S')
						opcao = 0;
				}
			}
		} while(opcao != 0);

		System.out.println("Até");
		
		Thread.sleep(2000);
	}

	private static void verificarExemplaresByCliente(int id) {

		System.out.println(ExemplaresDAO.selectRelacaoEmprestimo(id));
	}

	private static boolean alteraSenha(String senhaNova, int id) {

		return ClientesDAO.updateVariavel("senha", senhaNova, id);
	}
}
