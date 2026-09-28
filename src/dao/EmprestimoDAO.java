package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Emprestimo;

public class EmprestimoDAO {

    public boolean salvar(Emprestimo emp) {

        String sql = 
            "INSERT INTO emprestimos(idAluno,idLivro,dataEmprestimo,dataPrevista,devolvido) "
          + "VALUES (?,?,?,?,?)";

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, emp.getIdAluno());
            ps.setInt(2, emp.getIdLivro());
            ps.setDate(3, java.sql.Date.valueOf(emp.getDataEmprestimo()));
            ps.setDate(4, java.sql.Date.valueOf(emp.getDataDevolucao()));
            ps.setBoolean(5, false);

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<String[]> listar() {

        ArrayList<String[]> lista = new ArrayList<>();

        String sql =
            "SELECT e.id, a.nome, l.titulo, e.dataEmprestimo, e.dataPrevista, e.devolvido "
          + "FROM emprestimos e "
          + "INNER JOIN alunos a ON e.idAluno = a.id "
          + "INNER JOIN livros l ON e.idLivro = l.id "
          + "ORDER BY e.id";

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                String[] dados = new String[6];

                dados[0] = rs.getString("id");
                dados[1] = rs.getString("nome");
                dados[2] = rs.getString("titulo");
                dados[3] = rs.getString("dataEmprestimo");
                dados[4] = rs.getString("dataPrevista");
                dados[5] = rs.getBoolean("devolvido") ? "DEVOLVIDO" : "EMPRESTADO";

                lista.add(dados);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean devolver(int id) {

        String sql = "UPDATE emprestimos SET devolvido = true WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {

        String sql = "DELETE FROM emprestimos WHERE id = ?";

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean livroDisponivel(int idLivro) {

        String sql =
            "SELECT * FROM emprestimos "
          + "WHERE idLivro = ? AND devolvido = false";

        try (Connection con = Conexao.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idLivro);

            try (ResultSet rs = ps.executeQuery()) {
                return !rs.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean livroEmprestado(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
