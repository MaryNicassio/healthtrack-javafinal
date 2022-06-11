package br.com.healthtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.BO.Medidas;


public class MedidasDAO {
	
	public int add(Medidas Med) {
		DAO dao = new DAO();
		try {
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			PreparedStatement stmt = dao.getConnetion().prepareStatement("INSERT INTO T_SHT_MEDIDAS VALUES (SQ_IDMEDIDAS.NEXTVAL,?,?,?,?,?,?,?)");
			stmt.setFloat(1,Med.getPeso());
			stmt.setDouble(2,Med.getAltura());
			stmt.setDouble(3,Med.getImc());
			stmt.setFloat(4,Med.getTotalQuilosPerdidos());
			stmt.setDate(5,data);
			stmt.setString(6,Med.getPressaoArterial());
			stmt.setString(7,Med.getUsuarioUm().getCpf());
			return dao.ExecuteCommand(stmt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} return 0;
	} 
	
	// 
	public List<Medidas> Getall() {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<Medidas> listM = new ArrayList<Medidas>();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnetion().prepareStatement("SELECT * FROM T_SHT_MEDIDAS");
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				Medidas med = new Medidas();
				med.setPeso(result.getFloat("VL_PESO"));
				med.setAltura(result.getDouble("VL_ALTURA"));
				med.setImc(result.getDouble("VL_IMC"));
				med.setTotalQuilosPerdidos(result.getInt("VL_KQPERDIDOS"));
				med.setPressaoArterial(result.getString("VL_PRESSAOARTERIAL"));
				med.getUsuarioUm().setCpf(result.getString("T_SHT_USUARIO_NM_CPF"));
				listM.add(med);
			}
			return listM;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Medidas GetById(String id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnetion().prepareStatement("SELECT * FROM T_SHT_MEDIDAS WHERE T_SHT_USUARIO_NM_CPF = ?");
			stmt.setString(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				Medidas m = new Medidas();
				m.getUsuarioUm().setCpf(result.getString("T_SHT_USUARIO_NM_CPF"));
		        m.setPeso(result.getFloat("VL_PESO"));
		        m.setAltura(result.getDouble("VL_ALTURA"));
		        m.setImc(result.getDouble("VL_IMC"));
		        m.setTotalQuilosPerdidos(result.getFloat("VL_KQPERDIDOS"));
		        m.setPressaoArterial(result.getString("VL_PRESSAOARTERIAL"));
				return m;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
	public int Delete(int id) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.getConnetion().prepareStatement("DELETE FROM CATEGORY WHERE IDCATEGORY = ?");
			stmt.setInt(1, id);
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}
	public int Update(Medidas obj) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.getConnetion()
					.prepareStatement("UPDATE CATEGORY SET VL_PESO = ? WHERE ID_MEDIDAS = ?");
			stmt.setFloat(1, obj.getPeso());
			stmt.setInt(2, obj.getIdMedidas());
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}
}