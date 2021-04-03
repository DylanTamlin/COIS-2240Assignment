import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws SQLException {

      Database db = new Database();

      String[] keys = new String[3];
    keys[0] = "key";
    keys[1] = "value";
    keys[2] = "end";

    String[] values= new String[3];

    values[0] = "1";
    values[1] = "asd";
    values[2] = "qwer";


    db.insert("users", keys, values);

    System.out.println(hashPassword("vildan"));

  }


  /*
  *
  *
  * hash password MD5
  *
  *
  * */

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




