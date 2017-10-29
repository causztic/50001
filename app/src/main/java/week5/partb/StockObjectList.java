package week5.partb;

import java.util.Scanner;

/**
 * Created by yaojie on 23/10/17.
 */

public class StockObjectList {

    class StockObject {
        private int header;
        private String value;
        private StockObject next;
        private StockObject prev;

        public int getHeader() {
            return header;
        }

        public void setHeader(int header) {
            this.header = header;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public StockObject getNext() {
            return next;
        }

        public void setNext(StockObject next) {
            this.next = next;
        }

        public StockObject getPrev() {
            return prev;
        }

        public void setPrev(StockObject prev) {
            this.prev = prev;
        }

        StockObject(String value){
            this.value = value;
            this.header = value.length();
            next = null;
            prev = null;
        }
    }

    private StockObject start;
    private StockObject end;
    private int size;

    public StockObjectList(){
        start = null;
        end = null;
        size = 0;
    }

    public void enterObject(String value){
        StockObject so = new StockObject(value);
        if (start == null){
            // there are no items
            start = so;
            end = so;
        } else {
            StockObject current = start;
            StockObject prev = null;
            while (current != null && current.getHeader() < so.getHeader()){
                // if bigger, go next
                prev = current;
                current = current.getNext();
            }
            if (prev == null){
                // first item
                so.setNext(current);
                current.setPrev(so);
                start = so;
            } else {
                prev.setNext(so);
                so.setPrev(prev);
                if (current == null){
                    // last item
                    end = so;
                } else {
                    // in the middle
                    so.setNext(current);
                    current.setPrev(so);
                }
            }

        }
        size++;
    }

    public void displayObject(int position){

        if (position > size){
            System.out.println("Position is bigger than size.");
        } else {
            int pointer = size;
            StockObject item = end;
            while (position != pointer){
                item = item.getPrev();
                pointer--;
            }
            System.out.println(item.getValue());
        }
    }

    public void dumpObjects(){
        StockObject s = start;
        System.out.print("Stock Object List = ");
        while (s != null){
            System.out.printf("%s: %d", s.getValue(), s.getHeader());
            s = s.getNext();
            if (s != null){
                System.out.print(" <-> ");
            }
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char ch = 'Y';
        /*  Perform list operations  */
        StockObjectList sol = new StockObjectList();
        System.out.println("\nStock Object List Operations\n");
        System.out.println("1. Enter Object");
        System.out.println("2. Display Object at Position");
        System.out.println("3. Dump Objects");
        System.out.println("4. isEmpty");

        do        {
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter String object to add to list");
                    sol.enterObject(scan.next());
                    sol.dumpObjects();
                    break;
                case 2:
                    System.out.println("Enter position to display object");
                    sol.displayObject(scan.nextInt());
                    break;
                case 3:
                    sol.dumpObjects();
                    break;
                case 4:
                    System.out.printf("Stock Object List is %s.\n", sol.isEmpty() ? "empty" : "not empty");
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
        } while (true);
    }

}
