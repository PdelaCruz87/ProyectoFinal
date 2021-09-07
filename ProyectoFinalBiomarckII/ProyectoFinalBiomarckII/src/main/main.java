/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controlador.ControladorAltaUsers;
import controlador.ControladorInicio;
import controlador.ControladorLogin;
import modelo.RolVO;
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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MenuInicio inicio = new MenuInicio();
        FormularioAltaUser formAlta = new FormularioAltaUser();
        FormularioLogin formLogin = new FormularioLogin();
        FormularioPrincipal fprincipal = new FormularioPrincipal();
        
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        UsuarioVO modeloUsuario = new UsuarioVO();
        RolVO modeloRoles = new RolVO();
        
        
        ControladorInicio cInicio = new ControladorInicio(inicio,formAlta, formLogin);
        ControladorAltaUsers cUsers = new ControladorAltaUsers(formAlta,usuarioDAO,modeloUsuario,inicio,modeloRoles);
        ControladorLogin cLogin = new ControladorLogin(modeloUsuario, usuarioDAO, inicio, formLogin, fprincipal, formAlta);
        
                  
        inicio.setVisible(true);
        inicio.setLocationRelativeTo(null);
        
        
        
    }
    
}
