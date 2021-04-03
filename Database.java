import java.sql.*;
import java.util.Random;

public class Database {

  Connection con = null;

  Statement stm = null;

  public Database() {

    try {
      con = this.connect();
      stm = con.createStatement();
      stm.execute("CREATE TABLE IF NOT EXISTS users(username TEXT, password VARCHAR, WebsiteName TEXT)");
      stm.close();
      System.out.println("Connected");
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }


  public boolean insert(String table, String[] keys, String[] values) throws SQLException {
    String query = "INSERT INTO " + table + "(" + this.getKeysAsString(keys) + ") VALUE (" + this.getValuesAsString(values) + ");";
    ResultSet set = stm.executeQuery(query);
    stm.close();
    return true;
  }


  public ResultSet select(String table) throws SQLException {

    stm = this.con.createStatement();
    ResultSet set = stm.executeQuery("SELECT * FROM " + table);
    stm.close();

    return set;

  }

  public void select(String table, String[] keys, String[] where, String[] values, String operand, String[] operators){

    String whereClause = "";

    if(where != null){
      whereClause = buildWhere(where, values, operand, operators);
    }


    String query = "SELECT  from " + table;
  }

  private String buildWhere(String[] where, String[] values, String operand, String[] operators){


    String whereClause = "name = vildan";

    for (int i = 0; i < where.length; i++) {

      String op = i == where.length - 1 ? "" : operand;

      whereClause += where[i] + " " + operators[i] + " " + values[i] + " " + op;

    }

    return whereClause;
  }




  public String getKeysAsString(String[] keys){

    String value = "";

    for (String key : keys) {
      value += key + ",";
    }

    return value.replaceAll(",$", "");
  }


  public String getValuesAsString(String[] keys){

    String value = "";

    for (String key : keys) {
      value += "'" + key + "',";
    }

    return value.replaceAll(",$", "");
  }

  private static char[] generatePassword(int length) {
    String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    String specialCharacters = "!@#$";
    String numbers = "1234567890";
    String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
    Random random = new Random();
    char[] password = new char[length];

    password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
    password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
    password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
    password[3] = numbers.charAt(random.nextInt(numbers.length()));

    for(int i = 4; i< length ; i++) {
      password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
    }
    return password;
  }


  public Connection connect() throws SQLException {
    return DriverManager.getConnection("JDBC:sqlite:testing.db");
  }

}
