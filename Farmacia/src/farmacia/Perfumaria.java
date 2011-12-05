/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

/**
 *
 * @author lucas
 */
public class Perfumaria extends Item {

    private String fragrancia,  unidade;//unidade = vendido em caixa[sabonetes] ou em mls [perfumes]
    private int codPerf;

    public Perfumaria(String lote, float preco,
            String validade, String nome, String fragrancia, String unidade) {
        super(lote, preco, validade, nome);
        this.fragrancia = fragrancia;
        this.unidade = unidade;
        this.codPerf = getCodigo();//pega o código sequencial para novo item cadastrado 
    }    

    @Override
    void imprimeInfo() {   
        System.out.println("Codigo: " + getCodPerf() + "\n"
                + "Nome: " + getNome() + "\n"
                + "Fragrancia: " + getFragrancia()+"\n"
                + "Unidade de venda: " + getUnidade()+"\n"
                + "Lote: " + getLote() + "\n"
                + "Validade: " + getValidade()+ "\n"
                + "Preco: " + getPreco());
    }

    public int getCodPerf() {
        return codPerf;
    }

    public void setCodPerf(int codPerf) {
        this.codPerf = codPerf;
    }

    public String getFragrancia() {
        return fragrancia;
    }

    public void setFragrancia(String fragrancia) {
        this.fragrancia = fragrancia;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    
}
