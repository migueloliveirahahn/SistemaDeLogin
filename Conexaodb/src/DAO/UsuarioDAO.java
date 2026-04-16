package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class UsuarioDAO {
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void inserirUsuario(UsuarioDTO objUsuarioDTO) {
        
        String sql = "INSERT INTO tb_usuarios (id_usuario, usuario, login, senha) "
                   + "VALUES (?, ?, ?, ?)";

        conexao = new ConexaoDAO().conector();

        try {
            pst = conexao.prepareStatement(sql);
            
            pst.setInt(1, objUsuarioDTO.getId_usuario());
            pst.setString(2, objUsuarioDTO.getNome_usuario());
            pst.setString(3, objUsuarioDTO.getLogin_usuario());
            pst.setString(4, objUsuarioDTO.getSenha_usuario());

            pst.execute();
            pst.close();

            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no UsuarioDAO: " + e);
        }
    }
}
