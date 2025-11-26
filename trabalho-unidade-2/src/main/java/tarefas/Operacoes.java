package tarefas;

import anotacoes.Acao;
import anotacoes.Processar;

@Processar
public class Operacoes {
    @Acao
    public void dobrar(int x){
        int dobro = x * 2;
        System.out.println("[DOBRAR]: Dobro de " + x + " = " + dobro);
    }

    @Acao
    public void parOuImpar(int x){
        if(x % 2 == 0){
            System.out.println("[PAR/ÍMPAR]: O número " + x + " é par");
        } else {
            System.out.println("[PAR/ÍMPAR]: O número " + x + " é ímpar");
        }
    }

    @Acao
    public void imprimir(int x) {
        System.out.println("[IMPRIMIR]: Item processado: " + x);
    }

    // Método será ignorado
    public void dividir(int x) {
        double resultado = x / 2;
        System.out.println("[DIVIDIR]: Item dividido por 2: " + resultado);
    }
    
}
