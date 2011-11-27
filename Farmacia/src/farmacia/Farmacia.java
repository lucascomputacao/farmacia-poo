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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int menu = -1;
        Scanner sc = new Scanner(System.in);
        //MENU
        do {
            System.out.println("===================== FARMACIA DO POLVO ====================== ");
            System.out.println("| Escolha uma das operações abaixo ou 0 para sair...|" + "\n"
                    + " ---------------------------------------------------");
            System.out.println("| 1. Cadastrar Novo Cliente                         |" + "\n"                   
                    + "| 0. SAIR DO SISTEMA                                |");
            System.out.println("===================== LOCADORA ====================== ");
            menu = sc.nextInt();
            switch (menu) {
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Digite número entre 1-8 ou 0 pra sair...");
            }
        } while (menu != 0);
    }
}
