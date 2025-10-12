package br.universidade.repo.excecoes;

public class RecursoNaoEncontradoException extends RepositorioException {
    public RecursoNaoEncontradoException(String chave) {
        super("Recurso com a chave '" + chave + "' não foi encontrado.");
    }
}
