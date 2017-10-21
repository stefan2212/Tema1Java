package com.servlets;

import com.dao.Entities.Category;
import com.dao.repository.CategoryDao;
import com.dao.repository.ICategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RecordsServlet", urlPatterns = "/RecordsServlet")
public class RecordsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId = request.getParameter("selector");
        request.setAttribute("categoryId", categoryId);
        request.getRequestDispatcher("/resultTag.jsp").forward(request, response);
    }
}
