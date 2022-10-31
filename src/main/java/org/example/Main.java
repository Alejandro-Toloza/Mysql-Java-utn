package org.example;

import org.example.app.domain.Facade;
import org.example.app.dto.CategoriaDTO;
import org.example.app.dto.ProductoDTO;
import org.example.app.jdbc.MiShutdownHook;

import java.util.List;
import java.util.Scanner;

public class Main {

    static
    {
        Runtime.getRuntime().addShutdownHook(new MiShutdownHook());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Facade facade = new Facade();

        //Primera Pantalla
        System.out.println("-- SELECCIONES CATEGORIA --");
        List<CategoriaDTO> listDtoCategoria = facade.listCategoria();
        for(CategoriaDTO dto:listDtoCategoria){
            System.out.println(dto.getId_categoria()+" : "+dto.getDescripcion());
        }
        System.out.println("Seleccione categoria: ");
        int idCat = sc.nextInt();

        ///TODO: Duda
        //facade.setIdAux2(idCat);

        // segunda pantalla
        Facade.setIdAux(idCat);

        System.out.println("-- SELECCIONES PRODUCTO --");
        List<ProductoDTO> productoDTOList = facade.listProducto();

        for(ProductoDTO dto: productoDTOList){
            System.out.println("Producto: "+dto.getId_producto()+", descripcion: "+dto.getDescripcion()+",  id categoria: "+
            dto.getId_categoria()+","+dto.getFgl_discontinuo()+","+dto.getId_proveedor()+","+dto.getUnidades_reposicion()
            +".\nunidades en stock: "+dto.getUnidades_stock()+"\nprecio unitario:$"+dto.getPrecio_unitario());
            System.out.println("---***---***---***---***");
        }


        //Close Scanner
        sc.close();

    }

}