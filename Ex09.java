public class Ex09 implements Ex9 {
    private int nElemFila;
    private int inicio;
    private Object[] vetFila;

    public Ex09(int tamFila) {  // Constructor
        this.nElemFila = 0;
        this.inicio = 0;
        this.vetFila = new Object[tamFila];
    }

    @Override
    public boolean add(Object info) {  // Method to insert into the queue
        if (this.nElemFila == vetFila.length) {
            System.out.println("Queue capacity exhausted");
            return false;
        }
        int fim = (this.inicio + this.nElemFila) % this.vetFila.length;
        this.vetFila[fim] = info;
        this.nElemFila++;
        return true;
    }

    @Override
    public boolean remove() {  // Method to remove from the queue
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return false;
        }
        this.inicio = (this.inicio + 1) % this.vetFila.length;
        this.nElemFila--;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return this.nElemFila == 0;
    }

    @Override
    public int size() {
        return this.nElemFila;
    }

    // Method to print the queue
    public void imprimeFila() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int count = 0;
        int i = this.inicio;
        while (count < this.nElemFila) {
            System.out.print(this.vetFila[i] + " ");
            i = (i + 1) % this.vetFila.length;
            count++;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ex09 fila = new Ex09(5);  // Queue size 5
        fila.add(1);
        fila.add(2);
        fila.add(3);
        fila.imprimeFila();  // Prints: 1 2 3
        fila.remove();
        fila.imprimeFila();  // Prints: 2 3
        fila.add(4);
        fila.add(5);
        fila.add(6);
        fila.imprimeFila();  // Prints: 2 3 4 5 6
        fila.remove();
        fila.imprimeFila();  // Prints: 3 4 5 6
        fila.add(7);
        fila.imprimeFila();  // Prints: 3 4 5 6 7
    }
}
