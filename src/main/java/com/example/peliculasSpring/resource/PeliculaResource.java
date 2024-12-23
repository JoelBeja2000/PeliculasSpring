package com.example.peliculasSpring.resource;



import com.example.peliculasSpring.domain.Pelicula;
import com.example.peliculasSpring.service.PeliculaService;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import com.example.peliculasSpring.domain.Pagination;
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
    public Page<Pelicula> getAllPeliculasByPagination(@RequestParam int page,@RequestParam int size) {
      
        Pageable pageable = PageRequest.of(page, size);

        return peliculaService.obtenerTodasPeliculasByPagination(pageable);
    }

  
    @GetMapping("/{id}")
    public Optional<Pelicula> getPeliculaById(@PathVariable Long id) {
        return peliculaService.obtenerPeliculaPorId(id);
    }


    
    @GetMapping("/buscar")
    public List<Pelicula> getPeliculaByName(@RequestParam String name) {
        return peliculaService.obtenerPeliculasPorNombre(name);
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
