package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Aluno;
import model.ItemCombo;

public class AlunoDAO {

    // Salvar aluno
    public boolean salvar(Aluno aluno) {

        String sql = "INSERT INTO alunos (nome, matricula, turma) VALUES (?, ?, ?)";

        try {

            Connection con = Conexao.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getMatricula());
            ps.setString(3, aluno.getTurma());

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao salvar aluno: " + e.getMessage());
            return false;

        }

    }

    // Listar alunos
    public ArrayList<Aluno> listar() {

        ArrayList<Aluno> lista = new ArrayList<>();

        String sql = "SELECT * FROM alunos ORDER BY nome";

        try {

            Connection con = Conexao.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Aluno aluno = new Aluno();

                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setMatricula(rs.getString("matricula"));
                aluno.setTurma(rs.getString("turma"));

                lista.add(aluno);

            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {

            System.out.println("Erro ao listar alunos: " + e.getMessage());

        }

        return lista;

    }

    // Excluir aluno
    public boolean excluir(int id) {

        String sql = "DELETE FROM alunos WHERE id=?";

        try {

            Connection con = Conexao.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao excluir aluno: " + e.getMessage());

            return false;

        }

    }

    // Alterar aluno
    public boolean alterar(Aluno aluno) {

        String sql = "UPDATE alunos SET nome=?, matricula=?, turma=? WHERE id=?";

        try {

            Connection con = Conexao.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, aluno.getNome());
            ps.setString(2, aluno.getMatricula());
            ps.setString(3, aluno.getTurma());
            ps.setInt(4, aluno.getId());

            ps.executeUpdate();

            ps.close();
            con.close();

            return true;

        } catch (SQLException e) {

            System.out.println("Erro ao alterar aluno: " + e.getMessage());

            return false;

        }

    }

    public ArrayList<String> listarNomes() {

    ArrayList<String> lista = new ArrayList<>();

    String sql = "SELECT nome FROM alunos ORDER BY nome";

    try {

        Connection con = Conexao.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            lista.add(rs.getString("nome"));

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

    String sql = "SELECT id, nome FROM alunos ORDER BY nome";

    try {

        Connection con = Conexao.getConnection();

        PreparedStatement ps = con.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            lista.add(new ItemCombo(
                    rs.getInt("id"),
                    rs.getString("nome")));

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
