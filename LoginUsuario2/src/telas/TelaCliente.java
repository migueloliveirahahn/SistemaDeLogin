package telas;

import java.sql.*;
import dal.Mod_conexao;
import javax.swing.JOptionPane;

public class TelaCliente extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public TelaCliente() {
        initComponents();
        conexao = Mod_conexao.conector();
    }

    // métodos e consulta
    
    private void consultar() {
        String sql = "SELECT * FROM tb_clientes WHERE idCliente = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtIdCliente.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtNomeCliente.setText(rs.getString("nomeCliente"));
                txtEndeCliente.setText(rs.getString("enderecoCliente"));
             seleCidade.setSelectedItem(rs.getString("cidadeCliente"));
                textoUF.setText(rs.getString("ufCliente"));
       pst.setString(3, seleCidade.getSelectedItem().toString());
                telefoneTEXTO.setText(rs.getString("telefoneTEXTO"));
                txtDatNascCliente.setText(rs.getString("datNascCliente"));
            } else {
                
                JOptionPane.showMessageDialog(null, "cadastro não realizado;");
                
                // Limpa os campos
                txtNomeCliente.setText(null);
                txtEndeCliente.setText(null);
               seleCidade.setSelectedItem(null);
                textoUF.setText(null);
pst.setString(3, seleCidade.getSelectedItem().toString());
                telefoneTEXTO.setText(null);
                txtDatNascCliente.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // ADICIONAR
   private void adicionar() {
    String sql = "INSERT INTO tb_clientes "
            + "(nomeCliente, enderecoCliente, cidadeCliente, ufCliente, cpfCliente, telefoneCliente, datNascCliente) "
            + "VALUES (?,?,?,?,?,?,?)";
    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, txtNomeCliente.getText());
        pst.setString(2, txtEndeCliente.getText());
        pst.setString(3, seleCidade.getSelectedItem().toString());
        pst.setString(4, textoUF.getText());
        pst.setString(5, CPFCNJPtext.getText());          // ? CPF/CNPJ (parâmetro 5)
        pst.setString(6, telefoneTEXTO.getText());
        pst.setString(7, txtDatNascCliente.getText());

        int adicionado = pst.executeUpdate();
        if (adicionado > 0) {
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
            // Limpa o formulário
            txtNomeCliente.setText(null);
            txtEndeCliente.setText(null);
            seleCidade.setSelectedItem(null);
            textoUF.setText(null);
            CPFCNJPtext.setText(null);                    // limpa o documento também
            telefoneTEXTO.setText(null);
            txtDatNascCliente.setText(null);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao adicionar cliente: " + e.getMessage());
    }
}
    // ALTERAR
    private void alterar() {
        String sql = "UPDATE tb_clientes SET nomeCliente = ?, enderecoCliente = ?, "
                + "cidadeCliente = ?, ufCliente = ?, cpfCliente = ?, telefoneCliente = ?, "
                + "datNascCliente = ? WHERE idCliente = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeCliente.getText());
            pst.setString(2, txtEndeCliente.getText());
            pst.setString(3, seleCidade.getSelectedItem().toString());
            pst.setString(4, textoUF.getText());
pst.setString(3, seleCidade.getSelectedItem().toString());
            pst.setString(6, telefoneTEXTO.getText());
            pst.setString(7, txtDatNascCliente.getText());
            pst.setString(8, txtIdCliente.getText());

            int alterado = pst.executeUpdate();

            if (alterado > 0) {
                JOptionPane.showMessageDialog(null, "cliente alterado.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar cliente: " + e.getMessage());
        }
    }

                          //DELETE
    
    private void apagar() {
        int confirma = JOptionPane.showConfirmDialog(null,
                
                "Tem certeza que quer concluir essa ação?", "ATENÇÃO",
                
                JOptionPane.YES_NO_OPTION);
        if (confirma == JOptionPane.YES_OPTION) {
            String sql = 
                    "DELETE FROM tb_clientes WHERE idCliente = ?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtIdCliente.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0) {
                    JOptionPane.showMessageDialog(null, 
                            "cliente apagado");
                    
                    // Limpa o form
                    
                    txtNomeCliente.setText(null);
                    txtEndeCliente.setText(null);
                  seleCidade.setSelectedItem(null);
                    textoUF.setText(null);
                pst.setString(3, seleCidade.getSelectedItem().toString());
                    telefoneTEXTO.setText(null);
                    txtDatNascCliente.setText(null);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel11 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtNomeCliente = new javax.swing.JTextField();
        txtEndeCliente = new javax.swing.JTextField();
        textoUF = new javax.swing.JTextField();
        telefoneTEXTO = new javax.swing.JTextField();
        txtDatNascCliente = new javax.swing.JTextField();
        butaoADDicionar = new javax.swing.JButton();
        butaoEDIT = new javax.swing.JButton();
        botaoVIsualizar = new javax.swing.JButton();
        butaoDELETe = new javax.swing.JButton();
        seleCidade = new javax.swing.JComboBox<>();
        RB = new javax.swing.JRadioButton();
        rbCPF = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        CPFCNJPtext = new javax.swing.JTextField();

        jLabel10.setText("jLabel10");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jLabel11.setText("jLabel11");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel1.setText("Cadastro clientes");

        jLabel2.setText("ID:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Endereço:");

        jLabel5.setText("Cidade");

        jLabel6.setText("UF:");

        jLabel8.setText("Telefone:");

        jLabel9.setText("Data de nascimento:");

        txtIdCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdClienteActionPerformed(evt);
            }
        });

        txtNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeClienteActionPerformed(evt);
            }
        });

        txtEndeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEndeClienteActionPerformed(evt);
            }
        });

        textoUF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoUFActionPerformed(evt);
            }
        });

        telefoneTEXTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneTEXTOActionPerformed(evt);
            }
        });

        txtDatNascCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatNascClienteActionPerformed(evt);
            }
        });

        butaoADDicionar.setText("Adicionar");
        butaoADDicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoADDicionarActionPerformed(evt);
            }
        });

        butaoEDIT.setText("Editar");
        butaoEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoEDITActionPerformed(evt);
            }
        });

        botaoVIsualizar.setText("Visualizar");
        botaoVIsualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVIsualizarActionPerformed(evt);
            }
        });

        butaoDELETe.setText("Apagar");
        butaoDELETe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoDELETeActionPerformed(evt);
            }
        });

        seleCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a cidade", "Taquara", "Parobé", "Igrejinha", "Três Coroas", "Gramado", "Canela" }));
        seleCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleCidadeActionPerformed(evt);
            }
        });

        buttonGroup1.add(RB);
        RB.setText("CNPJ");
        RB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCPF);
        rbCPF.setText("CPF");
        rbCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCPFActionPerformed(evt);
            }
        });

        jLabel7.setText("CPF/CNPJ:");

        CPFCNJPtext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CPFCNJPtextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(telefoneTEXTO, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RB)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CPFCNJPtext, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(seleCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textoUF, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtEndeCliente))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbCPF))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDatNascCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(butaoADDicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVIsualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butaoEDIT, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butaoDELETe, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(CPFCNJPtext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(seleCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(telefoneTEXTO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RB))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(rbCPF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtEndeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textoUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtDatNascCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butaoADDicionar)
                    .addComponent(botaoVIsualizar)
                    .addComponent(butaoEDIT)
                    .addComponent(butaoDELETe))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void telefoneTEXTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneTEXTOActionPerformed
 
    }//GEN-LAST:event_telefoneTEXTOActionPerformed

    private void txtIdClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdClienteActionPerformed

            consultar();
    }//GEN-LAST:event_txtIdClienteActionPerformed

    private void txtNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeClienteActionPerformed

    private void txtEndeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEndeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEndeClienteActionPerformed

    private void textoUFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoUFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoUFActionPerformed

    private void txtDatNascClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatNascClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatNascClienteActionPerformed

    private void butaoADDicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoADDicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_butaoADDicionarActionPerformed

    private void butaoEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoEDITActionPerformed
       alterar();
    }//GEN-LAST:event_butaoEDITActionPerformed

    private void botaoVIsualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVIsualizarActionPerformed
        consultar();
    }//GEN-LAST:event_botaoVIsualizarActionPerformed

    private void butaoDELETeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoDELETeActionPerformed
        apagar();
    }//GEN-LAST:event_butaoDELETeActionPerformed

    private void seleCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seleCidadeActionPerformed

    private void RBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBActionPerformed
        // TODO add your handling code here:
    
  CPFCNJPtext.setText("");
    }//GEN-LAST:event_RBActionPerformed

    private void rbCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCPFActionPerformed
        // TODO add your handling code here:

    CPFCNJPtext.setText("");
    }//GEN-LAST:event_rbCPFActionPerformed

    private void CPFCNJPtextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPFCNJPtextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPFCNJPtextActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CPFCNJPtext;
    private javax.swing.JRadioButton RB;
    private javax.swing.JButton botaoVIsualizar;
    private javax.swing.JButton butaoADDicionar;
    private javax.swing.JButton butaoDELETe;
    private javax.swing.JButton butaoEDIT;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbCPF;
    private javax.swing.JComboBox<String> seleCidade;
    private javax.swing.JTextField telefoneTEXTO;
    private javax.swing.JTextField textoUF;
    private javax.swing.JTextField txtDatNascCliente;
    private javax.swing.JTextField txtEndeCliente;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNomeCliente;
    // End of variables declaration//GEN-END:variables
}
