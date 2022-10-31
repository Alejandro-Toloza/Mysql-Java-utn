package org.example.app.domain;

import org.example.app.dto.CategoriaDTO;
import org.example.app.jdbc.MyJdbc;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public List<CategoriaDTO> findAll(){
        MyJdbc x = MyJdbc.getInstance();
        List<Object[]> list = x.query("SELECT * FROM categoria");

        List<CategoriaDTO> listDto = new ArrayList<>();
        for(Object[] fila:list){
            CategoriaDTO dto = new CategoriaDTO();
            dto.setId_categoria((Integer) fila[0]);
            dto.setDescripcion((String) fila[1]);
            listDto.add(dto);
        }
        return listDto;
    }


}
