package com.example.api_control_usuario.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long>{

    @Query("SELECT u FROM Usuarios u WHERE u.rut= :rut AND u.pass= :pass")
    Usuarios findByLogin(@Param("rut") String rut, @Param("pass") String pass);

}
