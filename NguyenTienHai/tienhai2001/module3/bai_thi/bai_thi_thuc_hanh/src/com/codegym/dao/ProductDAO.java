package com.codegym.dao;

import com.codegym.model.Category;
import com.codegym.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    private static final String SELECT_ALL_PRODUCT ="select* from product;";
    private static final String INSERT_CLASS_PRODUCT_SQL ="insert into product(id,name_product,price,amount,color,`description`, name_category) value(?,?,?,?,?,?,?);";
    private static final String DELETE_CLASS_PRODUCT_SQL ="delete from product where id = ?;";
    private static final String UPDATE_CLASS_PRODUCT_SQL ="update product set name_product=?,price=?,amount=?,color=?,`description`=?, name_category=? where id = ?;";
    private static final String SELECT_CLASS_PRODUCT_BY_ID="select * from product where id =?";
    private static final String SELECT_CLASS_PRODUCT_BY_NAME="select * from product where name_product like ?;";




    @Override
    public List<Product> findAll() {
        List<Product> productList =new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(SELECT_ALL_PRODUCT);
                resultSet=statement.executeQuery();
                while ( resultSet.next() ){
                    int id=resultSet.getInt("id");
                    String name=resultSet.getString("name_product");
                    double price=resultSet.getDouble("price");
                    int amount=resultSet.getInt("amount");
                    String color=resultSet.getString("color");
                    String description=resultSet.getString("description");
                    String category=  resultSet.getString("name_category");
                    productList.add(new Product(id,name,price,amount,color,description,category));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
        return productList;
    }

    @Override
    public void create(Product product) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(INSERT_CLASS_PRODUCT_SQL);
                statement.setInt(1,product.getId());
                statement.setString(2,product.getNameProduct());
                statement.setDouble(3,product.getPrice());
                statement.setInt(4,product.getAmount());
                statement.setString(5,product.getColor());
                statement.setString(6,product.getDescription());
                statement.setString(7,product.getCategory());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CLASS_PRODUCT_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CLASS_PRODUCT_SQL);) {
            statement.setString(1,product.getNameProduct());
            statement.setDouble(2,product.getPrice());
            statement.setInt(3,product.getAmount());
            statement.setString(4,product.getColor());
            statement.setString(5,product.getDescription());
            statement.setString(6,product.getCategory());
            statement.setInt(7,product.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }finally {
            DBConnection.close();
        }
        return rowUpdated;
    }

    @Override
    public Product findById(int id) throws SQLException {
        Product product = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if(connection!=null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_CLASS_PRODUCT_BY_ID);
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while ( resultSet.next() ) {
                    int id1=resultSet.getInt("id");
                    String name=resultSet.getString("name_product");
                    double price=resultSet.getDouble("price");
                    int amount=resultSet.getInt("amount");
                    String color=resultSet.getString("color");
                    String description=resultSet.getString("description");
                    String category=resultSet.getString("name_category");
                    product= new Product(id1,name,price,amount,color,description,category);
                }

            } finally {
                DBConnection.close();
            }
        }
        return product;

    }

    @Override
    public List<Product> findByName(String name) throws SQLException {
        List<Product> productList = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLASS_PRODUCT_BY_NAME))
        {
            preparedStatement.setString(1, "%" + name + "%");
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                int id=resultSet.getInt("id");
                String name1=resultSet.getString("name_product");
                double price=resultSet.getDouble("price");
                int amount=resultSet.getInt("amount");
                String color=resultSet.getString("color");
                String description=resultSet.getString("description");
                String category=resultSet.getString("name_category");
                productList.add(new Product(id,name1,price,amount,color,description,category));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;
    }
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
