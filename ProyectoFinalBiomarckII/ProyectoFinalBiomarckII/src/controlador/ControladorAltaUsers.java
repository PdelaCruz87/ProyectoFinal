/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Hash;
import modelo.RolVO;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FormularioAltaUser;
import vista.MenuInicio;

/**
 *
 * @author laptop
 */
public final class ControladorAltaUsers implements ActionListener {
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    UsuarioVO modeloUsuario = new UsuarioVO();
    FormularioAltaUser formAlta = new FormularioAltaUser();
    MenuInicio menuInicio = new MenuInicio();
    RolVO modeloRoles = new RolVO();

   
   public ControladorAltaUsers(FormularioAltaUser formAlta, UsuarioDAO usuarioDAO, UsuarioVO modeloUsuario, MenuInicio menuInicio, RolVO modeloRoles) {
       this.formAlta = formAlta;
       this.usuarioDAO = usuarioDAO;
       this.modeloUsuario = modeloUsuario;
       this.menuInicio = menuInicio;
       this.modeloRoles = modeloRoles;
       
       this.formAlta.btnGuardar.addActionListener(this);
       this.formAlta.btnCancelar.addActionListener(this);
       this.fecha();
       this.llenarCombo();
       
   }

    

   

   public void guardarUsuario(){
       
       String pass = new String(formAlta.txtClave.getPassword());
       String passcon = new String(formAlta.txtConfirmaClave.getPassword());
       
       if (pass.equals(passcon)) {
           
       String passCifrada = Hash.md5(pass);
       modeloUsuario.setUsuario(formAlta.txtUsuario.getText());
       modeloUsuario.setNombres(formAlta.txtNombres.getText());
       modeloUsuario.setRol(formAlta.cmbTipoUser.getSelectedItem().toString());
       modeloUsuario.setCorreo(formAlta.txtCorreo.getText());
       modeloUsuario.setClave(passCifrada);
       modeloUsuario.setFechaalta(formAlta.txtFechaAlta.getText());
       String respuesta = usuarioDAO.insertarUsuario(modeloUsuario);
       if (respuesta!=null) {
           JOptionPane.showMessageDialog(null, respuesta);
           
       }
           
       }else{
           JOptionPane.showMessageDialog(null, "las contraseñas no coinciden");
       }
       
       
       
 
   }
   
   
    public void llenarCombo(){
        
       ArrayList<RolVO> llenarCombo = usuarioDAO.roles();
       for (int i = 0; i < llenarCombo.size(); i++) {
       formAlta.cmbTipoUser.addItem(llenarCombo.get(i).getRol());
            
        }
  
           
       }
    
    public void fecha(){
        String fecha = formAlta.txtFechaAlta.getText();
        Calendar calendario = new GregorianCalendar();
        formAlta.txtFechaAlta.setText(" "+ calendario.get(Calendar.YEAR)+
                " - " +(calendario.get(Calendar.MONTH)+1)+ " - " +calendario.get(Calendar.DAY_OF_MONTH));
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== this.formAlta.btnGuardar) {
            this.guardarUsuario();
            
        }
        if (e.getSource()== this.formAlta.btnCancelar) {
            this.menuInicio.setVisible(true);
            formAlta.setVisible(false);
            
            
        }
    }
    
    
    
}


