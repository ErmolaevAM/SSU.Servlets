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
import java.util.List;

public class ShowItemServlet extends HttpServlet {

    private ItemDAO itemDaoTxtImpl = new ItemDaoTxtImpl("items.txt");

    private ItemDAO itemDaoJsonImpl = new ItemDaoJsonImpl("items.json");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("items.jsp");

//        read file from TXT file
//        req.setAttribute("itemList", itemDaoTxtImpl.getItems());

//        read data from JSON file
        List<Item> list = itemDaoJsonImpl.getItems();

        req.setAttribute("itemList", list);
        dispatcher.forward(req, resp);
    }
}
