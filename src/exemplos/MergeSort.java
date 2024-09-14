package exemplos;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Array original:");
        printArray(array);
//teste
        mergeSort(array, 0, array.length - 1);

        System.out.println("\nArray ordenado:");
        printArray(array);
    }

    // Função principal que usa mergeSort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Ordena a primeira e a segunda metade
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Mescla as duas metades ordenadas
            merge(array, left, middle, right);
        }
    }

    // Função para mesclar duas sublistass
    public static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Cria arrays temporários
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia os dados para os arrays temporários
        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, middle + 1, R, 0, n2);

        // Mescla os arrays temporários de volta ao array original
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        // Copia os elementos restantes de L[], se houver
        while (i < n1) {
            array[k++] = L[i++];
        }

        // Copia os elementos restantes de R[], se houver
        while (j < n2) {
            array[k++] = R[j++];
        }
    }

    // Função auxiliar para imprimir o array
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
