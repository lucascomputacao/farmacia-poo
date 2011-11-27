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

    private static int codigo = 0;
    private String lote;
    private float preco;
    private String validade;

    public Item(String lote, float preco, String validade) {
        Item.codigo = codigo++;
        this.lote = lote;
        this.preco = preco;
        this.validade = validade;
    }

    public static int getCodigo() {
        return codigo;
    }

    public static void setCodigo(int codigo) {
        Item.codigo = codigo;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
    
    
}
