package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectionDB.ConnectionFactory;

public class InstrucoesGenericas {

	public static boolean check(String campo, String valor, String table) throws SQLException {

		// método genérico para verificar existencia de itens se existe retorna false,
		// senão true

		Connection con = ConnectionFactory.getConnection();
		String sql = "select count(" + campo + ") as " + campo + " from " + table + " where " + campo + " = ? ;";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, valor);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		String result = rs.getString(campo);
		ConnectionFactory.closeConnection(con, stmt);
		if (result.equals("1")) {
			return false;
		}
		return true;
	}

	public static void altera(String table, String campo, String campoPk, String valor, int valorPk)
			throws SQLException {
		// método genérico para alterar um valor
		Connection con = ConnectionFactory.getConnection();
		String sql = "update " + table + " set " + campo + " =? where " + campoPk + " = ?; ";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, valor);
		stmt.setInt(2, valorPk);
		stmt.executeUpdate();
		ConnectionFactory.closeConnection(con, stmt);

	}

}
