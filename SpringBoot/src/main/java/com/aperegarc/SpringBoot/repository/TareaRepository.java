package com.aperegarc.SpringBoot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aperegarc.SpringBoot.entity.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {

    // Consulta personalizada con JPQL para obtener tareas de un user
    @Query("SELECT t FROM Tarea t WHERE t.user.id = :userId")
    List<Tarea> findByUserId(Long userId);

    // Consulta personalizada para obtener una tarea específica de un user
    @Query("SELECT t FROM Tarea t WHERE t.id = :tareaId AND t.user.id = :userId")
    Optional<Tarea> findByUserIdAndTareaId(Long userId, Long tareaId);

}
