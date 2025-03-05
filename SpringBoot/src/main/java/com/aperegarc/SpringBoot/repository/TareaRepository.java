package com.aperegarc.SpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aperegarc.SpringBoot.entity.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {

    // Consulta personalizada con JPQL para obtener tareas de un cliente
    @Query("SELECT t FROM Tarea t WHERE t.cliente.id = :clienteId")
    List<Tarea> findByClienteId(Long clienteId);

    // Consulta personalizada para obtener una tarea específica de un cliente
    @Query("SELECT t FROM Tarea t WHERE t.id = :tareaId AND t.cliente.id = :clienteId")
    Optional<Tarea> findByClienteIdAndTareaId(Long clienteId, Long tareaId);

}
