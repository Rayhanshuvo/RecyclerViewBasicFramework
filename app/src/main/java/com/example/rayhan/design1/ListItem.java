package com.example.rayhan.design1;

/**
 * Created by Rayhan on 3/22/2018.
 */

public class ListItem {

    private String head;
    private String description;
    private String test;

    public ListItem(String head, String description,String test) {
        this.head = head;
        this.description = description;
        this.test=test;
    }

    public String getHead() {
        return head;
    }

    public String getDescription() {
        return description;
    }

    public String getTest() {
        return test;
    }
}
