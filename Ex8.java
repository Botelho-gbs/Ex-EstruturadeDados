// Definição da classe Vet
class Vet {
    private int[] vet;

    public Vet(int[] array) {
        this.vet = array.clone(); // Clona o array para evitar modificar o original
    }

    // Método para imprimir o vetor (opcional)
    public void imprimir() {
        for (int num : vet) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Método de ordenação Bubble Sort
    public void bubbleSort() {
        int n = vet.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vet[j] > vet[j + 1]) {
                    // troca vet[j+1] e vet[j]
                    int temp = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = temp;
                }
            }
        }
    }

    // Método de ordenação Selection Sort
    public void selectionSort() {
        int n = vet.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (vet[j] < vet[minIndex]) {
                    minIndex = j;
                }
            }
            // troca vet[minIndex] e vet[i]
            int temp = vet[minIndex];
            vet[minIndex] = vet[i];
            vet[i] = temp;
        }
    }

    // Método de ordenação Insertion Sort
    public void insertionSort() {
        int n = vet.length;
        for (int i = 1; i < n; ++i) {
            int key = vet[i];
            int j = i - 1;

            // Move os elementos de vet[0..i-1], que são maiores que key, para uma posição à frente de sua posição atual
            while (j >= 0 && vet[j] > key) {
                vet[j + 1] = vet[j];
                j = j - 1;
            }
            vet[j + 1] = key;
        }
    }

    // Método para medir o tempo de execução da ordenação
    public long medirTempoOrdenacao(Runnable metodoOrdenacao) {
        long inicio = System.nanoTime();
        metodoOrdenacao.run(); // Executa o método de ordenação
        long fim = System.nanoTime();
        return fim - inicio; // Retorna o tempo de execução em nanossegundos
    }
}

// Classe principal para testar
public class Ex8 {
    public static void main(String[] args) {
        // Gerar um vet com 1000 elementos aleatórios
        int[] vet = new int[1000];
        for (int i = 0; i < vet.length; i++) {
            vet[i] = (int) (Math.random() * 1000); // Números aleatórios entre 0 e 999
        }

        Vet meuVet = new Vet(vet);

        // Medição do tempo para ordenação com Bubble Sort
        long tempoBubbleSort = meuVet.medirTempoOrdenacao(() -> meuVet.bubbleSort());
        System.out.println("Tempo de execução do Bubble Sort: " + tempoBubbleSort + " ns");

        // Medição do tempo para ordenação com Selection Sort
        long tempoSelectionSort = meuVet.medirTempoOrdenacao(() -> meuVet.selectionSort());
        System.out.println("Tempo de execução do Selection Sort: " + tempoSelectionSort + " ns");

        // Medição do tempo para ordenação com Insertion Sort
        long tempoInsertionSort = meuVet.medirTempoOrdenacao(() -> meuVet.insertionSort());
        System.out.println("Tempo de execução do Insertion Sort: " + tempoInsertionSort + " ns");
    }
}
