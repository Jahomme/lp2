package com.biblioteca.model;

public class Livro {
    private String titulo;
    private String autor;
    private int quantidadeEmEstoque;

    public Livro(String titulo, String autor, int quantidadeEmEstoque) {
        this.titulo = titulo;
        this.autor = autor;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", estoque=" + quantidadeEmEstoque +
                '}';
    }
}