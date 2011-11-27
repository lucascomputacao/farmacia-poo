/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhopoo;

/**
 *
 * @author Lucas&Danilo
 */
public abstract class Medicamentos {
    private int codigo;
    private float preco;    
    //tarja = sem tarja [venda livre], amarela [genáricos], vermelha [com receita em papel branco] e preta [com receita em papel azul]
    private String nome, tarja, dataVencimento, principioAtivo;

    //construtor
    public Medicamentos(String nome, String tarja, String dataVencimento, String principioAtivo, int codigo, float preco) {
        this.nome = nome;
        this.tarja = tarja;
        this.dataVencimento = dataVencimento;
        this.principioAtivo = principioAtivo;
        this.codigo = codigo;
        this.preco = preco;
    }
    
    
    
}
