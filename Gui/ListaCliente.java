/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RelatorioMovimentacao.java
 *
 * Created on 28/11/2011, 19:42:10
 */
package Gui;

import ClassesBasicas.Cliente;
import ClassesBasicas.Movimentacao;
import Fachada.Fachada;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Danillo
 */
public class ListaCliente extends javax.swing.JFrame {

    Fachada fachada;
    ArrayList<Cliente> listaCliente;

    /** Creates new form RelatorioMovimentacao */
    public ListaCliente() {


        initComponents();
        listarCliente();

    }

    private void listarCliente() {
        DefaultTableModel modelo = (DefaultTableModel) Tabela_Cliente.getModel();
        modelo.setNumRows(0);
        try {

            listaCliente = Fachada.obterInstancia().ListarCliente();
            for (int i = 0; i < listaCliente.size(); i++) {
                modelo.addRow(new Object[]{
                            listaCliente.get(i).getCpf(),
                            listaCliente.get(i).getNome(),
                            listaCliente.get(i).getEndereco(),
                            listaCliente.get(i).getNumero(),
                            listaCliente.get(i).getComplemento(),
                            listaCliente.get(i).getBairro(),
                            listaCliente.get(i).getCidade(),
                            listaCliente.get(i).getTelefone()});
            }
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao listar: " + erro);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabela_Cliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24));
        jLabel1.setText("Clientes Cadastrados");

        jButton1.setText("Fechar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Tabela_Cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CPF", "NOME", "ENDEREÇO", "NUMERO", "COMPLEMENTO", "BAIRRO", "CIDADE", "TELEFONE"
            }
        ));
        Tabela_Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Tabela_ClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabela_Cliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(jLabel1)
                .addContainerGap(293, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(380, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(378, 378, 378))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 803, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Tabela_ClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Tabela_ClienteMouseClicked
        Cliente cliente = new Cliente();
        cliente.setCpf(listaCliente.get(Tabela_Cliente.getSelectedRow()).getCpf());
        AlterarCliente alterar = new AlterarCliente(cliente);
        alterar.show();// TODO add your handling code here:
    }//GEN-LAST:event_Tabela_ClienteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {




        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ListaCliente().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela_Cliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
