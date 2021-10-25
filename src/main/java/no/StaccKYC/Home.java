package no.StaccKYC;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/home")
public class Home extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println(request.getAttribute("errorMessage"));
        request.setAttribute("errorMessage", request.getAttribute("errorMessage"));
        request.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = request.getServletContext();
        Scanner sc = new Scanner(new File(context.getRealPath("/data/pep.csv")));

        String name = request.getParameter("name");
        List<String> matches = new ArrayList<>();
        String active;

        while (sc.hasNextLine()) {
            active = sc.nextLine();
            if (!name.equals("") && active.contains(name)) {
                matches.add(active);
            }
        }
        if (matches.isEmpty()) {
            request.setAttribute("errorMessage", "No one with that input");
            response.sendRedirect("home");
        } else {
            request.getSession().setAttribute("match", matches);
            response.sendRedirect("result");
        }
    }
}