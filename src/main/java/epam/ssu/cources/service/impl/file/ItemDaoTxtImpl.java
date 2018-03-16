package epam.ssu.cources.service.impl.file;

import epam.ssu.cources.model.Item;
import epam.ssu.cources.service.ItemDAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class ItemDaoTxtImpl implements ItemDAO {

    private File file;

    private int idCounter;

    private String path = "D:\\ermolaxe\\github\\SSU.Servlets\\src\\main\\resources\\items.txt";

    public ItemDaoTxtImpl(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(Objects.requireNonNull(classLoader.getResource(filename)).getFile());
    }

    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        String line;
//        try (BufferedReader reader = new BufferedReader(new FileReader(path))) { //need change to universal path
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { //need change to universal path
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(":");
                items.add(new Item(words[0], words[1], Integer.parseInt(words[2]), words[3]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Some gap with IO...");
            e.printStackTrace();
        }
        return items;
    }

    public void addItem(Item item) {
//        try (FileWriter writer = new FileWriter(path, true)) { //need change to universal path
        try (FileWriter writer = new FileWriter(file, true)) { //need change to universal path
            item.setId(String.valueOf(UUID.randomUUID()));
            writer.write(item.toString());
        } catch (IOException e) {
            System.out.println("Some gap with IO...");
            e.printStackTrace();
        }
    }

}
