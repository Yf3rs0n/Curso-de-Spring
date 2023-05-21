package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modelo.TipoIdentificacion;
import com.example.repository.ITipoIdentificacionRepository;
import com.example.service.ITipoIdentificacionService;

@Service
public class TipoIdentificacionServiceImpl implements ITipoIdentificacionService {

	@Autowired
	private ITipoIdentificacionRepository repo;

	@Override
	public List<TipoIdentificacion> listarTodos() {
		return repo.findAll();
	}

	@Override
	public TipoIdentificacion listarPorId(int id) {
		return repo.findById(id).orElse(null);
	}

	@Override
	public void registrar(TipoIdentificacion entidad) {
		repo.save(entidad);
	}

	@Override
	public void actualizar(TipoIdentificacion entidad) {
		repo.save(entidad);
	}

	@Override
	public void eliminar(int id) {
		repo.deleteById(id);
	}

}
