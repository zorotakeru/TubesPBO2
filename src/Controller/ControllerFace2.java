package Controller;

import DAO.DaoMonster;
import Main.Main;
import Model.Monsters;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFace2 {
    public ComboBox<Monsters> comboM1;
    public ComboBox<Monsters> comboM2;
    public ComboBox<Monsters> comboM3;
    public Button btnfight;
    public Button btnBack;
    ObservableList<Monsters> mList= FXCollections.observableArrayList();

    public void initialize(){
        comboM2.setDisable(true);
        comboM3.setDisable(true);

    }

    public void actfight(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/PlayPage.fxml"));
        Parent root = loader.load();
        stage.setTitle("Battling Foe");
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

    public void actBack(ActionEvent actionEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    public void actCmbM1(ActionEvent actionEvent) {
        comboM2.setDisable(false);
        mList.add(new Monsters(comboM1.getSelectionModel().getSelectedItem()));
        comboM1.setDisable(true);
    }

    public void actCmbM2(ActionEvent actionEvent) {
        comboM3.setDisable(false);
        mList.add(new Monsters(comboM2.getSelectionModel().getSelectedItem()));
        comboM2.setDisable(true);
    }

    public void actCmbM3(ActionEvent actionEvent) {
        mList.add(new Monsters(comboM3.getSelectionModel().getSelectedItem()));
        comboM3.setDisable(true);
        System.out.println(mList);
    }
}
