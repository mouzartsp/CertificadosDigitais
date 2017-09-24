package model;

import java.util.ArrayList;

public class Empresa {
	
	private int id;
	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private String telefones;
	private String email;
	private String site;
	private ArrayList<Pessoa> responsaveisLegais;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getRazaoSocial() {
		return razaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getTelefones() {
		return telefones;
	}
	public void setTelefones(String telefones) {
		this.telefones = telefones;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public ArrayList<Pessoa> getResponsaveisLegais() {
		return responsaveisLegais;
	}
	public void setResponsaveisLegais(ArrayList<Pessoa> responsaveisLegais) {
		this.responsaveisLegais = responsaveisLegais;
	}
	

}
