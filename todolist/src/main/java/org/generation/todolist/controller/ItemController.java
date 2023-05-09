package org.generation.todolist.controller;

import org.generation.todolist.service.ItemService;
import org.generation.todolist.repository.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.generation.todolist.controller.dto.ItemDTO;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController( @Autowired ItemService itemService )
    {
        this.itemService = itemService;
    }

    //display all
    @CrossOrigin
    @GetMapping( "/all" )
    public Iterable<Item> getItems()
    {
        return itemService.all();
    }

    //get by specific id
    @CrossOrigin
    @GetMapping( "/{id}" )
    public Item findItemById( @PathVariable Integer id )
    {
        return itemService.findById( id );
    }

    //delete
    @CrossOrigin
    @DeleteMapping( "/{id}" )
    public void delete( @PathVariable Integer id )
    {
        itemService.delete( id );
    }

    //set up post mapping and request
    @CrossOrigin
    @PostMapping("/add")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    public void save(
            @RequestParam(name="title", required = true) String title,
            @RequestParam(name="description", required = true) String description,
            //@RequestParam(name="date", required = true) String date)
    @RequestParam(name="date", required = true) Date date)

    {

        ItemDTO itemDto = new ItemDTO(title, description, date);
        itemService.save(new Item(itemDto));

    }
}
