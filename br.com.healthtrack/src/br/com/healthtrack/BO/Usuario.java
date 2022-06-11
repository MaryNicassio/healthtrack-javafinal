package br.com.healthtrack.BO;

/* A classe Usuario armazena as informações de nome, data de nascimento, idade, altura, peso inicial
 * , endereço, email e senha */

public class Usuario {
	    protected String nome;
	    protected String cpf;
		protected String dataNascimento;
		protected int idade;
		protected float altura;
		protected String endereco;
		protected String emailLogin;
		protected String senha;
		protected String genero;

		public String getGenero() {
			return genero;
		}
		public void setGenero(String genero) {
			this.genero = genero;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(String dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		public int getIdade() {
			return idade;
		}
		public void setIdade(int idade) {
			this.idade = idade;
		}
		public float getAltura() {
			return altura;
		}
		public void setAltura(float altura) {
			this.altura = altura;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public String getEmailLogin() {
			return emailLogin;
		}
		public void setEmailLogin(String emailLogin) {
			this.emailLogin = emailLogin;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		
		public void validarPermissoes() {
		}
		@Override
		public String toString() {
			return "Usuario [cpf=" + cpf + "]";
		}
		
		
		
	}
