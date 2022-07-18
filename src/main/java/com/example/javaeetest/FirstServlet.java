package com.example.javaeetest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;


public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(); // получение объекта сессии для текущего запроса

        Integer count = (Integer) session.getAttribute("count");// Получение значения из сессии

        // получение атрибута (счетчик посещений страницы)
        if(count == null){
            session.setAttribute("count", 1);
            count = 1;
        } else {
            session.setAttribute("count", count +1);
        }


//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
        PrintWriter pw = response.getWriter();

        pw.println("<html>");
        pw.println("<h1> Your count is: " + count + " </h1>");
//        pw.println("<h1> Hello, " + name + " " + surname + " </h1>");
        pw.println("</html>");

        //response.sendRedirect("https://www.google.com"); // редирект на стороний url
        //response.sendRedirect("/testJsp.jsp"); // редирект на внутрений url
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/testJsp.jsp"); // форвард на внутрений url
//        dispatcher.forward(request, response); // метод форвард

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
