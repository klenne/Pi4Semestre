/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

/**
 *
 * @author USER
 */
public class Filtros {// classe para adicionar filtros para as buscas de anuncios

    private String filtrosSql[];// instrução sql
    private String filtrosMostrar[]; // para mostrar para o usuario o filtro 

    public Filtros() {
        filtrosMostrar = new String[10];
        filtrosSql = new String[10];
        limpa();
    }

    public String[] getFiltrosSql() {
        return filtrosSql;
    }

    public String[] getFiltrosMostrar() {
        return filtrosMostrar;
    }

    public String joinRequisito() {
        return " join  REQUISITO as r  on   ap.cod_anuncio=r.cod_anuncio ";
    }

    public void filtroTitulo(String titulo) {
        filtrosMostrar[0] = "Título: " + titulo;
        filtrosSql[0] = "and ap.titulo = '" + titulo.toUpperCase() + "' ";

    }

    public void filtroConsole(String console) {
        filtrosMostrar[1] = "No console: " + console.toUpperCase();
        filtrosSql[1] = "and ap.console = '" + console.toUpperCase() + "' ";

    }

    public void filtroRequisito(String requisito) {
        filtrosMostrar[2] = "Aceitando o jogo: " + requisito;
        filtrosSql[2] = "and r.interesse_em like '%" + requisito.toUpperCase() + "%' ";

    }

    public void filtroCategoria(String categoria) {
        filtrosMostrar[3] = "Categoria: " + categoria;
        filtrosSql[3] = "and ap.tipo = '" + categoria + "' ";
    }

    public void filtroValor(String valor) {
        if (valor.equals("VENDA")) {

            filtrosSql[4] = "and not ap.valor = 'TROCA' and not ap.valor='DOACAO' ";
        } else {
            filtrosSql[4] = "and ap.valor = '" + valor + "' ";
        }
        filtrosMostrar[4] = "Tipo transacão: " + valor;

    }

    public void removerFiltro(int index) {
        filtrosMostrar[index] = "";
        filtrosSql[index] = "";
    }

    public String filtrosParaString() {
        String filtros = "";
        for (int i = 0; i < filtrosSql.length; i++) {
            filtros += filtrosSql[i] + " ";
        }
        return filtros;
    }

    public void limpa() {

        for (int i = 0; i < filtrosSql.length; i++) {
            filtrosSql[i] = "";
            filtrosMostrar[i] = "";
        }
    }

}
