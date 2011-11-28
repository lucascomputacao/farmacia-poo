/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class Farmacia {

    public static void cadastraMedicamento() {
//    int codigo, int lote, float preco, String nome, String tarja, String dataVencimento, String principioAtivo, boolean generico
        Scanner read = new Scanner(System.in);
        String nome, principioAtivo, dataVencimento, tarja = "n", gen, posologia, lote;
        int intTarja;
        float preco;
        boolean generico = false;

        System.out.println("============== CADASTRO DE MEDICAMENTOS =============");
        System.out.println("Digite o nome do remédio:");
        nome = read.nextLine();
        System.out.println("Digite a validade: [mm/aaaa] mes/ano");
        dataVencimento = read.nextLine();
        System.out.println("Digite o principio ativo da medicação:");
        principioAtivo = read.nextLine();
        do {
            System.out.println("Escolha a tarja:\n"
                    + "S. Sem tarja (medicamento vendido sem prescrição médica)\n"
                    + "V. Tarja VERMELHA (vendido com receita impressa em papel branco)\n"
                    + "P. Tarja PRETA(vendido com receita impressa em papel azul)");
            tarja = read.nextLine();
            tarja = tarja.toUpperCase();

        } while (!(tarja.equalsIgnoreCase("s") || tarja.equalsIgnoreCase("v") || tarja.equalsIgnoreCase("p")));
        System.out.println("Medicamento Generico? [S]im ou [N]ao\n"
                + "'S' para sim e 'N' para não... ");
        gen = read.nextLine();
        System.out.println("[Opcional] Digite a posologia:");
        posologia = read.nextLine();
        if (gen.equalsIgnoreCase("s")) {
            generico = true;
        }
        if (gen.equalsIgnoreCase("n")) {
            generico = false;
        }
        System.out.println("Digite o lote:");
        lote = read.nextLine();
        System.out.println("Digite o preço unitário:\n"
                + "*Use pontos pra divisão dos centavos*");
        preco = read.nextFloat();
        //cria objeto medicamentonormal ou controlado
        if ((tarja.equalsIgnoreCase("v") || tarja.equalsIgnoreCase("p"))) {
            if (posologia.equalsIgnoreCase("")) {
                Medicamentos remedio = new MedicamentoControlado(tarja, dataVencimento, principioAtivo, generico, lote, preco, lote, nome);
                System.out.println("Novo medicamento cadastrado:");
                remedio.imprimeInfo();
                insereMedDB(remedio);
            } else {
                Medicamentos remedio = new MedicamentoControlado(tarja, dataVencimento, principioAtivo, posologia, generico, lote, preco, lote, nome);
                System.out.println("Novo medicamento cadastrado:");
                remedio.imprimeInfo();
                insereMedDB(remedio);
            }
        } else {
            if (posologia.equalsIgnoreCase("")) {
                Medicamentos remedio = new MedicamentoNormal(tarja, dataVencimento, principioAtivo, generico, lote, preco, lote, nome);
                System.out.println("Novo medicamento cadastrado:");
                remedio.imprimeInfo();
                insereMedDB(remedio);
            } else {
                Medicamentos remedio = new MedicamentoNormal(tarja, dataVencimento, principioAtivo, posologia, generico, lote, preco, lote, nome);
                System.out.println("Novo medicamento cadastrado:");
                remedio.imprimeInfo();
                insereMedDB(remedio);
            }
        }
    }

    /**
     * Recebe um objeto Item e insere no banco de dados
     * @param remedio 
     */
    public static void insereMedDB(Medicamentos remedio) {
        String lote, nome, principioAtivo, posologia, generico, tarja, validade;
        float preco;
        int codigo;

        codigo = Item.getCodigo();
        lote = remedio.getLote();
        nome = remedio.getNome();
        principioAtivo = remedio.getPrincipioAtivo();
        posologia = remedio.getPosologia();
        if (remedio.isGenerico()) {
            generico = "S";
        } else {
            generico = "N";
        }
        tarja = remedio.getTarja();
        validade = remedio.getDataVencimento();
        preco = remedio.getPreco();
        System.out.println("Salvando...");
        ConexaoMySQL conection = new ConexaoMySQL();     
        if (conection.conectado()){
            System.out.println("Conectado com o banco de dados \\o/");
            String sql = "INSERTE INTO ...";
            //conection.atualizar(sql);
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
                    cadastraMedicamento();
                    break;
                default:
                    System.out.println("Digite número válido ou 0 pra sair...");
            }
        } while (menu != 0);
    }
}
