package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {


    public void gotoLogin(ActionEvent actionEvent) throws IOException {

        //Using the window to get the stage
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        Helper.LoadScene("Login.fxml");
    }

    public void gotoRegister(ActionEvent actionEvent) throws IOException {
        //Using the window to get the stage
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        Helper.LoadScene("Register.fxml");
    }

    public void GotoRoot(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
        Helper.LoadScene("Root.fxml");
    }

    public void exit(ActionEvent actionEvent) {
        Platform.exit();
    }
}
