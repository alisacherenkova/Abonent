package com.company.database;


import com.company.database.model.Abonent;

import java.util.List;

public interface Storage {
    boolean addAbonent(Abonent abonent);
    boolean updateAbonent(Abonent abonent);
    boolean deleteAbonent(Long id);
    boolean deleteAbonentBySurname(String surname);
    Abonent getAbonent(Long id);
    List<Abonent> findAbonents();
    //void saveContact(String surname, String name, String number);
    //String[] findNumber(String surname);
    //String[]  findName(String number);
    //void deleteContact(String surname) throws IOException;
}
