package CW2014; 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UpdateDVD extends JFrame
                  implements ActionListener {
    
    JTextField trackNo = new JTextField(2);
    JTextField star = new JTextField(5);
    TextArea information = new TextArea(6,35);
    JButton update = new JButton("Update");
    JLabel number = new JLabel("Enter DVD Number:");
    JLabel rating = new JLabel ("Add DVD rating:");
    
   
         
    public UpdateDVD(){
        setLayout(new BorderLayout());
        setBounds(100, 100, 400, 200);
        setTitle("Update DVD");
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel top = new JPanel();
        top.setBackground(Color.blue);
        top.add(number);
        number.setForeground(Color.white);
        top.add(trackNo);
        add("North", top);
        JPanel middle = new JPanel();
        middle.setBackground(Color.black);
        middle.add(rating);
        rating.setForeground(Color.white);
        middle.add(star);
        add("Center", middle); 
        JPanel bottom = new JPanel();
        bottom.setBackground(Color.black);
        bottom.add (information);
        bottom.add (update);
        update.addActionListener(this); 
        update.setBackground(Color.white);
        add("South", bottom);
        setResizable(false);
        setVisible(true);
       
    }
    
    public void actionPerformed(ActionEvent e) { 
        try {
            String key = trackNo.getText();
            String stars = star.getText();
            int rating = Integer.parseInt(stars);
            String name = MovieDB.getName(key);
            MovieDB.setRating(key, rating);
            if (name == null){
                information.setText("Invalid ID");
            }
            else {
            information.setText(name + " - " + MovieDB.getArtist(key));
            information.append("\nRating: " + stars(MovieDB.getRating(key)));
            information.append("\n No of Rentals: " + MovieDB.getPlayCount(key));
        }
        }
            catch(Exception NumberFormatException){
                information.setText("Please input a valid number");
            }
            
    }
 
   public String stars(int rating) {
        String stars = "";
        for (int i = 0; i < rating; ++i) {
            stars += "*";
        }
        return stars;  
    }
} 