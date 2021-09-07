/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author laptop
 */
public class UsuarioVO {
    
    String usuario;
    String nombres;
    String correo;
    String rol;
    String Clave;
    String fechaalta;

    public UsuarioVO() {
    }

    public UsuarioVO(String usuario, String nombres, String correo, String rol, String Clave, String fechaalta) {
        this.usuario = usuario;
        this.nombres = nombres;
        this.correo = correo;
        this.rol = rol;
        this.Clave = Clave;
        this.fechaalta = fechaalta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public String getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(String fechaalta) {
        this.fechaalta = fechaalta;
    }
    
    
    
    
}
