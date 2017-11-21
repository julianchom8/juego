/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class Panel extends javax.swing.JFrame {

    private String foto;
    private Persona persona;
    private DefaultTableModel table_model_personas;
    /**
     * Creates new form Panel
     */
   
    public Panel() {
        initComponents();
        button_eliminar.setVisible(false);
    }
    
    public void setTableModel(DefaultTableModel table_model_personas){
        this.table_model_personas = table_model_personas;
    }
    
    public void refreshTableModel()
    {
        ArrayList<Persona> lista_personas = Repositorio.obtenerTodos();
        while (table_model_personas.getRowCount() > 0) {
            table_model_personas.removeRow(0);
        }
        
        for(Persona p : lista_personas)
        {
            String[] data = {Integer.toString(p.getId()), p.getDocumento(), p.getNombre(), p.getTelefono(), p.getEmail(), p.getApellido()};
            table_model_personas.addRow(data);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_email = new javax.swing.JLabel();
        text_email = new javax.swing.JTextField();
        button_foto = new javax.swing.JButton();
        button_guardar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label_documento = new javax.swing.JLabel();
        button_eliminar = new javax.swing.JButton();
        text_documento = new javax.swing.JTextField();
        button_cancelar = new javax.swing.JButton();
        label_nombre = new javax.swing.JLabel();
        text_nombre = new javax.swing.JTextField();
        label_telefono = new javax.swing.JLabel();
        text_telefono = new javax.swing.JTextField();
        Start = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label_email.setText("Email");

        button_foto.setText("Buscar foto");
        button_foto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_fotoActionPerformed(evt);
            }
        });

        button_guardar.setText("Guardar");
        button_guardar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        button_guardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        button_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_guardarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        label_documento.setText("Documento");

        button_eliminar.setBackground(new java.awt.Color(255, 102, 102));
        button_eliminar.setForeground(new java.awt.Color(255, 255, 255));
        button_eliminar.setText("Eliminar");
        button_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_eliminarActionPerformed(evt);
            }
        });

        text_documento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_documentoActionPerformed(evt);
            }
        });

        button_cancelar.setText("Cancelar");
        button_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelarActionPerformed(evt);
            }
        });

        label_nombre.setText("Nombre");

        label_telefono.setText("Teléfono");

        text_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_telefonoActionPerformed(evt);
            }
        });

        Start.setText("Start");
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(Start)
                .addContainerGap(509, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(button_foto, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(label_documento, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(label_nombre)
                                .addComponent(label_telefono))
                            .addGap(153, 153, 153)
                            .addComponent(label_email))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(text_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(text_email, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(text_nombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(text_documento, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(button_guardar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button_cancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(399, 399, 399)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(266, Short.MAX_VALUE)
                .addComponent(Start)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(51, 51, 51)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label_documento)
                            .addGap(7, 7, 7)
                            .addComponent(text_documento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label_nombre)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(text_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(label_telefono)
                                .addComponent(label_email))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(text_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(text_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button_foto)
                        .addComponent(button_guardar)
                        .addComponent(button_cancelar)
                        .addComponent(button_eliminar))
                    .addContainerGap(51, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_fotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_fotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_fotoActionPerformed

    private void button_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_guardarActionPerformed

        if( text_documento.getText().isEmpty() ||
            text_nombre.getText().isEmpty() ||
            text_telefono.getText().isEmpty() ||
            text_email.getText().isEmpty()

        ){
            JOptionPane.showMessageDialog(this, "Por favor diligencie todo el formulario", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            switch(evt.getActionCommand())
            {
                case "Guardar":
                persona = Persona.crear(0, text_documento.getText(), text_nombre.getText(), text_telefono.getText(), text_email.getText(), "");
                Repositorio.crear(persona);
                JOptionPane.showMessageDialog(this, "Persona creada satisfactoriamente", "Bien", JOptionPane.INFORMATION_MESSAGE);
                break;
                case "Editar":
                persona.setDocumento(text_documento.getText());
                persona.setNombre(text_nombre.getText());
                persona.setTelefono(text_telefono.getText());
                persona.setEmail(text_email.getText());
                Repositorio.editar(persona);
                JOptionPane.showMessageDialog(this, "Persona actualizada satisfactoriamente", "Bien", JOptionPane.INFORMATION_MESSAGE);
                break;
            }

            this.refreshTableModel();
            this.resetPersona();
        }
    }//GEN-LAST:event_button_guardarActionPerformed

    private void button_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_eliminarActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Realmente desea eliminar esta persona", "Eliminar", JOptionPane.YES_NO_OPTION);

        if(result == JOptionPane.YES_OPTION){
            Repositorio.eliminar(persona);
            this.refreshTableModel();
            this.resetPersona();
        }
    }//GEN-LAST:event_button_eliminarActionPerformed

    private void text_documentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_documentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_documentoActionPerformed

    private void button_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelarActionPerformed
        resetPersona();
    }//GEN-LAST:event_button_cancelarActionPerformed

    private void text_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_telefonoActionPerformed

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_StartActionPerformed
                                              
   
    private void resetForm() {
        text_documento.setText("");
        text_nombre.setText("");
        text_telefono.setText("");
        text_email.setText("");
    }
    
    private void resetPersona() {
        persona.setId(0);
        persona.setDocumento("");
        persona.setEmail("");
        persona.setNombre("");
        persona.setTelefono("");
        popularPersona(persona);
    }
    
    private void popularPersona(Persona persona) {
        text_documento.setText(persona.getDocumento());
        text_nombre.setText(persona.getNombre());
        text_telefono.setText(persona.getTelefono());
        text_email.setText(persona.getEmail());
        
        if(persona.getId() != 0){
            button_eliminar.setVisible(true);
            button_guardar.setActionCommand("Editar");
        } else {
            button_eliminar.setVisible(false);
            button_guardar.setActionCommand("Guardar");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Start;
    private javax.swing.JButton button_cancelar;
    private javax.swing.JButton button_eliminar;
    private javax.swing.JButton button_foto;
    private javax.swing.JButton button_guardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label_documento;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_nombre;
    private javax.swing.JLabel label_telefono;
    private javax.swing.JTextField text_documento;
    private javax.swing.JTextField text_email;
    private javax.swing.JTextField text_nombre;
    private javax.swing.JTextField text_telefono;
    // End of variables declaration//GEN-END:variables
}
