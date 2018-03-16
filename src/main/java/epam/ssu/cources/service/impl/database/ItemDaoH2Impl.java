package epam.ssu.cources.service.impl.database;

import epam.ssu.cources.model.Item;
import epam.ssu.cources.service.ItemDAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class ItemDaoH2Impl implements ItemDAO {

    private Connection connection;

    private String url;
    private String username;
    private String password;

    public ItemDaoH2Impl() {
        try {
            //load .properties file
            FileInputStream stream = new FileInputStream("D:\\ermolaxe\\github\\SSU.Servlets\\src\\main\\resources\\application.properties");
            Properties properties = new Properties();
            properties.load(stream);

            //fetch params from .properties file
            String driverClassName = properties.getProperty("datasource.driverClassName");
            url = properties.getProperty("datasource.url");
            username = properties.getProperty("datasource.username");
            password = properties.getProperty("datasource.password");

            //configure database
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, username, password);

            //create table for item objects
            createItemTable();
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    private void createItemTable() {
        String sqlQuery = "CREATE TABLE IF NOT EXISTS ITEM (" +
                "id VARCHAR(255) not NULL," +
                "title VARCHAR(255) not NULL," +
                "price INT not NULL," +
                "desc VARCHAR(255)," +
                "PRIMARY KEY ( id )" +
                ")";
        createTableExecutor(sqlQuery);
    }

    private void createTableExecutor(String sqlQuery) {
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlQuery);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> getItems() {
        List<Item> all = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ITEM;");
            while (resultSet.next()) {
                String id = resultSet.getString("ID");
                String title = resultSet.getString("TITLE");
                int price = resultSet.getInt("PRICE");
                String desc = resultSet.getString("DESC");

                all.add(new Item(id, title, price, desc));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return all;
    }

    @Override
    public void addItem(Item item) {
        item.setId(String.valueOf(UUID.randomUUID()));
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String insertLine = String.format("INSERT INTO ITEM VALUES ('%s', '%s', %d, '%s');",
                    item.getId(),
                    item.getTitle(),
                    item.getPrice(),
                    item.getDesc());
            statement.executeUpdate(insertLine);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
