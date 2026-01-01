package servlet;

import dao.StudentDAO;
import model.Student;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowStudentsServlet extends HttpServlet {

    private final StudentDAO dao = new StudentDAO();

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
    List<Student> students = dao.getAllStudents();

    out.println("<html><body>");
    out.println("<h2>Registered Students</h2>");
    out.println("<table border='1'>");
    out.println("<tr><th>Name</th><th>Email</th><th>Year</th></tr>");

    for (Student s : students) {
        out.println("<tr>");
        out.println("<td>" + s.getName() + "</td>");
        out.println("<td>" + s.getEmail() + "</td>");
        out.println("<td>" + s.getYear() + "</td>");
        out.println("</tr>");
    }

    out.println("</table></body></html>");
} catch (Exception e) {
    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to fetch students");
}
}
}