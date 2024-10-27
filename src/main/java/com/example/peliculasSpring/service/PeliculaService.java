package com.example.peliculasSpring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.peliculasSpring.domain.Pelicula;
import com.example.peliculasSpring.repository.PeliculaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    
   

    // Crear o actualizar una película
    public Pelicula guardarPelicula(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    // Leer todas las películas
    @Transactional(readOnly = true)
    public List<Pelicula> obtenerTodasPeliculas() {
        return peliculaRepository.findAll();
    }

    // Leer una película por ID
    @Transactional(readOnly = true)
    public Optional<Pelicula> obtenerPeliculaPorId(Long id) {
        return peliculaRepository.findById(id);
    }

    // Eliminar una película
    public void eliminarPelicula(Long id) {
        peliculaRepository.deleteById(id);
    }
}
