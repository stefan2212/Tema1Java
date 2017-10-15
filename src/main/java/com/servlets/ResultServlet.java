package com.servlets;

import com.VerifyRecaptcha;
import com.dao.CategoryDao;
import com.dao.DataDao;
import com.dao.Entities.Category;
import com.dao.Entities.Data;
import com.dao.ICategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "ResultServlet", urlPatterns = "/ResultServlet")
public class ResultServlet extends HttpServlet {

    private Map<String, String[]> data = null;
    private PrintWriter out = null;

    private String keyForm;
    private String valueForm;
    private String categoryId;
    String gRecaptchaResponse;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int k = 0;
            out = response.getWriter();
            keyForm = request.getParameter("key");
            valueForm = request.getParameter("value");
            categoryId = request.getParameter("selector");
            Cookie cookie = new Cookie("cookie",categoryId);
            response.addCookie(cookie);
            gRecaptchaResponse = request.getParameter("g-recaptcha-response");
            ICategoryDao categoryDao = new CategoryDao();
            Category category = categoryDao.getEntity(Integer.valueOf(categoryId));
            Data data = new Data();
            data.setCategory(category);
            data.setKey(keyForm);
            data.setValue(valueForm);
            DataDao dataDao = new DataDao();
            boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
//            if (verify) {
            try {
                dataDao.addData(data);
                request.setAttribute("name", data);
                request.getRequestDispatcher("result.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("name", e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
//            } else {
//                request.setAttribute("name", "Captcha is not verified");
//                request.getRequestDispatcher("error.jsp").forward(request, response);
//            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

}
