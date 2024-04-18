package excepciones;

import java.util.ArrayList;


public class NumeroErroresException extends Exception{

    ArrayList<String> errores;

    public NumeroErroresException(ArrayList<String> errores) {
        super("Tienes un error en " + errores);
        this.errores = errores;

    }
    public ArrayList<String> getErrores() {
        return errores;
    }

    public void setErrores(ArrayList<String> errores) {
        this.errores = errores;
    }


}