package servlet;

import dao.UserDao;
import dao.UserDaoImp;
import model.User;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServletSign")
public class ServletSign extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                String sign = process(request,response);
                 UserDao users = new UserDaoImp();
                String path ="";
               if(sign.equals("sign")) {
                   String name = request.getParameter("textName");
                   String surname = request.getParameter("textSurname");
                   String email = request.getParameter("textEmail");
                   String username = request.getParameter("textUsername");
                   String password = request.getParameter("textPassword");
                   String confirm  = request.getParameter("textConfirm");

                   try {

                       if(password.equalsIgnoreCase(confirm)){
                           User user =new User(name,surname,email,username,password);
                           users.addUser(user);
                           path="jsp/internal/success.jsp";
                       }else{
                           path="jsp/external/error.jsp";
                       }
                   } catch (Exception e) {
                       path="jsp/external/error.jsp";
                   }


                }



        request.getRequestDispatcher(path).forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public  static  String process(HttpServletRequest request, HttpServletResponse response){
        String sign = request.getParameter("sign");
        return sign;

    }
}
