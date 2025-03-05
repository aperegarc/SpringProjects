package com.aperegarc.SpringBoot.service;

import java.util.List;

import com.aperegarc.SpringBoot.entity.Tarea;

public interface TareaService {
    
    public List<Tarea> getAllTareas();
    public List<Tarea> getTareas(Long id);
    public Tarea getTarea(Integer idTarea);
    public Tarea saveTarea(Tarea tarea);
    public List<Tarea> deleteTarea(Long id);
}
