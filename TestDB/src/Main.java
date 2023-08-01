import model.Datasource;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        Datasource datasource = new Datasource();

        if(!datasource.open()){
            System.out.println("Can't open data source");
            return;
        }

        datasource.close();

    } // End of main method
} //End of class