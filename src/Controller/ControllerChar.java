package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ControllerChar {
    public TableView tblChar;
    public TableColumn colCharName;
    public TableColumn colCharLevel;
    public TableColumn colCharXP;
    public TableColumn colTotalMonsters;
    public Button btnBack;

    public void actBack(ActionEvent actionEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    public void actAddChar(ActionEvent actionEvent) {
    }


}
