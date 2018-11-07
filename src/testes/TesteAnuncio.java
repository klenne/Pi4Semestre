/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import java.sql.SQLException;
import model.bean.AnuncioProduto;
import model.bean.Usuario;
import model.dao.AnuncioProdutoDAO;
import model.dao.Filtros;

/**
 *
 * @author USER
 */
public class TesteAnuncio {

    public static void main(String args[]) throws SQLException {
        Usuario u = new Usuario();
        u.setCodUsuario(2);
        Filtros f = new Filtros();
        AnuncioProdutoDAO apDAO = new AnuncioProdutoDAO();
        f.filtroRequisito("RED DEAD");
        
     
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
