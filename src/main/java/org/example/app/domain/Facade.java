package org.example.app.domain;

import org.example.app.dto.CategoriaDTO;
import org.example.app.dto.ProductoDTO;

import java.util.List;

public class Facade {

    private static int idAux;

    //TODO: Duda
    //private int idAux2;

    public List<CategoriaDTO> listCategoria(){
        CategoriaDAO dao = new CategoriaDAO();
        return dao.findAll();
    }
    public List<ProductoDTO> listProducto(){
        ProductoDAO dao = new ProductoDAO();
        return dao.findAll();
    }

    public static int getIdAux() {
        return Facade.idAux;
    }

    public static void setIdAux(int idAux) {
        Facade.idAux = idAux;
    }

    //TODO: Duda
    /*public int getIdAux2() {
        return idAux2;
    }

    public void setIdAux2(int idAux2) {
        this.idAux2 = idAux2;
    }*/


}
