/**
 * Class MergeSort - sorts an integer array using merge sort
 *
 * @author Jakob Allen
 */

import java.util.Arrays;

public class MergeSort {
    /**
     * Sorts an integer array using the merge sort algorithm
     * @param a int array to be sorted
     */
    public static void mergeSort(int[] a) {
        if (a.length > 1) {
            // split array into two halves
            int[] left = leftHalf(a);
            int[] right = rightHalf(a);
            SortingAlgorithmsGUI.appendTextField("[Left Size = "+left.length+"]"+Arrays.toString(left)+"[Right Size = "+right.length+"]"+Arrays.toString(right)+"\n");

            // recursively sort each half
            mergeSort(left);
            mergeSort(right);
            
            // merge the sorted halves into a sorted whole
            merge(a, left, right);
            SortingAlgorithmsGUI.appendTextField("[Array After Merge] "+Arrays.toString(a)+"\n");
        }
    }

    /**
     * Returns the first half of the given array.
     */
    private static int[] leftHalf(int[] a) {
        int size1 = a.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = a[i]; //copy to new array
        }

        return left;
    }
    
    /**
     * Returns the second half of the given array.
     */
    private static int[] rightHalf(int[] a) {
        int size1 = a.length / 2;
        int size2 = a.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = a[i + size1];    //copy to new array
        }

        return right;
    }

    /**
     * Merges the given left and right arrays into the given
     * result array.
     */
    private static void merge(int[] result, int[] left, int[] right) {
        int i1 = 0;   // index counter for left array
        int i2 = 0;   // index counter for right array
        
        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && 
                    left[i1] <= right[i2])) {
                result[i] = left[i1];    // take from left
                i1++;
            } else {
                result[i] = right[i2];   // take from right
                i2++;
            }
        }
    }
}
