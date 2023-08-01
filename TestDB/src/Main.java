import java.sql.*;

import static model.Datasource.*;

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            // Class.forName(DBConnectParams.driver); Old method of loading class and not necessary anymore.
            Connection conn = DriverManager.getConnection(CONNECTION,
                    USER, PASSWORD);
            Statement statement = conn.createStatement();
            // statement.execute("INSERT INTO artists(_id, artist_name) VALUES (202, 'Okeng Kin Gang')");
            statement.execute("DELETE FROM artists WHERE _id=202");
            statement.execute("SELECT COUNT(DISTINCT song_title) FROM " +
                    "artist_list WHERE album_name = \"Dragon Fly\"");

           //  statement.execute("SELECT * FROM songs ORDER BY album, track LIMIT 40" );
            // ResultSet results = statement.getResultSet();
            ResultSet results = statement.executeQuery("SELECT * FROM songs ORDER BY album, track LIMIT 40" );

            while(results.next()){
                System.out.println(results.getString("title") + " "
                        + results.getString("album"));
            }

            results.close();
            statement.close();
            conn.close();

        }catch(SQLException e){
            System.out.println("Something went wrong: " +e.getMessage() );
        }
    }
}