/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.AnuncioProduto;
import model.bean.Requisito;
import model.bean.Usuario;
import model.dao.AnuncioProdutoDAO;
import model.dao.Filtros;
import model.dao.RequisitoDAO;
import model.dao.UsuarioDAO;
import utilitarios.ImageEncoder;
import utilitarios.TextFormatter;

/**
 *
 * @author user
 */
public class Principal extends javax.swing.JFrame {

    UsuarioDAO uDAO = new UsuarioDAO();
    AnuncioProdutoDAO apDAO = new AnuncioProdutoDAO();
    RequisitoDAO rDAO = new RequisitoDAO();
    AnuncioProduto ap = new AnuncioProduto();
    Usuario u = new Usuario();
    Requisito r = new Requisito();
    Filtros f = new Filtros();
    TextFormatter tf = new TextFormatter();
    ImageEncoder ie = new ImageEncoder();
    List<AnuncioProduto> apList = new ArrayList();
    List<AnuncioProduto> apListMeusProdutos = new ArrayList();
    List<Requisito> apListMeusRequisitos = new ArrayList();
    boolean join = false;
    boolean controleTipoAnuncio = true;
    boolean controleCategoriaAnuncio = true;

    private DefaultListModel lista = new DefaultListModel();

    public Principal() {
        initComponents();

    }

    public void enviaPalavra(Login login, String email) throws SQLException {
        //recebendo os dados da outra janela

        uDAO.constroiUser(u, email);
        ap.setCodUsuario(u.getCodUsuario());
        preenchertabelaMeusAnuncios();
    }

    public void montaLista() {
        jListFiltros.removeAll();
        lista.removeAllElements();
        String[] filtros = f.getFiltrosMostrar();
        for (int i = 0; i < filtros.length; i++) {
            lista.addElement(filtros[i]);

        }
        jListFiltros.setModel(lista);

    }

    public void preenchertabelaMeusAnuncios() throws SQLException {
        apListMeusProdutos = apDAO.buscarAnuncios("", "", u, "MEUS");
        DefaultTableModel modelo = (DefaultTableModel) jTableMeusProdutos.getModel();
        modelo.setNumRows(0);
        for (AnuncioProduto ap : apListMeusProdutos) {
            modelo.addRow(new Object[]{
                ap.getCodAnuncio(),
                ap.getTitulo(),
                ap.getConsole(),
                ap.getValor()
            });
        }

    }

    public void preenchertabelaRequisitos() throws SQLException {
        apListMeusRequisitos = rDAO.listarRequisitos(ap);
        DefaultTableModel modelo = (DefaultTableModel) jTableRequisitos.getModel();
        modelo.setNumRows(0);
        for (Requisito re : apListMeusRequisitos) {
            modelo.addRow(new Object[]{
                re.getInteresseEm()
            });
        }

    }

