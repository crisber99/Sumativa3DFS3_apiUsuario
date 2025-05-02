package com.example.api_control_usuario.Rol;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api_control_usuario.Exception.ForoNotFoundException;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import lombok.RequiredArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/rol")
@RequiredArgsConstructor
public class RolesController {

    private static final Logger log = LoggerFactory.getLogger(RolesController.class);
    private final RolesService Roleservice;

    @PostMapping    
    public Roles addRol(@RequestBody Roles rol) {
        log.info("Rol creado");
        return Roleservice.creaRol(rol);
    }
    
    @GetMapping("/{id}")
    public EntityModel<Roles> getRolByid(@PathVariable Long id) {
        log.info("getRolByid");
        Optional<Roles> rol = Roleservice.getRol(id);
        if(rol.isPresent()){
            return EntityModel.of(rol.get(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getRolByid(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllRol()).withRel("all-roles"));
        }
        else{
            throw new ForoNotFoundException("Rol no funciona con el id: " + id);
        }
    }
    
    @GetMapping
    public CollectionModel<EntityModel<Roles>> getAllRol() {
        log.info("getRolByid");
        List<Roles> lstRoles = Roleservice.getAllRol();
        
        if(lstRoles.size() > 0){
            List<EntityModel<Roles>> RolResources = lstRoles.stream()
            .map(rol -> EntityModel.of(rol, 
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getRolByid(rol.getIdRol())).withSelfRel()
                ))
            .collect(Collectors.toList());
            
            WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllRol());
            CollectionModel<EntityModel<Roles>> resources = CollectionModel.of(RolResources, linkTo.withRel("Rol"));

            return resources;
        }
        else{
            throw new ForoNotFoundException("No se puede desplegar la lista de Roles en estos momentos");
        }

        
    }

    @PutMapping("/{id}")
    public Roles updRoles(@PathVariable Long id, @RequestBody Roles rol) {
        return Roleservice.updRol(id, rol);
    }

    @DeleteMapping("/{id}")
    public void delRol(@PathVariable Long id){
        Roleservice.delRol(id);
    }

}
