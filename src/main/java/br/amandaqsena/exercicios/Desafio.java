package br.amandaqsena.exercicios;

import java.util.Scanner;
import java.util.stream.Stream;

public class Desafio {
    public static void main(String[] args) {
        String nome = "Clark Kent";
        String tipoConta = "Corrente";
        double saldo = 1599.99;
        int opcao = 0;

        System.out.println("***********************");
        System.out.println("\nNome do cliente: " + nome);
        System.out.println("Tipo conta: " + tipoConta);
        System.out.println("Saldo atual: " + saldo);
        System.out.println("\n***********************");

        try (Scanner leitura = new Scanner(System.in)) {
            String menu = """
                    ** Digite sua opção **
                    1 - Consultar saldo
                    2 - Transferir valor
                    3 - Receber valor 
                    4 - Sair

                    """;

            while (opcao != 4) {
                System.out.println(menu);
                opcao = leitura.nextInt();
                
                switch(Operacoes.fromCodigo(opcao)){
                    case CONSULTAR_SALDO: {
                        System.out.println("O saldo atualizado é " + saldo);
                        
                        }
                        break;
                    case TRANSFERIR_VALOR: {
                        System.out.println("Qual o valor que deseja transferir?");
                        double valor = leitura.nextDouble();
                        if (valor > saldo) {
                            System.out.println("Não há saldo para realizar a transferência.");
                        } else {
                            saldo -= valor;
                            System.out.println("Novo saldo: " + saldo);
                        }
                        
                        }
                        break;
                    case RECEBER_VALOR:{
                        System.out.println("Valor recebido: ");
                        double valor = leitura.nextDouble();
                        saldo += valor;
                        System.out.println("Novo saldo: " + saldo);
                        
                        }
                        break;
                    case SAIR:
                        break;
                    case INVALIDA:{
                        System.out.println("Opção inválida!");
                        break;
                    }
                        
                }
                
            }
        }
    }
    public enum Operacoes{
        CONSULTAR_SALDO(1), TRANSFERIR_VALOR(2), RECEBER_VALOR(3),SAIR(4),INVALIDA(-1);
    
        private int codigo;
    
        Operacoes(int codigo){
            this.codigo = codigo;
        }

        public static Operacoes fromCodigo(Integer x) {

            return Stream.of(Operacoes.values())
                    .filter((it) -> it.codigo == x)
                    .findFirst().orElse(Operacoes.INVALIDA);
    
        }
    }
}




