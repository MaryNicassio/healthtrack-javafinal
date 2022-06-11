package br.com.healthtrack.BO;

import java.sql.Date;

public class ContaPremium extends Usuario {
	private String nrCartao;
	private String nmCartao;
	private Date dtCartao;
	private int pinCartao;
	private Usuario usuarioUm = new Usuario();
	
	public Usuario getUsuarioUm() {
		return usuarioUm;
	}
	public void setUsuarioUm(Usuario usuarioUm) {
		this.usuarioUm = usuarioUm;
	}
	public String getNrCartao(){
		return nrCartao;
	}
	public void setNrCartao(String nrCartao) {
		this.nrCartao = nrCartao;
	}
	public String getNmCartao() {
		return nmCartao;
	}
	public void setNmCartao(String nmCartao) {
		this.nmCartao = nmCartao;
	}
	public Date getDtCartao() {
		return dtCartao;
	}
	public void setDtCartao(Date dtCartao) {
		this.dtCartao = dtCartao;
	}
	public int getPinCartao() {
		return pinCartao;
	}
	public void setPinCartao(int pinCartao) {
		this.pinCartao = pinCartao;
	}
	
}
