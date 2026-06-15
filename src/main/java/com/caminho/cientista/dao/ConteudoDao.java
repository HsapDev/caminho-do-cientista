package com.caminho.cientista.dao;

import com.caminho.cientista.conexao.Conexao;
import com.caminho.cientista.model.Conteudo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConteudoDao {

    public void inserir (Conteudo conteudo){
        String sql = "INSERT INTO conteudo (materia_id,titulo,texto,formula) VALUES (?,?,?,?)";
        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,conteudo.getMateriaId());
            ps.setString(2,conteudo.getTitulo());
            ps.setString(3,conteudo.getTexto());
            ps.setString(4, conteudo.getFormula());

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro: "+e.getMessage());
        }
    }

    public Conteudo buscarPorId(int id){
        String sql ="SELECT * FROM conteudo WHERE id = ?";

        try (Connection con = Conexao.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
        if (rs.next()){
            Conteudo c = new Conteudo();
            c.setId(rs.getInt("id"));
            c.setMateriaId(rs.getInt("materia_id"));
            c.setTitulo(rs.getString("titulo"));
            c.setTexto(rs.getString("texto"));
            c.setFormula((rs.getString("formula")));
            return c;

        }


        }catch (SQLException e ){System.out.println("ERRO: "+e.getMessage());}
        return null;
    }

    public List<Conteudo> buscarPorIdmateria(int id){
        String sql ="SELECT * FROM conteudo WHERE materia_id = ?";
        ArrayList<Conteudo> conteudos = new ArrayList<>();

        try (Connection con = Conexao.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Conteudo c = new Conteudo();
                c.setId(rs.getInt("id"));
                c.setMateriaId(rs.getInt("materia_id"));
                c.setTitulo(rs.getString("Titulo"));
                c.setTexto(rs.getString("Texto"));
                c.setFormula(rs.getString("Formula"));
                conteudos.add(c);
            }
            return conteudos;


        }catch (SQLException e ){System.out.println("ERRO: "+e.getMessage());}
        return null;
    }

    public List<Conteudo> listar (){
        String sql = "SELECT * FROM CONTEUDO";
        List<Conteudo> conteudoList = new ArrayList<>();
        try(Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Conteudo c = new Conteudo();
                c.setId(rs.getInt("id"));
                c.setMateriaId(rs.getInt("materia_id"));
                c.setTitulo(rs.getString("Titulo"));
                c.setTexto(rs.getString("Texto"));
                c.setFormula(rs.getString("Formula"));
                conteudoList.add(c);
            }
        }
        catch (SQLException e ){
            System.out.println("Erro: "+e.getMessage());
        }
        return conteudoList;
    }
    public void editar (Conteudo conteudo){
        String sql = "UPDATE conteudo SET titulo =?, texto=?, formula = ? where id=?";

        try(Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,conteudo.getTitulo());
            ps.setString(2, conteudo.getTexto());
            ps.setString(3, conteudo.getFormula());
            ps.setInt(4,conteudo.getId());

            ps.executeUpdate();
            System.out.println("entities.Conteudo atualizado! ");
        }
        catch (SQLException e ){
            System.out.println("ERRO: "+e.getMessage());
        }
    }

    public void delete (int id){
        String sql = "DELETE FROM conteudo WHERE id = ? ";
        try(Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,id);
            ps.executeUpdate();
            System.out.println("entities.Conteudo Removido!");
        }
        catch (SQLException e ){System.out.println("ERRO: "+e.getMessage());}
    }



}
