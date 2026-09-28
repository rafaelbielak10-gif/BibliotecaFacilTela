package view;

import dao.AlunoDAO;
import dao.EmprestimoDAO;
import dao.LivroDAO;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Aluno;
import model.Emprestimo;
import model.ItemCombo;
import model.Livro;


public class TelaEmprestimo extends javax.swing.JFrame {

    private int idSelecionado = 0;

    /**
     * Creates new form Emprestimos
     */
    public TelaEmprestimo() {

    initComponents();

    setLocationRelativeTo(null);

    carregarAlunos();

    carregarLivros();

    carregarTabela();

}

private void carregarAlunos() {

    cbAluno.removeAllItems();

    cbAluno.addItem(new ItemCombo(0, "Selecione..."));

    AlunoDAO dao = new AlunoDAO();

    ArrayList<Aluno> lista = dao.listar();

    for (Aluno a : lista) {

        cbAluno.addItem(
                new ItemCombo(
                        a.getId(),
                        a.getNome()));

    }

}

private void carregarLivros() {

    cbLivro.removeAllItems();

    cbLivro.addItem(new ItemCombo(0, "Selecione..."));

    LivroDAO dao = new LivroDAO();

    ArrayList<Livro> lista = dao.listar();

    for (Livro l : lista) {

        cbLivro.addItem(
                new ItemCombo(
                        l.getId(),
                        l.getTitulo()));

    }

}

private void carregarTabela() {

    DefaultTableModel modelo =
            (DefaultTableModel) tabelaEmprestimos.getModel();

    modelo.setRowCount(0);

    EmprestimoDAO dao = new EmprestimoDAO();

    ArrayList<String[]> lista = dao.listar();

    for (String dados[] : lista) {

        modelo.addRow(dados);

    }

}

private void limparCampos() {

    idSelecionado = 0;

    carregarAlunos();
    carregarLivros();

    cbAluno.setSelectedIndex(0);
    cbLivro.setSelectedIndex(0);

    dcEmprestimo.setDate(null);
    dcPrevista.setDate(null);

}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        cbAluno = new javax.swing.JComboBox<>();
        cbLivro = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEmprestimos = new javax.swing.JTable();
        btnDevolver = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        dcEmprestimo = new com.toedter.calendar.JDateChooser();
        dcPrevista = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Biblioteca Fácil");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Sistema de Gerenciamento de Biblioteca");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Empréstimos");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Selecione um Aluno:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Selecione um Livro:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        cbAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAlunoActionPerformed(evt);
            }
        });

        jLabel1.setText("Data do Empréstimo:");

        jLabel2.setText("Data de Devolução:");

        tabelaEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Aluno", "Livro", "Empréstimo ", "Devolução ", "Status"
            }
        ));
        tabelaEmprestimos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tabelaEmprestimosAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tabelaEmprestimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaEmprestimosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaEmprestimos);

        btnDevolver.setText("Devolver");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        dcEmprestimo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                dcEmprestimoAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        dcPrevista.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                dcPrevistaAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dcEmprestimo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(cbAluno, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dcPrevista, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                                    .addComponent(cbLivro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btnSalvar)
                                .addGap(18, 18, 18)
                                .addComponent(btnDevolver)
                                .addGap(18, 18, 18)
                                .addComponent(btnExcluir)
                                .addGap(18, 18, 18)
                                .addComponent(btnLimpar)
                                .addGap(18, 18, 18)
                                .addComponent(btnVoltar)))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addComponent(dcEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnLimpar)
                    .addComponent(btnVoltar)
                    .addComponent(btnDevolver)
                    .addComponent(btnExcluir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
    try {

        ItemCombo livroSelecionado =
                (ItemCombo) cbLivro.getSelectedItem();


        EmprestimoDAO dao =
                new EmprestimoDAO();


        if(!dao.livroDisponivel(livroSelecionado.getId())){


            JOptionPane.showMessageDialog(this,
                    "Este livro já está emprestado.");

            return;

        }


        Emprestimo emp = new Emprestimo();


        ItemCombo alunoSelecionado =
                (ItemCombo) cbAluno.getSelectedItem();


        emp.setIdAluno(alunoSelecionado.getId());

        emp.setIdLivro(livroSelecionado.getId());


        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy-MM-dd");


        emp.setDataEmprestimo(
                sdf.format(dcEmprestimo.getDate())
        );


        emp.setDataDevolucao(
                sdf.format(dcPrevista.getDate())
        );


        if(dao.salvar(emp)){


            JOptionPane.showMessageDialog(this,
                    "Empréstimo realizado com sucesso!");


            carregarTabela();

            limparCampos();

        }


    } catch(Exception e){

        JOptionPane.showMessageDialog(this,
                "Preencha todos os campos.");

    }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void tabelaEmprestimosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabelaEmprestimosAncestorAdded

    }//GEN-LAST:event_tabelaEmprestimosAncestorAdded

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
        if(idSelecionado == 0){

        JOptionPane.showMessageDialog(this,
                "Selecione um empréstimo na tabela.");

        return;

    }


    int resposta = JOptionPane.showConfirmDialog(this,
            "Confirmar devolução do livro?",
            "Devolução",
            JOptionPane.YES_NO_OPTION);


    if(resposta == JOptionPane.YES_OPTION){

        EmprestimoDAO dao = new EmprestimoDAO();


        if(dao.devolver(idSelecionado)){

            JOptionPane.showMessageDialog(this,
                    "Livro devolvido com sucesso!");

            carregarTabela();

            idSelecionado = 0;

        }else{

            JOptionPane.showMessageDialog(this,
                    "Erro ao realizar devolução.");

        }

    }
    
    }//GEN-LAST:event_btnDevolverActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
       if(idSelecionado == 0){

        JOptionPane.showMessageDialog(this,
                "Selecione um empréstimo.");

        return;

    }


    int op = JOptionPane.showConfirmDialog(this,
            "Deseja excluir?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION);


    if(op == JOptionPane.YES_OPTION){

        EmprestimoDAO dao = new EmprestimoDAO();

        if(dao.excluir(idSelecionado)){

            JOptionPane.showMessageDialog(this,
                    "Registro excluído.");

            carregarTabela();

            idSelecionado = 0;

        }

    }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
    
        limparCampos();
        
    }//GEN-LAST:event_btnLimparActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void dcEmprestimoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_dcEmprestimoAncestorAdded

    }//GEN-LAST:event_dcEmprestimoAncestorAdded

    private void dcPrevistaAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_dcPrevistaAncestorAdded
   
    }//GEN-LAST:event_dcPrevistaAncestorAdded

    private void cbAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAlunoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAlunoActionPerformed

    private void tabelaEmprestimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaEmprestimosMouseClicked
                                               
    int linha = tabelaEmprestimos.getSelectedRow();

    if(linha >= 0){

        // pega o ID do empréstimo
        idSelecionado = Integer.parseInt(
                tabelaEmprestimos.getValueAt(linha, 0).toString()
        );


        // pega nome do aluno
        String aluno = tabelaEmprestimos.getValueAt(linha, 1).toString();

        // pega nome do livro
        String livro = tabelaEmprestimos.getValueAt(linha, 2).toString();


        // Selecionar aluno correto
for(int i = 0; i < cbAluno.getItemCount(); i++){

    ItemCombo item = cbAluno.getItemAt(i);

    if(item.toString().equals(aluno)){

        cbAluno.setSelectedIndex(i);
        break;
    }

}


// Selecionar livro correto
for(int i = 0; i < cbLivro.getItemCount(); i++){

    ItemCombo item = cbLivro.getItemAt(i);

    if(item.toString().equals(livro)){

        cbLivro.setSelectedIndex(i);
        break;
    }

}


        try {

            SimpleDateFormat sdf =
                    new SimpleDateFormat("yyyy-MM-dd");


            String dataEmp =
                    tabelaEmprestimos.getValueAt(linha,3).toString();


            String dataDev =
                    tabelaEmprestimos.getValueAt(linha,4).toString();


            dcEmprestimo.setDate(
                    sdf.parse(dataEmp)
            );


            dcPrevista.setDate(
                    sdf.parse(dataDev)
            );


        } catch(Exception e){

            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar datas.");

        }


        System.out.println(
                "Empréstimo selecionado: "
                + idSelecionado
        );

    }
    }//GEN-LAST:event_tabelaEmprestimosMouseClicked

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
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<ItemCombo> cbAluno;
    private javax.swing.JComboBox<ItemCombo> cbLivro;
    private com.toedter.calendar.JDateChooser dcEmprestimo;
    private com.toedter.calendar.JDateChooser dcPrevista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaEmprestimos;
    // End of variables declaration//GEN-END:variables
}
