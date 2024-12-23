package com.example.peliculasSpring.repository;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.peliculasSpring.domain.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    List<Pelicula> findByNombreContainingIgnoreCase(String nombre);

    Page<Pelicula> findAll(Pageable pageable);
  

    
}
