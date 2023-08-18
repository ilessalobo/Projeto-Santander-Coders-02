package ada.service;

import ada.enums.Genero;
import ada.model.Ator;
import ada.model.Catalogo;
import ada.model.Diretor;
import ada.model.Filme;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CatalogoService {
    private final Catalogo catalogo;

    public CatalogoService(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public void cadastrarFilme() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do filme: ");
        String nome = scanner.nextLine();
        LocalDate dataLancamento = null;
        while (dataLancamento == null) {
            System.out.println("Digite a data de lançamento do filme (formato: dd/mm/yyyy): ");
            String dataLancamentoStr = scanner.nextLine();
            try {
                dataLancamento = LocalDate.parse(dataLancamentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Por favor, digite novamente.");
            }
        }
        double orcamento = -1;
        while (orcamento < 0) {
            System.out.println("Digite o orçamento do filme: ");
            try {
                orcamento = scanner.nextDouble();
                if (orcamento < 0) {
                    System.out.println("Orçamento inválido. Por favor, digite novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Orçamento inválido. Por favor, digite novamente.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();
        System.out.println("Digite a descrição do filme: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite o nome do diretor do filme: ");
        String nomeDiretor = scanner.nextLine();
        Diretor diretor = buscarDiretor(nomeDiretor);
        if (diretor == null) {
            diretor = new Diretor(nomeDiretor);
            catalogo.getDiretores().add(diretor);
        }
        List<Ator> atores = new ArrayList<>();
        System.out.println("Digite os nomes dos atores do filme (separados por vírgula): ");
        String[] nomesAtores = scanner.nextLine().split(",");
        for (String nomeAtor : nomesAtores) {
            Ator ator = buscarAtor(nomeAtor.trim());
            if (ator == null) {
                ator = new Ator(nomeAtor.trim());
                catalogo.getAtores().add(ator);
            }
            atores.add(ator);
        }
        Genero genero = null;
        while (genero == null) {
            System.out.println("Escolha o gênero do filme:");
            Genero[] generos = Genero.values();
            for (int i = 0; i < generos.length; i++) {
                System.out.println((i + 1) + " - " + generos[i]);
            }
            int opcaoGenero = scanner.nextInt();
            scanner.nextLine();
            if (opcaoGenero < 1 || opcaoGenero > generos.length) {
                System.out.println("Opção inválida. Por favor, digite novamente.");
            } else {
                genero = generos[opcaoGenero - 1];
            }
        }
        Filme filme = new Filme(nome, dataLancamento, orcamento, descricao, diretor, atores, genero);
        catalogo.getFilmes().add(filme);
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do filme que deseja pesquisar: ");
        String nomeFilme = scanner.nextLine();
        Filme filmeEncontrado = buscarFilme(nomeFilme);

        if (filmeEncontrado == null) {
            System.out.println("Filme não encontrado.");
            return;
        }

        System.out.println("Nome: " + filmeEncontrado.getNome());
        System.out.println("Data de lançamento: " + filmeEncontrado.getDataLancamento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Orçamento: " + filmeEncontrado.getOrcamento());
        System.out.println("Descrição: " + filmeEncontrado.getDescricao());
        System.out.println("Diretor: " + filmeEncontrado.getDiretor().getNome());
        System.out.print("Atores: ");
        for (Ator ator : filmeEncontrado.getAtores()) {
            System.out.print(ator.getNome() + ", ");
        }
        System.out.println();
        System.out.println("Gênero: " + filmeEncontrado.getGenero());
    }

    private Filme buscarFilme(String nome) {
        String nomeNormalizado = normalizarString(nome);
        for (Filme filme : catalogo.getFilmes()) {
            String nomeFilmeNormalizado = normalizarString(filme.getNome());
            if (nomeFilmeNormalizado.contains(nomeNormalizado)) {
                return filme;
            }
        }
        return null;
    }

    private String normalizarString(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    private Ator buscarAtor(String nome) {
        for (Ator ator : catalogo.getAtores()) {
            if (ator.getNome().equalsIgnoreCase(nome)) {
                return ator;
            }
        }
        return null;
    }

    private Diretor buscarDiretor(String nome) {
        for (Diretor diretor : catalogo.getDiretores()) {
            if (diretor.getNome().equalsIgnoreCase(nome)) {
                return diretor;
            }
        }
        return null;
    }
}
