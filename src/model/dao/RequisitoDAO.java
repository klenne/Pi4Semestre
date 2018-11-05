package model.dao;

import connectionDB.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.AnuncioProduto;
import model.bean.Requisito;

public class RequisitoDAO {

    private final String TABLE = "REQUISITO";
    private final String PK = "cod_requisito";

    public void adicionarRequisito(Requisito r, AnuncioProduto ap) {

        String InsereRequisito = "INSERT INTO  " + TABLE
                + "  (interesse_em,cod_anuncio) VALUES(?,?)";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            // gravando requisito no banco
            stmt = con.prepareStatement(InsereRequisito);
            stmt.setString(1, r.getInteresseEm());
            stmt.setInt(2, ap.getCodAnuncio());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void constroiRequisito(Requisito r, int codRequisito) {

        String querryBusca = "select cod_requisito,cod_anuncio,interesse_em from " + TABLE + " where " + PK + " = ?";
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(querryBusca);
            stmt.setInt(1, codRequisito);
            rs = stmt.executeQuery();

            // construindo um objeto requisito
            rs.next();
            r.setCodRequisito(rs.getInt("cod_requisito"));
            r.setCodAnuncio(rs.getInt("cod_anuncio"));
            r.setInteresseEm(rs.getString("interesse_em"));

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Requisito> listarRequisitos(AnuncioProduto ap) throws SQLException {
        String sql = "select cod_requisito,cod_anuncio,interesse_em from " + TABLE + " where cod_anuncio = ?";
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = ConnectionFactory.getConnection();
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, ap.getCodAnuncio());
        List<Requisito> requisitos = new ArrayList<>();
        rs = stmt.executeQuery();

        while (rs.next()) {
            Requisito r = new Requisito();
            r.setCodRequisito(rs.getInt("cod_requisito"));
            r.setCodAnuncio(rs.getInt("cod_anuncio"));
            r.setInteresseEm(rs.getString("interesse_em"));
            requisitos.add(r);

        }
        ConnectionFactory.closeConnection(con, stmt, rs);
        return requisitos;
    }

    public void apagarRequisito(Requisito r) throws SQLException {
        InstrucoesGenericas.deleta(TABLE, PK, r.getCodRequisito());
    }

    public void alterarRequisito(Requisito r) throws SQLException {
        InstrucoesGenericas.altera(TABLE, "interesse_em", PK, r.getInteresseEm(), r.getCodRequisito());
    }

}
