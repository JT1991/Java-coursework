
package CW2014;

import java.io.File;
import java.sql.Statement;
import java.lang.Exception;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MovieDB {

    private static Connection movieDB;
    private static Statement stmt;
    static String name, Director, key, information;
    static Integer rating, playcount;
    static String Output="";
    static String dbUrl;
    static {
        try {
            dbUrl ="jdbc:ucanaccess://MovieDB.mdb";
            movieDB = DriverManager.getConnection(dbUrl);
            stmt = movieDB.createStatement();
        } // The following exceptions must be caught
        catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }
    
    public static String getName(String key) {
        try {
            ResultSet res = stmt.executeQuery("SELECT MovieName FROM Movie WHERE key = '" + key + "'");
            if (res.next()) {
                name = res.getString("MovieName");
                return name;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static String getArtist(String key) {
        try{
            ResultSet res = stmt.executeQuery("SELECT * FROM Movie WHERE key = '" + key + "'");
            if (res.next()) {
                return res.getString("Director");
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
    }
    }
    

    public static int getRating(String key) {
        try {
            ResultSet res = stmt.executeQuery("SELECT * FROM Movie WHERE key = '" + key + "'");
            if (res.next()) {
                return res.getInt("Rating");
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }
    // update rating levels

    public static void setRating(String key, int rating) {
        String updateStr = "UPDATE Movie SET Rating = " + rating + " WHERE key = '" + key + "'";
        System.out.println(updateStr);
        try {
            stmt.executeUpdate(updateStr);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

   public static void incrementPlaycount(String key) {
        String updateStr = "UPDATE Movie SET Playcount = Playcount+1 WHERE key = '" + key + "'";
            System.out.println(updateStr);
            try {
                stmt.executeUpdate(updateStr);
      }     catch (Exception e) {
            System.out.println(e);
        }
   }
       
    
    static int getPlayCount(String key) {
        try {
            ResultSet res = stmt.executeQuery("SELECT * FROM Movie WHERE key = '" + key + "'");
            if (res.next()) { 
                return res.getInt("Playcount");
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    static void incrementPlaycount(ArrayList<String> moviePlaylist) {
        String updateStr = "UPDATE Movie SET Playcount = Playcount+1";
            try {
                stmt.executeUpdate(updateStr);
      }     catch (Exception e) {
            System.out.println(e);
        }
   }
   public static String getPoster(String key){
       
        try {
            ResultSet res = stmt.executeQuery("SELECT Poster FROM Movie WHERE key = '" + key + "'");
            if (res.next()) { 
                return res.getString("Poster");
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
           
    public static void close() {
        try {
            movieDB.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
   }
    

