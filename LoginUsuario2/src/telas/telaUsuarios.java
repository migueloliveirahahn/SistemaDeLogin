package telas;

import java.sql.*;
import dal.Mod_conexao;
import javax.swing.JOptionPane;

public class telaUsuarios extends javax.swing.JInternalFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public telaUsuarios() {
        initComponents();
        conexao = Mod_conexao.conector();
    }
    
    private void consultar(){
    String sql = "SELECT * FROM tb_usuarios WHERE id=?";
    
    try {
    pst = conexao.prepareStatement(sql);
    pst.setString(1,txtId.getText());
    rs = pst.executeQuery();
    if (rs.next()) {
        txtNome.setText(rs.getString(2));
        txtEmail.setText(rs.getString(3));
        txtSenha.setText(rs.getString(4));
    } else {
        JOptionPane.showMessageDialog(null, "FALHA: usuario não cadastrado!");
//        nas linhas abaixo limpam os campos do formulario
        txtNome.setText(null);
        txtEmail.setText(null);
        txtSenha.setText(null);
    }   
    }catch (Exception e){
        JOptionPane.showConfirmDialog(null, e);
        }
    }
    
   private void adicionar(){
    String sql = "INSERT INTO tb_usuarios (nome,email,senha) VALUES (?,?,?)";
    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1 ,txtNome.getText());
        pst.setString(2 ,txtEmail.getText());
        pst.setString(3 ,txtSenha.getText());
        
        int adicionado = pst.executeUpdate(); // retorna 1 se estiver correto
        
        if (adicionado > 0) {
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado");
    
    //Exibe a mensagem
    
    //limpa o formulario
            txtNome.setText(null);
            txtEmail.setText(null);
            txtSenha.setText(null);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao adicionar usuário: " + e.getMessage());
    } finally {
    }
    
}
   
    private void alterar() {
        String sql = "UPDATE tb_usuarios SET nome = ?, email = ?, senha = ? WHERE id = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNome.getText());
            pst.setString(2, txtEmail.getText());
            pst.setString(3, txtSenha.getText());
            pst.setString(4, txtId.getText());
            int adicionado = pst.executeUpdate();
            if (adicionado > 0) {
                
                JOptionPane.showMessageDialog(null, "User alterado com sucesso");
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar usuário: " + e.getMessage());
        }
    }
    private void apagar(){
        int confirma = JOptionPane.showConfirmDialog(null, "Deseja concluir a ação?", "Atençao", JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION){
            String sql = "DELETE FROM tb_usuarios WHERE id = ?";
            try{
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtId.getText());
                int apagado = pst.executeUpdate();
                if (apagado > 0){
                    JOptionPane.showMessageDialog(null, "Usuário deletado");
               
                    //limpa o form:
                    
                    txtNome.setText(null);
                    txtEmail.setText(null);
                    txtSenha.setText(null);
                } 
                pst.executeUpdate();
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        ID = new javax.swing.JLabel();
        nome = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        senha = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        botaoADicionar = new javax.swing.JButton();
        botaoVIsualizar = new javax.swing.JButton();
        botaoDelete = new javax.swing.JButton();
        butaoEditar = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        ID.setText("ID:");

        nome.setText("Nome:");

        email.setText("Email:");

        senha.setText("Senha");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSenhaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("TELA CADASTRO");

        botaoADicionar.setText("Adicionar");
        botaoADicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoADicionarActionPerformed(evt);
            }
        });

        botaoVIsualizar.setText("Visualizar");
        botaoVIsualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVIsualizarActionPerformed(evt);
            }
        });

        botaoDelete.setText("Apagar");
        botaoDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDeleteActionPerformed(evt);
            }
        });

        butaoEditar.setText("Editar");
        butaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butaoEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email)
                            .addComponent(senha)
                            .addComponent(nome))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSenha)
                            .addComponent(txtEmail)
                            .addComponent(txtNome)
                            .addComponent(txtId)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(botaoADicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoVIsualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(butaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ID))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nome))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(senha)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(152, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoADicionar)
                            .addComponent(botaoVIsualizar)
                            .addComponent(butaoEditar)
                            .addComponent(botaoDelete))
                        .addGap(98, 98, 98))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void botaoVIsualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVIsualizarActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_botaoVIsualizarActionPerformed

    private void botaoADicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoADicionarActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_botaoADicionarActionPerformed

    private void butaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butaoEditarActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_butaoEditarActionPerformed

    private void botaoDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDeleteActionPerformed
        // TODO add your handling code here:
        apagar();
    }//GEN-LAST:event_botaoDeleteActionPerformed

    private void txtSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ID;
    private javax.swing.JButton botaoADicionar;
    private javax.swing.JButton botaoDelete;
    private javax.swing.JButton botaoVIsualizar;
    private javax.swing.JButton butaoEditar;
    private javax.swing.JLabel email;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel senha;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    // End of variables declaration//GEN-END:variables
}
