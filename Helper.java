package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Helper   {

    public static void LoadScene(String fxml) throws IOException {
        Stage primaryStage = new Stage();
        Parent Login = FXMLLoader.load(Helper.class.getResource(fxml));
        primaryStage.setTitle("Password Manager");
        primaryStage.setScene(new Scene(Login, 500, 500));
        primaryStage.show();

    }


}
