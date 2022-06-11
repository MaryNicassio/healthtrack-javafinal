package br.com.healthtrack.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.healthtrack.BO.Treino;


public class TreinoDAO {
	
	public int add(Treino Tre) {
		DAO dao = new DAO();
		try {
			PreparedStatement stmt = dao.getConnetion().prepareStatement("INSERT INTO T_SHT_TREINO VALUES (SQ_IDTREINO.NEXTVAL,?,?,?,?,?,?)");
			stmt.setFloat(1,Tre.getDuracao());
			stmt.setInt(2,Tre.getQuantExercicio());
			stmt.setString(3,Tre.getDescricao());
			stmt.setString(4,Tre.getNomeTreino());
			stmt.setInt(5,Tre.getRepeticaoTreino());
			stmt.setString(6,Tre.getUsuarioUm().getCpf());
			return dao.ExecuteCommand(stmt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} return 0;
	} 
	
	// 
	public List<Treino> Getall() {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		List<Treino> listM = new ArrayList<Treino>();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnetion().prepareStatement("SELECT * FROM T_SHT_TREINO");
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				Treino Tre = new Treino();
				Tre.setDuracao(result.getFloat("DS_DURACAO"));
				Tre.setQuantExercicio(result.getInt("QTD_EXERCICIO"));
				Tre.setDescricao(result.getString("DS_TREINO"));
				Tre.setNomeTreino(result.getString("NM_TREINO"));
				Tre.getUsuarioUm().setCpf(result.getString("T_SHT_USUARIO_NM_CPF"));
				listM.add(Tre);
			}
			return listM;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Treino GetById(String id) {
		DAO dao = new DAO();
		PreparedStatement stmt;
		try {
			stmt = dao.getConnetion().prepareStatement("SELECT * FROM T_SHT_TREINO WHERE T_SHT_USUARIO_NM_CPF = ?");
			stmt.setString(1, id);
			ResultSet result = null;
			result = dao.GetData(stmt);
			while (result.next()) {
				Treino m = new Treino();
				m.setDuracao(result.getFloat("DS_DURACAO"));
				m.setQuantExercicio(result.getInt("QTD_EXERCICIO"));
				m.setDescricao(result.getString("DS_TREINO"));
				m.setNomeTreino(result.getString("NM_TREINO"));
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
			PreparedStatement stmt = dao.getConnetion().prepareStatement("DELETE FROM T_SHT_TREINO_NM_CPF WHERE ID_TREINO = ?");
			stmt.setInt(1, id);
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}
	public int Update(Treino obj) {
		try {
			DAO dao = new DAO();
			PreparedStatement stmt = dao.getConnetion()
					.prepareStatement("UPDATE T_SHT_TREINO SET DS_TREINO = ? WHERE DS_TREINO = ?");
			stmt.setString(1, obj.getDescricao());
			stmt.setInt(2, obj.getIdTreino());
			return dao.ExecuteCommand(stmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return 0;
	}
}
