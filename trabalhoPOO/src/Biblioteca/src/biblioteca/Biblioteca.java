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
public class Biblioteca {

    private String nome, endereco;
    private ArrayList<Publicacao> listaPublicacoes = new ArrayList<Publicacao>();
    private int dataLocacao;
    //private Date dataDevolucao;
    GregorianCalendar gc = new GregorianCalendar();

    public void locar(Livro livro) {
        if (livro.isDisponivel()) {
            dataLocacao = GregorianCalendar.DATE + GregorianCalendar.MONTH + GregorianCalendar.YEAR;
            System.out.println("data de locacao = " + dataLocacao);
            livro.setDisponivel(false);
            long dia = gc.get(GregorianCalendar.DAY_OF_MONTH);
            //long diaDevolucao;
            long mes = gc.get(GregorianCalendar.MONTH) + 1;
            long mesDevoulucao;
            long ano = gc.get((GregorianCalendar.YEAR));
            boolean bissexto = false;
            //System.out.println("Dia: " + dia + "\nMês: " + mes + "\nAno: " + ano);
            System.out.println("Livro " + livro + " locado em " + dia + "/" + mes + "/" + ano);
            if ((ano / 4) == 0 && (ano / 100) != 0) {
                bissexto = true;
            }
            if (mes == 2) {//fevereiro PROBLEMÁTICO :@
                if (bissexto) {
                    if ((dia + 7) > 29) {
                        dia = (dia + 7) - 29;
                        mes++;
                    }
                } else {
                    if ((dia + 7) > 28) {
                        dia = (dia + 7) - 28;
                        mes++;
                    }
                }
            }
            //meses com 31
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                if ((dia) + 7 > 31) {
                    dia = (dia + 7) - 31;
                    mes++;
                }
            }
            //meses com 30
            if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                if ((dia) + 7 > 30) {
                    dia = (dia + 7) - 30;
                    mes++;
                }
            }
            System.out.println("Livro " + livro + " deverá ser devolvido em: " + dia + "/" + mes + "/" + ano);
        } else {
            System.out.println("Livro" + livro + " não está disponível");
        }
    }

    public void devolver(Publicacao publication) {
        publication.setDisponivel(true);
    }

    //inserir um ou mais livros
    public void insereLivro(Livro[] livros) {
        listaPublicacoes.addAll(Arrays.asList(livros));
    }

    //inserir um ou mais artigos
    public void insereArtigo(Artigo[] artigos) {
        listaPublicacoes.addAll(Arrays.asList(artigos));
    }

    //insere um ou mais autores para livro
    public void insereAutor(ArrayList<Autor> autores, Livro livro) {
        for (int i = 0; i < autores.size(); i++) {
            livro.setListaAutores(autores);
        }
    }

    //insere lista de publicacoes referencias
    public void insereReferencias(Publicacao pub, ArrayList<Publicacao> referencias) {
        pub.setListaPubReference(referencias);
    }

    public void listaAutores() {
        for (int i = 0; i < listaPublicacoes.size(); i++) {
            listaPublicacoes.get(i).getListaAutore();

        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }
}
