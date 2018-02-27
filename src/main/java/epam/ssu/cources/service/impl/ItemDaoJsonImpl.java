package epam.ssu.cources.service.impl;

import epam.ssu.cources.model.Item;
import epam.ssu.cources.service.ItemDAO;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.util.DefaultPrettyPrinter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

public class ItemDaoJsonImpl implements ItemDAO {

    private File file;

    private String path = "D:\\ermolaxe\\IdeaProjects\\ermolaxe.mock\\WebApp-Servlets\\src\\main\\resources\\items.json";

    private ObjectMapper mapper;

    public ItemDaoJsonImpl(String filename) {
        ClassLoader classLoader = getClass().getClassLoader();
        file = new File(classLoader.getResource(filename).getFile());
        mapper = new ObjectMapper();
    }

    @Override
    public List<Item> getItems() throws IOException {
        List<Item> list = mapper.readValue(new File(path), mapper.getTypeFactory().constructCollectionType(List.class, Item.class));
        return list;
    }

    @Override
    public void addItem(Item item) throws IOException {
        item.setId(String.valueOf(UUID.randomUUID()));
        List<Item> list = mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Item.class));
        list.add(item);
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.write("");
        printWriter.close();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(path), list);
    }
}
