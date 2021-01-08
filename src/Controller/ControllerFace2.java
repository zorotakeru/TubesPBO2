package Controller;

import DAO.DaoCharacter;
import DAO.DaoMonster;
import Main.Main;
import Model.Characters;
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
import Class.*;
import java.io.IOException;
import java.util.Date;

public class ControllerFace2 {
    public ComboBox<Monsters> comboM1;
    public ComboBox<Monsters> comboM2;
    public ComboBox<Monsters> comboM3;
    public Button btnfight;
    public Button btnBack;
    ObservableList<Monsters> mList= FXCollections.observableArrayList();
    ObservableList<Characters> cEList= FXCollections.observableArrayList();
    ObservableList<Monsters> mEList= FXCollections.observableArrayList();
    IOClass io = new IOClass();
    Date date=java.util.Calendar.getInstance().getTime();

    public void initialize(){
        comboM2.setDisable(true);
        comboM3.setDisable(true);
        btnfight.setDisable(true);
    }

    public void actfight(ActionEvent actionEvent) throws IOException {
        randomEnemy();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/PlayPage.fxml"));
        Parent root = loader.load();
        stage.setTitle("Battling Foe");
        stage.setScene(new Scene(root));
        ControllerPlay CP = loader.getController();
        CP.mList.addAll(mList);

        if(mEList.size()>3){
            mEList.remove(3,mEList.size());
        }

        CP.mEList.addAll(mEList);
        stage.showAndWait();
        io.history("User just JOIN THE BATTLE ROOM at "+date);

        Stage stage1 = (Stage) btnBack.getScene().getWindow();
        stage1.close();
    }

    public void actBack(ActionEvent actionEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        io.history("User just a chicken and choosing another player at "+date);
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
        btnfight.setDisable(false);
    }

    public void randomEnemy(){
        DaoCharacter cDao = new DaoCharacter();
        DaoMonster mDao = new DaoMonster();
        cEList = cDao.showData();
        cEList = cDao.showDetail(cEList.get(getRandomNumber(0,cEList.size())).getIdChar());
        mEList = mDao.showDetail(cEList.get(0).getIdChar());
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
