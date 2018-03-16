package epam.ssu.cources.servlet;

import epam.ssu.cources.model.Item;
import epam.ssu.cources.service.ItemDAO;
import epam.ssu.cources.service.impl.database.ItemDaoH2Impl;
import epam.ssu.cources.service.impl.file.ItemDaoJsonImpl;
import epam.ssu.cources.service.impl.file.ItemDaoTxtImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddItemServlet extends HttpServlet {

    private ItemDAO itemDaoTxtImpl = new ItemDaoTxtImpl("items.txt");

    private ItemDAO itemDaoJsonImpl = new ItemDaoJsonImpl("items.json");

    private ItemDAO itemDaoDatabaseImpl = new ItemDaoH2Impl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("createItem.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        fetch data from JSP form
        String title = req.getParameter("title");
        int price = Integer.parseInt(req.getParameter("price"));
        String description = req.getParameter("description");

//        create Item object
        Item item = new Item(title, price, description);

//        add item to storage
//        itemDaoTxtImpl.addItem(item);
//        itemDaoJsonImpl.addItem(item);
        itemDaoDatabaseImpl.addItem(item);

        resp.sendRedirect("/items");
    }
}
