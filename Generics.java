import java.util.Arrays;

public class Generics {

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    T temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }

    public static <T extends Comparable<T>> void mergeSort(T[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        T[] left = Arrays.copyOfRange(arr, 0, mid);
        T[] right = Arrays.copyOfRange(arr, mid, arr.length);

        mergeSort(left);
        mergeSort(right);

        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) < 0) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Integer[] bubbleSortArr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Bubble Sort Array: " + Arrays.toString(bubbleSortArr));
        bubbleSort(bubbleSortArr);
        System.out.println("Sorted Bubble Sort Array: " + Arrays.toString(bubbleSortArr));

        Integer[] mergeSortArr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original Merge Sort Array: " + Arrays.toString(mergeSortArr));
        mergeSort(mergeSortArr);
        System.out.println("Sorted Merge Sort Array: " + Arrays.toString(mergeSortArr));
    }
}