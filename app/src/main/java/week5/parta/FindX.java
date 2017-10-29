package week5.parta;

/**
 * Created by jit_biswas on 10/7/2017.
 */
public class FindX {
    private int visitnumber = 0;
    public FindX () {
        visitnumber++;
    }

    public int getVisitNumber() {
        return visitnumber;
    }
    public int findX(int x, int[] A) {
        visitnumber++;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (A[i] == x) return i;
        }
        return -1;
    }
}
