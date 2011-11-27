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

    public MedicamentoControlado(String nome, String tarja, String dataVencimento, String principioAtivo, String posologia, boolean generico, String lote, float preco, String validade) {
        super(nome, tarja, dataVencimento, principioAtivo, posologia, generico, lote, preco, validade);
    }

    public MedicamentoControlado(String nome, String tarja, String dataVencimento, String principioAtivo, boolean generico, String lote, float preco, String validade) {
        super(nome, tarja, dataVencimento, principioAtivo, generico, lote, preco, validade);
    }

   

       
}
