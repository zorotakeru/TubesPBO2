package DAO;

import Model.Element;
import javafx.collections.ObservableList;

import java.util.List;

public class DaoElement implements DaoInterface<Element> {
    @Override
    public ObservableList showData() {
        return null;
    }

    @Override
    public int addData(Element data) {

        return 0;
    }

    @Override
    public ObservableList showDetail(int data) {

        return null;
    }
}
