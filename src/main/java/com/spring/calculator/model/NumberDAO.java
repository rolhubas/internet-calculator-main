package com.spring.calculator.model;

import java.util.List;

// 04.26 metodu antrastes, kuriam CRUD
public interface NumberDAO {

    void insertEntity(Number number);
    Number findEntityById(int id);
    List<Number> findEntities();

    void updateEntity(Number number);
    void removeEntityById(int id);

}
