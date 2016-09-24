package CW2014;

import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;

public class AddDVD  extends JFrame 
                  implements ActionListener {

    
    JTextField trackNo = new JTextField(2);
    JButton add = new JButton("Add to playlist");
    JButton play = new JButton("Play Playlist"); 
    JTextArea information = new JTextArea(15, 30);
    JScrollPane scrollBar=new JScrollPane(information,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
    JButton clear = new JButton("Clear playlist");
    JLabel number = new JLabel("Enter DVD Number:");

    
    
    public AddDVD() {
        
        setLayout(new BorderLayout());
        setBounds(100, 100, 400, 400);
        setTitle("Add DVD to playlist");
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel top = new JPanel();
        top.setBackground(Color.blue);
        top.add(number);
        top.add(trackNo);
        number.setForeground(Color.white);
        add("North", top);
        JPanel middle = new JPanel();
        middle.setBackground(Color.black);
        middle.add(add);
        middle.add(play);
        middle.add(clear); 
        add.addActionListener(this);
        play.addActionListener(this); 
        clear.addActionListener(this);
        add.setBackground(Color.WHITE);
        play.setBackground(Color.WHITE);
        clear.setBackground(Color.WHITE);
        add("Center", middle);
        JPanel bottom = new JPanel();
        bottom.setBackground(Color.black);
        bottom.add(scrollBar);
        add("South", bottom); 
        setResizable(false);
        setVisible(true);
    }

            ArrayList<String> moviePlaylist = new ArrayList();
    

     public void actionPerformed(ActionEvent e) {
         
            String key = trackNo.getText();
            String name = MovieDB.getName(key);
     if (e.getSource()== play) {
         
          try{
                 MovieDB.incrementPlaycount(moviePlaylist);
                 information.setText("Movies playcount incremented.");
                         }
     
         
                catch (NullPointerException v){
                   information.setText("Invalid ID. Please clear playlist.");
                   
                }
} 

                    
                
            
     if(e.getSource()==add){
         try{
                 moviePlaylist.add(name);
                 
          StringBuilder format = new StringBuilder();
                      for (String names: moviePlaylist) {
                      format.append(names.toString()).append('\n');
}
        information.setText( format.toString());
                 }
            catch (NullPointerException NPE) {
                information.setText("Invalid ID. Please clear playlist.");
            }

                 try{
    FileOutputStream fos = new FileOutputStream("playlist.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);   
    oos.writeObject(moviePlaylist); // write moviePlaylist to ObjectOutputStream
    oos.close(); 
} 
            catch (IOException ex) {
               information.setText("File not found"); 
            }
}

               
       if(e.getSource()==clear) {
               moviePlaylist.clear();
               try{
    FileOutputStream fos = new FileOutputStream("playlist.txt");
    ObjectOutputStream oos = new ObjectOutputStream(fos);   
    oos.writeObject(moviePlaylist); // write moviePlaylist to ObjectOutputStream
    oos.close(); 
} 
            catch (IOException ex) {
               information.setText("File not found"); 
            }
               
 }
     }
     
     
    private String stars(int rating) {
        String stars = "";
        for (int i = 0; i < rating; ++i) {
            stars += "*";
       }
       return stars;
   }
}


