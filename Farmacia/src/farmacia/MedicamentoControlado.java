/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

/**
 *
 * @author lucas
 */
public class MedicamentoControlado extends Medicamentos {

    public MedicamentoControlado(int codigo, int lote, float preco, String nome, String tarja, String dataVencimento, String principioAtivo, boolean generico) {
        super(codigo, lote, preco, nome, tarja, dataVencimento, principioAtivo, generico);
    }   
    
}
