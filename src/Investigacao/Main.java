package Investigacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Grafo<String> apartamento = new Grafo();

        apartamento.adicionarVertice("Sala", "Pistas:\n" +
                "- Um vaso quebrado estava próximo ao sofá.\n" +
                "- Havia marcas de discussão no ambiente.\n" +
                "- Um pedaço de colar prata foi encontrado perto da mesa.");

        apartamento.adicionarVertice("Cozinha", "Pistas:\n" +
                "- Uma faca havia sido lavada recentemente.\n" +
                "- Copos quebrados estavam espalhados no chão.\n" +
                "- Impressões digitais foram encontradas na bancada.");

        apartamento.adicionarVertice("Banheiro", "Pistas:\n" +
                "- Fios de cabelo castanho estavam presos no ralo.\n" +
                "- Um lenço preto molhado estava no lixo.\n" +
                "- O espelho parecia ter sido limpo às pressas.");

        apartamento.adicionarVertice("Quarto", "Pistas:\n" +
                "- Marcas de luta foram encontradas perto da cama.\n" +
                "- Um óculos quebrado estava debaixo do armário.\n" +
                "- O celular da vítima havia desaparecido.");

        apartamento.adicionarVertice("Estúdio", "Pistas:\n" +
                "- Um casaco preto estava jogado no chão.\n" +
                "- A câmera de segurança havia sido desligada.\n" +
                "- Um colar prata foi encontrado próximo ao computador.");

        String[] comuns = new String[]{"Sala"};

        for(int i = 0; i < comuns.length; ++i) {
            for(int j = i + 1; j < comuns.length; ++j) {
                apartamento.conectarComodos(comuns[i], comuns[j], true);
            }
        }

        apartamento.conectarComodos("Quarto", "Estúdio", true);
        apartamento.conectarComodos("Quarto", "Banheiro", true);
        apartamento.conectarComodos("Sala", "Quarto", true);
        apartamento.conectarComodos("Sala", "Cozinha", true);

        Vertice localAtual = apartamento.getVertice("Sala");
        int pistasEncontradas = 0;
        System.out.println("\n------------------------------------------------------");
        System.out.println("=== INVESTIGAÇÃO: O ASSASSINATO DE ELENA GILBERT ===");
        System.out.println("\n------------------------------------------------------");

        System.out.println("Na noite de domingo, Elena Gilbert participou de um encontro no apartamento com amigos e conhecidos da universidade." +
                " Durante a noite, vários desentendimentos aconteceram, principalmente entre Elena e Evie," +
                " após uma discussão intensa sobre segredos pessoais e ciúmes antigos.\n" +
                "Horas depois da discussão, Elena foi encontrada morta no quarto do apartamento. Todos os presentes passaram a ser suspeitos!\n");

        while (true){
            System.out.println("\n----------------------------------");
            System.out.println("Local: " + (String)localAtual.getComodo());
            System.out.println("Observação: " + localAtual.getDescricaoPista());
            System.out.println("\nEscolha sua próxima ação:");
            ArrayList<Aresta<String>> conexoes = localAtual.getArestasSaida();

            for(int i = 0; i < conexoes.size(); ++i) {
                System.out.println((i + 1) + " - Ir para " + (String)((Aresta)conexoes.get(i)).getFim().getComodo());
            }

            System.out.println("0 - ACUSAR SUSPEITO");

            try {
                int escolha = leitor.nextInt();

                if (escolha == 0) {
                    System.out.println("\n=== QUEM É O CULPADO? ===");
                    System.out.println("1 - Marie Potter (Cabelo Castanho, Usa óculos, Roupa Preta, Estatura Alto, Acessorio colar prata)");
                    System.out.println("2 - Evie Prescott (Cabelo Vermelho, Usa óculos, Roupa Jaqueta Preta, Estatura Média, Acessório colar prata)");
                    System.out.println("3 - Bryan Morgan (Cabelo Preto, Roupa Preta, Estatura Média, Acessório relógio )");
                    System.out.println("4 - Claudio Benossi (Cabelo Branco, Roupa Verde, Estatura Baixa, Acessório fone de fio)");
                    System.out.println("5 - Matthew Smith (Cabelo Preto, Usa óculos, Roupa Vermelha, Estatura Alta, Acessório Brinco)");

                    while (true) {
                        try {
                            int culpado = leitor.nextInt();

                            if (culpado < 1 || culpado > 5) {
                                System.out.println("\n[ERRO] Escolha inválida!");
                                System.out.println("Digite um número entre 1 e 5.");
                                continue;
                            }

                            switch (culpado) {
                                case 1:
                                    System.out.println("\n[SUCESSO] Você prendeu a Maria!");
                                    System.out.println("Após juntar todas as pistas espalhadas pelos cômodos, " +
                                            "descobriu-se que Maria matou Elena e tentou aproveitar a briga entre Elena e Evie para despistar a investigação.");
                                    break;
                                default:
                                    System.out.println("\n[ERRO] Você condenou um inocente!");
                                    System.out.println("O verdadeiro culpado fugiu. Você foi exonerado do cargo de detetive.");
                            }

                            leitor.close();
                            return;

                        } catch (InputMismatchException e) {
                            System.out.println("Entrada inválida! Digite apenas números.");
                            leitor.next();
                        }
                    }

                } else if (escolha >= 1 && escolha <= conexoes.size()) {
                    localAtual = ((Aresta)conexoes.get(escolha - 1)).getFim();
                } else {
                    System.out.println("Caminho inválido!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Digite apenas números.");
                leitor.next();
            }
        }
    }
}