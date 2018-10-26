package testes;

import java.sql.SQLException;

import model.bean.Usuario;
import model.dao.UsuarioDAO;

public class Teste {

	public static void main(String[] args) {

		//////////////////////////////////////////////////////////////////////////////////////////////////

		// teste do método cadastra User
		/*
		 * 
		 * Usuario u = new Usuario(); UsuarioDAO uDAO = new UsuarioDAO();
		 * u.setEmail("teste@teste.com"); u.setNome("teste"); u.setSenha("123mudar");
		 * u.setTelefone("40028922"); u.setUf("FV"); u.setCidade("Mississipi");
		 * u.setBairro("derry"); u.setFoto(":)");
		 * 
		 * uDAO.cadastrar(u);
		 * 
		 * 
		 */

		/////////////////////////////////////////////////////////////////////////////////////////////////

		// testando método constroi user
		/*
		 * 
		 * Usuario u = new Usuario(); UsuarioDAO uDAO = new UsuarioDAO();
		 * uDAO.constroiUser(u, "teste@teste.com"); System.out.println(u.getNome() +
		 * "\n" + u.getEmail() + "\n" + u.getBairro() + "\n" + u.getCidade() + "\n" +
		 * u.getCodUsuario() + "\n" + u.getFoto() + "\n" + u.getSenha() + "\n" +
		 * u.getTelefone() + "\n" + u.getUf());
		 * 
		 */

		/////////////////////////////////////////////////////////////////////////////////////////////////

		/*
		 * UsuarioDAO uDAO = new UsuarioDAO(); try {
		 * System.out.println(uDAO.login("teste@teste.com", "123mudar")); } catch
		 * (SQLException e) { e.printStackTrace(); }
		 * 
		 * teste do método login
		 * 
		 */

		////////////////////////////////////////////////////////////////////////////////////////////////
/*
		Usuario u = new Usuario();
		UsuarioDAO uDAO = new UsuarioDAO();
		u.setEmail("teste@teste.com");
		u.setCodUsuario(1);
		try {
			uDAO.alterarEndereco(u, "SP", "Ferraz", "Sítio paredão");
			uDAO.alterarNome(u, "Guilherme");
			uDAO.alterarSenha(u, "123");
			uDAO.alterarTelefone(u, "754675673");

			System.out.println("testando email " + uDAO.checkEmail("teste@teste.com"));
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}

}
