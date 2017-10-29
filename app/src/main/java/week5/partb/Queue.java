package week5.partb;

import java.util.Scanner;

/**
 * Created by yaojie on 22/10/17.
 */

public class Queue extends LinkedList{
    public void enqueue(int value){
        insertAtStart(value);
    }
    public Node dequeue(){
        Node item = end;
        deleteAtPos(size);
        return item;
    }
    public void displayQueue(){
        display("Queue");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        Queue q = new Queue();
        System.out.println("Stack Test\n");
        char ch = 'Y';
        /*  Perform list operations  */

        System.out.println("Type n to exit.");
        System.out.println("\nStack Operations\n");
        System.out.println("1. Enqueue");
        System.out.println("2. Dequeue");
        System.out.println("3. DisplayQueue");
        System.out.println("4. isEmpty");

        do        {
            try {
                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter integer element to enqueue");
                        q.enqueue(scan.nextInt());
                        q.displayQueue();
                        break;
                    case 2:
                        if (q.getSize() > 0)
                            System.out.printf("Item dequeued = %d\n", q.dequeue().data);
                        q.displayQueue();
                        break;
                    case 3:
                        q.displayQueue();
                        break;
                    case 4:
                        System.out.printf("Queue is %s.\n", q.isEmpty() ? "empty" : "not empty");
                        break;
                    default:
                        System.out.println("Wrong Entry \n ");
                        break;
                }
            } catch (Exception e) {
                ch = scan.next().charAt(0);
                if (ch != 'N' && ch != 'n')
                    System.out.println("Invalid input.");
            }
        } while (ch != 'N'&& ch != 'n');
    }
}
