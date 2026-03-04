package recursividade;

/**
  Exemplos clássicos de Recursividade.

  Recursividade = uma função que chama a si mesma.
  Toda função recursiva precisa de:
   1. Caso base → condição de parada
   2. Caso recursivo → chamada menor do problema
 */
public class Recursividade {

    // ─── Fatorial ─────────────────────────────────────────────────────────────
    // n! = n * (n-1)!   →  caso base: 0! = 1
    public static long fatorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n deve ser >= 0");
        if (n == 0) return 1;            // caso base
        return n * fatorial(n - 1);      // caso recursivo
    }

    // ─── Fibonacci ────────────────────────────────────────────────────────────
    // fib(n) = fib(n-1) + fib(n-2)  →  casos base: fib(0)=0, fib(1)=1
    public static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n deve ser >= 0");
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // ─── Fibonacci com memoização (otimizado) ─────────────────────────────────
    private static long[] memo = new long[100];

    public static long fibonacciMemo(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibonacciMemo(n - 1) + fibonacciMemo(n - 2);
        return memo[n];
    }

    // ─── Busca Binária Recursiva ───────────────────────────────────────────────
    // Pré-condição: array ordenado
    // Complexidade: O(log n)
    public static int buscaBinaria(int[] arr, int alvo, int esquerda, int direita) {
        if (esquerda > direita) return -1;          // caso base: não encontrado
        int meio = esquerda + (direita - esquerda) / 2;
        if (arr[meio] == alvo) return meio;          // caso base: encontrado
        if (arr[meio] < alvo)
            return buscaBinaria(arr, alvo, meio + 1, direita);
        else
            return buscaBinaria(arr, alvo, esquerda, meio - 1);
    }

    // ─── Potência Recursiva ───────────────────────────────────────────────────
    // base^exp — complexidade O(log exp) com exponenciação rápida
    public static long potencia(long base, int exp) {
        if (exp == 0) return 1;
        if (exp % 2 == 0) {
            long metade = potencia(base, exp / 2);
            return metade * metade;
        }
        return base * potencia(base, exp - 1);
    }

    // ─── Main ─────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=== Fatorial ===");
        for (int i = 0; i <= 10; i++) {
            System.out.printf("%2d! = %d%n", i, fatorial(i));
        }

        System.out.println("\n=== Fibonacci ===");
        System.out.print("Sequência: ");
        for (int i = 0; i <= 10; i++) {
            System.out.print(fibonacciMemo(i) + (i < 10 ? ", " : "\n"));
        }

        System.out.println("\n=== Busca Binária Recursiva ===");
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int alvo = 23;
        int idx = buscaBinaria(arr, alvo, 0, arr.length - 1);
        System.out.println("Procurando " + alvo + " → índice: " + idx);
        System.out.println("Procurando 99  → índice: " + buscaBinaria(arr, 99, 0, arr.length - 1));

        System.out.println("\n=== Potência ===");
        System.out.println("2^10 = " + potencia(2, 10));
        System.out.println("3^5  = " + potencia(3, 5));
    }
}