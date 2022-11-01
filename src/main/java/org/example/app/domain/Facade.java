package org.example.app.domain;

import org.example.app.dto.*;

import java.util.List;

public class Facade {

    private static int idCatAux;
    private static int idProductoAux;

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
    public List<PromocionDTO> listPromocion(){
        PromocionDAO dao = new PromocionDAO();
        return dao.findAll();
    }
    public List<PromocionVigenciaDTO> listPromocionVigencia(){
        PromocionVigenciaDAO dao = new PromocionVigenciaDAO();
        return dao.findAll();
    }
    public List<PromocionProductoDTO> listPromocionProducto(){
        PromocionProductoDAO dao = new PromocionProductoDAO();
        return dao.findAll();
    }


    public static int getIdAux() {
        return Facade.idCatAux;
    }

    public static void setIdAux(int idCatAux) {
        Facade.idCatAux = idCatAux;
    }

    public static int getIdProductoAux() {
        return idProductoAux;
    }

    public static void setIdProductoAux(int idProductoAux) {
        Facade.idProductoAux = idProductoAux;
    }

    //TODO: Duda
    /*public int getIdAux2() {
        return idAux2;
    }

    public void setIdAux2(int idAux2) {
        this.idAux2 = idAux2;
    }*/


}
