package org.example;

import org.example.app.domain.Facade;
import org.example.app.dto.CategoriaDTO;
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
        System.out.println("-- SELECCIONES CATEGORIA --");
        List<CategoriaDTO> listDto = facade.listCategoria();
        for(CategoriaDTO dto:listDto){
            System.out.println(dto.getId_categoria()+" : "+dto.getDescripcion());
        }
        System.out.println("Seleccione categoria: ");
        int idCat = sc.nextInt();


        //Close Scanner
        sc.close();
    }

}