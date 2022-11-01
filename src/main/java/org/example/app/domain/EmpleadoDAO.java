package org.example.app.domain;

import org.example.app.dto.EmpleadoDTO;
import org.example.app.jdbc.MyJdbc;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoDAO {

    public List<EmpleadoDTO> findAll(){

        MyJdbc myJdbc = MyJdbc.getInstance();

        String sql="";
        sql+="SELECT id_empleado, ";
        sql+="nombre ";
        sql+="FROM empleado";

        List<Object[]> list = myJdbc.query(sql);
        List<EmpleadoDTO> empleadoDTOList = new ArrayList<>();

        for(Object[] fila: list){
            EmpleadoDTO empleadoDTO = new EmpleadoDTO();
            empleadoDTO.setId_empleado((Integer) fila[0]);
            empleadoDTO.setNombre((String) fila[1]);
            empleadoDTOList.add(empleadoDTO);
        }

        return empleadoDTOList;
    }

}
