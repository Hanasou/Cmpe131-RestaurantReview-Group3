import javax.swing.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.BorderLayout;
/**
 * Write a description of class LogInManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LogInManager extends JFrame
{  
  public static void createLogInPage()
  {
  //hello
     JFrame frame = new JFrame("First frame");
     frame.setPreferredSize(new Dimension(2000,2000));
     JButton logIn = new JButton("Log in");
     JLabel logInLabel = new JLabel("Log in: ");
     JLabel passwordLabel = new JLabel("Password: ");
     JTextField logInField = new JTextField();
     logInField.setPreferredSize(new Dimension(150,20));
     JPasswordField passwordField = new JPasswordField();
     passwordField.setPreferredSize(new Dimension(150,20));
     
     JPanel labelPanel = new JPanel();
     labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.PAGE_AXIS));
     labelPanel.add(Box.createVerticalStrut(60));
     labelPanel.add(logInLabel);
     labelPanel.add(Box.createVerticalStrut(12));
     labelPanel.add(passwordLabel);
     
     JPanel textFieldPanel = new JPanel();
     textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.PAGE_AXIS));
     textFieldPanel.add(Box.createVerticalStrut(100));
     textFieldPanel.add(logInField);
     textFieldPanel.add(Box.createVerticalStrut(10));
     textFieldPanel.add(passwordField);
     textFieldPanel.add(Box.createVerticalStrut(10));
     textFieldPanel.add(logIn);
     
     
     ImageIcon image = new ImageIcon("/Users/aliaksandrnenartovich/Desktop/Restaurant.jpg");
     JLabel label = new JLabel(image);
     JPanel p = new JPanel();
     p.setPreferredSize(new Dimension(2000,2000));
     p.add(label);
     
     JPanel panel = new JPanel();
     panel.add(labelPanel);
     panel.add(textFieldPanel);
   
     JPanel finalPanel = new JPanel(new BorderLayout());
     finalPanel.add(p);
     
     finalPanel.add(panel, BorderLayout.EAST);
     frame.add(finalPanel);
     
     // put some users into database for testing purposes
     UserDatabase database = new UserDatabase();
     database.setAccount("JohnDoe", "12345");
     database.setAccount("MaryJane", "cutie");
     database.setAccount("Misha", "12345");
     
     logIn.addActionListener(new ActionListener()  {
         public void actionPerformed(ActionEvent e)
         {
            String username = logInField.getText();
            String password = passwordField.getText();
            if(database.validateLogIn(username,password))
            {
            frame.setVisible(false);
            SearchManager manager = new SearchManager();
            manager.createPage(username);
             }
            else if(database.wrongPassword(username,password))
            {
               JOptionPane.showMessageDialog(frame,"You have entered " +
                    "incorrect password. Please try again.");
               logInField.setText("");
               passwordField.setText("");
            }
            else if(database.noAccountExists(username))
            {
               JOptionPane.showMessageDialog(frame, "You have entered " +
                     "incorrect username. Please try again.");
               logInField.setText("");
               passwordField.setText("");
            }
            }
        });
     frame.pack();
     frame.setVisible(true);
    }
}
