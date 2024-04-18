
package interfazvisual;




public class ListadoMostrar extends java.awt.Dialog {

   
    public ListadoMostrar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
   
    }

    public void setTexto(String mensaje){
        textArea1.setText("\n" + mensaje + "\n");
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel1 = new java.awt.Panel();
        Salir = new java.awt.Button();
        textArea1 = new java.awt.TextArea();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        java.awt.GridBagLayout panel1Layout = new java.awt.GridBagLayout();
        panel1Layout.columnWidths = new int[] {0};
        panel1Layout.rowHeights = new int[] {0, 25, 0};
        panel1.setLayout(panel1Layout);

        Salir.setLabel("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        panel1.add(Salir, gridBagConstraints);
        panel1.add(textArea1, new java.awt.GridBagConstraints());

        add(panel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_SalirActionPerformed

    
   
  


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button Salir;
    private java.awt.Panel panel1;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
