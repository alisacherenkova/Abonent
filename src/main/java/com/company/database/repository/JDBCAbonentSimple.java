package com.company.database.repository;


import com.company.database.ConnectionManager;
import com.company.database.Extractor;
import com.company.database.Storage;
import com.company.database.model.Abonent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class JDBCAbonentSimple implements Storage {


    private ConnectionManager connectionManager = ConnectionManager.getInstance();
    private Extractor<Abonent> extractor = rs -> {
        List<Abonent> abonents = new ArrayList<>();
        while (rs.next()) {
            final Abonent abonent = new Abonent(
                    rs.getString("surname"),
                    rs.getString("name"),
                    rs.getString("phone_number")
            );
            abonent.setId(rs.getLong("id"));
            abonents.add(abonent);
        }
        return abonents;
    };

    @Override
    public boolean addAbonent(Abonent abonent) {
        return update(String.format(
                "INSERT INTO abonent (SURNAME, NAME, PHONE_NUMBER) " +
                        "VALUES ('%s', '%s', '%s')",
                abonent.getSurname(), abonent.getName(), abonent.getPhoneNumber()));
    }

    @Override
    public boolean updateAbonent(Abonent abonent) {
        return update(String.format(
                "UPDATE abonent " +
                "SET surname = '%s', " +
                "    name = '%s', " +
                "    phone_number = '%s'"+
                "WHERE id = %d; ",
                abonent.getSurname(), abonent.getName(), abonent.getPhoneNumber(), abonent.getId()));
    }

    @Override
    public boolean deleteAbonent(Long id) {
        return update(String.format("DELETE FROM abonent WHERE id = %d;", id));
    }

    @Override
    public boolean deleteAbonentBySurname(String surname) {
        return update(String.format("DELETE FROM abonent WHERE surname = '%s';", surname));
    }


    @Override
    public Abonent getAbonent(Long id) {
        final List<Abonent> abonents = executeSelect(String.format("SELECT * FROM abonent WHERE ID = %d", id), extractor);
        return abonents.size() > 0 ? abonents.get(0) : null;
    }

    @Override
    public List<Abonent> findAbonents() {
        return executeSelect("SELECT * FROM abonent", extractor);
    }


    private <T> List<T> executeSelect(String query, Extractor<T> extractor) {
        try (
                Connection connection = connectionManager.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet resultSet = statement.executeQuery(query);
            return extractor.extract(resultSet);
        } catch (SQLException e) {
            System.out.println("Unable to get data: " + e.getMessage());
        }
        return Collections.emptyList();
    }

    private boolean update(String query) {
        try (
                Connection connection = connectionManager.getConnection();
                Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {
            System.out.println("Unable to get data: " + e.getMessage());
            return false;
        }
    }

}
