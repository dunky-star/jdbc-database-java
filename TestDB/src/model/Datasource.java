package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Datasource {
    // protected static String driver = "com.mysql.cj.jdbc.Driver";
    public static final String DB_NAME = "basic_jdbc";
    public static final String CONNECTION = "jdbc:mysql://localhost:3306/" + DB_NAME;
    public static final String USER = "student";
    public static final String PASSWORD = "cluster@1";

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "album_name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";

    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";


    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "artist_name";

    public static final String TABLE_ARTISTS_LIST = "artist_list";

    private Connection conn;
    // Method to open database resource connection.
    public boolean open() {
        try {
            conn =  DriverManager.getConnection(CONNECTION, USER, PASSWORD);
            return true;
        }catch(SQLException e){
            System.out.println("Couldn't connect to the database" + e.getMessage());
            return false;
        }
    }


    // Method tp close database resource connection.
    public void close(){
        try{
            if(conn != null){
                conn.close();
            }

        }catch(SQLException e){
            System.out.println("Connection couldn't be closed" + e.getMessage());
        }
    }

    // Methods to Querying DB tables.
    public List<Artist> queryArtists(){

        ResultSet results = null;

        try (Statement statement = conn.createStatement()) {
            results = statement.executeQuery("SELECT * FROM " + TABLE_ARTISTS);

            List<Artist> artists = new ArrayList<>();
            while (results.next()) {
                Artist artist = new Artist();
                artist.setId(results.getInt(COLUMN_ARTIST_ID));
                artist.setName(results.getString(COLUMN_ARTIST_NAME));
                artists.add(artist);
            }

            return artists;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }


    }

} // End of class
