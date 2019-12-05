package com.example.parkingprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ListItem  {

    private String head;
    private String desc;

    public ListItem(String name, String occupied_spaces, String capacity, String disability, String longitude, String head, String desc){
        this.head = head;
        this.desc = desc;
    }

    public String getHead() {return head;}

    public String getDesc() {return desc;}
    }

