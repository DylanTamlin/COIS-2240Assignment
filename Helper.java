

import Models.Website;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Tab;
import javafx.stage.Stage;

import javax.swing.text.TableView;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Helper {

  public static void LoadScene(String fxml) throws IOException, SQLException {
    //Getting the parent file and stage then switching fxml files
    Stage primaryStage = new Stage();
    Parent Login = FXMLLoader.load(Helper.class.getResource(fxml));
    primaryStage.setTitle("Password Manager");
    primaryStage.setScene(new Scene(Login, 550, 550));
    primaryStage.show();

  }


  public static boolean validateUsername(String username) {

    String regex = ("^[A-Za-z]w{5,29}$");


    Pattern p = Pattern.compile(regex);

    if (username == null) {

      return false;
    }

    Matcher m = p.matcher(username);

    return m.matches();

  }

  public static boolean validatePassword(String password) {
    if (!(password.length() < 6)) {
      System.out.println("Password needs to be more that 6");
      return false;
    }


    return true;
  }



//  public static boolean validateLoginUserWithUsername(String username, String password) throws Exception {
//    Database db = new Database();
//
//    ResultSet user = db.select("user", new String[]{"*"}, new String[]{"mUsername"}, new String[]{username}, "AND", new String[]{"="});
//
//    if(user.next()){
//
//      String dbPass = user.getString("mPassword");
//
//      if(!dbPass.equals(password)){
//
//        throw new Exception("Invalid Credentials");
//
//      }
//    }else{
//      throw new Exception("Invalid Credentials");
//    }
//
//    return true;
//  }
}
