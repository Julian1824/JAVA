
package Modelo;

public class Detalle {
    private int id;
    private int cantidad;
    private int id_venta;
    private double precio;
    private String cod_pro;
    
    public Detalle(){
    
    }

    public Detalle(int id, int cantidad, int id_venta, double precio, String cod_pro) {
        this.id = id;
        this.cantidad = cantidad;
        this.id_venta = id_venta;
        this.precio = precio;
        this.cod_pro = cod_pro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCod_pro() {
        return cod_pro;
    }

    public void setCod_pro(String cod_pro) {
        this.cod_pro = cod_pro;
    }
    
}
