
package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import mod.*;
public class probardao {
    public static void main(String[] args) throws SQLException, ParseException {
        
        Dao d = new Dao();
        String fecha = "dd/MM/yyyy";
        amigo a = new amigo("maider", "c@c.com", 18231321, new SimpleDateFormat(fecha).parse("23/05/2004"));
        contactopro pro = new contactopro("unai", "d@d.com", 2713712, "Ceinmark");
        
        amigo modA = new amigo("jonander", "jonander@gmail.com", 3131312,new SimpleDateFormat(fecha).parse("30/05/2002"));
        
        contactopro modC = new contactopro("unai", "unai@gay.com", 76213821, "calasanz");
        
        //select funciona
//        c = d.Seleccionar("juan");
//        if (c != null) {
//            System.out.println(c);
//        }
        
        //insertar funcionan
        //d.Insertar(a);
        //d.Insertar(pro);
                
        
        //borrar funciona       
        //d.Borrar("juan", "profesional");
        
        //listado funciona
        //d.Listado();
        
        //modificar funciona
        //d.Modificar(modA); 
        //d.Modificar(modC);
    }
}
