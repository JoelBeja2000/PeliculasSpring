package com.example.peliculasSpring.resource;



import com.example.peliculasSpring.domain.Pelicula;
import com.example.peliculasSpring.service.PeliculaService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.peliculasSpring.domain.Pagination;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/peliculas")
public class PeliculaResource {

    private final PeliculaService peliculaService;
    private final ObjectMapper objectMapper;
    


    public PeliculaResource(PeliculaService peliculaService, ObjectMapper objectMapper) {
        this.peliculaService = peliculaService;
        this.objectMapper = objectMapper;
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
    public Pelicula crearPelicula(@RequestPart("pelicula") String pelicula, @RequestPart("file") MultipartFile file ) {
	
    Path directoryPath = Paths.get("src\\main\\resources\\static\\images");
    String absolutePath = directoryPath.toFile().getAbsolutePath();
   

    try {   
        Pelicula peliculaMap = objectMapper.readValue(pelicula, Pelicula.class);

        byte[] portadaByte = file.getBytes();
        Path rutaImagen = Paths.get(absolutePath + "\\" + file.getOriginalFilename());
        Files.write(rutaImagen, portadaByte);

        return peliculaService.guardarPelicula(peliculaMap);

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        return null;
    }

    
    
    
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
