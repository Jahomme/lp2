package app;

import estruturas.ListaLigada;
import io.LeitorArquivo;
import tarefas.Processador;

public class Main {

    public static void main(String[] args){

        ListaLigada<Integer> dados = lerArquivo();

        iniciarProcessamento(dados);
    }


    public static ListaLigada<Integer> lerArquivo(){
        ListaLigada<Integer> lista = new ListaLigada<>();
        LeitorArquivo leitorArquivo = new LeitorArquivo();
        String caminhoArquivo = "dados.txt";

        System.out.println("Iniciando leitura do arquivo...");
        leitorArquivo.carregarDados(caminhoArquivo, lista);

        System.out.println("Leitura concluída! Itens na lista: " + lista.size());
        System.out.println("Lista final: " + lista.toString() + "\n");


        return lista;
    }


    public static void iniciarProcessamento(ListaLigada<Integer> lista) {
        if (lista.isEmpty()) {
            System.out.println("Lista vazia. Nada a processar.");
            return;
        }

        Processador<Integer> processador = new Processador<>();
        processador.executar(lista);
    }
}