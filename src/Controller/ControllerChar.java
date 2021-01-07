package Controller;

import DAO.DaoCharacter;
import Model.Characters;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import Class.*;
import java.util.Date;

public class ControllerChar {
    public TableView<Characters> tblChar;
    public TableColumn<Characters, String> colCharName;
    public TableColumn<Characters, String> colCharLevel;
    public TableColumn<Characters, String> colTotalMonsters;
    public Button btnBack;
    ObservableList<Characters> cList;
    IOClass io = new IOClass();
    Date date=java.util.Calendar.getInstance().getTime();

    public void initialize(){
        DaoCharacter daoCharacter = new DaoCharacter();
        cList=daoCharacter.showData();
        tblChar.setItems(cList);
        colCharName.setCellValueFactory(new PropertyValueFactory<Characters, String>("nameUser"));
        colCharLevel.setCellValueFactory(new PropertyValueFactory<Characters, String>("level"));
        colTotalMonsters.setCellValueFactory(new PropertyValueFactory<Characters, String>("totalMonster"));
    }

    public void actBack(ActionEvent actionEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        stage.close();
        io.history("User just Back from characters page at "+date);
    }

    public void actAddChar(ActionEvent actionEvent) {
        DaoCharacter daoCharacter = new DaoCharacter();
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Character");
        dialog.setHeaderText("Confirmation");
        dialog.setContentText("Enter your name");
        dialog.showAndWait();
        if (!dialog.getEditor().getText().equals("")&&dialog.getEditor()!=null) {
            int result = daoCharacter.addData(new Characters(dialog.getEditor().getText(),0,0));
            if (result != 0){
                System.out.println("Insert Character Berhasil");
            }
            ObservableList<Characters> cList = daoCharacter.showData();
            tblChar.setItems(cList);
            io.history("User just add a character with name "+dialog.getEditor().getText()+" at "+date);
        }

    }
}
