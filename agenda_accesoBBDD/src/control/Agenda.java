
package control;
import java.text.*;
import mod.*;
import java.util.*;
import excepciones.*;
import java.io.*;
import dao.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agenda {
    
    
        //creo mapa de agenda
        //HashMap<String,contactos> agenda;
        Dao d;
    
    public Agenda() {
        //agenda = new HashMap <String,contactos>();
        d = new Dao();            
    }
        
        public void alta(String cat, String nombre, String email, String tlf, String cumpleaños, String Nempresas) throws ParseException, NombreVacioException, NumberFormatException,  NombreIgualException {
            //correccion de clase
            int x=0;
            
            if (nombre == null || nombre.isEmpty()) {
                NombreVacioException vc = new NombreVacioException();
                throw vc;               
            }
            
            
            //si los nombre son iguales
//            if (agenda.containsKey(nombre)) {
//                NombreIgualException nie = new NombreIgualException();
//                throw nie;                
//            }     ACTUALIZAR
            
            if(tlf!=null && !tlf.isEmpty()){                
                x = Integer.parseInt(tlf);                                              
            }
            
            if(cat!=null && cat.equals("amigo") && cumpleaños!=null && !cumpleaños.isEmpty()){
                SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/yyyy");
                
                Date fecha = sdf.parse(cumpleaños);
                contactos nuevoA = new amigo (nombre, email, x, fecha);
                
                try {
                    d.Insertar(nuevoA);
                } catch (SQLException ex) {
                    if(ex.getErrorCode() == 00001){
                        NombreIgualException nie = new NombreIgualException();
                        throw nie;
                    }
                }
                
            }else{
                contactos nuevoC = new contactopro(nombre, email, x, Nempresas);
                
                try {
                    d.Insertar(nuevoC);
                } catch (SQLException ex) {
                    if(ex.getErrorCode() == 00001){
                        NombreIgualException nie = new NombreIgualException();
                        throw nie;
                    }
                }
            }
        }
            
//            //pasamos el string a date
//            SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
//            Date fecha = sdf.parse(cumpleaños);
//            
//            //categorizamos amigos y contactopro y los creamos
//            if(cat.equals("amigo")){
//                agenda.put(nombre, new amigo(nombre, email, Integer.parseInt(tlf), fecha));
//                
//            }else if(cat.equals("contactopro")){
//                agenda.put(nombre, new contactopro(nombre,email,Integer.parseInt(tlf), Nempresas));
//            }           
//        }
        
        //para dar de baja
        public void baja(String nombre, String tipo) throws SQLException {
                       
            d.Borrar(nombre, tipo);            
        }
        
        //para actualizar contactos
        public void actualizar(String nombre, String email, String tlf, String cumpleaños, String Nempresas ) throws ParseException, NombreVacioException, NumberFormatException, NombreIgualException{
            
            contactos c = null;          
            try {
                c = d.Seleccionar(nombre);
            } catch (SQLException ex) {
                if(ex.getErrorCode() == 12899){
                    System.err.println("El valor introducido es muy largo ");
                }
            }
            
//                if(c==null){
//                    return ;
//                }
//                if(tlf!=null && !tlf.isEmpty()){
//                    c.setTlf(Integer.valueOf(tlf));
//                }
//                if(email!=null && !email.isEmpty()){
//                    c.setEmail(email);
//                }
            if(c instanceof amigo){
                if (cumpleaños != null && !cumpleaños.isEmpty()) {
                     SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/yyyy");
                     Date fecha = sdf.parse(cumpleaños);
                     ((amigo) c).setCumpleaños(fecha);
		}else if(Nempresas!=null && !Nempresas.isEmpty()){
                    ((contactopro)c).setNempresas(Nempresas);
                }
            }
            
            try {
                d.Modificar(c);
            } catch (SQLException ex) {
                if(ex.getErrorCode() == 12899){
                    System.err.println("El valor introducido es muy largo ");
                }
            }
        }

        
        //para buscar en el hashmap por clave, string para pasarselo a la interfaz
        public String buscar(String nombre) throws SQLException{
            contactos c = d.Seleccionar(nombre);
            return c.toString();           
        }
        
        
        //metodo para el listado de la interfaz grafica
        public ArrayList<String> getNombres() throws SQLException{
                    
            return d.Listado();                 
        }
               
        //no es necesario tenerlo dentro del metodo
        ArrayList<String> errores = new ArrayList<>();
        public void importarFichero(String fichero) throws IOException, NumeroErroresException, SQLException{

            FileReader fr= new FileReader(fichero);
            BufferedReader br = new BufferedReader(fr);
            String linea= br.readLine(); 

            while(linea!=null){
                String[]datos=linea.split(",");
                               
                try {
                    alta(datos[0], datos[1], datos[2], datos[3], datos[4], datos[5]);//datos5 no se ve porque en el txt sea amigo o contacto solo llega a 4
                } catch (ParseException | NombreVacioException | NumberFormatException | NombreIgualException ex) {
                   errores.add(linea+"Error:"+ex);
                }
                
                    //para probar si cuenta cuantos errores tiene
                    //System.out.println(errores.size());
                    linea=br.readLine();
             }
             if(!errores.isEmpty()){
                 throw new NumeroErroresException(errores);
             }
        }
        

        
        //metodo para ir pasando los datos de la gente del listado a los cuadros de texto
        public String[] getDatos(String nombre) throws SQLException {
            
            String [] datos = new String [6];
            contactos c = d.Seleccionar(nombre);
            //estos datos fuera ya q siempre han de estar
                datos[1] = c.getNombre();
                datos[2] = c.getEmail();
                datos[3] = String.valueOf(c.getTlf());
                
            if(c instanceof amigo){
                
                datos[0] = "Amigo";
                SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
                datos[4] = sdf.format(((amigo) c).getCumpleaños());
            
            }else {               
                datos[0] = "Profesional";                                                   
                datos[5] = ((contactopro)c).getNempresas();               
            } 
            
            return datos;
        }
   
}//cierre
