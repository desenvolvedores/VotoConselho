/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import ClassReport.ReportDAO;
import Eleitor.Eleitor;
import Eleitor.EleitorDAO;
import com.nilo.plaf.nimrod.NimRODLookAndFeel;
import com.nilo.plaf.nimrod.NimRODTheme;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.MaskFormatter;

public class FormCadastroEleitor extends javax.swing.JFrame {

    private int largura = 822;
    private int altura = 285;

    public FormCadastroEleitor() {
        initComponents();

        try {

            NimRODTheme nt = new NimRODTheme("eleicao.theme");
            NimRODLookAndFeel nf = new NimRODLookAndFeel();
            nf.setCurrentTheme(nt);
            UIManager.setLookAndFeel(nf);

            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Get the size of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

        // Determine the new location of the window
        this.setSize(largura, altura);
        int w = this.getSize().width;
        int h = this.getSize().height;
        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        // Move the window
        this.setLocation(x, y);
        this.setBounds(x, y, w, h);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtPesquisaTitulo = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        javax.swing.text.MaskFormatter cpf = null;
        try {
            cpf = new javax.swing.text.MaskFormatter("###.###.###-##");
            cpf.setPlaceholderCharacter('_');}
        catch (java.text.ParseException exc) {}
        txtCpf = new javax.swing.JFormattedTextField(cpf);
        jSeparator3 = new javax.swing.JSeparator();
        btnCadastrar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnCedula2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbxSala = new javax.swing.JComboBox();
        btnCedula1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eleição do Conselho Tutelar - Caraguatatuba -SP");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel2.setText("Pesquisar Título:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 15, -1, -1));
        getContentPane().add(txtPesquisaTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 17, 247, -1));

        btnVerificar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnVerificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/procurar2.png"))); // NOI18N
        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 11, -1, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, 754, 10));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel3.setText("Nome:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 62, -1, -1));

        txtNome.setEnabled(false);
        getContentPane().add(txtNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 64, 551, -1));

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel4.setText("Título Eleitoral:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 90, -1, -1));

        txtTitulo.setEnabled(false);
        getContentPane().add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 92, 283, -1));

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel5.setText("RG:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 118, -1, -1));

        txtRg.setEnabled(false);
        getContentPane().add(txtRg, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 118, 283, -1));

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel6.setText("CPF:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 144, -1, -1));

        txtCpf.setEnabled(false);
        getContentPane().add(txtCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 144, 283, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 754, -1));

        btnCadastrar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/concluir.png"))); // NOI18N
        btnCadastrar.setText("Cadastrar Eleitor");
        btnCadastrar.setEnabled(false);
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(591, 178, -1, -1));

        btnLimpar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/novo2.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.setEnabled(false);
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 178, -1, -1));

        btnCedula2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnCedula2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/printer.png"))); // NOI18N
        btnCedula2.setText("Gerar Cédula 2");
        btnCedula2.setEnabled(false);
        btnCedula2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCedula2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCedula2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel7.setText("Sala:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(689, 62, -1, -1));

        cbxSala.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--", "01", "02", "03", "04", "05" }));
        cbxSala.setEnabled(false);
        getContentPane().add(cbxSala, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 64, -1, -1));

        btnCedula1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        btnCedula1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/printer.png"))); // NOI18N
        btnCedula1.setText("Gerar Cédula 1");
        btnCedula1.setEnabled(false);
        btnCedula1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCedula1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCedula1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, -1));

        jMenu1.setText("Encerrar");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        mnuSair.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        mnuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete1.png"))); // NOI18N
        mnuSair.setText("Sair");
        mnuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSairActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSair);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        try {

            Eleitor eleitor = new Eleitor();

            eleitor.setTitulo(txtTitulo.getText());
            eleitor.setSala(cbxSala.getSelectedItem().toString());
            eleitor.setNome(txtNome.getText().toUpperCase());

            if (eleitor.getTitulo().equals("")) {

                String mensagem = "O campo Título Eleitoral é obrigatório!";
                txtTitulo.requestFocus();
                JOptionPane.showMessageDialog(null, mensagem);

            } else {
                if (eleitor.getSala().equals("--")) {

                    String mensagem = "Selecione a Sala de Votação.";
                    cbxSala.requestFocus();
                    JOptionPane.showMessageDialog(null, mensagem);

                } else {
                    if (eleitor.getNome().equals("")) {

                        String mensagem = "O nome do Eleitor é obrigatório!";
                        cbxSala.requestFocus();
                        JOptionPane.showMessageDialog(null, mensagem);
                        
                    } else {
                        
                        eleitor.setNome(txtNome.getText().toUpperCase());
                        eleitor.setRg(txtRg.getText());
                        eleitor.setCpf(txtCpf.getText());
                        eleitor.setStatus("1");

                        EleitorDAO dao = new EleitorDAO();
                        dao.adicionaEleitor(eleitor);

                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                        btnCedula1.setEnabled(true);
                        btnCedula2.setEnabled(true);
                    }
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getLocalizedMessage());
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        Eleitor eleitor = new Eleitor();

        eleitor.setTitulo(txtPesquisaTitulo.getText());

        if (eleitor.getTitulo().equals("")) {

            JOptionPane.showMessageDialog(null, "O Nº do Título não foi informado!");

        } else {

            try {

                EleitorDAO dao = new EleitorDAO();

                //Verifica se o título já está cadastrado
                boolean validar = dao.validarTitulo(eleitor);
                if (validar == true) {

                    JOptionPane.showMessageDialog(null, "Eleitor já cadastrado!");

                    List<Eleitor> listaEleitor = dao.getListaEleitor(eleitor);

                    for (Eleitor cursor : listaEleitor) {

                        txtNome.setText(cursor.getNome());
                        cbxSala.setSelectedItem(cursor.getSala());
                        txtTitulo.setText(cursor.getTitulo());
                        txtRg.setText(cursor.getRg());
                        txtCpf.setText(cursor.getCpf());
                    }

                    btnLimpar.setEnabled(true);
                    // btnExcluir.setEnabled(true);

                } else {

                    if (validar == false) {

                        txtTitulo.setText(eleitor.getTitulo());
                        txtPesquisaTitulo.setText("");
                        limparCampos02();

                        //Bloqueio de txtField
                        txtPesquisaTitulo.setEnabled(false);
                        btnVerificar.setEnabled(false);
                        //JTextField - Desbloquear campos                       
                        
                        txtNome.setEnabled(true);
                        txtTitulo.setEnabled(true);
                        cbxSala.setEnabled(true);
                        txtRg.setEnabled(true);
                        txtCpf.setEnabled(true);
                        //JButton - Desbloquear botões
                        btnCadastrar.setEnabled(true);
                        btnLimpar.setEnabled(true);
                    }
                }

            } catch (SQLException ex) {
                Logger.getLogger(FormCadastroEleitor.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a pesquisa: " + ex.getLocalizedMessage());
            }

        }
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void mnuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSairActionPerformed
        Object[] options = {"Sim", "Não"};
        Object opc = JOptionPane.showOptionDialog(null, "Deseja fechar o sistema ?", "Eleição - Conselho Tutelar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                options, options[0]);

        if (opc.toString().equals("0")) {
            System.exit(0);
        }
    }//GEN-LAST:event_mnuSairActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        limparCampos();        
        
        //desbloquear campos
        txtPesquisaTitulo.setEnabled(true);
        btnVerificar.setEnabled(true);

        //JTextField - bloquear campos
        txtNome.setEnabled(false);
        txtTitulo.setEnabled(false);
        cbxSala.setEnabled(false);
        txtRg.setEnabled(false);
        txtCpf.setEnabled(false);
        //JButton - bloquear botões
        btnCedula1.setEnabled(false);
        btnCedula2.setEnabled(false);
        btnCadastrar.setEnabled(false);
        btnLimpar.setEnabled(true);
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnCedula2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCedula2ActionPerformed
        try {
            ReportDAO dao = new ReportDAO();

            String nome = null, sala = null;

            nome = txtNome.getText();
            sala = cbxSala.getSelectedItem().toString();

            dao.setParametro3(nome);
            dao.setParametro4(sala);

            dao.createConnection();
            dao.gerarCedulaEleitoral2();
            
            btnCadastrar.setEnabled(false);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Erro", 0);
        }
    }//GEN-LAST:event_btnCedula2ActionPerformed

    private void btnCedula1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCedula1ActionPerformed
try {
            ReportDAO dao = new ReportDAO();

            String nome = null, sala = null;

            nome = txtNome.getText();
            sala = cbxSala.getSelectedItem().toString();

            dao.setParametro1(nome);
            dao.setParametro2(sala);

            dao.createConnection();
            dao.gerarCedulaEleitoral1();
            
            btnCadastrar.setEnabled(false);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getLocalizedMessage(), "Erro", 0);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnCedula1ActionPerformed
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormCadastroEleitor().setVisible(true);
            }
        });
    }

    private void limparCampos() {
        // Limpa todos os campos para novo cadastro
        txtPesquisaTitulo.setText("");
        txtNome.setText("");
        txtTitulo.setText("");
        txtRg.setText("");
        txtCpf.setText("");
        cbxSala.setSelectedIndex(0);
    }
    
    private void limparCampos02() {
        // Limpa todos os campos para novo cadastro
        txtPesquisaTitulo.setText("");
        txtNome.setText("");
        txtRg.setText("");
        txtCpf.setText("");
        cbxSala.setSelectedIndex(0);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCedula1;
    private javax.swing.JButton btnCedula2;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JComboBox cbxSala;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JMenuItem mnuSair;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPesquisaTitulo;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
