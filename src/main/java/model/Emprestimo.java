package model;

import java.util.Date;

public class Emprestimo {

	private int id;
	private Date dataEmprestimo;
	private Date dataDevolucao;
	private int id_exemplar;
	private int id_cliente;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public int getId_exemplar() {
		return id_exemplar;
	}
	public void setId_exemplar(int id_exemplar) {
		this.id_exemplar = id_exemplar;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	
	
}
