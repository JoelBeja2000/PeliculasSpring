package com.example.resource;


import com.example.peliculasSpring.domain.Pelicula;
import com.example.peliculasSpring.service.PeliculaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaResource {

    private final PeliculaService peliculaService;

    public PeliculaResource(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    
    @GetMapping
    public List<Pelicula> getAllPeliculas() {
        return peliculaService.obtenerTodasPeliculas();
    }

  
    @GetMapping("/{id}")
    public Optional<Pelicula> getPeliculaById(@PathVariable Long id) {
        return peliculaService.obtenerPeliculaPorId(id);
    }

   
    @PostMapping
    public Pelicula createPelicula(@RequestBody Pelicula pelicula) {
        return peliculaService.guardarPelicula(pelicula);
    }

   
    @PutMapping("/{id}")
    public Pelicula updatePelicula(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        pelicula.setId(id);
        return peliculaService.guardarPelicula(pelicula);
    }

  
    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable Long id) {
        peliculaService.eliminarPelicula(id);
    }
}
