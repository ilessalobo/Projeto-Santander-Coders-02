package ada.exec;

import ada.model.Ator;
import ada.model.Catalogo;
import ada.model.Filme;
import ada.service.CatalogoService;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        CatalogoService catalogoService = new CatalogoService(catalogo);
        Scanner scan = new Scanner(System.in);
        boolean sair = false;
        while (!sair) {
            System.out.println("Escolha a opção desejada:");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Cadastrar Ator");
            System.out.println("3 - Cadastrar Diretor");
            System.out.println("4 - Pesquisar Filme");
            System.out.println("5 - Sair");
            int opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1 -> catalogoService.cadastrarFilme();
                case 2 -> catalogoService.cadastrarAtor();
                case 3 -> catalogoService.cadastrarDiretor();
                case 4 -> catalogoService.pesquisarFilme();
                case 5 -> sair = true;
                default -> System.out.println("Opção inválida!");
            }
            if (!sair) {
                exibirCatalogo(catalogo);
            }
        }
    }

    private static void exibirCatalogo(Catalogo catalogo) {
        System.out.println("Catálogo de filmes:");
        for (Filme filme : catalogo.getFilmes()) {
            System.out.println("=====================================================================================");
            System.out.println("Nome: " + filme.getNome());
            System.out.println("Data de lançamento: " + filme.getDataLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
            System.out.println("Orçamento: " + filme.getOrcamento());
            System.out.println("Descrição: " + filme.getDescricao());
            System.out.println("Diretor: " + filme.getDiretor().getNome());
            System.out.print("Atores: ");
            for (Ator ator : filme.getAtores()) {
                System.out.print(ator.getNome() + ", ");
            }
            System.out.println();
            System.out.println("Gênero: " + filme.getGenero());
            System.out.println("=====================================================================================");
        }
    }
}