package banco.controller;

import banco.dao.AccountsDAO;
import banco.dao.TransactionsDAO;
import banco.dao.UsersDAO;
import banco.view.BancoView;

public class BancoController {
	private BancoView view = new BancoView();
	private UsersDAO usersDAO = new UsersDAO();
	private AccountsDAO accountsDAO = new AccountsDAO();
	private TransactionsDAO transactionsDAO = new TransactionsDAO();
	
	public BancoController(BancoView view, UsersDAO usersDAO, AccountsDAO accountsDAO, TransactionsDAO transactionsDAO) {
		this.view = view;
		this.accountsDAO = accountsDAO;
		this.transactionsDAO = transactionsDAO;
		this.usersDAO = usersDAO;
		
	}

	
}
