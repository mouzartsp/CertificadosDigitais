package model;

public class Certificado {
	
	private int id;
	private String descricao;
	private int validade;
	private Midia midia;
	private double custo;
	private double comissao;
	private double preco_vista;
	private double preco_prazo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getValidade() {
		return validade;
	}
	public void setValidade(int validade) {
		this.validade = validade;
	}
	public Midia getMidia() {
		return midia;
	}
	public void setMidia(Midia midia) {
		this.midia = midia;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public double getComissao() {
		return comissao;
	}
	public void setComissao(double comissao) {
		this.comissao = comissao;
	}
	public double getPreco_vista() {
		return preco_vista;
	}
	public void setPreco_vista(double preco_vista) {
		this.preco_vista = preco_vista;
	}
	public double getPreco_prazo() {
		return preco_prazo;
	}
	public void setPreco_prazo(double preco_prazo) {
		this.preco_prazo = preco_prazo;
	}
	
	

}
