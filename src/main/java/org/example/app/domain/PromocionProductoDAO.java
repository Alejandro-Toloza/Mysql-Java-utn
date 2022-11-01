package org.example.app.domain;

import org.example.app.dto.PromocionDTO;
import org.example.app.dto.PromocionProductoDTO;
import org.example.app.jdbc.MyJdbc;

import java.util.ArrayList;
import java.util.List;

public class PromocionProductoDAO {

    public List<PromocionProductoDTO> findAll() {

        MyJdbc jdbc = MyJdbc.getInstance();
        String sql="";
        sql+="SELECT id_promocion_producto, ";
        sql+="id_producto, ";
        sql+="id_promocion_vigencia, ";
        sql+="descuento ";
        sql+="FROM promocion_producto";

        List<Object[]> list = jdbc.query(sql);
        List<PromocionProductoDTO> listDto = new ArrayList<>();
        for(Object[] fila:list){
            PromocionProductoDTO dto = new PromocionProductoDTO();
            dto.setId_promocion_producto((Integer) fila[0]);
            dto.setId_producto((Integer) fila[1]);
            dto.setId_promocion_vigencia((Integer) fila[2]);
            dto.setDescuento((Double) fila[3]);
            listDto.add(dto);
        }
        return listDto;

    }

}
