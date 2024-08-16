package model;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Storage {
    static PaisModel[] paises = new PaisModel[10];
    static Scanner scanner = new Scanner(System.in);
    static int indice = 0;

    public static void adicionar() {
        System.out.println("Qual é o nome do país?");
        String nome = scanner.nextLine();

        int medalhas = -1;
        while (medalhas < 0) {
            System.out.println("Quantas medalhas este país ganhou na competição?");
            try {
                medalhas = scanner.nextInt();
                if (medalhas < 0) {
                    System.out.println("Número de medalhas não pode ser negativo. Por favor, insira um número válido.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira apenas números.");
                scanner.next();
            }
        }
        scanner.nextLine();

        String classificacao = "";
        while (!classificacao.equals("s") && !classificacao.equals("n")) {
            System.out.println("Este país está classificado aos próximos jogos? (s/n)");
            classificacao = scanner.nextLine().toLowerCase();
            if (!classificacao.equals("s") && !classificacao.equals("n")) {
                System.out.println("Resposta inválida. Por favor, responda apenas com 's' ou 'n'.");
            }
        }
        boolean realClassificacao = classificacao.equals("s");

        PaisModel paisAdicionado = new PaisModel(nome, medalhas, realClassificacao);

        paises[indice++] = paisAdicionado;

        System.out.println("PAÍS CADASTRADO COM SUCESSO");
    }

    public static void listar() {
        int indiceLocal = 0;
        for (PaisModel pais : paises) {
            if (pais != null) {
                System.out.println("Índice: " + indiceLocal + ", Nome: " + pais.getNome() + ", Medalhas: " + pais.getNumeroDeMedalhas() + ", Competidor: " + pais.isCompetidor());
                indiceLocal++;
            }
        }
    }

    public static void buscar() {
        System.out.println("Digite o nome do país para buscar:");
        String nomeBusca = scanner.nextLine();

        for (int i = 0; i < indice; i++) {
            if (paises[i] != null && paises[i].getNome().equalsIgnoreCase(nomeBusca)) {
                System.out.println("País encontrado: " + paises[i].toString());
                return;
            }
        }
        System.out.println("O país não pode ser encontrado.");
    }

    public static void atualizar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o índice do país que deseja atualizar:");
        int indiceAtualizar = scanner.nextInt();
        scanner.nextLine();

        if (indiceAtualizar >= 0 && indiceAtualizar < indice) {
            System.out.println("Digite o novo nome do país:");
            String novoNome = scanner.nextLine();

            int novaMedalhas = -1;
            while (novaMedalhas < 0) {
                System.out.println("Digite o novo número de medalhas:");
                try {
                    novaMedalhas = scanner.nextInt();
                    if (novaMedalhas < 0) {
                        System.out.println("Número de medalhas não pode ser negativo. Por favor, insira um número válido.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, insira apenas números.");
                    scanner.next();
                }
            }
            scanner.nextLine();

            String novaClassificacao = "";
            while (!novaClassificacao.equals("s") && !novaClassificacao.equals("n")) {
                System.out.println("Este país está classificado aos próximos jogos? (s/n)");
                novaClassificacao = scanner.nextLine().toLowerCase();
                if (!novaClassificacao.equals("s") && !novaClassificacao.equals("n")) {
                    System.out.println("Resposta inválida. Por favor, responda apenas com 's' ou 'n'.");
                }
            }
            boolean novaClassificacaoBool = novaClassificacao.equals("s");

            PaisModel paisAtualizado = new PaisModel(novoNome, novaMedalhas, novaClassificacaoBool);

            paises[indiceAtualizar] = paisAtualizado;

            System.out.println("País atualizado com sucesso!");
        } else {
            System.out.println("Índice inválido. Não foi possível atualizar o país.");
        }
    }

    public static void remover() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o índice do país que deseja remover:");
        int indiceRemover = scanner.nextInt();
        scanner.nextLine();

        if (indiceRemover >= 0 && indiceRemover < indice) {
            for (int i = indiceRemover; i < indice - 1; i++) {
                paises[i] = paises[i + 1];
            }
            paises[indice - 1] = null;
            indice--;

            System.out.println("País removido com sucesso!");
        } else {
            System.out.println("Índice inválido. Não foi possível remover o país.");
        }
    }
}


