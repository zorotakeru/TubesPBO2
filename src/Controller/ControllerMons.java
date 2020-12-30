package Controller;

import DAO.DaoCharacter;
import DAO.DaoElement;
import DAO.DaoMonster;
import DAO.DaoSkill;
import Main.Main;
import Model.Characters;
import Model.Elements;
import Model.Monsters;
import Model.Skills;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

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

    public void initialize() {
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

    public void actAddMons(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/AddMonster.fxml"));
        Parent root = loader.load();
        stage.setTitle("add monsters");
        stage.setScene(new Scene(root));
        ControllerAddMons addMons = loader.getController();
        stage.showAndWait();


        DaoElement eDao= new DaoElement();
        ObservableList<Elements> eList = eDao.showData();
        System.out.println(eList.size());
        int element1= eList.get(getRandomNumber(0,eList.size())).getIdElement();
        System.out.println(element1);
        int element2= eList.get(getRandomNumber(0,eList.size())).getIdElement();
        System.out.println(element2);

        DaoSkill sDao = new DaoSkill();
        ObservableList<Skills> sList1 = sDao.showDetail(eList.get(element1-1).getIdElement());
        System.out.println(sList1);
        ObservableList<Skills> sList2 = sDao.showDetail(eList.get(element2-1).getIdElement());
        System.out.println(sList2);

        int skill1= sList1.get(getRandomNumber(0,sList1.size())).getIdSkills();
        System.out.println(skill1);
        int skill2= sList2.get(getRandomNumber(0,sList2.size())).getIdSkills();
        System.out.println(skill2);

        DaoMonster daoMonster = new DaoMonster();
        int result = daoMonster.addData(new Monsters(addMons.addnamamonsterfield.getText(), getRandomNumber(100, 2000), getRandomNumber(100, 500), getRandomNumber(50, 200), getRandomNumber(100, 1000), addMons.ownercmbbox.getSelectionModel().getSelectedItem().getIdChar(), "", "", "", "", "",skill1,skill2,element1,element2));

        if (result != 0) {
            System.out.println("Insert Character Berhasil");
        }
        ObservableList<Monsters> mList = daoMonster.showData();
        tblMons.setItems(mList);


    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}