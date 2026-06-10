import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestoesDao {

    public void inserir(Questoes questao){
        String sql = "INSERT INTO  questoes (conteudo_id,enunciado,resolucao,resposta) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setInt(1,questao.getConteudoId());
            ps.setString(2,questao.getEnunciado());
            ps.setString(3,questao.getResolucao());
            ps.setString(4,questao.getResposta());
            ps.executeUpdate();
            System.out.println("Questao criada! ");

        }catch (SQLException e){System.out.println("ERRO: "+e.getMessage());}
    }
    public List<Questoes> listar (){
        String sql = "Select * from questoes";
        List<Questoes> questoesList = new ArrayList<>();

        try(Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Questoes q = new Questoes();
                //logica eu peco da clase questao, e o resultSet pega do banco
                q.setConteudoId(rs.getInt("conteudo_id"));
                q.setEnunciado(rs.getString("enunciado"));
                q.setResolucao(rs.getString("resolucao"));
                q.setResposta(rs.getString("resposta"));
                questoesList.add(q);
            }
        }
        catch (SQLException e ){System.out.println("ERRO: "+e.getMessage());}

        return questoesList;
    }

    public void editar (Questoes questao){
        String sql="UPDATE questao SET enunciado =?,resolucao=?, resposta=? where id =?";
        try(Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,questao.getEnunciado());
            ps.setString(2,questao.getResolucao());
            ps.setString(3,questao.getResposta());
            ps.setInt(4,questao.getId());

            ps.executeUpdate();
            System.out.println("Questao atualizada");
        }
        catch (SQLException e ){System.out.println("ERRO: " + e.getMessage());}

    }

    public void deletar (Questoes questao){
        String sql = "DELETE FROM questao WHERE id = ? ";
        try(Connection conn = Conexao.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1,questao.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("ERRO: "+e.getMessage());
        }

    }
}
