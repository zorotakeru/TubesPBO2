package Controller;

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
    public Label costS1;
    public Label costS2;
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
        if (!monsterHp.getText().equals("DIED") && !enemyHp.getText().equals("DIED")) {
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

                    areaInfo.appendText(mList.get(mIndex).getNameMonster() + " attack with " + mList.get(mIndex).getAttMonster() + " damage" + "\n");
                    areaInfo.appendText(mEList.get(mEIndex).getNameMonster() + " attack with " + mEList.get(mEIndex).getAttMonster() + " damage" + "\n");

                    updateP(mList.get(mIndex));
                    updateE(mEList.get(mEIndex));


                } else {
                    System.out.println("Choose enemy monster");
                }
            } else {
                System.out.println("Choose your monster");
            }
        }
    }

    public void actSkill1(ActionEvent actionEvent) {
        double mMastery = skillEff(mList.get(mIndex).getSkill1(), mEList.get(mEIndex).getSkill1());
        double mEMastery = skillEff(mEList.get(mEIndex).getSkill1(), mList.get(mIndex).getSkill1());
        int countP;
        int countE;

        if (!monsterHp.getText().equals("DIED") && !enemyHp.getText().equals("DIED")) {
            if (mIndex != 9999) {
                if (mEIndex != 9999) {
                    countP = (int) (mList.get(mIndex).getHpMonster() - ((mEList.get(mEIndex).getMastery1() * mEMastery) - (mList.get(mIndex).getDefMonster() / 50)));
                    countE = (int) (mEList.get(mEIndex).getHpMonster() - ((mList.get(mIndex).getMastery1() * mMastery) - (mEList.get(mEIndex).getDefMonster() / 50)));
                    if (mEList.get(mEIndex).getMastery1() <= mEList.get(mEIndex).getManaMonster()) {
                        if (countP < 0) {
                            mList.get(mIndex).setHpMonster(0);
                        } else {
                            mList.get(mIndex).setHpMonster(countP);
                        }
                        mEList.get(mEIndex).setManaMonster(mEList.get(mEIndex).getManaMonster() - mEList.get(mEIndex).getMastery1());
                    } else {
                        System.out.println("Enemy mana is not enough");
                    }

                    if (mList.get(mIndex).getMastery1() <= mList.get(mIndex).getManaMonster()) {
                        if (countE < 0) {
                            mEList.get(mEIndex).setHpMonster(0);
                        } else {
                            mEList.get(mEIndex).setHpMonster(countE);
                        }
                        mList.get(mIndex).setManaMonster(mList.get(mIndex).getManaMonster() - mList.get(mIndex).getMastery1());
                    } else {
                        System.out.println("Your mana is not enough for this skill");
                    }


                    areaInfo.appendText(mList.get(mIndex).getNameMonster() + " cast " + mList.get(mIndex).getSkill1() + "\n");
                    areaInfo.appendText(mEList.get(mEIndex).getNameMonster() + " cast " + mEList.get(mEIndex).getSkill1() + "\n");


                } else {
                    System.out.println("Choose enemy monster");
                }
            } else {
                System.out.println("Choose your monster");
            }
            enemyList.setItems(mEList);
            monsterList.setItems(mList);

            updateP(mList.get(mIndex));
            updateE(mEList.get(mEIndex));
        }
    }

    public void actSkill2(ActionEvent actionEvent) {
        double mMastery = skillEff(mList.get(mIndex).getSkill2(), mEList.get(mEIndex).getSkill1());
        double mEMastery = skillEff(mEList.get(mEIndex).getSkill2(), mList.get(mIndex).getSkill1());
        int countP;
        int countE;

        if (!monsterHp.getText().equals("DIED") && !enemyHp.getText().equals("DIED")) {
            if (mIndex != 9999) {
                if (mEIndex != 9999) {
                    countP = (int) (mList.get(mIndex).getHpMonster() - ((mEList.get(mEIndex).getMastery2() * mEMastery) - (mList.get(mIndex).getDefMonster() / 50)));
                    countE = (int) (mEList.get(mEIndex).getHpMonster() - ((mList.get(mIndex).getMastery2() * mMastery) - (mEList.get(mEIndex).getDefMonster() / 50)));
                    if (mEList.get(mEIndex).getMastery2() <= mEList.get(mEIndex).getManaMonster()) {
                        if (countP < 0) {
                            mList.get(mIndex).setHpMonster(0);
                        } else {
                            mList.get(mIndex).setHpMonster(countP);
                        }
                        mEList.get(mEIndex).setManaMonster(mEList.get(mEIndex).getManaMonster() - mEList.get(mEIndex).getMastery1());
                    } else {
                        System.out.println("Enemy mana is not enough");
                    }

                    if (mList.get(mIndex).getMastery2() <= mList.get(mIndex).getManaMonster()) {
                        if (countE < 0) {
                            mEList.get(mEIndex).setHpMonster(0);
                        } else {
                            mEList.get(mEIndex).setHpMonster(countE);
                        }
                        mList.get(mIndex).setManaMonster(mList.get(mIndex).getManaMonster() - mList.get(mIndex).getMastery1());
                    } else {
                        System.out.println("Your mana is not enough for this skill");
                    }

                    areaInfo.appendText(mList.get(mIndex).getNameMonster() + " cast " + mList.get(mIndex).getSkill2() + "\n");
                    areaInfo.appendText(mEList.get(mEIndex).getNameMonster() + " cast " + mEList.get(mEIndex).getSkill2() + "\n");

                } else {
                    System.out.println("Choose enemy monster");
                }
            } else {
                System.out.println("Choose your monster");
            }
            enemyList.setItems(mEList);
            monsterList.setItems(mList);

            updateP(mList.get(mIndex));
            updateE(mEList.get(mEIndex));
        }
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
            costS1.setText(Integer.toString(m.getMastery1()));
            costS2.setText(Integer.toString(m.getMastery2()));


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

    public void winLose(ObservableList<Monsters> list1,ObservableList<Monsters> list2){
        if(list1.get(0).getHpMonster() <= 0 && list1.get(1).getHpMonster() <= 0 && list1.get(2).getHpMonster() <= 0){

        }
    }

    public double skillEff(String elementAtt, String elementDef) {
        double multipler = 0;
        switch (elementAtt) {
            case "Water":
                switch (elementDef) {
                    case "Water":
                        multipler = 1;
                        break;
                    case "Fire":
                        multipler = 2;
                        break;
                    case "Thunder":
                        multipler = 1;
                        break;
                    case "Ice":
                        multipler = 0.5;
                        break;
                    case "Wind":
                        multipler = 0.5;
                        break;
                    case "Ground":
                        multipler = 2;
                        break;
                    case "Steel":
                        multipler = 2;
                        break;
                    case "Poison":
                        multipler = 1;
                        break;
                    case "Light":
                        multipler = 0.5;
                        break;
                    case "Dark":
                        multipler = 1;
                        break;
                }
                break;

            case "Fire":
                switch (elementDef) {
                    case "Water":
                        multipler = 0.5;
                        break;
                    case "Fire":
                        multipler = 1;
                        break;
                    case "Thunder":
                        multipler = 2;
                        break;
                    case "Ice":
                        multipler = 2;
                        break;
                    case "Wind":
                        multipler = 0.5;
                        break;
                    case "Ground":
                        multipler = 0.5;
                        break;
                    case "Steel":
                        multipler = 0.5;
                        break;
                    case "Poison":
                        multipler = 2;
                        break;
                    case "Light":
                        multipler = 2;
                        break;
                    case "Dark":
                        multipler = 1;
                        break;
                }
                break;

            case "Thunder":
                switch (elementDef) {
                    case "Water":
                        multipler = 2;
                        break;
                    case "Fire":
                        multipler = 0.5;
                        break;
                    case "Thunder":
                        multipler = 1;
                        break;
                    case "Ice":
                        multipler = 1;
                        break;
                    case "Wind":
                        multipler = 0.5;
                        break;
                    case "Ground":
                        multipler = 0.5;
                        break;
                    case "Steel":
                        multipler = 2;
                        break;
                    case "Poison":
                        multipler = 2;
                        break;
                    case "Light":
                        multipler = 1;
                        break;
                    case "Dark":
                        multipler = 1;
                        break;
                }
                break;

            case "Ice":
                switch (elementDef) {
                    case "Water":
                        multipler = 1;
                        break;
                    case "Fire":
                        multipler = 0.5;
                        break;
                    case "Thunder":
                        multipler = 0.5;
                        break;
                    case "Ice":
                        multipler = 1;
                        break;
                    case "Wind":
                        multipler = 2;
                        break;
                    case "Ground":
                        multipler = 2;
                        break;
                    case "Steel":
                        multipler = 1;
                        break;
                    case "Poison":
                        multipler = 0.5;
                        break;
                    case "Light":
                        multipler = 1;
                        break;
                    case "Dark":
                        multipler = 2;
                        break;
                }
                break;

            case "Wind":
                switch (elementDef) {
                    case "Water":
                        multipler = 2;
                        break;
                    case "Fire":
                        multipler = 2;
                        break;
                    case "Thunder":
                        multipler = 2;
                        break;
                    case "Ice":
                        multipler = 1;
                        break;
                    case "Wind":
                        multipler = 1;
                        break;
                    case "Ground":
                        multipler = 1;
                        break;
                    case "Steel":
                        multipler = 0.5;
                        break;
                    case "Poison":
                        multipler = 1;
                        break;
                    case "Light":
                        multipler = 0.5;
                        break;
                    case "Dark":
                        multipler = 0.5;
                        break;
                }
                break;

            case "Ground":
                switch (elementDef) {
                    case "Water":
                        multipler = 0.5;
                        break;
                    case "Fire":
                        multipler = 2;
                        break;
                    case "Thunder":
                        multipler = 2;
                        break;
                    case "Ice":
                        multipler = 1;
                        break;
                    case "Wind":
                        multipler = 1;
                        break;
                    case "Ground":
                        multipler = 1;
                        break;
                    case "Steel":
                        multipler = 2;
                        break;
                    case "Poison":
                        multipler = 0.5;
                        break;
                    case "Light":
                        multipler = 1;
                        break;
                    case "Dark":
                        multipler = 0.5;
                        break;
                }
                break;

            case "Steel":
                switch (elementDef) {
                    case "Water":
                        multipler = 1;
                        break;
                    case "Fire":
                        multipler = 1;
                        break;
                    case "Thunder":
                        multipler = 1;
                        break;
                    case "Ice":
                        multipler = 2;
                        break;
                    case "Wind":
                        multipler = 2;
                        break;
                    case "Ground":
                        multipler = 2;
                        break;
                    case "Steel":
                        multipler = 1;
                        break;
                    case "Poison":
                        multipler = 0.5;
                        break;
                    case "Light":
                        multipler = 0.5;
                        break;
                    case "Dark":
                        multipler = 0.5;
                        break;
                }
                break;

            case "Poison":
                switch (elementDef) {
                    case "Water":
                        multipler = 2;
                        break;
                    case "Fire":
                        multipler = 1;
                        break;
                    case "Thunder":
                        multipler = 0.5;
                        break;
                    case "Ice":
                        multipler = 1;
                        break;
                    case "Wind":
                        multipler = 1;
                        break;
                    case "Ground":
                        multipler = 0.5;
                        break;
                    case "Steel":
                        multipler = 0.5;
                        break;
                    case "Poison":
                        multipler = 1;
                        break;
                    case "Light":
                        multipler = 2;
                        break;
                    case "Dark":
                        multipler = 2;
                        break;
                }
                break;

            case "Light":
                switch (elementDef) {
                    case "Water":
                        multipler = 1;
                        break;
                    case "Fire":
                        multipler = 0.5;
                        break;
                    case "Thunder":
                        multipler = 0.5;
                        break;
                    case "Ice":
                        multipler = 2;
                        break;
                    case "Wind":
                        multipler = 1;
                        break;
                    case "Ground":
                        multipler = 0.5;
                        break;
                    case "Steel":
                        multipler = 1;
                        break;
                    case "Poison":
                        multipler = 2;
                        break;
                    case "Light":
                        multipler = 1;
                        break;
                    case "Dark":
                        multipler = 2;
                        break;
                }
                break;

            case "Dark":
                switch (elementDef) {
                    case "Water":
                        multipler = 0.5;
                        break;
                    case "Fire":
                        multipler = 0.5;
                        break;
                    case "Thunder":
                        multipler = 2;
                        break;
                    case "Ice":
                        multipler = 0.5;
                        break;
                    case "Wind":
                        multipler = 2;
                        break;
                    case "Ground":
                        multipler = 1;
                        break;
                    case "Steel":
                        multipler = 1;
                        break;
                    case "Poison":
                        multipler = 1;
                        break;
                    case "Light":
                        multipler = 2;
                        break;
                    case "Dark":
                        multipler = 1;
                        break;
                }
                break;
        }
        return multipler;
    }
}