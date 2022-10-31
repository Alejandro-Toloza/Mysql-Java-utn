package org.example.app.domain;

import org.example.app.dto.ProductoDTO;
import org.example.app.jdbc.MyJdbc;

import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    //TODO: DUDA
    /*private int idAux2;
    Facade facade = new Facade();*/

    public List<ProductoDTO> findAll() {

        MyJdbc jdbc = MyJdbc.getInstance();
        String sql="";
        sql+="SELECT id_producto, ";
        sql+="descripcion, ";
        sql+="id_categoria, ";
        sql+="precio_unitario, ";
        sql+="unidades_stock ";
        sql+="FROM producto WHERE id_categoria=? ";

        //TODO DUDA:
        //idAux2= facade.getIdAux2();

        List<Object[]> list = jdbc.query(sql,Facade.getIdAux());
        List<ProductoDTO> listDto = new ArrayList<>();
        for(Object[] fila:list){
            ProductoDTO dto = new ProductoDTO();
            dto.setId_producto((Integer) fila[0]);
            dto.setDescripcion((String) fila[1]);
            dto.setId_categoria((Integer) fila[2]);
            dto.setPrecio_unitario((Double) fila[3]);;
            dto.setUnidades_stock((Integer) fila[4]);
            listDto.add(dto);
        }
        return listDto;

    }



}
