package DAO;


import Model.Monsters;
import Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DaoMonster implements DaoInterface<Monsters>{
    @Override
    public ObservableList<Monsters> showData() {
        ObservableList<Monsters> monsList = FXCollections.observableArrayList();
        try {
            String query = "SELECT monster.idMonster AS 'id', monster.nameMonster AS 'name', monster.hpMonster AS 'hpmonsters', monster.manaMonster AS 'mana', monster.attackMonster AS 'att', monster.deffendMonster AS 'deff',monster.skill1Monster as 'idSkill1', s1.skillName AS 'skill1',monster.skill2Monster as 'idSkill2', s2.skillName AS 'skill2',monster.User_idUser AS 'idUser', user.nameUser AS 'owner',monster.Element_idElement1 AS 'idElement1', e1.nameElement AS 'element1',monster.Element_idElement2 AS 'idElement2', e2.nameElement AS 'element2' FROM monster JOIN user ON monster.User_idUser = user.idUser JOIN element e1 ON monster.Element_idElement1 = e1.idElement JOIN element e2 ON monster.Element_idElement2 = e2.idElement JOIN skill s1 ON monster.skill1Monster = s1.idSkill JOIN skill s2 ON monster.skill2Monster = s2.idSkill";

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
                int idUser = result.getInt("idUser");
                int idSkill1 = result.getInt("idSkill1");
                int idSkill2 = result.getInt("idSkill2");
                int idElement1 = result.getInt("idElement1");
                int idElement2 = result.getInt("idElement2");
                String owner = result.getString("owner");
                String element1 = result.getString("element1");
                String element2 = result.getString("element2");
                String skill1 = result.getString("skill1");
                String skill2 = result.getString("skill2");
                Monsters mo = new Monsters(name,hpmonsters,mana,att,deff,idUser,owner,element1,element2,skill1,skill2,idSkill1,idSkill2,idElement1,idElement2);
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
    public int addData(Monsters data) {
        int result = 0;
        try {
            String query = "INSERT INTO monster (nameMonster,hpMonster,manaMonster,attackMonster,deffendMonster,User_idUser,Element_idElement1,Element_idElement2,skill1Monster,skill2Monster) VALUES (?,?,?,?,?,?,?,?,?,?)";
            Connection conn = JDBCConnection.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement statement;
            statement = conn.prepareStatement(query);
            statement.setString(1, data.getNameMonster());
            statement.setInt(2, data.getHpMonster());
            statement.setInt(3, data.getManaMonster());
            statement.setInt(4, data.getAttMonster());
            statement.setInt(5, data.getDefMonster());
            statement.setInt(6, data.getIdUser());
            statement.setInt(7, data.getIdElement1());
            statement.setInt(8, data.getIdElement2());
            statement.setInt(9, data.getIdSkill1());
            statement.setInt(10, data.getIdSkill2());
            result = statement.executeUpdate();
            if(result != 0){
                conn.commit();
            }
            else {
                conn.rollback();
            }
        }
        catch (SQLException exception){
            System.out.println(exception);
        }
        return result;
    }

    @Override
    public ObservableList<Monsters> showDetail(int data) {
        ObservableList<Monsters> monsList = FXCollections.observableArrayList();
        try {
            String query = "SELECT monster.idMonster AS 'id', monster.nameMonster AS 'name', monster.hpMonster AS 'hpmonsters', monster.manaMonster AS 'mana', monster.attackMonster AS 'att', monster.deffendMonster AS 'deff',monster.skill1Monster as 'idSkill1', s1.skillName AS 'skill1',monster.skill2Monster as 'idSkill2', s2.skillName AS 'skill2',monster.User_idUser AS 'idUser', user.nameUser AS 'owner',monster.Element_idElement1 AS 'idElement1', e1.nameElement AS 'element1',monster.Element_idElement2 AS 'idElement2', e2.nameElement AS 'element2' FROM monster JOIN user ON monster.User_idUser = user.idUser JOIN element e1 ON monster.Element_idElement1 = e1.idElement JOIN element e2 ON monster.Element_idElement2 = e2.idElement JOIN skill s1 ON monster.skill1Monster = s1.idSkill JOIN skill s2 ON monster.skill2Monster = s2.idSkill WHERE monster.User_idUser = ?";
            PreparedStatement statement;
            statement = JDBCConnection.getConnection().prepareStatement(query);
            statement.setInt(1, data);
            ResultSet result= statement.executeQuery();
            while (result.next()){
                int id = result.getInt("id");
                String name = result.getString("name");
                int hpmonsters = result.getInt("hpmonsters");
                int mana = result.getInt("mana");
                int att = result.getInt("att");
                int deff = result.getInt("deff");
                int idUser = result.getInt("idUser");
                int idSkill1 = result.getInt("idSkill1");
                int idSkill2 = result.getInt("idSkill2");
                int idElement1 = result.getInt("idElement1");
                int idElement2 = result.getInt("idElement2");
                String owner = result.getString("owner");
                String element1 = result.getString("element1");
                String element2 = result.getString("element2");
                String skill1 = result.getString("skill1");
                String skill2 = result.getString("skill2");
                Monsters mo = new Monsters(name,hpmonsters,mana,att,deff,idUser,owner,element1,element2,skill1,skill2,idSkill1,idSkill2,idElement1,idElement2);
                Monsters mon = new Monsters(id,mo);
                monsList.add(mon);
            }
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return monsList;
    }
}
