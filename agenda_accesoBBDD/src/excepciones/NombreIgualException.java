
package excepciones;


public class NombreIgualException extends Exception{
    
    public NombreIgualException(){
        super("No puedes repetir el mismo nombre");
    }
    
}
