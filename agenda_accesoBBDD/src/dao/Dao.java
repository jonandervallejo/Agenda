
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mod.*;

public class Dao {
    
    PreparedStatement ps;    
    ResultSet rs;
    
    private Connection AbrirConexion() throws SQLException{           
       return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
    }
   
    //funciona
    public contactos Seleccionar (String nombre) throws SQLException{
        
        Connection conn = AbrirConexion();
        contactos c = null;
        
        ps = conn.prepareStatement("select nombre, telefono, email, tipo, cumpleaños, nombre_empresa from contactos where nombre = ?");
        ps.setString(1, nombre);
               
        rs = ps.executeQuery();
       
        while (rs.next()) {
            String tipo = rs.getString("tipo");
            
            if(tipo.equals("amigo")){
                c = new amigo(rs.getString("nombre"),
                rs.getString("email"),
                rs.getInt("telefono"),
                rs.getDate("cumpleaños"));
                
            }else {
                c = new contactopro(rs.getString("nombre"),
                rs.getString("email"),
                rs.getInt("telefono"),
                rs.getString("nombre_empresa"));
            }           
        }
        rs.close();
        ps.close();
        conn.close();
        return c;
    }
    
    //probar
    public void Insertar(contactos c) throws SQLException{
        Connection conn = AbrirConexion();
        
        if(c instanceof amigo){        
            ps = conn.prepareStatement("insert into amigo (nombre, telefono, email, cumpleaños) values (?, ?, ?, ?)");
            amigo a = (amigo) c;
            ps.setString(1, a.getNombre());
            ps.setInt(2, a.getTlf());
            ps.setString(3, a.getEmail());
            ps.setDate(4, new java.sql.Date (a.getCumpleaños().getTime()));
            ps.executeUpdate();
            
        }else if (c instanceof contactopro){
            ps = conn.prepareStatement("insert into profesional (nombre, email, telefono, empresa) values (?, ?, ?, ?)");
            contactopro pro = (contactopro) c;
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getEmail());
            ps.setInt(3, pro.getTlf());
            ps.setString(4, pro.getNempresas());
            ps.executeUpdate();
        }
                
        ps.close();
        conn.close();
    }
    
    //funciona
    public int Borrar(String nombre, String tipo) throws SQLException{
        Connection conn = AbrirConexion();
        
        if(tipo.equals("amigo")){
            ps = conn.prepareStatement("delete from amigo where nombre = ?");
            ps.setString(1, nombre);
        
        }else{
            ps = conn.prepareStatement("delete from profesional where nombre = ?");
            ps.setString(1, nombre);
        }
        
        int x = ps.executeUpdate();

        if (x > 0){
            System.out.println(x);
            
        }else{        
            System.out.println("0");
        }
        
        ps.close();
        conn.close();
        return x;
    }
    
    //probar
    public ArrayList<String> Listado() throws SQLException{
        Connection conn = AbrirConexion();

        ArrayList lista = new ArrayList();
        ps = conn.prepareStatement("select nombre from contactos");
        rs = ps.executeQuery();
        
        while(rs.next()){
            String nombre = rs.getString("nombre");     //cargo el nombre y se lo paso a la lista
            lista.add(nombre);
            
        }
        System.out.println(lista);
        
        rs.close();
        ps.close();
        conn.close();
        return lista;
    }
    
    
    public int Modificar(contactos c) throws SQLException{
        Connection conn = AbrirConexion();
                
        if(c instanceof amigo){
            ps = conn.prepareStatement("update amigo set telefono = ?, email = ?, cumpleaños = ? where nombre = ?");
            amigo a = (amigo) c;
            ps.setInt(1, a.getTlf());
            ps.setString(2, a.getEmail());
            ps.setDate(3, new java.sql.Date (a.getCumpleaños().getTime()));
            ps.setString(4, a.getNombre());
            
        }else if (c instanceof contactopro){
            ps = conn.prepareStatement("update profesional set telefono = ?, email = ?, empresa = ? where nombre = ?");
            contactopro pro = (contactopro) c;
            ps.setInt(1, pro.getTlf());
            ps.setString(2, pro.getEmail());
            ps.setString(3, pro.getNempresas());
            ps.setString(4, pro.getNombre());
        }
        int z = ps.executeUpdate();
        
        if(z > 0){
            System.out.println(z);
        }else {
            System.out.println("No has hecho nada");
        }
        
        
        ps.close();
        conn.close();
        return z;
    }
}


