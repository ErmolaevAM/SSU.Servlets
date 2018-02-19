package epam.ssu.cources.service;

import epam.ssu.cources.model.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO {

    private File file;

    private int idCounter;

    private String path = "D:\\ermolaxe\\IdeaProjects\\ermolaxe.mock\\WebApp-Servlets\\src\\main\\resources\\items.txt";

    public ItemDAO(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(classLoader.getResource(filename).getFile());
    }

    public List<Item> getItems() {
        List<Item> items = new ArrayList<>();
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) { //need change to universal path
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(":");
                items.add(new Item(Integer.parseInt(words[0]), words[1], Integer.parseInt(words[2]), words[3]));
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
        try (FileWriter writer = new FileWriter(path, true)) { //need change to universal path
            item.setId(idCounter);
            writer.write(item.toString());
        } catch (IOException e) {
            System.out.println("Some gap with IO...");
            e.printStackTrace();
        }
    }

}
