package br.com.healthtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.BO.Exercicio;


public class ExercicioDAO {
	
	public int add(Exercicio Exe) {
		DAO dao = new DAO();
		try {
			PreparedStatement stmt = dao.getConnetion().prepareStatement("INSERT INTO T_SHT_EXERCICIO VALUES (SQ_IDEXERCICIO.NEXTVAL,?,?,?,?,?,?)");
			stmt.setString(1,Exe.getNomeExercicio());
			stmt.setInt(2,Exe.getIdExercicio());
			stmt.setFloat(3,Exe.getTempoDuracao());
			stmt.setString(4,Exe.getTipoExercicio());
			stmt.setString(5,Exe.getVideo());
			stmt.setString(7,Exe.getUsuarioUm().getCpf());
			return dao.ExecuteCommand(stmt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} return 0;
	} 
	
	// 
	public List<Exercicio> Getall() {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<Exercicio> listM = new ArrayList<Exercicio>();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnetion().prepareStatement("SELECT * FROM T_SHT_EXERCICIO");
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				Exercicio Exe = new Exercicio();
				Exe.setNomeExercicio(result.getString("NM_EXERCICIO"));
				Exe.setQtdRepeticoes(result.getInt("QTD_REPETICOES"));
				Exe.setTempoDuracao(result.getFloat("DS_DURACAO"));
				Exe.setTipoExercicio(result.getString("DS_EXERCICIO"));
				Exe.setVideo(result.getString("VDS_VIDEO"));
				Exe.getUsuarioUm().setCpf(result.getString("T_SHT_USUARIO_NM_CPF"));
				listM.add(Exe);
			}
			return listM;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Exercicio GetById(String id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnetion().prepareStatement("SELECT * FROM T_SHT_EXERCICIO WHERE T_SHT_USUARIO_NM_CPF = ?");
			stmt.setString(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				Exercicio m = new Exercicio();
				m.setNomeExercicio(result.getString("NM_EXERCICIO"));
				m.setQtdRepeticoes(result.getInt("QTD_REPETICOES"));
				m.setTempoDuracao(result.getFloat("DS_DURACAO"));
				m.setTipoExercicio(result.getString("DS_EXERCICIO"));
				m.setVideo(result.getString("VDS_VIDEO"));
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
	public int Delete(int id) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.getConnetion().prepareStatement("DELETE FROM T_SHT_EXERCICIO_NM_CPF WHERE ID_NUTRICAO = ?");
			stmt.setInt(1, id);
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}
	public int Update(Exercicio obj) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.getConnetion()
					.prepareStatement("UPDATE T_SHT_EXERCICIO SET DS_EXERCICIO = ? WHERE ID_EXERCICIO = ?");
			stmt.setString(1, obj.getTipoExercicio());
			stmt.setInt(2, obj.getIdExercicio());
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}
}
