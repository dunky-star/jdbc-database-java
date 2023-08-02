import model.Artist;
import model.Datasource;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Datasource datasource = new Datasource();

        if(!datasource.open()){
            System.out.println("Can't open data source");
            return;
        }

        List<Artist> artists = datasource.queryArtists();
        if(artists == null){
            System.out.println("No artists!");
            return;
        }

        System.out.println("\nARTISTS IN OUR DATABASE");
        System.out.println("++++++++++++++++++++++++++\n");
        for(Artist artist:artists){
            System.out.println("ID = " + artist.getId() + ", Name = " + artist.getName());
        }

        datasource.close();

    } // End of main method
} //End of class