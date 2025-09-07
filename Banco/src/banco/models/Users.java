package banco.models;

public class Users {
	private int id;
	private String name;
	private String cpf;
	private String password;
	
	//construtor
	
	public Users(String name, String cpf, String password) {
		this.cpf = cpf;
		this.name = name;
		this.password = password;
	}
	
	//gets
	public int getId() {return id;}
	public String getName() {return name;}
	public String getCpf() {return cpf;}
	public String getpassword() {return password;}
	
	//sets
	public void setId(int id) {this.id = id;}
	public void setName(String name) {this.name = name;}
	public void setCpf(String cpf) {this.cpf = cpf;}
	public void setPassword(String password) {this.password = password;}
}
