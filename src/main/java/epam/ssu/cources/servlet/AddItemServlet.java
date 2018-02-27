package epam.ssu.cources.servlet;

import epam.ssu.cources.model.Item;
import epam.ssu.cources.service.ItemDAO;
import epam.ssu.cources.service.impl.ItemDaoJsonImpl;
import epam.ssu.cources.service.impl.ItemDaoTxtImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddItemServlet extends HttpServlet {

    private ItemDaoTxtImpl itemDaoTxtImpl = new ItemDaoTxtImpl("items.txt");

    private ItemDAO itemDaoJsonImpl = new ItemDaoJsonImpl("items.json");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("createItem.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        int price = Integer.parseInt(req.getParameter("price"));
        String description = req.getParameter("description");
//        itemDaoTxtImpl.addItem(new Item(title, price, description));
        itemDaoJsonImpl.addItem(new Item(title, price, description));
        resp.sendRedirect("/items");
    }
}
