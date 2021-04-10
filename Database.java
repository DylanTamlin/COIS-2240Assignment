import Models.Website;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

  Connection con = null;
  Statement stm = null;
  ResultSet set = null;

  public Database() {

    try {
      con = this.connect();
      stm = con.createStatement();
      stm.execute("CREATE TABLE IF NOT EXISTS users(username TEXT, password VARCHAR, WebsiteName TEXT)");
      System.out.println("Connected");
    } catch (SQLException e) {

      e.printStackTrace();

    } finally {
      try {
        closeConnection();
        stm.close();
      } catch (Exception e) {

      }
    }
  }

  public void validateLogin(String username, String password) throws Exception {
    try {

      con = connect();
      stm = con.createStatement();

      String query = "SELECT * FROM user WHERE mUsername = '" + username + "'";
      set = stm.executeQuery(query);

      if (set.next()) {

        if (!set.getString("mPassword").equals(password)) {
          throw new Exception("Invalid Credentials");
        }

      } else {
        throw new Exception("Invalid Credentials");
      }


    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        stm.close();
        set.close();
        closeConnection();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }


  }

  private void closeConnection() throws SQLException {
    if (con != null) {
      con.close();
    }
  }
//
//  /**
//   * @param table
//   * @param keys
//   * @param values
//   * @return
//   * @throws SQLException
//   */
//  public boolean insert(String table, String[] keys, String[] values) throws SQLException {
//
//    con = this.connect();
//    stm = con.createStatement();
//    String query = "INSERT INTO " + table + "(" + this.getKeysAsString(keys) + ") VALUES (" + this.getValuesAsString(values) + ");";
//
//    return stm.execute(query);
//
//  }
//
//  /**
//   * @param table
//   * @param keys
//   * @param values
//   * @param where
//   * @param whereValues
//   * @param operand
//   * @param operations
//   * @return
//   * @throws SQLException
//   */
//  public boolean update(String table, String[] keys, String[] values, String[] where, String[] whereValues, String operand, String[] operations) throws SQLException {
//
//    con = this.connect();
//    stm = con.createStatement();
//
//    String columnsVals = buildUpdateColumns(keys, values);
//    String whereClause = buildWhere(where, whereValues, operand, operations);
//
//    String query = "UPDATE " + table + " SET " +
//            columnsVals + " WHERE " + whereClause;
//
//    return stm.execute(query);
//  }
//
//  /**
//   * @param keys
//   * @param values
//   * @return
//   */
//  private String buildUpdateColumns(String[] keys, String[] values){
//
//    String query = "";
//
//    for (int i = 0; i < keys.length; i++) {
//      query += keys[i] + " = " + "\"" + values[i] + "\",";
//    }
//
//    return query.replaceAll(",$", "");
//  }
//
//  /**
//   * @param table
//   * @return
//   * @throws SQLException
//   */
//  /*
//   * Select * from table
//   * */
//  public ResultSet select(String table) throws SQLException {
//
//    return this.select(table, new String[]{"*"});
//
//  }
//
//  /**
//   * @param table
//   * @param keys
//   * @return
//   * @throws SQLException
//   */
//  /*
//   * Select keys from table
//   * */
//  public ResultSet select(String table, String[] keys) throws SQLException {
//
//    String fields = "*";
//
//    if (keys.length > 0) {
//      fields = this.getKeysAsString(keys);
//    }
//
//
//    this.getKeysAsString(keys);
//
//    String query = "SELECT " + fields + " FROM " + table;
//
//    try {
//      con = this.connect();
//      stm = con.createStatement();
//      set = stm.executeQuery(query);
//
//      return set;
//
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//      return null;
//    } finally {
//      try {
//      } catch (Exception e) {
//        System.out.println(e.getMessage());
//      }
//    }
//  }
//
//  /**
//   * @param String table
//   * @param String array | keys => Cols to select
//   * @param String array | where => cols to compare
//   * @param String array | values => values for cols
//   * @param String | operand => AND || OR
//   * @param array | operators => [=, => <=, <, >]
//   * @return ResultSet
//   * @throws SQLException
//   */
//  public ResultSet select(String table, String[] keys, String[] where, String[] values, String operand, String[] operators) throws SQLException {
//
//    String whereClause = "";
//
//    if (where != null) {
//      whereClause = buildWhere(where, values, operand, operators);
//    }
//
//
//    String fields = keys == null ? "*" : this.getKeysAsString(keys);
//
//    String query = "SELECT " + fields + " FROM " + table + " WHERE " + whereClause;
//
//
//    con = this.connect();
//    stm = this.con.createStatement();
//    ResultSet set = stm.executeQuery(query);
//
//    return set;
//  }
//
//  private String buildWhere(String[] where, String[] values, String operand, String[] operators) {
//
//
//    String whereClause = "";
//
//    for (int i = 0; i < where.length; i++) {
//
//      String op = i == where.length - 1 ? "" : operand;
//      whereClause += where[i] + " " + operators[i] + " \"" + values[i] + "\" " + op;
//
//    }
//
//    return whereClause.replaceAll(" $", "");
//  }
//
//  public String getKeysAsString(String[] keys) {
//
//    String value = "";
//
//    for (String key : keys) {
//      value += key + ",";
//    }
//
//    return value.replaceAll(",$", "");
//  }
//
//  public String getValuesAsString(String[] keys) {
//
//    String value = "";
//
//    for (String key : keys) {
//      value += "'" + key + "',";
//    }
//
//    return value.replaceAll(",$", "");
//  }

  public Connection connect() throws SQLException {
    return DriverManager.getConnection("JDBC:sqlite:testing.db");
  }

  public void storeNewWebsiteCred(String username, String password, String website) throws SQLException {

    con = connect();
    stm = con.createStatement();

    String query = "INSERT INTO vault (username, password, WebsiteName) VALUES('" + username + "'," + "'" + password + "'," + "'" + website + "');";

    try {
      stm.execute(query);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        closeConnection();
        stm.close();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }


  }

  public List<Website> getAllWebsites() {
    List<Website> websites = new ArrayList<>();

    try {


      con = connect();
      stm = con.createStatement();
      set = stm.executeQuery("SELECT * FROM vault");

      while (set.next()) {
        websites.add(new Website(set.getString("username"), set.getString("WebsiteName"), set.getString("password")
        ));

      }

      return websites;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    } finally {
      try {
        closeConnection();
        stm.close();
        set.close();
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    return websites;
  }
}
