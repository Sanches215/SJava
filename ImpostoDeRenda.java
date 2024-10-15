import java.util.Scanner;

public class ImpostoDeRenda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leitura dos dados fornecidos pelo usuário
        System.out.print("Renda anual com salário: ");
        double rendaSalarioAnual = sc.nextDouble();
        System.out.print("Renda anual com prestação de serviço: ");
        double rendaServicosAnual = sc.nextDouble();
        System.out.print("Renda anual com ganho de capital: ");
        double rendaCapitalAnual = sc.nextDouble();
        System.out.print("Gastos médicos: ");
        double gastosMedicos = sc.nextDouble();
        System.out.print("Gastos educacionais: ");
        double gastosEducacionais = sc.nextDouble();

        // Cálculo do imposto sobre salário
        double salarioMensal = rendaSalarioAnual / 12;
        double impostoSalario;
        if (salarioMensal < 3000) {
            impostoSalario = 0;
        } else if (salarioMensal < 5000) {
            impostoSalario = rendaSalarioAnual * 0.10;
        } else {
            impostoSalario = rendaSalarioAnual * 0.20;
        }

        // Cálculo do imposto sobre serviços e ganho de capital
        double impostoServicos = rendaServicosAnual * 0.15;
        double impostoCapital = rendaCapitalAnual * 0.20;

        // Cálculo do imposto bruto total
        double impostoBrutoTotal = impostoSalario + impostoServicos + impostoCapital;

        // Cálculo das deduções
        double maximoDedutivel = impostoBrutoTotal * 0.30;
        double gastosDedutiveis = Math.min(gastosMedicos + gastosEducacionais, maximoDedutivel);

        // Cálculo do imposto final devido
        double impostoFinal = impostoBrutoTotal - gastosDedutiveis;

        // Exibição do relatório
        System.out.println("\n### RELATÓRIO DE IMPOSTO DE RENDA ###");
        System.out.printf("* CONSOLIDADO DE RENDA:\n");
        System.out.printf("Imposto sobre salario: %.2f\n", impostoSalario);
        System.out.printf("Imposto sobre servicos: %.2f\n", impostoServicos);
        System.out.printf("Imposto sobre ganho de capital: %.2f\n", impostoCapital);
        System.out.printf("* DEDUCOES:\n");
        System.out.printf("Maximo dedutivel: %.2f\n", maximoDedutivel);
        System.out.printf("Gastos dedutiveis: %.2f\n", gastosDedutiveis);
        System.out.printf("* RESUMO:\n");
        System.out.printf("Imposto bruto total: %.2f\n", impostoBrutoTotal);
        System.out.printf("Abatimento: %.2f\n", gastosDedutiveis);
        System.out.printf("Imposto devido: %.2f\n", impostoFinal);

        sc.close();
    }
}
