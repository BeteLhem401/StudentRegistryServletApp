package servlet;

import dao.StudentDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterStudentServlet extends HttpServlet {

    private final StudentDAO dao = new StudentDAO();

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

       try {
    String name = req.getParameter("name");
    String email = req.getParameter("email");
    int year = Integer.parseInt(req.getParameter("year"));

    dao.insertStudent(name, email, year);

    resp.sendRedirect("show_all");

} catch (Exception e) {
    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input");
}

    }
}
