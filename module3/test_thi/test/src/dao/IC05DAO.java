package dao;

import model.ClassC05;

import java.sql.SQLException;
import java.util.List;

public interface IC05DAO {
    List<ClassC05> findAll();
    void create(ClassC05 classC05);
    boolean deleteClassC05(String id) throws SQLException;
    boolean updateClassC05(ClassC05 classC05) throws SQLException;
    ClassC05 findById(String id) throws SQLException;
    List<ClassC05> findByName(String name) throws SQLException;

}
