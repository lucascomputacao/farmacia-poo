/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.*;

/**
 *
 * @author lucas
 */
public class Livro extends Publicacao {

    private ArrayList<Publicacao> listaPubReference = new ArrayList<Publicacao>();
    private ArrayList<Autor> listaAutores = new ArrayList<Autor>();
    private int numeroEdicao;
    private String nomeEditora;
    private int isbn;//international Standard Book Number
    private int tempoLocacao;//dias = 1 semana

    public Livro(int numeroEdicao, String nomeEditora, int isbn) {
        this.numeroEdicao = numeroEdicao;
        this.nomeEditora = nomeEditora;
        this.isbn = isbn;        
    }
   

    @Override
    public void setDisponivel(boolean disponivel) {
        setDisponivel(disponivel);
    }


    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public ArrayList<Autor> getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(ArrayList<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }

    public String getNomeEditora() {
        return nomeEditora;
    }

    public void setNomeEditora(String nomeEditora) {
        this.nomeEditora = nomeEditora;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }
}
