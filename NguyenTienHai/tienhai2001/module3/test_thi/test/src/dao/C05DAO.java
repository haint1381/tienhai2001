package dao;

import model.ClassC05;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class C05DAO implements IC05DAO {
    private static final String SELECT_ALL_CLASS_CO5 ="select* from c05";
    private static final String INSERT_CLASS_CO5_SQL ="insert into c05(id,full_name,birthday,gender) value(?,?,?,?)";
    private static final String DELETE_CLASS_CO5_SQL ="delete delete from co5 where id = ?;";
    private static final String UPDATE_CLASS_CO5_SQL ="";
    private static final String SELECT_CLASS_CO5_BY_ID="";
    private static final String SELECT_CLASS_CO5_BY_NAME="";

    @Override
    public List<ClassC05> findAll() {
        List<ClassC05> classC05List =new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(SELECT_ALL_CLASS_CO5);
                resultSet=statement.executeQuery();
                while ( resultSet.next() ){
                    String id=resultSet.getString("id");
                    String name=resultSet.getString("name");
                    String birthday=resultSet.getString("birthday");
                    String gender=resultSet.getString("gender");
                    classC05List.add(new ClassC05(id,name,birthday,gender));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
        return classC05List;
    }

    @Override
    public void create(ClassC05 classC05) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if(connection!=null){
            try {
                statement=connection.prepareStatement(INSERT_CLASS_CO5_SQL);
                statement.setString(1,classC05.getId());
                statement.setString(2,classC05.getName());
                statement.setString(3,classC05.getBirthday());
                statement.setString(4,classC05.getGender());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                DBConnection.close();
            }
        }
    }

    @Override
    public boolean deleteClassC05(String id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CLASS_CO5_SQL);) {
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateClassC05(ClassC05 classC05) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CLASS_CO5_SQL);) {
            statement.setString(1,classC05.getId());
            statement.setString(2,classC05.getName());
            statement.setString(3,classC05.getBirthday());
            statement.setString(4,classC05.getGender());
            rowUpdated = statement.executeUpdate() > 0;
        }finally {
            DBConnection.close();
        }
        return rowUpdated;
    }

    @Override
    public ClassC05 findById(String id) throws SQLException {
        ClassC05 classC05 = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if(connection!=null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_CLASS_CO5_BY_ID);
                preparedStatement.setString(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while ( resultSet.next() ) {
                    String id1=resultSet.getString("id");
                    String name=resultSet.getString("name");
                    String birthday=resultSet.getString("birthday");
                    String gender=resultSet.getString("gender");
                    classC05=new ClassC05(id1,name,birthday,gender);
                }

            } finally {
                DBConnection.close();
            }
        }
        return classC05;

    }

    @Override
    public  List<ClassC05>  findByName(String name) throws SQLException {
        List<ClassC05> classC05List = new ArrayList<>();
        try (
                Connection connection = DBConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLASS_CO5_BY_NAME))
        {
            preparedStatement.setString(1, "%" + name + "%");
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (resultSet.next()) {
                String id=resultSet.getString("id");
                String name1=resultSet.getString("name");
                String birthday=resultSet.getString("birthday");
                String gender=resultSet.getString("gender");
                classC05List.add(new ClassC05(id,name1,birthday,gender));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return classC05List;
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
