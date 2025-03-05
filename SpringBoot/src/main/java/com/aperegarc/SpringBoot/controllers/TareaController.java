package com.aperegarc.SpringBoot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aperegarc.SpringBoot.entity.Tarea;
import com.aperegarc.SpringBoot.service.TareaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    TareaService tareaService;


    @GetMapping
    public List<Tarea> allTareas(){
        return tareaService.getAllTareas();
    }

    @GetMapping("/{id}")
    public List<Tarea> listarTareas(@PathVariable Long id) {
        return tareaService.getTareas(id);
    }

    @GetMapping("/tarea/{id}")
    public Tarea mostrarTarea(@PathVariable Integer idTarea) {
        return tareaService.getTarea(idTarea);
    }

    @PostMapping
    public Tarea addTarea(@RequestBody Tarea tarea){
        tareaService.saveTarea(tarea);

        return tarea;
    }

    @DeleteMapping("/{id}")
    public List<Tarea> borrarTarea(@PathVariable Long id){
        tareaService.deleteTarea(id);
        return tareaService.getAllTareas();
    }

    @PutMapping("/{id}")
    public Tarea modificarTarea(@PathVariable Integer id, @RequestBody Tarea nuevaTarea){
        Tarea tareaVieja = tareaService.getTarea(id);
        tareaService.modificarTarea(id.longValue(), nuevaTarea);
        return nuevaTarea;
    }

}
