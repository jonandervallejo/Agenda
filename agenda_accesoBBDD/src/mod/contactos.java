
package mod;

import java.io.Serializable;
import java.util.*;
public abstract class contactos implements Comparable, Serializable {
    private String nombre;
    private String email;
    private Integer tlf;   


    public contactos(String nombre, String email,Integer tlf ) {
        this.tlf = tlf;
        this.nombre = nombre;
        this.email = email;
    }   
    
    public Integer getTlf() {
        return tlf;
    }

    public void setTlf(Integer tlf) {
        this.tlf = tlf;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public int compareTo(Object o) {
       if (this == o) {
            return 0;
        }
        if (o == null) {
            return -1;
        }
        if (getClass() != o.getClass()) {
            return 1;
        }
        final contactos other = (contactos) o;
        return nombre.compareTo(other.nombre);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final contactos other = (contactos) obj;
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Contactos: " + "Nombre= " + nombre + ", Email= " + email + ", Telefono= " + ((tlf==null)?"-":tlf);
    }
    
      
}
