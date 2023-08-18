package ada.exec;

import ada.model.Catalogo;
import ada.service.CatalogoService;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        CatalogoService catalogoService = new CatalogoService(catalogo);
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        while (!sair) {
            System.out.println("Escolha a opção desejada:");
            System.out.println("1 - Cadastrar Filme");
            System.out.println("2 - Cadastrar Ator");
            System.out.println("3 - Cadastrar Diretor");
            System.out.println("4 - Pesquisar Filme");
            System.out.println("5 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    catalogoService.cadastrarFilme();
                    break;
                case 2:
                    catalogoService.cadastrarAtor();
                    break;
                case 3:
                    catalogoService.cadastrarDiretor();
                    break;
                case 4:
                    catalogoService.pesquisarFilme();
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}