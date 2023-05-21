package com.example.ejerciciosesiones456.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String memoria;
    private String almacenamiento;
    private String pantalla;
    private Double price;


    public Laptop() {
    }

    public Laptop(Long id, String marca, String memoria, String almacenamiento, String pantalla, Double price) {
        this.id = id;
        this.marca = marca;
        this.memoria = memoria;
        this.almacenamiento = almacenamiento;
        this.pantalla = pantalla;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getmemoria() {
        return memoria;
    }

    public void setmemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

