package com.example.api_control_usuario.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdUsuario;
    @Column(name = "nombre")
    @NotNull(message = "Campo en null, debe ingresar un Nombre.")
    @NotEmpty(message = "Campo vacío, debe ingresar un Nombre.")
    private String Nombre;
    @Column(name = "ap_paterno")
    @NotNull(message = "Campo en null, debe ingresar un Apellido Paterno.")
    @NotEmpty(message = "Campo vacío, debe ingresar un Apellido Paterno.")
    private String Ap_paterno;
    @Column(name = "rut")
    @NotNull(message = "Campo en null, debe ingresar un Rut.")
    @NotEmpty(message = "Campo vacío, debe ingresar un Rut.")
    private String rut;
    @Column(name = "email")
    @NotNull(message = "Campo en null, debe ingresar un Email.")
    @NotEmpty(message = "Campo vacío, debe ingresar un Email.")
    private String Email;
    @Column(name = "pass")
    @NotNull(message = "Campo en null, debe ingresar un Password.")
    @NotEmpty(message = "Campo vacío, debe ingresar un Password.")
    private String pass;
    @Column(name = "rol")
    @NotNull(message = "Campo en null, debe ingresar un Rol.")
    @NotEmpty(message = "Campo vacío, debe ingresar un Rol.")
    private String Rol;

    public Long getId(){
        return IdUsuario;
    }

    public String getNombre(){
        return Nombre;
    }

    public String getApPaterno(){
        return Ap_paterno;
    }

    public String getRut(){
        return rut;
    }

    public String getEmail(){
        return Email;
    }

    public String getPass(){
        return pass;
    }

    public String getRol(){
        return Rol;
    }

//SET
    public void setId(Long id){
        this.IdUsuario = id;
    }

    public void setNombre(String nombre){
        this.Nombre = nombre;
    }

    public void setRut(String rut){
        this.rut = rut;
    }

    public void setApPaterno(String ap_paterno){
        this.Ap_paterno = ap_paterno;
    }

    public void setEmail(String email){
        this.Email = email;
    }

    public void setPass(String pass){
        this.pass = pass;
    }

    public void setRol(String rol){
        this.Rol = rol;
    }

}
