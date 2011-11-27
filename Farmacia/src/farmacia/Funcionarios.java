/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

/**
 *
 * @author Lucas&Danilo
 */
public class Funcionarios {
    private String nome, endereco, telefone, dataAdmissao;
    private int id;
    private float salario;

    //construtor
    public Funcionarios(String nome, String endereco, String telefone, String dataAdmissao, int id, float salario) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataAdmissao = dataAdmissao;
        this.id = id;
        this.salario = salario;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
}
