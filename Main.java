import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws SQLException {


    Database db = new Database();

    String password = "password";

    ResultSet set = db.select("users", new String[]{"username", "password"}, new String[]{"username"} , new String[]{"Jane Doe"}, "AND", new String[]{"="});
//    db.update("users", new String[]{"password"}, new String[]{hashPassword("password")}, new String[]{"username"}, new String[] {"Jane Doe"}, "AND", new String[]{"="});


    if(set.next()){

      String dbPass = set.getString("password");

      String hashPass = hashPassword(password);

      if(dbPass.equals(hashPass)){
        System.out.println("Loggin in");
        System.out.println("dbPass "+ dbPass + "\n" + "hashPass " + hashPassword(password));
        System.out.println("Invalid Credentials");
      }else{
        System.out.println("dbPass "+ dbPass + "\n" + "hashPass " + hashPassword(password));
        System.out.println("Invalid Credentials");
      }
    }else{
      System.out.println("Invalid Credentials");
    }



  }





  public static String hashPassword(String password) {

    MessageDigest md = null;

    try {
      md = MessageDigest.getInstance("MD5");
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    md.update(password.getBytes());

    byte[] b = md.digest();

    StringBuffer sb = new StringBuffer();

    for (byte b1 : b) {

      sb.append(Integer.toHexString(b1 & 0xff).toString());

    }

    return sb.toString(); //Return the hashed password
  }

}




