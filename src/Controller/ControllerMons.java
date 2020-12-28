package Controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    public void actBack(ActionEvent actionEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
    }

    public void actAddMons(ActionEvent actionEvent) {
<<<<<<< Updated upstream
=======
//        DaoMonster daoMonster = new DaoMonster();
//        TextInputDialog dialog = new TextInputDialog();
//        dialog.setTitle("Add Monster");
//        dialog.setHeaderText("Confirmation");
//        dialog.setContentText("Enter your monster name");
//        dialog.showAndWait();
//        if (!dialog.getEditor().getText().equals("")&&dialog.getEditor()!=null) {
//            int result = daoMonster.addData(new Monsters(dialog.getEditor().getText(),0,0,0,0,"","","",""));
//            if (result != 0){
//                System.out.println("Insert Character Berhasil");
//            }
//            ObservableList<Monsters> mList = daoMonster.showData();
//            tblMons.setItems(mList);
//        }
>>>>>>> Stashed changes
    }
}
