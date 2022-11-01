package org.example.app.dto;

public class PromocionProductoDTO {

    private int id_promocion_producto;
    private int id_producto;
    private int id_promocion_vigencia;
    private double descuento;

    public int getId_promocion_producto() {
        return id_promocion_producto;
    }

    public void setId_promocion_producto(int id_promocion_producto) {
        this.id_promocion_producto = id_promocion_producto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getId_promocion_vigencia() {
        return id_promocion_vigencia;
    }

    public void setId_promocion_vigencia(int id_promocion_vigencia) {
        this.id_promocion_vigencia = id_promocion_vigencia;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
}
