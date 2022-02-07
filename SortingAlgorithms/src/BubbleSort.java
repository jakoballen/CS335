/**
 * Class BubbleSort - sorts an integer array using bubble sort
 *
 * @author Jakob Allen
 */

import java.util.Arrays;

public class BubbleSort {
    /**
     * Sorts an integer array using the bubble sort algorithm
     * @param a int array to be sorted
     */
    public static void bubbleSort(int[] a){
        int numSwaps = 0;   //number of swaps during this iteration
        for(int i = 0; i < a.length-1; i++){
            if(a[i] > a[i+1]){
                swap(a, i);
                ++numSwaps;
                SortingAlgorithmsGUI.appendTextField("[Swapped "+ i +" and "+(i+1)+"] "+ Arrays.toString(a)+"\n");
            }
        }
        if(numSwaps != 0){  //if the array is not yet sorted
            bubbleSort(a);
        }
    }

    /**
     * Swap the values at the given index and the next one
     * @param a integer array
     * @param i index in array
     */
    private static void swap(int[] a, int i){
        if(i < a.length-1) {    //avoid index out of bounds exception
            int temp = a[i];
            a[i] = a[i + 1];
            a[i + 1] = temp;
        }else{
            throw new IndexOutOfBoundsException("Invalid index given in \"swap\"");
        }
    }
}
