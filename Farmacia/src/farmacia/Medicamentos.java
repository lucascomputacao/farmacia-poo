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

    private String tarja, dataVencimento, principioAtivo, posologia;
    private boolean generico;

    public Medicamentos(String tarja, String dataVencimento, String principioAtivo, String posologia, boolean generico, String lote, float preco, String validade, String nome) {
        super(lote, preco, validade, nome);
        this.tarja = tarja;
        this.dataVencimento = dataVencimento;
        this.principioAtivo = principioAtivo;
        this.posologia = posologia;
        this.generico = generico;
    }

    public Medicamentos(String tarja, String dataVencimento, String principioAtivo, boolean generico, String lote, float preco, String validade, String nome) {
        super(lote, preco, validade, nome);
        this.tarja = tarja;
        this.dataVencimento = dataVencimento;
        this.principioAtivo = principioAtivo;
        this.generico = generico;
    }

    
    public void imprimeInfo() {
        String iTarja = "";
        if (getTarja().equalsIgnoreCase("s")) {
            iTarja = "Sem Tarja";
        }
        if (getTarja().equalsIgnoreCase("v")) {
            iTarja = "Tarja Vermelha";
        }
        if (getTarja().equalsIgnoreCase("p")) {
            iTarja = "Tarja Preta";
        }
        System.out.println("Nome: " + getNome() + "\n"
                + "Principio Ativo: " + getPrincipioAtivo() + "\n"
                + "Posologia: " + getPosologia() + "\n"
                + "Tarja: " + iTarja + "\n"
                + "Validade: " + getDataVencimento());
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
