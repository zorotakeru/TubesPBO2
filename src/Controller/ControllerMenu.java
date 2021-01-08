package Controller;

import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import Class.*;
import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ControllerMenu {
    public Button btnExit;
    IOClass io = new IOClass();
    Date date=java.util.Calendar.getInstance().getTime();

    public void actPlay(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/1stFace.fxml"));
        Parent root = loader.load();
        stage.setTitle("Let's Play");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        io.history("User just press Play Button at "+date);
    }

    public void actListMons(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/Monsters.fxml"));
        Parent root = loader.load();
        stage.setTitle("Monsters");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        io.history("User just press Monster Button to see all Monsters at "+date);
    }

    public void actListChar(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/Characters.fxml"));
        Parent root = loader.load();
        stage.setTitle("Characters");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        io.history("User just press Character Button to see all Characters at "+date);
    }

    public void actExit(ActionEvent actionEvent) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();io.history("User just press Exit Button and it's time to rest and the time is "+date);
    }

    public void actLogFile(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/History.fxml"));
        Parent root = loader.load();
        stage.setTitle("History");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        io.history("User just press Log Button to see Me!? at"+date);
    }



}
