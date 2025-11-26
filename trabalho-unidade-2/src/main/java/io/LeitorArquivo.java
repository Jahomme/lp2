package io;

import estruturas.ListaLigada;
import exceptions.NonNullAndNegativeNumbersException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LeitorArquivo {

    public void carregarDados(String nomeArquivo, ListaLigada<Integer> lista) {
        Scanner scanner = null;

        try {
            File arquivo = new File(nomeArquivo);
            scanner = new Scanner(arquivo);


            while (scanner.hasNext()) {
                String dadoBruto = scanner.next();

                try {
                    int numero = Integer.parseInt(dadoBruto);

                    if(numero <= 0){
                        throw new NonNullAndNegativeNumbersException("Erro: número não permitido pela regra de negócio");
                    }

                    lista.add(numero);

                } catch (NumberFormatException e) {
                    System.out.println("Dado ignorado: " + dadoBruto);
                } catch (NonNullAndNegativeNumbersException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
        } finally {
            if (scanner != null) {
                scanner.close();
                System.out.println("Recurso Scanner fechado no finally.");
            }
        }
    }
}