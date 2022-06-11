package br.com.healthtrack.BO;

import java.sql.Date;

public class Nutricao {
	private int idNutricao;
	private String tipoRefeicao;
	private int qtdKcalDiarias;
	private int qtdKcal;
	private Date dtRefeicao;
	private String dieta;
	private Usuario usuarioUm = new Usuario();
	
	public Usuario getUsuarioUm() {
		return usuarioUm;
	}
	public void setUsuarioUm(Usuario usuarioUm) {
		this.usuarioUm = usuarioUm;
	}
	public int getIdNutricao() {
		return idNutricao;
	}
	public void setIdNutricao(int idNutricao) {
		this.idNutricao = idNutricao;
	}
	public String getTipoRefeicao() {
		return tipoRefeicao;
	}
	public void setTipoRefeicao(String tipoRefeicao) {
		this.tipoRefeicao = tipoRefeicao;
	}
	public int getQtdKcal() {
		return qtdKcal;
	}
	public void setQtdKcal(int qtdKcal) {
		this.qtdKcal = qtdKcal;
	}
	public Date getDtRefeicao() {
		return dtRefeicao;
	}
	public void setDtRefeicao(Date dtRefeicao) {
		this.dtRefeicao = dtRefeicao;
	}
	public String getDieta() {
		return dieta;
	}
	public void setDieta(String dieta) {
		this.dieta = dieta;
	}
	public int getQtdKcalDiarias() {
		return qtdKcalDiarias;
	}
	public void setQtdKcalDiarias(int qtdKcalDiarias) {
		this.qtdKcalDiarias = qtdKcalDiarias;
	}
	protected void somarKcalDiarias() {
		if (dtRefeicao == dtRefeicao)qtdKcalDiarias = qtdKcal ++;
	}	

}
