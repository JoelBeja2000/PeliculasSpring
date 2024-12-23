package com.example.peliculasSpring.domain;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import jakarta.persistence.*;


@Entity
@Table(name = "pelicula")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Pelicula implements Serializable{
    public Pelicula(String nombre, String descripcion, LocalDate fechaLanzamiento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaLanzamiento = fechaLanzamiento;
    };

    public Pelicula() {
        // Constructor vacío necesario para Hibernate
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre" )
    private String nombre;

    @Column (name = "descripcion" )
    private String descripcion;
    @Column (name = "fecha_lanzamiento" )
    private LocalDate fechaLanzamiento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pelicula)) return false;
        Pelicula pelicula = (Pelicula) o;
        return id != null && id.equals(pelicula.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    

    public String toString() {
        return "Pelicula{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", descripcion='" + getDescripcion() + "'" +
            ", fechaLanzamiento='" + getFechaLanzamiento() + "'" +
       
            "}";
    }

}