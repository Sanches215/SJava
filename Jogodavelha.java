import java.util.Scanner;

public class Jogodavelha {
    private static char[][] tabuleiro = new char[3][3];
    private static char jogadorAtual = 'X'; // Começa com o jogador 'X'

    public static void main(String[] args) {
        inicializarTabuleiro();
        boolean jogoAtivo = true;

        try (Scanner scanner = new Scanner(System.in)) { // Try-with-resources
            while (jogoAtivo) {
                exibirTabuleiro();
                System.out.println("Jogador " + jogadorAtual + ", faça sua jogada.");
                System.out.print("Digite a linha (0-2): ");
                int linha = scanner.nextInt();
                System.out.print("Digite a coluna (0-2): ");
                int coluna = scanner.nextInt();

                if (coordenadaValida(linha, coluna)) {
                    tabuleiro[linha][coluna] = jogadorAtual;
                    if (verificarVencedor()) {
                        exibirTabuleiro();
                        System.out.println("Parabéns, jogador " + jogadorAtual + " venceu!");
                        jogoAtivo = false;
                    } else if (verificarEmpate()) {
                        exibirTabuleiro();
                        System.out.println("O jogo empatou!");
                        jogoAtivo = false;
                    } else {
                        trocarJogador();
                    }
                } else {
                    System.out.println("Jogada inválida. Tente novamente.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }

    private static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = ' ';
            }
        }
    }

    private static void exibirTabuleiro() {
        System.out.println("  0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            System.out.println();
            if (i < 2) System.out.println(" ---+---+---");
        }
    }

    private static boolean coordenadaValida(int linha, int coluna) {
        return linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == ' ';
    }

    private static boolean verificarVencedor() {
        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) ||
                (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual)) {
                return true;
            }
        }

        // Verifica diagonais
        if ((tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) ||
            (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual)) {
            return true;
        }

        return false;
    }

    private static boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void trocarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }
}
