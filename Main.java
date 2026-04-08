import java.util.Scanner;

public class Main {

    static int melhorPont = 0;

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean jogar = true;

        while (jogar) {
            titulo();
            narrativa();
            jogo(scanner);

            jogar = Restart(scanner);
        }

        scanner.close();
    }

    
    public static void titulo() {
        System.out.println(" ░▒▓██████▓▒░░▒▓█▓▒░      ░▒▓█▓▒░▒▓████████▓▒░▒▓███████▓▒░       ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓███████▓▒░▒▓████████▓▒░ ");
        System.out.println("░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░     ");
        System.out.println("░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░     ");
        System.out.println("░▒▓████████▓▒░▒▓█▓▒░      ░▒▓█▓▒░▒▓██████▓▒░ ░▒▓█▓▒░░▒▓█▓▒░      ░▒▓████████▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░     ");
        System.out.println("░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░     ");
        System.out.println("░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░     ");
        System.out.println("░▒▓█▓▒░░▒▓█▓▒░▒▓████████▓▒░▒▓█▓▒░▒▓████████▓▒░▒▓█▓▒░░▒▓█▓▒░      ░▒▓█▓▒░░▒▓█▓▒░░▒▓██████▓▒░░▒▓█▓▒░░▒▓█▓▒░ ░▒▓█▓▒░     ");
        System.out.println("                                                                                                                      ");
        System.out.println("                                                                                                                      ");
        System.out.println("\n        O c a s o  V a r g i n h a              \n");
    }

    
    public static void narrativa() {
        System.out.println();
        System.out.println();
        System.out.println();        
        
        textoLento("Varginha, Janeiro 1996.", 120);
        textoLento("Três jovens relataram ter visto um ser pequeno,", 120);
        textoLento("de pele verde e olhos grandes caindo perto de uma floresta escura.", 120);
        System.out.println();
        textoLento("Na floresta, as árvores estão numeradas de 1 a 100.", 120);
        textoLento("Descubra onde ele está.", 120);
        System.out.println();
    }

    
    public static void jogo(Scanner scanner) {

        int numero = gerarNumero();
        int guess = 0;
        int tentativa = 0;
        final int MAX_TENTATIVAS = 7;

        while (guess != numero && tentativa < MAX_TENTATIVAS) {
            System.out.println("Tentativa " + (tentativa + 1) + " de " + MAX_TENTATIVAS);

            guess = lerPalpite(scanner);
            tentativa++;

            if (guess != numero && tentativa < MAX_TENTATIVAS) {
                Palpitecheck(guess, numero);
            }
        }

        
        boolean venceu = (guess == numero);

        if (venceu) {
            System.out.println("Parabéns!! você achou o marciano. Agora ligue pro 190.");
        } else {
            System.out.println("O marciano fugiu. Ele estava na árvore: " + numero);
        }

        
        int pontuacao = calcularPontuacao(tentativa, venceu);

        System.out.println("Pontuação: " + pontuacao);

        atualizarRanking(pontuacao);
        mostrarRanking();
    }

    
    public static void atualizarRanking(int pontAtual) {
        if (pontAtual > melhorPont) {
            melhorPont = pontAtual;
            System.out.println(" NOVO RECORDE!!!");
        }
    }

    public static void mostrarRanking() {
        System.out.println();
        System.out.println(" Melhor pontuação até agora: " + melhorPont);
    }

    public static int calcularPontuacao(int tentativas, boolean venceu) {
        if (!venceu) return 0;

        int pontuacao = 100 - ((tentativas - 1) * 14);

        if (pontuacao < 0) {
            pontuacao = 0;
        }

        return pontuacao;
    }

    
    public static int lerPalpite(Scanner scanner) {
        System.out.println();
        System.out.print("Digite um número de 1 a 100: ");
        return scanner.nextInt();
    }

    
    public static int gerarNumero() {
        return (int) (Math.random() * 100) + 1;
    }

    public static void Palpitecheck(int guess, int numero) {
        if (guess < numero) {
            System.out.println("\nNão... muito baixo, tente de novo.\n");
        } else if (guess > numero) {
            System.out.println("\nMuito alto, tenta de novo.\n");
        }
    }

    
    public static boolean Restart(Scanner scanner) {
        System.out.println();
        System.out.print("Voltar no tempo e procurar de novo? (s/n): ");

        String resposta = scanner.next().toLowerCase();

        if (resposta.equals("s")) {
            System.out.println("\n Voltando no tempo...\n");
            return true;
        } else {
            System.out.println("\nEncerrando...");
            return false;
        }
    }

    
    public static void textoLento(String texto, int delay) {
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
