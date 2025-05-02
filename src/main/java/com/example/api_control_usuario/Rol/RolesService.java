package com.example.api_control_usuario.Rol;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RolesService {

private final RolesRepository rolRepo;

    public Roles creaRol(Roles rol){
        return rolRepo.save(rol);
    }

    public List<Roles> getAllRol(){
        return rolRepo.findAll();
    }

    public Optional<Roles> getRol(Long id){
        return rolRepo.findById(id);
    }

    public Roles updRol(Long id, Roles rol){
        if(rolRepo.existsById(id)){
            rol.setIdRol(id);
            return rolRepo.save(rol);
        }
        else return null;
    }

    public void delRol(long id){
        rolRepo.deleteById(id);
    }
}
