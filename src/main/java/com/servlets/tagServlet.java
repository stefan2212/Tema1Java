package com.servlets;

import com.customtags.DataTagHandler;
import com.dao.Entities.Data;
import com.dao.repository.DataDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name ="tagServlet", urlPatterns = "/tagServlet")
public class tagServlet extends HttpServlet {

    DataDao daoObject;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        String inputKey = request.getParameter("tagKey");
        daoObject = new DataDao();

        List<Data> listOfData = new ArrayList<Data>();
        listOfData = daoObject.getAllData();

        String myRecord = "";
        for (Data currentData : listOfData) {
            String currentKey = currentData.getKey();
            if (currentKey.compareTo(inputKey) == 0) {
                myRecord += currentData.getKey();
                myRecord += currentData.getValue();
                myRecord += currentData.getCategory().toString();
                break;
            }
        }

        request.setAttribute("record",myRecord);
        request.getRequestDispatcher("/tagPage.jsp").forward(request, response);
    }
}
