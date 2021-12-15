package com.company.database.repository;

import com.company.database.Storage;
import com.company.database.model.Abonent;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Catalog implements Storage {

    public boolean findNumber(String surname) {
        try (Scanner in = new Scanner(new File("file.txt"))) {
            String[] s;

            boolean foundPerson = false;
            while (in.hasNextLine()) {
                s = in.nextLine().split(" ");
                if (s[0].equals(surname)) {
                    System.out.println(surname + " имеет номер: " + s[3]);
                    foundPerson = true;
                    break;
                }
            }
            if (!foundPerson) {
                System.out.println(surname + " не найден");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }


    public String[] findName(String number) {
        try (Scanner in = new Scanner(new File("file.txt"))) {
            String[] s;

            boolean foundNumber = false;
            while (in.hasNextLine()) {
                s = in.nextLine().split(" ");
                if (s[3].equals(number)) {
                    System.out.println(number + " имеет номер: " + s[0] + " " + s[1]);
                    foundNumber = true;
                    break;
                }
            }
            if (!foundNumber) {
                System.out.println(number + " не найден");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    public void deleteContact(String surname) throws IOException {
        Scanner in = new Scanner(new File("file.txt"), "UTF-8");
        List<String> data = new ArrayList<>();
        String check = null;
        while (in.hasNextLine()) {
            check = in.nextLine();
            if (!check.startsWith(surname))
                data.add(check);
            System.out.println("Контакт удален");
        }
        if (check == null) {
            System.out.println(" Контакт не найден");
        }
        PrintWriter out = new PrintWriter(new FileWriter("file.txt", false));
        for (String s : data)
            out.println(s);
        in.close();
        out.close();
    }


    @Override
    public boolean addAbonent(Abonent abonent) {
        System.out.println("Сохранить контакт " + abonent.getSurname() + " " + abonent.getName() + " : " + abonent.getPhoneNumber());
        try (PrintWriter pw = new PrintWriter(new FileWriter("file.txt", true))) {
            pw.println(abonent.getSurname() + " " + abonent.getName() + " : " + abonent.getPhoneNumber());
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateAbonent(Abonent abonent) {
        return false;
    }

    @Override
    public boolean deleteAbonent(Long id) {
        return false;
    }

    @Override
    public boolean deleteAbonentBySurname(String surname) {
        return false;
    }

    @Override
    public Abonent getAbonent(Long id) {
        return null;
    }

    @Override
    public List<Abonent> findAbonents() {
        return null;
    }
}
