package com.spring.calculator.model;

import javax.persistence.*;


import jakarta.validation.constraints.Min;
// 04.26 gali puti pervadinta i NumberPojo
@Entity // 04.26 anotacija tai POJO klase sujungta su DB esancia lent naudojant ORM technika
// 04.26 nurodo jog susiesime POJO klase su DB esancia lentele kurios pav "numbers"
@Table(name = "numbers") // 04.26 lenteles DB pavadinimas daugistika
public class Number {
    // 04.26 toliau is https://www.baeldung.com/hibernate-identifiers
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ) // atitinka DB auto increment f-ja
    @Column (name = "id")
    private int id;

    @Column(name = "sk1")
    @Min(value=0, message = "Validacijos Klaida: Skaicius negali buti neigiamas")
    private  int sk1;

    @Column(name = "sk2")
    @Min(value=0, message = "Validacijos Klaida: Skaicius negali buti neigiamas")
    private  int sk2;
    @Column(name = "action")
    private  String action;
    @Column(name = "result")
    private  int result;


    public Number(int id, int sk1, int sk2, String action, int result) {
        this.id = id;
        this.sk1 = sk1;
        this.sk2 = sk2;
        this.action = action;
        this.result = result;
    }

    public Number(){

    }

    public int getSk1() {
        return sk1;
    }

    public void setSk1(int sk1) {
        this.sk1 = sk1;
    }

    public int getSk2() {
        return sk2;
    }

    public void setSk2(int sk2) {
        this.sk2 = sk2;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", sk1=" + sk1 +
                ", sk2=" + sk2 +
                ", action='" + action + '\'' +
                ", result=" + result +
                '}';
    }
}
