
package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JComboBox;

public class ProductosDao {
     Connection conn;
     Conexion cn=new Conexion();
     PreparedStatement ps;
     ResultSet rs;
     
     public boolean RegistrarProducto(Productos pd){
         String sql="INSERT INTO productos(codigo,nombre,cantidad,proveedor,precio) values (?,?,?,?,?)";
         try{
        conn=cn.getConnection();
        ps=conn.prepareStatement(sql);
        ps.setString(1, pd.getCodigo());
        ps.setString(2, pd.getDescripcion());
        ps.setInt(3, pd.getCantidad());
        ps.setString(4, pd.getProveedor());
        ps.setDouble(5, pd.getPrecio());
        ps.execute();
        return true;
     }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
     }public void ConsultaProveedor(JComboBox proveedor){
         String sql="SELECT * FROM proveedor";
         try{
             conn=cn.getConnection();
             ps=conn.prepareStatement(sql);
             rs=ps.executeQuery();
             while(rs.next()){
                 proveedor.addItem(rs.getString("nombre"));
             }
         }catch(SQLException e){
             System.out.println(e.toString());
         }
     }public List ListarProducto(){
         List<Productos> procl=new ArrayList();
         String sql="SELECT * FROM productos";
         try{
         conn=cn.getConnection();
         ps=conn.prepareStatement(sql);
         rs=ps.executeQuery();
         
         while(rs.next()){
            Productos pd =new Productos();
            pd.setId(rs.getInt("id"));
            pd.setCodigo(rs.getString("codigo"));
            pd.setDescripcion(rs.getString("nombre"));
            pd.setCantidad(rs.getInt("cantidad"));
            pd.setPrecio(rs.getDouble("precio"));
            pd.setProveedor(rs.getString("proveedor"));
            procl.add(pd);
         }
     }catch(SQLException e){
         System.out.println(e.toString());
     }
         return procl;
    }public boolean EliminarProductos(int id){
        String sql="DELETE FROM productos WHERE ID=?";
        
        try{
          ps=conn.prepareStatement(sql);
          ps.setInt(1,id);
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
    }public boolean ModificarProductos(Productos pd){
        String sql="UPDATE productos SET codigo=?,nombre=?,cantidad=?,precio=?,proveedor=? WHERE ID=?";
        try{
            //conn=cn.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, pd.getCodigo());
            ps.setString(2,pd.getDescripcion());
            ps.setInt(3,pd.getCantidad());
            ps.setDouble(4, pd.getPrecio());
            ps.setString(5, pd.getProveedor());
            ps.setInt(6, pd.getId());
            
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
        }public Productos BuscarPro(String cod){
            Productos producto= new Productos();
            String sql = "SELECT * FROM productos WHERE codigo = ?";

            
            try{
            conn=cn.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if(rs.next()){
                producto.setDescripcion(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setCantidad(rs.getInt("cantidad"));
            }
            }catch(SQLException e){
                System.out.println(e.toString());
            }
            return producto;
        }
        public List ListarVentas(){
            List<Ventas> vent=new ArrayList();
            String sql="SELECT * FROM ventas";
            try{
                conn=cn.getConnection();
                ps=conn.prepareStatement(sql);
                rs=ps.executeQuery();
                while(rs.next()){
                    Ventas cd = new Ventas();
                    cd.setId(rs.getInt("id"));
                    cd.setCliente(rs.getString("cliente"));
                    cd.setVendedor(rs.getString("vendedor"));
                    cd.setTotal(rs.getDouble("total"));
                    vent.add(cd);
                }
                
            }catch(SQLException e){
                System.out.println(e.toString());
            }
            return vent;
        }
    }

