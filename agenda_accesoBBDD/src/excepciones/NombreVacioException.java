
package excepciones;


public class NombreVacioException extends Exception {
    
    public NombreVacioException(){
        super("El nombre no puede quedar vacio ");
        
    }
}
