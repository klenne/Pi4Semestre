/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import model.dao.Filtros;

/**
 *
 * @author USER
 */
public class TesteFiltro {

    public static void main(String args[]) {

        Filtros f = new Filtros();
        f.filtroConsole("ps4");
        f.filtroRequisito("RED DEAD REDENPTION 2");

        for (String a : f.getFiltrosMostrar()) {
            System.out.println(a);
        }

        System.out.println("");

        for (String a : f.getFiltrosSql()) {
            System.out.println(a);
        }

        System.out.println("");
        
      
  
        
       
        f.filtroConsole("xone");
        
                for (String a : f.getFiltrosMostrar()) {
            System.out.println(a);
        }

        System.out.println("");

        for (String a : f.getFiltrosSql()) {
            System.out.println(a);
        }
        
        
        System.out.println(f.filtroParaString());
        
        
        
        
        
        
        
    }
}
