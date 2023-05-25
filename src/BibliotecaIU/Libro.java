/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BibliotecaIU;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author alumno
 */
public class Libro {
    
    private String isbn;
    private String titulo;
    private LocalDate fechaPubli;
    private List<Autor> autores;


    public Libro(String isbn, String titulo, LocalDate fechaPubli, List<Autor> autores) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.fechaPubli = fechaPubli;
        this.autores = autores!=null?autores:new ArrayList<>();
    }

        
    public Libro(String lineaCSV) {
        
        String [] linea = lineaCSV.split(";");
        this.isbn = linea[0].trim();
        this.titulo = linea[1].trim();
        this.fechaPubli = LocalDate.parse(linea[2], DateTimeFormatter.ofPattern("dd/MM/uuuu"));
        this.autores = new ArrayList<>();
        if(linea.length == 4){
            if(linea[3].contains("-")){
                String [] nombres = linea[3].split("-");
                for(String n:nombres){
                    Autor a1 = new Autor(n);
                    this.autores.add(a1);
                    }
            }else{
                Autor a1 = new Autor(linea[3]);
                this.autores.add(a1);
            }
        }
    }

    
    
    
    public String getLibroFormatoCSV(){
        
        String salida = this.isbn + ";" + this.titulo + ";" + this.fechaPubli +
                ";" ;
        for(Autor a:this.autores){
            salida += a.getAutorFormatoCSV() + "-";
        }
        
        if(!this.autores.isEmpty()){
            salida = salida.substring(0,salida.length()-1);
        }
        
        return salida;
    }
    
    
    
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getFechaPubli() {
        return fechaPubli;
    }

    public void setFechaPubli(LocalDate fechaPubli) {
        this.fechaPubli = fechaPubli;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.isbn);
        hash = 17 * hash + Objects.hashCode(this.titulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return Objects.equals(this.titulo, other.titulo);
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", fechaPubli=" + fechaPubli + ", autores=" + autores + '}';
    }
    
    
    
    
    
    
    
    
    
}
