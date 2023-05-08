package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    //atrubutos
    private BookRepository bookRepository;
    //constructor
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //CRUD
    /**
     * Busca en BD (ArrayList libros)
     * http://localhost:80/api/books
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findAll(){
        //Recuperar y Devolver los libros de la BD
        return bookRepository.findAll();

    }

    /**
     * Buscar por ID
     * http://localhost:80/api/books/1
     * Request - Peticion
     * Response - Respuesta
     * @param id
     * @return
     */
    @GetMapping("/api/books/{id}")//Buscador
    public ResponseEntity<Book> findOneById(@PathVariable Long id){//Para que funcione\
        Optional <Book> bookOpt = bookRepository.findById(id);
        //opcion 1
        if (bookOpt.isPresent())//Si existe el libro o no
            return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();
        //opcion 2
        //return bookOpt.orElse(null);
        //return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Metodo Post, no coliciona con findAll porque son diferentes metodos Http: Get vs Post
     * @param book
     * @param headers
     * @return
     */
    //Crear - Guardar
    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));//Leer las cabeceras
        //Guardar el libro recibido por parametro en la base de datos
        return bookRepository.save(book);// se genera el libro devuelto tiene una clave primaria
    }
    //Actializar

    //Borrar
}
