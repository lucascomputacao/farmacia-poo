/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

/**
 *
 * @author Lucas&Danilo
 */
public abstract class Medicamentos extends Item {
//classe não pode ser instanciada
   
    //tarja = sem tarja [venda livre], amarela [genáricos], vermelha [com receita em papel branco] e preta [com receita em papel azul]
    private String nome, tarja, dataVencimento, principioAtivo;
    private boolean generico;

    public Medicamentos(String nome, String tarja, String dataVencimento, String principioAtivo, boolean generico, int codigo, int lote, float preco, String validade) {
        super(codigo, lote, preco, validade);
        this.nome = nome;
        this.tarja = tarja;
        this.dataVencimento = dataVencimento;
        this.principioAtivo = principioAtivo;
        this.generico = generico;
    }

   

  
    
    

}
