package DAO;

import Model.Characters;
import Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DaoCharacter implements DaoInterface{
    @Override
    public ObservableList showData() {
        ObservableList<Characters> chList = FXCollections.observableArrayList();
        try {
            String query = "SELECT user.idUser,user.nameUser,user.Point,user.Level,COUNT(monster.idMonster) AS 'totalMonster' FROM user JOIN monster WHERE user.idUser = monster.User_idUser";
            PreparedStatement statement;
            statement = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet result= statement.executeQuery();
            while (result.next()){
                int idChar = result.getInt("user.idUser");
                String nameUser = result.getString("user.nameUser");
                int point = result.getInt("user.Point");
                int level = result.getInt("user.Level");
                int mCount = result.getInt("totalMonster");
                Characters ch = new Characters(nameUser,point,level,mCount);
                Characters cha = new Characters(idChar,ch);
                chList.add(cha);
            }
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return chList;
    }
}
