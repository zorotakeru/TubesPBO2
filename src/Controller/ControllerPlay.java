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
    ObservableList<Monsters> mList = FXCollections.observableArrayList();
    ObservableList<Monsters> mEList = FXCollections.observableArrayList();

    int mIndex = 9999;
    int mEIndex = 9999;

    public void initialize() {

        enemyList.setItems(mEList);
        monsterList.setItems(mList);
        selectEnemyMonster();
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
        int countP;
        int countE;
        if(!monsterHp.getText().equals("DIED") && !enemyHp.getText().equals("DIED")) {
            if (mIndex != 9999) {
                if (mEIndex != 9999) {
                    countP = mList.get(mIndex).getHpMonster() - (mEList.get(mEIndex).getAttMonster() - (mList.get(mIndex).getDefMonster() / 50));
                    countE = mEList.get(mEIndex).getHpMonster() - (mList.get(mIndex).getAttMonster() - (mEList.get(mEIndex).getDefMonster() / 50));
                    if (countP < 0) {
                        mList.get(mIndex).setHpMonster(0);
                    } else {
                        mList.get(mIndex).setHpMonster(countP);
                    }

                    if (countE < 0) {
                        mEList.get(mEIndex).setHpMonster(0);
                    } else {
                        mEList.get(mEIndex).setHpMonster(countE);
                    }

                    enemyList.setItems(mEList);
                    monsterList.setItems(mList);

                    updateP(mList.get(mIndex));
                    updateE(mEList.get(mEIndex));
                } else {
                    System.out.println("Choose enemy monster");
                }
            } else {
                System.out.println("Choose your monster");
            }
        }

        System.out.println(mList.get(mIndex).getHpMonster());
        System.out.println(mEList.get(mEIndex).getHpMonster());
    }

    public void actSkill1(ActionEvent actionEvent) {

    }

    public void actSkill2(ActionEvent actionEvent) {

    }

    public void selectMonster() {
        monsterList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Monsters>() {
            @Override
            public void changed(ObservableValue<? extends Monsters> observable, Monsters oldValue, Monsters newValue) {
                updateP(newValue);
                mIndex = monsterList.getSelectionModel().getSelectedIndex();
                System.out.println(mIndex);
            }
        });
    }


    public void selectEnemyMonster() {
        enemyList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Monsters>() {
            @Override
            public void changed(ObservableValue<? extends Monsters> observable, Monsters oldValue, Monsters newValue) {
                updateE(newValue);
                mEIndex = enemyList.getSelectionModel().getSelectedIndex();
                System.out.println(mEIndex);
            }
        });
    }

    public void updateP(Monsters m) {
        if (m.getHpMonster() > 0) {
            monsterHp.setText(Integer.toString(m.getHpMonster()));
            monsterMana.setText(Integer.toString(m.getManaMonster()));
            monsterAttack.setText(Integer.toString(m.getAttMonster()));
            monsterDefend.setText(Integer.toString(m.getDefMonster()));
            monsterElement1.setText(m.getElementName1());
            monsterElement2.setText(m.getElementName2());
            btnSkill1.setText(m.getSkill1());
            btnSkill2.setText(m.getSkill2());


        } else {
            monsterHp.setText("DIED");
            monsterMana.setText("DIED");
            monsterAttack.setText("DIED");
            monsterDefend.setText("DIED");
            monsterElement1.setText("DIED");
            monsterElement2.setText("DIED");
            btnSkill1.setText("DIED");
            btnSkill2.setText("DIED");
        }
    }

    public void updateE(Monsters mE) {
        if (mE.getHpMonster() > 0) {
            enemyHp.setText(Integer.toString(mE.getHpMonster()));
            enemyMana.setText(Integer.toString(mE.getManaMonster()));
            enemyAttack.setText(Integer.toString(mE.getAttMonster()));
            enemyDefend.setText(Integer.toString(mE.getDefMonster()));
            enemyElement1.setText(mE.getElementName1());
            enemyElement2.setText(mE.getElementName2());

        } else {
            enemyHp.setText("DIED");
            enemyMana.setText("DIED");
            enemyAttack.setText("DIED");
            enemyDefend.setText("DIED");
            enemyElement1.setText("DIED");
            enemyElement2.setText("DIED");
        }
    }
}