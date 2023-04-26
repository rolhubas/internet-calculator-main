package com.spring.calculator.service;

import com.spring.calculator.model.Number;
import com.spring.calculator.model.NumberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
// @Service t.y. sluoksnis skirtas "verslo" logikai, gal rasys i DB o galnores i txt faila, gali greit pakeisti GRUD
// po servizo sluoksnio kreipemes i  duomenu baze (DAO)
@Service

public class NumberServiceImpl implements NumberService {

    // @Autowired naudojama automatiniai priklausomybiu injekcijei ( IOC arba inversion of control)
    // kad panaudoti @Autowired  anotacija reikia pirmiausia tureti apsirasius @Bean ir @Configuration klase
    @Autowired
    // @Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkreciai Bean susieti priklausomybe,
    // jeigu @Configuratio klaeje yra daugiau negu vienas Bean, @Qualifier anotacija yra privaloma, kitu atveju klaida:
    // 'Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
    // or using @Qualifier to identify the bean that should be consumed'
    @Qualifier("NumberDAO") // SVARBU, interfeiso pavadinimas, unikalus Bean indentifikatorius
    private NumberDAO numberDAO;

    @Override
    public void insert(Number number) {
        numberDAO.insertEntity(number);

    }

    @Override
    public Number getById(int id) {
        return numberDAO.findEntityById(id);
    }

    @Override
    public List<Number> getall() {
        return numberDAO.findEntities();
    }

    @Override
    public void update(Number number) {
        numberDAO.updateEntity(number);

    }

    @Override
    public void delete(int id) {
        numberDAO.removeEntityById(id);

    }
}
