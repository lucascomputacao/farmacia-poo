/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopoo;

import java.util.GregorianCalendar;

/**
 * Classe cria o objeto venda que é posteriormente inserido no banco de dados        
 * 
 * @author lucas
 */
public class Venda {

    private String descricao;
    private int codigo, qtd;
    private float vlrUnit, vlrTotal;
    
    //data da venda
    GregorianCalendar gc = new GregorianCalendar();
    long dia = gc.get(GregorianCalendar.DAY_OF_MONTH);
    long mes = gc.get(GregorianCalendar.MONTH) + 1;
    long ano = gc.get((GregorianCalendar.YEAR));

    //construtor
    public Venda(String descricao, int codigo, int qtd, float vlrUnit, float vlrTotal) {
        this.descricao = descricao;
        this.codigo = codigo;
        this.qtd = qtd;
        this.vlrUnit = vlrUnit;
        this.vlrTotal = vlrTotal;
    }
    
}
