package com.spring.calculator.config;
// 04.26 Klase skirta sukurti entity maneger factory, kaip vadyba su DB

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    // persistence.xml toks pats pavad "PERSISTENCE"
    private static final String PERSISTENCE_UNIT_NAME = "PERSISTENCE";

    private static EntityManagerFactory entityManagerFactory;

    // 04.26 EntityManagerFactory per aplikacijos veikima bus tik viena( sesiju gali buti daug...)
    // 04.26 EntityManagerFactory veikia Singleton sablonu (patern)

    // JPAUtil yra pagalbinė klasė, skirta padėti inicializuoti ir konfigūruoti Java Persistence API
    // (JPA) objektų valdymo kontekstą. Ši klasė gali būti naudojama pradiniame programos paleidime,
    // kad būtų sukurtas ir sukonfigūruotas EntityManagerFactory objektas.

    /**
     * uztikrina kad bus vienas
     * jei tuscia sukuria
     * @return kitu atveju grazina uzpildyta
     */
    public static EntityManagerFactory getEntityManagerFactory(){
        if (entityManagerFactory == null){
            entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
        return entityManagerFactory;
    }

    public static void shutdown(){
        if (entityManagerFactory != null){
            entityManagerFactory.close();
        }
    }

}
