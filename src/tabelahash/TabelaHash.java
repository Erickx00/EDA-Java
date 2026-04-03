package tabelahash;

import java.util.LinkedList;

import java.util.LinkedList;

public class TabelaHash {

    private LinkedList<Aluno>[] tabela;
    private int tamanho;

    // Construtor
    public TabelaHash(int tamanho) {
        this.tamanho = tamanho;
        tabela = new LinkedList[tamanho];

        // Inicializa cada posição com uma lista
        for (int i = 0; i < tamanho; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    // Função HASH (mod)
    private int hash(int matricula) {
        return matricula % tamanho;
    }

    // Inserir valor
    public void inserirValor(int matricula, String nome) {
        int pos = hash(matricula);
        tabela[pos].add(new Aluno(matricula, nome));
    }

    // Buscar valor (retorna nome)
    public String pegarValor(int matricula) {
        int pos = hash(matricula);

        for (Aluno aluno : tabela[pos]) {
            if (aluno.getMatricula() == matricula) {
                return aluno.getNome();
            }
        }

        return null; // não encontrado
    }

    // Remover valor
    public void removerValor(int matricula) {
        int pos = hash(matricula);

        tabela[pos].removeIf(aluno -> aluno.getMatricula() == matricula);
    }
}
