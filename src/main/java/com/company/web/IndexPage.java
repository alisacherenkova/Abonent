package com.company.web;

import com.company.AbonentManager;
import com.company.factory.ManagerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexPage", urlPatterns = {"/index"})
public class IndexPage extends HttpServlet {
    private AbonentManager abonentManager;

    @Override
    public void init() throws ServletException {
        super.init();
        abonentManager = ManagerFactory.getINSTANCE().getManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("a", abonentManager.findAbonents());

        getServletContext()
                .getRequestDispatcher("/index.jsp")
                .forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("delete"));
        abonentManager.deleteAbonent(id);
        resp.sendRedirect("/index");
    }
}
