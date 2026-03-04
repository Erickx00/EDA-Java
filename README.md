# 📚 Estrutura de Dados e Algoritmos — Java

> Implementações em Java dos principais conteúdos de EDA, baseados nas aulas do IFPB.

---

## 🗂️ Estrutura do Projeto

```
eda-java/
└── src/
    ├── estruturas/
    │   ├── Pilha.java          # Stack (LIFO)
    │   └── Fila.java           # Queue (FIFO)
    ├── ordenacao/
    │   └── AlgoritmosOrdenacao.java  # Bubble, Selection, Insertion, Merge, Quick Sort
    └── recursividade/
        └── Recursividade.java  # Fatorial, Fibonacci, Busca Binária, Potência
```

---

## 📦 Estruturas de Dados

### 🗂️ Pilha (Stack) — `LIFO`
> **L**ast **I**n, **F**irst **O**ut — o último que entra é o primeiro que sai.

| Operação | Descrição | Complexidade |
|----------|-----------|:---:|
| `push(e)` | Empilha elemento | O(1) |
| `pop()` | Remove e retorna o topo | O(1) |
| `peek()` | Consulta o topo | O(1) |
| `isEmpty()` | Verifica se está vazia | O(1) |

**Uso prático incluído:** verificação de parênteses balanceados.

```java
Pilha<Integer> pilha = new Pilha<>(5);
pilha.push(10);
pilha.push(20);
pilha.pop(); // retorna 20
```

---

### 🚶 Fila (Queue) — `FIFO`
> **F**irst **I**n, **F**irst **O**ut — o primeiro que entra é o primeiro que sai.

| Operação | Descrição | Complexidade |
|----------|-----------|:---:|
| `enqueue(e)` | Enfileira elemento | O(1) |
| `dequeue()` | Remove e retorna o primeiro | O(1) |
| `peek()` | Consulta o primeiro | O(1) |
| `isEmpty()` | Verifica se está vazia | O(1) |

**Uso prático incluído:** simulação de fila de atendimento.

```java
Fila<String> fila = new Fila<>(10);
fila.enqueue("João");
fila.enqueue("Maria");
fila.dequeue(); // retorna "João"
```

---

## 🔢 Algoritmos de Ordenação

| Algoritmo | Melhor Caso | Caso Médio | Pior Caso | Estável? |
|-----------|:-----------:|:----------:|:---------:|:--------:|
| **Bubble Sort** | O(n) | O(n²) | O(n²) | ✅ |
| **Selection Sort** | O(n²) | O(n²) | O(n²) | ❌ |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | ✅ |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | ✅ |
| **Quick Sort** | O(n log n) | O(n log n) | O(n²) | ❌ |

### 🫧 Bubble Sort
Percorre o array repetidamente, "flutuando" o maior elemento para o final a cada passagem.

```java
int[] resultado = AlgoritmosOrdenacao.bubbleSort(new int[]{64, 34, 25, 12, 22});
// → [12, 22, 25, 34, 64]
```

### 🎯 Selection Sort
Seleciona o menor elemento não ordenado e o posiciona corretamente.

```java
int[] resultado = AlgoritmosOrdenacao.selectionSort(arr);
```

### 🃏 Insertion Sort
Insere cada elemento na posição certa dentro da parte já ordenada. Ótimo para dados quase ordenados.

```java
int[] resultado = AlgoritmosOrdenacao.insertionSort(arr);
```

### 🔀 Merge Sort
Divide o array ao meio recursivamente e mescla as partes ordenadas (dividir para conquistar).

```java
int[] resultado = AlgoritmosOrdenacao.mergeSort(arr);
```

### ⚡ Quick Sort
Escolhe um pivô, separa menores à esquerda e maiores à direita, e ordena recursivamente.

```java
int[] resultado = AlgoritmosOrdenacao.quickSort(arr);
```

---

## 🔄 Recursividade

Exemplos clássicos que demonstram os dois pilares da recursão:
- **Caso base** → condição de parada
- **Caso recursivo** → chamada com problema menor

| Algoritmo | Descrição | Complexidade |
|-----------|-----------|:---:|
| `fatorial(n)` | Calcula n! | O(n) |
| `fibonacci(n)` | Sequência de Fibonacci (com memoização) | O(n) |
| `buscaBinaria(arr, alvo)` | Busca binária recursiva em array ordenado | O(log n) |
| `potencia(base, exp)` | Exponenciação rápida | O(log n) |

---

## ▶️ Como Executar

### Compilar
```bash
# Na raiz do projeto
javac -d out src/**/*.java
```

### Executar cada classe
```bash
java -cp out estruturas.Pilha
java -cp out estruturas.Fila
java -cp out ordenacao.AlgoritmosOrdenacao
java -cp out recursividade.Recursividade
```

---

## 📖 Conceitos de Análise de Algoritmos

### Notação Big O — Complexidade de Tempo

| Notação | Nome | Exemplo |
|---------|------|---------|
| O(1) | Constante | Acesso a array por índice |
| O(log n) | Logarítmica | Busca binária |
| O(n) | Linear | Busca sequencial |
| O(n log n) | Linearítmica | Merge Sort, Quick Sort |
| O(n²) | Quadrática | Bubble Sort, Selection Sort |

> 📌 A notação **O(n)** representa o **pior caso** — quanto tempo o algoritmo leva no cenário mais desfavorável.

---

## 🛠️ Tecnologias

- **Java 11+**
- Sem dependências externas

---

## 📚 Referências

- Aulas de Estrutura de Dados e Algoritmos — IFPB / Prof.ª Renata França de Pontes
- Cormen, T. H. et al. **Introduction to Algorithms** (CLRS), 3ª ed.
- Sedgewick, R. **Algorithms**, 4ª ed.
