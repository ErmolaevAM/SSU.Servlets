package epam.ssu.cources.servlet;

import epam.ssu.cources.model.Item;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("items.jsp");
        List<Item> items = new ArrayList<Item>();
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\ermolaxe\\IdeaProjects\\ermolaxe.mock\\WebApp-Servlets\\src\\main\\resources\\items.txt"))) {
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(":");
                items.add(new Item(Integer.parseInt(words[0]), words[1], Integer.parseInt(words[2]), words[3]));
            }
        }
        req.setAttribute("itemList", items);
        dispatcher.forward(req, resp);
    }
}
