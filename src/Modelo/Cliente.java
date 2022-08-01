package Modelo;

public class Cliente {
    private int id;
    private int runt;
    private int telefono;
    private String nombre;
    private String direccion;
    private String razon;
public Cliente(){
        
    } 
    public Cliente(int id, int runt, int telefono, String nombre, String direccion, String razon) {
        this.id = id;
        this.runt = runt;
        this.telefono = telefono;
        this.nombre = nombre;
        this.direccion = direccion;
        this.razon = razon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRunt() {
        return runt;
    }

    public void setRunt(int runt) {
        this.runt = runt;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
    }
    
}