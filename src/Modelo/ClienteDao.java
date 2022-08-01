package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;

public class ClienteDao {
    Conexion cn=new Conexion();
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarCliente(Cliente cl){
        String sql="INSERT INTO CLIENTES(runt,nombre,telefono,direccion,razon) VALUES(?,?,?,?,?)";
        try{
        conn=cn.getConnection();
        ps=conn.prepareStatement(sql);
        ps.setInt(1, cl.getRunt());
        ps.setString(2, cl.getNombre());
        ps.setInt(3, cl.getTelefono());
        ps.setString(4, cl.getDireccion());
        ps.setString(5, cl.getRazon());
        ps.execute();
        return true;
        }catch(SQLException e){
             JOptionPane.showMessageDialog(null,(e.toString()));
             return false;
        }finally{
            try{
                conn.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    public List ListarCliente(){
    List<Cliente> LisCL = new ArrayList();
    String sql= "SELECT * FROM CLIENTES";
       
    try{
        conn= cn.getConnection();
        ps= conn.prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
         Cliente cl = new Cliente();
            cl.setId(rs.getInt("id"));
            cl.setRunt(rs.getInt("runt"));
            cl.setNombre(rs.getString("nombre"));
            cl.setTelefono(rs.getInt("telefono"));
            cl.setDireccion(rs.getString("direccion"));
            cl.setRazon(rs.getString("razon"));
            LisCL.add(cl);
        }
    }catch(SQLException e){
        System.out.println(e.toString());
    }
    return LisCL;
    }
    //return ListaCL;
    
    public boolean EliminarCliente(int id){
        String sql="DELETE FROM CLIENTES WHERE ID=?";
        try{
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
            
    }public boolean ActualizarCliente(Cliente cl){
        String sql="UPDATE CLIENTES SET runt=?, nombre=?, telefono=?, direccion=?, razon=? WHERE id=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setInt(1,cl.getRunt());     
            ps.setString(2,cl.getNombre());     
            ps.setInt(3,cl.getTelefono());     
            ps.setString(4,cl.getDireccion());     
            ps.setString(5,cl.getRazon());
            ps.setInt(6, cl.getId());
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
    }public Cliente BuscarCliente(int runt){
        Cliente cli=new Cliente();
        String sql="SELECT * FROM clientes WHERE runt=?";
        try{
        conn=cn.getConnection();
        ps=conn.prepareStatement(sql);
        ps.setInt(1,runt);
        rs=ps.executeQuery();
        if(rs.next()){
           cli.setNombre(rs.getString("nombre"));
           cli.setTelefono(rs.getInt("telefono"));
           cli.setDireccion(rs.getString("direccion"));
           cli.setRazon(rs.getString("razon"));
        }
    }catch(SQLException e){
        System.out.println(e.toString());
    }
        return cli;
  }
}
