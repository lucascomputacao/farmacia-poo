/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Caixa {
    //ATIVIDADES DO CAIXA DA FARMACIA: ABERTURA, FECHAMENTO, VENDA, TROCO, CANCELAMENTO

    private static ArrayList<Venda> listVenda = new ArrayList<Venda>();
    private static int id = 0;
    private String operador;
    private float saldo;

    public Caixa(String operador, float saldo) {
        this.operador = operador;
        this.saldo = saldo;
        Caixa.id = id++;
    }

    public float exibirItens(Venda venda) {
        float total = 0;
        for (int i = 0; i < venda.getListaItensVenda().size(); i++) {
            venda.getListaItensVenda().get(i).imprimeInfo();
            total =  venda.getVlrTotal();
        }
        System.out.println("\nQuantidade de itens:" + venda.getListaItensVenda().size()+ "\nValor Total: " + total);
        return total;
    }
    //retira do estoque os itens vendidos

    public void baixaEstoque(Venda venda) {
        ArrayList<Item> itensVendidos = venda.getListaItensVenda();
        for (int i = 0; i < Farmacia.getListaItens().size(); i++) {
            Item busca = itensVendidos.get(i);
            if (Farmacia.getListaItens().get(i).equals(busca)) {
                if (Farmacia.getListaItens().size() == 1) {
                    Farmacia.getListaItens().clear();
                } else {
                    Item remove = Farmacia.getListaItens().remove(i);
                }

            }
        }
    }

    public float cobranca(float dinheiro, float aPagar) {
        if (dinheiro < aPagar) {
            System.out.println("Quantia em dinheiro insuficiente");
            return 0;
        }
        float troco = dinheiro - aPagar;
        System.out.println("Recebido: R$ " + dinheiro + " - Total: R$ " + aPagar);
        System.out.println("Troco: R$ " + troco);
        return troco;
    }

    public void addListaVenda(Venda venda) {
        listVenda.add(venda);
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Caixa.id = id;
    }

    public ArrayList<Venda> getListVenda() {
        return listVenda;
    }

    public void setListVenda(ArrayList<Venda> listVenda) {
        this.listVenda = listVenda;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
}
