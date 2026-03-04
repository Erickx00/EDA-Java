package estruturas;

/**
  Implementação de Fila (Queue) usando array circular.
  Princípio FIFO (First In, First Out).

  Operações principais:
   - enqueue(elemento): enfileira
   - dequeue(): desenfileira e retorna o primeiro
   - peek(): consulta o primeiro sem remover
   - isEmpty(): verifica se está vazia
   - isFull(): verifica se está cheia
 */
public class Fila<T> {

    private Object[] dados;
    private int inicio;
    private int fim;
    private int tamanho;
    private int capacidade;

    public Fila(int capacidade) {
        this.capacidade = capacidade;
        this.dados = new Object[capacidade];
        this.inicio = 0;
        this.fim = -1;
        this.tamanho = 0;
    }

    /** Enfileira um elemento no final. */
    public void enqueue(T elemento) {
        if (isFull()) {
            throw new RuntimeException("Fila cheia! Não é possível enfileirar.");
        }
        fim = (fim + 1) % capacidade;
        dados[fim] = elemento;
        tamanho++;
        System.out.println("Enfileirado: " + elemento);
    }

    /** Remove e retorna o elemento do início da fila. */
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia! Não é possível desenfileirar.");
        }
        T elemento = (T) dados[inicio];
        dados[inicio] = null;
        inicio = (inicio + 1) % capacidade;
        tamanho--;
        System.out.println("Desenfileirado: " + elemento);
        return elemento;
    }

    /** Retorna o primeiro elemento sem remover. */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia!");
        }
        return (T) dados[inicio];
    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == capacidade;
    }

    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Fila: []";
        StringBuilder sb = new StringBuilder("Fila (início → fim): [");
        for (int i = 0; i < tamanho; i++) {
            sb.append(dados[(inicio + i) % capacidade]);
            if (i < tamanho - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // ─── Exemplo de uso ────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Fila de Strings ===");
        Fila<String> fila = new Fila<>(5);

        fila.enqueue("Tarefa A");
        fila.enqueue("Tarefa B");
        fila.enqueue("Tarefa C");
        System.out.println(fila);

        System.out.println("Próxima: " + fila.peek());
        fila.dequeue();
        System.out.println(fila);

        // Exemplo prático: simulação de fila de atendimento
        System.out.println("\n=== Fila de Atendimento ===");
        Fila<String> atendimento = new Fila<>(10);
        String[] clientes = {"João", "Maria", "Pedro", "Ana", "Lucas"};

        System.out.println("→ Clientes chegando:");
        for (String cliente : clientes) {
            atendimento.enqueue(cliente);
        }

        System.out.println("\n→ Atendendo clientes:");
        while (!atendimento.isEmpty()) {
            System.out.println("Atendendo: " + atendimento.dequeue());
        }
    }
}