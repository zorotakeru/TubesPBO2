package DAO;

import java.util.List;

public interface DaoInterface<E> {
    public List<E> showData();
    public int addData(E data);
}
