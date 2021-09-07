/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.EmpleadoDAO;
import modelo.EmpleadoVO;
import vista.EmpleadosF;

/**
 *
 * @author laptop
 */
public class ControladorEmpleado implements ActionListener {
    
    EmpleadosF empleadosF = new EmpleadosF();
    EmpleadoVO modeloEmpleado = new EmpleadoVO();
    EmpleadoDAO empleadoDAO = new EmpleadoDAO();

    public ControladorEmpleado(EmpleadosF empleadosF) {
        this.empleadosF = empleadosF;
        
        this.empleadosF.btnGuardarEmpleado.addActionListener(this);
        this.empleadosF.btnCancelar.addActionListener(this);
        
        
    }
    
    public void guardarEmpleado(){
        modeloEmpleado.setFicha(Integer.parseInt(empleadosF.txtFicha.getText()));
        modeloEmpleado.setEstatus(empleadosF.cmbEstatus.getSelectedItem().toString());
        modeloEmpleado.setSexo(empleadosF.cmbSexo.getSelectedItem().toString());
        modeloEmpleado.setPrimernombre(empleadosF.txtPrimerNombre.getText());
        modeloEmpleado.setSegundonombre(empleadosF.txtSegundoNombre.getText());
        modeloEmpleado.setPrimerapellido(empleadosF.txtPrimerApellido.getText());
        modeloEmpleado.setSegundoapellido(empleadosF.txtSegundoApellido.getText());
        modeloEmpleado.setPuesto(empleadosF.cmbPuesto.getSelectedItem().toString());
        modeloEmpleado.setNit(Integer.parseInt(empleadosF.txtNit.getText()));
        modeloEmpleado.setSalario(Integer.parseInt(empleadosF.txtSalario.getText()));
        modeloEmpleado.setAntiguedad(Integer.parseInt(empleadosF.txtAntiguedad.getText()));
        modeloEmpleado.setRenglon(Integer.parseInt(empleadosF.cmbRenglon.getSelectedItem().toString()));
        modeloEmpleado.setCuadrilla(empleadosF.cmbCuadrilla.getSelectedItem().toString());
        modeloEmpleado.setSede(empleadosF.txtSede.getText());
        modeloEmpleado.setCategoria(empleadosF.txtCategoria.getText());
        modeloEmpleado.setIgss(Integer.parseInt(empleadosF.txtNoAfiliacionIGSS.getText()));
        String respuesta = empleadoDAO.insertarEmpleado(modeloEmpleado);
        if (respuesta != null) {
            JOptionPane.showMessageDialog(null, respuesta);
            
        }
        
    }
    
    public void Limpiar(){
        empleadosF.txtFicha.setText("");
        empleadosF.txtPrimerNombre.setText("");
        empleadosF.txtSegundoNombre.setText("");
        empleadosF.txtPrimerApellido.setText("");
        empleadosF.txtSegundoApellido.setText("");
        empleadosF.txtNit.setText("");
        empleadosF.txtSalario.setText("");
        empleadosF.txtAntiguedad.setText("");
        empleadosF.txtSede.setText("");
        empleadosF.txtCategoria.setText("");
        empleadosF.txtNoAfiliacionIGSS.setText("");
        empleadosF.txtFicha.requestFocus();
        
        
        
    }
    
    public void salir(){
        empleadosF.dispose();
    }
    
    
    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==this.empleadosF.btnGuardarEmpleado) {
            this.guardarEmpleado();
            this.Limpiar();
            
        }
        if (e.getSource()==empleadosF.btnCancelar) {
            this.salir();
            
        }
        
    }
    
}
