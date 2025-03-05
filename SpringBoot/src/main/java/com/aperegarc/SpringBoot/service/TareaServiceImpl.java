
package com.aperegarc.SpringBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.aperegarc.SpringBoot.entity.Tarea;
import com.aperegarc.SpringBoot.repository.TareaRepository;



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
        Integer idCliente = tareaRepository.findById(id.intValue()).get().getCliente().getId();

        tareaRepository.deleteById(id.intValue());;

        return this.getTareas(idCliente.longValue());
    }

    
    
}