/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import java.util.Scanner;

/**
 *
 * @author lucas
 */
public class Farmacia {

    public static void cadatraMedicamento() {
//          private int codigo, lote;
//    private float preco;
//    //tarja = sem tarja [venda livre], amarela [genáricos], vermelha [com receita em papel branco] e preta [com receita em papel azul]
//    private String nome, tarja, dataVencimento, principioAtivo;
//    private boolean generico;
//    int codigo, int lote, float preco, String nome, String tarja, String dataVencimento, String principioAtivo, boolean generico
        Scanner read = new Scanner(System.in);
        String nome, principioAtivo, dataVencimento;
        int lote, tarja;
        float preco;

        System.out.println("============== CADASTRO DE MEDICAMENTOS =============");
        System.out.println("Digite o nome do remédio:");
        nome = read.nextLine();
        System.out.println("Digite a data de vencimento:");
        dataVencimento = read.nextLine();
        System.out.println("Digite o principio ativo da medicação:");
        principioAtivo = read.nextLine();
        System.out.println("Digite o preço unitário:");
        preco = read.nextFloat();
        System.out.println("Digite o lote:");
        lote = read.nextInt();
        System.out.println("Escolha a tarja:\n"
                + "0. Sem tarja (medicamento vendido sem prescrição médica)\n"
                + "1. Tarja VERMELHA (vendido com receita impressa em papel branco)\n"
                + "2. Tarja PRETA(vendido com receita impressa em papel azul)");
        tarja = read.nextInt();
        switch (tarja) {
            case 0:

                break;
            case 1:
                break;
            case 2:
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int menu = -1;
        Scanner sc = new Scanner(System.in);
        //MENU
        do {
            System.out.println("================= FARMACIA DO POLVO ================= ");
            System.out.println("| Escolha uma das operações abaixo ou 0 para sair...|" + "\n"
                    + " ---------------------------------------------------");
            System.out.println("| 1. Cadastrar Medicamento                          |" + "\n"
                    + "| 0. SAIR DO SISTEMA                                |");
            System.out.println("================= FARMACIA DO POLVO ================= ");
            menu = sc.nextInt();
            switch (menu) {
                case 0:
                    System.out.println("Bye =]\nSaindo do Sistema...");
                    break;
                case 1:
                    cadatraMedicamento();
                    break;
                default:
                    System.out.println("Digite número entre 1-8 ou 0 pra sair...");
            }
        } while (menu != 0);
    }
}
