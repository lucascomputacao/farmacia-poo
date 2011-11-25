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
public class Artigo extends Publicacao {

    private ArrayList<Autor> listaAutores = new ArrayList<Autor>();
    private ArrayList<Publicacao> listaPubReference = new ArrayList<Publicacao>();
    private String resumo;
    
    @Override
    public void setDisponivel(boolean disponivel) {
        setDisponivel(disponivel);
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public ArrayList<Autor> getListaAutores() {
        return listaAutores;
    }

    public void setListaAutores(ArrayList<Autor> listaAutores) {
        this.listaAutores = listaAutores;
    }
    
    
}
