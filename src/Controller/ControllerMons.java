package Controller;

import DAO.DaoCharacter;
import DAO.DaoMonster;
import Model.Monsters;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ControllerMons {
    public TableView<Monsters> tblMons;
    public TableColumn<Monsters, String> colmMonsName;
    public TableColumn<Monsters, String> colElementPri;
    public TableColumn<Monsters, String> colElementSec;
    public TableColumn<Monsters, String> colHP;
    public TableColumn<Monsters, String> colMana;
    public TableColumn<Monsters, String> colAtk;
    public TableColumn<Monsters, String> colDef;
    public TableColumn<Monsters, String> colSkill1;
    public TableColumn<Monsters, String> colSkill2;
    public TableColumn<Monsters, String> colOwner;
    public Button btnBack;
    ObservableList<Monsters> monList;

    public void initialize(){
        DaoMonster daoMonster = new DaoMonster();
        monList = daoMonster.showData();
        tblMons.setItems(monList);
        colmMonsName.setCellValueFactory(new PropertyValueFactory<Monsters, String>("nameMonster"));
        colHP.setCellValueFactory(new PropertyValueFactory<Monsters, String>("hpMonster"));
        colMana.setCellValueFactory(new PropertyValueFactory<Monsters, String>("manaMonster"));
        colAtk.setCellValueFactory(new PropertyValueFactory<Monsters, String>("attMonster"));
        colDef.setCellValueFactory(new PropertyValueFactory<Monsters, String>("defMonster"));
        colOwner.setCellValueFactory(new PropertyValueFactory<Monsters, String>("userName"));
        colElementPri.setCellValueFactory(new PropertyValueFactory<Monsters, String>("elementName1"));
        colElementSec.setCellValueFactory(new PropertyValueFactory<Monsters, String>("elementName2"));
        colSkill1.setCellValueFactory(new PropertyValueFactory<Monsters, String>("skill1"));
        colSkill2.setCellValueFactory(new PropertyValueFactory<Monsters, String>("skill2"));

    }

    public void actBack(ActionEvent actionEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    public void actAddMons(ActionEvent actionEvent) {

    }
}
