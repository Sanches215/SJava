import java.util.Scanner;

public class Bar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leitura dos dados fornecidos pelo usuário
        System.out.print("Sexo (M/F): ");
        char sexo = sc.next().charAt(0);
        System.out.print("Quantidade de cervejas: ");
        int cervejas = sc.nextInt();
        System.out.print("Quantidade de refrigerantes: ");
        int refrigerantes = sc.nextInt();
        System.out.print("Quantidade de espetinhos: ");
        int espetinhos = sc.nextInt();

        // Definição dos preços
        double precoIngresso = (sexo == 'M' || sexo == 'm') ? 10 : 8;
        double precoCerveja = 5.0;
        double precoRefrigerante = 3.0;
        double precoEspetinho = 7.0;
        double precoCouvert = 4.0;

        // Cálculo do consumo
        double consumo = (cervejas * precoCerveja) + (refrigerantes * precoRefrigerante) + (espetinhos * precoEspetinho);

        // Verificação do couvert artístico
        if (consumo > 30) {
            precoCouvert = 0.0;
        }

        // Cálculo do valor total a pagar
        double valorTotal = consumo + precoCouvert + precoIngresso;

        // Exibição do relatório
        System.out.println("\nRELATÓRIO:");
        System.out.printf("Consumo = R$ %.2f\n", consumo);
        if (precoCouvert == 0) {
            System.out.println("Isento de Couvert");
        } else {
            System.out.printf("Couvert = R$ %.2f\n", precoCouvert);
        }
        System.out.printf("Ingresso = R$ %.2f\n", precoIngresso);
        System.out.printf("Valor a pagar = R$ %.2f\n", valorTotal);

        sc.close();
    }
}
