package sort;

import java.util.Arrays;

public class ArrayNumerosAleatorios {
    public static void main(String[] args) {

        // Aquí colocamos los 100 números aleatorios dentro de un array.
        int[] numerosAleatorios = {
            587, 254, 503, 818, 237, 215, 122, 653, 774, 202, 890, 657, 109, 859, 305, 789, 141, 788, 147, 598, 
            227, 133, 423, 947, 969, 27, 792, 572, 908, 339, 746, 243, 181, 279, 428, 96, 647, 545, 872, 174, 
            479, 934, 25, 931, 922, 678, 110, 292, 617, 104, 741, 726, 823, 503, 736, 581, 63, 852, 470, 121, 
            419, 866, 283, 328, 336, 454, 196, 461, 473, 77, 764, 612, 468, 855, 962, 798, 287, 25, 394, 204, 
            989, 293, 305, 361, 307, 154, 319, 803, 108, 538, 396, 227, 262, 949, 69, 123, 18, 255, 979, 493, 
            657, 581, 71
        };

        // Imprimir los números aleatorios para verificar
        System.out.println("Números aleatorios:");
        printArray(numerosAleatorios);
        System.out.println("\n");

        // Imprimir los números ordenados por Bubble Sort
        long startTime = System.nanoTime();
        int[] bubbleSorted = bubbleSort(numerosAleatorios);
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort:");
        printArray(bubbleSorted);
        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " ns\n");

        // Imprimir los números ordenados por Merge Sort
        startTime = System.nanoTime();
        int[] mergeSorted = mergeSort(numerosAleatorios);
        endTime = System.nanoTime();
        System.out.println("Merge Sort:");
        printArray(mergeSorted);
        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " ns\n");

        // Imprimir los números ordenados por Quick Sort
        startTime = System.nanoTime();
        int[] quickSorted = quickSort(numerosAleatorios, 0, numerosAleatorios.length - 1);
        endTime = System.nanoTime();
        System.out.println("Quick Sort:");
        printArray(quickSorted);
        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " ns\n");

        // Imprimir los números ordenados por AVL Tree Sort
        AVLTree avlTree = new AVLTree();
        startTime = System.nanoTime();
        for (int num : numerosAleatorios) {
            avlTree.insert(num);
        }
        System.out.println("AVL Tree Sort:");
        avlTree.inOrderTraversal();
        endTime = System.nanoTime();
        System.out.println("Tiempo de ejecución: " + (endTime - startTime) + " ns");
    }

    // Función para imprimir los arreglos
    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    // Función para Bubble Sort
    private static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    // Función para Merge Sort
    private static int[] mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);

            mergeSort(left);
            mergeSort(right);

            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }

            while (i < left.length) {
                arr[k++] = left[i++];
            }

            while (j < right.length) {
                arr[k++] = right[j++];
            }
        }
        return arr;
    }

    // Función para Quick Sort
    private static int[] quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
        return arr;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

}