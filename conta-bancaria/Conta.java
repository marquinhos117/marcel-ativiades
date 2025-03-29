package ContaBancaria;
import java.util.Scanner;

public class Conta{

        String titular;
        String cpf;
        String conta;
        String agencia;
        double saldo;

        public Conta(String titular, String cpf, String conta, String agencia, double saldo){
            this.titular = titular;
            this.cpf = cpf;
            this.conta = conta;
            this.saldo = saldo;
            this.agencia = agencia;
        }

        public void dados(){
            System.out.println("Titular: " + titular);
            System.out.println("CPF: " + cpf);
            System.out.println("conta: " + conta);
            System.out.println("agencia: " + agencia);
            System.out.println("saldo: " + saldo);
        }

        public void depositar( double valor){
            saldo = saldo + valor;
            System.out.println(valor + "depositado com sucesso.");
        }

        public void sacar(double valor){
            if(saldo >= 0 && saldo >= valor){
                saldo = saldo - valor;
                System.out.println("Saque de " + valor + "realizado");
            }else{
                System.out.println("Saldo insuficiente");
            }
        }

        public void transferir(Conta destino, double valor, String titular){
            if(saldo >= 0 && saldo >= valor){
                saldo = saldo -valor;
                destino.saldo = destino.saldo + valor;
                System.out.println(valor + "transferencia realizada para" + titular);
            }else{
                System.out.println("Saldo insuficiente");
            }
        }
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Conta conta01 =  new Conta ("Marcel da Silva Melo", "089.112.116-00", "00001", "01", 2000);
            Conta conta02 = new Conta ("Marcos Eduardo Graciano Paula", "710.315.061-00", "0002", "01", 2000);


            int operacao, selecionada;
            Conta contaSelecionada;
            do{

            System.out.print("Selecione uma conta:\n1 - Marcel\n2 - Marcos\nDigite a opção:");
            selecionada = scanner.nextInt();

            if (selecionada == 1) {
                contaSelecionada = conta01;
                conta01.dados();
            } else {
                contaSelecionada = conta02;
                conta02.dados();
            }

            System.out.println("========================");
            System.out.print("\nEscolha uma operação:\n1 - Sacar\n2 - Depositar\n3 - Transferir\n4 - Mostrar conta\n5 - Mostrar todas as contas\n6 - sair\nDigite a opção:");
            operacao = scanner.nextInt();

            switch (operacao) {
                case 1:
                System.out.println("Valo a ser sacado: ");
                double saque = scanner.nextDouble();
                contaSelecionada.sacar(saque);
                    break;

                case 2:
                System.out.println("Valor a ser depositado: ");
                double deposito = scanner.nextDouble();
                contaSelecionada.depositar(deposito);
                    break;

                case 3:
                System.out.println("Valor a ser transferido para ");
                if(contaSelecionada == conta01){
                    System.out.println("Marcos");
                }else{
                    System.out.println("Marcel");
                } // coloquei assim pq são só duas contas, caso fosse diferente a lógica seria para inserir a conta ora transferir
                double transferencia = scanner.nextDouble();
                if (contaSelecionada == conta01) {
                    contaSelecionada.transferir(conta02, transferencia, "Marcos");
                } else {
                    contaSelecionada.transferir(conta01, transferencia, "Marcel");
                }
                    break;

                case 4:
                System.out.println("Mostrar conta atual");
                contaSelecionada.dados();
                    break;

                case 5:
                System.out.println("Mostrar todas as contas");
                conta01.dados();
                System.out.println("\n");
                conta02.dados();
                    break;

                case 6:
                break;

                default:
                System.out.println("Digite uma operação correta");
                    break;
            }





           }while (operacao != 6);
           scanner.close();
        }
}