package com.servlets;

import com.users.UserData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "inregistrare")
public class inregistrare extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Inregistrare");
        String user=request.getParameter("name");
        String pass=request.getParameter("pass");
        String email=request.getParameter("email");
        UserData userOb = new UserData();
        try {
            if(userOb.isValidUser(user,pass,"user")){
                request.setAttribute("errorregister","Contul deja exista!");
                request.getRequestDispatcher("/register.jsp").forward(request,response);
            }
            else{
                userOb.registerUser(user,pass);
                userOb.setValueOf(user,pass,"email",email);
                response.sendRedirect("/index.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
