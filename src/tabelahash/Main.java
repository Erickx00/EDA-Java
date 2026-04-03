package tabelahash;

public class Main {
    public static void main(String[] args) {

        TabelaHash tabela = new TabelaHash(10);

        tabela.inserirValor(123, "Erick");
        tabela.inserirValor(456, "Maria");
        tabela.inserirValor(133, "João"); // colisão possível

        System.out.println(tabela.pegarValor(123)); // Erick

        tabela.removerValor(123);

        System.out.println(tabela.pegarValor(123)); // null
    }
}
