package epam.ssu.cources.service;

import epam.ssu.cources.model.Item;

import java.io.IOException;
import java.util.List;

public interface ItemDAO {
    List<Item> getItems() throws IOException;

    void addItem(Item item) throws IOException;
}
