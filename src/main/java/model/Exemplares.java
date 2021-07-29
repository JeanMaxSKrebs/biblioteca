package model;

public class Exemplares {
	private int id;
	private String nome;
	private String tipoExemplar; //Periodico, Livro, Artigo
	private int edicao;
	private String autor;
	private String editora;
	private String situacao; // Estoque, Perdido, Retirado
	
	
	public Exemplares() {
		super();
	}
	
	public Exemplares(int id, String nome, String tipoExemplar, int edicao, String autor, String editora,
			String situacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoExemplar = tipoExemplar;
		this.edicao = edicao;
		this.autor = autor;
		this.editora = editora;
		this.situacao = situacao;
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
	public String getTipoExemplar() {
		return tipoExemplar;
	}
	public void setTipoExemplar(String tipoExemplar) {
		this.tipoExemplar = tipoExemplar;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	@Override
	public String toString() {
		return "Exemplares [id=" + id + ", nome=" + nome + ", tipoExemplar=" + tipoExemplar + ", edicao=" + edicao
				+ ", autor=" + autor + ", editora=" + editora + ", situacao=" + situacao + "]\n";
	}
}
