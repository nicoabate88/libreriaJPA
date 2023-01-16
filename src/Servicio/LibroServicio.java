package Servicio;

import Entidades.Libro;
import Persistencia.LibroJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibroServicio {

    LibroJpaController libroJPA = new LibroJpaController();

    public void crearLibro() {

        try {

            Libro libro = new Libro(185, "la", 20, 5, 2, 3, null, null);
            libroJPA.create(libro);

        } catch (Exception ex) {
            Logger.getLogger(LibroServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void consultarLibro() {

        Libro libro = libroJPA.findLibro(14);
        System.out.println(libro);
    }

    public void consultarTodosLibros() {

        ArrayList<Libro> listaLibro = new ArrayList();

        listaLibro.addAll(libroJPA.findLibroEntities());

        for (Libro libro : listaLibro) {
            System.out.println(libro);
        }

    }

    public void eliminarLibro() {

        try {
            libroJPA.destroy(14);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(LibroServicio.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void modificarLibro(){
        try {
            Libro libro = new Libro(185, "Nicolas",2014,698555,56333,5666,null,null);
            
            libroJPA.edit(libro);
        } catch (Exception ex) {
            Logger.getLogger(LibroServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    
    
    
    
    
}
