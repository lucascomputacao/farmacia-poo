/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package farmacia;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Data {

    private int dia, mes, ano;

    public Data(int dia, int mes, int ano) {
        if (testaData()) {
            this.dia = dia;
            this.mes = mes;
            this.ano = ano;
        } else {
            System.out.println("Data Incorreta");
        }
    }

    /**
     * Validação de data inserida pelo construtor da classe
     * @return true se a data for válida
     */
    public final boolean testaData() {
        boolean bissexto = false, valida = false;
        if (dia < 1 || dia > 31) {
            System.out.println("Dia tem que estar entre 1 e 31");
            return false;
        }
        if (mes < 1 || mes > 12) {
            System.out.println("Mes tem que estar entre 1 e 12");
            return false;
        }
        if (ano < 0) {
            System.out.println("Ano não poder ser menor do que 0");
            return false;
        }
        //ano bissexto
        if ((ano / 4) == 0 && (ano / 100) != 0) {
            bissexto = true;
        }
        //
        if (mes == 2 && !(bissexto) && dia > 28) {//fevereiro PROBLEMÁTICO :@
            System.out.println("Ano não é bissexto, fevereiro não pode ter mais de 28 dias!");
            return false;
        }
        if (mes == 2 && bissexto && dia > 29) {
            System.out.println("Fevereiro tem apenas 29 dias em anos bissextos");
            return false;
        }
        if ((dia > 30) && (mes == 2 || mes == 4 || mes == 6 || mes == 9 || mes == 11)) {
            System.out.println(mesToString(mes) + "não tem mais de 30 dias!!");
            return false;
        }
        //data válida caso nenhuma das anteriores se aplicar
        return true;
    }

    //metodo pra retornar string a partir do inteiro correspondente ao mes
    public final String mesToString(int mes) {
        String[] meses = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        ArrayList<String> listaMeses = new ArrayList<String>(mes);
        if (mes < 1 || mes > 12) {
            return "Mes deve estar entre 1 e 12";
        } else {
            //retorna o mes como string -- indices do ArrayList começa em 0
            return listaMeses.get(mes + 1);
        }
    }
}
