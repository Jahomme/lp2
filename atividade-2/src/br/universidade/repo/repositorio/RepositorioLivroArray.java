package br.universidade.repo.repositorio;

import br.universidade.repo.modelo.Livro;
import br.universidade.repo.excecoes.*;

public class RepositorioLivroArray implements Repositorio {
    private Livro[] livros;
    private int proximoIndice;

    public RepositorioLivroArray(int capacidade) {
        this.livros = new Livro[capacidade];
        this.proximoIndice = 0;
    }

    @Override
    public void adicionar(Object obj) throws RepositorioException {
        if (this.proximoIndice >= this.livros.length) {
            throw new RepositorioCheioException();
        }

        if (!(obj instanceof Livro)) {
            throw new RepositorioException("Objeto fornecido não é do tipo Livro.");
        }

        this.livros[this.proximoIndice] = (Livro) obj;
        this.proximoIndice++;
    }

    @Override
    public void remover(String chave) throws RecursoNaoEncontradoException {
        int indiceEncontrado = -1;

        for (int i = 0; i < proximoIndice; i++) {
            if (livros[i].getTitulo().equalsIgnoreCase(chave)) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado != -1) {
            for (int i = indiceEncontrado; i < proximoIndice - 1; i++) {
                livros[i] = livros[i + 1];
            }
            proximoIndice--;
            livros[proximoIndice] = null; 
        } else {
            throw new RecursoNaoEncontradoException(chave);
        }
    }

    @Override
    public Object buscar(String chave) throws RecursoNaoEncontradoException {
        for (int i = 0; i < proximoIndice; i++) {
            if (livros[i].getTitulo().equalsIgnoreCase(chave)) {
                return livros[i]; 
            }
        }
        
        throw new RecursoNaoEncontradoException(chave);
    }

    @Override
    public Object[] listar() {
        Livro[] listaDeLivros = new Livro[proximoIndice];
        
        System.arraycopy(this.livros, 0, listaDeLivros, 0, proximoIndice);
        
        return listaDeLivros;
    }
}