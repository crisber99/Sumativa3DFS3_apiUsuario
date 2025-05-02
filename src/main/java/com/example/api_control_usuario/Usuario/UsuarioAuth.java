package com.example.api_control_usuario.Usuario;

public class UsuarioAuth {
    private String rut;
    private String pass;

    public String getRut() {
        return rut;
    }
    
    public String getPass() {
        return pass;
    }

    public void setRut(String rut){
        this.rut = rut;
    }

    public void setPass(String pass){
        this.pass = pass;
    }
}
