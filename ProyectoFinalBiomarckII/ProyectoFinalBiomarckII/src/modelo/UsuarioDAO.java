/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

/**
 *
 * @author laptop
 */
public class UsuarioDAO extends Conector {
    UsuarioVO modeloUsuario = new UsuarioVO();
    String cSql;
    PreparedStatement ps;
    ResultSet rs;
    String respuesta;

    public UsuarioDAO() {
    }
    
    public String insertarUsuario(UsuarioVO modeloUsuario){
        
        try {
            
            conectar();
            cSql = "INSERT INTO usuarios (usuario, nombres,rol, correo, clave, fechaalta)"
                    + "VALUES(?,?,?,?,?,?)";
            ps = getMiConexion().prepareStatement(cSql);
            ps.setString(1, modeloUsuario.getUsuario());
            ps.setString(2, modeloUsuario.getNombres());
            ps.setString(3, modeloUsuario.getRol());
            ps.setString(4, modeloUsuario.getCorreo());
            ps.setString(5, modeloUsuario.getClave());
            ps.setString(6, modeloUsuario.fechaalta);
            ps.executeUpdate();  
            respuesta = "Datos Almacenados Correctamente";
        }catch (Exception e){
            System.err.println("Datos no almacenados"+e.getMessage());
            
        }
        
        
        return respuesta;
    }
    
    public ArrayList <RolVO> roles(){
        ArrayList<RolVO> datos = new ArrayList<>();
       
        
        try {
            conectar();
            cSql = "SELECT * FROM tipousuario";
            ps = getMiConexion().prepareStatement(cSql);
            rs = ps.executeQuery();
            while(rs.next()){
                RolVO rolesVO = new RolVO();
                rolesVO.setRol(rs.getString("rol"));
                  
                datos.add(rolesVO);
                
            }
            desconectar();
            
        }catch(Exception e){
            System.err.println("Error" +e.getMessage());
            
        }
        
        return datos;
    }
    
    public UsuarioVO validarUsuario(String usuario, String clave){
        
        try {
            conectar();
            cSql = "SELECT * FROM usuarios WHERE usuario=? AND clave=?";
            ps = getMiConexion().prepareStatement(cSql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            rs = ps.executeQuery();
            while(rs.next()){
                modeloUsuario.setUsuario(rs.getString("usuario"));
                modeloUsuario.setNombres(rs.getString("nombres"));
                modeloUsuario.setCorreo(rs.getString("correo"));
                modeloUsuario.setRol(rs.getString("rol"));
                modeloUsuario.setClave(rs.getString("clave"));
                modeloUsuario.setFechaalta(rs.getString("fechaalta"));
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return modeloUsuario;
        
    }
     
}
