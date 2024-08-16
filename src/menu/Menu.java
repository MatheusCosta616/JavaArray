package menu;

import java.util.Scanner;

import static model.Storage.*;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int cont = 1;
        while (cont == 1) {
            System.out.println("Seja bem-vindo ao cadastro de país nas Olímpiadas");
            System.out.println("""
                    O que você gostaria de fazer?
                    1. Cadastrar um país
                    2. Listar países
                    3. Buscar um país
                    4. Atualizar um país
                    5. Remover um país
                    0. Sair
                    """);
            String rest = scanner.nextLine();
            switch (rest) {
                case "1":
                    adicionar();
                    break;
                case "2":
                    listar();
                    break;
                case "3":
                    buscar();
                    break;
                case "4":
                    atualizar();
                    break;
                case "5":
                    remover();
                    break;
                case "0":
                    System.out.println("Saindo...");
                    cont = 0;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }
}
