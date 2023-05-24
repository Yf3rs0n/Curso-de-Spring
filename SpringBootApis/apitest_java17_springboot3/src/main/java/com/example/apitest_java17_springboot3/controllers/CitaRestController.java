package com.example.apitest_java17_springboot3.controllers;

import com.example.apitest_java17_springboot3.models.Cita;
import com.example.apitest_java17_springboot3.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class CitaRestController {

    private CitaService citaServicel;

    @Autowired
    public CitaRestController(CitaService citaServicel) {
        this.citaServicel = citaServicel;
    }

    @PostMapping
    public ResponseEntity<Cita> createCita(@RequestBody Cita cita) {
        Cita createdCita = citaServicel.createCita(cita);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCita);
    }

    @GetMapping
    public ResponseEntity<List<Cita>> listarCitas() {
        List<Cita> citas = citaServicel.listarCitas();
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cita>> buscarId(@PathVariable Long id) {
        Optional<Cita> cita = citaServicel.buscarId(id);
        return ResponseEntity.of(Optional.ofNullable(cita));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizarCita(@PathVariable Long id, @RequestBody Cita cita) {
        Cita updatedCita = citaServicel.actualizarCita(id, cita);
        return ResponseEntity.ok(updatedCita);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        citaServicel.eliminarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Cita>> buscarNombre(@PathVariable String nombre) {
        List<Cita> citas = citaServicel.buscarNombre(nombre);
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Cita>> buscarFecha(@PathVariable Date fecha) {
        List<Cita> citas = citaServicel.buscarFecha(fecha);
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/hora/{hora}")
    public ResponseEntity<List<Cita>> buscarHora(@PathVariable LocalTime hora) {
        List<Cita> citas = citaServicel.buscarHora(hora);
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/duracion/{duracion}")
    public ResponseEntity<List<Cita>> buscarDuracion(@PathVariable int duracion) {
        List<Cita> citas = citaServicel.buscarDuracion(duracion);
        return ResponseEntity.ok(citas);
    }

    @GetMapping("/ubicacion/{ubicacion}")
    public ResponseEntity<List<Cita>> buscarUbicacion(@PathVariable String ubicacion) {
        List<Cita> citas = citaServicel.buscarUbicacion(ubicacion);
        return ResponseEntity.ok(citas);
    }

}

}
