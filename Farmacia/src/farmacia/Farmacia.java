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
        int menu = -1, codigoCliente, codigoFilme, devCodFilme;
        Scanner sc = new Scanner(System.in);
        //MENU
        do {
            System.out.println("===================== LOCADORA ====================== ");
            System.out.println("| Escolha uma das operações abaixo ou 0 para sair...|" + "\n"
                    + " ---------------------------------------------------");
            System.out.println("| 1. Cadastrar Novo Cliente                         |" + "\n"
                    + "| 2. Cadastrar novo Filme                           |" + "\n"
                    + "| 3. Empréstimo de Filme                            |" + "\n"
                    + "| 4. Devolução de Filme                             |" + "\n"
                    + "| 5. Listar os filmes da locadora                   |" + "\n"
                    + "| 6. Listar filmes por classificação                |" + "\n"
                    + "| 7. Consulta Cliente                               |" + "\n"
                    + "| 8. Consulta Filme                                 |" + "\n"
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
