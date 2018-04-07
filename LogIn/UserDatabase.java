import java.util.HashMap;
/**
 * Write a description of class UserDatabase here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class UserDatabase
{
  private HashMap<String,String> userAccount;
  private String username;
  private String password;
  
  public UserDatabase()
  {
     userAccount = new HashMap();    
  }
  
  public String getUsername()
  {
     return username;    
  }
  
  public void setAccount(String username, String password)
  {
      this.username = username;
      this.password = password;
      userAccount.put(username,password);    
  }
  
  public boolean validateLogIn(String username, String password)
  {
      if(userAccount.containsKey(username))
        {
            if(userAccount.get(username).equals(password))
               return true;
        }   
      return false; 
    }
    
  public boolean wrongPassword(String username, String password)
  {
     return userAccount.containsKey(username) 
                && !userAccount.get(username).equals(password);   
   }
   
  public boolean noAccountExists(String username)
  {
      return !userAccount.containsKey(username);   
   }
}
