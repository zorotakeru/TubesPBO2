package DAO;


import java.util.List;

import Model.Elements;

import Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import Model.Elements;
import Model.Skills;
import Utility.JDBCConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoElement implements DaoInterface<Elements> {
    @Override

    public ObservableList<Elements> showData() {
        ObservableList<Elements> skList = FXCollections.observableArrayList();
        try {
            String query = "SELECT element.idElement AS 'id' ,element.nameElement AS 'elementname' FROM element";
            PreparedStatement statement;
            statement = JDBCConnection.getConnection().prepareStatement(query);
            ResultSet result= statement.executeQuery();
            while (result.next()){
                int idElement = result.getInt("id");
                String elementName = result.getString("elementname");
                Elements elem = new Elements(idElement, elementName);
                skList.add(elem);
            }
        }
        catch (SQLException exception){
            System.out.println(exception.getMessage());
        }
        return skList;
    }

    @Override
    public int addData(Elements data) {

        return 0;
    }

    @Override
    public ObservableList showDetail(int data) {
        return null;
    }

    @Override
    public int updateData(int data) {
        return 0;
    }
}
