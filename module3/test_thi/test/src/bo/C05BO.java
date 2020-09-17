package bo;

import dao.C05DAO;
import dao.IC05DAO;
import model.ClassC05;

import java.sql.SQLException;
import java.util.List;

public class C05BO implements IC05BO {
    IC05DAO ic05DAO =new C05DAO();
    @Override
    public List<ClassC05> findAll() {
        return ic05DAO.findAll();
    }

    @Override
    public void create(ClassC05 classC05) {
        ic05DAO.create(classC05);
    }

    @Override
    public boolean deleteClassC05(String id) throws SQLException {
        return ic05DAO.deleteClassC05(id);
    }

    @Override
    public boolean updateClassC05(ClassC05 classC05) throws SQLException {
        return ic05DAO.updateClassC05(classC05);
    }

    @Override
    public ClassC05 findById(String id) throws SQLException {
        return ic05DAO.findById(id);
    }

    @Override
    public List<ClassC05> findByName(String name) throws SQLException {
        return ic05DAO.findByName(name);
    }

    @Override
    public boolean checkId(String id) {
        boolean check=true;
        List<ClassC05> classC05List =ic05DAO.findAll();
        for (int i=0;i<classC05List.size();i++){
            if(id.equals(classC05List.get(i).getId())){
                check=false;
                break;
            }
        }
        return check;
    }
}
