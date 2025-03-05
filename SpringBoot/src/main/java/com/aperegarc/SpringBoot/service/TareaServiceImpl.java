
package com.aperegarc.SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aperegarc.SpringBoot.entity.Tarea;
import com.aperegarc.SpringBoot.repository.TareaRepository;


@Service
public class TareaServiceImpl implements TareaService{

    @Autowired
    TareaRepository tareaRepository;

    public List<Tarea> getAllTareas(){
        return tareaRepository.findAll();
    }

    public List<Tarea> getTareas(Long id){
        return tareaRepository.findByClienteId(id);
    }

    public Tarea getTarea(Integer idTarea){
        Optional<Tarea> tarea = tareaRepository.findById(idTarea);
        if(tarea.isPresent()){
            return tarea.get();
        }else{
            return null;
        }

    }
    
    public Tarea saveTarea(Tarea tarea){
        tareaRepository.save(tarea);
        return tarea;
    }
    
    public List<Tarea> deleteTarea(Long id){

        tareaRepository.deleteById(id.intValue());;

        return tareaRepository.findAll();
    }

    @Override
    public Tarea modificarTarea(Long id, Tarea tarea) {
        Tarea tareaVieja = tareaRepository.findById(id.intValue()).get();
        if(tarea.getContent() != null || tarea.getContent() == ""){
            tareaVieja.setContent(tarea.getContent());
        }
        if(tarea.getEnCurso() != null){
            tareaVieja.setEnCurso(tarea.getEnCurso());
        }
        if(tarea.getName() != null || tarea.getName() == ""){
            tareaVieja.setName(tarea.getName());
        }
        if(tarea.getFechaInicio() != null){
            tareaVieja.setFechaInicio(tarea.getFechaInicio());
        }
        if(tarea.getFechaFin() != null){
            tareaVieja.setFechaFin(tarea.getFechaFin());
        }
        if(tarea.getCliente() != null){
            tareaVieja.setCliente(tarea.getCliente());
        }

        return tareaRepository.save(tareaVieja);
    }

    
    
}