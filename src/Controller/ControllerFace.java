package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ControllerFace {
    public ComboBox comboCharacter;
    public TableView tblMonster;
    public TableColumn colMonsterName;
    public TableColumn colElementPri;
    public TableColumn colElemetSec;
    public Button btnBack;

    public void actFight(ActionEvent actionEvent) {
    }

    public void actBack(ActionEvent actionEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }
}
