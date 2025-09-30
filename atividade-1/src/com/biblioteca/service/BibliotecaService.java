package com.biblioteca.service;

import com.biblioteca.model.Emprestimo;
import com.biblioteca.model.Livro;
import com.biblioteca.model.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Livro> livros = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public void cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        System.out.println("Usuário cadastrado: " + usuario.getNome());
    }

    public void cadastrarLivro(Livro livro) {
        this.livros.add(livro);
        System.out.println("Livro cadastrado: " + livro.getTitulo());
    }

    public Emprestimo realizarEmprestimo(Usuario usuario, Livro livro) {
        if (livro.getQuantidadeEmEstoque() <= 0) {
            System.out.println("ERRO: O livro '" + livro.getTitulo() + "' não está disponível no estoque.");
            return null;
        }

        livro.setQuantidadeEmEstoque(livro.getQuantidadeEmEstoque() - 1);

        LocalDate dataEmprestimo = LocalDate.now();
        
        int prazo = usuario.getPrazoDias(); 
        LocalDate dataPrevista = dataEmprestimo.plusDays(prazo);

        Emprestimo novoEmprestimo = new Emprestimo(usuario, livro, dataEmprestimo, dataPrevista);
        this.emprestimos.add(novoEmprestimo);

        System.out.println("SUCESSO: Empréstimo realizado!");
        System.out.println(novoEmprestimo);
        
        return novoEmprestimo;
    }

    public void realizarDevolucao(Emprestimo emprestimo) {
        if (emprestimo.getDataDevolucaoEfetiva() != null) {
            System.out.println("ATENÇÃO: Este empréstimo já foi finalizado.");
            return;
        }
        
        emprestimo.setDataDevolucaoEfetiva(LocalDate.now());

        Livro livroDevolvido = emprestimo.getLivro();
        livroDevolvido.setQuantidadeEmEstoque(livroDevolvido.getQuantidadeEmEstoque() + 1);

        System.out.println("SUCESSO: Devolução do livro '" + livroDevolvido.getTitulo() + "' registrada.");
    }

    public void listarEmprestimosEmAndamento() {
        System.out.println("\n--- LISTA DE EMPRÉSTIMOS EM ANDAMENTO ---");
        boolean encontrou = false;
        for (Emprestimo e : this.emprestimos) {
            if (e.getDataDevolucaoEfetiva() == null) {
                System.out.println(e);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhum empréstimo em andamento no momento.");
        }
        System.out.println("------------------------------------------");
    }
}