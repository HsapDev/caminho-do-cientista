package com.caminho.cientista.dao;
import com.caminho.cientista.conexao.Conexao;

import com.caminho.cientista.model.Link;
import com.caminho.cientista.model.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriaDAO {

    public void inserir(Materia materia){
        String sqlInsert = "INSERT INTO materia (nome,descricao) VALUES (?,?)";
        try (Connection conn = Conexao.conectar()) {
            PreparedStatement ps = conn.prepareStatement(sqlInsert);

            ps.setString(1, materia.getNome());
            ps.setString(2, materia.getDescricao());
            ps.executeUpdate();
            System.out.println("Materia cadastrada");

        }
        catch (SQLException e ){
            System.out.println("Erro ao inserir" + e.getMessage());
        }
    }

    public List<Materia> listar(){
        String sql = "SELECT * FROM materia";
        List<Materia> lista = new ArrayList<>();

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()){

            while (rs.next()){
                Materia m = new Materia();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setDescricao(rs.getString("descricao"));
                lista.add(m);
            }
        }
        catch (SQLException e ){
            System.out.println("Erro: "+e.getMessage());
        }
        return lista;
    }

    public Materia buscarPorId(int id){
        String sql ="SELECT * FROM materia WHERE id = ?";

        try (Connection con = Conexao.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                Materia m = new Materia();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setDescricao(rs.getString("descricao"));

                return m;

            }


        }catch (SQLException e ){System.out.println("ERRO: "+e.getMessage());}
        return null;
    }
    public void editar (Materia materia){
        String sql = "UPDATE materia SET nome = ?, descricao = ? where id = ? ";
        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, materia.getNome());
            ps.setString(2, materia.getDescricao());
            ps.setInt(3,materia.getId());

            ps.executeUpdate();
            System.out.println("entities.Materia atualizada! ");
        } catch (SQLException e){
            System.out.println("Erro ao digitar: "+e.getMessage());
        }

    }

    public void excluir (int id){
        String sql ="DELETE FROM materia WHERE id = ?";

        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("entities.Materia Removida!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir! "+ e.getMessage());
        }
    }

}
