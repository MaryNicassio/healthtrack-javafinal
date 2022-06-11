package br.com.healthtrack.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
	private Connection conn;
	
	public DAO () {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnetion(){
		openConnection();
		return this.conn;
	}
	private void openConnection() {
		try {
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM92041", "260697");
		    System.out.println("Conectado!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void closeConnection() {
		if (this.conn != null)
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public int ExecuteCommand(PreparedStatement stmt) {
		int j = 0;
		try {
			j = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return j;
	}
	public ResultSet GetData(PreparedStatement stmt) {
		ResultSet resultSet = null;
		try {
			resultSet = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;
	}
	public int ExecuteProcedure(CallableStatement cs) {

		try {
			return cs.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;

	}
}
