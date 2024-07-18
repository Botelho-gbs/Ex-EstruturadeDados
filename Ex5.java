import java.util.Scanner;

class Noh {
    Object data;
    Noh next;
    Noh prev;

    public Noh(Object data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LDE {
    private Noh head;
    private Noh tail;

    public LDE() {
        this.head = null;
        this.tail = null;
    }

    // Método para inserir um elemento no final da lista
    public void insert(Object data) {
        Noh newNode = new Noh(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Método para buscar um nó contendo o dado especificado
    public Noh search(Object data) {
        Noh current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Método para remover um nó contendo o dado especificado
    public boolean remove(Object data) {
        Noh toRemove = search(data);
        if (toRemove == null) {
            return false; // Elemento não encontrado
        }

        if (toRemove == head) {
            head = toRemove.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            toRemove.prev.next = toRemove.next;
        }

        if (toRemove == tail) {
            tail = toRemove.prev;
            if (tail != null) {
                tail.next = null;
            }
        } else {
            toRemove.next.prev = toRemove.prev;
        }

        return true; // Elemento removido com sucesso
    }

    // Método para imprimir a lista em ordem normal
    public void printListForward() {
        Noh current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Método para imprimir a lista em ordem reversa
    public void printListBackward() {
        Noh current = tail;
        while (current != null) {
            System.out.println(current.data);
            current = current.prev;
        }
    }
}

class Alunos {
    String nome;
    int matricula;

    public Alunos(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nome='" + nome + '\'' + ", matricula=" + matricula + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Aluno aluno = (Aluno) obj;
        return matricula == aluno.matricula && nome.equals(aluno.nome);
    }
}

public class Ex5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LDE listaDeAlunos = new LDE();

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

        System.out.println("Lista de Alunos (Ordem normal):");
        listaDeAlunos.printListForward();

        System.out.println("Lista de Alunos (Ordem reversa):");
        listaDeAlunos.printListBackward();

        // Remover um aluno
        System.out.print("Digite o nome do aluno a ser removido: ");
        String nome = scanner.nextLine();
        System.out.print("Digite a matrícula do aluno a ser removido: ");
        int matricula = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        boolean removed = listaDeAlunos.remove(new Aluno(nome, matricula));
        if (removed) {
            System.out.println("Aluno removido com sucesso!");
        } else {
            System.out.println("Aluno não encontrado.");
        }

        System.out.println("Lista de Alunos (Após remoção - Ordem normal):");
        listaDeAlunos.printListForward();

        System.out.println("Lista de Alunos (Após remoção - Ordem reversa):");
        listaDeAlunos.printListBackward();

        scanner.close();
    }
}
