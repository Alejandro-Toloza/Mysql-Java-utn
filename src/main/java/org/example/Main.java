package org.example;

import org.example.app.domain.Facade;
import org.example.app.dto.*;
import org.example.app.jdbc.MiShutdownHook;

import java.util.List;
import java.util.Scanner;

public class Main {

    static
    {
        Runtime.getRuntime().addShutdownHook(new MiShutdownHook());
    }

    public static void main(String[] args) {

        int id_producto;
        double precio_unitario = 0;
        double precio_total = 0;
        int id_promo_vigencia;
        int cantidad;
        Integer num=0;
        String nombre_promocion;
        String nombreCategoria;

        Scanner scanner = new Scanner(System.in);
        Facade facade = new Facade();

        //PRIMERA PANTALLA -----------------------------------------
        System.out.println("-- SELECCIONES CATEGORIA --");
        List<CategoriaDTO> listDtoCategoria = facade.listCategoria();
        for (CategoriaDTO dto : listDtoCategoria) {
            System.out.println(dto.getId_categoria() + " : " + dto.getDescripcion());
        }
        System.out.println("Seleccione categoria: ");
        int idCat = scanner.nextInt();

        ///DUDA
        //facade.setIdAux2(idCat);

        // SEGUNDA PANTALLA -------------------------------------
        Facade.setIdAux(idCat);
        nombreCategoria = (idCat == 1 ? "COMPUTACION" : idCat == 2 ? "TELEFONIA" : idCat == 3 ? "VIDEOJUEGOS" : "-");

        System.out.println("-- SELECCIONE PRODUCTO DE " + nombreCategoria);
        List<ProductoDTO> productoDTOList = facade.listProducto();
        //List<ProductoDTO> list2 = new ArrayList<>();

        for (ProductoDTO dto : productoDTOList) {
            System.out.println("Producto: " + dto.getId_producto() + ", descripcion: " + dto.getDescripcion() + ",  id categoria: " +
                    dto.getId_categoria() + " - (" + nombreCategoria + ")" + ".\nunidades en stock: " + dto.getUnidades_stock() + "\nprecio unitario:$" + dto.getPrecio_unitario());
            System.out.println("--------------------------------------");
            //list2.add(dto);
        }

        //TERCERA PANTALLA: -----------------------------
        System.out.println("SELECCIONE EL N° DE ID del producto");
        id_producto = scanner.nextInt();

        for (ProductoDTO dto : productoDTOList) {
            //System.out.println((id_producto==dto.getId_producto()?dto.getDescripcion():"-"));
            if (id_producto == dto.getId_producto()) {
                precio_unitario = dto.getPrecio_unitario();
                System.out.println("Nombre Prudcto seleccionado: " + dto.getDescripcion());
                System.out.println("Precio unitario: $" + precio_unitario);
            }

        }

        //CUARTA PANTALLA --------------------------------

        List<PromocionProductoDTO> promocionProductoDTOList = facade.listPromocionProducto();


        System.out.println("\n---PROMO VIGENCIA");

        for (PromocionProductoDTO dto3 : promocionProductoDTOList) {

            if (dto3.getId_producto() == id_producto) {
                nombre_promocion = (dto3.getId_promocion_vigencia()>=10&&dto3.getId_promocion_vigencia()<=12?
                        "Promo Tarjeta Naranja":
                        dto3.getId_promocion_vigencia()>=20&&dto3.getId_promocion_vigencia()<=21?
                                "Promo Banco Galicia":
                                dto3.getId_promocion_vigencia()>=30&&dto3.getId_promocion_vigencia()<=32?"Promo Clarin 365":"");

                //descuento = precio_unitario - (precio_unitario * dto3.getDescuento());

                System.out.println("Id Producto: "+dto3.getId_producto() +
                        ", id_promo_vigencia: " + dto3.getId_promocion_vigencia() +
                        "\nNombre Promo: " + nombre_promocion +
                        ". \nDescuento: " + dto3.getDescuento() +
                        "\nPrecio con descuento: $"+(precio_unitario - (precio_unitario * dto3.getDescuento())));

                System.out.println("\n-------------------");
            }

        }

        System.out.println("Seleccione el id de promocion para generar el descuento\n " +
                "o un valor negativo si no quiere ninguna promo");
        id_promo_vigencia = scanner.nextInt();

            for(PromocionProductoDTO dto4 : promocionProductoDTOList){

                if(id_promo_vigencia == dto4.getId_promocion_vigencia()&&id_producto==dto4.getId_producto()){
                    precio_total += precio_unitario - (dto4.getDescuento()*precio_unitario);
                    //System.out.println("Precio con descuento"+precio_total);
                    System.out.println("---------------------------");
                    System.out.println("Indique la cantidad de unidades que desea comprar: ");
                    cantidad = scanner.nextInt();
                    switch (cantidad){
                        case 1:
                            break;
                        case 2:
                            precio_total *=2;
                            break;
                        case 3:
                            precio_total *= 3;
                            break;
                        default:
                            precio_total *=1;
                            break;
                    }
                }

            }

        System.out.println("precio total: "+precio_total);

        // QUINTA PANTALLA
        List<EmpleadoDTO> empleadoDTOList = facade.empleadoDTOList();
        System.out.println("Ingrese el id del empleado: ");
        num = scanner.nextInt();
        for(EmpleadoDTO dto : empleadoDTOList){
            if(num==dto.getId_empleado()){
                System.out.println("Id Empleado: "+dto.getId_empleado()+"\nNombre Empleado: "+dto.getNombre());
            }
        }

        //SEXTA PANTALLA
        List<ClienteDTO> clienteDTOList = facade.clienteDTOList();
        System.out.println("Ingrese el id del Cliente: ");
        num = scanner.nextInt();
        for(ClienteDTO dto : clienteDTOList){
            if(num==dto.getId_cliente()){
                System.out.println("Id Cliente: "+dto.getId_cliente()+"\nNombre Empleado: "+dto.getNombre());
            }
        }

        System.out.println("Orden Generada por un total de: $"+precio_total);

        scanner.close();

    }

}