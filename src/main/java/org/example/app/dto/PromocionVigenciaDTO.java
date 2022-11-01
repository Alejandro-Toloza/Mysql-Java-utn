package org.example.app.dto;

import java.util.Date;

public class PromocionVigenciaDTO {

    private int id_promocion_vigencia;
    private int id_promocion;
    private Date fecha_inicio;
    private Date fecha_fin;


    public int getId_promocion_vigencia() {
        return id_promocion_vigencia;
    }

    public void setId_promocion_vigencia(int id_promocion_vigencia) {
        this.id_promocion_vigencia = id_promocion_vigencia;
    }

    public int getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(int id_promocion) {
        this.id_promocion = id_promocion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }


}
