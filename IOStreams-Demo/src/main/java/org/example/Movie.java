package org.example;

import java.io.Serializable;

public class Movie implements Serializable {

    private static long classic = 1L; //static makes it from being serialized in general
    private transient int id; //add transient to prevent serialization of actual ID or whatever value
    private String name;

    public Movie(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}

//Reading and writing operations right now using Basic I/O Streams will block subsequent read/write operations

//NIO -- new input output -- provides better approach to read/write operations (non blocking)

//no need to manually instantiate streams
