package br.universidade.repo.modelo;

public class Aluno {
    private String nome;
    private int matricula;
    private int idade;

    public Aluno(String nome, int matricula, int idade) {
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
    }
   
    public String getNome() {
        return this.nome;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public int getIdade() {
        return this.idade;
    }

    @Override
    public String toString() {
        return "Aluno [Aluno=" + nome + ", Matricula=" + matricula + ", Idade=" + idade + "]";
    }
}
