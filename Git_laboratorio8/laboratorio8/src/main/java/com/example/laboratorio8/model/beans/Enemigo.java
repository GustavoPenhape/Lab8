package com.example.laboratorio8.model.beans;

public class Enemigo {
    private int EnemigoId;
    private String nombreEnemigo;
    private int ataque;
    private int experienciaEntregada;
    private int probabilidadTirarObjeto;
    private String objetoEntregado;
    private String genero;
    private int clase;

    public int getEnemigoId() {
        return EnemigoId;
    }

    public void setEnemigoId(int enemigoId) {
        EnemigoId = enemigoId;
    }

    public String getNombreEnemigo() {
        return nombreEnemigo;
    }

    public void setNombreEnemigo(String nombreEnemigo) {
        this.nombreEnemigo = nombreEnemigo;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getExperienciaEntregada() {
        return experienciaEntregada;
    }

    public void setExperienciaEntregada(int experienciaEntregada) {
        this.experienciaEntregada = experienciaEntregada;
    }

    public int getProbabilidadTirarObjeto() {
        return probabilidadTirarObjeto;
    }

    public void setProbabilidadTirarObjeto(int probabilidadTirarObjeto) {
        this.probabilidadTirarObjeto = probabilidadTirarObjeto;
    }

    public String getObjetoEntregado() {
        return objetoEntregado;
    }

    public void setObjetoEntregado(String objetoEntregado) {
        this.objetoEntregado = objetoEntregado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getClase() {
        return clase;
    }

    public void setClase(int clase) {
        this.clase = clase;
    }

}
