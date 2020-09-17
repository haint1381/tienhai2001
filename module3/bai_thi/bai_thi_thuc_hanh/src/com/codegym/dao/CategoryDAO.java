package com.codegym.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO implements ICategoryDAO {
    private static final String SELECT_ALL_CATEGORY ="select* from category;";

    public List<com.codegym.model.Category> findAllCategory(){
        List<com.codegym.model.Category> categoryList =new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(SELECT_ALL_CATEGORY);
                resultSet=statement.executeQuery();
                while ( resultSet.next() ){
                    String name=resultSet.getString("name_category");
                    categoryList.add(new com.codegym.model.Category(name));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
        return categoryList;
    };
}
