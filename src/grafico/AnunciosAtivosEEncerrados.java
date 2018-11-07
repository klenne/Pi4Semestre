/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafico;

import java.sql.SQLException;
import javax.swing.JFrame;
import model.dao.AnuncioProdutoDAO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class AnunciosAtivosEEncerrados extends JFrame {
AnuncioProdutoDAO apDAO=new AnuncioProdutoDAO();
int a,b;
    public AnunciosAtivosEEncerrados() throws SQLException {
        super("Anúncios Ativos e Encerrados"); //Define o titulo da tela
        //Cria um dataSet para inserir os dados que serão passados para a criação do gráfico tipo Pie
        DefaultPieDataset pieDataset = new DefaultPieDataset();

//Adiciona os dados ao dataSet deve somar um total de 100%
a=apDAO.contaAnunciosAtivos();
b=apDAO.contaAnunciosEncerrados();
        pieDataset.setValue("Anúncios ativos: "+a, new Integer(a));
        pieDataset.setValue("Anúncios encerrados: "+b, new Integer(b));

//Cria um objeto JFreeChart passando os seguintes parametros
        JFreeChart grafico = ChartFactory.createPieChart(
                "Anúncios Ativos e Encerrados", //Titulo do grafico
                pieDataset, //DataSet
                true, //Para mostrar ou não a legenda
                true, //Para mostrar ou não os tooltips
                false);

        this.add(new ChartPanel(grafico));
        this.pack(); //para ajustar automaticamente o Frame
    }



}
