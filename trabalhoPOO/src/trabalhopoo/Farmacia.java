/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopoo;

/**
 *
 * @author lucas
 */
public class Farmacia {

    public static void menuPrincipal() {
        System.out.println("=============== FARMÁCIA DO POLVO ================");
        System.out.println("1. Cadastrar medicamentos");
        System.out.println("[S]AIR -- TECLE S");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String opcao = "n";
        do {
            menuPrincipal();
        } while (!opcao.equalsIgnoreCase("s"));
        
    }
}
