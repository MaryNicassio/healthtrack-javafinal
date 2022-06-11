package br.com.healthtrack.presentation;

import br.com.healthtrack.BO.Medidas;
import br.com.healthtrack.BO.Usuario;
import br.com.healthtrack.DAO.MedidasDAO;

public class TestMedidas {
	public static void main(String[] args) {
		Usuario u1 = new Usuario();
		u1.setCpf("44455566677");
		Medidas med = new Medidas();
				
		med.setUsuarioUm(u1);
		med.setPeso(56);
		med.setAltura(1.54);
		med.calcularImc(0);
		med.setTotalQuilosPerdidos(0);
		med.setPressaoArterial("12/8");
		
		MedidasDAO mDAO = new MedidasDAO();
		System.out.println("Medidas cadastradas. Registros Alterados: " + mDAO.add(med));
				
		for (Medidas m :mDAO.Getall()) {
			System.out.println(m);
		}
	}
}
		/*for (Medidas m : mDAO.GetById("33322211100")) {
			System.out.println(m);
		}*/
