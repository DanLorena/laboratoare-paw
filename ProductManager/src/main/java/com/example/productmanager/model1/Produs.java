package com.example.productmanager.model1;



public class Produs {
    private Long id;
    private String nume;
    private Double pret;
    private Integer stoc;

    public Produs() {}

    public Produs(Long id, String nume, Double pret, Integer stoc) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.stoc = stoc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public Integer getStoc() {
        return stoc;
    }

    public void setStoc(Integer stoc) {
        this.stoc = stoc;
    }
}

