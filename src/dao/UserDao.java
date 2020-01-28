package dao;

import model.Avto;
import model.Image;
import model.Model;
import model.User;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    List <Avto> getAllAvto() throws SQLException, NamingException;
    List <Avto> getAllAvtoSearch(String marka,String model,String volume,String year,String min,String max) throws SQLException, NamingException;
    List <User> getAllUser() throws SQLException, NamingException;
    void addUser(User user) throws SQLException, NamingException;
    void addAvto(Avto avto) throws SQLException, NamingException;
    List <Model> getModelforMarka (int markaValue) throws SQLException, NamingException;
    List <Avto> getMyAvtos (int id) throws SQLException, NamingException;
    List <Avto> getAvtoForId (int id) throws SQLException, NamingException;
    List <Image> getImagesForAvtoId(int id) throws SQLException, NamingException;
    void uploadImageForAvtoId(String writename,int avtoId) throws SQLException, NamingException;

    Avto getAboutForAvtoId(Integer id) throws SQLException, NamingException;
}
