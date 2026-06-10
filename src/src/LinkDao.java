import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LinkDao {

    public void inserir(Link link){
        String sql = "INSERT INTO Link (conteudo_id,titulo,url) VALUES (?,?,?)";
        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,link.getConteudo_id());
            ps.setString(2,link.getTitulo());
            ps.setString(3,link.getUrl());
            ps.executeUpdate();
            System.out.println("link adicionado ");
        }
        catch (SQLException e ){System.out.println("ERRO: "+ e.getMessage());}
    }

    public List<Link> listar(){
        String sql = "SELECT * FROM Link";
        List<Link> LinkList = new ArrayList<>();
        try(Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Link l = new Link();
                l.setConteudo_id(rs.getInt("conteudo_id"));
                l.setTitulo(rs.getString("titulo"));
                l.setUrl(rs.getString("url"));
                LinkList.add(l);
            }
            System.out.println("LISTA");
        }
        catch (SQLException e){
            System.out.println("ERRO: "+ e.getMessage());
        }
        return LinkList;
    }

    public void editar (Link link){
        String sql = "UPDATE Link SET titulo = ?, url = ? WHERE id =?";
        try(Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,link.getTitulo());
            ps.setString(2, link.getUrl());
            ps.setInt(3,link.getId());
            ps.executeUpdate();
            System.out.println("link ATUALIZADO");
        }
        catch (SQLException e){System.out.println("ERRO: "+e.getMessage());}
    }
    public void excluir (Link Link){
        String sql = "DELETE FROM Link WHERE id= ?";
        try(Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,Link.getId());
            ps.executeUpdate();
            System.out.println("link DELETADO");
        }
        catch (SQLException e){System.out.println("ERRO: "+e.getMessage());}
    };
}
