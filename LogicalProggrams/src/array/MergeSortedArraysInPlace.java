package array;

import java.util.Arrays;

public class MergeSortedArraysInPlace {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 0, 0, 0};
        int[] arr2 = {2, 4, 6};
        int m = 3; // valid elements in arr1
        int n = arr2.length;

        int i = m - 1;       // pointer for arr1
        int j = n - 1;       // pointer for arr2
        int k = m + n - 1;   // pointer for merged position in arr1

        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k] = arr1[i];
                k--;
                i--;
            } else {
                arr1[k] = arr2[j];
                k--;
                j--;
            }
            System.out.println(Arrays.toString(arr1));
        }

        // Copy remaining elements from arr2 (if any)
        while (j >= 0) {
            arr1[k--] = arr2[j--];
        }

        System.out.println("Merged Sorted Array: " + Arrays.toString(arr1));
    }
}
