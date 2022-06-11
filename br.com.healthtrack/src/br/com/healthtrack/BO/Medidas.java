package br.com.healthtrack.BO;

import java.sql.Date;
import java.util.List;

import br.com.healthtrack.DAO.MedidasDAO;

/* A classe peso armazena as informações de descrição do peso, quilos perdidos, total dos quilos perdidos e a data
 */

public class Medidas {
	private int idMedidas;
	private float peso;
	private float totalQuilosPerdidos;
	private Date dataPesagem;
	private double altura;
	private double imc;
	private String pressaoArterial;
	private Usuario usuarioUm = new Usuario();
		
	public int getIdMedidas() {
		return idMedidas;
	}
	public void setIdMedidas(int idMedidas) {
		this.idMedidas = idMedidas;
	}
	public String getPressaoArterial() {
		return pressaoArterial;
	}
	public void setPressaoArterial(String pressaoArterial) {
		this.pressaoArterial = pressaoArterial;
	}
	public double getImc() {
		return imc;
	}
	public void setImc(double imc) {
		this.imc = imc;
	}
	public float getPeso() {
		return peso;
	}
	public Usuario getUsuarioUm() {
		return usuarioUm;
	}
	public void setUsuarioUm(Usuario usuarioUm) {
		this.usuarioUm = usuarioUm;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public float getTotalQuilosPerdidos() {
		return totalQuilosPerdidos;
	}
	public void setTotalQuilosPerdidos(float totalQuilosPerdidos) {
		this.totalQuilosPerdidos = totalQuilosPerdidos;
	}
	public Date getDataPesagem() {
		return dataPesagem;
	}
	public void setDataPesagem(Date dataPesagem) {
		this.dataPesagem = dataPesagem;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double d) {
		this.altura = d;
	}
	/* O metódo CalcularPeso() recebe os dados de descricaoPeso, quilosPerdidos e calcula o total de quilos perdidos na variável totalQuilosPerdidos
	 */
		public void calcularPeso(float peso, float novoPeso,float totalQuilosPerdidos, float setTotalQuilosPerdidos) {
		    float y = peso - novoPeso;
		    setTotalQuilosPerdidos(y);
			if (totalQuilosPerdidos < 0) {
			System.out.println("Voce Ganhou " + getTotalQuilosPerdidos() + " Kg");}
			else if (totalQuilosPerdidos == 0) {
			System.out.println("Voce Não perdeu nem ganhou quilos");}
			if (totalQuilosPerdidos > 0) {
			System.out.println("Voce Perdeu " + getTotalQuilosPerdidos() + " Kg");}
		}
	/*O metódo adicionarDataPeso recebe a informação de data do dia*/

		public void adicionarDataPeso(Date getDataPesagem) {
			System.out.println("Foi adicionado a data " + getDataPesagem());
		}
	/* Metodo para calculo do IMC */
		
		public void calcularImc (double setImc) {
			double t = altura * altura ;
			double w = peso/t;
			setImc(w);
			System.out.printf("Seu IMC é " + getImc());
		}
	    	
		@Override
		public String toString() {
			return "Medidas [idMedidas=" + idMedidas + ", peso=" + peso + ", totalQuilosPerdidos=" + totalQuilosPerdidos
					+ ", dataPesagem=" + dataPesagem + ", altura=" + altura + ", imc=" + imc + ", pressaoArterial="
					+ pressaoArterial + ", nmCPF " + usuarioUm + "]";
		}
		
		public List<Medidas> VisualizaMedidas() {
			MedidasDAO mDAO = new MedidasDAO();
			return mDAO.Getall();
		}

		public Medidas SelecionaMedidas(String id) {
			MedidasDAO mDAO = new MedidasDAO();
			return mDAO.GetById(id);

		}

		public int RemoveMedidas(int id) {
			MedidasDAO mDAO = new MedidasDAO();
			return mDAO.Delete(id);
		}

		public int AtualizaMedidas() {
			MedidasDAO mDAO = new MedidasDAO();
			return mDAO.Update(this);
		}
}