package com.example.laboratorio8.model.beans;

public class Enemigo {
    private int EnemigoId;
    private String nombreEnemigo;
    private int ataque;
    private int experienciaEntregada;
    private int probabilidadTirarObjeto;
    private String objeto_entregado;
    private String genero;
    private String clase;

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

    public String getObjeto_entregado() {
        return objeto_entregado;
    }

    public void setObjeto_entregado(String objeto_entregado) {
        this.objeto_entregado = objeto_entregado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

}
