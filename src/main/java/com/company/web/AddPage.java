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

@WebServlet(name = "AbonentPage", urlPatterns = {"/add"})
public class AddPage extends HttpServlet {
    private AbonentManager abonentManager;

    @Override
    public void init() throws ServletException {
        super.init();
        abonentManager = ManagerFactory.getINSTANCE().getManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String surname = req.getParameter("surname");
        String name = req.getParameter("name");
        String phoneNumber = req.getParameter("phoneNumber");
        Abonent abonent = new Abonent(surname, name, phoneNumber);
        boolean result1 = abonentManager.addAbonent(abonent);
        String message;
        if (result1)
            message = "Data add";
        else
            message = "Data not add";

        req.setAttribute("message", message);
        req.setAttribute("abonent", abonent);

        getServletContext()
                .getRequestDispatcher("/add.jsp")
                .forward(req, resp);

    }
}
