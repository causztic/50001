package week2.homework;

/**
 * Created by yaojie on 14/9/17.
 */
public class Pset1 {

    public static boolean isAllCharacterUnique(String sIn) {
        if (sIn.length() > 256)
            // definitely will have duplicates
            return false;

        boolean[] values = new boolean[256];
        for (int i = 0; i < sIn.length(); i++){
            int item = (int) sIn.charAt(i);
            if (!values[item]){
                // if it does not exist, set it
                values[item] = true;
            } else {
                // it exists, return false
                return false;
            }
        }
        return true;
    }

    public static boolean isPermutation(String sIn1, String sIn2) {
        if (sIn1.length() != sIn2.length())
            // if different length, it is not a permutation.
            return false;

        int[] items = new int[256];

        for (int i = 0; i < sIn1.length(); i++) {
            items[sIn1.charAt(i)]++;
            items[sIn2.charAt(i)]--;
            // for every item in string1, add. for every item in string2, subtract.
            // at the end of the loop, it is a permutation if all the values are 0.
        }

        for (int i = 0; i < items.length; i++){
            // check if any items are non-zero. if there are non-zeroes, it is not a permutation.
            if (items[i] != 0)
                return false;
        }

        return true;
    }
}

class TestPset1 {
    public static void main(String[] args) {
        System.out.println(Pset1.isAllCharacterUnique("abcdefghijklmnopqrstuvABC"));
        System.out.println(Pset1.isAllCharacterUnique("abcdefgghijklmnopqrstuvABC"));
        System.out.println(Pset1.isPermutation("@aba", "aa@b"));
        System.out.println(Pset1.isPermutation("abcd", "bcdA"));
    }
}
