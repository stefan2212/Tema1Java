package com.servlets;

import com.dao.Entities.Category;
import com.dao.repository.CategoryDao;
import com.dao.repository.ICategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryServlet", urlPatterns = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICategoryDao dao = new CategoryDao();
        List<Category> categoryList = dao.getAllCategories();
        request.setAttribute("name", categoryList);
        request.getRequestDispatcher("/records.jsp").forward(request, response);
    }

}
