package org.example.app.domain;

import org.example.app.domain.CategoriaDAO;
import org.example.app.dto.CategoriaDTO;

import java.util.List;

public class Facade {

    public List<CategoriaDTO> listCategoria(){

        CategoriaDAO dao = new CategoriaDAO();
        return dao.findAll();
    }

}
