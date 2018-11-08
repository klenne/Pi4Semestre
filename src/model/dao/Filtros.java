package model.dao;

public class Filtros {

    /*
    classe para adicionar filtros para as buscas de anuncios
    
    Utiliza dois vetores, um com a resposta que é mostrada para o usuário e outro com a instrução sql parea buscar no banco de dados
     */
    
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

    public String joinRequisito() {// caso utilize o filtro Requisito é necessario usar esse join
        return " join  REQUISITO as r  on   ap.cod_anuncio=r.cod_anuncio ";
    }

    public void filtroTitulo(String titulo) {//filtrando por título ex: Fifa 2018
        filtrosMostrar[0] = "Título: " + titulo;
        filtrosSql[0] = "and ap.titulo = '" + titulo.toUpperCase() + "' ";

    }

    public void filtroConsole(String console) {//filtrando por console ex: playstation 4 ou ps4
        filtrosMostrar[1] = "No console: " + console.toUpperCase();
        filtrosSql[1] = "and ap.console = '" + console.toUpperCase() + "' ";

    }

    public void filtroRequisito(String requisito) {// filtrando por quem está aceitando o jogo que o usuário tem ex: tenho o jogo Gta V quem esta aceitando esse jogo como troca
        filtrosMostrar[2] = "Aceitando o jogo: " + requisito;
        filtrosSql[2] = "and r.interesse_em like '%" + requisito.toUpperCase() + "%' ";

    }

    public void filtroCategoria(String categoria) {// filtrando por categoria ex: jogo, console, acessório
        filtrosMostrar[3] = "Categoria: " + categoria;
        filtrosSql[3] = "and ap.tipo = '" + categoria + "' ";
    }

    public void filtroValor(String valor) {// filtrando por tipo de transação ex: troca, Venda, doação
        if (valor.equals("VENDA")) {

            filtrosSql[4] = "and not ap.valor = 'TROCA' and not ap.valor='DOACAO' ";
        } else {
            filtrosSql[4] = "and ap.valor = '" + valor + "' ";
        }
        filtrosMostrar[4] = "Tipo transacão: " + valor;

    }

    public void removerFiltro(int index) {//remove o filtro dos vetores na posição passada como parâmetro
        filtrosMostrar[index] = "";
        filtrosSql[index] = "";
    }

    public String filtrosParaString() {// passa todas as instrucões de consulta no banco de dados para uma única String
        String filtros = "";
        for (int i = 0; i < filtrosSql.length; i++) {
            filtros += filtrosSql[i] + " ";
        }
        return filtros;
    }

    public void limpa() {// passa uma String vazia para todas as posições dos vetores

        for (int i = 0; i < filtrosSql.length; i++) {
            filtrosSql[i] = "";
            filtrosMostrar[i] = "";
        }
    }

}
