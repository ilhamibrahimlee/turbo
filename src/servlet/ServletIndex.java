package servlet;

import dao.UserDao;
import dao.UserDaoImp;
import model.Avto;
import model.Image;
import model.Model;
import model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class ServletIndex extends javax.servlet.http.HttpServlet {
    private String filePath;
    private int maxFileSize = 1000 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file;

    public void init() {
        filePath = getServletContext().getRealPath("/") + "upload" + File.separator;
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = " ";
        action = action(request, response);
        UserDao user = new UserDaoImp();
        String path = "";

        if (action == null) {
            System.out.println("action is null");
            return;
        }

        if (action.equals("showAvto")) {
            try {
                List<Avto> list = user.getAllAvto();
                request.setAttribute("avtoList", list);
                path = "jsp/internal/avtoTable.jsp";

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (action.equals("showSearch")) {
            path = "jsp/internal/showSearch.jsp";
        }

        if (action.equals("search")) {

            try {

                List<Avto> list = user.getAllAvtoSearch(request.getParameter("marka"),
                        request.getParameter("model"), request.getParameter("volume"), request.getParameter("year"),
                        request.getParameter("min"), request.getParameter("max"));
                request.setAttribute("searchList", list);

                path = "jsp/internal/avtoTableSearch.jsp";

            } catch (Exception e) {
                e.printStackTrace();

            }


        }

        if (action.equals("showSignIn")) {

            path = "jsp/internal/signIn.jsp";
        }

        if (action.equals("loginUser")) {

            try {
                String username = request.getParameter("username1");
                String password = request.getParameter("password1");
                List<User> list = user.getAllUser();
                int id = 0;
                boolean test1 = false;


                for (User u : list) {
                    if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equalsIgnoreCase(password)) {
                        test1 = true;
                        id = u.getId();

                    }
                }

                request.setAttribute("boolean1", test1);
                request.setAttribute("id1", id);

                path = "jsp/internal/buttonAdd.jsp";

            } catch (Exception e) {
                e.printStackTrace();

            }

        }

        if (action.equals("loginUsername")) {
            try {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                List<User> list = user.getAllUser();
                String frontUsername = null;
                String frontemail = null;
                boolean test1 = false;

                for (User u : list) {
                    if (u.getUsername().equalsIgnoreCase(username) && u.getPassword().equalsIgnoreCase(password)) {
                        test1 = true;
                        frontUsername = u.getName();
                        frontemail = u.getEmail();
                    }
                }
                request.setAttribute("boolean", test1);
                request.setAttribute("frontName", frontUsername);
                request.setAttribute("frontemail", frontemail);
                path = "jsp/internal/userName.jsp";

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (action.equalsIgnoreCase("addAvto")) {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("userId", id);
            path = "jsp/internal/addAvto.jsp";


        }

        if (action.equalsIgnoreCase("addAvtoData")) {

            try {
                System.out.println("add avto data");
                String marka = request.getParameter("marka");
                String model = request.getParameter("model");
                Double volume = Double.parseDouble(request.getParameter("volume"));
                Integer year = Integer.parseInt(request.getParameter("year"));
                int cost = Integer.parseInt(request.getParameter("cost"));
                String info = request.getParameter("info");
                int userId = Integer.parseInt(request.getParameter("userId"));

                Avto avto = new Avto(marka, model, volume, year, cost, userId);
                user.addAvto(avto);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        if (action.equalsIgnoreCase("addModel")) {

            Integer markaValue = Integer.parseInt(request.getParameter("markaValue"));
            try {
                List<Model> list = user.getModelforMarka(markaValue);
                request.setAttribute("list", list);
                path = "jsp/internal/model.jsp";

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (action.equalsIgnoreCase("searchModel")) {

            Integer markaValue = Integer.parseInt(request.getParameter("markaValue"));
            try {
                List<Model> list = user.getModelforMarka(markaValue);
                request.setAttribute("list", list);
                path = "jsp/internal/model.jsp";


            } catch (Exception e) {
                e.printStackTrace();
            }


        }

        if (action.equalsIgnoreCase("addImage")) {
            try {

                String writeName1=" ";
                int avtoId1 =0;
                response.setContentType("text/html");

                DiskFileItemFactory factory = new DiskFileItemFactory();

                factory.setSizeThreshold(maxMemSize);
                factory.setRepository(new File(filePath));

                ServletFileUpload upload = new ServletFileUpload(factory);

                upload.setSizeMax(maxFileSize);
                List<FileItem> fileItems = upload.parseRequest(request);
                Iterator<FileItem> i = fileItems.iterator();

                while (i.hasNext()) {
                    FileItem fi = i.next();
                    if (!fi.isFormField()) {
                        String fieldName = fi.getFieldName();
                        String fileName = fi.getName();
                        String contentType = fi.getContentType();
                        boolean isInMemory = fi.isInMemory();
                        long sizeInByte = fi.getSize();

                        String fileExtension = fileName.substring(fileName.lastIndexOf("."));
                        String writeName = UUID.randomUUID().toString() + fileExtension;

                        OutputStream writer = new FileOutputStream(new File(filePath + writeName));
                        writer.write(fi.get());
                        writer.close();

                        path = "jsp/internal/image.jsp";
                        request.setAttribute("image", writeName);
                        System.out.println(writeName);
                        writeName1=writeName;

                    } else { //get text type value
                        String name = fi.getFieldName();
                        String value = fi.getString();
                        avtoId1=Integer.parseInt(value);
                    }
                }

                System.out.println(writeName1+avtoId1);

                user.uploadImageForAvtoId(writeName1,avtoId1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (action.equalsIgnoreCase("showMyAvtos")) {

            try {
                Integer id = Integer.parseInt(request.getParameter("id"));
                List<Avto> list = user.getMyAvtos(id);
                request.setAttribute("list", list);
                path = "jsp/internal/myAvtos.jsp";

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        if (action.equalsIgnoreCase("about")) {

            try {
                Integer avtoId = Integer.parseInt(request.getParameter("id"));
                List<Avto> list = user.getAvtoForId(avtoId);
                List<Image> listImage = user.getImagesForAvtoId(avtoId);
                request.setAttribute("list", list);
                request.setAttribute("listImage", listImage);
                request.setAttribute("avtoId", avtoId);
                path = "jsp/internal/aboutAvto.jsp";


            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(action.equalsIgnoreCase("aboutAvto")){

            try {
                Integer id = Integer.parseInt(request.getParameter("id"));

                Avto avto = user.getAboutForAvtoId(id);
                List<Image> listImage = user.getImagesForAvtoId(id);

                request.setAttribute( "avtomobil",avto);
                request.setAttribute("listImage", listImage);

                path = "jsp/internal/about.jsp";


            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    public static String action(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String action = request.getParameter("action");

        return action;
    }


}
