package model.dao;

import connectionDB.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.bean.Transacao;
import model.bean.Usuario;

public class TransacaoDAO {

    private final String TABLE = "TRANSACAO", PK = "cod_transacao";

    public void gravaTransacao(Transacao t) throws ParseException {

        String InsereAnuncioProduto = "INSERT INTO  " + TABLE
                + " (cod_usuario,cod_anuncio,status,data) VALUES(?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        t.setDate();
        String data = t.getData();

        try {
            // gravando transacao  no banco de dados
            stmt = con.prepareStatement(InsereAnuncioProduto);
            stmt.setInt(1, t.getCodUsuario());
            stmt.setInt(2, t.getCodAnuncio());
            stmt.setString(3, "INTERESSE");
            stmt.setDate(4, new java.sql.Date(format.parse(data).getTime()));
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void deletarTransacao(Transacao t) throws SQLException {
        InstrucoesGenericas.deleta(TABLE, PK, t.getCodTransacao());
    }

    public List<Transacao> listarMinhasTransacoes(String tipoBusca, Usuario u) throws SQLException {// lista as transacoes que usuario realizou

        String sql = "select t.cod_transacao, t.cod_anuncio,ap.titulo,t.status,t.data from TRANSACAO"
                + " as t join ANUNCIO_PRODUTO as ap on t.cod_anuncio = ap.cod_anuncio where t.cod_usuario= ? and t.status = ?";
        PreparedStatement stmt = null;
        Connection con = ConnectionFactory.getConnection();
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, u.getCodUsuario());
        switch (tipoBusca) {
            case "INTERESSE":
                stmt.setString(2, "INTERESSE");
                break;
            case "EM_ANDAMENTO":
                stmt.setString(2, "EM_ANDAMENTO");
                break;
            case "REALIZADA":
                stmt.setString(2, "REALIZADA");
                break;
            case "CANCELADA":
                stmt.setString(2, "CANCELADA");
                break;
        }

        ResultSet rs = null;

        List<Transacao> transacoes = new ArrayList<>();
        rs = stmt.executeQuery();
        while (rs.next()) {
            Transacao t = new Transacao();
            t.setCodTransacao(rs.getInt("t.cod_transacao"));
            t.setCodAnuncio(rs.getInt("t.cod_anuncio"));
            t.setTitulo(rs.getString("ap.titulo"));
            t.setStatus(rs.getString("t.status"));
            t.setData(String.valueOf(rs.getDate("t.data")));
            transacoes.add(t);
        }
        ConnectionFactory.closeConnection(con, stmt, rs);
        return transacoes;

    }

    public List<Transacao> listarInteracoesComMeusAnuncios(String status, Usuario u) throws SQLException {// lista os interesses de outros usuarios nos anuncios  do usuario

        String sql = "select u.nome,t.cod_transacao,t.cod_anuncio,ap.titulo,t.data from TRANSACAO as t join ANUNCIO_PRODUTO as ap on t.cod_anuncio=ap.cod_anuncio "
                + " join USUARIO as u on t.cod_usuario = u.cod_usuario "
                + " where ap.cod_usuario =? and t.status=?";
        PreparedStatement stmt = null;
        Connection con = ConnectionFactory.getConnection();
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, u.getCodUsuario());
        switch (status) {
            case "INTERESSE":
                stmt.setString(2, "INTERESSE");
                break;
            case "EM_ANDAMENTO":
                stmt.setString(2, "EM_ANDAMENTO");
                break;
            case "REALIZADA":
                stmt.setString(2, "REALIZADA");
                break;
            case "CANCELADA":
                stmt.setString(2, "CANCELADA");
                break;
        }

        ResultSet rs = null;

        List<Transacao> transacoes = new ArrayList<>();
        rs = stmt.executeQuery();
        while (rs.next()) {
            Transacao t = new Transacao();
            t.setNome(rs.getString("u.nome"));
            t.setCodTransacao(rs.getInt("t.cod_transacao"));
            t.setCodAnuncio(rs.getInt("t.cod_anuncio"));
            t.setTitulo(rs.getString("ap.titulo"));
            t.setData(String.valueOf(rs.getDate("t.data")));
            transacoes.add(t);
        }
        ConnectionFactory.closeConnection(con, stmt, rs);
        return transacoes;

    }

    public boolean checkTransacao(int codUsuario, int codAnuncio) throws SQLException {//verifica se usuario já tem interesse no produto
        return InstrucoesGenericas.check("cod_anuncio", codAnuncio, TABLE, "cod_usuario", codUsuario);

    }

    public void mudarStatusParaEmAndamento(int codTransacao) throws SQLException {
        InstrucoesGenericas.altera(TABLE, "status", PK, "EM_ANDAMENTO", codTransacao);
    }

    public void mudarStatusParaCancelada(int codTransacao) throws SQLException {
        InstrucoesGenericas.altera(TABLE, "status", PK, "CANCELADA", codTransacao);
    }

    public void mudarStatusParaRealizada(int codTransacao) throws SQLException {
        InstrucoesGenericas.altera(TABLE, "status", PK, "REALIZADA", codTransacao);
    }
}
