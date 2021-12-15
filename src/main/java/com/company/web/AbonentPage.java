package com.company.web;

import com.company.AbonentManager;
import com.company.database.model.Abonent;
import com.company.factory.ManagerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AbonentPage", urlPatterns = {"/abonent/*"})
public class AbonentPage extends HttpServlet {
    private AbonentManager abonentManager;

    @Override
    public void init() throws ServletException {
        super.init();
        abonentManager = ManagerFactory.getINSTANCE().getManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = extractId(req.getPathInfo());
        if (id == null) {
        // обработка ошибки
        }
        Abonent abonent = abonentManager.getAbonent(id);
        req.setAttribute("abonent", abonent);

        getServletContext()
                .getRequestDispatcher("/abonent.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = extractId(req.getPathInfo());
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");

        Abonent abonent = new Abonent(id, surname, name, phoneNumber);
        boolean result = abonentManager.updateAbonent(abonent);

        String message;
        if (result)
            message = "Data updated";
        else
            message = "Data not updated";

        req.setAttribute("message", message);
        req.setAttribute("abonent", abonent);

        getServletContext()
                .getRequestDispatcher("/abonent.jsp")
                .forward(req, resp);
    }


    private Long extractId(String path) {
        if (path != null) {
            try {
                path = path.split("/")[1];
                path = path.split("\\?")[0];
                return (long) Integer.parseInt(path);
            } catch (NumberFormatException e ) {
                return null;
            }
        }
        return null;
    }
}
