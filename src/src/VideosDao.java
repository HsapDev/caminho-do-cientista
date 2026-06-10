import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideosDao {

    public void inserir(videos video){
        String sql = "INSERT INTO videos (conteudo_id,titulo,url) VALUES (?,?,?)";
        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,video.getConteudo_id());
            ps.setString(2,video.getTitulo());
            ps.setString(3,video.getUrl());
            ps.executeUpdate();
            System.out.println("Video adicionado ");
        }
        catch (SQLException e ){System.out.println("ERRO: "+ e.getMessage());}
    }

    public List<videos> listar(){
        String sql = "SELECT * FROM videos";
        List<videos> videosList = new ArrayList<>();
        try(Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                videos v = new videos();
                v.setConteudo_id(rs.getInt("conteudo_id"));
                v.setTitulo(rs.getString("titulo"));
                v.setUrl(rs.getString("url"));
                videosList.add(v);
            }
            System.out.println("LISTA");
        }
        catch (SQLException e){
            System.out.println("ERRO: "+ e.getMessage());
        }
        return videosList;
    }

    public void editar (videos video){
        String sql = "UPDATE videos SET titulo = ?, url = ? WHERE id =?";
        try(Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,video.getTitulo());
            ps.setString(2, video.getUrl());
            ps.setInt(3,video.getId());
            ps.executeUpdate();
            System.out.println("VIDEO ATUALIZADO");
        }
        catch (SQLException e){System.out.println("ERRO: "+e.getMessage());}
    }
    public void excluir (videos videos){
        String sql = "DELETE FROM videos WHERE id= ?";
        try(Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,videos.getId());
            ps.executeUpdate();
            System.out.println("VIDEO DELETADO");
        }
        catch (SQLException e){System.out.println("ERRO: "+e.getMessage());}
    };
}
