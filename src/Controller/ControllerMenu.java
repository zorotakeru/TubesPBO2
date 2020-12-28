package Controller;

import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMenu {
    public Button btnExit;

    public void actPlay(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/1stFace.fxml"));
        Parent root = loader.load();
        stage.setTitle("Let's Play");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public void actListMons(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/Monsters.fxml"));
        Parent root = loader.load();
        stage.setTitle("Monsters");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public void actListChar(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/Characters.fxml"));
        Parent root = loader.load();
        stage.setTitle("Characters");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public void actExit(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void actLogFile(ActionEvent actionEvent) {

    }
}
