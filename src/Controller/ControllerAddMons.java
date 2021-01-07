package Controller;

import DAO.DaoCharacter;
import Model.Characters;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import Class.*;
import javafx.stage.Stage;

import java.util.Date;

public class ControllerAddMons {
    public TextField addnamamonsterfield;
    public ComboBox<Characters> ownercmbbox;
    public Button btnback;
    public Button btnok;
    IOClass io = new IOClass();
    Date date=java.util.Calendar.getInstance().getTime();

    public void initialize(){
        DaoCharacter cDao = new DaoCharacter();
        ObservableList<Characters> cList = cDao.showData();
        ownercmbbox.setItems(cList);
    }

    public void actbtnback(ActionEvent actionEvent) {

        Stage stage = (Stage) btnback.getScene().getWindow();
        stage.close();
        io.history("User just cancel to add a monster at "+date);
    }

    public void actbtnok(ActionEvent actionEvent) {
        System.out.println(ownercmbbox.getSelectionModel().getSelectedItem());
        System.out.println(addnamamonsterfield.getText());
        if (ownercmbbox.getSelectionModel().getSelectedItem() != null && !addnamamonsterfield.getText().equals("")) {
            Stage stage = (Stage) btnok.getScene().getWindow();
            stage.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error");
            alert.setContentText("Chose the character");
            alert.showAndWait();
        }
    }
}
