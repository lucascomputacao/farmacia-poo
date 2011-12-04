/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import java.util.*;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class Farmacia {

    private static ArrayList<Item> listaItens = new ArrayList<Item>();

    //cadastrar medicamento
    public static void cadastraMedicamento() {
//    int codigo, int lote, float preco, String nome, String tarja, String dataVencimento, String principioAtivo, boolean generico
        Scanner read = new Scanner(System.in);
        String nome, principioAtivo, dataVencimento, tarja = "n", gen, posologia, lote, opcao = "";
        ArrayList<Medicamentos> listLocal = new ArrayList<Medicamentos>();
        int intTarja, codIni = 0, ini = 0, crm = 0, quantidade = 0;
        float preco;
        boolean generico = false;
        do {
            System.out.println("============== CADASTRO DE MEDICAMENTOS =============");
            System.out.println("Digite a quantidade de medicamentos");
            quantidade = read.nextInt();
            read.nextLine();
            System.out.println("Digite o nome do remédio:");
            nome = read.nextLine();
            System.out.println("Digite a validade: [mm/aaaa] mes/ano");
            dataVencimento = read.nextLine();
            System.out.println("Digite o principio ativo da medicação:");
            principioAtivo = read.nextLine();
            do {
                System.out.println("Escolha a tarja:\n" + "S. Sem tarja (medicamento vendido sem prescrição médica)\n" + "V. Tarja VERMELHA (vendido com receita impressa em papel branco)\n" + "P. Tarja PRETA(vendido com receita impressa em papel azul)");
                tarja = read.nextLine();
                tarja = tarja.toUpperCase();
            } while (!(tarja.equalsIgnoreCase("s") || tarja.equalsIgnoreCase("v") || tarja.equalsIgnoreCase("p")));
            System.out.println("Medicamento Generico? [S]im ou [N]ao\n" + "'S' para sim e 'N' para não... ");
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
                    + "*Use PONTO pra divisão dos centavos*");
            preco = read.nextFloat();
            read.nextLine();
            //cria objeto medicamentonormal ou controlado
            if ((tarja.equalsIgnoreCase("v") || tarja.equalsIgnoreCase("p"))) {

                if (posologia.equalsIgnoreCase("")) {
                    Medicamentos remedio = new MedicamentoControlado(
                            crm, tarja, dataVencimento, principioAtivo, generico, codIni, lote, preco, lote, nome);
                    System.out.println("Novo medicamento cadastrado:");
                    for (int i = 0; i < quantidade; i++) {
                        listaItens.add(remedio);
                        listLocal.add(remedio);
                        remedio.imprimeInfo();
                    }
                    //insereMedDB(remedio);

                } else {
                    Medicamentos remedio = new MedicamentoControlado(
                            crm, tarja, dataVencimento, principioAtivo, posologia, generico, codIni, lote, preco, lote, nome);
                    System.out.println("Novo medicamento cadastrado:");
                    for (int i = 0; i < quantidade; i++) {
                        listaItens.add(remedio);
                        listLocal.add(remedio);
                        remedio.imprimeInfo();
                    }//insereMedDB(remedio);
                }
            } else {
                if (posologia.equalsIgnoreCase("")) {
                    Medicamentos remedio = new MedicamentoNormal(
                            tarja, dataVencimento, principioAtivo, generico, codIni, lote, preco, lote, nome);
                    System.out.println("Novo medicamento cadastrado:");
                    for (int i = 0; i < quantidade; i++) {
                        listaItens.add(remedio);
                        listLocal.add(remedio);
                        remedio.imprimeInfo();
                    }
                } else {
                    Medicamentos remedio = new MedicamentoNormal(
                            tarja, dataVencimento, principioAtivo, posologia, generico, codIni, lote, preco, lote, nome);
                    System.out.println("Novo medicamento cadastrado:");
                    for (int i = 0; i < quantidade; i++) {
                        listaItens.add(remedio);
                        listLocal.add(remedio);
                        remedio.imprimeInfo();
                    }
                }
            }
            System.out.println("Deseja cadastrar outro item? [S]im ou [N]ão");
            opcao = read.nextLine();

        } while (opcao.equalsIgnoreCase("s"));
        //imprime os itens cadastrados
        System.out.println("\nMedicamentos cadastrados:\n");
        for (int i = 0, itensPag = 1; i < listLocal.size(); i++, itensPag++) {
            listLocal.get(i).imprimeInfo();
            if (i < listLocal.size() && itensPag > 3) {
                System.out.println("\nPRESSIONE ENTER PARA VISUALIZAR ITENS RESTANTES");
                read.nextLine();
                itensPag = 0;
            }
        }
        System.out.println("\nPRESSIONE ENTER PARA RETORNAR AO MENU");
        read.nextLine();
    }

    public static void cadastraPerfumaria() {
        String opcao = "", nome, validade, fragrancia, unidade, lote;
        float preco;
        ArrayList<Perfumaria> listaLocal = new ArrayList<Perfumaria>();

        Scanner read = new Scanner(System.in);

        do {
            System.out.println("================== CADASTRO DE PERFUMARIA ===============");
            System.out.println("| Digite o nome :                                       |");
            nome = read.nextLine();
            System.out.println("| Digite a fragrancia:                                  |");
            fragrancia = read.nextLine();
            System.out.println("| Digite a unidade [caixa, quantidade de mls]           |");
            unidade = read.nextLine();
            System.out.println("| Digite a validade: [mm/aaaa] mes/ano                  |");
            validade = read.nextLine();
            System.out.println("| Digite o lote:                                        |");
            lote = read.nextLine();
            System.out.println("| Digite o preco:\t[Use PONTO para separar os centavos] |");
            preco = read.nextFloat();
            read.nextLine();
            System.out.println("================== CADASTRO DE PERFUMARIA ===============");
            Perfumaria itemPerf = new Perfumaria(lote, preco, validade, nome, fragrancia, unidade);
            System.out.println("|  Novo Item cadastrado:                                 |");
            itemPerf.imprimeInfo();
            listaItens.add(itemPerf);//lista de itens
            listaLocal.add(itemPerf);//lista local
            System.out.println("Deseja cadastrar outro item? [S]im ou [N]ão");
            opcao = read.nextLine();
        } while (opcao.equalsIgnoreCase("s"));
        //imprime os itens cadastrados
        System.out.println("\nItens de Perfumaria cadastrados:\n");

        for (int i = 0, itensPag = 1; i < listaLocal.size(); i++, itensPag++) {
            listaLocal.get(i).imprimeInfo();
            if (i < listaLocal.size() && itensPag > 3) {
                System.out.println("\nPRESSIONE ENTER PARA VISUALIZAR ITENS RESTANTES");
                read.nextLine();
                itensPag = 0;
            }
        }
        System.out.println("\nNAO EXISTEM MAIS ITENS A SEREM LISTADOS\nPRESSIONE ENTER PARA RETORNAR AO MENU");
        read.nextLine();
    }

    //POLIMORFISMO NO MÉTODO
    public static void imprimeListaItens() {
        Scanner read = new Scanner(System.in);

        System.out.println("Lista de Itens cadastrados:");
        for (int i = 0, itensPag = 1, maxItens = 0; i < listaItens.size(); i++, itensPag++, maxItens++) {
            if (listaItens.get(i) instanceof Medicamentos) {
                System.out.println("Medicamento:");
            }
            if (listaItens.get(i) instanceof Perfumaria) {
                System.out.println("Perfumaria:");
            }
            listaItens.get(i).imprimeInfo();
            System.out.println("\n");
            if (maxItens != listaItens.size() && itensPag == 3) {
                System.out.println("\nPRESSIONE ENTER PARA VISUALIZAR ITENS RESTANTES");
                read.nextLine();
                itensPag = 0;
            }
        }
        System.out.println("Total de Itens: " + listaItens.size());
        System.out.println("\nNAO EXISTEM MAIS ITENS A SEREM LISTADOS\nPRESSIONE ENTER PARA RETORNAR AO MENU");
        read.nextLine();
    }

    /**
     * Recebe um objeto Item e insere no banco de dados
     * @param remedio 
     */
    public static void insereMedDB(Medicamentos remedio) {
        String lote, nome, principioAtivo, posologia, generico, tarja, validade;
        float preco;
        int codigo;

        codigo = remedio.getCodMed();
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
        if (conection.conectado()) {
            System.out.println("Conectado com o banco de dados \\o/");
            String sql = "INSERT INTO TB_MEDICAMENTOS (codigo, nome, lote,preco, validade, tarja, priAtivo, posologia, generico) VALUES(" + codigo + "," + nome + "," + preco + "," + validade + "," + tarja + "," + principioAtivo + "," + posologia + "," + generico + ")";
            //conection.atualizar(sql);
        }

    }

    public static void pesquisarItem() {
        int opcao = -1, codigo;
        String nome = null, menu = null;
        Scanner read = new Scanner(System.in);

        do {
            System.out.println("============= PESQUISAR PRODUTOS ================ ");
            System.out.println("| 1. Pesquisa por codigo                        |");
            System.out.println("| 2. Pesquisa por nome                          |");
            System.out.println("============= PESQUISAR PRODUTOS ================ ");
            opcao = read.nextInt();
            read.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o codigo do produto que deseja pesquisar");
                    codigo = read.nextInt();
                    read.nextLine();
                    buscaItemCodigo(codigo);
                    break;
                case 2:
                    System.out.println("Digite o nome do produto que deseja pesquisar");
                    nome = read.nextLine();
                    buscaItemNome(nome);
                    break;
            }
            System.out.println("Nova Busca?\n[S]im ou [N]ao?");
            menu = read.nextLine();
        } while (menu.equalsIgnoreCase("s"));
    }

    public static void buscaItemCodigo(int codigo) {
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i).getCodigo() == codigo) {
                listaItens.get(i).imprimeInfo();
            }
            if (i == listaItens.size()) {
                System.out.println("Item de codigo " + codigo + " nao encontrado");
            }
        }
    }

    public static void buscaItemNome(String nome) {
        Scanner read = new Scanner(System.in);
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i).getNome().equalsIgnoreCase(nome)) {
                listaItens.get(i).imprimeInfo();
            }
            if (i == listaItens.size()) {
                System.out.println("Item " + nome + " nao encontrado");
            }
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
            System.out.println("============= FARMACIA DO POLVO PAUL ================ ");
            System.out.println("| Escolha uma das operações abaixo ou 0 para sair...|");
            System.out.println(" ---------------------------------------------------");
            System.out.println("| 1. Cadastrar Medicamento                          |");
            System.out.println("| 2. Cadastrar Perfumaria                           |");
            System.out.println("| 3. Listar Itens cadastrados                       |");
            System.out.println("| 4. Pesquisar Item                                 |");
            System.out.println("| 0. SAIR DO SISTEMA                                |");
            System.out.println("============= FARMACIA DO POLVO PAUL ================ ");
            menu = sc.nextInt();
            switch (menu) {
                case 0:
                    System.out.println("Bye, see you later...\nSaindo do Sistema...");
                    break;
                case 1:
                    cadastraMedicamento();
                    break;
                case 2:
                    cadastraPerfumaria();
                    break;
                case 3:
                    imprimeListaItens();
                    break;
                case 4:
                    pesquisarItem();
                    break;
                default:
                    System.out.println("Digite número válido ou 0 pra sair...");
            }
        } while (menu != 0);
    }
}
