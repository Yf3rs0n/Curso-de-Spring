package com.example.apitest_java17_springboot3.repositories;

import com.example.apitest_java17_springboot3.models.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
public interface ICitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findBynombre(String nombre);
    List<Cita> findByfecha(Date fecha);
    List<Cita> findByhora(LocalTime hora);
    List<Cita> findByduracion(int duracion);
    List<Cita> findByubicacion(String ubicacion);
    List<Cita> findBydetalles(String detalles);
    List<Cita> findByestado(String estado);
    //hora minina
    //estados varios

}
