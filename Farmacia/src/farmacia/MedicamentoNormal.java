/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

/**
 *
 * @author lucas
 */
public class MedicamentoNormal extends Medicamentos {

    //Construtor com posologia
    public MedicamentoNormal(String nome, String tarja, String dataVencimento, String principioAtivo, String posologia, boolean generico, int codigo, int lote, float preco, String validade) {
        super(nome, tarja, dataVencimento, principioAtivo, posologia, generico, codigo, lote, preco, validade);
    }
    //Construtor sem posologia
    public MedicamentoNormal(String nome, String tarja, String dataVencimento, String principioAtivo, boolean generico, int codigo, int lote, float preco, String validade) {
        super(nome, tarja, dataVencimento, principioAtivo, generico, codigo, lote, preco, validade);
    }
    
    //Getters e Setters
    
    
}
