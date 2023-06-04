package com.example.apitest_java17_springboot3.services;
import com.example.apitest_java17_springboot3.models.Cita;
import com.example.apitest_java17_springboot3.repositories.ICitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class CitaService {
    //instanciar la interface de repository
    private ICitaRepository citaRepository;
    //inyección de dependencias en el contructor mecomendado para las pruebas unitarias "Buena Practica"
    @Autowired
    public CitaService(ICitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    //Method to create
    public Cita createCita(Cita cita) {
        return citaRepository.save(cita);
    }

    //Method to list all
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }

    //Method to search by specific id
    public Optional<Cita> buscarId(Long id) {
        return citaRepository.findById(id);
    }

    //Method to update
    public Cita actualizarCita(Long id, Cita cita) {
        cita.setId(cita.getId());
        return citaRepository.save(cita);
    }

    //method to remove
//    public void eliminarPorId(Long id) {
//        citaRepository.deleteById(id);
//    }

    public void deleteCita(Long id) {
        // Get the cita from the database.
        Cita cita = citaRepository.findById(id).get();

        // Change the state of the cita to "deleted".
        cita.setEstado("Eliminada");

        // Save the cita to the database.
        citaRepository.save(cita);
    }

    public void actualizarCitaEstado(Long id, String estado) {
        // Get the cita from the database.
        Cita cita = citaRepository.findById(id).get();
        // Change the state of the cita.
        cita.setEstado(estado);
        // Save the cita to the database.
        citaRepository.save(cita);
    }



    //Methods to search according to attributes of the class
    public List<Cita> buscarNombre(String nombre) {
        return citaRepository.findBynombre(nombre);
    }

    public List<Cita> buscarFecha(Date fecha) {
        return citaRepository.findByfecha(fecha);
    }

    public List<Cita> buscarHora(LocalTime hora) {
        return citaRepository.findByhora(hora);
    }

    public List<Cita> buscarDuracion(int duracion) {
        return citaRepository.findByduracion(duracion);
    }

    public List<Cita> buscarUbicacion(String ubicacion) {
        return citaRepository.findByubicacion(ubicacion);
    }
    public List<Cita> buscarDetalles(String detalles) {
        return citaRepository.findBydetalles(detalles);
    }
    public List<Cita> buscaEstado(String estado) {
        return citaRepository.findByestado(estado);
    }


}

