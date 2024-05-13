package nz.ac.auckland.se754.web.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nz.ac.auckland.se754.web.model.Item;
import org.springframework.stereotype.Service;

@Service
public class Questions {
    private final List<Item> items;
    private final Map<Item,List<String>> questions2user;
    public Questions(){
        items = new ArrayList<>();
        questions2user = new HashMap<>();
        items.add(new Item(1, "Question1"));
        items.add(new Item(2, "Question2"));
        items.add(new Item(3, "Question3"));
        questions2user.put(items.get(0), Arrays.asList("user1","user2"));
        questions2user.put(items.get(1), Arrays.asList("user1"));
        questions2user.put(items.get(2), Arrays.asList("user2"));
    }

    public List<Item> retrieveQuestions(String user) {
        List<Item> filteredItems = new ArrayList<>();
        for (Item c : items) {
            if (questions2user.containsKey(c)) {
                if(questions2user.get(c).contains(user))
                filteredItems.add(c);
            }
        }
        return filteredItems;
    }
}