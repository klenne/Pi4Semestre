package model.dao;

import connectionDB.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.AnuncioProduto;
import model.bean.Usuario;

public class AnuncioProdutoDAO {

    InstrucoesGenericas ig;
    private final String TABLE = "ANUNCIO_PRODUTO", PK = "cod_anuncio";

    public void cadastraAnuncio(AnuncioProduto ap, Usuario u) {// cadastrando produto

        String InsereAnuncioProduto = "INSERT INTO  " + TABLE
                + " (cod_usuario,tipo,titulo,console,valor,status,foto) VALUES(?,?,?,?,?,?,?)";
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            // gravando anuncio do produto  no banco de dados
            stmt = con.prepareStatement(InsereAnuncioProduto);
            stmt.setInt(1, u.getCodUsuario());
            stmt.setString(2, ap.getTipo());
            stmt.setString(3, ap.getTitulo());
            stmt.setString(4, ap.getConsole());
            stmt.setString(5, ap.getValor());
            stmt.setString(6, "ATIVO");
            stmt.setString(7, ap.getFoto());
            stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void constroiAnuncio(AnuncioProduto ap) {
        String querryBusca = "select cod_usuario,tipo,titulo,console,valor,status,foto  from "
                + TABLE + "  where cod_anuncio =?";

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(querryBusca);
            stmt.setInt(1, ap.getCodAnuncio());
            rs = stmt.executeQuery();

            // construindo um objeto anuncioProduto
            rs.next();
            ap.setCodUsuario(rs.getInt("cod_usuario"));
            ap.setTipo(rs.getString("tipo"));
            ap.setTitulo(rs.getString("titulo"));
            ap.setConsole(rs.getString("console"));
            ap.setStatus(rs.getString("status"));
            ap.setFoto(rs.getString("foto"));

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void alterarAnuncio(AnuncioProduto ap) throws SQLException {
        InstrucoesGenericas.altera(TABLE, "tipo", PK, ap.getTipo(), ap.getCodAnuncio());
        InstrucoesGenericas.altera(TABLE, "titulo", PK, ap.getTitulo(), ap.getCodAnuncio());
        InstrucoesGenericas.altera(TABLE, "console", PK, ap.getConsole(), ap.getCodAnuncio());
        InstrucoesGenericas.altera(TABLE, "valor", PK, ap.getValor(), ap.getCodAnuncio());
        InstrucoesGenericas.altera(TABLE, "status", PK, ap.getStatus(), ap.getCodAnuncio());
        InstrucoesGenericas.altera(TABLE, "foto", PK, ap.getFoto(), ap.getCodAnuncio());
    }

    public void removerAnuncio(AnuncioProduto ap) throws SQLException {
        InstrucoesGenericas.deleta(TABLE, PK, ap.getCodAnuncio());
    }

    public List<AnuncioProduto> buscarAnuncios(String filtros) throws SQLException {
        String sql = "select cod_anuncio,titulo,valor from " + TABLE + " where cod_anuncio is not null " + filtros;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = ConnectionFactory.getConnection();
        List<AnuncioProduto> anuncios = new ArrayList<>();
        rs = stmt.executeQuery();
        while (rs.next()) {
            AnuncioProduto ap = new AnuncioProduto();
            ap.setCodAnuncio(rs.getInt("cod_anuncio"));
            ap.setTitulo(rs.getString("titulo"));
            ap.setValor(rs.getString("valor"));
            anuncios.add(ap);
        }
        ConnectionFactory.closeConnection(con, stmt, rs);
        return anuncios;
    }

}
