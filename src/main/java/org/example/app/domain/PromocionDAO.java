package org.example.app.domain;

import org.example.app.dto.PromocionDTO;
import org.example.app.jdbc.MyJdbc;

import java.util.ArrayList;
import java.util.List;

public class PromocionDAO {

     /*  public List<PromocionDTO> findAll() {

     MyJdbc jdbc = MyJdbc.getInstance();
        String sql="";
        sql+="SELECT id_promocion, ";
        sql+="descripcion ";
        sql+="FROM promocion";

        List<Object[]> list = jdbc.query(sql);
        List<PromocionDTO> listDto = new ArrayList<>();
        for(Object[] fila:list){
            PromocionDTO dto = new PromocionDTO();
            dto.setId_promocion((Integer) fila[0]);
            dto.setDescripcion((String) fila[1]);
            listDto.add(dto);
        }
        return listDto;

    }
*/

}
