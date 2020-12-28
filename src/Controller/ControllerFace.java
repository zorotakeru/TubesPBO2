package Controller;

import DAO.DaoCharacter;
import Main.Main;
import Model.Characters;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFace {
    public ComboBox<Characters> comboCharacter;
    public TableView tblMonster;
    public TableColumn colMonsterName;
    public TableColumn colElementPri;
    public TableColumn colElemetSec;
    public Button btnBack;

    public void initialize(){
        DaoCharacter cDao = new DaoCharacter();
        ObservableList<Characters> cList = cDao.showData();
        comboCharacter.setItems(cList);
    }

    public void actFight(ActionEvent actionEvent) throws IOException {
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
}
