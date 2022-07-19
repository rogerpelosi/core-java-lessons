package org.example;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCustomDataStructure implements Iterable<String>{

    //store data, handle only string
    private String[] storage;
    private int capacity;
    private int itemsStored;
    private int currentIndex;

    //create constructor with default length
    public MyCustomDataStructure(){
        this.capacity = 10;
        storage = new String[this.capacity];

    }

    //for custom capacity
    public MyCustomDataStructure(int capacity){
        this.capacity = capacity;
        storage = new String[capacity];
    }

    //to add items to our arr
    public void add(String item){
        //if no space to add string based on current capacity
       if(this.currentIndex == this.capacity){
           throw new StorageFullException();
       }
       //when adding item increment current index
       storage[currentIndex++] = item;
       itemsStored++;
    }

    public int size(){
        return itemsStored;
    }

    //method being specified in iterable, return type iterator
    //requires access to storage and other properties, so it cant be external type or else the code will be lengthy bc of security and accessibility
    //so we need an inner class
    @Override
    public Iterator<String> iterator() {
        return new MySataStructureIterator();
    }

    private class MySataStructureIterator implements Iterator<String>{

        private int currentIteratorPosition;
        private int totalIterableItems;

        MySataStructureIterator(){
            this.totalIterableItems = itemsStored;
        }

        @Override
        public boolean hasNext() {
            if(currentIteratorPosition == totalIterableItems){
                //if it has reached the last position
                return false;
            }
            return true;
        }

        @Override
        public String next() {
           if(totalIterableItems != itemsStored){
               throw new ConcurrentModificationException();
               //
           } else if(currentIteratorPosition == totalIterableItems){
               throw new NoSuchElementException();
           }
           return storage[currentIteratorPosition++];
        }

        @Override
        public void remove() {
        }
    }

}
