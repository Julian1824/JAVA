/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reportes;
import Modelo.Conexion;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

public class Grafico {
    
    public static void Graficar(String fecha){

        Connection conn;
        Conexion cn=new Conexion();
        PreparedStatement ps;
        ResultSet rs;
       
        try{
            String sql="SELECT total from ventas where fecha=?";
            conn=cn.getConnection();
            ps=conn.prepareStatement(sql);
            ps.setString(1,fecha);
            rs=ps.executeQuery();
            DefaultPieDataset dateset = new DefaultPieDataset(); 
            while(rs.next()){
                dateset.setValue(rs.getString("total"), rs.getDouble("total"));
                }
            
            JFreeChart jf = ChartFactory.createPieChart("Reporte de Venta", dateset);
            ChartFrame f = new ChartFrame("Total a pagar",jf);
            f.setSize(1000,500);
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    
    }
    
}
