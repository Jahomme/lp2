package com.biblioteca.main;

import com.biblioteca.model.Aluno;
import com.biblioteca.model.Emprestimo;
import com.biblioteca.model.Livro;
import com.biblioteca.model.Professor;
import com.biblioteca.service.BibliotecaService;

public class Main {
    public static void main(String[] args) {
        BibliotecaService service = new BibliotecaService();
        System.out.println("=== Sistema de Biblioteca - Início da Demonstração ===\n");

        System.out.println("--- Fase de Cadastros ---");
        Aluno aluno = new Aluno("João Silva", "2024001");
        Professor professor = new Professor("Maria Souza", "SIAPE123");
        service.cadastrarUsuario(aluno);
        service.cadastrarUsuario(professor);

        Livro livroJava = new Livro("Java Efetivo", "Joshua Bloch", 2);
        Livro livroArquitetura = new Livro("Arquitetura Limpa", "Robert C. Martin", 1);
        service.cadastrarLivro(livroJava);
        service.cadastrarLivro(livroArquitetura);
        System.out.println("-------------------------\n");

        service.listarEmprestimosEmAndamento();

        System.out.println("\n--- Fase de Empréstimos ---");
        Emprestimo emprestimoAluno = service.realizarEmprestimo(aluno, livroJava);
        
        Emprestimo emprestimoProfessor = service.realizarEmprestimo(professor, livroArquitetura);
        
        System.out.println("\nTentando emprestar livro sem estoque:");
        service.realizarEmprestimo(aluno, livroArquitetura);
        System.out.println("---------------------------\n");


        service.listarEmprestimosEmAndamento();
        System.out.println("\nEstoque do livro 'Java Efetivo' agora: " + livroJava.getQuantidadeEmEstoque());
        System.out.println("Estoque do livro 'Arquitetura Limpa' agora: " + livroArquitetura.getQuantidadeEmEstoque());


        System.out.println("\n--- Fase de Devolução ---");
        if (emprestimoAluno != null) {
            service.realizarDevolucao(emprestimoAluno);
        }
        System.out.println("-------------------------\n");
        

        service.listarEmprestimosEmAndamento();
        System.out.println("\nEstoque do livro 'Java Efetivo' após devolução: " + livroJava.getQuantidadeEmEstoque());

        System.out.println("\n=== Fim da Demonstração ===");
    }
}