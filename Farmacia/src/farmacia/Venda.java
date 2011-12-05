/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Classe cria o objeto venda que é posteriormente inserido no banco de dados        
 * 
 * @author lucas
 */
public class Venda {
    //Uma venda tem vários itens

    private ArrayList<Item> listaItensVenda = new ArrayList<Item>();
    //private String descricao;
    private String dataVenda = null;
    private int idVenda, qtd;
    private float vlrTotal;
    //Inicializando as variáveis da data da venda
    private GregorianCalendar gc = new GregorianCalendar();
    private long dia = getGc().get(GregorianCalendar.DAY_OF_MONTH);
    private long mes = getGc().get(GregorianCalendar.MONTH) + 1;
    private long ano = getGc().get((GregorianCalendar.YEAR));

    public Venda() {
        this.idVenda = idVenda++;
        colocaDataVenda();

    }

    public void addListaItensVenda(Item item) {
        listaItensVenda.add(item);
        System.out.println("Item: codigo =  " + item.getCodigo() + "| Nome = " + item.getNome() + " adicionado a compra");
        calculaValorTotal();
        System.out.println("Totalizando "+getVlrTotal());
        setQtd(listaItensVenda.size());
    }

    public void calculaValorTotal() {
        float soma = 0;
        for (int i = 0; i < listaItensVenda.size(); i++) {
            soma += listaItensVenda.get(i).getPreco();
        }
        setVlrTotal(soma);
    }

    public long getAno() {
        return ano;
    }

    public void setAno(long ano) {
        this.ano = ano;
    }

    public final void colocaDataVenda() {
        String novaData = getDia() + "/" + getMes() + "/" + getAno();
        setDataVenda(novaData);
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public long getDia() {
        return dia;
    }

    public void setDia(long dia) {
        this.dia = dia;
    }

    public GregorianCalendar getGc() {
        return gc;
    }

    public void setGc(GregorianCalendar gc) {
        this.gc = gc;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public ArrayList<Item> getListaItensVenda() {
        return listaItensVenda;
    }

    public void setListaItensVenda(ArrayList<Item> listaItensVenda) {
        this.listaItensVenda = listaItensVenda;
    }

    public long getMes() {
        return mes;
    }

    public void setMes(long mes) {
        this.mes = mes;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(float vlrTotal) {
        this.vlrTotal = vlrTotal;
    }
}
