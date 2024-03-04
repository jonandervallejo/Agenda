
package control;
import java.text.*;
import mod.*;
import java.util.*;
import excepciones.*;
import java.io.*;
import java.time.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Agenda {
    
    
        //creo mapa de agenda
        HashMap<String,contactos> agenda;

    public Agenda() {
        agenda = new HashMap <String,contactos>();
                    
    }
        
        public void alta(String cat, String nombre, String email, String tlf, String cumpleaños, String Nempresas) throws ParseException, NombreVacioException, NumberFormatException,  NombreIgualException {
            //correccion de clase
            int x=0;
            
            if (nombre == null || nombre.isEmpty()) {
            NombreVacioException vc = new NombreVacioException();
            throw vc;
               
            }
            
            //si los nombre son iguales
            if (agenda.containsKey(nombre)) {
                NombreIgualException nie = new NombreIgualException();
                throw nie;                
            }
            
            if(tlf!=null && !tlf.isEmpty()){                
                x = Integer.valueOf(tlf);                                              
            }
            
            if(cat!=null && cat.equals("amigo") && cumpleaños!=null && !cumpleaños.isEmpty()){
                SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/yyyy");
                
                Date fecha = sdf.parse(cumpleaños);
                contactos nuevo = new amigo (nombre, email, x, fecha);
                agenda.put(nombre, nuevo);
            }else{
                contactos nuevo = new contactopro(nombre, email, x, Nempresas);
                agenda.put(nombre, nuevo);
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
        public void baja(String nombre){
            agenda.remove(nombre);            
        }
        
        //para actualizar contactos
        public void actualizar(String nombre, String email, String tlf, String cumpleaños, String Nempresas ) throws ParseException, NombreVacioException, NumberFormatException, NombreIgualException{
            //parse para pasar de String a Date

            
           //corregido en clase
            contactos c = agenda.get(nombre);
            
            if (nombre == null || nombre.isEmpty()) {
            NombreVacioException vc = new NombreVacioException();
            throw vc;
               
            }
            
            //si los nombre son iguales
            if (!agenda.containsKey(nombre)) {
                NombreIgualException nie = new NombreIgualException();
                throw nie;                
            }
            
                if(c==null){
                    return ;
                }
                if(tlf!=null && !tlf.isEmpty()){
                    c.setTlf(Integer.valueOf(tlf));
                }
                if(email!=null && !email.isEmpty()){
                    c.setEmail(email);
                }
            if(c instanceof amigo){
                if (cumpleaños != null && !cumpleaños.isEmpty()) {
                     SimpleDateFormat sdf= new SimpleDateFormat("dd/mm/yyyy");
                     Date fecha = sdf.parse(cumpleaños);
                     ((amigo) c).setCumpleaños(fecha);
		}else if(Nempresas!=null && !Nempresas.isEmpty()){
                    ((contactopro)c).setNempresas(Nempresas);
                }
            }
            }
            
//            //buscamos por nombre y modificamos sus atributos
//            if(agenda.containsKey(nombre)){               
//                contactos c = agenda.get(nombre);
//                c.setEmail(email);
//                c.setTlf(Integer.parseInt(tlf));
//                
//            //la condicion del if es para poder utilizar los setter de las clase hijo
//            if(c instanceof contactopro){
//                ((contactopro) c).setNempresas(Nempresas);
//                           
//            }else if(c instanceof amigo){
//                ((amigo) c).setCumpleaños(fecha);
//            }               
//            }        
//        }
        
        //para buscar en el hashmap por clave, string para pasarselo a la interfaz
        public String buscar(String nombre){
            contactos c = agenda.get(nombre);
            return c.toString();           
        }
        
        //listar la informacion del hashmap alfabeticamente, string para pasarselo a la interfaz
        public String listado(){
            Collection col = agenda.values();
            ArrayList lista = new ArrayList(col);
            Collections.sort(lista);           
            return lista.toString();
        }
        
        //metodo para el listado de la interfaz grafica
        public ArrayList<String> getNombres(){
            Collection col1 = agenda.keySet();
            ArrayList lista1 = new ArrayList(col1);
            Collections.sort(lista1);                     
            return lista1;                 
        }
               
        //no es necesario tenerlo dentro del metodo
        ArrayList<String> errores = new ArrayList<>();
        public void importarFichero(String fichero) throws IOException, NumeroErroresException{

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
        
        public void guardarHashMap(String direccion1) throws IOException{
            
            File f = new File(direccion1);
            File fRuta = new File(direccion1 + ".back");
            
            if(f.exists()){                
                f.renameTo(fRuta);
            }
            
            try(FileOutputStream fos = new FileOutputStream(f);
                ObjectOutputStream oos = new ObjectOutputStream(fos);){                               
                oos.writeObject(agenda);
                fRuta.delete();
                
            } catch(IOException ex){ 
                fRuta.renameTo(f);
                throw ex;             
            }
            
        }
        
        
        public void recuperarHashMap(String direccion2) throws FileNotFoundException, ClassNotFoundException, IOException{
           
            try(FileInputStream fis = new FileInputStream(direccion2);
            ObjectInputStream ois = new ObjectInputStream(fis);){
            
            agenda=(HashMap<String,contactos>)ois.readObject();
            } catch (IOException ex){
                throw ex;
            }
            
        }
        
        //metodo para ir pasando los datos de la gente del listado a los cuadros de texto
        public String[] getDatos(String nombre) {
            
            String [] datos = new String [6];
            contactos c = agenda.get(nombre);
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
