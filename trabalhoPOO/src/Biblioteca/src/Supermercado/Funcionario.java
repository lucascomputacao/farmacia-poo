/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

/**
 *
 * @author lucas
 */
public class Funcionario {
   private String nome;
   private String cpf;
   private float salario;

    public Funcionario(String nome, String cpf, int salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }
    public float calculaSalario(Funcionario funcionario){        
        return funcionario.calculaSalario(funcionario);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

   
    public void setSalario(int salario) {
        this.salario = salario;
    }
   
   
}
