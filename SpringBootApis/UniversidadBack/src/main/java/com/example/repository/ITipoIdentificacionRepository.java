package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.modelo.TipoIdentificacion;

@Repository
public interface ITipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Integer> {

}
