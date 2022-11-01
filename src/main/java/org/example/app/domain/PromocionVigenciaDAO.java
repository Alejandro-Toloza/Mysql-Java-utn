package org.example.app.domain;

import org.example.app.dto.PromocionProductoDTO;
import org.example.app.dto.PromocionVigenciaDTO;
import org.example.app.jdbc.MyJdbc;

import java.util.ArrayList;
import java.util.List;

public class PromocionVigenciaDAO {

    public List<PromocionVigenciaDTO> findAll() {

        MyJdbc jdbc = MyJdbc.getInstance();
        String sql="";
        sql+="SELECT id_promocion_vigencia, ";
        sql+="id_promocion ";
        sql+="FROM promocion_vigencia";

        List<Object[]> list = jdbc.query(sql);
        List<PromocionVigenciaDTO> listDto = new ArrayList<>();
        for(Object[] fila:list){
            PromocionVigenciaDTO dto = new PromocionVigenciaDTO();
            dto.setId_promocion_vigencia((Integer) fila[0]);
            dto.setId_promocion((Integer) fila[1]);
            listDto.add(dto);
        }
        return listDto;

    }

}
