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
    private String nome;

    public Item(String lote, float preco, String validade, String nome) {
        this.lote = lote;
        this.preco = preco;
        this.validade = validade;
        this.nome = nome;
    }
    //MÉTODO ABSTRATO
    abstract void imprimeInfo();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static int getCodigo() {
        return codigo;
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
