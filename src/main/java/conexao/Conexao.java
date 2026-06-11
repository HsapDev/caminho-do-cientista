package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    private static final String URL ="jdbc:postgresql://localhost:4002/postgres";
    private static final String USUARIO="postgres";
    private static final String SENHA ="senhadobanco";

    public static Connection conectar(){
        try{
            return DriverManager.getConnection(URL,USUARIO,SENHA);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar"+ e.getMessage());
            return null;
        }
    }
}
