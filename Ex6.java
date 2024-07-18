import java.util.Random;

public class Ex6 {
    private int[] vetor;
    private int tamanho;

    public Ex6(int tamanho) {
        this.tamanho = tamanho;
        this.vetor = new int[tamanho];
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            this.vetor[i] = random.nextInt(10000); // Gera números aleatórios entre 0 e 9999
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public int getElemento(int index) {
        if (index >= 0 && index < tamanho) {
            return vetor[index];
        }
        throw new IndexOutOfBoundsException("Índice fora dos limites do vetor");
    }

    // Método recursivo para encontrar o maior elemento
    public int encontrarMaiorRecursivo(int index) {
        if (index == tamanho - 1) {
            return vetor[index];
        }
        int maior = encontrarMaiorRecursivo(index + 1);
        return Math.max(vetor[index], maior);
    }

    // Método iterativo para encontrar o maior elemento
    public int encontrarMaiorIterativo() {
        int maior = vetor[0];
        for (int i = 1; i < tamanho; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        return maior;
    }

    public static void main(String[] args) {
        int tamanhoVetor = 1000;
        Ex6 tadVetor = new Ex6(tamanhoVetor);

        // Medir o tempo do método recursivo
        long startTimeRecursivo = System.nanoTime();
        int maiorRecursivo = tadVetor.encontrarMaiorRecursivo(0);
        long endTimeRecursivo = System.nanoTime();
        long durationRecursivo = endTimeRecursivo - startTimeRecursivo;
        System.out.println("Maior elemento (Recursivo): " + maiorRecursivo);
        System.out.println("Tempo de execução (Recursivo): " + durationRecursivo + " nanosegundos");

        // Medir o tempo do método iterativo
        long startTimeIterativo = System.nanoTime();
        int maiorIterativo = tadVetor.encontrarMaiorIterativo();
        long endTimeIterativo = System.nanoTime();
        long durationIterativo = endTimeIterativo - startTimeIterativo;
        System.out.println("Maior elemento (Iterativo): " + maiorIterativo);
        System.out.println("Tempo de execução (Iterativo): " + durationIterativo + " nanosegundos");
    }
}
