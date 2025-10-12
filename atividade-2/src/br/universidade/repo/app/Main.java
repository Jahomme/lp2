package br.universidade.repo.app;

import br.universidade.repo.modelo.Aluno;
import br.universidade.repo.modelo.Livro;
import br.universidade.repo.repositorio.Repositorio;
import br.universidade.repo.repositorio.RepositorioAlunoArray;
import br.universidade.repo.repositorio.RepositorioLivroArray;
import br.universidade.repo.excecoes.RepositorioException;
import br.universidade.repo.excecoes.RepositorioCheioException;
import br.universidade.repo.excecoes.RecursoNaoEncontradoException;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- INICIANDO TESTES COM REPOSITÓRIO DE ALUNOS ---");
        gerenciarAlunos();

        System.out.println("\n\n--- INICIANDO TESTES COM REPOSITÓRIO DE LIVROS ---");
        gerenciarLivros();
    }

    public static void gerenciarAlunos() {
        Repositorio repositorioAlunos = new RepositorioAlunoArray(3);

        System.out.println("\n>>> Adicionando alunos...");
        try {
            repositorioAlunos.adicionar(new Aluno("João Silva", 101, 20));
            repositorioAlunos.adicionar(new Aluno("Maria Souza", 102, 22));
            repositorioAlunos.adicionar(new Aluno("Pedro Lima", 103, 21));
            System.out.println("Alunos adicionados com sucesso!");
        } catch (RepositorioException e) {
            System.err.println("Erro inesperado ao adicionar: " + e.getMessage());
        }

        listarEImprimirAlunos(repositorioAlunos);

        System.out.println("\n>>> Tentando adicionar um 4º aluno (deve falhar)...");
        try {
            repositorioAlunos.adicionar(new Aluno("Ana Costa", 104, 19));
        } catch (RepositorioCheioException e) {
            System.err.println("ERRO CAPTURADO CORRETAMENTE: " + e.getMessage());
        } catch (RepositorioException e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }

        System.out.println("\n>>> Buscando e removendo alunos...");
        try {
            Object aluno = repositorioAlunos.buscar("102");
            System.out.println("Busca por matrícula '102' bem-sucedida: " + aluno);

            repositorioAlunos.remover("101");
            System.out.println("Remoção do aluno com matrícula '101' bem-sucedida.");
            listarEImprimirAlunos(repositorioAlunos);

            System.out.println("Tentando buscar aluno com matrícula '999' (deve falhar)...");
            repositorioAlunos.buscar("999");

        } catch (RecursoNaoEncontradoException e) {
            System.err.println("ERRO CAPTURADO CORRETAMENTE: " + e.getMessage());
        }
    }

    public static void gerenciarLivros() {
        Repositorio repositorioLivros = new RepositorioLivroArray(2);

        System.out.println("\n>>> Adicionando livros...");
        try {
            repositorioLivros.adicionar(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", 5));
            repositorioLivros.adicionar(new Livro("Java para Iniciantes", "Herbert Schildt", 10));
            System.out.println("Livros adicionados com sucesso!");
        } catch (RepositorioException e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }

        listarEImprimirLivros(repositorioLivros);

        System.out.println("\n>>> Tentando adicionar um 3º livro (deve falhar)...");
        try {
            repositorioLivros.adicionar(new Livro("O Guia do Mochileiro das Galáxias", "Douglas Adams", 3));
        } catch (RepositorioCheioException e) {
            System.err.println("ERRO CAPTURADO CORRETAMENTE: " + e.getMessage());
        } catch (RepositorioException e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }

        System.out.println("\n>>> Removendo livros...");
        try {
            System.out.println("Tentando remover o livro 'Livro Fantasma' (deve falhar)...");
            repositorioLivros.remover("Livro Fantasma");
        } catch (RecursoNaoEncontradoException e) {
            System.err.println("ERRO CAPTURADO CORRETAMENTE: " + e.getMessage());
        }
    }


    private static void listarEImprimirAlunos(Repositorio repositorio) {
        System.out.println("--- Lista de Alunos Atuais ---");
        Object[] alunos = repositorio.listar();
        if (alunos.length == 0) {
            System.out.println("Nenhum aluno no repositório.");
            return;
        }
        for (Object obj : alunos) {
            Aluno aluno = (Aluno) obj;
            System.out.println(aluno.toString()); 
        }
        System.out.println("------------------------------");
    }

    private static void listarEImprimirLivros(Repositorio repositorio) {
        System.out.println("--- Lista de Livros Atuais ---");
        Object[] livros = repositorio.listar();
        if (livros.length == 0) {
            System.out.println("Nenhum livro no repositório.");
            return;
        }
        for (Object obj : livros) {
            Livro livro = (Livro) obj;
            System.out.println(livro.toString()); 
        }
        System.out.println("-----------------------------");
    }
}