package APS;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Sorteio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao1;

        // Exibe o menu até que o usuário escolha a opção 4 (sair)
        do {
            System.out.println("Selecione o tipo de algoritmo de ordenação:");
            System.out.println("1 - InsertionSort");
            System.out.println("2 - MergeSort");
            System.out.println("3 - BucketSort");
            System.out.println("4 - Sair");
            System.out.print("Opção: ");

            try {
                opcao1 = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
                scanner.next(); // Limpa a entrada inválida
                continue;
            }

            if (opcao1 == 4) {
                System.out.println("Saindo do programa...");
                break;
            }

            int[] array = submenu(scanner); // Lê o array de números de arquivos

            if (array == null) {
                System.out.println("Erro ao ler o arquivo. Encerrando o programa...");
                return;
            }

            long startTime, endTime, duration;

            switch (opcao1) {
                case 1:
                    System.out.println("Você escolheu a opção 1: InsertionSort");
                    startTime = System.nanoTime();
                    insertionSort(array);
                    endTime = System.nanoTime();
                    duration = endTime - startTime;
                    System.out.println("Array ordenado com InsertionSort: " + Arrays.toString(array));
                    System.out.println("Tempo levado: " + (duration / 1_000_000.0) + " ms");
                    break;
                case 2:
                    System.out.println("Você escolheu a opção 2: MergeSort");
                    startTime = System.nanoTime();
                    mergeSort(array, 0, array.length - 1);
                    endTime = System.nanoTime();
                    duration = endTime - startTime;
                    System.out.println("Array ordenado com MergeSort: " + Arrays.toString(array));
                    System.out.println("Tempo levado: " + (duration / 1_000_000.0) + " ms");
                    break;
                case 3:
                    System.out.println("Você escolheu a opção 3: BucketSort");
                    startTime = System.nanoTime();
                    bucketSort(array, array.length);
                    endTime = System.nanoTime();
                    duration = endTime - startTime;
                    System.out.println("Array ordenado com BucketSort: " + Arrays.toString(array));
                    System.out.println("Tempo levado: " + (duration / 1_000_000.0) + " ms");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println(); // Linha em branco para espaçamento
        } while (true);

        scanner.close();
    }

    // Método para exibir um submenu e ler os arquivos com base na escolha
    public static int[] submenu(Scanner scanner) {
        int opcao2;
        String caminhoDiretorio = "C:\\Users\\amand\\IdeaProjects\\APS4-Algoritmo\\src\\APS\\";

        System.out.println("Selecione a quantidade de números:");
        System.out.println("1 - 1.000");
        System.out.println("2 - 5.000");
        System.out.println("3 - 10.000");
        System.out.print("Opção: ");

        try {
            opcao2 = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
            scanner.next(); // Limpa a entrada inválida
            return null;
        }

        String arquivo;
        switch (opcao2) {
            case 1:
                arquivo = "1000_numbers.txt";
                break;
            case 2:
                arquivo = "5000_numbers.txt";
                break;
            case 3:
                arquivo = "10000_numbers.txt";
                break;
            default:
                System.out.println("Opção inválida! Tente novamente.");
                return null;
        }

        // Lê os números do arquivo selecionado
        return lerArquivo(caminhoDiretorio + arquivo);
    }

    // Método para ler números de um arquivo de texto
    public static int[] lerArquivo(String nomeArquivo) {
        ArrayList<Integer> numeros = new ArrayList<>();

        try {
            // Abre o arquivo
            File file = new File(nomeArquivo);
            Scanner fileScanner = new Scanner(file);

            // Lê os números do arquivo
            while (fileScanner.hasNext()) {
                if (fileScanner.hasNextInt()) {
                    numeros.add(fileScanner.nextInt());
                } else {
                    fileScanner.next(); // Ignora elementos que não são inteiros
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: Arquivo " + nomeArquivo + " não encontrado.");
            return null;
        }

        // Converte ArrayList para array de int
        int[] array = new int[numeros.size()];
        for (int i = 0; i < numeros.size(); i++) {
            array[i] = numeros.get(i);
        }

        return array;
    }

    // Implementação do InsertionSort
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;

            // Move os elementos maiores para a frente
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    // Implementação do MergeSort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Ordena as metades
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Junta as duas metades
            merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++)
            leftArray[i] = array[left + i];
        for (int i = 0; i < n2; i++)
            rightArray[i] = array[mid + 1 + i];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Implementação do BucketSort
    public static void bucketSort(int[] array, int n) {
        if (n <= 0)
            return;

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        int maxVal = Arrays.stream(array).max().orElse(10000);

        for (int num : array) {
            int bucketIndex = (num * n) / (maxVal + 1);
            buckets[bucketIndex].add(num);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int num : buckets[i]) {
                array[index++] = num;
            }
        }
    }
}
