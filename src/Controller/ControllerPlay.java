package Controller;


import DAO.DaoMonster;
import Model.Monsters;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    public ListView<Monsters> enemyList;
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
    ObservableList<Monsters> mEList= FXCollections.observableArrayList();


    public void initialize() {
        enemyList.setItems(mEList);
        selectEnemyMonster();
        monsterList.setItems(mList);
        selectMonster();
        monsterHp.setEditable(false);
        monsterMana.setEditable(false);
        monsterAttack.setEditable(false);
        monsterDeffend.setEditable(false);
        enemyHp.setEditable(false);
        enemyMana.setEditable(false);
        enemyAttack.setEditable(false);
        enemyDeffend.setEditable(false);
    }

    public void actAttack(ActionEvent actionEvent) {

    }

    public void actSkill1(ActionEvent actionEvent) {

    }

    public void actSkill2(ActionEvent actionEvent) {

    }

    public void selectMonster(){
        monsterList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Monsters>() {
            @Override
            public void changed(ObservableValue<? extends Monsters> observable, Monsters oldValue, Monsters newValue) {
                monsterHp.setText(Integer.toString(newValue.getHpMonster()));
                monsterMana.setText(Integer.toString(newValue.getManaMonster()));
                monsterAttack.setText(Integer.toString(newValue.getAttMonster()));
                monsterDeffend.setText(Integer.toString(newValue.getDefMonster()));
                monsterElement1.setText(newValue.getElementName1());
                monsterElement2.setText(newValue.getElementName2());
                btnSkill1.setText(newValue.getSkill1());
                btnSkill2.setText(newValue.getSkill2());
            }
        });
    }


    public void selectEnemyMonster(){
        enemyList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Monsters>() {
            @Override
            public void changed(ObservableValue<? extends Monsters> observable, Monsters oldValue, Monsters newValue) {
                enemyHp.setText(Integer.toString(newValue.getHpMonster()));
                enemyMana.setText(Integer.toString(newValue.getManaMonster()));
                enemyAttack.setText(Integer.toString(newValue.getAttMonster()));
                enemyDeffend.setText(Integer.toString(newValue.getDefMonster()));
                enemyElement1.setText(newValue.getElementName1());
                enemyElement2.setText(newValue.getElementName2());
            }
        });
    }


}
