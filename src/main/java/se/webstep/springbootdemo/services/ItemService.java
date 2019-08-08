package se.webstep.springbootdemo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import se.webstep.springbootdemo.entities.Item;


@Service
public class ItemService {

    public List<Item> getMockedListOfItems(){
        Item firstItem=new Item(1,1,"First Item");
        Item secondItem=new Item(2,1,"Second Item");

        List<Item> allItems=new ArrayList<Item>();
        allItems.add(firstItem);
        allItems.add(secondItem);

        return allItems;
    }

    public List<Item> getAllItems(){
        return getMockedListOfItems();
    }

}
