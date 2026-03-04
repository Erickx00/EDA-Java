package ordenacao;

import java.util.Arrays;

/**
  Algoritmos de Ordenação implementados em Java.

  Algoritmos incluídos:
   - Bubble Sort → O(n²)
   - Selection Sort → O(n²)
   - Insertion Sort → O(n²) — melhor: O(n)
   - Merge Sort → O(n log n)
   - Quick Sort → O(n log n) médio, O(n²) pior caso
 */
public class AlgoritmosOrdenacao {

    // ─────────────────────────────────────────────────────────────────────────
    // BUBBLE SORT — O(n²)
    // Percorre o array repetidamente, trocando elementos adjacentes fora de ordem.
    // ─────────────────────────────────────────────────────────────────────────
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        int[] v = arr.clone();
        int trocas = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean houveTroca = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                    trocas++;
                    houveTroca = true;
                }
            }
            // Otimização: se não houve troca, array já está ordenado
            if (!houveTroca) break;
        }
        System.out.println("Bubble Sort → trocas: " + trocas);
        return v;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // SELECTION SORT — O(n²)
    // Seleciona o menor elemento e o coloca na posição correta a cada iteração.
    // ─────────────────────────────────────────────────────────────────────────
    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        int[] v = arr.clone();
        int trocas = 0;

        for (int i = 0; i < n - 1; i++) {
            int idxMinimo = i;
            for (int j = i + 1; j < n; j++) {
                if (v[j] < v[idxMinimo]) {
                    idxMinimo = j;
                }
            }
            if (idxMinimo != i) {
                int temp = v[i];
                v[i] = v[idxMinimo];
                v[idxMinimo] = temp;
                trocas++;
            }
        }
        System.out.println("Selection Sort → trocas: " + trocas);
        return v;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // INSERTION SORT — O(n²), melhor caso O(n)
    // Insere cada elemento na posição correta dentro da parte já ordenada.
    // Eficiente para arrays quase ordenados.
    // ─────────────────────────────────────────────────────────────────────────
    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        int[] v = arr.clone();
        int movimentos = 0;

        for (int i = 1; i < n; i++) {
            int chave = v[i];
            int j = i - 1;
            while (j >= 0 && v[j] > chave) {
                v[j + 1] = v[j];
                j--;
                movimentos++;
            }
            v[j + 1] = chave;
        }
        System.out.println("Insertion Sort → movimentos: " + movimentos);
        return v;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // MERGE SORT — O(n log n)
    // Divide o array ao meio recursivamente e então mescla as partes ordenadas.
    // ─────────────────────────────────────────────────────────────────────────
    public static int[] mergeSort(int[] arr) {
        int[] v = arr.clone();
        mergeSortAux(v, 0, v.length - 1);
        return v;
    }

    private static void mergeSortAux(int[] v, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = esquerda + (direita - esquerda) / 2;
            mergeSortAux(v, esquerda, meio);
            mergeSortAux(v, meio + 1, direita);
            mesclar(v, esquerda, meio, direita);
        }
    }

    private static void mesclar(int[] v, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(v, esquerda, L, 0, n1);
        System.arraycopy(v, meio + 1, R, 0, n2);

        int i = 0, j = 0, k = esquerda;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) v[k++] = L[i++];
            else                v[k++] = R[j++];
        }
        while (i < n1) v[k++] = L[i++];
        while (j < n2) v[k++] = R[j++];
    }

    // ─────────────────────────────────────────────────────────────────────────
    // QUICK SORT — O(n log n) médio, O(n²) pior caso
    // Escolhe um pivô, particiona o array em menores e maiores, e ordena recursivamente.
    // ─────────────────────────────────────────────────────────────────────────
    public static int[] quickSort(int[] arr) {
        int[] v = arr.clone();
        quickSortAux(v, 0, v.length - 1);
        return v;
    }

    private static void quickSortAux(int[] v, int baixo, int alto) {
        if (baixo < alto) {
            int pivo = particionar(v, baixo, alto);
            quickSortAux(v, baixo, pivo - 1);
            quickSortAux(v, pivo + 1, alto);
        }
    }

    private static int particionar(int[] v, int baixo, int alto) {
        int pivo = v[alto]; // último elemento como pivô
        int i = baixo - 1;

        for (int j = baixo; j < alto; j++) {
            if (v[j] <= pivo) {
                i++;
                int temp = v[i]; v[i] = v[j]; v[j] = temp;
            }
        }
        int temp = v[i + 1]; v[i + 1] = v[alto]; v[alto] = temp;
        return i + 1;
    }

    // ─────────────────────────────────────────────────────────────────────────
    // MAIN — comparação de todos os algoritmos
    // ─────────────────────────────────────────────────────────────────────────
    public static void main(String[] args) {
        int[] original = {64, 34, 25, 12, 22, 11, 90, 47, 3, 58};

        System.out.println("Array original:   " + Arrays.toString(original));
        System.out.println();

        System.out.println("Bubble Sort:    " + Arrays.toString(bubbleSort(original)));
        System.out.println("Selection Sort: " + Arrays.toString(selectionSort(original)));
        System.out.println("Insertion Sort: " + Arrays.toString(insertionSort(original)));
        System.out.println("Merge Sort:     " + Arrays.toString(mergeSort(original)));
        System.out.println("Quick Sort:     " + Arrays.toString(quickSort(original)));

        // ─── Benchmark de tempo ────────────────────────────────────────────
        System.out.println("\n=== Benchmark (10.000 elementos) ===");
        int[] grande = new java.util.Random().ints(10_000, 0, 100_000).toArray();
        benchmark("Bubble Sort",    grande, () -> bubbleSort(grande));
        benchmark("Selection Sort", grande, () -> selectionSort(grande));
        benchmark("Insertion Sort", grande, () -> insertionSort(grande));
        benchmark("Merge Sort",     grande, () -> mergeSort(grande));
        benchmark("Quick Sort",     grande, () -> quickSort(grande));
    }

    private static void benchmark(String nome, int[] arr, Runnable algoritmo) {
        long inicio = System.nanoTime();
        algoritmo.run();
        long fim = System.nanoTime();
        System.out.printf("%-15s → %6.2f ms%n", nome, (fim - inicio) / 1_000_000.0);
    }
}