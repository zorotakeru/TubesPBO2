package Controller;

import DAO.DaoCharacter;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerChar {
    public TableView<Character> tblChar;
    public TableColumn<Character, String> colCharName;
    public TableColumn<Character, String> colCharLevel;
    public TableColumn<Character, String> colCharXP;
    public TableColumn<Character, String> colTotalMonsters;
    public Button btnBack;
    ObservableList<Character> cList;



    public void initialize(){
        DaoCharacter daoCharacter = new DaoCharacter();
        cList=daoCharacter.showData();
        tblChar.setItems(cList);
        colCharName.setCellValueFactory(new PropertyValueFactory<Character, String>("nameUser"));
        colCharLevel.setCellValueFactory(new PropertyValueFactory<Character, String>("level"));
        colCharXP.setCellValueFactory(new PropertyValueFactory<Character, String>("point"));
        colTotalMonsters.setCellValueFactory(new PropertyValueFactory<Character, String>("totalMonster"));

    }

    public void actBack(ActionEvent actionEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    public void actAddChar(ActionEvent actionEvent) {
    }


}
