package model;

import java.util.Date;

public class Parceria {
	
	private int id;
	private String nome;
	private String telefone;
	private String email;
	private String empresa;
	private String formaPagComissao;
	private String dataPagComissao;
	private String endereco;
	private String pontoReferencia;
	private String codParceiro;
	private Date dataCadastro;
	private Date ultimaAlteracao;
	private String usuarioCadastro;
	private String usuarioUltimaAlteracao;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getFormaPagComissao() {
		return formaPagComissao;
	}
	public void setFormaPagComissao(String formaPagComissao) {
		this.formaPagComissao = formaPagComissao;
	}
	public String getDataPagComissao() {
		return dataPagComissao;
	}
	public void setDataPagComissao(String dataPagComissao) {
		this.dataPagComissao = dataPagComissao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getPontoReferencia() {
		return pontoReferencia;
	}
	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}
	public String getCodParceiro() {
		return codParceiro;
	}
	public void setCodParceiro(String codParceiro) {
		this.codParceiro = codParceiro;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getUltimaAlteracao() {
		return ultimaAlteracao;
	}
	public void setUltimaAlteracao(Date ultimaAlteracao) {
		this.ultimaAlteracao = ultimaAlteracao;
	}
	public String getUsuarioCadastro() {
		return usuarioCadastro;
	}
	public void setUsuarioCadastro(String usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}
	public String getUsuarioUltimaAlteracao() {
		return usuarioUltimaAlteracao;
	}
	public void setUsuarioUltimaAlteracao(String usuarioUltimaAlteracao) {
		this.usuarioUltimaAlteracao = usuarioUltimaAlteracao;
	}
}