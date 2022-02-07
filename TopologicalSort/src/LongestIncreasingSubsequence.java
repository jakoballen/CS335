import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = new int[]{10,22,9,33,21,50,41,60,80};
        findLIS(arr);

        arr = new int[]{3,10,2,1,20};
        findLIS(arr);

        arr = new int[]{3,2};
        findLIS(arr);

        arr = new int[]{50,3,10,7,40,80};
        findLIS(arr);
    }

    /**
     * Find longest increasing subsequence in an array
     * @param arr input
     */
    public static void findLIS(int[] arr){
        Integer[] lis = new Integer[arr.length];
        for(int i = 0; i<arr.length; i++){
            lis[i] = findLIS(arr, i, false);
        }

        printOutput(arr, lis);
    }

    /**
     * Find longest increasing subsequence in an array starting at a given index
     * @param arr input array
     * @param index starting index
     * @param print determines if the LIS is printed or not
     * @return length of increasing subsequence starting at given index
     */
    private static int findLIS(int[] arr, int index, boolean print){
        int subsequenceLength = 1;
        int currentLargestElement = arr[index];
        ArrayList<Integer> lis = new ArrayList<>(); //store subsequence
        lis.add(arr[index]);
        for(int i = index; i < arr.length-1; i++){
            if(currentLargestElement < arr[i+1]){
                subsequenceLength++;
                currentLargestElement = arr[i+1];
                lis.add(currentLargestElement);
            }
        }
        if(print){
            System.out.print(lis.toString().replace("[", "{").replace("]", "}"));
        }
        return subsequenceLength;
    }

    /**
     * Print the output to the system
     * @param arr input array
     * @param lis lengths of subsequences
     */
    private static void printOutput(int[] arr, Integer[] lis){
        int max = Collections.max(Arrays.asList(lis));
        System.out.println("Input: arr[] = "+Arrays.toString(arr).replace("[", "{").replace("]", "}")+"\nOutput: Length of LIS = "+max+"");
        if(lisCount(lis, max)>1){
            System.out.print("The longest increasing subsequences are ");
            boolean first = true;
            for(int i = 0; i < lis.length; i++){
                if(lis[i] == max){
                    if(!first){
                        System.out.print(" and ");
                    }
                    findLIS(arr, i, true);
                    first = false;
                }
            }
        }else{
            System.out.print("The longest increasing subsequence is ");
            for(int i = 0; i < lis.length; i++){
                if(lis[i] == max){
                    findLIS(arr, i, true);
                }
            }
        }
        System.out.println("\n");
    }

    /**
     * Find number of longest increasing subsequences in an array
     * @param a array of lengths
     * @param max longest subsequence
     * @return number of longest increasing subsequences
     */
    private static int lisCount(Integer[] a, int max){
        int count = 0;
        for(Integer i : a){
            if(i == max){
                count++;
            }
        }
        return count;
    }
}
