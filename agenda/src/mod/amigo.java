
package mod;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

public class amigo extends contactos implements Serializable{
    private Date cumpleaños;
    
    
    public amigo(String nombre, String email, Integer tlf, Date cumpleaños) {
        super(nombre, email, tlf);
        this.cumpleaños = cumpleaños;
    }

    public amigo(Date cumpleaños, String nombre) {
        this(nombre, null, null, cumpleaños);
       
    }
    public amigo(String nombre) {
        this(nombre, null, null, null);
       
    }
    public amigo(Date cumpleaños, String nombre, String email) {
        this(nombre, email, null, cumpleaños);
       
    }
    
    
    public Date getCumpleaños() {
        return cumpleaños;
    }

    public void setCumpleaños(Date cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    @Override
    public String toString() {
        //format para pasar de date a string
    SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
    String fecha = sdf.format(cumpleaños);

        return super.toString() + " Cumpleaños= " + fecha + "\n" ;
    }
    
    
}
