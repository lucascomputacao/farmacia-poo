/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

/**
 *
 * @author lucas
 */
public abstract class Item {

    private int codigo, lote;
    private float preco;
    private String validade;

    public Item(int codigo, int lote, float preco, String validade) {
        this.codigo = codigo;
        this.lote = lote;
        this.preco = preco;
        this.validade = validade;
    }
}
