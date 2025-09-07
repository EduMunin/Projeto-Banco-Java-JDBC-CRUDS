package banco.view;

import java.sql.ResultSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import banco.models.Users;

public class BancoView {
	private Scanner scanner;
	
	public void StartMenu() {
		System.out.println("1 - Login");
		System.out.println("2 - Register");
	}
	
	public int lerOpcao() {
		try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Digite um número válido!");
            scanner.nextLine();
            return -1;
        }
        finally {
            scanner.nextLine(); // Consumir a nova linha
        }
    }
	
	public void ShowMessage(String massage) {
		System.out.println(massage);
	}
	
	public void ShowAllUsers(List<Users> Users) {
		for (Users users : Users) {
			System.out.println("Name: " + users.getName() + " || " + "CPF: " + users.getCpf());
			System.out.println("Password: " + users.getpassword());
			System.out.println("--------------------------------------------------------------");
		}
	}
}
