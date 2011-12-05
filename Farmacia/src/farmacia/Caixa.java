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
    
    public void exibirItens(){
        for (int i = 0; i < listVenda.size(); i++) {
           ArrayList<Item> lista = listVenda.get(i).getListaItensVenda();
           lista.get(i).imprimeInfo();            
        }
    }
    
    public void addListaVenda(Venda venda){
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
