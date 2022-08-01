
package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class ProveedorDao {
    
    Conexion cn = new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarProveedor(Proveedor pr){
        String sql="INSERT INTO proveedor(runt,nombre,telefono,direccion,razon) values(?,?,?,?,?)";
        try{
        conn=cn.getConnection();
        ps=conn.prepareStatement(sql);
        
        ps.setInt(1, pr.getRunt());
        ps.setString(2,  pr.getNombre());
        ps.setInt(3,     pr.getTelefono());
        ps.setString(4,  pr.getDireccion());
        ps.setString(5,  pr.getRazon());
        ps.execute();
        return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                conn.close();
            }catch(SQLException e){
            System.out.println(e.toString());
        }
        }
    }public List<Proveedor> ListarProveedor(){
       List<Proveedor> Listapr = new ArrayList();
       
       String sql="SELECT * FROM proveedor";
       
        try{
        conn=cn.getConnection();
        ps=conn.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
            Proveedor pr = new Proveedor();
            pr.setId(rs.getInt("id"));
            pr.setRunt(rs.getInt("runt"));
            pr.setNombre(rs.getString("nombre"));
            pr.setTelefono(rs.getInt("telefono"));
            pr.setDireccion(rs.getString("direccion"));
            pr.setRazon(rs.getString("razon"));
            
            Listapr.add(pr);
        }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
         return Listapr;
    }    public boolean EliminarProveedor(int id){
        String sql="DELETE FROM proveedor WHERE ID=?";
        try{
            conn=cn.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
        try{
           conn.close();
         }catch(SQLException e){
         System.out.println(e.toString());
        }
        }  
    }public boolean ActualizarProveedor(Proveedor pr){
         String sql="UPDATE proveedor SET runt=?, nombre=?, telefono=?, direccion=?, razon=? WHERE id=?";
        try{
        ps=conn.prepareStatement(sql);
        ps.setInt(1,pr.getRunt());  
        ps.setString(2, pr.getNombre());
        ps.setInt(3,pr.getTelefono());  
        ps.setString(4, pr.getDireccion());
        ps.setString(5, pr.getRazon());
        ps.setInt(6,pr.getId());
        ps.execute();
        return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }finally{
            try{
                conn.close();
            }catch(SQLException e){
              System.out.println(e.toString());
            }
        }
    }
}
