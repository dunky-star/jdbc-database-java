import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            // Class.forName(DBConnectParams.driver); Old method of loading class and not necessary anymore.
            Connection conn = DriverManager.getConnection(DBConnectParams.connection,
                    DBConnectParams.user, DBConnectParams.password);
            Statement statement = conn.createStatement();
            statement.execute("SELECT COUNT(DISTINCT song_title) FROM " +
                    "artist_list WHERE album_name = \"Dragon Fly\"");

            statement.close();
            conn.close();

        }catch(SQLException e){
            System.out.println("Something went wrong: " +e.getMessage() );
        }
    }
}