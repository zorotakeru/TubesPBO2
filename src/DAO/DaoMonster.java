package DAO;


import Model.Monsters;
import Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DaoMonster implements DaoInterface{
    @Override
    public ObservableList<Monsters> showData() {
        ObservableList<Monsters> monsList = FXCollections.observableArrayList();
        try {
            String query = "SELECT monster.idMonster AS 'id', monster.nameMonster AS 'name', monster.hpMonster AS 'hpmonsters', monster.manaMonster AS 'mana', monster.attackMonster AS 'att', monster.deffendMonster AS 'deff', s1.skillName AS 'skill1', s2.skillName AS 'skill2', user.nameUser AS 'owner', e1.nameElement AS 'element1', e2.nameElement AS 'element2' FROM monster JOIN user ON monster.User_idUser = user.idUser JOIN element e1 ON monster.Element_idElement1 = e1.idElement JOIN element e2 ON monster.Element_idElement2 = e2.idElement JOIN skill s1 ON monster.skill1Monster = s1.idSkill JOIN skill s2 ON monster.skill2Monster = s2.idSkill";
            PreparedStatement statement;
            statement = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet result= statement.executeQuery();
            while (result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                int hpmonsters = result.getInt("hpmonsters");
                int mana = result.getInt("mana");
                int att = result.getInt("att");
                int deff = result.getInt("deff");
                String owner = result.getString("owner");
                String element1 = result.getString("element1");
                String element2 = result.getString("element2");
                String skill1 = result.getString("skill1");
                String skill2 = result.getString("skill2");
                Monsters mo = new Monsters(name,hpmonsters,mana,att,deff,owner,element1,element2,skill1,skill2);
                Monsters mon = new Monsters(id,mo);
                monsList.add(mon);
            }
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return monsList;
    }

    @Override
    public int addData(Object data) {
        return 0;
    }
}
