package br.universidade.repo.repositorio;

import br.universidade.repo.excecoes.RepositorioException;
import br.universidade.repo.excecoes.RecursoNaoEncontradoException;

public interface Repositorio {

    void adicionar(Object obj) throws RepositorioException;

    void remover(String chave) throws RecursoNaoEncontradoException;
    
    Object buscar(String chave) throws RecursoNaoEncontradoException;

    Object[] listar();
    
} 