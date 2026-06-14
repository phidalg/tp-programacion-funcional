package com.utn;

import com.utn.dtos.UsuarioDTO;
import com.utn.entities.Categoria;
import com.utn.entities.Pedido;
import com.utn.entities.Producto;
import com.utn.entities.Usuario;
import com.utn.enums.FormaPago;
import com.utn.enums.Rol;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        final Set<Producto> productos = new HashSet<>();

        System.out.println("\nCreando usuarios...");

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

        System.out.println("Creando pedidos...");

        Pedido pedido1 = Pedido.builder()
                .formaPago(FormaPago.TRANSFERENCIA)
                .build();

        Pedido pedido2 = Pedido.builder()
                .formaPago(FormaPago.EFECTIVO)
                .build();

        Pedido pedido3 = Pedido.builder()
                .formaPago(FormaPago.TARJETA)
                .build();

        System.out.println("Creando categorías de productos...");

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

        System.out.println("Creando productos...");

        Producto pendrive = Producto.builder()
                .nombre("Pendrive del Jefe de Gabinete")
                .precio(6800.00)
                .descripcion("Con Bitcoins de dudosa procedencia.")
                .stock(120)
                .imagen("pendrive.png")
                .disponible(true)
                .build();

        Producto auriculares = Producto.builder()
                .nombre("Auriculares Bluetooth")
                .precio(25999.99)
                .descripcion("Auriculares inalámbricos con cancelación de ruido.")
                .stock(50)
                .imagen("auriculares_bt.png")
                .disponible(true)
                .build();

        Producto teclado = Producto.builder()
                .nombre("Teclado Mecánico")
                .precio(18500.00)
                .descripcion("Teclado mecánico retroiluminado, disposición en español.")
                .stock(30)
                .imagen("teclado_mecanico.png")
                .disponible(true)
                .build();


        Producto cargador = Producto.builder()
                .nombre("Cargador Inalámbrico")
                .precio(9750.50)
                .descripcion("Cargador inalámbrico rápido, compatible con Qi.")
                .stock(0)
                .imagen("cargador.png")
                .disponible(false)
                .build();

        Producto alfajor = Producto.builder()
                .nombre("Alfajor")
                .precio(850.00)
                .descripcion("Alfajor de chocolate con tres capas de dulce de leche.")
                .stock(200)
                .imagen("alfajor.png")
                .disponible(true)
                .build();

        Producto gaseosa = Producto.builder()
                .nombre("Gaseosa Cola 500 ml")
                .precio(1200.00)
                .descripcion("Bebida gaseosa sabor cola, botella individual.")
                .stock(150)
                .imagen("gaseosa_cola.png")
                .disponible(true)
                .build();

        Producto chicles = Producto.builder()
                .nombre("Chicles Menta")
                .precio(350.00)
                .descripcion("Pastillas de goma menta, caja por 12 unidades.")
                .stock(300)
                .imagen("chicles_menta.png")
                .disponible(true)
                .build();

        Producto remera = Producto.builder()
                .nombre("Remera Básica Blanca")
                .precio(7200.00)
                .descripcion("Remera 100% algodón, talle M.")
                .stock(80)
                .imagen("remera_blanca.png")
                .disponible(true)
                .build();

        Producto buzo = Producto.builder()
                .nombre("Buzo Canguro Gris")
                .precio(15400.00)
                .descripcion("Buzo con capucha y bolsillo frontal, talle L.")
                .stock(45)
                .imagen("buzo_gris.png")
                .disponible(true)
                .build();

        Producto zapatillas = Producto.builder()
                .nombre("Zapatillas Running")
                .precio(42000.00)
                .descripcion("Zapatillas deportivas con suela amortiguada, número 42.")
                .stock(0)
                .imagen("zapatillas_running.png")
                .disponible(false)
                .build();

        System.out.println("Asignando productos a las categorías...");

        cat1.addProducto(auriculares);
        cat1.addProducto(teclado);
        cat1.addProducto(pendrive);
        cat1.addProducto(cargador);

        cat2.addProducto(alfajor);
        cat2.addProducto(gaseosa);
        cat2.addProducto(chicles);

        cat3.addProducto(remera);
        cat3.addProducto(buzo);
        cat3.addProducto(zapatillas);

        productos.addAll(cat1.getProductos());
        productos.addAll(cat2.getProductos());
        productos.addAll(cat3.getProductos());

        System.out.println("Agregando detalles a los pedidos...");

        pedido1.addDetallePedido(1, pendrive);
        pedido1.addDetallePedido(2, alfajor);

        pedido2.addDetallePedido(5, remera);
        pedido2.addDetallePedido(1, buzo);
        pedido2.addDetallePedido(1, zapatillas);

        pedido3.addDetallePedido(10, chicles);
        pedido3.addDetallePedido(1, teclado);

        System.out.println("Asignando pedidos a los usuarios...");

        usuario1.agregarPedido(pedido1);
        usuario1.agregarPedido(pedido2);
        usuario2.agregarPedido(pedido3);

        System.out.println("Imprimiendo por consola un producto:\n");

        System.out.println(pendrive);

        System.out.println("\nImprimiendo por consola el listado de productos cargados:\n");

        for (Producto producto : productos) {
            System.out.println(producto);
        }

        System.out.println("\nImprimiendo por consola los pedidos del usuario que tiene mayor cantidad de pedidos:\n");

        for (Pedido pedido : usuario1.getPedidos()) {
            System.out.println(pedido);
        }

        System.out.println(
                "\nInstanciando un nuevo producto donde el campo utilizado en equals() y hashCode() " +
                "son iguales a un producto existente:\n(El campo comparado es \"nombre\")\n");

        Producto repetido = Producto.builder()
                .nombre("Alfajor")
                .build();
        System.out.println(repetido);

        System.out.println("\nComparando el producto repetido con todos los demás productos:\n");

        for (Producto producto : productos) {
            System.out.println("Comparando " + producto.getNombre() + " con " + repetido.getNombre() + "...");
            boolean sonIguales = producto.equals(repetido);
            System.out.println("Resultado: " + sonIguales );
        }

        System.out.println("\nImprimiendo por consola un objeto usuarioDTO:\n");

        UsuarioDTO usuario1DTO = new UsuarioDTO(
                usuario1.getId(),
                usuario1.getCreatedAt(),
                usuario1.getNombre(),
                usuario1.getApellido(),
                usuario1.getMail(),
                usuario1.getCelular(),
                usuario1.getPedidos());

        System.out.println(usuario1DTO);
    }
}