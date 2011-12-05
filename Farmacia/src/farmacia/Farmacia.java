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

    //===================== CADASTROS ======================
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
                    //se > 0 foi encontrado objeto igual na lista de itens
                    if (buscaCadastro(remedio) > 0) {
                        remedio.setCodMed(buscaCadastro(remedio));
                    }
                    for (int i = 0; i < quantidade; i++) {
                        listaItens.add(remedio);
                        listLocal.add(remedio);
                        //remedio.imprimeInfo();
                    }
                    System.out.println(quantidade + " medicamento(s) cadastrado(s) com sucesso!");
                    remedio.imprimeInfo();
                    //insereMedDB(remedio);
                } else {
                    Medicamentos remedio = new MedicamentoControlado(
                            crm, tarja, dataVencimento, principioAtivo, posologia, generico, codIni, lote, preco, lote, nome);
                    ///se > 0 foi encontrado objeto igual na lista de itens
                    if (buscaCadastro(remedio) > 0) {
                        remedio.setCodMed(buscaCadastro(remedio));
                    }
                    for (int i = 0; i < quantidade; i++) {
                        listaItens.add(remedio);
                        listLocal.add(remedio);
                        remedio.imprimeInfo();
                    }//insereMedDB(remedio);
                    System.out.println(quantidade + " medicamento(s) cadastrado(s) com sucesso!");
                }
            } else {
                if (posologia.equalsIgnoreCase("")) {
                    Medicamentos remedio = new MedicamentoNormal(
                            tarja, dataVencimento, principioAtivo, generico, codIni, lote, preco, lote, nome);
                    //se > 0 foi encontrado objeto igual na lista de itens
                    if (buscaCadastro(remedio) > 0) {
                        remedio.setCodMed(buscaCadastro(remedio));
                    }
                    for (int i = 0; i < quantidade; i++) {
                        listaItens.add(remedio);
                        listLocal.add(remedio);
                    }
                    System.out.println(quantidade + " medicamento(s) cadastrado(s) com sucesso!");
                    remedio.imprimeInfo();
                } else {
                    Medicamentos remedio = new MedicamentoNormal(
                            tarja, dataVencimento, principioAtivo, posologia, generico, codIni, lote, preco, lote, nome);
                    //se > 0 foi encontrado objeto igual na lista de itens
                    if (buscaCadastro(remedio) > 0) {
                        remedio.setCodMed(buscaCadastro(remedio));
                    }
                    for (int i = 0; i < quantidade; i++) {
                        listaItens.add(remedio);
                        listLocal.add(remedio);
                    }
                    System.out.println(quantidade + " medicamento(s) cadastrado(s) com sucesso!");
                    remedio.imprimeInfo();
                }
            }
            System.out.println("\nDeseja cadastrar outro item? [S]im ou [N]ão");
            opcao = read.nextLine();

        } while (opcao.equalsIgnoreCase("s"));
    }

    public static void cadastraPerfumaria() {
        String opcao = "", nome, validade, fragrancia, unidade, lote;
        float preco;
        ArrayList<Perfumaria> listaLocal = new ArrayList<Perfumaria>();
        Perfumaria itemPerf = null;
        Scanner read = new Scanner(System.in);

        do {
            System.out.println("================== CADASTRO DE PERFUMARIA ===============");
            System.out.println("| Digite a quantidade do item que deseja cadastrar      |");
            int qtd = read.nextInt();
            read.nextLine();
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
            itemPerf = new Perfumaria(lote, preco, validade, nome, fragrancia, unidade);
            //se > 0 foi encontrado objeto igual na lista de itens
            if (buscaCadastro(itemPerf) > 0) {
                itemPerf.setCodPerf(buscaCadastro(itemPerf));
            }
            for (int i = 0; i < qtd; i++) {
                listaItens.add(itemPerf);//lista de itens
                listaLocal.add(itemPerf);//lista local
            }
            System.out.println(qtd + " novos Itens cadastrados! ");
            itemPerf.imprimeInfo();
            System.out.println("\nDeseja cadastrar outro item? [S]im ou [N]ão");
            opcao = read.nextLine();
        } while (opcao.equalsIgnoreCase("s"));
    }
    //===================== CADASTROS ======================

    //MÉTODO POLIMÓRFICO PARA IMPRESSAO DE INFORMACOES DOS ITENS
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
            if (itensPag > 3 && listaItens.size() - 1 > 3) {
                System.out.println("\nPRESSIONE ENTER PARA VISUALIZAR ITENS RESTANTES");
                read.nextLine();
                itensPag = 0;
            }
        }
        System.out.println("Total de Itens: " + listaItens.size());
        System.out.println("\nPRESSIONE ENTER PARA RETORNAR AO MENU");
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

    //===============  MENUS =====================
    public static void menuPesquisarItem() {
        int opcao = -1, codigo;
        String nome = null, menu = null;
        Scanner read = new Scanner(System.in);

        do {
            System.out.println("============= PESQUISAR PRODUTOS ================ ");
            System.out.println("| 1. Pesquisa por Codigo                        |");
            System.out.println("| 2. Pesquisa por Nome                          |");
            System.out.println("| 3. Pesquisa Medicamento                       |");
            System.out.println("| 4. Pesquisa Perfumaria                        |");
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
                case 3:
                    menuBuscaMedicamentos();
                    break;
                case 4:
                    menuPesquisarPerfumaria();
                    break;
            }
            System.out.println("\nNova Busca por produtos?\n[S]im ou [N]ao?");
            menu = read.nextLine();
        } while (menu.equalsIgnoreCase("s"));
    }

    public static void menuPesquisarPerfumaria() {
        int opcao = -1, saida = 0;
        String menu = null;
        Scanner read = new Scanner(System.in);
        do {
            System.out.println("============= PESQUISAR PERFUMARIA ================ ");
            System.out.println("| 1. Pesquisa por Codigo                          |");
            System.out.println("| 2. Pesquisa por Nome                            |");
            System.out.println("| 3. Pesquisa por Fragrancia                      |");
            System.out.println(" -------------------------------------------------");
            System.out.println("| 0. SAIR DO MENU PERFUMARIA                      |");
            System.out.println(" -------------------------------------------------");
            System.out.println("============= PESQUISAR PERFUMARIA ================ ");
            opcao = read.nextInt();
            read.nextLine();
            switch (opcao) {
                case 0://condicao de saida do menu
                    saida = 1;
                    menu = "n";
                    break;
                case 1:
                    System.out.println("Digite o codigo do item de perfumaria que deseja pesquisar");
                    int codPerf = read.nextInt();
                    read.nextLine();
                    int qtdPerCod = buscaPerfumariaCod(codPerf);
                    if (qtdPerCod > 0) {
                        System.out.println(qtdPerCod + "itens encontrados");
                    } else {
                        System.out.println("Nao existem itens de perfumaria como codigo " + codPerf);
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do item de perfumaria que deseja pesquisar");
                    String nomePerf = read.nextLine();
                    int qtdPerfNome = buscaPerfumariaNome(nomePerf);
                    if (qtdPerfNome > 0) {
                        System.out.println(qtdPerfNome + " itens " + nomePerf + " encontrados");
                    } else {
                        System.out.println("Nao foram encontrados itens com o nome " + nomePerf);
                    }
                    break;
                case 3:
                    System.out.println("Digite a fragrancia que deseja pesquisar");
                    String fragrancia = read.nextLine();
                    int qtdFrag = buscaPerfumariaFrag(fragrancia);
                    if (qtdFrag > 0) {
                        System.out.println(qtdFrag + " iten encontrados com a fragrancia " + fragrancia);
                    } else {
                        System.out.println("Nao foram encontrados itens com a fragrancia " + fragrancia);
                    }
                    break;
            }//end of switch
            if (saida == 0) {
                System.out.println("\nPesquisar novo item de perfumaria?\n[S]im ou [N]ao");
                menu = read.nextLine();
            }
        } while (menu.equalsIgnoreCase("s"));
    }

    public static void menuBuscaMedicamentos() {
        int opcao = -1, saida = 0;
        String menu = null;
        Scanner read = new Scanner(System.in);
        do {
            System.out.println("============= PESQUISAR MEDICAMENTOS ================ ");
            System.out.println("| 1. Pesquisa por Nome                              |");
            System.out.println("| 2. Pesquisa por Principio Ativo                   |");
            System.out.println("| 3. Pesquisa por Genericos                         |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("| 0. SAIR DO MENU MEDICAMENTOS                      |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("============= PESQUISAR MEDICAMENTOS ================ ");
            opcao = read.nextInt();
            read.nextLine();
            switch (opcao) {
                case 0:
                    saida = 1;
                    menu = "n";
                    break;
                case 1:
                    System.out.println("Digite o nome do medicamento");
                    String nome = read.nextLine();
                    int qtdNome = buscaItemNome(nome);
                    if (qtdNome > 0) {
                        System.out.println(qtdNome + " ocorrencias do nome" + nome);
                    } else {
                        System.out.println("Busca por " + nome + "nao obteve resultados");
                    }
                    break;
                case 2:
                    System.out.println("Digite o principio Ativo que deseja pesquisar");
                    String priAtivo = read.nextLine();
                    int qtdPri = buscaPriAtivo(priAtivo);
                    if (qtdPri > 0) {
                        System.out.println(qtdPri + " ocorrencias do principio ativo " + priAtivo);
                    } else {
                        System.out.println("Busca por " + priAtivo + " nao obteve resultados");
                    }
                    break;
                case 3:
                    menuGenericos();
                    break;
            }
            if (saida == 0) {
                System.out.println("Pesquisar novo medicamento?\n[S]im ou [N]ao");
                menu = read.nextLine();
            }

        } while (menu.equalsIgnoreCase("s"));
    }

    public static void menuGenericos() {
        int opcao = -1, saida = 0;
        String menu = null;
        Scanner read = new Scanner(System.in);
        do {
            System.out.println("============== PESQUISAR GENERICOS ================== ");
            System.out.println("| 1. Pesquisa por Codigo                            |");
            System.out.println("| 2. Pesquisa por Nome                              |");
            System.out.println("| 3. Pesquisa por Principio Ativo                   |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("| 0. SAIR DO MENU GENERICOS                         |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("============== PESQUISAR GENERICOS ================== ");
            opcao = read.nextInt();
            read.nextLine();
            switch (opcao) {
                case 0:
                    saida = 1;
                    menu = "n";
                    break;
                case 1:
                    System.out.println("Digite o codigo do generico que deseja pesquisar");
                    int codGen = read.nextInt();
                    read.nextLine();
                    int qtdCodGen = buscaGenCod(codGen);
                    if (qtdCodGen > 0) {
                        System.out.println(qtdCodGen + " generico(s) com o codigo " + codGen);
                    } else {
                        System.out.println("Nao foi encontrado codigo " + codGen + " na busca por genericos");
                    }
                    break;
                case 2:
                    System.out.println("Digite o nome do generico");
                    String nome = read.nextLine();
                    int qtdGen = buscaGenNome(nome);
                    if (qtdGen > 0) {
                        System.out.println(qtdGen + " Generico(s) encontrados");
                    } else {
                        System.out.println("Nao foi encontrado " + nome + " na busca por genericos");
                    }
                    break;
                case 3:
                    System.out.println("Digite o principio Ativo que deseja pesquisar");
                    String priAtivo = read.nextLine();
                    int qtdPriAtiv = buscaGenPriAtivo(priAtivo);
                    if (qtdPriAtiv > 0) {
                        System.out.println(qtdPriAtiv + " generico(s) encontrados");
                    } else {
                        System.out.println("Nao foi encontrado principio ativo " + priAtivo + " na busca por genericos");
                    }
                    break;

            }
            if (saida == 0) {//so mostra se n for setado 0 pra sair do menu
                System.out.println("Pesquisar novo medicamento Generico?\n[S]im ou [N]ao");
                menu = read.nextLine();
            }
        } while (menu.equalsIgnoreCase("s"));
    }

    public static void menuExcluir() {
        int opcao = -1, saida = 0;
        String menu = null;
        Scanner read = new Scanner(System.in);
        do {
            System.out.println("===================== EXCLUIR ======================= ");
            System.out.println("| 1. Excluir Medicamento                            |");
            System.out.println("| 2. Exclui item de Perfumaria                      |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("| 0. SAIR DO MENU GENERICOS                         |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("===================== EXCLUIR ======================= ");
            opcao = read.nextInt();
            read.nextLine();
            switch (opcao) {
                case 0:
                    saida = 1;
                    menu = "n";
                    break;
                case 1:
                    if (algumMedicamento() > 0) {
                        menuExcluiMedicamentos();
                    } else {
                        System.out.println("Nao existem medicamentos cadastrados");
                    }
                    break;
                case 2:
                    if (algumPerfumaria() > 0) {
                        menuExcluiPerf();
                    } else {
                        System.out.println("Nao existem itens de perfumaria cadastrados");
                    }
                    break;
            }
            if (saida == 0) {//so mostra se n for setado 0 pra sair do menu
                System.out.println("\nDeseja excluir mais algum item?\n[S]im ou [N]ao -- 0 pra SAIR do MENU EXCLUIR");
                menu = read.nextLine();
            }
        } while (menu.equalsIgnoreCase("s"));
    }

    public static void menuExcluiMedicamentos() {
        int opcao = -1, saida = 0;
        String menu = null;
        Scanner read = new Scanner(System.in);
        do {
            System.out.println("============== EXCLUIR MEDICAMENTOS ================== ");
            System.out.println("| 1. Excluir por Codigo                            |");
            System.out.println("| 2. Excluir por Nome                              |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("| 0. SAIR DO MENU EXCLUIR MEDICAMENTOS             |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("============== EXCLUIR MEDICAMENTOS ================== ");
            opcao = read.nextInt();
            read.nextLine();
            switch (opcao) {
                case 0:
                    saida = 1;
                    menu = "n";
                    break;
                case 1:
                    if (algumMedicamento() > 0) {
                        System.out.println("Digite o codigo do medicamento que deseja excluir");
                        int codMed = read.nextInt();
                        read.nextLine();
                        int qtdMedExc = excluiMedCod(codMed);
                        if (qtdMedExc > 0) {
                            System.out.println(qtdMedExc + " medicamentos foram excluidos");
                        }
                    } else {
                        System.out.println("Não existem itens a serem excluidos");
                    }

                    break;
                case 2:
                    if (algumMedicamento() > 0) {
                        System.out.println("Digite o nome do medicamento que deseja excluir");
                        String nomeMed = read.nextLine();
                        int qtdMedNomeExc = excluiMedNome(nomeMed);
                        if (qtdMedNomeExc > 0) {
                            System.out.println(qtdMedNomeExc + " medicamentos foram excluidos");
                        }
                    } else {
                        System.out.println("Não existem itens a serem excluidos");
                    }


            }
            if (saida == 0) {//so mostra se n for setado 0 pra sair do menu
                System.out.println("Deseja excluir mais algum medicamento?\n[S]im ou [N]ao -- 0 para SAIR do MENU EXCLUIR MEDICAMENTOS");
                menu = read.nextLine();
            }
        } while (menu.equalsIgnoreCase("s"));
    }

    public static void menuExcluiPerf() {
        int opcao = -1, saida = 0;
        String menu = null;
        Scanner read = new Scanner(System.in);
        do {
            System.out.println("============== EXCLUIR PERFUMARIA ================== ");
            System.out.println("| 1. Excluir por Codigo                            |");
            System.out.println("| 2. Excluir por Nome                              |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("| 0. SAIR DO MENU EXCLUIR PERFUMARIA               |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("============== EXCLUIR PERFUMARIA ================== ");
            opcao = read.nextInt();
            read.nextLine();
            switch (opcao) {
                case 0:
                    saida = 1;
                    menu = "n";
                    break;
                case 1:
                    if (algumPerfumaria() > 0) {
                        System.out.println("Digite o codigo do item de perfumaria que deseja excluir");
                        int codPerf = read.nextInt();
                        read.nextLine();
                        int qtdExcPerf = excluiPerfCod(codPerf);
                        if (qtdExcPerf > 0) {
                            System.out.println(qtdExcPerf + " itens de perfumaria foram excluidos");
                        }
                    }
                    break;
                case 2:
                    if (algumPerfumaria() > 0) {
                        System.out.println("Digite o nome do item de perfumaria que deseja excluir");
                        String nomePerf = read.nextLine();
                        int qtdExcNome = excluiPerfNome(nomePerf);
                        if (qtdExcNome > 0) {
                            System.out.println(qtdExcNome + " itens de perfumaria excluidos");
                        }
                    }
                    break;
            }
            if (saida == 0) {//so mostra se n for setado 0 pra sair do menu
                System.out.println("Deseja excluir mais algum item de perfumaria?\n[S]im ou [N]ao -- 0 Pra SAIR do MENU EXCLUIR PERFUMARIA");
                menu = read.nextLine();
            }
        } while (menu.equalsIgnoreCase("s"));
    }

    public static void menuVenda() {
        int opcao = -1, saida = 0;
        String menu = null;
        Scanner read = new Scanner(System.in);
        do {
            System.out.println("======================= VENDAS ===================== ");
            System.out.println("| 1. Nova Venda                                    |");
            System.out.println("| 2.                                               |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("| 0. SAIR DO MENU VENDAS                           |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("======================= VENDAS ===================== ");
            opcao = read.nextInt();
            read.nextLine();
            switch (opcao) {
                case 0:
                    saida = 1;
                    menu = "n";
                    break;
                case 1:
                    if (algumPerfumaria() > 0) {
                    }
                    break;
                case 2:
                    if (algumPerfumaria() > 0) {
                    }
                    break;
            }
            if (saida == 0) {//so mostra se n for setado 0 pra sair do menu
                System.out.println("Deseja eefetuar mais alguma venda?\n[S]im ou [N]ao -- 0 Pra SAIR do MENU VENDAS");
                menu = read.nextLine();
            }
        } while (menu.equalsIgnoreCase("s"));


    }
    //===============  MENUS =====================

    //=============== EXCLUSÕES ==================
    public static int excluiPerfCod(int cod) {
        int count = 0, countOcorre = 0, exclusoes = 0;
        Perfumaria perf = null, amostra = null;
        Scanner read = new Scanner(System.in);
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i) instanceof Perfumaria) {
                perf = (Perfumaria) listaItens.get(i);
                if (perf.getCodPerf() == cod) {
                    countOcorre++;
                    amostra = perf;
                }
            }
        }
        do {
            System.out.println("Existem " + countOcorre + " unidades do medicamento  de codigo " + cod);
            if (countOcorre > 0) {
                amostra.imprimeInfo();
                System.out.println("Digite a quantidade que deseja excluir [0 caso queira cancelar a exclusão]");
                exclusoes = read.nextInt();
                read.nextLine();
            }
        } while (exclusoes < 0 || exclusoes > countOcorre);
        int k = 0, excluidos = 0;
        for (int j = 0; j < listaItens.size(); j++) {
            System.out.println(listaItens.size());
            if (listaItens.get(j) instanceof Perfumaria) {
                perf = (Perfumaria) listaItens.get(j);
                if (excluidos < exclusoes && perf.getCodPerf() == cod) {
                    listaItens.remove(j);
                    excluidos++;
                    k++;
                }
            }
        }
        if (algumPerfumaria() == exclusoes && exclusoes == listaItens.size()) {
            excluidos = listaItens.size();
            listaItens.clear();
        }
        System.out.println("tamanho lista = " + listaItens.size());
        if (exclusoes == 0) {
            System.out.println("A exclusão do item de perfumaria foi cancelada!!");
        }
        return excluidos;
    }

    public static int excluiPerfNome(String nome) {
        int count = 0, countOcorre = 0, exclusoes = 0;
        Perfumaria perf = null, amostra = null;
        Scanner read = new Scanner(System.in);
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i) instanceof Perfumaria) {
                perf = (Perfumaria) listaItens.get(i);
                if (perf.getNome().equalsIgnoreCase(nome)) {
                    countOcorre++;
                    amostra = perf;
                }
            }
        }
        do {
            System.out.println("Existem " + countOcorre + " unidades do medicamento " + perf.getNome());
            if (countOcorre > 0) {
                amostra.imprimeInfo();
                System.out.println("Digite a quantidade que deseja excluir [0 caso queira cancelar a exclusão]");
                exclusoes = read.nextInt();
                read.nextLine();
            }
        } while (exclusoes < 0 || exclusoes > countOcorre);
        int k = 0, excluidos = 0;
        for (int j = 0; j < listaItens.size(); j++) {
            if (listaItens.get(j) instanceof Perfumaria) {
                perf = (Perfumaria) listaItens.get(j);
                if (k < exclusoes && perf.getNome().equalsIgnoreCase(nome)) {
                    listaItens.remove(j);
                    excluidos++;
                    k++;
                }
            }
        }
        if (excluidos == 0) {
            System.out.println("A exclusão do medicamento foi cancelada!!");
        }
        return excluidos;
    }

    public static int excluiMedCod(int cod) {
        int count = 0, countOcorre = 0, exclusoes = 0;
        Medicamentos med = null, amostra = null;
        Scanner read = new Scanner(System.in);
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i) instanceof Medicamentos) {
                med = (Medicamentos) listaItens.get(i);
                if (med.getCodMed() == cod) {
                    countOcorre++;
                    amostra = med;
                }
            }
        }
        do {
            System.out.println("Existem " + countOcorre + " unidades do medicamento " + med.getNome() + " de codigo " + cod);
            amostra.imprimeInfo();
            System.out.println("Digite a quantidade que deseja excluir [0 caso queira cancelar a exclusão]");
            exclusoes = read.nextInt();
            read.nextLine();
        } while (exclusoes < 0 || exclusoes > countOcorre);
        int k = 0, excluidos = 0;
        for (int j = 0; j < listaItens.size(); j++) {
            if (listaItens.get(j) instanceof Medicamentos) {
                med = (Medicamentos) listaItens.get(j);
                if (k < exclusoes && med.getCodMed() == cod) {
                    listaItens.remove(j);
                    excluidos++;
                }
            }
        }
        if (excluidos == 0) {
            System.out.println("A exclusão do medicamento " + amostra.getNome() + " foi cancelada!!");
        }
        return excluidos;
    }

    public static int excluiMedNome(String nome) {
        int count = 0, countOcorre = 0, exclusoes = 0;
        Medicamentos med = null, amostra = null;
        Scanner read = new Scanner(System.in);
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i) instanceof Medicamentos) {
                med = (Medicamentos) listaItens.get(i);
                if (med.getNome().equalsIgnoreCase(nome)) {
                    countOcorre++;
                    amostra = med;
                }
            }
        }
        do {
            System.out.println("Existem " + countOcorre + " unidades do medicamento " + med.getNome());
            amostra.imprimeInfo();
            System.out.println("Digite a quantidade que deseja excluir [0 caso queria cancelar a exclusão]");
            exclusoes = read.nextInt();
            read.nextLine();
        } while (exclusoes < 0 || exclusoes > countOcorre);
        int k = 0, excluidos = 0;
        for (int j = 0; j < listaItens.size(); j++) {
            if (listaItens.get(j) instanceof Medicamentos) {
                med = (Medicamentos) listaItens.get(j);
                if (k < exclusoes && med.getNome().equalsIgnoreCase(nome)) {
                    listaItens.remove(j);
                    excluidos++;
                    k++;
                }
            }
        }
        if (excluidos == 0) {
            System.out.println("A exclusão do medicamento " + amostra.getNome() + " foi cancelada!!");
        }
        return excluidos;
    }
    //=============== EXCLUSÕES ==================

    //============== BUSCAS ======================
    public static int algumMedicamento() {
        int count = 0;
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i) instanceof Medicamentos) {
                count++;
            }
        }
        return count;
    }

    public static int algumPerfumaria() {
        int count = 0;
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i) instanceof Perfumaria) {
                count++;
            }
        }
        return count;
    }

    public static int buscaItemCodigo(int codigo) {
        int count = 0;
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i).getCodigo() == codigo) {
                if (listaItens.get(i) instanceof Medicamentos) {
                    System.out.println("Medicamento:");
                }
                if (listaItens.get(i) instanceof Perfumaria) {
                    System.out.println("Perfumaria: ");
                }
                listaItens.get(i).imprimeInfo();
                System.out.println();
                count++;
            }
            if (i == listaItens.size()) {
                System.out.println("Item de codigo " + codigo + " nao encontrado");
            }
        }
        return count;
    }

    public static int buscaItemNome(String nome) {
        Scanner read = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i).getNome().equalsIgnoreCase(nome)) {
                if (listaItens.get(i) instanceof Medicamentos) {
                    System.out.println("Medicamento:");
                }
                if (listaItens.get(i) instanceof Perfumaria) {
                    System.out.println("Perfumaria: ");
                }
                listaItens.get(i).imprimeInfo();
                System.out.println();
                count++;
            }
            if (i == listaItens.size()) {
                System.out.println("Item " + nome + " nao encontrado");
            }
        }
        return count;
    }

    public static int buscaPriAtivo(String priAtivo) {
        Scanner read = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i).getNome().equalsIgnoreCase(priAtivo)) {
                if (listaItens.get(i) instanceof Medicamentos) {
                    System.out.println("Medicamento:");
                }
                if (listaItens.get(i) instanceof Perfumaria) {
                    System.out.println("Perfumaria: ");
                }
                listaItens.get(i).imprimeInfo();
                System.out.println();
                count++;
            }
        }
        return count;
    }
    //USO DE CAST

    public static int buscaGenCod(int cod) {
        int count = 0;
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i) instanceof Medicamentos) {
                Medicamentos med = (Medicamentos) listaItens.get(i);
                if (med.isGenerico() && med.getCodMed() == cod) {
                    med.imprimeInfo();
                    count++;
                }
            }
        }
        return count;
    }

    public static int buscaGenNome(String nome) {
        Scanner read = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i) instanceof Medicamentos) {
                Medicamentos med = (Medicamentos) listaItens.get(i);
                if (med.isGenerico() && med.getNome().equalsIgnoreCase(nome)) {
                    med.imprimeInfo();
                    count++;
                }
            }
            if (count == 0 || listaItens.isEmpty()) {
                System.out.println("Generico de " + nome + " nao foi encontrado");
            }
        }
        return count;
    }

    public static int buscaGenPriAtivo(String priAtivo) {
        int count = 0;
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i) instanceof Medicamentos) {
                Medicamentos med = (Medicamentos) listaItens.get(i);
                if (med.isGenerico() && med.getPrincipioAtivo().equalsIgnoreCase(priAtivo)) {
                    med.imprimeInfo();
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Generico com Principio Ativo " + priAtivo + " nao foi encontrado");
        }
        return count;
    }

    public static int buscaPerfumariaCod(int cod) {
        int count = 0;
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i) instanceof Perfumaria) {
                Perfumaria perf = (Perfumaria) listaItens.get(i);
                if (perf.getCodPerf() == cod) {
                    perf.imprimeInfo();
                    count++;
                }
            }
        }
        return count;
    }

    public static int buscaPerfumariaNome(String nome) {
        int count = 0;
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i) instanceof Perfumaria) {
                Perfumaria perf = (Perfumaria) listaItens.get(i);
                if (perf.getNome().equalsIgnoreCase(nome)) {
                    perf.imprimeInfo();
                    count++;
                }
            }
        }
        return count;
    }

    public static int buscaPerfumariaFrag(String fragrancia) {
        int count = 0;
        for (int i = 0; i < listaItens.size(); i++) {
            if (listaItens.get(i) instanceof Perfumaria) {
                Perfumaria perf = (Perfumaria) listaItens.get(i);
                if (perf.getFragrancia().equalsIgnoreCase(fragrancia)) {
                    perf.imprimeInfo();
                    count++;
                }
            }
        }
        return count;
    }

    //testa se já existe um objeto igual cadastrado na lista de Itens
    public static int buscaCadastro(Item item) {
        String nome = item.getNome();
        if (item instanceof Medicamentos) {
            //MedicamentoNormal med = new MedicamentoNormal(tarja, data, principio, posologia, generico, codigo,lote, preco, validade, nome)
            for (int i = 0; i < listaItens.size(); i++) {
                //se o nome for igual, compara o restantes dos atributos
                if (listaItens.get(i).getNome().equalsIgnoreCase(nome)) {
                    Medicamentos med = (Medicamentos) listaItens.get(i);
                    String tarja = med.getTarja();
                    String data = med.getDataVencimento();
                    String priAtivo = med.getPrincipioAtivo();
                    String posologia = med.getPosologia();
                    boolean generico = med.isGenerico();
                    String lote = med.getLote();
                    float preco = med.getPreco();
                    String validade = med.getValidade();
                    //SE FOREM OBJETOS IGUAIS RETORNA O CÓDIGO DO OBJETO JÁ CADASTRADO NA LISTA
                    if (med.getTarja().equalsIgnoreCase(tarja) && med.getDataVencimento().equalsIgnoreCase(data)
                            && med.getPrincipioAtivo().equalsIgnoreCase(priAtivo) && med.getPosologia().equalsIgnoreCase(posologia)
                            && med.isGenerico() == generico && med.getLote().equalsIgnoreCase(lote)
                            && med.getPreco() == preco) {
                        Item.decreCod();//decrementa o atributo estatico cod
                        return med.getCodMed();//codigo do objeto existente na lista
                    }
                }
            }
        }

        if (item instanceof Perfumaria) {
            //Perfumaria perf = new Perfumaria(lote, preco, validade, nome, fragrancia, unidade)
            for (int i = 0; i < listaItens.size(); i++) {
                //se o nome for igual compara o restante dos atributos
                if (listaItens.get(i).getNome().equalsIgnoreCase(nome)) {
                    Perfumaria perf = (Perfumaria) listaItens.get(i);
                    String lote = perf.getLote();
                    float preco = perf.getPreco();
                    String validade = perf.getValidade();
                    String fragrancia = perf.getFragrancia();
                    String unidade = perf.getUnidade();
                    //SE FOREM OBJETOS IGUAIS RETORNA O CÓDIGO DO OBJETO QUE JÁ ESTÁ CADASTRADO NA LISTA
                    if (perf.getLote().equalsIgnoreCase(lote) && perf.getPreco() == preco
                            && perf.getValidade().equalsIgnoreCase(validade) && perf.getFragrancia().equalsIgnoreCase(fragrancia)
                            && perf.getUnidade().equalsIgnoreCase(unidade)) {
                        return perf.getCodPerf();//codigo do objetoj existente na lista
                    }
                }
            }
        }
        return 0;
    }

    public static ArrayList<Item> getListaItens() {
        return listaItens;
    }

    public static void setListaItens(ArrayList<Item> listaItens) {
        Farmacia.listaItens = listaItens;
    }

    //============== BUSCAS ======================
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int menu = -1;
        Scanner read = new Scanner(System.in);
        //MENU
        do {
            System.out.println("============= FARMACIA DO POLVO PAUL ================ ");
            System.out.println(" ---------------------------------------------------");
            System.out.println("| Escolha uma das operações abaixo ou 0 para sair...|");
            System.out.println(" ---------------------------------------------------");
            System.out.println("| 1. Cadastrar Medicamento                          |");
            System.out.println("| 2. Cadastrar Perfumaria                           |");
            System.out.println("| 3. Listar Itens cadastrados                       |");
            System.out.println("| 4. Pesquisar                                      |");
            System.out.println("| 5. Excluir                                        |");
            System.out.println("| 6. Efetuar VENDA                                  |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("| 0. SAIR DO SISTEMA                                |");
            System.out.println(" ---------------------------------------------------");
            System.out.println("============= FARMACIA DO POLVO PAUL ================ ");
            menu = read.nextInt();
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
                    if (!listaItens.isEmpty()) {
                        menuPesquisarItem();
                    } else {
                        System.out.println("Nao existem itens cadastrados\nCadastre um item antes de pesquisar");
                        System.out.println("Tecle ENTER para voltar ao menu");
                        read.nextLine();
                        read.nextLine();
                    }
                    break;
                case 5:
                    if (!listaItens.isEmpty()) {
                        menuExcluir();
                    } else {
                        System.out.println("Nao existem itens para serem excluidos");
                    }
                    break;
                case 6:
                    if (!listaItens.isEmpty()) {
                        menuVenda();
                    } else {
                        System.out.println("Nao existem itens para serem vendidos");
                    }
                default:
                    System.out.println("Digite número válido ou 0 pra SAIR...");
            }
        } while (menu != 0);
    }
}