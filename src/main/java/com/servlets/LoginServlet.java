package com.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name ="LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private String username = "admin";
    private String password = "admin";

    public LoginServlet(){

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (verifyUser(username,password)){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            response.sendRedirect("/MappingServlet");
          //  request.getRequestDispatcher("/input.jsp").forward(request, response);
        }
        else{
            request.setAttribute("name", "Username or Password are invalid");
            request.getRequestDispatcher("/login.jsp").forward(request, response);

        }
    }

    private boolean verifyUser(String username, String password){
        if(username.compareTo(this.username)==0 && password.compareTo(this.password) == 0)
            return true;
        return false;
    }



}
