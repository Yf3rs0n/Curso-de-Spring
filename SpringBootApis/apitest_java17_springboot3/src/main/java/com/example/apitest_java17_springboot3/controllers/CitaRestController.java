package com.example.apitest_java17_springboot3.controllers;

import com.example.apitest_java17_springboot3.models.Cita;
import com.example.apitest_java17_springboot3.services.CitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/citas")
public class CitaRestController {

    private CitaService citaService;

    @Autowired
    public CitaRestController(CitaService citaServicel) {
        this.citaService = citaServicel;
    }

    @PostMapping(value = "crear",headers = "Accept=application/json")
    public ResponseEntity<Cita> createCita(@RequestBody Cita cita) {
        Cita createdCita = citaService.createCita(cita);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCita);
    }

    @GetMapping(value = "listar",headers = "Accept=application/json")
    public ResponseEntity<List<Cita>> listarCitas() {
        List<Cita> citas = citaService.listarCitas();
        return ResponseEntity.ok(citas);
    }

    @GetMapping(value = "/{id}",headers = "Accept=application/json")
    public ResponseEntity<Optional<Cita>> buscarId(@PathVariable Long id) {
        Optional<Cita> cita = citaService.buscarId(id);
        return ResponseEntity.of(Optional.ofNullable(cita));
    }

    @PutMapping(value = "/{id}",headers = "Accept=application/json")
    public ResponseEntity<Cita> actualizarCita(@PathVariable Long id, @RequestBody Cita cita) {
        Cita updatedCita = citaService.actualizarCita(id, cita);
        return ResponseEntity.ok(updatedCita);
    }

    @PutMapping(value = "/eliminar/{id}",headers = "Accept=application/json")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        citaService.deleteCita(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/estado/{id}", headers = "Accept=application/json")
    public ResponseEntity<Cita> actualizarEstado(@PathVariable Long id, @RequestBody Cita cita) {
        // Call the service method to update the cita.
        citaService.actualizarCitaEstado(id, cita.getEstado());
        // Return a 200 OK status code with the cita in the response payload body.
        return ResponseEntity.ok(cita);
    }

    @GetMapping(value = "/nombre/{nombre}",headers = "Accept=application/json")
    public ResponseEntity<List<Cita>> buscarNombre(@PathVariable String nombre) {
        List<Cita> citas = citaService.buscarNombre(nombre);
        return ResponseEntity.ok(citas);
    }

    @GetMapping(value = "/fecha/{fecha}",headers = "Accept=application/json")
    public ResponseEntity<List<Cita>> buscarFecha(@PathVariable Date fecha) {
        List<Cita> citas = citaService.buscarFecha(fecha);
        return ResponseEntity.ok(citas);
    }

    @GetMapping(value = "/hora/{hora}",headers = "Accept=application/json")
    public ResponseEntity<List<Cita>> buscarHora(@PathVariable LocalTime hora) {
        List<Cita> citas = citaService.buscarHora(hora);
        return ResponseEntity.ok(citas);
    }

    @GetMapping(value = "/duracion/{duracion}",headers = "Accept=application/json")
    public ResponseEntity<List<Cita>> buscarDuracion(@PathVariable int duracion) {
        List<Cita> citas = citaService.buscarDuracion(duracion);
        return ResponseEntity.ok(citas);
    }

    @GetMapping(value = "/ubicacion/{ubicacion}",headers = "Accept=application/json")
    public ResponseEntity<List<Cita>> buscarUbicacion(@PathVariable String ubicacion) {
        List<Cita> citas = citaService.buscarUbicacion(ubicacion);
        return ResponseEntity.ok(citas);
    }
    @GetMapping(value = "/detalles/{detalles}",headers = "Accept=application/json")
    public ResponseEntity<List<Cita>> buscarDetalles(@PathVariable String detalles) {
        List<Cita> citas = citaService.buscarDetalles(detalles);
        return ResponseEntity.ok(citas);
    }
    @GetMapping(value = "/estado/{estado}",headers = "Accept=application/json")
    public ResponseEntity<List<Cita>> buscaEstado(@PathVariable String estado) {
        List<Cita> citas = citaService.buscaEstado(estado);
        return ResponseEntity.ok(citas);
    }

}

