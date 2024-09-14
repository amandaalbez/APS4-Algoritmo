package exemplos;

public class InsertionSort {
    //teste
    // Método para realizar a ordenação por Insertion Sort
    public static void insertionSort(int[] array) {
        // Itera sobre o array a partir do segundo elemento
        for (int i = 1; i < array.length; i++) {
            int chave = array[i]; // O elemento atual a ser inserido na posição correta
            int j = i - 1;

            // Move os elementos do array que são maiores que a chave para umaa posição à frente
            while (j >= 0 && array[j] > chave) {
                array[j + 1] = array[j];
                j--;
            }

            // Insere a chave na posição correta
            array[j + 1] = chave;
        }
    }

    public static void main(String[] args) {
        // Cria um array de exemplo
        int[] array = {64, 25, 12, 22, 11};

        // Imprime o array antes da ordenação
        System.out.println("Array antes da ordenação:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Chama o método de ordenação
        insertionSort(array);

        // Imprime o array após a ordenação
        System.out.println("Array após a ordenação:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}