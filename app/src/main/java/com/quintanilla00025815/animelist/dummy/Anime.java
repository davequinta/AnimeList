package com.quintanilla00025815.animelist.dummy;

/**
 * Created by Nestor on 15/5/2017.
 */

public class Anime {
    private int idAnime;
    private String titulo;
    private int imgId;
    private String genero;
    private String subGenero;
    private int cantCapitulos;
    private int cantTemporadas;
    private String descripcion;

    public Anime(String titulo, int imgId) {
        this.titulo = titulo;
        this.imgId = imgId;
    }

    public int getIdAnime() {
        return idAnime;
    }

    public Anime(int idAnime, String titulo, int imgId, String genero, String subGenero, int cantCapitulos, int cantTemporadas, String descripcion) {
        this.idAnime = idAnime;
        this.titulo = titulo;
        this.imgId = imgId;
        this.genero = genero;
        this.subGenero = subGenero;
        this.cantCapitulos = cantCapitulos;
        this.cantTemporadas = cantTemporadas;
        this.descripcion = descripcion;
    }

    public void setIdAnime(int idAnime) {
        this.idAnime = idAnime;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSubGenero() {
        return subGenero;
    }

    public void setSubGenero(String subGenero) {
        this.subGenero = subGenero;
    }

    public int getCantCapitulos() {
        return cantCapitulos;
    }

    public void setCantCapitulos(int cantCapitulos) {
        this.cantCapitulos = cantCapitulos;
    }

    public int getCantTemporadas() {
        return cantTemporadas;
    }

    public void setCantTemporadas(int cantTemporadas) {
        this.cantTemporadas = cantTemporadas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



}
