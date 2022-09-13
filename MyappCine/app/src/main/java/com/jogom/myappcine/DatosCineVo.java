package com.jogom.myappcine;

public class DatosCineVo {

    private Integer imagenPelicula;
    private Integer nombrePelicula;
    private Integer duracion;
    private Integer precioBoleto;
    private Integer sinopsis;
    private Integer direcActores;
    private Integer puntuacion;
    private Integer recaudacion;

    public DatosCineVo() {
    }

    public DatosCineVo(Integer imagenPelicula, Integer nombrePelicula, Integer duracion, Integer precioBoleto) {
        this.imagenPelicula = imagenPelicula;
        this.nombrePelicula = nombrePelicula;
        this.duracion = duracion;
        this.precioBoleto = precioBoleto;
    }

    public DatosCineVo(Integer imagenPelicula, Integer nombrePelicula, Integer sinopsis, Integer direcActores, Integer puntuacion, Integer recaudacion) {
        this.imagenPelicula = imagenPelicula;
        this.nombrePelicula = nombrePelicula;
        this.sinopsis = sinopsis;
        this.direcActores = direcActores;
        this.puntuacion = puntuacion;
        this.recaudacion = recaudacion;
    }

    public Integer getImagenPelicula() {
        return imagenPelicula;
    }

    public void setImagenPelicula(Integer imagenPelicula) {
        this.imagenPelicula = imagenPelicula;
    }

    public Integer getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(Integer nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Integer getPrecioBoleto() {
        return precioBoleto;
    }

    public void setPrecioBoleto(Integer precioBoleto) {
        this.precioBoleto = precioBoleto;
    }

    public Integer getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(Integer sinopsis) {
        this.sinopsis = sinopsis;
    }

    public Integer getDirecActores() {
        return direcActores;
    }

    public void setDirecActores(Integer direcActores) {
        this.direcActores = direcActores;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer getRecaudacion() {
        return recaudacion;
    }

    public void setRecaudacion(Integer recaudacion) {
        this.recaudacion = recaudacion;
    }
}
