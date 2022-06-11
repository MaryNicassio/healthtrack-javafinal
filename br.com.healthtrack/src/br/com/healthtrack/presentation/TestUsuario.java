package br.com.healthtrack.presentation;

import br.com.healthtrack.BO.Usuario;
import br.com.healthtrack.DAO.UsuarioDAO;

public class TestUsuario {
	public static void main(String[] args) {
		Usuario u1 = new Usuario();
		
		u1.setCpf("44455566677");
		u1.setNome("Rachel Karen Green");
		u1.setDataNascimento("15/05/1983");
		u1.setEmailLogin("rachkgreen@gmail.com");
		u1.setGenero("f");
		u1.setSenha("blomies");
		UsuarioDAO uDAO = new UsuarioDAO();
		System.out.println("Usuario Cadastrado.Registros alterados: " + uDAO.add(u1));
	}
}
