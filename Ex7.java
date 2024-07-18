import java.util.Arrays;

// Definição da classe Vetores
class Vetores {
    private int[] vetores;

    public Vetores(int[] array) {
        this.vetores = array;
    }

    // Pesquisa binária com laço de repetição
    public int pesquisaBinariaIterativa(int chave) {
        int esquerda = 0;
        int direita = vetores.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            if (vetores[meio] == chave)
                return meio;
            else if (vetores[meio] < chave)
                esquerda = meio + 1;
            else
                direita = meio - 1;
        }

        return -1; // Retorna -1 se não encontrar
    }

    // Pesquisa binária com recursão
    public int pesquisaBinariaRecursiva(int chave) {
        return pesquisaBinariaRecursiva(chave, 0, vetores.length - 1);
    }

    private int pesquisaBinariaRecursiva(int chave, int esquerda, int direita) {
        if (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            if (vetores[meio] == chave)
                return meio;
            else if (vetores[meio] < chave)
                return pesquisaBinariaRecursiva(chave, meio + 1, direita);
            else
                return pesquisaBinariaRecursiva(chave, esquerda, meio - 1);
        }

        return -1; // Retorna -1 se não encontrar
    }
}

// Classe principal para testar
public class Ex7 {
    public static void main(String[] args) {
        int[] vetor = new int[1000];
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = i; // Preenche o vetor com números de 0 a 999
        }

        Vetores meusVetores = new Vetores(vetor);

        // Medição do tempo para pesquisa no último elemento
        long inicio, fim;

        // Pesquisa binária iterativa
        inicio = System.nanoTime();
        int indiceIterativo = meusVetores.pesquisaBinariaIterativa(999);
        fim = System.nanoTime();
        long tempoIterativo = fim - inicio;

        // Pesquisa binária recursiva
        inicio = System.nanoTime();
        int indiceRecursivo = meusVetores.pesquisaBinariaRecursiva(999);
        fim = System.nanoTime();
        long tempoRecursivo = fim - inicio;

        // Exibindo os resultados
        System.out.println("Índice encontrado (Iterativo): " + indiceIterativo);
        System.out.println("Tempo de execução (Iterativo): " + tempoIterativo + " ns");

        System.out.println("Índice encontrado (Recursivo): " + indiceRecursivo);
        System.out.println("Tempo de execução (Recursivo): " + tempoRecursivo + " ns");
    }
}
