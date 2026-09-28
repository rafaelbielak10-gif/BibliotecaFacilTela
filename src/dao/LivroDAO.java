package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Livro;
import model.ItemCombo;

public class LivroDAO {

    public boolean salvar(Livro livro){

        String sql =
        "INSERT INTO livros(titulo,autor,categoria) VALUES(?,?,?)";

        try{

            Connection con = Conexao.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setString(3, livro.getCategoria());

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        }catch(SQLException e){

            System.out.println(e.getMessage());

            return false;

        }

    }

    public ArrayList<Livro> listar(){

        ArrayList<Livro> lista = new ArrayList<>();

        String sql = "SELECT * FROM livros ORDER BY titulo";

        try{

            Connection con = Conexao.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){

                Livro livro = new Livro();

                livro.setId(rs.getInt("id"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setAutor(rs.getString("autor"));
                livro.setCategoria(rs.getString("categoria"));

                lista.add(livro);

            }

            rs.close();
            ps.close();
            con.close();

        }catch(SQLException e){

            System.out.println(e.getMessage());

        }

        return lista;

    }

    public boolean alterar(Livro livro){

        String sql =
        "UPDATE livros SET titulo=?, autor=?, categoria=? WHERE id=?";

        try{

            Connection con = Conexao.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setString(3, livro.getCategoria());
            ps.setInt(4, livro.getId());

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        }catch(SQLException e){

            return false;

        }

    }

    public boolean excluir(int id){

        String sql =
        "DELETE FROM livros WHERE id=?";

        try{

            Connection con = Conexao.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1,id);

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        }catch(SQLException e){

            return false;

        }

    }

    public ArrayList<String> listarTitulos() {

    ArrayList<String> lista = new ArrayList<>();

    String sql = "SELECT titulo FROM livros ORDER BY titulo";

    try {

        Connection con = Conexao.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            lista.add(rs.getString("titulo"));

        }

        rs.close();
        ps.close();
        con.close();

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return lista;

}
    public ArrayList<ItemCombo> listarCombo() {

    ArrayList<ItemCombo> lista = new ArrayList<>();

    String sql = "SELECT id, titulo FROM livros ORDER BY titulo";

    try {

        Connection con = Conexao.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            lista.add(new ItemCombo(
                    rs.getInt("id"),
                    rs.getString("titulo")));

        }

        rs.close();
        ps.close();
        con.close();

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    }

    return lista;

}
}