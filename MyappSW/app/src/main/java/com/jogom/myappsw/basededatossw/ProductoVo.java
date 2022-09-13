package com.jogom.myappsw.basededatossw;

public class ProductoVo {
    private Integer codProducto;
    private String nombreProducto;
    private Double precioUnitario;
    private String fechaIngresoProducto;
    private Double pesoProducto;
    private Integer existenciasProducto;

    public ProductoVo() {
    }

    public ProductoVo(Integer codProducto, String nombreProducto, Double precioUnitario, String fechaIngresoProducto, Double pesoProducto, Integer existenciasProducto) {
        this.codProducto = codProducto;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.fechaIngresoProducto = fechaIngresoProducto;
        this.pesoProducto = pesoProducto;
        this.existenciasProducto = existenciasProducto;
    }

    public Integer getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Integer codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getFechaIngresoProducto() {
        return fechaIngresoProducto;
    }

    public void setFechaIngresoProducto(String fechaIngresoProducto) {
        this.fechaIngresoProducto = fechaIngresoProducto;
    }

    public Double getPesoProducto() {
        return pesoProducto;
    }

    public void setPesoProducto(Double pesoProducto) {
        this.pesoProducto = pesoProducto;
    }

    public Integer getExistenciasProducto() {
        return existenciasProducto;
    }

    public void setExistenciasProducto(Integer existenciasProducto) {
        this.existenciasProducto = existenciasProducto;
    }
}
