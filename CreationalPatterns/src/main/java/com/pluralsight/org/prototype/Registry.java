package com.pluralsight.org.prototype;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    private Map<String, Item> items = new HashMap<>();

    public Registry() {
        loadItems();
    }

    public Item createItem(String type) {
        Item item = null;

        try {
            item = (Item) items.get(type).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return item;
    }

    private void loadItems() {
        Movie movie = new Movie();
        movie.setRuntime("2 hours");
        movie.setTitle("Star Wars");
        items.put("Movie", movie);

        Book book = new Book();
        book.setNumberOfPages(335);
        book.setTitle("Lord of the Rings");
        items.put("Book", book);
    }
}
