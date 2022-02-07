/**
 * Class QuickSort - sorts an integer array using quick sort
 *
 * @author Jakob Allen
 */

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int a[] = new int[]{16,19,56,5,8,3,2,6,7,1,4,9,11,98};  //Original input
        System.out.println("Input: " + Arrays.toString(a));
        QuickSort(a);
        System.out.println("Output: "+ Arrays.toString(a));
    }


    public static void QuickSort(int[] a){
        if(a.length > 1){
            //Keep track of the pivot
            int pivot = a[0];

            //Split the array based on the pivot
            int[] left = left(a, pivot);
            int[] right = right(a, pivot);

            //Sort the smaller arrays
            QuickSort(left);
            QuickSort(right);

            //Print both arrays
            System.out.println("Left: "+ Arrays.toString(left) +"\tRight: " + Arrays.toString(right));

            //Merge both sides of the array
            merge(a, left, right, pivot);
        }
    }

    /**
     * Returns the elements with a value lesser than the pivot
     */
    private static int[] left(int[]a, int pivot){
        //find the size for the new array
        int i = 0;
        for(int n : a){
            if(n < pivot){
                i++;
            }
        }

        //Copy elements with a lesser value than the pivot to the new array
        int[] left = new int[i];
        if(i>0) {
            int li = 0; //left index
            for (i = 0; i < a.length; i++) {
                if (a[i] < pivot) {
                    left[li] = a[i];
                    li++;
                }
            }
        }
        return left;
    }

    /**
     * Returns the elements with a value greater than the pivot
     */
    private static int[] right(int[]a, int pivot){
        //find the size for the new array
        int i = 0;
        for(int n : a){
            if(n > pivot){
                i++;
            }
        }

        //Copy elements with a greater value than the pivot to the new array
        int[] right = new int[i];
        if(i > 0) {
            int ri = 0; //right index
            for (i = 0; i < a.length; i++) {
                if (a[i] > pivot) {
                    right[ri] = a[i];
                    ri++;
                }
            }
        }
        return right;
    }

    /**
     * Merges the given left and right arrays into the given
     * result array.
     */
    private static void merge(int[] result, int[] left, int[] right, int pivot) {
        int i1 = 0;   // index counter for left array
        int i2 = 0;   // index counter for right array

        for (int i = 0; i < result.length; i++) {
            if(i < left.length) {           //take from left array until there aren't any more elements
                result[i] = left[i1];
                i1++;
            }else if(i == left.length){     //add pivot when left array has been copied
                result[i] = pivot;
            }else{                          //take from right array until there aren't any more elements
                result[i] = right[i2];
                i2++;
            }
        }
    }
}