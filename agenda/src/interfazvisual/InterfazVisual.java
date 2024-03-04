

package interfazvisual;

import control.*;
import excepciones.*;
import java.awt.FileDialog;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;




public class InterfazVisual extends java.awt.Frame {

    
    Agenda ag;
    VentanaExcepciones ve;
    VentanaConfirmacion vc;   
    FileDialog fd1; 
    FileDialog fd2;
    ListadoMostrar lm;
    
    public InterfazVisual() {
        initComponents();
        ag = new Agenda();
        ve = new VentanaExcepciones(this, true);
        vc = new VentanaConfirmacion(this, true);
        lm = new ListadoMostrar(this, true);
        
        //para que seleccione el archivo
        fd1 = new FileDialog(this, "", FileDialog.LOAD);
        
        //para que seleccione el archivo       
        fd2 = new FileDialog(this, "", FileDialog.SAVE);
                
        //tratamiento de la ventana de excepciones
        ve.setVisible(false);
        
        //tratamiento para ventana de confirmacion
        vc.setVisible(false);
        
        //default empresa y cumpleaños no visibles
        label6.setVisible(false);
        textField6.setVisible(false);
        label5.setVisible(false);
        textField5.setVisible(false);
        
        //para limpiar campos al entrar
           textField2.setText("");
           textField3.setText("");
           textField4.setText("");
           textField5.setText("");
           textField6.setText("");
           checkbox1.setState(false);
           checkbox2.setState(false);
           
           //no dejar editar hasta que pulse "añadir amigo"       
           textField2.setEditable(false);
           textField3.setEditable(false);
           textField4.setEditable(false);
           checkbox1.setEnabled(false);
           checkbox2.setEnabled(false);
           
        try {
            //de clase
            ag.importarFichero("C:\\Users\\MULTI\\Documents\\NetBeansProjects\\contactos2.txt");
            
            //de casa
            //ag.importarFichero("C:\\Users\\jonan\\OneDrive\\Documentos\\NetBeansProjects\\contactos.txt");
      
        } catch (NumeroErroresException | IOException ex) {
            ve.mostrarExcepcion(ex.getMessage());
            ve.setVisible(true);
            
        }
        
        recargar();
          

        
        //todo quitado hasta q haga algo
         alta.setEnabled(false);
         baja.setEnabled(false);
         modificar.setEnabled(false);
    }
      
        

    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel1 = new java.awt.Panel();
        alta = new java.awt.Button();
        baja = new java.awt.Button();
        modificar = new java.awt.Button();
        panel2 = new java.awt.Panel();
        panel4 = new java.awt.Panel();
        list1 = new java.awt.List();
        listado = new java.awt.Button();
        panel3 = new java.awt.Panel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        textField2 = new java.awt.TextField();
        textField3 = new java.awt.TextField();
        textField4 = new java.awt.TextField();
        textField5 = new java.awt.TextField();
        textField6 = new java.awt.TextField();
        panel5 = new java.awt.Panel();
        checkbox1 = new java.awt.Checkbox();
        checkbox2 = new java.awt.Checkbox();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        Guardar = new java.awt.MenuItem();
        Recuperar = new java.awt.MenuItem();
        menu2 = new java.awt.Menu();
        Importar = new java.awt.MenuItem();

