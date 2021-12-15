package com.company;

import com.company.console.MainMenu;

public class Main {


    public static void main(String[] args){
        new MainMenu().displayMenu();
        //com.company.AbonentManager cm = new com.company.AbonentManager();

        //Abonent c1 = new Abonent("Андрей", "Соколов", Collections.singletonList("+7-911-890-7766"));
        //Abonent c2 = new Abonent("Сергей", "Иванов", Collections.singletonList("+7-911-890-7755"));
        //Abonent c3 = new Abonent("Татьяна", "Семенова", Collections.singletonList("+7-911-890-1164"));

        //System.out.println("ADD CONTACT ==============");
        //int cId1 = cm.addAbonent(c1);
        //int cId2 = cm.addAbonent(c2);
        //int cId3 = cm.addAbonent(c3);
        //List<Abonent> result1 = cm.findAbonent();
        //for(Abonent c : result1) {
        //    System.out.println(c);
        //}

        //System.out.println("UPDATE CONTACT ==============");
        //Abonent change = new Abonent(cId1, "Алексей", "Соколов", Collections.singletonList("+7-911-890-7766"));
        //cm.updateAbonent(change);
        //List<Abonent> result2 = cm.findAbonent();
        //for(Abonent a : result2) {
        //    System.out.println(a);
        //}

        //System.out.println("DELETE CONTACT ==============");
        //cm.deleteAbonent(cId1);
        //List<Abonent> result3 = cm.findAbonent();
        //for(Abonent a : result3) {
        //    System.out.println(a);
        //}

        //System.out.println("GET CONTACT ==============");
        //Abonent abonent = cm.getAbonent(cId2);
        //System.out.println(abonent);
    }
}
