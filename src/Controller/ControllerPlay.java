package Controller;


import DAO.DaoMonster;
import Model.Monsters;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

public class ControllerPlay {

    public ListView<Monsters> monsterList;
    public TextField monsterHp;
    public TextField monsterMana;
    public TextField monsterAttack;
    public TextField monsterDeffend;
    public ListView enemyList;
    public TextField enemyHp;
    public TextField enemyMana;
    public TextField enemyAttack;
    public TextField enemyDeffend;
    public Label monsterElement1;
    public Label monsterElement2;
    public Button btnAttack;
    public Button btnSkill1;
    public Button btnSkill2;
    public Label enemyElement1;
    public Label enemyElement2;
    public TextArea areaInfo;
    ObservableList<Monsters> mList= FXCollections.observableArrayList();

    public void initialize() {

    }

    public void actAttack(ActionEvent actionEvent) {

    }

    public void actSkill1(ActionEvent actionEvent) {

    }

    public void actSkill2(ActionEvent actionEvent) {

    }
}
