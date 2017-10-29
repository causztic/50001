package extras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by yaojie on 19/9/17.
 */
public class Sort {
    public static int[] insertionSort(int[] input){

        for (int i = 1; i < input.length; i++){
            while (i > 0 && input[i] < input[i-1]){
                int temp = input[i-1];
                input[i-1] = input[i];
                input[i] = temp;
                i--;
            }
        }
        return input;
    }

    public static int[] quickSort(int[] A, int l, int r){
        int pivotval, pivot, prev_l, prev_r;

        prev_l = l;
        prev_r = r;
        pivotval = A[l];
        while (l < r) {
            while ((A[r] >= pivotval) && (l < r))
                r--;
            if (l != r) {
                A[l] = A[r];
                l++;
            }
            while ((A[l] <= pivotval) && (l < r))
                l++;
            if (l != r) {
                A[r] = A[l];
                r--;
            }
        }
        A[l] = pivotval;
        pivot = l;
        l = prev_l;
        r = prev_r;
        if (l < pivot)
            quickSort(A, l, pivot-1);
        if (r > pivot)
            quickSort(A, pivot+1, r);

        return A;
    }

    public static int[] mergeSort(int[] input){
        if (input.length == 1){
            return input;
        }
        int[] left = Arrays.copyOfRange(input, 0, input.length / 2);
        int[] right = Arrays.copyOfRange(input, input.length / 2, input.length);

        left = mergeSort(left);
        right = mergeSort(right);

        // System.out.printf("LEFT: %s \t RIGHT: %s \n", Arrays.toString(left), Arrays.toString(right));
        // loop through the left and right to merge
        int[] output = new int[left.length + right.length];

        int leftPointer = 0;
        int rightPointer = 0;
        int outputPointer = 0;

        while(leftPointer < left.length || rightPointer < right.length){

            if (leftPointer == left.length) {
                output[outputPointer] = right[rightPointer];
                rightPointer++;
            } else if (rightPointer == right.length){
                output[outputPointer] = left[leftPointer];
                leftPointer++;
            } else if (left[leftPointer] < right[rightPointer]){
                output[outputPointer] = left[leftPointer];
                leftPointer++;
            } else {
                output[outputPointer] = right[rightPointer];
                rightPointer++;
            }
            outputPointer++;
        }

        return output;
    }

    public static Integer[] countingSort(Integer[] items){
        Integer[] output = new Integer[items.length];
        List<Integer> listItems = Arrays.asList(items);
        int max = Collections.max(listItems);
        ArrayList<ArrayList<Integer>> keys = new ArrayList<>(max);
        for (int item: items){
            keys.get(item).add(item);
        }
        for (int i = 0, counter = 0; i < max; i++){
            for (int key: keys.get(i)){
                output[counter] = key;
                counter++;
            }
        }
        return output;
    }

    public static void main(String[] args){
        System.out.println("GENERATING RANDOM ARRAY: ");
        int[] input = new int[100000];
        for (int i = 0; i < 100000; i++){
            input[i] = (int) (Math.random()*20000) + 1;
        }

        int[] output = mergeSort(input);
        System.out.println("OUTPUT MERGE DONE");
        System.out.printf("OUTPUT MERGE: \t %s\n", Arrays.toString(output));
        int[] outputSlow = insertionSort(input);
        System.out.println("OUTPUT INSERTION DONE");
        System.out.printf("OUTPUT INSERTION: \t %s\n", Arrays.toString(outputSlow));
    }
}
