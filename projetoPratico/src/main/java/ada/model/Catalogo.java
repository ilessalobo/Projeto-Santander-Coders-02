package ada.model;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Filme> filmes;
    private List<Ator> atores;
    private List<Diretor> diretores;

    public Catalogo() {
        this.filmes = new ArrayList<>();
        this.atores = new ArrayList<>();
        this.diretores = new ArrayList<>();
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public List<Diretor> getDiretores() {
        return diretores;
    }

    public void setDiretores(List<Diretor> diretores) {
        this.diretores = diretores;
    }
}