/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teste;

import model.bean.AnuncioProduto;
import model.bean.Usuario;
import model.dao.AnuncioProdutoDAO;

/**
 *
 * @author USER
 */
public class Teste {

    public static void main(String args[]) {
        AnuncioProduto ap = new AnuncioProduto();
        AnuncioProdutoDAO apDAO = new AnuncioProdutoDAO();
        Usuario u = new Usuario();
        
        u.setCodUsuario(9);
        
        ap.setTipo("JOGO");
        ap.setTitulo("RED DEAD REDEMPTION 2");
        ap.setConsole("PS4");
        ap.setValor("250");

        apDAO.cadastraAnuncio(ap, u);

    }

}
