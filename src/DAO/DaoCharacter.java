package DAO;

import Model.Characters;
import Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class DaoCharacter implements DaoInterface<Characters>{
    @Override
    public ObservableList<Characters> showData() {
        ObservableList<Characters> chList = FXCollections.observableArrayList();
        try {
            String query = "SELECT user.idUser,user.nameUser,user.Level,COUNT(monster.User_idUser) AS 'totalMonster' FROM user LEFT OUTER JOIN monster ON user.idUser = monster.User_idUser GROUP BY user.idUser,user.nameUser,user.Point,user.Level";
            PreparedStatement statement;
            statement = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet result= statement.executeQuery();
            while (result.next()){
                int idChar = result.getInt("user.idUser");
                String nameUser = result.getString("user.nameUser");
                int level = result.getInt("user.Level");
                int mCount = result.getInt("totalMonster");
                Characters ch = new Characters(nameUser,level,mCount);
                Characters cha = new Characters(idChar,ch);
                chList.add(cha);
            }
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return chList;
    }

    @Override
    public int addData(Characters data) {
        int result = 0;
        try {
            String query = "INSERT INTO user (nameUser,Level) VALUES (?,?)";
            Connection conn = JDBCConnection.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement statement;
            statement = conn.prepareStatement(query);
            statement.setString(1, data.getNameUser());
            statement.setInt(2, 0);
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
    public ObservableList<Characters> showDetail(int data) {
        ObservableList<Characters> chList = FXCollections.observableArrayList();
        try {
            String query = "SELECT user.idUser,user.nameUser,user.Level,COUNT(monster.User_idUser) AS 'totalMonster' FROM user LEFT OUTER JOIN monster ON user.idUser = monster.User_idUser WHERE user.idUser = ? GROUP BY user.idUser,user.nameUser,user.Point,user.Level";
            PreparedStatement statement;
            statement = JDBCConnection.getConnection().prepareStatement(query);
            statement.setInt(1, data);
            ResultSet result= statement.executeQuery();
            while (result.next()){
                int idChar = result.getInt("user.idUser");
                String nameUser = result.getString("user.nameUser");
                int level = result.getInt("user.Level");
                int mCount = result.getInt("totalMonster");
                Characters ch = new Characters(nameUser,level,mCount);
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
