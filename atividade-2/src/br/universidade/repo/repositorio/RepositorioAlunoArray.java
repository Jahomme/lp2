package br.universidade.repo.repositorio;

import br.universidade.repo.modelo.Aluno;
import br.universidade.repo.excecoes.*;

public class RepositorioAlunoArray implements Repositorio {
    private Aluno[] alunos;
    private int proximoIndice;

    public RepositorioAlunoArray(int capacidade) {
        this.alunos = new Aluno[capacidade];
        this.proximoIndice = 0;
    }

    @Override
    public void adicionar(Object obj) throws RepositorioException {
        if (this.proximoIndice >= this.alunos.length) {
            throw new RepositorioCheioException();
        }
        
        if (!(obj instanceof Aluno)) {
            throw new RepositorioException("Objeto fornecido não é do tipo Aluno.");
        }

        this.alunos[this.proximoIndice] = (Aluno) obj;
        this.proximoIndice++;
    }

    @Override
    public void remover(String chave) throws RecursoNaoEncontradoException {
        int matriculaParaRemover = Integer.parseInt(chave);
        int indiceEncontrado = -1;

        for (int i = 0; i < proximoIndice; i++) {
            if (alunos[i].getMatricula() == matriculaParaRemover) {
                indiceEncontrado = i;
                break;
            }
        }

        if (indiceEncontrado != -1) {
            for (int i = indiceEncontrado; i < proximoIndice - 1; i++) {
                alunos[i] = alunos[i + 1];
            }
            proximoIndice--;
            alunos[proximoIndice] = null;
        } else {
            throw new RecursoNaoEncontradoException(chave);
        }
    }

    @Override
    public Object buscar(String chave) throws RecursoNaoEncontradoException {
        int matriculaParaBuscar = Integer.parseInt(chave);
        for (int i = 0; i < proximoIndice; i++) {
            if (alunos[i].getMatricula() == matriculaParaBuscar) {
                return alunos[i];
            }
        }
        throw new RecursoNaoEncontradoException(chave);
    }

    @Override
    public Object[] listar() {
        Aluno[] listaDeAlunos = new Aluno[proximoIndice];
        System.arraycopy(this.alunos, 0, listaDeAlunos, 0, proximoIndice);
        return listaDeAlunos;
    }
}