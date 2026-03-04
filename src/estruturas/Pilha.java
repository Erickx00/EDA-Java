package estruturas;

/**
  Implementação de Pilha (Stack) usando array.
  Princípio LIFO (Last In, First Out).

  Operações principais:
   - push(elemento): empilha
   - pop(): desempilha e retorna o topo
   - peek(): consulta o topo sem remover
   - isEmpty(): verifica se está vazia
   - isFull(): verifica se está cheia
 */
public class Pilha<T> {

    private Object[] dados;
    private int topo;
    private int capacidade;

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.dados = new Object[capacidade];
        this.topo = -1;
    }

    /** Empilha um elemento no topo. */
    public void push(T elemento) {
        if (isFull()) {
            throw new RuntimeException("Pilha cheia! Não é possível empilhar.");
        }
        dados[++topo] = elemento;
        System.out.println("Empilhado: " + elemento);
    }

    /** Remove e retorna o elemento do topo. */
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia! Não é possível desempilhar.");
        }
        T elemento = (T) dados[topo];
        dados[topo--] = null;
        System.out.println("Desempilhado: " + elemento);
        return elemento;
    }

    /** Retorna o elemento do topo sem remover. */
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pilha vazia!");
        }
        return (T) dados[topo];
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == capacidade - 1;
    }

    public int tamanho() {
        return topo + 1;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Pilha: []";
        StringBuilder sb = new StringBuilder("Pilha (topo → base): [");
        for (int i = topo; i >= 0; i--) {
            sb.append(dados[i]);
            if (i > 0) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // ─── Exemplo de uso ────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Pilha de Inteiros ===");
        Pilha<Integer> pilha = new Pilha<>(5);

        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        System.out.println(pilha);

        System.out.println("Topo: " + pilha.peek());
        pilha.pop();
        System.out.println(pilha);

        // Exemplo prático: verificar parênteses balanceados
        System.out.println("\n=== Verificação de Parênteses ===");
        String expressao1 = "((a + b) * (c - d))";
        String expressao2 = "((a + b) * (c - d)";
        System.out.println(expressao1 + " → " + (verificaParenteses(expressao1) ? "Balanceado ✓" : "Desbalanceado ✗"));
        System.out.println(expressao2 + " → " + (verificaParenteses(expressao2) ? "Balanceado ✓" : "Desbalanceado ✗"));
    }

    /** Verifica se os parênteses de uma expressão estão balanceados. */
    public static boolean verificaParenteses(String expressao) {
        Pilha<Character> pilha = new Pilha<>(expressao.length());
        for (char c : expressao.toCharArray()) {
            if (c == '(') pilha.push(c);
            else if (c == ')') {
                if (pilha.isEmpty()) return false;
                pilha.pop();
            }
        }
        return pilha.isEmpty();
    }
}