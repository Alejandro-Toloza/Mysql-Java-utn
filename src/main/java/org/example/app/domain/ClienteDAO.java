package org.example.app.domain;

import org.example.app.dto.ClienteDTO;
import org.example.app.jdbc.MyJdbc;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<ClienteDTO> findAll(){

        MyJdbc myJdbc = MyJdbc.getInstance();

        String sql = "";
        sql += "SELECT id_cliente, ";
        sql += "nombre, ";
        sql += "direccion ";
        sql += "FROM cliente";

        List<Object[]> list = myJdbc.query(sql);
        List<ClienteDTO> listDto = new ArrayList<>();

        for(Object[] fila: list){
            ClienteDTO clienteDTO = new ClienteDTO();
            clienteDTO.setId_cliente((Integer)fila[0]);
            clienteDTO.setNombre((String)fila[1]);
            clienteDTO.setDireccion((String)fila[2]);
            listDto.add(clienteDTO);
        }

        return listDto;

    }


}
