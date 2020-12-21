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
    public ObservableList<Characters> showData() {
        ObservableList<Characters> chList = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM user";
            PreparedStatement statement;
            statement = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet result= statement.executeQuery();
            while (result.next()){
                int idChar = result.getInt("idChar");
                String nameUser = result.getString("colCharName");
                int Point = result.getInt("Point");
                int Level = result.getInt("colCharLevel");
                Characters cha = new Characters(idChar,nameUser, Point,Level);
                chList.add(cha);
            }
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return chList;
    }
}
