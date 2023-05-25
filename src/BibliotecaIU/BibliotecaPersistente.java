/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BibliotecaIU;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author alumno
 */
public class BibliotecaPersistente {
    
    
    public final static String PATH = "ficheros/libros.csv";
    
    
    public static void addLibro(Libro l) throws FileNotFoundException{
        
        FileOutputStream fos = new FileOutputStream(PATH, true);
        PrintWriter pw = new PrintWriter(fos);
        pw.println(l.getLibroFormatoCSV());
        pw.close();
        
    }
    
    
    public static boolean deleteLibro(Libro l) throws IOException{
        List<Libro> libros = cargarLibros();
            if(libros.remove(l)){
                FileOutputStream fos = new FileOutputStream(PATH, false);
                PrintWriter pw = new PrintWriter(fos);
                pw.println("﻿isbn;titulo;fecha_pub;Autores(separados por -)");
                for(Libro li:libros){
                    pw.println(li);
                }
                pw.close();
                return true;
            }
        
        return false;
    }
    
    
    public static boolean modificarLibro(Libro lOld, Libro lNew) throws FileNotFoundException, IOException{
        if(deleteLibro(lOld)){
            addLibro(lNew);
            return true;
        }
        return false;
    }
    
    
    public static List<Libro> cargarLibros() throws FileNotFoundException, IOException{
        
        List<Libro> libros = new ArrayList<>();
        FileInputStream fis = new FileInputStream(PATH);
        Scanner sc = new Scanner(fis);
        sc.nextLine();
        while(sc.hasNext()){
            libros.add(new Libro(sc.nextLine()));
        }
        fis.close();
        
        return libros;
    } 

  
    
    
}
