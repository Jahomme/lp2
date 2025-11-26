package estruturas;

import java.util.Iterator;


public class ListaLigada<T> implements Iterable<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho = 0;


    public void add(T elemento) {
        No<T> novoNo = new No<>(elemento);

        if (inicio == null) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
        tamanho++;
    }

    public int size() {
        return tamanho;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private No<T> atual = inicio;

            @Override
            public boolean hasNext() {
                return atual != null;
            }

            @Override
            public T next() {
                T dado = atual.valor;
                atual = atual.proximo;
                return dado;
            }
        };
    }

    @Override
    public String toString() {
        if (inicio == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        No<T> atual = inicio;
        while (atual != null) {
            sb.append(atual.valor);
            if (atual.proximo != null) sb.append(", ");
            atual = atual.proximo;
        }
        sb.append("]");
        return sb.toString();
    }

    // Metodo extra
    public boolean isEmpty() {
        if(tamanho == 0){
            return true;
        }

        return false;
    }

    // Metodo extra
    public boolean contem(T elementoBuscado) {
        No<T> atual = inicio;
        while (atual != null) {
            if (atual.valor.equals(elementoBuscado)) {
                return true;
            }
            atual = atual.proximo;
        }
        return false;
    }
}