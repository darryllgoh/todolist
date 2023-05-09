package org.generation.todolist.repository.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.generation.todolist.controller.dto.ItemDTO;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Item {

    //Properties/attributes - will be mapped to the columns of the database table
    //Need to use the Wrapper class on primitive data types - need to pass the datatype
    // as an object to CRUDRepository Class (provided by SpringBoot framework)


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  //retrieve product item by ID - has to be an object


    private String title;
    private String description;
    //private String date;

    private Date date;


    public Item() {}

    public Item(ItemDTO itemDTO)
    {
        //Transfer the object (with the data) to Entity Class for mapping with the
        // database table columns and to be able to save the data in the columns
        this.title = itemDTO.getTitle();
        this.description = itemDTO.getDescription();
        this.date = itemDTO.getDate();
    }


    public Integer getId()
    {
        return id;
    }


    public void setId( Integer id )
    {
        this.id = id;
    }


    public String getTitle()
    {
        return title;
    }


    public void setTitle( String title )
    {
        this.title = title;
    }


    public String getDescription()
    {
        return description;
    }


    public void setDescription( String description )
    {
        this.description = description;
    }

//    public String getDate()
//    {
//        return date;
//    }
//
//    public void setDate( String date )
//    {
//        this.date = date;
//    }

    public Date getDate() {return date;}
    public void setDate( Date date ) {this.date = date;}



    @Override
    public String toString()
    {
        return "Item{" + "id=" + id + ", title='" + title + '\'' + ", description='" +
                description + '\'' + ". date='" + date + '\'' +
                '}';
    }

}