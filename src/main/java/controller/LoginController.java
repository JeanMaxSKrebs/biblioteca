package controller;

import dao.ClientesDAO;

public class LoginController {


	public static boolean main(String nome, String senha) {

		return ClientesDAO.verificaLogin(nome, senha);
	}

}
