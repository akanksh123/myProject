package com.example.lenovo.dualfragment;

import java.util.ArrayList;

public class AdressBook {
    private static final AdressBook ourInstance = new AdressBook();
    private ArrayList<NameAndAddress2>mNameAndAddress;
    public static AdressBook getInstance() {
        return ourInstance;
    }

    private AdressBook() {
        mNameAndAddress= new ArrayList<NameAndAddress2>();
        NameAndAddress2 tempEntry = new NameAndAddress2("B Obama",
                "The White House",
                "Washington",
                "DC1");
        // Add it to the ArrayList
        mNameAndAddress.add(tempEntry);
        // Create a new entry
        tempEntry = new NameAndAddress2("E Windsor",
                "Buckingham Palace",
                "London",
                "SW1A 1AA");
        // Add it to the ArrayList
        mNameAndAddress.add(tempEntry);
        // Create a new entry
        tempEntry = new NameAndAddress2("V Putin",
                "The Kremlin",
                "Moscow",
                "MS1");

        mNameAndAddress.add(tempEntry);

    }

    public ArrayList<NameAndAddress2> getBook(){
        return mNameAndAddress;
    }
}
