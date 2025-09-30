package com.biblioteca.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private Usuario usuario; 
    private Livro livro;     
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucaoEfetiva; 

    public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao) {
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        this.dataDevolucaoEfetiva = null; 
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataDevolucaoEfetiva() {
        return dataDevolucaoEfetiva;
    }

    public void setDataDevolucaoEfetiva(LocalDate dataDevolucaoEfetiva) {
        this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String devolvido = (dataDevolucaoEfetiva == null) ? "Em andamento" : "Devolvido em " + dataDevolucaoEfetiva.format(formatter);

        return "Emprestimo [" +
                "Usuario: " + usuario.getNome() + " (" + usuario.getClass().getSimpleName() + ")" +
                ", Livro: " + livro.getTitulo() +
                ", Data Empréstimo: " + dataEmprestimo.format(formatter) +
                ", Devolução Prevista: " + dataPrevistaDevolucao.format(formatter) +
                ", Status: " + devolvido +
                ']';
    }
}