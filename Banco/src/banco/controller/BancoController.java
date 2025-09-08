package banco.controller;

import banco.dao.AccountsDAO;
import banco.dao.TransactionsDAO;
import banco.dao.UsersDAO;
import banco.view.BancoView;

public class BancoController {
	private BancoView view;
	private UsersDAO usersDAO;
	private AccountsDAO accountsDAO;
	private TransactionsDAO transactionsDAO;
	
	public BancoController(BancoView view, UsersDAO usersDAO, AccountsDAO accountsDAO, TransactionsDAO transactionsDAO) {
		this.view = view;
		this.accountsDAO = accountsDAO;
		this.transactionsDAO = transactionsDAO;
		this.usersDAO = usersDAO;
		
	}
	
	public void Start() {
		boolean exit = false;
		while (!exit) {
			view.AccoountMenu();
			int Option = view.ReadOption();
			
			switch (Option) {
			case 1:
				//RegisterAccount();
				break;

			case 2:
				//LoginAccount();
				
				break;
				
			default:
				view.ShowMessage("Option Invalid!");
				break;
			}
			
		}
	}
	
}
