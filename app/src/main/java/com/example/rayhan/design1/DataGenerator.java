package com.example.rayhan.design1;

/**
 * Created by Rayhan on 3/22/2018.
 */

public class DataGenerator {


    private static DataGenerator instance;
    private static AppDataBase dataBase;


    public static DataGenerator with(AppDataBase appDataBase) {

        if (dataBase == null)
            dataBase = appDataBase;

        if (instance == null)
            instance = new DataGenerator();

        return instance;
    }



    private Address addressInstance(String street, String state, String city, int postCode) {
        Address address = new Address();

        address.street = street;
        address.state = state;
        address.city = city;
        address.postCode = postCode;

        return address;
    }


    public void generateAddress() {
        if (dataBase == null)
            return;

        Address[] addresses = new Address[4];
        addresses[0] = addressInstance("Dhaka","Bangladesh","Paltan",5);
        addresses[1] = addressInstance("India","West Bengle","kolkata",7);
        addresses[2] = addressInstance("Dubai","ramjan","Katar",8);
        addresses[3] = addressInstance("Noakhali","BARISAL","UK",7);

        dataBase.addressDao().insert(addresses);
    }



}