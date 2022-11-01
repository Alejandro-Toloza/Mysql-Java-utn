package org.example.app.domain;

import org.example.app.dto.*;

import java.util.List;

public class Facade {

    private static int idCatAux;

    public List<CategoriaDTO> listCategoria(){
        CategoriaDAO dao = new CategoriaDAO();
        return dao.findAll();
    }
    public List<ProductoDTO> listProducto(){
        ProductoDAO dao = new ProductoDAO();
        return dao.findAll();
    }
    public List<PromocionProductoDTO> listPromocionProducto(){
        PromocionProductoDAO dao = new PromocionProductoDAO();
        return dao.findAll();
    }
    public List<ClienteDTO> clienteDTOList(){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.findAll();
    }
    public List<EmpleadoDTO> empleadoDTOList(){
        EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        return empleadoDAO.findAll();
    }

    public static int getIdAux() {
        return Facade.idCatAux;
    }

    public static void setIdAux(int idCatAux) {
        Facade.idCatAux = idCatAux;
    }



}
