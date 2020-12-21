package DAO;

import Model.Characters;
import Model.Monsters;
import Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoMonster implements DaoInterface{
    @Override
    public ObservableList<Monsters> showData() {
        ObservableList<Monsters> monsList = FXCollections.observableArrayList();
        try {
            String query = "SELECT monster.idMonster AS 'id', monster.nameMonster AS 'name', monster.hpMonster AS 'hpmonsters', monster.manaMonster AS 'mana', monster.attackMonster AS 'att', monster.deffendMonster AS 'deff', monster.skill1Monster AS 'skill1', monster.skill2Monster AS 'skill2', user.nameUser AS 'owner'FROM monster JOIN user ON monster.User_idUser = user.idUser JOIN element ON monster.Element_idElement1 = element.idElement JOIN element ON monster.Element_idElement2 = element.idElement";
            PreparedStatement statement;
            statement = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet result= statement.executeQuery();
            while (result.next()){
                int id = result.getInt("monsters.idMonster");
                String name = result.getString("monster.nameMonster");
                int hpmonsters = result.getInt("monster.hpMonster");
                int mana = result.getInt("monster.manaMonster");
                int att = result.getInt("monster.attackMonster");
                int deff = result.getInt("monster.deffendMonster");
                String skill1 = result.getString("monster.skill1Monster");
                String skill2 = result.getString("monster.skill2Monster");
                String owner = result.getString("user.nameUser");
                Monsters mon = new Monsters(id, name, hpmonsters, mana, att, deff, skill1, skill2, owner);
                monsList.add(mon);
            }
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return monsList;
    }
}
