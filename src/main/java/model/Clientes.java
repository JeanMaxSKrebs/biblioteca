package model;

public class Clientes {
	private int id;
	private String nome;
	private int idade;
	private Long telefone;
	private String endereco;
	private String tipoCliente;
	private String senha;
	
	public Clientes() {
		super();
	}
	
	
	
	public Clientes(int id, String nome, int idade, Long telefone, String endereco, String tipoCliente, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
		this.endereco = endereco;
		this.tipoCliente = tipoCliente;
		this.senha = senha;
	}

	//sem senha
	public Clientes(int id, String nome, int idade, Long telefone, String endereco, String tipoCliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
		this.endereco = endereco;
		this.tipoCliente = tipoCliente;
	}
	//sem id e sem senha
	public Clientes(String nome, int idade, Long telefone, String endereco, String tipoCliente) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.telefone = telefone;
		this.endereco = endereco;
		this.tipoCliente = tipoCliente;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Long getTelefone() {
		return telefone;
	}
	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}



	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nome=" + nome + ", idade=" + idade + ", telefone=" + telefone + ", endereco="
				+ endereco + ", tipoCliente=" + tipoCliente + "]\n";
	}
}
