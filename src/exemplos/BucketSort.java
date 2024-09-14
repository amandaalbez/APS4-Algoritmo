package exemplos;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    //teste
    // Função para executar o Bucket Sort
    public static void bucketSort(float[] arr) {
        int n = arr.length;

        // 1. Criar um número de baldes igual ao tamanho dao array
        ArrayList<Float>[] buckets = new ArrayList[n];

        // Inicializar os baldes
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        // 2. Distribuir os elementos nos baldes
        for (float num : arr) {
            int bucketIndex = (int) (num * n); // Calcula o índice do balde
            buckets[bucketIndex].add(num);
        }

        // 3. Ordenar cada balde individualmente
        for (ArrayList<Float> bucket : buckets) {
            Collections.sort(bucket);
        }

        // 4. Concatenar todos os baldes ordenados
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
            for (float num : bucket) {
                arr[index++] = num;
            }
        }
    }

    // Função principal para testar o Bucket Sort
    public static void main(String[] args) {
        float[] arr = {0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f};

        System.out.println("Array original:");
        for (float num : arr) {
            System.out.print(num + " ");
        }

        bucketSort(arr);

        System.out.println("\nArray ordenado:");
        for (float num : arr) {
            System.out.print(num + " ");
        }
    }
}