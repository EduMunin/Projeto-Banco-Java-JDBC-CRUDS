package banco.main;

import banco.controller.BancoController;
import banco.dao.*;
import banco.view.BancoView;

public class BancoMain {
	public static void main(String[] args) {
		BancoView View = new BancoView();
		UsersDAO usersDAO = new UsersDAO();
		AccountsDAO accountsDAO = new AccountsDAO();
		TransactionsDAO transactionsDAO = new TransactionsDAO();
		BancoController controller = new BancoController(View, usersDAO, accountsDAO, transactionsDAO);
		
	}

}
