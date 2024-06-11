package com.desafio.desafio.controllers;

public class PluralizacionResponse {
    private String[] palabrasPlural;
    private int[] cuentaRegla;

    // Constructor sin argumentos necesario para Jackson
    public PluralizacionResponse() {
    }

    public PluralizacionResponse(String[] palabrasPlural, int[] cuentaRegla) {
        this.palabrasPlural = palabrasPlural;
        this.cuentaRegla = cuentaRegla;
    }

    // Getters y Setters
    public String[] getPalabrasPlural() {
        return palabrasPlural;
    }

    public void setPalabrasPlural(String[] palabrasPlural) {
        this.palabrasPlural = palabrasPlural;
    }

    public int[] getCuentaRegla() {
        return cuentaRegla;
    }

    public void setCuentaRegla(int[] cuentaRegla) {
        this.cuentaRegla = cuentaRegla;
    }
}
