
package CW2014;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DVDLibrary extends JFrame
                  implements ActionListener {
        JButton check = new JButton("Check DVD");
        JButton playlist = new JButton("Add DVD");
        JButton update = new JButton("Update DVD");
        JLabel title = new JLabel("Select an option by clicking one of the buttons below");
        JButton quit = new JButton("Exit");

    public static void main(String[] args) {
       DVDLibrary xyz = new DVDLibrary();
    }
    
    
    public DVDLibrary() {
        setLayout(new BorderLayout());
        setSize(450, 100);
        setTitle("DVD Library System");
        getContentPane().setBackground(Color.BLACK);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        JPanel top = new JPanel();
        top.setBackground(Color.blue);
        top.add(title);
        title.setForeground(Color.white);
        add("North", top);
        JPanel bottom = new JPanel();
        bottom.setBackground(Color.black);
        bottom.add(check); check.addActionListener(this);
        bottom.add(playlist); playlist.addActionListener(this);
        bottom.add(update); update.addActionListener(this);
        bottom.add(quit); quit.addActionListener(this);
        check.setBackground(Color.WHITE);
        playlist.setBackground(Color.WHITE);
    update.setBackground(Color.WHITE);
        quit.setBackground(Color.WHITE);
        add("South", bottom);
        setResizable(false);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == check) {
            new CheckDVD();
            
        }
             if (e.getSource() == playlist) {
                 new AddDVD();
            
        } 
               if (e.getSource() == update) {
                   new UpdateDVD();
                   
        }   
             else if (e.getSource() == quit) {
            MovieDB.close();
            System.exit(0);
            
        }
    }
    }


