/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BibliotecaIU;

import java.util.Objects;

/**
 *
 * @author alumno
 */
public class Autor {
    
    private String nombre;
    private String apellido1;
    private String apellido2;

    public Autor(String nomnbre, String apellido1, String apellido2) {
        this.nombre = nomnbre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }
    
    public Autor(String autorCSV){
        String [] apellidosNombre = autorCSV.split(",");
        String apellidos = apellidosNombre[0].trim();
        String nombre = apellidosNombre[1];
        String [] ap1ap2 = apellidos.split(" ");
        String apellido1 = ap1ap2[0];
        String apellido2 = ap1ap2[1];
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public String getNomnbre() {
        return nombre;
    }

    public void setNomnbre(String nomnbre) {
        this.nombre = nomnbre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nombre);
        hash = 73 * hash + Objects.hashCode(this.apellido1);
        hash = 73 * hash + Objects.hashCode(this.apellido2);
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
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido1, other.apellido1)) {
            return false;
        }
        return Objects.equals(this.apellido2, other.apellido2);
    }
    
    
    
    
    public String getAutorFormatoCSV(){
        return this.apellido1 + " " + this.apellido2 + ", " + this.nombre;
    }

    
    
    
    
    @Override
    public String toString() {
        return "Autor{" + "nomnbre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + '}';
    }
    
    
    
    
}
