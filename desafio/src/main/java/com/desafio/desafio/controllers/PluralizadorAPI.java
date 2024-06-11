package com.desafio.desafio.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PluralizadorAPI {

    static int[] cuenta_regla = new int[4];

    public static void main(String[] args) {
        SpringApplication.run(PluralizadorAPI.class, args);
    }

    @PostMapping(value = "/pluralizar", produces = "application/json")
    public ResponseEntity<PluralizacionResponse> pluralizarPalabras(@RequestBody String[] palabras) {
        for (int i = 0; i < cuenta_regla.length; i++) {
            cuenta_regla[i] = 0;
        }
        String[] palabrasPlural = pluralizador(palabras);
        PluralizacionResponse response = new PluralizacionResponse(palabrasPlural, cuenta_regla);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static String[] pluralizador(String[] palabras) {
        String[] palabrasPlural = new String[palabras.length];

        for (int i = 0; i < palabras.length; i++) {
            palabrasPlural[i] = pluralizaPalabra(palabras[i]);
        }

        return palabrasPlural;
    }

    private static String pluralizaPalabra(String palabra) {
        palabra = palabra.toLowerCase();
        int largo_palabra = palabra.length();
        char eval = palabra.charAt(largo_palabra - 1);
        int nRegla = regla(eval);

        if (nRegla == 0) {
            palabra += "s";
            cuenta_regla[0] += 1;
        }
        if (nRegla == 1) {
            cuenta_regla[1] += 1;
        }
        if (nRegla == 2) {
            palabra = palabra.substring(0, palabra.length() - 1);
            palabra += "ces";
            cuenta_regla[2] += 1;
        }
        if (nRegla == 3) {
            palabra += "es";
            cuenta_regla[3] += 1;
        }
        return palabra;
    }

    public static int regla(char letra) {
        if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
            return 0;
        }
        if (letra == 's' || letra == 'x') {
            return 1;
        }
        if (letra == 'z') {
            return 2;
        }
        return 3;
    }
}
