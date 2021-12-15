package com.company.database.repository;

import com.company.database.Storage;
import com.company.database.model.Abonent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class AbonentSimple implements Storage {
    private static AtomicLong atomicLong = new AtomicLong(1);

    private final List<Abonent> abonents = new ArrayList<Abonent>();

    @Override
    public boolean addAbonent(Abonent abonent) {
        Long id = generateIdAbonent();
        abonent.setId(id);
        return abonents.add(abonent);

    }

    @Override
    public boolean updateAbonent(Abonent abonent) {
        Abonent oldAbonent = getAbonent(abonent.getId());
        if (oldAbonent != null) {
            oldAbonent.setSurname(abonent.getSurname());
            oldAbonent.setName(abonent.getName());
            oldAbonent.setPhoneNumber(abonent.getPhoneNumber());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAbonent(Long id) {
        return abonents.removeIf(abonent -> Objects.equals(abonent.getId(), id));
    }

    @Override
    public boolean deleteAbonentBySurname(String surname) {
        return abonents.removeIf(abonent -> Objects.equals(abonent.getSurname(), surname));
    }


    @Override
    public Abonent getAbonent(Long id) {
        for (Abonent abonent : abonents) {
            if (Objects.equals(abonent.getId(), id)) {
                return abonent;
            }
        }
        return null;
    }

    @Override
    public List<Abonent> findAbonents() {
        return List.copyOf(abonents);
    }

    private Long generateIdAbonent() {
        return atomicLong.getAndIncrement();
    }
}
