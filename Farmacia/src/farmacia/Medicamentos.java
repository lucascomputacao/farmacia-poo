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
    private String nome, tarja, dataVencimento, principioAtivo, posologia;
    private boolean generico;

    //construtoro com posologia
    public Medicamentos(String nome, String tarja, String dataVencimento, String principioAtivo, String posologia, boolean generico, int codigo, int lote, float preco, String validade) {
        super(codigo, lote, preco, validade);
        this.nome = nome;
        this.tarja = tarja;
        this.dataVencimento = dataVencimento;
        this.principioAtivo = principioAtivo;
        this.posologia = posologia;
        this.generico = generico;
    }
    //construtor sem posologia

    public Medicamentos(String nome, String tarja, String dataVencimento, String principioAtivo, boolean generico, int codigo, int lote, float preco, String validade) {
        super(codigo, lote, preco, validade);
        this.nome = nome;
        this.tarja = tarja;
        this.dataVencimento = dataVencimento;
        this.principioAtivo = principioAtivo;
        this.generico = generico;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public boolean isGenerico() {
        return generico;
    }

    public void setGenerico(boolean generico) {
        this.generico = generico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public String getPrincipioAtivo() {
        return principioAtivo;
    }

    public void setPrincipioAtivo(String principioAtivo) {
        this.principioAtivo = principioAtivo;
    }

    public String getTarja() {
        return tarja;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

}
