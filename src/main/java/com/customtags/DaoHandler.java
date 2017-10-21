package com.customtags;

import com.dao.Entities.Data;
import com.dao.repository.DataDao;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.List;

public class DaoHandler extends SimpleTagSupport {
    public void doTag() throws JspException, IOException {
        DataDao dataDao = new DataDao();
        List<Data> datas = dataDao.getAllData();
        JspWriter out = getJspContext().getOut();
        out.print("<table border = 2px>");
        for(Data data: datas){
            out.print("<tr>");
            out.print("<td>" + data.getKey() + "</td>");
            out.print("<td>" + data.getValue() + "</td>");
            out.print("<td>" + data.getCategory() + "</td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}
