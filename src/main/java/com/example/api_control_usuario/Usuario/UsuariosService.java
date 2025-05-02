package com.example.api_control_usuario.Usuario;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuariosService {

    private final UsuariosRepository userRepo;

    public Usuarios creaUsuario(Usuarios user){
        return userRepo.save(user);
    }

    public List<Usuarios> getAllUsuario(){
        return userRepo.findAll();
    }

    public Optional<Usuarios> getUsuario(Long id){
        return userRepo.findById(id);
    }

    public Usuarios getLogin(String rut, String pass){
        return userRepo.findByLogin(rut, pass);
    }

    public Usuarios updUsuario(Long id, Usuarios user){
        if(userRepo.existsById(id)){
            user.setId(id);
            return userRepo.save(user);
        }
        else return null;
    }

    public void delUsuario(long id){
        userRepo.deleteById(id);
    }
}
