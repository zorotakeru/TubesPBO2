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
    public TableView tblMons;
    public TableColumn colmMonsName;
    public TableColumn colElementPri;
    public TableColumn colElementSec;
    public TableColumn colHP;
    public TableColumn colMana;
    public TableColumn colAtk;
    public TableColumn colDef;
    public TableColumn colSkill1;
    public TableColumn colSkill2;
    public TableColumn colSkillPsv;
    public TableColumn colSkillUlt;
    public TableColumn colOwner;
    public Button btnBack;
    ObservableList<Monsters> monList;

    public void initialize(){
        DaoMonster daoMonster = new DaoMonster();
        monList = daoMonster.showData();
        tblMons.setItems(monList);
        colmMonsName.setCellValueFactory(new PropertyValueFactory<Monsters, String>("nameMonster"));
        colHP.setCellValueFactory(new PropertyValueFactory<Character, String>("hpMonster"));
        colMana.setCellValueFactory(new PropertyValueFactory<Character, String>("manaMonster"));
        colAtk.setCellValueFactory(new PropertyValueFactory<Character, String>("attackMonster"));
        colDef.setCellValueFactory(new PropertyValueFactory<Character, String>("deffendMonster"));
        colSkill1.setCellValueFactory(new PropertyValueFactory<Character, String>("skill1Monster"));
        colSkill2.setCellValueFactory(new PropertyValueFactory<Character, String>("skill1Monster"));
        colOwner.setCellValueFactory(new PropertyValueFactory<Character, String>("User_idUser"));
    }

    public void actBack(ActionEvent actionEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    public void actAddMons(ActionEvent actionEvent) {
    }
}
