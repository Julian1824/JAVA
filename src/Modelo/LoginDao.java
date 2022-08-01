package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn=new Conexion();
    
    public login log(String correo, String password){
        login l=new login();
        String sql="Select * from usuario where correo=? and password=?";
        try{
            conn =cn.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if(rs.next()){
                //l.setId(rs.getInt("id"));
                l.setCorreo(rs.getString("correo"));
                l.setNombre(rs.getString("nombre"));
                l.setPassword(rs.getString("password"));
                l.setRol(rs.getString("rol"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return l;
    }
    public boolean RegistrarUser(login reg){
        String sql="INSERT INTO usuario(correo,nombre,password,rol) values (?,?,?,?)";
        
        try{
        conn=cn.getConnection();
        ps=conn.prepareStatement(sql);
        ps.setString(1,reg.getCorreo());
        ps.setString(2,reg.getNombre());
        ps.setString(3, reg.getPassword());
        ps.setString(4, reg.getRol());
        ps.execute();
        return true;
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
    } 
}
