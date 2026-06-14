package com.utn.dtos;

import com.utn.entities.Pedido;
import java.time.LocalDateTime;
import java.util.Set;

public record UsuarioDTO(
        long id,
        LocalDateTime createdAt,
        String nombre,
        String apellido,
        String mail,
        String celular,
        Set<Pedido> pedidos
) {}