import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            Class.forName(DBConnectParams.driver);
            Connection conn = DriverManager.getConnection(DBConnectParams.connection,
                    DBConnectParams.user, DBConnectParams.password);


        }catch(SQLException e){
            System.out.println("Something went wrong: " +e.getMessage() );
        }
    }
}