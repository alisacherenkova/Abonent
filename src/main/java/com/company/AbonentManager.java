package com.company;

import com.company.database.Storage;
import com.company.database.StorageFactory;
import com.company.database.model.Abonent;

import java.util.List;

public class AbonentManager {
    private Storage st;

    public AbonentManager() {
        st = StorageFactory.getStorage();
    }

    public boolean addAbonent(Abonent abonent) {
        return st.addAbonent(abonent);
    }

    public boolean updateAbonent(Abonent abonent) {
        return st.updateAbonent(abonent);
    }

    public boolean deleteAbonent(Long id) {
       return st.deleteAbonent(id);
    }

    public boolean deleteAbonentBySuranme(String surname) {
        return st.deleteAbonentBySurname(surname);

    }

    public Abonent getAbonent(Long id) {
        return st.getAbonent(id);
    }

    public List<Abonent> findAbonents() {
        return st.findAbonents();
    }
}
