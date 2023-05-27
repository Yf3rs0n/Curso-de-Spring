package com.example.apitest_java17_springboot3.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.Time;
import java.util.Date;

//@Data
@Getter
@Setter
@NoArgsConstructor//constructor sin parametros
@AllArgsConstructor//constructor com parametros
@Entity
@Table(name = "citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "hora")
    private Time hora;

    @Column(name = "duracion")
    private int duracion;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "detalles", columnDefinition = "TEXT")
    private String detalles;

    @Column(name = "estado")
    private String estado;

    @Column(name = "tipo_cita")
    private String tipo_cita;

    @Column(name = "notas_internas", columnDefinition = "TEXT" )
    private String notas_internas;



}
