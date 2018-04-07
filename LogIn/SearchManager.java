import javax.swing.*;
import java.awt.Dimension;
import java.awt.BorderLayout;
/**
 * Write a description of class SearchManager here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SearchManager extends JFrame
{  
  public void createPage(String username)
  {
        JFrame frame = new JFrame("Search Frame");
        JLabel searchLabel = new JLabel("Search");
        JLabel welcomeLabel = new JLabel("Welcome! You are logged in as "
                    + username);
        JTextField searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(300,20));
        JButton searchButton = new JButton("Search");
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.PAGE_AXIS));
        eastPanel.add(welcomeLabel);
        
        JPanel searchPanel = new JPanel();
        searchPanel.add(Box.createHorizontalStrut(200));
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(Box.createVerticalStrut(300));
        centerPanel.add(searchPanel);
        
        JPanel finalPanel = new JPanel(new BorderLayout());
        finalPanel.add(centerPanel,BorderLayout.CENTER);
        finalPanel.add(eastPanel,BorderLayout.EAST);
        frame.add(finalPanel); 
       
        frame.setPreferredSize(new Dimension(2000,2000));
        frame.pack();
        frame.setVisible(true);
    }
}
