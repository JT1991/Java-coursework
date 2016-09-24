//package name
package CW2014;
//Handles layout of JPane 
import java.awt.BorderLayout;
//Handles layout of JPane 
import java.awt.Color;
//Spilts content pane
import java.awt.TextArea;
//Enables text area for output
import java.awt.Dimension;
//For resizing JFrame
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//listens for events - button being pressed etc.
import javax.swing.JButton;
//Handles buttons
import javax.swing.ImageIcon;
//Handles images
import javax.swing.JFrame;
//new template
import javax.swing.JLabel;
//Handles labels
import javax.swing.JTextField;
//Enables text box for input
import javax.swing.JPanel;
//Enables panels in jframe - so user can spilt JFrame into sections
public class CheckDVD extends JFrame 
                  implements ActionListener {
    //application is subclass of Swing Jframe class and should listen to events
    JTextField trackNo = new JTextField(2);
    //new text field
    TextArea information = new TextArea(6, 50);
    //new TextArea
    JButton list = new JButton("List All DVD");
    //new button
    JButton check = new JButton("Check DVD");
    //another button
    JLabel title = new JLabel("Enter DVD Number:");
    //declares label
    JLabel image = new JLabel("");
    //another label
    
    public CheckDVD() {
        //name of the class
        getContentPane().setBackground(Color.BLACK);
        //sets background to black
        setLayout(new BorderLayout());
        //sets the type of layout
        setBounds(350, 350, 550, 200);
        //sets dimensions
        setTitle("Check DVD");
        //sets title
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //enable exit
        JPanel top = new JPanel();
        //add panel at the top of frame
        top.setBackground(Color.blue);
        //sets panel colour
        top.add(title);
        //add label to top panel
        title.setForeground(Color.white);
        //sets label colour
        top.add(trackNo);
        //add text field to top panel
        top.add(check);
        //add button to top panel
        top.add(list);
        //add second button to top panel
        list.addActionListener(this);
        check.addActionListener(this);
        //adding listeners to both buttons - program will perform action when pressed.
        check.setBackground(Color.WHITE);
        list.setBackground(Color.WHITE);
        //setting colour of both buttons
        add("North", top);
        //position buttons on the top panel on the north frame
        JPanel middle = new JPanel();
        //new panel
        middle.setBackground(Color.black);
        //set colour of panel
        middle.add(image);
        //add label to middle panel
        information.setText(LibraryData.listAll());  
        //set textarea to show all movies
        middle.add(information);
        //add textarea
        add("Center", middle);
        //position on the middle panel on the center pane
        setResizable(false);
        //making frame non resizable
        setVisible(true);
        //making frame visable
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == list) {
             //if list is selected
            try{
            image.hide();
            //hides image label
            setBounds(350, 350, 550, 200);
            //sets dimensions of frame
            information.setText(LibraryData.listAll());
            //gets all movies from LibraryData class
            }
            catch (Exception ex){
                //if function fails
                information.setText("Error");
                //show error
            }
        }
        if (e.getSource()== check) { 
          //if list is selected
            String key = trackNo.getText();
            //name trackNo input as key
            String name = MovieDB.getName(key);
            String director = MovieDB.getArtist(key);
            //create variable name and perform getName method from MovieDB class 
             information.setText(name + " - " + director);
             //input movie name and perform getArtist method from MovieDB class to get director
             if (name== null){
                 //if name is null set textarea to invalid input
                 information.setText("Invalid ID");
            }
             else{
             information.append("\nRating: " + stars(MovieDB.getRating(key)));
             //perform getRating method from MovieDB class, call stars method
             information.append("\n No of Rentals: " + MovieDB.getPlayCount(key));
             //perform getPlayCount method from movieDB class and input number to textarea
            image.show();
            //show image
             setSize(new Dimension(700, 520));
             //set new dimension
             setVisible(true);     
             ImageIcon t = new ImageIcon(MovieDB.getPoster(key)); 
             //perform getPoster method and set it to ImageIcon
             image.setIcon(t);
             //input ImageIcon into image label
            
        }
        }
    } 

    private String stars(int rating) {
        String stars = "";
        //create string variable stars
        for (int i = 0; i < rating; ++i) {
            stars += "*";
        }
        return stars;
    }
}