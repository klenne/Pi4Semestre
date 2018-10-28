package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connectionDB.ConnectionFactory;
import model.bean.CidadeEstado;


public class CidadesEstadoDAO {

	public List<CidadeEstado> buscaUF() throws  SQLException  {

		String querryBusca = "select uf from estado";

		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		 stmt = con.prepareStatement(querryBusca);
		List<CidadeEstado> ufs = new ArrayList<>();
		rs = stmt.executeQuery();
		while (rs.next()) {
			CidadeEstado ce = new CidadeEstado();
			ce.setUf(rs.getString("uf"));
			ufs.add(ce);

		}
		ConnectionFactory.closeConnection(con, stmt, rs);
		return ufs;
	}
	
	public List<CidadeEstado> buscaCidade(String uf) throws  SQLException  {

		String querryBusca = "select nome from cidade where estado =(select id from estado where uf=? ) ";

		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;
		 stmt = con.prepareStatement(querryBusca);
		 stmt.setString(1,uf);
		List<CidadeEstado> cidades = new ArrayList<>();
		rs = stmt.executeQuery();
		while (rs.next()) {
			CidadeEstado ce = new CidadeEstado();
			ce.setCidade(rs.getString("nome"));
			cidades.add(ce);

		}
		ConnectionFactory.closeConnection(con, stmt, rs);
		return cidades;
	}

}
