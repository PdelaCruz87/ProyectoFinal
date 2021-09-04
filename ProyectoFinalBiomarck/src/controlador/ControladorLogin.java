/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.UsuarioDAO;
import modelo.UsuarioVO;
import vista.FormularioAltaUser;
import vista.FormularioLogin;
import vista.FormularioPrincipal;
import vista.MenuInicio;

/**
 *
 * @author laptop
 */
public class ControladorLogin implements ActionListener {
    
    UsuarioVO modeloUsuario = new UsuarioVO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    MenuInicio inicio = new MenuInicio();
    FormularioLogin formLogin = new FormularioLogin();
    FormularioPrincipal fprincipal = new FormularioPrincipal();
    FormularioAltaUser formAlta = new FormularioAltaUser();

    public ControladorLogin(UsuarioVO modeloUsuario, UsuarioDAO usuarioDAO,
            MenuInicio inicio, FormularioLogin formLogin, FormularioPrincipal fprincipal, FormularioAltaUser formAlta) {
        
        this.modeloUsuario = modeloUsuario;
        this.usuarioDAO = usuarioDAO;
        this.formLogin = formLogin;
        this.inicio = inicio;
        this.fprincipal = fprincipal;
        this.formAlta = formAlta;
        
        this.formLogin.bntIniciarSesion.addActionListener(this);
        this.formLogin.btnCancelar.addActionListener(this);
    }
    
    public void validar(){
        String usuario = formLogin.txtUsuario.getText();
        String clave = formLogin.txtContraseña.getText();
        if (formLogin.txtUsuario.getText().equals("") || formLogin.txtContraseña.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "El Usuario o contraseña no pueden ir vacios");
            
        }else{
            modeloUsuario = usuarioDAO.validarUsuario(usuario, clave);
            if (modeloUsuario.getUsuario()!= null && modeloUsuario.getClave()!=null) {
                fprincipal.setVisible(true);
                formLogin.setVisible(false);
                
                
            }else{
                JOptionPane.showMessageDialog(null, "ingrese usuario o contraseña");
                formLogin.txtUsuario.requestFocus();
            }
        }
        
    }
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== formLogin.bntIniciarSesion) {
            this.validar();
            
        }
        if (e.getSource()== formLogin.btnCancelar) {
            this.inicio.setVisible(true);
            this.formLogin.setVisible(false);
            
            
        }
        
    }
    
}
