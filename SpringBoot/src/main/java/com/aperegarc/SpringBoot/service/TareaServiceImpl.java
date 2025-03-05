
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

    
    
}