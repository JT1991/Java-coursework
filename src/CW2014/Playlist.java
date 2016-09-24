
package CW2014;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Josh
 */
public class Playlist {
    static String  information;


    ArrayList moviePlaylist = new ArrayList(){
        
        public void AddMovie (String name) {
        moviePlaylist.add(name);
        }
        public void WritePlaylist (ArrayList<String> moviePlaylist) {
            try{
    FileOutputStream fos = new FileOutputStream("playlist.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);   
    oos.writeObject(moviePlaylist); // write moviePlaylist to ObjectOutputStream
    oos.close(); 
}  catch (IOException ex) {
              // information.setText("File not found"); 
}  
    }
        public void ReadPlaylist (ArrayList<String> moviePlaylist){
            
                    File file = new File("playlist.txt");
                    Scanner scanner = null;
            try {
                scanner = new Scanner(file);
            } catch (FileNotFoundException ex) {
               // information.setText("Fle not found"); 
            }
                    while(scanner.hasNextLine()){
                    moviePlaylist.add(scanner.nextLine());
                    }
        }
        public void ClearPlaylist (ArrayList<String> moviePlaylist) throws FileNotFoundException, IOException{
            moviePlaylist.clear();
            
    FileOutputStream fos = new FileOutputStream("playlist.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);   
    oos.writeObject(moviePlaylist); // write moviePlaylist to ObjectOutputStream
    oos.close(); 
        }
    };
            }