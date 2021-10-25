package no.StaccKYC;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@WebServlet("/result")
public class Result extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = request.getServletContext();
        Scanner sc = new Scanner(new File(context.getRealPath("/data/pep.csv")));
        String[] firstRow = sc.nextLine().replace("\"", "").split(",");
        List<String> matchList = (List<String>) request.getSession().getAttribute("match");
        System.out.println(matchList.size());
        if (matchList != null) {
            List<String[]> matchListList = new ArrayList<>();;
            for (int i = 0; i < matchList.size(); i++) {
                matchListList.add(matchList.get(i).replace("\"", "").split(","));
            }
            request.setAttribute("match", matchListList);
        }
        request.setAttribute("firstRow", firstRow);
        request.getRequestDispatcher("WEB-INF/pages/result.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
