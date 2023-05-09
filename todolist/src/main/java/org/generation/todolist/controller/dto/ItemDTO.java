package org.generation.todolist.controller.dto;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;



public class ItemDTO {


    private String title;
    private String description;
    //private String date;

    private Date date;


    public ItemDTO(String title, String description, Date date) //String date
    {
        this.title = title;
        this.description = description;
        this.date = date;
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
//
//    public void setDate( String date )
//    {
//        this.date = date;
//    }

    public Date getDate() {return date;}
    public void setDate( Date date) {this.date = date; }


}