        setTitle("Agenda");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        panel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 115, 5));

        alta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        alta.setLabel("Alta");
        alta.setPreferredSize(new java.awt.Dimension(65, 24));
        alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaActionPerformed(evt);
            }
        });
        panel1.add(alta);

        baja.setLabel("Baja");
        baja.setPreferredSize(new java.awt.Dimension(65, 24));
        baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaActionPerformed(evt);
            }
        });
        panel1.add(baja);

        modificar.setLabel("Modificar");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        panel1.add(modificar);

        add(panel1, java.awt.BorderLayout.SOUTH);

        panel2.setLayout(new java.awt.GridLayout(1, 0));

        panel4.setLayout(new java.awt.GridBagLayout());

        list1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                list1ItemStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 250;
        gridBagConstraints.ipady = 250;
        gridBagConstraints.insets = new java.awt.Insets(28, 28, 15, 28);
        panel4.add(list1, gridBagConstraints);

        listado.setLabel("Listado");
        listado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        panel4.add(listado, gridBagConstraints);

        panel2.add(panel4);

        java.awt.GridBagLayout panel3Layout = new java.awt.GridBagLayout();
        panel3Layout.columnWidths = new int[] {0, 14, 0};
        panel3Layout.rowHeights = new int[] {0, 25, 0, 25, 0, 25, 0, 25, 0};
        panel3.setLayout(panel3Layout);

        label1.setText("Tipo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 8);
        panel3.add(label1, gridBagConstraints);

        label2.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 8);
        panel3.add(label2, gridBagConstraints);

        label3.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 8);
        panel3.add(label3, gridBagConstraints);

        label4.setText("Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 8);
        panel3.add(label4, gridBagConstraints);

        label5.setText("Cumpleaños");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 8);
        panel3.add(label5, gridBagConstraints);

        label6.setText("Empresa");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 8, 0, 8);
        panel3.add(label6, gridBagConstraints);

        textField2.setMinimumSize(new java.awt.Dimension(165, 20));
        textField2.setText("textField2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        panel3.add(textField2, gridBagConstraints);

        textField3.setMinimumSize(new java.awt.Dimension(165, 20));
        textField3.setText("textField3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        panel3.add(textField3, gridBagConstraints);

        textField4.setMinimumSize(new java.awt.Dimension(165, 20));
        textField4.setText("textField4");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        panel3.add(textField4, gridBagConstraints);

        textField5.setMinimumSize(new java.awt.Dimension(165, 20));
        textField5.setText("textField5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        panel3.add(textField5, gridBagConstraints);

        textField6.setMinimumSize(new java.awt.Dimension(165, 20));
        textField6.setText("textField6");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        panel3.add(textField6, gridBagConstraints);

        panel5.setLayout(new java.awt.GridBagLayout());

        checkbox1.setLabel("Amigo");
        checkbox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkbox1ItemStateChanged(evt);
            }
        });
        panel5.add(checkbox1, new java.awt.GridBagConstraints());

        checkbox2.setLabel("Profesional");
        checkbox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkbox2ItemStateChanged(evt);
            }
        });
        panel5.add(checkbox2, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 15;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 20);
        panel3.add(panel5, gridBagConstraints);

        panel2.add(panel3);

        add(panel2, java.awt.BorderLayout.CENTER);

        menu1.setLabel("Archivo");

        Guardar.setLabel("Guardar");
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });
        menu1.add(Guardar);

        Recuperar.setLabel("Recuperar");
        Recuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RecuperarActionPerformed(evt);
            }
        });
        menu1.add(Recuperar);

        menuBar1.add(menu1);

        menu2.setLabel("Importar");

        Importar.setLabel("Importar Fichero");
        Importar.setName("");
        Importar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportarActionPerformed(evt);
            }
        });
        menu2.add(Importar);

        menuBar1.add(menu2);

        setMenuBar(menuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //para salirse
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        vc.mostrarExcepcion("Desea cerrar el programa?");
        vc.setVisible(true);
        
        
        if(vc.confirmar()){
            System.exit(0);
        }
        
        
        
    }//GEN-LAST:event_exitForm

    //metodo para ordenar la lista alfabeticamente 
    private void recargar(){
        
        ArrayList<String> nombres = ag.getNombres();
        //para comprobar si la arraylist tiene datos
        //System.out.println(nombres);
        list1.removeAll();
        list1.add("AÑADIR PERSONA");
        
        for(String m : nombres){
            list1.add(m);
        }     
    }
    
    //botones, texto y checkbox desactivar/activar, limpieza de texto y checkbox
    private void list1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_list1ItemStateChanged
        
       String cad= list1.getSelectedItem();
       
       if(cad.equals("AÑADIR PERSONA")){
           //para limpiar todo cuando clique en nuevo
           textField2.setText("");
           textField3.setText("");
           textField4.setText("");
           textField5.setText("");
           textField6.setText("");
           checkbox1.setState(false);
           checkbox2.setState(true);
           
           textField2.setEditable(true);
           textField3.setEditable(true);
           textField4.setEditable(true);
           checkbox1.setEnabled(true);
           checkbox2.setEnabled(true);
           
           //activo el boton de alta
           alta.setEnabled(true);
           
           //desactivo los botones
           baja.setEnabled(false);
           modificar.setEnabled(false);
           
           //hacer invisible los campos para cuando visualice a alguien y despues le de a añadir no se quede nada
           label6.setVisible(true);
           textField6.setVisible(true);
           
           textField5.setVisible(false);
           label5.setVisible(false);
           
       //cuando no es "añadir persona"
       }else{
           //le paso el nombre,email y tlf cuando no clica "añadir persona" y selecciona alguien
           String [] datos = ag.getDatos(cad);
        textField2.setText(datos[1]);
        textField3.setText(datos[2]);
        textField4.setText(datos[3]);
        
        textField2.setEditable(false); //para que no se pueda editar el nombre
        textField3.setEditable(true); //confirmar que se pueda editar email
        textField4.setEditable(true); //confirmar que se pueda editar tlf
        
        //activo baja y modificar y desactivo el alta
        baja.setEnabled(true);
        modificar.setEnabled(true);
        alta.setEnabled(false);
        
      
        
        if(datos[0]!=null && datos[0].equals("Amigo")){
                        
            textField5.setText(datos[4]);
            textField5.setVisible(true);
            label5.setVisible(true);
             
            //cambiar campos de la checkbox         
            checkbox2.setState(false);
            checkbox1.setState(true);
            
            //empresa y texto hacer invisible
            label6.setVisible(false);
            textField6.setVisible(false);
        }else {
            
                     
            textField6.setText(datos[5]);
            textField6.setVisible(true);
            label6.setVisible(true);
            
            //cambiar campos de la checkbox
            checkbox1.setState(false);
            checkbox2.setState(true);
            
            //cumpleaños y texto hacer invisible
            textField5.setVisible(false);
            label5.setVisible(false);
            
        }
        }
        
         
    }//GEN-LAST:event_list1ItemStateChanged

    //metodo para modificar cosas cuando clico amigo
    private void checkbox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkbox1ItemStateChanged
        
        //para que cuando amigo este seleccionado y lo vuelva a seleccionar se ponga profesional
        checkbox2.setState(!checkbox1.getState());
        if(checkbox1.getState()){
            //hacer visible cumpleaños
            textField5.setVisible(true);
            label5.setVisible(true);
            
            //empresa y texto hacer invisible
            label6.setVisible(false);
            textField6.setVisible(false);
            
            //para que cuando se cambie de boton se cambien los campos
        }else {
            
            //hacer visible empresa
            textField6.setVisible(true);
            label6.setVisible(true);
            
            //cumpleaños y texto hacer invisible
            textField5.setVisible(false);
            label5.setVisible(false);
        }
    }//GEN-LAST:event_checkbox1ItemStateChanged

    //metodo para modificar cosas cuando clico profesional
    private void checkbox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkbox2ItemStateChanged
       
        //para que cuando profesional este seleccionado y lo vuelva a seleccionar se ponga amigo
        checkbox1.setState(!checkbox2.getState());
        
        if(checkbox2.getState()){
             
            //hacer visible empresa
            textField6.setVisible(true);
            label6.setVisible(true);
            
            //cumpleaños y texto hacer invisible
            textField5.setVisible(false);
            label5.setVisible(false);
            
            //para que cuando se cambie de boton se cambien los campos
        }else {
            
            //hacer visible cumpleaños
            textField5.setVisible(true);
            label5.setVisible(true);
            
            //empresa y texto hacer invisible
            label6.setVisible(false);
            textField6.setVisible(false);            
        }
    }//GEN-LAST:event_checkbox2ItemStateChanged

    //metodo para eliminar personas de la lista. ESTA BIEN
    private void bajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaActionPerformed
            
        String nomSeleccionado1 = list1.getSelectedItem();
        vc.mostrarExcepcion("Estas seguro que quieres dar de baja a " + nomSeleccionado1);
        
        if (!nomSeleccionado1.equals("AÑADIR PERSONA")) {               
            //eliminar sus datos de la agenda
            ag.baja(nomSeleccionado1);
            
            //para hacer visible la ventana de dialogo
            vc.setVisible(true);
            
            //si es que si lo da de baja sino nada
            if(vc.confirmar()){
                
            //eliminar el nombre de la lista visual
            list1.remove(nomSeleccionado1);
        
            //limpiar los campos de texto y desactivar los botones
            textField2.setText("");
            textField3.setText("");
            textField4.setText("");
            textField5.setText("");
            textField6.setText("");
            checkbox1.setState(false);
            checkbox2.setState(false);
            alta.setEnabled(false);
            baja.setEnabled(false);
            modificar.setEnabled(false);
            
            }
        }
    }//GEN-LAST:event_bajaActionPerformed

    //metodo para añadir personas a la lista. ESTA BIEN
    private void altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaActionPerformed
        
            //para cargar los escrito en el texto de nombre
            String nombreText1 = textField2.getText();//nombre
            String nombreText2 = textField3.getText();//email
            String nombreText3 = textField4.getText();//tlf
            String nombreText4 = textField5.getText();//cumpleaños
            String nombreText5 = textField6.getText();//empresa
            boolean cajaAmigo = checkbox1.getState(); //checkbox de amigo
            String cat=null;
            
            //si el amigo esta marcado a cat le doy amigo y sino es contactoprofesional                             
            if(cajaAmigo)cat="amigo";
            else cat="prof";
            
            //cargo todos los datos en la agenda
            try {
                ag.alta(cat, nombreText1,nombreText2,nombreText3,nombreText4,nombreText5);
                recargar();
                
                //limpio campos
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");           
                checkbox1.setState(false);
                checkbox2.setState(false);
                
        } catch (ParseException ex) {
            ve.mostrarExcepcion("Debes introducir la fecha correctamente: dd/mm/yyyy ");
            ve.setVisible(true);
            
        } catch (NombreVacioException | NombreIgualException ex) {
            ve.mostrarExcepcion(ex.getMessage());
            ve.setVisible(true);
            
        } catch (NumberFormatException ex) {
            ve.mostrarExcepcion("Debes introducir tu numero de telefono ");
            ve.setVisible(true);
            
        }
           
    }//GEN-LAST:event_altaActionPerformed

    //metodo de modificar el email, tlf, cumpleaños y empresa. ESTA BIEN
    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        String nomSeleccionado2 = list1.getSelectedItem();
        String nombreText2 = textField3.getText();//email
        String nombreText3 = textField4.getText();//tlf
        String nombreText4 = textField5.getText();//cumpleaños
        String nombreText5 = textField6.getText();//empresa

        if (!nomSeleccionado2.equals("AÑADIR PERSONA")){
            
            try {
                ag.actualizar(nomSeleccionado2, nombreText2, nombreText3, nombreText4, nombreText5);
        } catch (ParseException ex) {
            ve.mostrarExcepcion("Debes introducir la fecha correctamente: dd/mm/yyyy ");
            ve.setVisible(true);
            
        } catch (NombreVacioException | NombreIgualException ex) {
            ve.mostrarExcepcion(ex.getMessage());
            ve.setVisible(true);
            
        } catch (NumberFormatException ex) {
            ve.mostrarExcepcion("Debes introducir tu numero de telefono ");
            ve.setVisible(true);
                        
        }
           
        }
    }//GEN-LAST:event_modificarActionPerformed

    //metodo de guardar
    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        //directorio inicial
        fd2.setDirectory("C:\\");
        fd2.setTitle("Guardar Hashmap");
        fd2.setVisible(true);
        
        String dir = fd2.getDirectory();
        String fil = fd2.getFile();
        
        try {
            ag.guardarHashMap(dir + fil);
            
        } catch (IOException ex) {
            ve.mostrarExcepcion(ex.getMessage());
            ve.setVisible(true);
        }
        
        
    }//GEN-LAST:event_GuardarActionPerformed

    //metodo de recuperar
    private void RecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RecuperarActionPerformed
                
        //directorio inicial
        fd1.setDirectory("C:\\");
        fd1.setTitle("Recuperar Hashmap");
        fd1.setVisible(true);
        
        String dir = fd1.getDirectory();
        String fil = fd1.getFile();
        
        //para comprobar que le ha dado a aceptar cuando selecciona el archivo
        if(dir!= null && fil!= null){
            
            try {
                ag.recuperarHashMap(dir + fil);
                recargar();

            } catch (ClassNotFoundException | IOException ex) {
                ve.mostrarExcepcion(ex.getMessage());
                ve.setVisible(true);

            }  
        }
    }//GEN-LAST:event_RecuperarActionPerformed

    //metodo de importar fichero
    private void ImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportarActionPerformed
        fd1.setDirectory("C:\\");
        fd2.setTitle("Importar un fichero .txt");
        fd1.setVisible(true);
        
        String dir = fd1.getDirectory();
        String fil = fd1.getFile();
        
        //para comprobar que le ha dado a aceptar cuando selecciona el archivo
        if(dir!= null && fil!= null){
                        
            try {
                ag.importarFichero(dir + fil);
                recargar();
                
            } catch (NumeroErroresException ex) {
                ve.mostrarExcepcion(ex.getMessage());
                ve.setVisible(true);
                recargar(); //para asegurarse de no hacer nada si salta la excepcion
                
            } catch (IOException ex) {
                ve.mostrarExcepcion(ex.getMessage());
                ve.setVisible(true);
            }                     
        }                      
    }//GEN-LAST:event_ImportarActionPerformed

    private void listadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadoActionPerformed
        
        if(listado.isEnabled()){           
            String contactos = ag.listado();           
            lm.pack();
            lm.setTexto(contactos);           
            lm.setVisible(true);
                      
        }
    }//GEN-LAST:event_listadoActionPerformed
   
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazVisual().setVisible(true);
            }
        });
    }
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.MenuItem Guardar;
    private java.awt.MenuItem Importar;
    private java.awt.MenuItem Recuperar;
    private java.awt.Button alta;
    private java.awt.Button baja;
    private java.awt.Checkbox checkbox1;
    private java.awt.Checkbox checkbox2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.List list1;
    private java.awt.Button listado;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private java.awt.Button modificar;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private java.awt.Panel panel4;
    private java.awt.Panel panel5;
    private java.awt.TextField textField2;
    private java.awt.TextField textField3;
    private java.awt.TextField textField4;
    private java.awt.TextField textField5;
    private java.awt.TextField textField6;
    // End of variables declaration//GEN-END:variables
}
