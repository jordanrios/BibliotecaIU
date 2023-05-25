/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BibliotecaIU;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Principal {
    
    
    List<Autor> autores = new ArrayList<>();
    Autor a1 = new Autor("Federico", "hola", "adios");
    Autor a2 = new Autor("Rodolfo", "Raul", "adios");
    Autor a3 = new Autor("Paco", "Garcia", "adios");

    Libro l1 = new Libro("21341", "aaaaaaaaaa", LocalDate.now(), autores);
    Libro l2 = new Libro("21341", "bbbbbbbbbb", LocalDate.now(), autores);
    
    
    public static void main(String[] args) throws IOException {
        
        List<Libro> aux = BibliotecaPersistente.cargarLibros();
        System.out.println(aux);
    }
    
  
    
    
    
    
}

