/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.sql.SQLException;
import model.bean.Transacao;
import model.bean.Usuario;
import model.dao.TransacaoDAO;

/**
 *
 * @author USER
 */
public class Teste {
    public static void main (String args[]) throws SQLException{
        TransacaoDAO tDAO=new TransacaoDAO();
        Usuario u =new Usuario ();
        u.setCodUsuario(2);
  for(Transacao t: tDAO.listarInteracoesComMeusAnuncios("INTERESSE", u))  {
        System.out.println(t.getNome());
        System.out.println(t.getTitulo());
    }
    }
    
}
