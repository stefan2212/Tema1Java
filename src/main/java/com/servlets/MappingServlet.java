package com.servlets;

import com.dao.CategoryDao;
import com.dao.ICategoryDao;
import com.content.Content;
import com.content.IContent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@WebServlet(name = "MappingServlet", urlPatterns = "/MappingServlet")
public class MappingServlet extends HttpServlet {
    private PrintWriter out = null;
    private Map<String, String[]> data = null;
    private static int threadCounter = 0;
    private String filename = "";


    public MappingServlet() {
        data = new ConcurrentHashMap<String, String[]>();
    }

    public void init() {

    }

    synchronized protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        out = response.getWriter();
        if (request.getHeader("User-Agent").contains("Mozilla/5.0 (Windows NT 10.0; Win64; ")) {
            this.generateHtml(request);
        } else {
            this.writeIntoFile(request);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICategoryDao dao = new CategoryDao();
        //     dao.getAllCategories();

        Cookie cookies[] = request.getCookies();
        for (Cookie cookie : cookies) {
            request.setAttribute("cookie", cookie);
        }
        request.setAttribute("name", dao.getAllCategories());
        request.getRequestDispatcher("input.jsp").forward(request, response);
    }

    private void writeIntoFile(HttpServletRequest request) {
        PrintWriter writer = null;
        filename =
                getServletContext().getRealPath("fisier.txt");

        try {
            writer = new PrintWriter(new PrintWriter(new FileOutputStream(
                    new File(filename),
                    true)));

            IContent content = getContent(request);
            log(content.toString());
            writer.write(content.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
        out.println(readFileContent());
        out.close();
    }


    private void generateHtml(HttpServletRequest request) {
        IContent content = new Content();
        data = request.getParameterMap();
        for (String key : data.keySet()) {
            for (String value : data.get(key)) {
                content.setKey(key);
                content.setValue(value);
            }
        }
        content.setMethod(request.getMethod());
        content.setHeader(request.getHeader("User-Agent"));

        out.println("<h1> Response to the browser </h1>");
        out.println("<h2>" + content.toString() + "<h2>");

    }

    synchronized public String readFileContent() {
        String line;
        StringBuffer content = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                content.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content.toString();
    }

    private IContent getContent(HttpServletRequest request) {
        IContent content = new Content();
        data = request.getParameterMap();
        for (String key : data.keySet()) {
            content.setKey(parseText(key)[0]);
            content.setValue(parseText(key)[1]);
            content.setMethod(request.getMethod());
            content.setHeader(request.getHeader("User-Agent"));
        }

        return content;
    }

    private String[] parseText(String text) {
        String key = text.split(":")[0];
        String value = text.split(":")[1];

        key = key.substring(2, (key.length() - 1));
        value = value.substring(1, (value.length() - 2));
        return new String[]{key, value};
    }


}
