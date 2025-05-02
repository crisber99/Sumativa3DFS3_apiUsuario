package com.example.api_control_usuario.Rol;

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
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdRol;
    @Column(name = "nombre_rol")
    @NotNull(message = "Debe ingresar el nombre del rol")
    @NotEmpty(message = "Debe ingresar el nombre del rol, no puede estar vacío.")
    private String NombreRol;

    public Long getIdRol(){
        return IdRol;
    }

    public String getNombreRol(){
        return NombreRol;
    }

    //SET
    public void setIdRol(Long id){
        this.IdRol = id;
    }

    public void setNombreRol(String nombre){
        this.NombreRol = nombre;
    }
}
