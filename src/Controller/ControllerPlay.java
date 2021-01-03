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
    public TextField monsterDefend;
    public ListView<Monsters> enemyList;
    public TextField enemyHp;
    public TextField enemyMana;
    public TextField enemyAttack;
    public TextField enemyDefend;
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

    int mIndex;
    int mEIndex;


    public void initialize() {
        System.out.println(mEList);

        enemyList.setItems(mEList);
        selectEnemyMonster();
        monsterList.setItems(mList);
        selectMonster();
        monsterHp.setEditable(false);
        monsterMana.setEditable(false);
        monsterAttack.setEditable(false);
        monsterDefend.setEditable(false);
        enemyHp.setEditable(false);
        enemyMana.setEditable(false);
        enemyAttack.setEditable(false);
        enemyDefend.setEditable(false);

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
                monsterDefend.setText(Integer.toString(newValue.getDefMonster()));
                monsterElement1.setText(newValue.getElementName1());
                monsterElement2.setText(newValue.getElementName2());
                btnSkill1.setText(newValue.getSkill1());
                btnSkill2.setText(newValue.getSkill2());
                mIndex = monsterList.getSelectionModel().getSelectedIndex();
                System.out.println(mIndex);
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
                enemyDefend.setText(Integer.toString(newValue.getDefMonster()));
                enemyElement1.setText(newValue.getElementName1());
                enemyElement2.setText(newValue.getElementName2());
                mEIndex = enemyList.getSelectionModel().getSelectedIndex();
                System.out.println(mEIndex);
            }
        });
    }


}
