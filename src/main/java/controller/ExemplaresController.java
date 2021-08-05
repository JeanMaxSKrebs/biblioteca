package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.EmprestimoDAO;
import dao.ExemplaresDAO;
import model.Exemplares;

public class ExemplaresController {

	public static void main(String[] args) throws InterruptedException {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int opcao = 0;
		char sair = 'N';
		int id;
		int cliente;

		do {
		System.out.println("\n");
		System.out.print(
				  "1 ------------------- Informa Retirada\n"
				+ "2 ------------------- Criar Registro\n"
				+ "3 ------------------- Atualizar Registro\n"
				+ "4 ------------------- Atualiza Único Registro\n"
				+ "5 ------------------- Mostra Livros\n"
				+ "6 ------------------- Informa Perdido\n"
				+ "7 ------------------- Informa Devolução\n"
				+ "8 ------------------- Verifica Emprestimos\n"
				+ "9 ------------------- Voltar\n"

				+ "\n"
				+ "--> ");
		opcao = input.nextInt();
		input.nextLine();

		switch(opcao) {
		
		case 1:
			System.out.print("\n ________|   Informa Retirada   |________ \n");
			System.out.print("Se deseja voltar --> 0\n"
					+ "Qual código do cliente?\n");
			cliente = input.nextInt();
			if(cliente != 0) {
				System.out.print("Se deseja voltar --> 0\n"
						+ "Qual código do exemplar?\n");
				id = input.nextInt();

				if(id != 0) {
					if(verificaEstoque(id)) {
						if(retiraLivro(id, cliente))
							System.out.println("Sucesso");
						else {
							System.out.println("Erro");
						}
					} else {
						System.out.println("Sem Estoque");
					}
				}
			}
			break;
		case 2:
			System.out.print("\n ________|   Criar Registro   |________ \n");
			
			if(criaRegistro(dadosRegistro(0)))
				System.out.println("Sucesso");
			else {
				System.out.println("Erro");
			}
			
			break;
		case 3:
			System.out.print("\n ________|  Atualizar Registro Completo  |________ \n");
			System.out.println("\n");
			System.out.print("Se deseja voltar --> 0\n"
					+ "Qual código do exemplar?\n");
			id = input.nextInt();
			if(id != 0) {
				if(atualizaRegistro(dadosRegistro(id)))
					System.out.println("Sucesso");
				else {
					System.out.println("Erro");
				}
			}

			break;
		case 4:
			int opcaoAtt = 0;
			do {
				System.out.print("\n ________|   Atualiza Único Registro   |________ \n");
				System.out.println("\n");
				System.out.print("Se deseja voltar --> 0\n"
						+ "Qual código do exemplar?\n");
				id = input.nextInt();
				input.nextLine();
				if(id != 0) {
					System.out.print(
							  "1 ------------------- Nome\n"
							+ "2 ------------------- Tipo Exemplar"
							+ "3 ------------------- Edicão\n"
							+ "4 ------------------- Autor\n"
							+ "5 ------------------- Editora\n"
							+ "\n"
							+ "--> ");
					opcaoAtt = input.nextInt();
					input.nextLine();
				
					if(verificaRegistroUnico(opcaoAtt)) {
						if(atualizaRegistroUnico(opcaoAtt, id))
							System.out.println("Sucesso");
					}
				}
				
			} while(opcaoAtt != 0);
			break;
		case 5:
			System.out.print("\n ________| Livros |________ \n");
			System.out.println("\n");
			mostraExemplares();
			break;
		case 6:
			System.out.print("\n ________|   Informa Perdido   |________ \n");
			System.out.print("Se deseja voltar --> 0\n"
					+ "Qual código do exemplar?\n");
			id = input.nextInt();
			if(id != 0) {
				if(informaLivroPerdido(id))
					System.out.println("Sucesso");
				else {
					System.out.println("Erro");
				}
			}
			break;
		case 7:
			System.out.print("\n ________|   Informa Devolução   |________ \n");
			System.out.print("Se deseja voltar --> 0\n"
					+ "Qual código do exemplar?\n");
			id = input.nextInt();
			if(id != 0) {
				if(informaLivroDevolucao(id))
					System.out.println("Sucesso");
				else {
					System.out.println("Erro");
				}
			}
			break;
		case 8:
			System.out.print("\n ________|   Verifica Emprestimos   |________ \n");
			System.out.print("Se deseja voltar --> 0\n"
					+ "Qual código do cliente?\n");
			cliente = input.nextInt();
			if(cliente != 0) {
				System.out.println(verificaEmprestimo(cliente)+" empréstimo(s)");
			}
			break;
		default:
			if(opcao != 0) {
				System.out.println("Deseja Voltar? S/N");
				sair = input.next().charAt(0);
				if(sair == 'S')
					opcao = 0;
			}
		}
		Thread.sleep(2000);
		} while(opcao != 0);
		
		System.out.print("Até");
		
	}
	
	public static int verificaEmprestimo(int cliente) {
		return EmprestimoDAO.countIdCliente(cliente);
	
	}

