package com.example.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.TipoIdentificacion;
import com.example.service.ITipoIdentificacionService;

@RestController
@RequestMapping("/api/tipo-identificacion")
public class TipoIdentificacionRest {

	@Autowired
	private ITipoIdentificacionService service;

	@GetMapping("")
	public List<TipoIdentificacion> listarTodos() {
		return service.listarTodos();
	}

}
