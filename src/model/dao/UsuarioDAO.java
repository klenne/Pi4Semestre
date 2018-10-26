package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connectionDB.ConnectionFactory;
import model.bean.Usuario;

public class UsuarioDAO {// Usuario Data Acess Object

	// objeto com métodos que realizam instruções sql genéricas, para evitar
	// repetição de código
	InstrucoesGenericas ig;
	private final String TABLE = "USUARIO", PK = "cod_usuario";

	public void cadastrar(Usuario u) {

		// Instrução SQL
		String InsereUsuario = "INSERT INTO  " + TABLE
				+ "  (email,nome,senha,telefone,uf,cidade,bairro,foto) VALUES(?,?,?,?,?,?,?,?)";
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			// gravando usuário no banco de dados
			stmt = con.prepareStatement(InsereUsuario);
			stmt.setString(1, u.getEmail());
			stmt.setString(2, u.getNome());
			stmt.setString(3, u.getSenha());
			stmt.setString(4, u.getTelefone());
			stmt.setString(5, u.getUf());
			stmt.setString(6, u.getCidade());
			stmt.setString(7, u.getBairro());
			stmt.setString(8, u.getFoto());
			stmt.executeUpdate();

		} catch (SQLException ex) {
			System.out.println(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

	public void constroiUser(Usuario u, String email) {
		/*
		 * Método que busca registros do usuario no banco e constroi um objeto usuario
		 * para ser mais simples utilizar esses dados durante a execcução do programa
		 */

		// instrução SQL
<<<<<<< HEAD
		String querryBusca = "select cod_usuario,email,nome,senha,telefone,uf,cidade,bairro,foto  from " + TABLE
				+ "  where email=?";
=======
		String querryBusca = "select cod_usuario,email,nome,senha,telefone,uf,cidade,bairro,foto  from " +TABLE+"  where email=?";
>>>>>>> origin/master

		Connection con = ConnectionFactory.getConnection();

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = con.prepareStatement(querryBusca);
			stmt.setString(1, email);
			rs = stmt.executeQuery();

			// construindo um objeto usuario
			rs.next();
			u.setCodUsuario(rs.getInt("cod_usuario"));
			u.setEmail(rs.getString("email"));
			u.setNome(rs.getString("nome"));
			u.setSenha(rs.getString("senha"));
			u.setTelefone(rs.getString("telefone"));
			u.setUf(rs.getString("uf"));
			u.setCidade(rs.getString("cidade"));
			u.setBairro(rs.getString("bairro"));
			u.setFoto(rs.getString("foto"));

		} catch (SQLException ex) {
			System.out.println(ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}

	}

	public boolean login(String email, String senha) throws SQLException {
		/*
		 * buscando registros no banco de dados, se existir 1 registro com o email e a
		 * senha correspondendo aos parâmetros passados o método retorna true
		 */

		Connection con = ConnectionFactory.getConnection();
<<<<<<< HEAD
		String sql = "select Count(email)as login from " + TABLE + " where email=? and senha=?";
=======
		String sql = "select Count(email)as login from " +TABLE+" where email=? and senha=?";
>>>>>>> origin/master
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, email);
		stmt.setString(2, senha);
		ResultSet rs = stmt.executeQuery();
		rs.next();
		String result = rs.getString("login");
		ConnectionFactory.closeConnection(con, stmt);
		if (result.equals("1")) {
			return true;
		}

		return false;

	}

	public boolean checkEmail(String email) throws SQLException {
		/*
		 * Método para verificar se já estão utilizando o email passado como parâmetro
		 * quando for cadastrar um novo usuário se ele já existe retorna false, senão
		 * retorna true
		 */
		String campo = "email";
		return InstrucoesGenericas.check(campo, email, TABLE);
	}

	public void alterarSenha(Usuario u, String senhaNova) throws SQLException {

		InstrucoesGenericas.altera(TABLE, "senha", PK, senhaNova, u.getCodUsuario());

	}

	public void alterarEndereco(Usuario u, String ufNova, String cidadeNova, String bairroNovo) throws SQLException {
		// alterando uf, cidade e bairro
		InstrucoesGenericas.altera(TABLE, "uf", PK, ufNova, u.getCodUsuario());
		InstrucoesGenericas.altera(TABLE, "cidade", PK, cidadeNova, u.getCodUsuario());
		InstrucoesGenericas.altera(TABLE, "bairro", PK, bairroNovo, u.getCodUsuario());

	}

	public void alterarNome(Usuario u, String novoNome) throws SQLException {
		InstrucoesGenericas.altera(TABLE, "nome", PK, novoNome, u.getCodUsuario());

	}

	public void alterarTelefone(Usuario u, String novoTelefone) throws SQLException {
		InstrucoesGenericas.altera(TABLE, "telefone", PK, novoTelefone, u.getCodUsuario());

	}

<<<<<<< HEAD
	public void alterarFoto(Usuario u, String novaFoto) throws SQLException {
		InstrucoesGenericas.altera(TABLE, "foto", PK, novaFoto, u.getCodUsuario());
	}
=======
>>>>>>> origin/master
}
