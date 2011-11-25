/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;
//imports
import java.util.*;

/**
 *
 * @author lucas
 */
public class Publicacao {

    private String dataPublicacao;
    private String titulo;
    private ArrayList<Publicacao> listaPubReference = new ArrayList<Publicacao>();
    private ArrayList<Autor> listaAutore = new ArrayList<Autor>();
    private boolean disponivel;

    public boolean disponivel(Publicacao objeto) {
        return objeto.isDisponivel();
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void verificaDisponiblilidade() {
        if (disponivel) {
            System.out.println("Indisponível");
        } else {
            System.out.println("Disponível");
        }

    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public ArrayList<Autor> getListaAutore() {
        return listaAutore;
    }

    public void setListaAutore(ArrayList<Autor> listaAutore) {
        this.listaAutore = listaAutore;
    }

    public ArrayList<Publicacao> getListaPubReference() {
        return listaPubReference;
    }

    public void setListaPubReference(ArrayList<Publicacao> listaPubReference) {
        this.listaPubReference = listaPubReference;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
