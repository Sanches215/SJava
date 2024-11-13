import java.util.Scanner;

public class Lampada {
    private String marca;
    private String voltagem;
    private String tipo;
    private String modelo;
    private String cor;
    private double preco;
    private String garantia;
    private boolean ligada;

    // Construtor
    public Lampada(String marca, String voltagem, String tipo, String modelo, String cor, double preco, String garantia) {
        this.marca = marca;
        this.voltagem = voltagem;
        this.tipo = tipo;
        this.modelo = modelo;
        this.cor = cor;
        this.preco = preco;
        this.garantia = garantia;
        this.ligada = false; // Inicia desligada
    }

    // Getters e Setters
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getVoltagem() { return voltagem; }
    public void setVoltagem(String voltagem) { this.voltagem = voltagem; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public String getCor() { return cor; }
    public void setCor(String cor) { this.cor = cor; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public String getGarantia() { return garantia; }
    public void setGarantia(String garantia) { this.garantia = garantia; }

    public boolean isLigada() { return ligada; }
    
    // Métodos para ligar e desligar a lâmpada
    public void ligar() { ligada = true; }
    public void desligar() { ligada = false; }

    // Método para mostrar o status da lâmpada
    public void mostrarStatus() {
        System.out.println(">>> INÍCIO DO SOFTWARE DA LÂMPADA <<<");
        System.out.println("COR: " + cor);
        System.out.println("MARCA: " + marca);
        System.out.println("MODELO: " + modelo);
        System.out.println("VOLTAGEM: " + voltagem);
        System.out.println("TIPO: " + tipo);
        System.out.println("GARANTIA: " + garantia);
        System.out.printf("PREÇO – R$: %.2f\n", preco);
        System.out.println("STATUS: " + (ligada ? "Ligada" : "Desligada"));
    }

    public static void main(String[] args) {
        // Cria uma lâmpada com dados de exemplo
        Lampada lampada = new Lampada("Phillips", "100V", "LED", "P5589L18", "Amarela", 25.00, "24 meses");
        
        Scanner scanner = new Scanner(System.in);
        int opcao;
        
        do {
            lampada.mostrarStatus();
            System.out.println("Ligar/Desligar lâmpada? 0 – Sair / 1 – Sim / 2 – Não");
            opcao = scanner.nextInt();
            
            if (opcao == 1) {
                if (lampada.isLigada()) {
                    lampada.desligar();
                    System.out.println("# Lâmpada Desligada #");
                } else {
                    lampada.ligar();
                    System.out.println("# Lâmpada Ligada #");
                }
            } else if (opcao == 2) {
                System.out.println("# Lâmpada " + (lampada.isLigada() ? "Ligada" : "Desligada") + " #");
            }
        } while (opcao != 0);

        System.out.println("*** Você encerrou o software. ***");
        scanner.close();
    }
}
