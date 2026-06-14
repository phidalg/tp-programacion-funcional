package com.utn;

import com.utn.entities.Categoria;
import com.utn.entities.Pedido;
import com.utn.entities.Usuario;
import com.utn.enums.FormaPago;
import com.utn.enums.Rol;

public class Main {
    public static void main(String[] args) {

        Usuario usuario1 = Usuario.builder()
                .nombre("Pepe")
                .apellido("Perez")
                .rol(Rol.USUARIO)
                .celular("543519876543")
                .contrasena("abc123")
                .mail("pperez@mail.com")
                .build();

        Usuario usuario2 = Usuario.builder()
                .nombre("Juan")
                .apellido("Juanez")
                .rol(Rol.ADMIN)
                .celular("543517654321")
                .contrasena("123xyz")
                .mail("juan.j@mail.com.ar")
                .build();

        Pedido pedido1 = Pedido.builder()
                .formaPago(FormaPago.TRANSFERENCIA)
                .build();

        Pedido pedido2 = Pedido.builder()
                .formaPago(FormaPago.EFECTIVO)
                .build();

        Pedido pedido3 = Pedido.builder()
                .formaPago(FormaPago.TARJETA)
                .build();

        Categoria cat1 = Categoria.builder()
                .nombre("Electronica")
                .descripcion("Productos electrónicos.")
                .build();

        Categoria cat2 = Categoria.builder()
                .nombre("Kiosko")
                .descripcion("Articulos de kiosko.")
                .build();

        Categoria cat3 = Categoria.builder()
                .nombre("Indumentaria")
                .descripcion("Pilchas.")
                .build();

        System.out.println(pedido1);

    }
}