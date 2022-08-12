package com.jogom.myappreciclerviewtelefonos;

public class DatosVo {
    private int img;
    private String nombre;
    private String numero;

    public DatosVo() {
    }

    public DatosVo(int img, String nombre, String numero) {
        this.img = img;
        this.nombre = nombre;
        this.numero = numero;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
