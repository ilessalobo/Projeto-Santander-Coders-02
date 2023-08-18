package ada.service;

import ada.model.Ator;
import ada.model.Catalogo;
import ada.model.Diretor;

import java.util.Scanner;

public class CatalogoService {
    private Catalogo catalogo;

    public CatalogoService(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public void cadastrarFilme() {
    }

    public void cadastrarAtor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do ator: ");
        String nome = scanner.nextLine();
        Ator ator = new Ator(nome);
        catalogo.getAtores().add(ator);
    }

    public void cadastrarDiretor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do diretor: ");
        String nome = scanner.nextLine();
        Diretor diretor = new Diretor(nome);
        catalogo.getDiretores().add(diretor);
    }

    public void pesquisarFilme() {
    }
}
