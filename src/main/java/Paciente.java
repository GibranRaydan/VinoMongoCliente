/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



public class Paciente {
 
    private String nombre;
    private String address;
    private String telefono;
    private String fecha;
    private String contacto;
   
/**
 *
 * @author white
 */
public Paciente() {
    
}
 public Paciente (String id,String nombre, String address, String telefono, String fecha, String contacto) {
        this.nombre = nombre;
        this.address = address;
        this.telefono = telefono;
        this.fecha = fecha;
        this.contacto = contacto;
        
    }
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
 
}