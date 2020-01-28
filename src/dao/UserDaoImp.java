package dao;

import helper.DbConfig;
import helper.Query;
import model.Avto;
import model.Image;
import model.Model;
import model.User;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImp implements UserDao {
    @Override
    public List<Avto> getAllAvto() throws SQLException, NamingException {
        Connection connection = DbConfig.openUser();
        PreparedStatement pts =connection.prepareStatement(Query.showAllAvto.getSql());
        ResultSet rs =pts.executeQuery();
        List<Avto> list = new ArrayList<>();
        while (rs.next()){

            list.add(new Avto(rs.getInt(1),rs.getString(2),rs.getString(3),
                    rs.getDouble(4),rs.getInt(5),rs.getInt(6)));
        }
        pts.execute();
        connection.close();


        return list;
    }

    @Override
    public List<Avto> getAllAvtoSearch(String marka,String model,String volume,String year,String min,String max) throws SQLException, NamingException {
        String sql = Query.showAllAvto.getSql();
        StringBuilder builder = new StringBuilder(sql);
        builder.append("where 1=1");
        if(marka!=null && !marka.trim().isEmpty()&& Integer.parseInt(marka)!=0){//?
            builder.append("and marka="+marka);
        }
        try{
        if(model!=null && !model.trim().isEmpty()&&Integer.parseInt(model)!=0){
            builder.append("and model="+model);
        }
        }catch (Exception e){

        }
        if(volume!=null && !volume.trim().isEmpty()){
            builder.append("and volume="+volume);
        }
        if(year!=null && !year.trim().isEmpty()){
            builder.append("and year="+year);
        }
        if(min!=null && !min.trim().isEmpty()){
            builder.append("and cost>"+min);
        }
        if(max!=null && !max.trim().isEmpty()){
            builder.append("and cost<="+max);
        }

        Connection connection =DbConfig.openUser();
        PreparedStatement pts = connection.prepareStatement(String.valueOf(builder));
        ResultSet rs = pts.executeQuery();
        List <Avto> list = new ArrayList<>();

        while (rs.next()){

            list.add( new Avto(rs.getInt(1),rs.getString(2),rs.getString(3),
                    rs.getDouble(4),rs.getInt(5),rs.getInt(6)));
        }
        pts.execute();
        connection.close();



        return list;
    }

    @Override
    public List<User> getAllUser() throws SQLException, NamingException {
        Connection connection = DbConfig.openUser();
        PreparedStatement pts=connection.prepareStatement(Query.getAllUsers.getSql());
        ResultSet rs = pts.executeQuery();
        List <User> list = new ArrayList<>();
        while (rs.next()){
            User  user  = new User(rs.getInt(1),rs.getString(2),
                    rs.getString(3),rs.getString(4),rs.getString(5),
                    rs.getString(6));
            list.add(user);
        }
        pts.execute();
        connection.close();


        return list;
    }

    @Override
    public void addUser(User user) throws SQLException, NamingException {
        //(id,name,surname,email,username,password)
        Connection connection = DbConfig.openUser();
        PreparedStatement pts = connection.prepareStatement(Query.addUser.getSql());
        System.out.println(user.getName());
        System.out.println(user.getSurname());
        System.out.println(user.getEmail());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        pts.setString(1,user.getName());
        pts.setString(2,user.getSurname());
        pts.setString(3,user.getEmail());
        pts.setString(4,user.getUsername());
        pts.setString(5,user.getPassword());
        pts.execute();
        connection.close();




    }

    @Override
    public void addAvto(Avto avto) throws SQLException, NamingException {

        Connection connection = DbConfig.openUser();
        PreparedStatement pts = connection.prepareStatement(Query.addAvto.getSql());
        pts.setString(1,avto.getMarka());
        pts.setString(2,avto.getModel());
        pts.setDouble(3, avto.getVolume());
        pts.setInt(4,avto.getYear());
        pts.setInt(5,avto.getCost());
        pts.setInt(6 ,avto.getUserId());
        pts.execute();
        connection.close();

    }

    @Override
    public List <Model> getModelforMarka(int markaValue) throws SQLException, NamingException {

        Connection connection =DbConfig.openUser();
        PreparedStatement pts =connection.prepareStatement(Query.getModelsForMarka.getSql());
        pts.setInt(1,markaValue);
        ResultSet rs = pts.executeQuery();
        List <Model> list = new ArrayList<>();

        while(rs.next()){
            Model model = new Model(rs.getInt(1),rs.getString(2));
            list.add(model);
        }
            pts.execute();
            connection.close();
        return list;
    }

    @Override
    public List<Avto> getMyAvtos(int id) throws SQLException, NamingException {
        Connection connection = DbConfig.openUser();
        PreparedStatement pts = connection.prepareStatement(Query.getMyAvtos.getSql());
        pts.setInt(1,id);
        ResultSet rs =pts.executeQuery();
        List <Avto> list =new ArrayList<>();

        while (rs.next()){
            Avto avto = new Avto(rs.getInt(1),rs.getString(2),rs.getString(3),
                    rs.getDouble(4),rs.getInt(5),rs.getInt(6));
            list.add(avto);
        }
        pts.execute();
        connection.close();

        return list;
    }

    @Override
    public List<Avto> getAvtoForId(int id) throws SQLException, NamingException {
        Connection connection =DbConfig.openUser();
        PreparedStatement pts = connection.prepareStatement(Query.getAvtoForId.getSql());
        pts.setInt(1,id);
        ResultSet rs= pts.executeQuery();
        List <Avto> list =new ArrayList<>();

        while (rs.next()){
            Avto avto = new Avto(rs.getInt(1),rs.getString(2),rs.getString(3),
                    rs.getDouble(4),rs.getInt(5),rs.getInt(6));
            list.add(avto);
        }
        pts.execute();
        connection.close();

        return list;
    }

    @Override
    public List<Image> getImagesForAvtoId(int id) throws SQLException, NamingException {
        Connection connection =DbConfig.openUser();
        PreparedStatement pts =connection.prepareStatement(Query.getImageForUserId.getSql());
        pts.setInt(1,id);
        ResultSet rs =pts.executeQuery();
        List <Image> list = new ArrayList<>();

        while (rs.next()){
            Image image = new Image(rs.getInt(1),rs.getString(2),rs.getInt(3));
            list.add(image);
        }
        pts.execute();
        connection.close();

        return list;
    }

    @Override
    public void uploadImageForAvtoId(String writename, int avtoId) throws SQLException, NamingException {
        Connection connection =DbConfig.openUser();
        PreparedStatement pts = connection.prepareStatement(Query.uploadImageForAvtoId.getSql());
        pts.setString(1,writename);
        pts.setInt(2,avtoId);
        pts.execute();
        connection.close();

    }

    @Override
    public Avto getAboutForAvtoId(Integer id) throws SQLException, NamingException {

        Connection connection = DbConfig.openUser();
        PreparedStatement pts = connection.prepareStatement(Query.getAvtoForId.getSql());
        pts.setInt(1,id);
        ResultSet rs = pts.executeQuery();
        Avto avto = new Avto() ;
        while (rs.next()){
             avto = new Avto (rs.getInt(1),rs.getString(2),rs.getString(3),
                    rs.getDouble(4),rs.getInt(5));

        }
        pts.execute();
        connection.close();
        return avto;
    }


}
