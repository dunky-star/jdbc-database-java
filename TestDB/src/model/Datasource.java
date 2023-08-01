package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    // Opening database resource connection
    public boolean open() {
        try {
            conn =  DriverManager.getConnection(CONNECTION, USER, PASSWORD);
            return true;
        }catch(SQLException e){
            System.out.println("Couldn't connect to the database" + e.getMessage());
            return false;
        }
    }

    // Closing database resource connection
    public void close(){
        try{
            if(conn != null){
                conn.close();
            }

        }catch(SQLException e){
            System.out.println("Connection couldn't be closed" + e.getMessage());
        }
    }



} // End of class
