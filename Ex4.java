import java.util.Scanner;

// Classe Node para representar um nó na lista
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// Classe Ld para representar a lista simplesmente encadeada
class Ld<T> {
    private Node<T> head;

    public Ld() {
        this.head = null;
    }

    // Método para inserir um elemento no final da lista
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Método para imprimir os elementos da lista
    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

// Classe Aluno para representar um aluno
class Aluno {
    String nome;
    int matricula;

    public Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome='" + nome + '\'' + ", matricula=" + matricula + '}';
    }
}

// Classe principal para testar a implementação
public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ld<Aluno> listaDeAlunos = new Ld<>();

        while (true) {
            System.out.print("Digite o nome do aluno (ou 'sair' para terminar): ");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                break;
            }

            System.out.print("Digite a matrícula do aluno: ");
            int matricula = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            listaDeAlunos.insert(new Aluno(nome, matricula));
        }

        System.out.println("Lista de Alunos:");
        listaDeAlunos.printList();

        scanner.close();
    }
}
