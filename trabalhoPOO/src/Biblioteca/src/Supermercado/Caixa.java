/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

/**
 *
 * @author lucas
 */
public class Caixa extends Funcionario {

    private float horaExtra;

    public Caixa(float horaExtra, String nome, String cpf, int salario) {
        super(nome, cpf, salario);
        this.horaExtra = horaExtra;
    }

    public float getHoraExtra() {
        return horaExtra;
    }

    public void setHoraExtra(float horaExtra) {
        this.horaExtra = horaExtra;
    }

    @Override
    public float calculaSalario(Funcionario funcionario) {
        return super.getSalario() + horaExtra*10;//10 por hora extra trabalhada
    }
}
