

import Models.Person;
import Models.Website;
import javafx.application.Platform;
import javafx.beans.binding.When;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Controller {

  Database db = new Database();

  @FXML
  private TableView tableView;

  @FXML
  private TextField RegisterUsername;
  @FXML
  private TextField RegisterPassword;
  @FXML
  private Button SendRegister;
  @FXML
  private Button RegisterBack;

  @FXML
  private TextField LoginUsername;
  @FXML
  private TextField LoginPassword;
  @FXML
  private Button LoginLogin;
  @FXML
  private Button LoginBack;


  @FXML
  private TextField MainWebsite;
  @FXML
  private TextField MainUsername;
  @FXML
  private TextField MainPassword;

  @FXML
  private Button RootLogin;
  @FXML
  private Button RootRegister;
  @FXML
  private Button RootQuit;


  //When Register button in Register is clicked

//  public void gotoLogin() {
//    System.out.println("Go To Login");
////    try {
////
////      db.CreateVaultTable();
////    } catch (Exception e) {
////      System.out.println(e.getMessage());
////    }
//
//    boolean valid = true;
//
//
//    Alert a = new Alert(Alert.AlertType.ERROR);
//    Alert b = new Alert(Alert.AlertType.CONFIRMATION);
//
//
//    //Validate Register Username using regex called
//    String user = RegisterUsername.getText();
//    if (Helper.validateUsername(user) == false) {
//      a.setAlertType(Alert.AlertType.ERROR);
//      a.setContentText("The Username is Invalid: Please only use Characters [A-Z/a-z]");
//      a.show();
//      valid = false;
//    } else {
//
//      System.out.println("The username is valid");
//    }
//    //Validate Register password
//    String pass = RegisterPassword.getText();
//    if (Helper.validatePassword(pass) == false) {
//
//      a.setAlertType(Alert.AlertType.ERROR);
//      a.setContentText("The password is invalid: Must include at least one; Capital and Lowercase Charatcer/Number/Special Character");
//      a.show();
//      valid = false;
//    } else {
//
//      System.out.println("The password is valid.");
//    }
//
//    if (valid == true) {
//      //Code to go to Login goes in here
//      SendRegister.setDisable(true);
//
////            Database.InsertVaultRecord(user, pass);
//
//      b.setAlertType(Alert.AlertType.CONFIRMATION);
//
//      b.setContentText("Register Successful!");
//
//      b.show();
//
//    }
//  }


  public void Testing() {
    System.out.println("Testing The app");
  }

  //When the Login button in Login is clicked
//  public void GotoMain() {
//
//
//    System.out.println("Got To Main");
//
////        Database.CreateVaultTable(Database.Connect());
//
//    boolean valid = true;
//
//    Alert a = new Alert(Alert.AlertType.ERROR);
//    Alert b = new Alert(Alert.AlertType.CONFIRMATION);
//
//    //Validate Login Username using regex called
//    String user = LoginUsername.getText();
//    if (Helper.validateUsername(user) == false) {
//      a.setAlertType(Alert.AlertType.ERROR);
//      a.setContentText("The Username is Invalid: Please only use characters");
//      a.show();
//      valid = false;
//    } else {
//
//      System.out.println("The username is valid");
//    }
//  }

  public void gotoLogin(ActionEvent actionEvent) throws IOException, SQLException {
    System.out.println("Go To Login With Action Event");

    //Using the window to get the stage and closing previous file and  loading the next fxml file
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    stage.close();
    Helper.LoadScene("/Login.fxml");
  }

  public void gotoRegister(ActionEvent actionEvent) throws IOException, SQLException {
    System.out.println("Go To Register");

    //Using the window to get the stage and closing previous file and  loading the next fxml file
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    stage.close();
    Helper.LoadScene("/Register.fxml");
  }

  public void GotoRoot(ActionEvent actionEvent) throws IOException, SQLException {
    System.out.println("Go To Root");

    //Using the window to get the stage and closing previous file and  loading the next fxml file
    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
    stage.close();
    Helper.LoadScene("/Root.fxml");
  }

  public void GotoMain(ActionEvent actionEvent) throws Exception {
    System.out.println(LoginUsername.getText());


    String username = LoginUsername.getText();
    String password = LoginPassword.getText();


    try {

      Database db = new Database();



      //Using the window to get the stage and closing previous file and  loading the next fxml file
      Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
      stage.close();
      Helper.LoadScene("/Main.fxml");

      db.validateLogin(username, password);


//      List<Website> websites = db.getAllWebsites();
//
//      ObservableList<Website> data = tableView.getItems();
//      for (Website web: websites) {data.add(web);}
//
//      MainPassword.setText("");
//      MainWebsite.setText("");
//      MainUsername.setText("");


    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void exit(ActionEvent actionEvent) {
    //Exiting from the program
    Platform.exit();
  }

  public void StorePassword(ActionEvent actionEvent) {

    String password = MainPassword.getText();
    String website = MainWebsite.getText();
    String username = MainUsername.getText();

    Database db = new Database();
    try{
      db.storeNewWebsiteCred(username, password, website);

      ObservableList<Website> data = tableView.getItems();

      data.add(new Website(website,username,password));

      MainPassword.setText("");
      MainWebsite.setText("");
      MainUsername.setText("");

    }catch (Exception e){
      System.out.println(e.getMessage());
    }

  }
}




















  /*
  //
//    String pass = LoginPassword.getText();
//
//        if(Helper.validatePassword(pass) == false){
//
//        a.setAlertType(Alert.AlertType.ERROR);
//        a.setContentText("The password is invalid: Must include at least one; Capital and Lowercase Charatcer/Number/Special Character");
//        a.show();
//        valid = false;
//    }else{
//
//        System.out.println("The password is valid.");
//
//
//        if (valid == true) {
//            //Code to go to main goes in here
//            LoginLogin.setDisable(true);
//            Database.insert(Database.Connect(), user, pass, WebsiteName);
//            b.setAlertType(Alert.AlertType.CONFIRMATION);
//            b.setContentText("Register Successful!");
//            b.show();
//        }
//
//
//
//
//        /*public void SendReg () {
//
//
//        try {
//
//            Database.CreateUserTable(Database.connect());
//
//            String mUsername = RegisterUsername.getText();
//            String mPassword = RegisterPassword.getText();
//
//            Database.InsertUserRecord(Database.connect(), mUsername, mPassword);
//
//
//        } catch (SQLException e) {
//
//            System.out.println("Error " + e.getMessage());
//
//
//        }
//
//
//    }/*
//
//       /* public void submitToVault {
//        try {
//            Database.connect();
//
//            String username = MainUsername.getText();
//            String password = MainPassword.getText();
//            String WebsiteName = MainWebsite.getText();
//
//
//        } catch (SQLException e) {
//            System.out.println("Error " + e.getMessage());
//
//        }*/
//
//
//    }
//    }*/