    public void limparCampoCadastroAnuncio() {
        jTextFieldTitulo.setText("");
        jTextFieldConsoleCadastro.setText("");
        jTextFieldValor.setText("");
        jComboBoxCategoria.setSelectedIndex(0);
        jComboBoxTipoTransacao.setSelectedIndex(0);
        jLabelFoto.setIcon(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Abas = new javax.swing.JTabbedPane();
        abaPesquisa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxFiltroCategoria = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldBusca = new javax.swing.JTextField();
        jTextFieldConsoleFiltro = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jButtonAdicionarFiltroConsole = new javax.swing.JButton();
        jButtonFiltroCategoria = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListFiltros = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        jComboBoxTipoTransacaoFiltro = new javax.swing.JComboBox<>();
        jButtonAdicionarFiltroTransacao = new javax.swing.JButton();
        jButtonFiltroInteresse = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableBusca = new javax.swing.JTable();
        jButtonRemoveFiltros = new javax.swing.JButton();
        jButtonVerAnuncio = new javax.swing.JButton();
        abaAnunciar = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabelConsole = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabelValor = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jTextFieldValor = new javax.swing.JTextField();
        jButtoncadastrarAnuncio = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jButtonAlterar = new javax.swing.JButton();
        jButtonEncerrar = new javax.swing.JButton();
        jButtonFoto = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTableMeusProdutos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButtonAdicionarRequisito = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTableRequisitos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jButtonRemoveRequisito = new javax.swing.JButton();
        jTextFieldInteresse = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldConsoleCadastro = new javax.swing.JTextField();
        jComboBoxTipoTransacao = new javax.swing.JComboBox<>();
        jButtonLimpar = new javax.swing.JButton();
        jLabelFoto = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        jButtonVerMeuAnuncio = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Abas.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        abaPesquisa.setPreferredSize(new java.awt.Dimension(1000, 600));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Título específico");

        jComboBoxFiltroCategoria.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBoxFiltroCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JOGO", "CONSOLE", "ACESSORIO" }));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Categoria");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("Console");

        jTextFieldBusca.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jTextFieldConsoleFiltro.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jButtonBuscar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonAdicionarFiltroConsole.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonAdicionarFiltroConsole.setText("Adicionar");
        jButtonAdicionarFiltroConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarFiltroConsoleActionPerformed(evt);
            }
        });

        jButtonFiltroCategoria.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonFiltroCategoria.setText("Adicionar");
        jButtonFiltroCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltroCategoriaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setText("Filtros");

        jListFiltros.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(jListFiltros);

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setText("Tipo Transação");

        jComboBoxTipoTransacaoFiltro.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBoxTipoTransacaoFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VENDA", "TROCA", "DOACAO" }));

        jButtonAdicionarFiltroTransacao.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonAdicionarFiltroTransacao.setText("Adicionar");
        jButtonAdicionarFiltroTransacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarFiltroTransacaoActionPerformed(evt);
            }
        });

        jButtonFiltroInteresse.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonFiltroInteresse.setText("Aceitando o Jogo:");
        jButtonFiltroInteresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltroInteresseActionPerformed(evt);
            }
        });

        jTableBusca.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Anuncio", "Título", "Console", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableBusca.setToolTipText("");
        jTableBusca.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableBusca.getTableHeader().setResizingAllowed(false);
        jTableBusca.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(jTableBusca);

        jButtonRemoveFiltros.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonRemoveFiltros.setText("Remover Filtros");
        jButtonRemoveFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveFiltrosActionPerformed(evt);
            }
        });

        jButtonVerAnuncio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonVerAnuncio.setText("Ver Anuncio");
        jButtonVerAnuncio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerAnuncioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout abaPesquisaLayout = new javax.swing.GroupLayout(abaPesquisa);
        abaPesquisa.setLayout(abaPesquisaLayout);
        abaPesquisaLayout.setHorizontalGroup(
            abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaPesquisaLayout.createSequentialGroup()
                        .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaPesquisaLayout.createSequentialGroup()
                                .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(abaPesquisaLayout.createSequentialGroup()
                                        .addGap(451, 451, 451)
                                        .addComponent(jButtonBuscar))
                                    .addComponent(jLabel1)
                                    .addGroup(abaPesquisaLayout.createSequentialGroup()
                                        .addGap(180, 180, 180)
                                        .addComponent(jLabel4))
                                    .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaPesquisaLayout.createSequentialGroup()
                                .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(abaPesquisaLayout.createSequentialGroup()
                                        .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxFiltroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(abaPesquisaLayout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(21, 21, 21)
                                                .addComponent(jTextFieldConsoleFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jButtonAdicionarFiltroConsole))
                                        .addGap(18, 18, 18)
                                        .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxTipoTransacaoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonAdicionarFiltroTransacao)
                                            .addComponent(jLabel9)))
                                    .addComponent(jButtonFiltroCategoria))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaPesquisaLayout.createSequentialGroup()
                        .addComponent(jButtonVerAnuncio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRemoveFiltros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonFiltroInteresse)))
                .addContainerGap())
        );
        abaPesquisaLayout.setVerticalGroup(
            abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(abaPesquisaLayout.createSequentialGroup()
                        .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel3))
                        .addGap(7, 7, 7)
                        .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxFiltroCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxTipoTransacaoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldConsoleFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(36, 36, 36)
                        .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdicionarFiltroConsole)
                            .addComponent(jButtonAdicionarFiltroTransacao)
                            .addComponent(jButtonFiltroCategoria)))
                    .addComponent(jScrollPane2))
                .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaPesquisaLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(abaPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonFiltroInteresse)
                            .addComponent(jButtonRemoveFiltros))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaPesquisaLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVerAnuncio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        Abas.addTab("Pesquisar", abaPesquisa);

        jLabel36.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel36.setText("Título");

        jLabelConsole.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelConsole.setText("Console");

        jLabel38.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel38.setText("Tipo de Transação");

        jLabelValor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelValor.setText("Valor");

        jLabel40.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel40.setText("Anunciar");

        jTextFieldValor.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jTextFieldValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldValorKeyTyped(evt);
            }
        });

        jButtoncadastrarAnuncio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtoncadastrarAnuncio.setText("Anunciar");
        jButtoncadastrarAnuncio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncadastrarAnuncioActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel41.setText("Produtos Anunciados");

        jButtonAlterar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonAlterar.setText("ALTERAR");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonEncerrar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonEncerrar.setText("ENCERRAR");
        jButtonEncerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncerrarActionPerformed(evt);
            }
        });

        jButtonFoto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonFoto.setText("Adicionar Foto");
        jButtonFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFotoActionPerformed(evt);
            }
        });

        jTableMeusProdutos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableMeusProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "codigo anuncio", "Título", "Console", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTableMeusProdutos);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jButtonAdicionarRequisito.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonAdicionarRequisito.setText("Adicionar como Requisito");
        jButtonAdicionarRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarRequisitoActionPerformed(evt);
            }
        });

        jTableRequisitos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTableRequisitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Interesse em:"
            }
        ));
        jScrollPane10.setViewportView(jTableRequisitos);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Requisitos");

        jButtonRemoveRequisito.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonRemoveRequisito.setText("Remover Requisito");
        jButtonRemoveRequisito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveRequisitoActionPerformed(evt);
            }
        });

        jTextFieldInteresse.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel11.setText("Interesse em (Requisitos)");

        jTextFieldConsoleCadastro.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jComboBoxTipoTransacao.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBoxTipoTransacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VENDA", "TROCA", "DOACAO" }));
        jComboBoxTipoTransacao.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoTransacaoItemStateChanged(evt);
            }
        });

        jButtonLimpar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonLimpar.setText("Limpar campos anúncio");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jLabelFoto.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFoto.setText("FOTO");
        jLabelFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jComboBoxCategoria.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JOGO", "CONSOLE", "ACESSORIO" }));
        jComboBoxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCategoriaItemStateChanged(evt);
            }
        });

        jLabel39.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel39.setText("Categoria");

        jButtonVerMeuAnuncio.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButtonVerMeuAnuncio.setText("Ver Anúncio");
        jButtonVerMeuAnuncio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerMeuAnuncioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout abaAnunciarLayout = new javax.swing.GroupLayout(abaAnunciar);
        abaAnunciar.setLayout(abaAnunciarLayout);
        abaAnunciarLayout.setHorizontalGroup(
            abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaAnunciarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonVerMeuAnuncio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonEncerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jButtonLimpar)
                .addContainerGap(452, Short.MAX_VALUE))
            .addComponent(jScrollPane8)
            .addGroup(abaAnunciarLayout.createSequentialGroup()
                .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaAnunciarLayout.createSequentialGroup()
                        .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(abaAnunciarLayout.createSequentialGroup()
                                    .addGap(193, 193, 193)
                                    .addComponent(jLabel38)
                                    .addGap(317, 317, 317))
                                .addGroup(abaAnunciarLayout.createSequentialGroup()
                                    .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(abaAnunciarLayout.createSequentialGroup()
                                            .addComponent(jTextFieldTitulo)
                                            .addGap(31, 31, 31))
                                        .addGroup(abaAnunciarLayout.createSequentialGroup()
                                            .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel36)
                                                .addComponent(jLabel40))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(162, 162, 162)))
                            .addGroup(abaAnunciarLayout.createSequentialGroup()
                                .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(abaAnunciarLayout.createSequentialGroup()
                                        .addComponent(jLabelConsole)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldConsoleCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(abaAnunciarLayout.createSequentialGroup()
                                        .addComponent(jLabelValor)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jComboBoxTipoTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtoncadastrarAnuncio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(172, 172, 172)))
                        .addComponent(jLabel2))
                    .addComponent(jLabel11)
                    .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldInteresse, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, abaAnunciarLayout.createSequentialGroup()
                            .addComponent(jButtonAdicionarRequisito)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButtonRemoveRequisito)))
                    .addGroup(abaAnunciarLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel41)))
                .addGap(18, 18, 18)
                .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );
        abaAnunciarLayout.setVerticalGroup(
            abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaAnunciarLayout.createSequentialGroup()
                .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaAnunciarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(abaAnunciarLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelConsole)
                                    .addComponent(jTextFieldConsoleCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addGap(5, 5, 5))
                            .addGroup(abaAnunciarLayout.createSequentialGroup()
                                .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(abaAnunciarLayout.createSequentialGroup()
                                        .addComponent(jLabel40)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel36)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(abaAnunciarLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel39)
                                            .addComponent(jLabel38))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxTipoTransacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtonFoto))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(abaAnunciarLayout.createSequentialGroup()
                                        .addGap(65, 65, 65)
                                        .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelValor)
                                            .addComponent(jTextFieldValor, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButtoncadastrarAnuncio))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)))))
                        .addComponent(jTextFieldInteresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAdicionarRequisito)
                            .addComponent(jButtonRemoveRequisito))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel41))
                    .addGroup(abaAnunciarLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(abaAnunciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonEncerrar)
                    .addComponent(jButtonLimpar)
                    .addComponent(jButtonVerMeuAnuncio))
                .addContainerGap())
        );

        Abas.addTab("Meus Produtos", abaAnunciar);

        jTable2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(jTable2);

        jLabel42.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel42.setText("Produtos que tenho interesse");

        jTable4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane9.setViewportView(jTable4);

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel15.setText("Meus produtos com interesses");

        jButton6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton6.setText("ABRIR");

        jButton7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton7.setText("REMOVER");

        jButton10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton10.setText("Atualizar Página");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42)
                            .addComponent(jLabel15))
                        .addGap(386, 801, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton10)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10)
                .addContainerGap())
        );

        Abas.addTab("Interesses", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1028, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        Abas.addTab("Alterar Dados", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1028, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );

        Abas.addTab("Estatisticas", jPanel3);

        jMenu4.setText("Sobre nós");

        jMenuItem3.setText("Equipe");
        jMenu4.add(jMenuItem3);

        jMenuBar2.add(jMenu4);

        jMenu1.setText("Help");

        jMenuItem4.setText("Como Usar");
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Notas de Atualização");
        jMenu1.add(jMenuItem5);

        jMenuBar2.add(jMenu1);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Abas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Abas, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVerAnuncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerAnuncioActionPerformed
        int selectedRowIndex = jTableBusca.getSelectedRow();

        ap = apList.get(selectedRowIndex);
        Produto p = new Produto();
        p.setLocationRelativeTo(null);
        p.setVisible(true);
        p.setResizable(false);
        p.enviaPalavra2(this, ap.getCodAnuncio(), u.getCodUsuario());

    }//GEN-LAST:event_jButtonVerAnuncioActionPerformed

    private void jButtonRemoveFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveFiltrosActionPerformed
        f.limpa();
        montaLista();
        join = false;
    }//GEN-LAST:event_jButtonRemoveFiltrosActionPerformed

    private void jButtonFiltroInteresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltroInteresseActionPerformed

        String requisito = JOptionPane.showInputDialog(null, "Digite o nome do jogo que você tem e veja anuncios de pessoas que estão aceitando esse jogo:");
        f.filtroRequisito(requisito);
        montaLista();
        join = true;
    }//GEN-LAST:event_jButtonFiltroInteresseActionPerformed

    private void jButtonAdicionarFiltroTransacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarFiltroTransacaoActionPerformed
        f.filtroValor((String) jComboBoxTipoTransacaoFiltro.getSelectedItem());
        montaLista();
    }//GEN-LAST:event_jButtonAdicionarFiltroTransacaoActionPerformed

    private void jButtonFiltroCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltroCategoriaActionPerformed
        f.filtroCategoria((String) jComboBoxFiltroCategoria.getSelectedItem());
        montaLista();

    }//GEN-LAST:event_jButtonFiltroCategoriaActionPerformed

    private void jButtonAdicionarFiltroConsoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarFiltroConsoleActionPerformed

        f.filtroConsole(jTextFieldConsoleFiltro.getText());
        montaLista();
    }//GEN-LAST:event_jButtonAdicionarFiltroConsoleActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        if (tf.verificaEspacosEmbranco(jTextFieldBusca.getText())) {
            f.filtroTitulo(jTextFieldBusca.getText().toUpperCase());

        } else {
            f.removerFiltro(0);
        }

        DefaultTableModel modelo = (DefaultTableModel) jTableBusca.getModel();
        modelo.setNumRows(0);

        try {
            if (!join) {
                apList = apDAO.buscarAnuncios(f.filtrosParaString(), "", u, "OUTROS");
            } else {
                apList = apDAO.buscarAnuncios(f.filtrosParaString(), f.joinRequisito(), u, "OUTROS");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (apList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "A busca não retornou nenhum resultado");
        }
        for (AnuncioProduto ap : apList) {
            modelo.addRow(new Object[]{
                ap.getCodAnuncio(),
                ap.getTitulo(),
                ap.getConsole(),
                ap.getValor()
            });
        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jComboBoxTipoTransacaoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoTransacaoItemStateChanged
        String valor = (String) jComboBoxTipoTransacao.getSelectedItem();
        if (valor.equals("VENDA")) {
            controleTipoAnuncio = true;
            jLabelValor.setVisible(true);
            jTextFieldValor.setVisible(true);
        } else {
            controleTipoAnuncio = false;
            jLabelValor.setVisible(false);
            jTextFieldValor.setVisible(false);
        }
    }//GEN-LAST:event_jComboBoxTipoTransacaoItemStateChanged

    private void jButtonFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFotoActionPerformed

        ap.setFoto(ie.lerImagem());
        try {
            jLabelFoto.setIcon(ie.ConverterImagemAnuncio(ap));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonFotoActionPerformed

    private void jButtoncadastrarAnuncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncadastrarAnuncioActionPerformed
        String valor = (String) jComboBoxTipoTransacao.getSelectedItem();
        ap.setCodUsuario(u.getCodUsuario());
        if (tf.verificaEspacosEmbranco(jTextFieldTitulo.getText())) {
            ap.setConsole(jTextFieldConsoleCadastro.getText().toUpperCase());
            ap.setTitulo(jTextFieldTitulo.getText().toUpperCase());
            ap.setTipo((String) jComboBoxCategoria.getSelectedItem());
            switch (valor) {
                case "VENDA":
                    if (tf.verificaEspacosEmbranco(jTextFieldValor.getText())) {
                        ap.setValor(jTextFieldValor.getText());
                        apDAO.cadastraAnuncio(ap);
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo Valor vazio");
                    }
                    break;
                case "TROCA":
                    ap.setValor("TROCA");
                    apDAO.cadastraAnuncio(ap);
                    break;
                case "DOACAO":
                    ap.setValor("DOACAO");
                    apDAO.cadastraAnuncio(ap);
                    break;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }
        try {
            preenchertabelaMeusAnuncios();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        limparCampoCadastroAnuncio();
    }//GEN-LAST:event_jButtoncadastrarAnuncioActionPerformed

    private void jComboBoxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaItemStateChanged

        String valor = (String) jComboBoxCategoria.getSelectedItem();
        if (valor.equals("JOGO")) {
            controleCategoriaAnuncio = true;
            jLabelConsole.setVisible(true);
            jTextFieldConsoleCadastro.setVisible(true);
        } else {
            controleCategoriaAnuncio = false;
            jLabelConsole.setVisible(false);
            jTextFieldConsoleCadastro.setVisible(false);
        }

    }//GEN-LAST:event_jComboBoxCategoriaItemStateChanged

    private void jTextFieldValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldValorKeyTyped
        String caracteres = "0987654321.";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldValorKeyTyped

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        try {
            ap.setCodAnuncio(0);
            preenchertabelaRequisitos();
            limparCampoCadastroAnuncio();
            preenchertabelaMeusAnuncios();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonEncerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncerrarActionPerformed
        try {
            // TODO add your handling code here:
            int selectedRowIndex = jTableMeusProdutos.getSelectedRow();
            ap.setCodUsuario(u.getCodUsuario());
            ap = apListMeusProdutos.get(selectedRowIndex);
            try {
                apDAO.mudarStatusParaVendido(ap);
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            preenchertabelaMeusAnuncios();
            limparCampoCadastroAnuncio();
            ap.setCodAnuncio(0);
            preenchertabelaRequisitos();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEncerrarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed

        int selectedRowIndex = jTableMeusProdutos.getSelectedRow();
        ap.setCodUsuario(u.getCodUsuario());
        ap = apListMeusProdutos.get(selectedRowIndex);
        String valor = (String) jComboBoxTipoTransacao.getSelectedItem();
        if (tf.verificaEspacosEmbranco(jTextFieldTitulo.getText())) {
            ap.setConsole(jTextFieldConsoleCadastro.getText().toUpperCase());
            ap.setTitulo(jTextFieldTitulo.getText().toUpperCase());
            ap.setTipo((String) jComboBoxCategoria.getSelectedItem());
            switch (valor) {
                case "VENDA":
                    if (tf.verificaEspacosEmbranco(jTextFieldValor.getText())) {
                        ap.setValor(jTextFieldValor.getText());
                        try {
                            apDAO.alterarAnuncio(ap);
                        } catch (SQLException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Campo Valor vazio");
                    }
                    break;
                case "TROCA":
                    ap.setValor("TROCA");
                     {
                        try {
                            apDAO.alterarAnuncio(ap);
                        } catch (SQLException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "DOACAO":
                    ap.setValor("DOACAO");
                     {
                        try {
                            apDAO.alterarAnuncio(ap);
                        } catch (SQLException ex) {
                            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
            }

            try {
                apDAO.alterarAnuncio(ap);
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }

        limparCampoCadastroAnuncio();
        try {
            ap.setCodAnuncio(0);
            preenchertabelaMeusAnuncios();
            preenchertabelaRequisitos();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonAdicionarRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarRequisitoActionPerformed
        int selectedRowIndex = jTableMeusProdutos.getSelectedRow();
        ap = apListMeusProdutos.get(selectedRowIndex);

        if (tf.verificaEspacosEmbranco(jTextFieldInteresse.getText())) {
            r.setInteresseEm(jTextFieldInteresse.getText().toUpperCase());
            rDAO.adicionarRequisito(r, ap);
            try {
                preenchertabelaRequisitos();
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo Vazio");
        }
        
    }//GEN-LAST:event_jButtonAdicionarRequisitoActionPerformed

    private void jButtonRemoveRequisitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveRequisitoActionPerformed
       int selectedRowIndex = jTableRequisitos.getSelectedRow();
       r=apListMeusRequisitos.get(selectedRowIndex);
        try {
            rDAO.apagarRequisito(r);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            preenchertabelaRequisitos();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonRemoveRequisitoActionPerformed

    private void jButtonVerMeuAnuncioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerMeuAnuncioActionPerformed
         int selectedRowIndex = jTableMeusProdutos.getSelectedRow();
        ap.setCodUsuario(u.getCodUsuario());
        ap = apListMeusProdutos.get(selectedRowIndex);
        apDAO.constroiAnuncio(ap, ap.getCodAnuncio());
        if (ap.getTipo().equals("JOGO")) {
            jTextFieldConsoleCadastro.setText(ap.getConsole());
            jComboBoxCategoria.setSelectedIndex(0);

        } else if (ap.getTipo().equals("CONSOLE")) {
            jComboBoxCategoria.setSelectedIndex(1);
        } else {
            jComboBoxCategoria.setSelectedIndex(2);
        }
        if (ap.getValor().equals("VENDA")) {
            jTextFieldValor.setText(ap.getValor());
            jComboBoxTipoTransacao.setSelectedIndex(0);

        } else if (ap.getValor().equals("TROCA")) {
            jComboBoxTipoTransacao.setSelectedIndex(1);
        } else {
            jComboBoxTipoTransacao.setSelectedIndex(2);
        }

        jTextFieldTitulo.setText(ap.getTitulo());
        try {
            jLabelFoto.setIcon(ie.ConverterImagemAnuncio(ap));
            preenchertabelaRequisitos();
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonVerMeuAnuncioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane Abas;
    private javax.swing.JPanel abaAnunciar;
    private javax.swing.JPanel abaPesquisa;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButtonAdicionarFiltroConsole;
    private javax.swing.JButton jButtonAdicionarFiltroTransacao;
    private javax.swing.JButton jButtonAdicionarRequisito;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEncerrar;
    private javax.swing.JButton jButtonFiltroCategoria;
    private javax.swing.JButton jButtonFiltroInteresse;
    private javax.swing.JButton jButtonFoto;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonRemoveFiltros;
    private javax.swing.JButton jButtonRemoveRequisito;
    private javax.swing.JButton jButtonVerAnuncio;
    private javax.swing.JButton jButtonVerMeuAnuncio;
    private javax.swing.JButton jButtoncadastrarAnuncio;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JComboBox<String> jComboBoxFiltroCategoria;
    private javax.swing.JComboBox<String> jComboBoxTipoTransacao;
    private javax.swing.JComboBox<String> jComboBoxTipoTransacaoFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelConsole;
    private javax.swing.JLabel jLabelFoto;
    private javax.swing.JLabel jLabelValor;
    private javax.swing.JList<String> jListFiltros;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTableBusca;
    private javax.swing.JTable jTableMeusProdutos;
    private javax.swing.JTable jTableRequisitos;
    private javax.swing.JTextField jTextFieldBusca;
    private javax.swing.JTextField jTextFieldConsoleCadastro;
    private javax.swing.JTextField jTextFieldConsoleFiltro;
    private javax.swing.JTextField jTextFieldInteresse;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JTextField jTextFieldValor;
    // End of variables declaration//GEN-END:variables
}
