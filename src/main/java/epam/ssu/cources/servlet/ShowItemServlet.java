package epam.ssu.cources.servlet;

import epam.ssu.cources.service.ItemDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowItemServlet extends HttpServlet {

    private ItemDAO itemDAO = new ItemDAO("items.txt");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("items.jsp");
        req.setAttribute("itemList", itemDAO.getItems());
        dispatcher.forward(req, resp);
    }
}
