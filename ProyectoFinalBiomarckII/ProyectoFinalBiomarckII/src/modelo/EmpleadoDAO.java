/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author laptop
 */
public class EmpleadoDAO extends Conector {
    
    EmpleadoVO modeloEmpleado = new EmpleadoVO();
    String cSql;
    String respuesta;
    PreparedStatement ps;
    ResultSet rs;

    public EmpleadoDAO() {
    }
    
    public String insertarEmpleado(EmpleadoVO modeloEmpleado){ 
        try {
            conectar();
            cSql = "INSERT INTO empleado(ficha_empleado, estatus, sexo, primer_nombre, segundo_nombre,"
                    + "primer_apellido, segundo_apellido, puesto, nit, salario, anios_antiguedad,"
                    + "renglon, cuadrilla, sede, categoria, no_afiliacion_igss)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            ps = getMiConexion().prepareStatement(cSql);
            ps.setInt(1, modeloEmpleado.getFicha());
            ps.setString(2, modeloEmpleado.getEstatus());
            ps.setString(3, modeloEmpleado.getSexo());
            ps.setString(4, modeloEmpleado.getPrimernombre());
            ps.setString(5, modeloEmpleado.getSegundonombre());
            ps.setString(6, modeloEmpleado.getPrimerapellido());
            ps.setString(7, modeloEmpleado.getSegundoapellido());
            ps.setString(8, modeloEmpleado.getPuesto());
            ps.setInt(9, modeloEmpleado.getNit());
            ps.setInt(10, modeloEmpleado.getSalario());
            ps.setInt(11, modeloEmpleado.getAntiguedad());
            ps.setInt(12, modeloEmpleado.getRenglon());
            ps.setString(13, modeloEmpleado.getCuadrilla());
            ps.setString(14, modeloEmpleado.getSede());
            ps.setString(15, modeloEmpleado.getCategoria());
            ps.setInt(16, modeloEmpleado.getIgss());
            ps.executeUpdate();
            String respuesta = "Empleado ingresado correctamente";
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        
        return respuesta;
        
    }
    
}
