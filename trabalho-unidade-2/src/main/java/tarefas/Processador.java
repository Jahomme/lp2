package tarefas;

import anotacoes.Acao;
import anotacoes.Processar;

import java.lang.reflect.Method;



public class Processador<T> {

    public <E> void logGenerico(E item) {
        System.out.println("[LOG GENÉRICO]: Processando item -> " + item);
    }

    public void executar(Iterable<T> dados) {
        try {
            // 1. Instanciar a classe que tem as ações

            Operacoes operacoes = new Operacoes();
            Class<?> clazz = operacoes.getClass();

            // 2. Verificar se a classe tem a anotação @Processar
            if (!clazz.isAnnotationPresent(Processar.class)) {
                System.out.println("A classe não está marcada para processamento.");
                return;
            }

            // 3. Loop Externo: Percorre os dados (números)
            for (T item : dados) {
                System.out.println("===================== PROCESSAMENTO DO ITEM [" + item + "] DA LISTA =====================");
                logGenerico(item);

                // 4. Loop Interno: Percorre os MÉTODOS da classe
                for (Method metodo : clazz.getDeclaredMethods()) {

                    if (metodo.isAnnotationPresent(Acao.class)) {
                        metodo.invoke(operacoes, item);
                    }
                }

                System.out.println("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}