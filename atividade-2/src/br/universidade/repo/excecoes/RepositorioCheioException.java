package br.universidade.repo.excecoes;

public class RepositorioCheioException extends RepositorioException {
     public RepositorioCheioException() {
        super("O repositório está cheio.");
    }
}
