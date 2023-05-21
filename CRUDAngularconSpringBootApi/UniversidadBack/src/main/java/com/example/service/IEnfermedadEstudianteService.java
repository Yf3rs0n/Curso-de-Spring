package com.example.service;

import java.util.List;

import com.example.modelo.EnfermedadEstudiante;

public interface IEnfermedadEstudianteService extends ICrudService<EnfermedadEstudiante> {

	public List<EnfermedadEstudiante> listarPorIdEstudiante(int idEstudiante);
}
