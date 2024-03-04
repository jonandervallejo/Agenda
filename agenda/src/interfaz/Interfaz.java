
package interfaz;

import java.util.Scanner;
import control.*;
import excepciones.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Interfaz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();
        while(true){
            
            System.out.println("1- Para dar de alta: ");
            System.out.println("2- Para dar de baja: ");
            System.out.println("3- Para actualizar a alguien: ");
            System.out.println("4- Para buscar a alguien: ");
            System.out.println("5- Para que aparezca todo el mundo: ");
            System.out.println("6- Para importar lo que tengas de un archivo: ");
            System.out.println("7- Para guardar la informacion de tu agenda: ");
            System.out.println("8- Para recuperar la informacion de tu agenda: ");
            System.out.println("0- Para salirse: ");
            System.out.println("Introduce una opcion: ");
            int opcion=sc.nextInt();
            //al utilizar nextLine después de un nextInt, nextDouble, etc puede que no lea el salto de línea, ya que los métodos nextInt, etc no leen el salto de línea final (cuando el usuario presiona enter) por lo que si haces una llamada a nextLine despues de un nextInt el método leerá hasta el siguiente salto de línea, que puede ser justo el que quedó pendiente, y da como resultado una cadena vacía
            sc.nextLine();
            switch(opcion){
                case 1:  //alta                  
                    System.out.println("Si eres amigo escribe amigo sino dejalo vacio: ");
                    String cat= sc.nextLine();
                    System.out.println("Introduce un nombre: ");
                    String nombre= sc.nextLine();
                    System.out.println("Introduce un email: ");
                    String email= sc.nextLine();
                    System.out.println("Introduce un telefono: ");
                    String tlf= sc.nextLine();
                    String cumpleaños=null;
                    String Nempresas=null;
                    
                    if(cat!=null && cat.equals("amigo")){
                    System.out.println("Introduce un cumpleaños (dd/mm/yyyy): ");
                    cumpleaños= sc.nextLine();
                    
                }else{
                    System.out.println("Introduce un nombre de empresa: ");
                    Nempresas= sc.nextLine();
                    }
        
                //le paso mi excepcion y la parse exception al estar ambas en el metodo de alta
                    try {
                        agenda.alta(cat, nombre, email, tlf, cumpleaños, Nempresas);
                    } catch (NombreVacioException | ParseException ex) {                       
                        System.out.println("Tienes un error: " + ex.getMessage());              
                    } catch (NumberFormatException ix){
                        System.out.println("Debes introducir el numero de telefono: ");                                               
                    } catch (DateTimeException | NombreIgualException ex) {
                        System.out.println(ex);
                }
                                                                                                                         
                    break;


                    
                case 2:  //baja
                    System.out.println("Introduce el nombre de la persona que quieres dar de baja: ");
                    String nombre1= sc.nextLine();
                    
                    agenda.baja(nombre1);
                    break;
                    
                case 3:  //actualizar 
                    System.out.println("Introduce el nombre de la persona que quieras actualizar: ");
                    String nombre2= sc.nextLine();                                      
                    System.out.println("Introduce un nuevo email: ");
                    String email2= sc.nextLine();
                    System.out.println("Introduce un nuevo telefono: ");
                    String tlf2= sc.nextLine();
                    System.out.println("Introduce un nuevo cumpleaños: ");
                    String cumpleaños2= sc.nextLine();
                    System.out.println("Introduce un nuevo nombre de empresa: ");
                    String Nempresas2= sc.nextLine();
                    
               
                    try {
                        agenda.actualizar(nombre2, email2, tlf2, cumpleaños2, Nempresas2);
                    } catch (NombreVacioException | ParseException ex) {
                        System.out.println("Tienes un error: " + ex.getMessage());                    
                    } catch (NumberFormatException ix){
                        System.out.println("Debes introducir el numero de telefono: ");
                        
                    } catch (DateTimeException | NombreIgualException ex) { 
                        System.out.println(ex);                
                    }
                   
                                                                                  
                    break;



                case 4:  //buscar
                    System.out.println("Introduce el nombre de la persona que quieras buscar: ");
                    String nombre3= sc.nextLine();  
                    System.out.println(agenda.buscar(nombre3));
                    
                    break;
                    
                case 5:  //listado
                    System.out.println("Aqui tienes todas las personas dadas de alta: ");
                    System.out.println(agenda.listado());
                     
                    break;
                    
                case 6:     //leer Fichero
                    System.out.println("Introduce la ruta del fichero que quieras importar: ");
                    String direccion= sc.nextLine();


                    try {
                        agenda.importarFichero(direccion);
                    } catch (NumberFormatException ix){
                        System.out.println("Debes introducir el numero de telefono: ");
                    } catch (IOException ex) {
                    System.out.println(ex);
                    } catch(Exception ex){
                        System.out.println("Tienes un error en: " + ex);
                    }



                    break;  
  
                    
                case 7: //guardar Hashmap
                    System.out.println("Pasame la ruta donde quieres que te guarde la informacion y el nombre del archivo: ");
                    String direccion1 = sc.nextLine();
                    
                    try{
                        agenda.guardarHashMap(direccion1);
                    } catch (IOException ex) {
                        System.out.println("Tienes un error: " + ex);
                    }
                
                    
                    break;
                    
                case 8:  //recuperar Hashmap
                    System.out.println("Pasame la ruta de donde quieres que recupere la informacion: ");
                    String direccion2= sc.nextLine();
                    
                    try{
                        agenda.recuperarHashMap(direccion2);
                    } catch (IOException ex) {
                        System.out.println("Tienes un error: " + ex);           
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Tienes un error: " + ex);
                    }
                    
                    
                    break;

                case 0:
                    System.out.println("Te has salido. ");
                    
                    return; 
                   
            }
            
            
            
            
        }
        
        
        
        
    }  
}
