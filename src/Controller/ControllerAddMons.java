package Controller;

import DAO.DaoCharacter;
import Model.Characters;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerAddMons {


    public TextField addnamamonsterfield;
    public ComboBox<Characters> ownercmbbox;
    public Button btnback;
    public Button btnok;

    public void initialize(){
        DaoCharacter cDao = new DaoCharacter();
        ObservableList<Characters> cList = cDao.showData();
        ownercmbbox.setItems(cList);
    }

    public void btnback(ActionEvent actionEvent) {
        Stage stage = (Stage) btnback.getScene().getWindow();
        stage.close();
    }

    public void btnok(ActionEvent actionEvent) {

    }
}
