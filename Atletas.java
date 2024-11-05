import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

class Atleta {
    String nome;
    String sexo;
    double altura;
    double peso;

    public Atleta(String nome, String sexo, double altura, double peso) {
        this.nome = nome;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
    }
}

public class RelatorioAtletas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // Configura o Scanner para usar ponto como separador decimal

        System.out.print("Digite a quantidade de atletas: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        List<Atleta> atletas = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Digite os dados do atleta " + (i + 1) + ":");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Sexo (M/F): ");
            String sexo = scanner.nextLine().toUpperCase();

            System.out.print("Altura (use ponto como separador decimal): ");
            double altura = scanner.nextDouble();

            System.out.print("Peso (use ponto como separador decimal): ");
            double peso = scanner.nextDouble();
            scanner.nextLine(); // Consumir nova linha

            atletas.add(new Atleta(nome, sexo, altura, peso));
        }

        // Calcular peso médio dos atletas
        double somaPeso = 0;
        for (Atleta atleta : atletas) {
            somaPeso += atleta.peso;
        }
        double pesoMedio = somaPeso / n;

        // Encontrar o atleta mais alto
        Atleta atletaMaisAlto = atletas.get(0);
        for (Atleta atleta : atletas) {
            if (atleta.altura > atletaMaisAlto.altura) {
                atletaMaisAlto = atleta;
            }
        }

        // Calcular a porcentagem de homens
        int totalHomens = 0;
        for (Atleta atleta : atletas) {
            if (atleta.sexo.equals("M")) {
                totalHomens++;
            }
        }
        double porcentagemHomens = (totalHomens * 100.0) / n;

        // Calcular altura média das mulheres
        double somaAlturaMulheres = 0;
        int totalMulheres = 0;
        for (Atleta atleta : atletas) {
            if (atleta.sexo.equals("F")) {
                somaAlturaMulheres += atleta.altura;
                totalMulheres++;
            }
        }
        double alturaMediaMulheres = totalMulheres > 0 ? (somaAlturaMulheres / totalMulheres) : 0;

        // Exibir o relatório
        System.out.printf("Peso médio dos atletas: %.2f kg\n", pesoMedio);
        System.out.println("Nome do atleta mais alto: " + atletaMaisAlto.nome);
        System.out.printf("Porcentagem de homens: %.2f%%\n", porcentagemHomens);
        if (totalMulheres > 0) {
            System.out.printf("Altura média das mulheres: %.2f m\n", alturaMediaMulheres);
        } else {
            System.out.println("Não há mulheres cadastradas.");
        }

        scanner.close();
    }
}
