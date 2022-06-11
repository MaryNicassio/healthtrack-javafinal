package br.com.healthtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.healthtrack.BO.ContaPremium;

public class ContaPremiumDAO {
	
	public int add(ContaPremium Pre) {
		DAO dao = new DAO();
		try {
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			PreparedStatement stmt = dao.getConnetion().prepareStatement("INSERT INTO T_SHT_CARTAO VALUES (SQ_NR_CARTAO.NEXTVAL,?,?,?,?,?)");
			stmt.setString(1,Pre.getNrCartao());
			stmt.setString(2,Pre.getNmCartao());
			stmt.setDate(3,data);
			stmt.setInt(4,Pre.getPinCartao());
			stmt.setString(6,Pre.getUsuarioUm().getCpf());
			return dao.ExecuteCommand(stmt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} return 0;
	} 
	
	// 
	public List<ContaPremium> Getall() {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<ContaPremium> listM = new ArrayList<ContaPremium>();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnetion().prepareStatement("SELECT * FROM T_SHT_CARTAO");
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				ContaPremium Pre = new ContaPremium();
				Pre.setNrCartao(result.getString("NR_CARTAO"));
				Pre.setNmCartao(result.getString("NM_CARTAO"));
				Pre.setDtCartao(result.getDate("DT_VALIDADE"));
				Pre.setPinCartao(result.getInt("PIN_CARTAO"));
				Pre.getUsuarioUm().setCpf(result.getString("T_SHT_USUARIO_NM_CPF"));
				listM.add(Pre);
			}
			return listM;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public ContaPremium GetById(String id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnetion().prepareStatement("SELECT * FROM T_SHT_TREINO WHERE T_SHT_USUARIO_NM_CPF = ?");
			stmt.setString(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				ContaPremium m = new ContaPremium();
				m.setNrCartao(result.getString("NR_CARTAO"));
				m.setNmCartao(result.getString("NM_CARTAO"));
				m.setDtCartao(result.getDate("DT_VALIDADE"));
				m.setPinCartao(result.getInt("PIN_CARTAO"));
				m.getUsuarioUm().setCpf(result.getString("T_SHT_USUARIO_NM_CPF"));
				return m;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
	public int Delete(int pin) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.getConnetion().prepareStatement("DELETE FROM T_SHT_CARTAO WHERE PIN_CARTAO = ?");
			stmt.setInt(1, pin);
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}
	public int Update(ContaPremium obj) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.getConnetion()
					.prepareStatement("UPDATE T_SHT_CARTAO SET NM_CARTAO = ? WHERE NM_CPF = ?");
			stmt.setString(1, obj.getNmCartao());
			stmt.setString(2, obj.getCpf());
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}
}

