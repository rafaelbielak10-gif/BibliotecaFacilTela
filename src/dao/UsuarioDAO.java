package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean validar(String usuario, String senha) {

        String sql =
        "SELECT * FROM usuarios WHERE usuario=? AND senha=?";

        try {

            Connection con = Conexao.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario);

            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            boolean encontrou = rs.next();

            rs.close();
            ps.close();
            con.close();

            return encontrou;

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return false;

    }

}