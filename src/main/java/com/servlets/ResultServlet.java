package com.servlets;

import com.VerifyRecaptcha;
import com.dao.repository.CategoryDao;
import com.dao.repository.DataDao;
import com.dao.Entities.Category;
import com.dao.Entities.Data;
import com.dao.repository.ICategoryDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
            keyForm = request.getParameter("key");
            valueForm = request.getParameter("value");
            categoryId = request.getParameter("selector");
            ICategoryDao categoryDao = new CategoryDao();
            Category category = categoryDao.getEntity(Integer.valueOf(categoryId));
            Cookie cookie = new Cookie("cookie",category.getCategory());
            response.addCookie(cookie);
            gRecaptchaResponse = request.getParameter("g-recaptcha-response");
            Data data = new Data();
            data.setCategory(category);
            data.setKey(keyForm);
            data.setValue(valueForm);
            DataDao dataDao = new DataDao();
            boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
            if (verify) {
            try {
                dataDao.addData(data);
                DataDao allData = new DataDao();
                List<Data> datas = allData.getAllData();
                request.setAttribute("name",datas);
                request.getRequestDispatcher("result.jsp").forward(request, response);
            } catch (Exception e) {
                request.setAttribute("name", e.getMessage());
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            } else {
                request.setAttribute("name", "Captcha is not verified");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

}
