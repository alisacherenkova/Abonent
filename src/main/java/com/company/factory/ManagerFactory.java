package com.company.factory;


import com.company.AbonentManager;

public class ManagerFactory {

    private static ManagerFactory INSTANCE;

    private final AbonentManager manager;

    private ManagerFactory() {
        manager = new AbonentManager();
    }

    public static ManagerFactory getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new ManagerFactory();
        }

        return INSTANCE;
    }


    public AbonentManager getManager() {
        return manager;
    }
}
