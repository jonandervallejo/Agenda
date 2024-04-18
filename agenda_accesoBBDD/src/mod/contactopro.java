
package mod;
import java.io.Serializable;
import java.util.*;

public class contactopro extends contactos implements Serializable{
    private String Nempresas;

    public contactopro(String nombre, String email, Integer tlf, String Nempresas) {
        super(nombre, email,tlf );
        this.Nempresas = Nempresas;
    }
    public contactopro(String Nempresas,  String nombre, Integer tlf) {
        super(nombre, null,tlf ); 
        this.Nempresas= Nempresas;
    }
    public contactopro(String nombre, Integer tlf, String email) {
        super(nombre, email, tlf );        
    }
    public contactopro(Integer tlf, String nombre) {
        super(nombre, null, tlf);
    }

    public String getNempresas() {
        return Nempresas;
    }

    public void setNempresas(String Nempresas) {
        this.Nempresas = Nempresas;
    }

    @Override
    public String toString() {
        return super.toString() + " Nombre de empresa= " + ((Nempresas == null)?'-':getNempresas() + "\n");
    }
    
    
}
