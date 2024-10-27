package com.example.peliculasSpring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.peliculasSpring.domain.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    
}
