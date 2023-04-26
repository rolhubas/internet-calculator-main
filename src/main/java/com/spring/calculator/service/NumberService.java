package com.spring.calculator.service;

import com.spring.calculator.model.Number;

import java.util.List;

// 04.26 Sluoksnis ant DB skirti verslo logikai aprasyti,
public interface NumberService {
    void insert(Number number);
    Number getById(int id);
    List<Number> getall();

    void update(Number number);
    void delete(int id);

}
