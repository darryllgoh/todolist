package org.generation.todolist.service;

import org.generation.todolist.repository.entity.Item;
import org.springframework.stereotype.Service;
import org.generation.todolist.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ItemServiceMySQL implements ItemService {

    private final ItemRepository itemRepository;


    public ItemServiceMySQL(@Autowired ItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
    }

    //save
    @Override
    public Item save(Item item)
    {
        return this.itemRepository.save(item);
    }

    //delete
    @Override
    public void delete(int itemId)
    {
        this.itemRepository.deleteById(itemId);
    }

    //display all
    @Override
    public ArrayList<Item> all()
    {
        ArrayList<Item> result = new ArrayList<>();
        itemRepository.findAll().forEach(result::add);
        return result;
    }

    //find by id
    @Override
    public Item findById(int itemId)
    {
        Optional<Item> item = itemRepository.findById(itemId);
        Item itemResponse = item.get();
        return itemResponse;
    }
}
