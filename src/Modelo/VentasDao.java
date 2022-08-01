/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JComboBox;
/**
 *
 * @author julia
 */
public class VentasDao {
    
    Connection conn;
    Conexion cn=new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    int r;
    
    
    public int IdVenta(){
        int id=0;
        String sql="SELECT MAX(id) FROM ventas";
            try{
                conn=cn.getConnection();
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                if(rs.next()){
                    id=rs.getInt(1);
                }
            }catch(SQLException e){
                System.out.print(e.toString());
            }
            return id;
    }
        public int RegistrarVenta(Ventas v){
            String sql="INSERT INTO ventas(cliente,vendedor,total,fecha) values (?,?,?,?)";
            
            try{
            conn=cn.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,v.getCliente());
            ps.setString(2, v.getVendedor());
            ps.setDouble(3, v.getTotal());
            ps.setString(4, v.getFecha());
            ps.execute();
            
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                conn.close();
            }catch(SQLException e){
                System.out.print(e.toString());
            }
         }
      return r;
    }
        public int RegistrarDetalle(Detalle dt){
            String sql="INSERT INTO detalle(cod_pruducto,cantidad,precio,id_venta) values(?,?,?,?)";
            
            try{
            conn=cn.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,dt.getCod_pro());
            ps.setInt(2, dt.getCantidad());
            ps.setDouble(3, dt.getPrecio());
            ps.setInt(4, dt.getId_venta());
            ps.execute();
            
            }catch(SQLException e){
                System.out.print(e.toString());
            }finally{
            try{
                conn.close();
            }catch(SQLException e){
                System.out.print(e.toString());
            }
         }
            return r;
        }public boolean ActualizarStock(int cant, String cod){
            String sql="UPDATE productos set cantidad=? where codigo=?";
            
            try{
                conn=cn.getConnection();
                ps=conn.prepareStatement(sql);
                ps.setInt(1, cant);
                ps.setString(2, cod);
                ps.execute();
                return true;
            }catch(SQLException e){
                System.out.print(e.toString());
                return false;
            }
        
        }public ConfiDatos BuscarCod(){
            ConfiDatos confi= new ConfiDatos();
            String sql = "SELECT * FROM config";
            
            try{
            conn=cn.getConnection();
            ps=conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                confi.setId(rs.getInt("id"));
                confi.setRunt(rs.getInt("runt"));
                confi.setTelefono(rs.getInt("telefono"));
                confi.setNombre(rs.getString("nombre"));
                confi.setRazon(rs.getString("razon"));
                confi.setDireccion(rs.getString("direccion"));

            }
            }catch(SQLException e){
                System.out.println(e.toString());
            }
            return confi;
        }public int ActualizarEmpresa(ConfiDatos confi){
               String sql="UPDATE config SET nombre=?,runt=?,telefono=?,direccion=?,razon=? where id=?";
               
               try{
                   //conn=cn.getConnection();
                   ps=conn.prepareStatement(sql);
                   ps.setString(1, confi.getNombre());
                   ps.setInt(2, confi.getRunt());
                   ps.setInt(3, confi.getTelefono());
                   ps.setString(4, confi.getDireccion());
                   ps.setString(5, confi.getRazon());
                   ps.setInt(6, confi.getId());
                   ps.execute();
                   
               }catch(SQLException e){
                System.out.println(e.toString());
        }finally{
                     try{
                   //conn=cn.getConnection();
                   conn.close();
               }catch(SQLException e){
                System.out.println(e.toString());
        }
               }
        return r;
        }
}
