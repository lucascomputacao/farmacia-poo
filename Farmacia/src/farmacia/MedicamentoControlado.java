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

    public MedicamentoControlado(String tarja, String dataVencimento, String principioAtivo, String posologia, boolean generico, int codigo, String lote, float preco, String validade, String nome) {
        super(tarja, dataVencimento, principioAtivo, posologia, generico, codigo, lote, preco, validade, nome);
    }

    public MedicamentoControlado(String tarja, String dataVencimento, String principioAtivo, boolean generico, int codigo, String lote, float preco, String validade, String nome) {
        super(tarja, dataVencimento, principioAtivo, generico, codigo, lote, preco, validade, nome);
    }

       
}
