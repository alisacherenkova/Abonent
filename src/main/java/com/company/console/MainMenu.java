package com.company.console;

import com.company.AbonentManager;
import com.company.database.model.Abonent;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
    //Catalog m = new Catalog();
    //private Page page = new AbonentPage();
    public void displayMenu() {
        //page.open();
        try (Scanner in = new Scanner(System.in)) {
            AbonentManager am = new AbonentManager();
            String surname, name;

            do {
                System.out.println("\nВыберите номер действия(1, 2, 3 ...)");
                System.out.println("1.Сохранить контакт");
                System.out.println("2.Найти номер телефона по фамилии ");
                System.out.println("3.Найти фамилию и имя по номеру");
                System.out.println("4.Найти фамилию, имя, номер по ID");
                System.out.println("5.Удалить контакт по фамилии");
                System.out.println("6.Удалить контакт по ID");
                System.out.println("7.Изменить определенный контакт");
                System.out.println("8.Вывести всех абонентов");

                int choise = in.nextInt();
                in.nextLine();

                switch (choise) {
                    case 1:
                        System.out.println("\nФамилия контакта: ");
                        surname = in.nextLine();
                        System.out.println("\nИмя контакта: ");
                        name = in.nextLine();
                        System.out.println("\nНомер абонента: ");
                        String number = in.nextLine();
                        Abonent ab = new Abonent(surname, name, number);
                        am.addAbonent(ab);
                        System.out.println("ДОБАВЛЕН: " + surname + " " + name + " " + number);

                        break;

                    case 2:
                        System.out.println("\nФамилия контакта, номер которого необходимо найти: ");
                        //Abonent abonent = cm.getAbonent();
                        boolean foundNumber = false;
                        String s = in.nextLine();
                        List<Abonent> result2 = am.findAbonents();
                        for (Abonent a : result2) {
                            if (s.equals(a.getSurname())) {
                                System.out.println(a.getName() + " " + a.getPhoneNumber());
                                foundNumber = true;
                            }
                        }
                        if (!foundNumber) {
                            System.out.println(s + " не найден");
                        }
                        //cm.findAbonent(in.nextLine());
                        //Abonent abonent = cm.getAbonent(cId2);
                        //System.out.println(abonent);
                        //m.findNumber(in.nextLine());
                        break;

                    case 3:
                        System.out.println("\nНомер абонента, фамилию и имя которого необходимо найти: ");
                        boolean foundSurname = false;
                        String n = in.nextLine();
                        List<Abonent> result3 = am.findAbonents();
                        for (Abonent a : result3) {
                            if (n.equals(a.getPhoneNumber())) {
                                System.out.println(a.getSurname() + " " + a.getName());
                                foundSurname = true;
                            }
                        }
                        if (!foundSurname) {
                            System.out.println("Абонент не найден");
                        }
                        //m.findName(in.nextLine());
                        break;

                    case 4:
                        System.out.println("\nID абонента, которого необходимо найти: ");
                        boolean foundId = false;
                        Long id = in.nextLong();
                        List<Abonent> result4 = am.findAbonents();
                        for (Abonent a : result4) {
                            if (id.equals(a.getId())) {
                                System.out.println(a);
                                foundId = true;
                            }
                        }
                        if (!foundId) {
                            System.out.println("Абонент не найден");
                        }
                        //m.findName(in.nextLine());
                        break;

                    case 5:
                        System.out.println("\nФамилия абонента, которого необходимо удалить: ");
                        //cm.deleteAbonent(in.nextInt());
                        String d = in.nextLine();
                        boolean r = am.deleteAbonentBySuranme(d);

                        //am.deleteAbonentBySuranme(d);
                        if (r) {
                            System.out.println("Контакт удален");
                        } else
                            System.out.println("Такого контакта нет");
                        //List<Abonent> result5 = am.findAbonents();

                        //System.out.println("УДАЛЕН: " + d);
                        break;

                    case 6:
                        System.out.println("\nID абонента, которого необходимо удалить: ");
                        //cm.deleteAbonent(in.nextInt());
                        Long id1 = in.nextLong();
                        boolean m = am.deleteAbonent(id1);
                        if (m) {
                            System.out.println("Контакт удален");
                        } else
                            System.out.println("Такого контакта нет");
                        //System.out.println("УДАЛЕН " );
//                        List<Abonent> result5 = am.findAbonents();
//                        for (Abonent a : result5) {
//                            System.out.println(a);
//                        }
                        break;

                    case 7:
                        System.out.println("\nФамилия абонента, на которую необходимо изменить: ");

                        String sur = in.nextLine();
                        System.out.println("\nИмя абонента, на которое необходимо изменить: ");
                        String nam = in.nextLine();
                        System.out.println("\nНомер абонента, на который необходимо изменить: ");
                        String phon = in.nextLine();
                        System.out.println("\nID абонента, данные которого необходимо изменить: ");
                        Long i = in.nextLong();
                        Abonent abon = new Abonent(i, sur, nam, phon);
                        am.updateAbonent(abon);
                        List<Abonent> result7 = am.findAbonents();
//                        for (Abonent a : result7) {
//                            if (u.equals(a.getId())) {
//                                am.updateAbonent(a);
//                            }
//                        }
                        break;
                    case 8:
                        List<Abonent> result8 = am.findAbonents();

                        for (Abonent a : result8) {
                            System.out.println(a);
                        }
                        break;

                    default:
                        break;
                }

                System.out.println("Хотите ли выполнить еще действие?(1 - да/2 - нет)");
                if (in.next().toLowerCase().charAt(0) != '1')
                    break;

            } while (true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
