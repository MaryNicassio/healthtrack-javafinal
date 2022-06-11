package br.com.healthtrack.BO;

/* A classe Exercicio armazena o nome do exercicio, número do mesmo, tempo de duração, tipo de exercicio e o nome do video do exercicio
 */

public class Exercicio {
	private String nomeExercicio;
	private int idExercicio;
	private float tempoDuracao;
	private int qtdRepeticoes;
	private String tipoExercicio;
	private String video;
	private Usuario usuarioUm = new Usuario();
		
	public int getQtdRepeticoes() {
		return qtdRepeticoes;
	}

	public void setQtdRepeticoes(int qtdRepeticoes) {
		this.qtdRepeticoes = qtdRepeticoes;
	}

	public Usuario getUsuarioUm() {
		return usuarioUm;
	}

	public void setUsuarioUm(Usuario usuarioUm) {
		this.usuarioUm = usuarioUm;
	}

	public String getNomeExercicio() {
		return nomeExercicio;
	}

	public void setNomeExercicio(String nomeExercicio) {
		this.nomeExercicio = nomeExercicio;
	}

	public int getIdExercicio() {
		return idExercicio;
	}

	public void setIdExercicio(int idExercicio) {
		this.idExercicio = idExercicio;
	}

	public float getTempoDuracao() {
		return tempoDuracao;
	}

	public void setTempoDuracao(float tempoDuracao) {
		this.tempoDuracao = tempoDuracao;
	}

	public String getTipoExercicio() {
		return tipoExercicio;
	}

	public void setTipoExercicio(String tipoExercicio) {
		this.tipoExercicio = tipoExercicio;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}
	
	/* O metódo criarExercicio informa que o exercicio foi criado
	 */

	public static void criarExercicio () {
		System.out.println("Exercicio criado com sucesso!");
	}
}
