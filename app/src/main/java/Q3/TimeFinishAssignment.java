package Q3;

import java.util.ArrayList;
import java.util.Collections;

public class TimeFinishAssignment {

    public static void main(String[] args) {
        ArrayList<Integer> listOfAssignment = new ArrayList<>();
        listOfAssignment.add(15);
        listOfAssignment.add(10);
        listOfAssignment.add(20);

        System.out.println(computeTimeFinish(listOfAssignment));
    }



    public static int computeTimeFinish(ArrayList<Integer> l) {
        // sort the list to ascending order.
        // for terms to compare, for every item, take a last one, then take the first one.
        // go for the smallest guy to increase the probability first as he will take
        // the bigger numbers

        int sum = 0;
        Collections.sort(l);
        int[] peoples = new int[3];
        peoples[0] = l.size() / 3;
        peoples[1] = (l.size() - peoples[0]) / 2;
        peoples[2] = (l.size() - peoples[0]) / 2;
        int position = 0;

        while (l.size() > 0){
            int count = 0;
            int total = 0;

            while (peoples[position] > 0){

                if (l.size() == 0){
                    break;
                }

                if (count % 2 == 0) {
                    total += l.get(l.size() - 1);
                    l.remove(l.size() - 1);
                } else {
                    total += l.get(0);
                    l.remove(0);
                }
                peoples[position]--;
                count++;
            }
            if (total > sum){
                sum = total;
            }
            position++;
        }

        return sum;
    }



}
