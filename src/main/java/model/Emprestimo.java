package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Emprestimo {

	private int id;
	private Calendar dataEmprestimo;
	private Calendar dataDevolucao;
	private int id_exemplar;
	private int id_cliente;
	
	public Emprestimo() {
		super();
	}
	
	public Emprestimo(int id_exemplar, int id_cliente) {
		super();
		this.id_exemplar = id_exemplar;
		this.id_cliente = id_cliente;
	}

	public Emprestimo(int id, Calendar dataEmprestimo, Calendar dataDevolucao, int id_exemplar, int id_cliente) {
		super();
		this.id = id;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucao = dataDevolucao;
		this.id_exemplar = id_exemplar;
		this.id_cliente = id_cliente;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Calendar dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Calendar dataDevolucao) {
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

	@Override
	public String toString() {
		return "Emprestimo [id=" + id + ", dataEmprestimo=" + calendarToString(dataEmprestimo) + ", dataDevolucao=" + calendarToString(dataDevolucao)
				+ ", id_exemplar=" + id_exemplar + ", id_cliente=" + id_cliente + "]\n";
	}
	
	private static String calendarToString(Calendar data) {
		if(data != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			return sdf.format(data.getTime());
		}
		return "00/00/0000";
	}
	
	
	
	
	
}
