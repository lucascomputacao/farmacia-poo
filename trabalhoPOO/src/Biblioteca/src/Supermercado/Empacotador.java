/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado;

/**
 *
 * @author lucas
 */
public class Empacotador extends Funcionario {

    private boolean deficiencia;
    

    public Empacotador(boolean deficiencia, String nome, String cpf, int salario) {
        super(nome, cpf, salario);
        this.deficiencia = deficiencia;
    }
    
    public float calculaSalario() {
        if (deficiencia == true) {
            //portadores de deficiencia tem adicional de 10% no salario
            return super.getSalario()+(super.getSalario()/ 10);
        }else{
            return super.getSalario();
        }
    }
}