	public static void mostraExemplares() {
		List<Exemplares> listExemplares = new ArrayList<Exemplares>();
		
		
		
		listExemplares = ExemplaresDAO.selectExemplares();
		
		for (int i = 0; i < listExemplares.size(); i++) {
			System.out.println(" || Id: " + listExemplares.get(i).getId()
							 + " || Nome: " + listExemplares.get(i).getNome()
							 + " || Tipo: " + listExemplares.get(i).getTipoExemplar()
							 + " || Edição: " + listExemplares.get(i).getEdicao()
							 + " || Autor: " + listExemplares.get(i).getAutor()
							 + " || Editora: " + listExemplares.get(i).getEditora()
							 + " || Situação: " + listExemplares.get(i).getSituacao()
							 + " || \n");
		}
	}
	
	public static boolean informaLivroDevolucao(int id) {
		
		if(ExemplaresDAO.softDeleteExemplar(id, "Estoque")
			&& EmprestimoDAO.softDeleteEmprestimo(id, false)) {
			return true;
		} else {
			return false;
		}
	}
	public static boolean informaLivroPerdido(int id) {
		return ExemplaresDAO.softDeleteExemplar(id, "Perdido");
	}

	public static boolean verificaEstoque(int id) {
		
		return ExemplaresDAO.selectExemplarById(id).getSituacao().equals("Estoque");
			
	}
	
	public static boolean retiraLivro(int id, int cliente) {

		if(ExemplaresDAO.softDeleteExemplar(id, "Retirado")
			&& EmprestimoDAO.insertEmprestimo(id, cliente)) {
			return true;
		}
		return false;
	}

	public static boolean criaRegistro(Exemplares exemplar) {
		
		return ExemplaresDAO.insertExemplar(exemplar);
		
	}
	
	public static boolean atualizaRegistro(Exemplares exemplar) {
		
		return ExemplaresDAO.updateExemplar(exemplar);
	}
	
	public static Exemplares dadosRegistro(int id) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String nome;
		String tipoExemplar;
		int edicao;
		String autor;
		String editora;
		Exemplares exemplar = new Exemplares();
		
		System.out.print("Nome: ");
		nome = input.nextLine();
		System.out.println(nome);
		System.out.print("Tipo Exemplar: ");
		tipoExemplar = input.nextLine();
		System.out.println(tipoExemplar);
		System.out.print("Edição: ");
		edicao = input.nextInt();
		input.nextLine();
		System.out.println(edicao);
		System.out.print("Autor: ");
		autor = input.nextLine();
		System.out.println(autor);
		System.out.print("Editora: ");
		editora = input.nextLine();
		System.out.println(editora);
		
		exemplar.setNome(nome);
		exemplar.setTipoExemplar(tipoExemplar);
		exemplar.setEdicao(edicao);
		exemplar.setAutor(autor);
		exemplar.setEditora(editora);
		exemplar.setId(id);
		 
		return exemplar;
	}
	
	public static boolean atualizaRegistroUnico(int registro, int id) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String nomeCampo = null;

		char voltar = 'N';
		
		System.out.print("Digite o novo Registro: ");
		String novoRegistro = input.nextLine();
		System.out.println(novoRegistro);
		do {
			switch(registro) {
			case 1:
				nomeCampo = "nome";
				break;
			case 2:
				nomeCampo = "tipoExemplar";
				break;
			case 3:
				nomeCampo = "edicao";
				break;
			case 4:
				nomeCampo = "autor";
				break;
			case 5:
				nomeCampo = "editora";
				break;
				
			default:
				System.out.println("Em Andamento");

			}
			System.out.println("Deseja Voltar? S/N");
			voltar = input.next().charAt(0);
		} while(voltar != 'S');
		
		return ExemplaresDAO.updateVariavel(nomeCampo, novoRegistro, id);

	}

	public static boolean verificaRegistroUnico(int registro) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		char confirmar = 'N';
		char sair = 'N';

		do {
			switch(registro) {
			case 1:
				System.out.println("Deseja Alterar o Nome? S/N");
				confirmar = input.next().charAt(0);

				break;
				
			case 2:
				System.out.println("Deseja Alterar o Tipo de Cliente? S/N");
				confirmar = input.next().charAt(0);

				break;
				
			case 3:
				System.out.println("Deseja Alterar o Edição? S/N");
				confirmar = input.next().charAt(0);

				break;
			case 4:
				System.out.println("Deseja Alterar o Autor? S/N");
				confirmar = input.next().charAt(0);
				
				break;
			case 5:
				System.out.println("Deseja Alterar o Editora? S/N");
				confirmar = input.next().charAt(0);
				
				break;

			default:
				System.out.println("Em Andamento");

			}
			if(confirmar != 'S') {
				System.out.println("Deseja Voltar? S/N");
				sair = input.next().charAt(0);
			}
		} while(confirmar != 'S' && sair != 'S');
		
		if(confirmar == 'S')
			return true;
		else
			return false;
	}
 
}
