package Controller;

import DAO.DaoCharacter;
import DAO.DaoMonster;
import Main.Main;
import Model.Characters;
import Model.Monsters;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Class.*;
import java.io.IOException;
import java.util.Date;

public class ControllerFace {
    public ComboBox<Characters> comboCharacter;
    public TableView <Monsters> tblMonster;
    public TableColumn <Monsters,String> colMonsterName;
    public TableColumn <Monsters,String> colElementPri;
    public TableColumn <Monsters,String> colElemetSec;
    public Button btnBack;
    public ObservableList<Monsters> monList;
    public Button btnFight;
    public ImageView imgBG;
    IOClass io = new IOClass();
    Date date=java.util.Calendar.getInstance().getTime();

    public void initialize(){
        ImageView iv =  new ImageView(new Image("Img/sword.png") );
        iv.setFitHeight(20);
        iv.setFitWidth(20);
        btnFight.setGraphic(iv);
        imgBG.setImage(new Image("Img/bgMonster.jpg"));
        DaoCharacter cDao = new DaoCharacter();
        ObservableList<Characters> cList = cDao.showData();
        comboCharacter.setItems(cList);
        btnFight.setDisable(true);
    }

    public void actFight(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../View/2ndFace.fxml"));
        Parent root = loader.load();
        stage.setTitle("Choosing monsters");
        stage.setScene(new Scene(root));
        ControllerFace2 cf2 =loader.getController();

        cf2.comboM1.setItems(monList);
        cf2.comboM2.setItems(monList);
        cf2.comboM3.setItems(monList);

        stage.showAndWait();
        io.history("User just Goin to FIGHT at "+date);
    }

    public void actBack(ActionEvent actionEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        io.history("User just a chicken and leaving the battle at "+date);

    }

    public void actCmbChar(ActionEvent actionEvent) {

        DaoMonster daoMonster = new DaoMonster();


        monList = daoMonster.showDetail(comboCharacter.getSelectionModel().getSelectedItem().getIdChar());
        tblMonster.setItems(monList);

        colMonsterName.setCellValueFactory(new PropertyValueFactory<Monsters, String>("nameMonster"));
        colElementPri.setCellValueFactory(new PropertyValueFactory<Monsters, String>("elementName1"));
        colElemetSec.setCellValueFactory(new PropertyValueFactory<Monsters, String>("elementName2"));
        btnFight.setDisable(false);
    }
}
