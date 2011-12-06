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
    //Registro CRM do médico responsável pela receita
    private int crm;

    public MedicamentoControlado(int crm, String tarja, String dataVencimento, String principioAtivo, String posologia, boolean generico, int codMed, String lote, float preco, String validade, String nome) {
        super(tarja, dataVencimento, principioAtivo, posologia, generico, codMed, lote, preco, validade, nome);
        this.crm = crm;
    }

    public MedicamentoControlado(int crm, String tarja, String dataVencimento, String principioAtivo, boolean generico, int codMed, String lote, float preco, String validade, String nome) {
        super(tarja, dataVencimento, principioAtivo, generico, codMed, lote, preco, validade, nome);
        this.crm = crm;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }
    
}
