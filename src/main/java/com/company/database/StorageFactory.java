package com.company.database;


import com.company.database.repository.JDBCAbonentSimple;

public class StorageFactory {
    //public static Storage getStorage() {
    //    return new AbonentSimple();
    //}
    //public static Storage storage = new AbonentSimple();
    public static Storage storage = new JDBCAbonentSimple();

    public static Storage getStorage(){
        return storage;
    }
}
