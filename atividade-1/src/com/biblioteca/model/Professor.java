package com.biblioteca.model;

public class Professor extends Usuario {

    public Professor(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public int getPrazoDias() {
        return 14;
    }
}