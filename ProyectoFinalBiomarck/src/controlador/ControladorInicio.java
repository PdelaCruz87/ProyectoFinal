/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.FormularioAltaUser;
import vista.FormularioLogin;
import vista.MenuInicio;

/**
 *
 * @author laptop
 */
public class ControladorInicio implements ActionListener {
    
    MenuInicio inicio = new MenuInicio();
    FormularioAltaUser formAlta = new FormularioAltaUser();
    FormularioLogin formLogin = new FormularioLogin();

    public ControladorInicio(MenuInicio inicio, FormularioAltaUser formAlta, FormularioLogin formLogin) {
        this.inicio = inicio;
        this.formAlta = formAlta;
        this.formLogin = formLogin;
        
        this.inicio.btnLogin.addActionListener(this);
        this.inicio.btnAlta.addActionListener(this);
    
    
    

  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== this.inicio.btnLogin) {
            formLogin.setVisible(true);
            inicio.setVisible(false);
            
        }
        if (e.getSource()== this.inicio.btnAlta) {
            formAlta.setVisible(true);
            inicio.setVisible(false);
            
        }
    }
}