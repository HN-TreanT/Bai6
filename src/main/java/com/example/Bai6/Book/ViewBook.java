package com.example.Bai6.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/view-books")
public class ViewBook extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("text/html");
//        PrintWriter out=response.getWriter();
//        out.println("<a href='create-book'>Add New Book</a>");
//        out.println("<h1>Book List</h1>");
//
//        List<Book> list=BookDAO.getAllEmployees();
//
//        out.print("<table border='1' width='100%'");
//        out.print("<tr><th>Id</th><th>Mô tả chi tiết</th><th>Mô tả tóm tắt</th><th>Giá</th><th>Edit</th><th>Delete</th></tr>");
//        for(Book e:list){
//            out.print("<tr><td>"+e.getID()+"</td><td>"+e.getShortDescription()+"</td><td>"+e.getLongDescription()+"</td><td>"+e.getCost()+"</td><td><a href='EditServlet?id="+e.getID()+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getID()+"'>delete</a></td></tr>");
//        }
//        out.print("</table>");
//
//        out.close();
//    }
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    List<Book> list = BookDAO.getAllBooks();
    String docType =
            "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                    "Transitional//EN\">\n";
    out.println(docType +
            "<HTML>\n" +
            "<HEAD><TITLE>" + "Danh sach book" + "</TITLE></HEAD>\n" +
            "<BODY BGCOLOR=\"#FDF5E6\">\n" +
            "<H1 ALIGN=\"CENTER\">" + "Danh sach book" + "</H1>");
    Book item;
    for (int i = 0; i < list.size(); i++) {
        out.println("<HR>");
        item = list.get(i);
        out.println();
        String formURL =
                "card";
        // Pass URLs that reference own site through encodeURL.
        formURL = response.encodeURL(formURL);
        out.println
                ("<FORM ACTION=\"" + formURL + "\">\n" +
                        "<INPUT TYPE=\"HIDDEN\" NAME=\"itemID\" " +
                        "       VALUE=\"" + item.getID() + "\">\n" +
                        "<H2>" + item.getShortDescription() +
                        " ($" + item.getCost() + ")</H2>\n" +
                        item.getLongDescription() + "\n" +
                        "<P>\n<CENTER>\n" +
                        "<INPUT TYPE=\"SUBMIT\" " +
                        "VALUE=\"Add to Shopping Cart\">\n" +
                        "</CENTER>\n<P>\n</FORM>");
    }
    out.println("<HR>\n</BODY></HTML>");
}
}
