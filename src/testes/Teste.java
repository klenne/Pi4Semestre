package testes;

import java.sql.SQLException;

import model.bean.Usuario;
import model.dao.UsuarioDAO;

public class Teste {

	public static void main(String[] args) {
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		/*
		 * Usuario u = new Usuario(); UsuarioDAO uDAO = new UsuarioDAO();
		 * uDAO.constroiUser(u, "guiklesse@gmail.com"); System.out.println(u.getNome() +
		 * "\n" + u.getEmail() + "\n" + u.getBairro() + "\n" + u.getCidade() + "\n" +
		 * u.getCpf() + "\n" + u.getFoto() + "\n" + u.getSenha() + "\n" +
		 * u.getTelefone() + "\n" + u.getUf());	
		 * 
		 * teste do método constroiUser() da classe UsuarioDAO 
		 */
		
		
	//////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		/*
		 Usuario u = new Usuario(); 
		 UsuarioDAO uDAO = new UsuarioDAO();
		 u.setEmail("teste@teste.com");
		 u.setNome("teste");
		 u.setCpf("12345678910");
		 u.setSenha("123mudar");
		 u.setTelefone("40028922");
		 u.setUf("FV");
		 u.setCidade("Mississipi");
		 u.setBairro("derry");
		 u.setFoto(":)");
		 
		 uDAO.cadastrar(u);
		
		teste do método para cadastrar usuário
		 
		 */
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		/*
		 UsuarioDAO uDAO = new UsuarioDAO();
		 try {
			System.out.println(uDAO.login("teste@teste.com", "123mudar"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		teste do método login
		
		*/
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////
		
		 Usuario u = new Usuario(); 
		 UsuarioDAO uDAO = new UsuarioDAO();
		 u.setEmail("teste@teste.com");
		 u.setNome("teste");
		 u.setCpf("12345678910");
		 u.setSenha("123mudar");
		 u.setTelefone("40028922");
		 u.setUf("FV");
		 u.setCidade("Mississipi");
		 u.setBairro("derry");
		 u.setFoto(":)");
		 
		 try {
			uDAO.alterarEndereco(u, "SP", "Ferraz", "Sítio paredão");
			uDAO.alterarNome(u, "Guilherme");
			uDAO.alterarSenha(u, "123");
			uDAO.alterarTelefone(u, "754675673");
			
			System.out.println("testando cpf "+uDAO.checkCPF("12345678910"));
			System.out.println("testando email "+uDAO.checkEmail("teste@teste.com"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//testando métodos alterarEndereco, alterarNome, alterarSenha, alterarTelefone, checkCpf, e checkEmail
		
	
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	}

}
