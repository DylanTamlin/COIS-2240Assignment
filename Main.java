
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

       URL some = getClass().getResource("/Root.fxml");

        Parent root = FXMLLoader.load(getClass().getResource("/Root.fxml"));
        primaryStage.setTitle("Password Manager");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) throws SQLException {
      launch(args);
    }


}
