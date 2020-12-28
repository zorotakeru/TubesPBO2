package DAO;

import Model.Characters;
import Model.Skills;
import Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoSkill implements DaoInterface<Skills> {

    @Override
    public ObservableList<Skills> showData() {
        ObservableList<Skills> skList = FXCollections.observableArrayList();
        try {
            String query = "SELECT skill.idSkill AS 'id' ,skill.skillName AS 'skillname', skill.elementalMastery AS 'elemastery', ele.nameElement AS 'element' FROM skill JOIN element ele ON skill.Element_idElement = ele.idElement";
            PreparedStatement statement;
            statement = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet result= statement.executeQuery();
            while (result.next()){
                int idSkill = result.getInt("id");
                String skillname = result.getString("skillname");
                int elementmastery = result.getInt("elemastery");
                String element = result.getString("element");
                Skills sk = new Skills(skillname,elementmastery,element);
                Skills ski = new Skills(idSkill,sk);
                skList.add(ski);
            }
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return skList;
    }

    @Override
    public int addData(Skills data) {
        return 0;
    }

    @Override
    public ObservableList showDetail(int data) {
        return null;
    }
}
