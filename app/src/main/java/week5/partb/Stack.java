package week5.partb;

import java.util.Scanner;

/**
 * Created by yaojie on 22/10/17.
 */

public class Stack extends LinkedList {
    public Node top() {
        return end;
    }

    public void push(int value) {
        insertAtEnd(value);
    }

    public Node pop() {
        Node lastItem = null;
        if (size != 0){
            lastItem = end;
            deleteAtPos(size);
        }
        return lastItem;
    }

    public void displayStack() {
        display("Stack");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        Stack s = new Stack();
        System.out.println("Stack Test\n");
        char ch = 'Y';
        /*  Perform list operations  */

        System.out.println("Type n to exit.");
        System.out.println("\nStack Operations\n");
        System.out.println("1. Push");
        System.out.println("2. Top");
        System.out.println("3. Pop");
        System.out.println("4. isEmpty");
        System.out.println("5. DisplayStack");

        do        {
            try {
                int choice = scan.nextInt();
                switch (choice) {
                    case 1:
                        System.out.println("Enter integer element to push");
                        s.push(scan.nextInt());
                        s.displayStack();
                        break;
                    case 2:
                        if (s.getSize() > 0)
                            System.out.printf("Top item = %d\n", s.top().data);
                        s.displayStack();
                        break;
                    case 3:
                        if (s.getSize() > 0)
                            System.out.printf("Item popped = %d\n", s.pop().data);
                        s.displayStack();
                        break;
                    case 4:
                        System.out.printf("Stack is %s.\n", s.isEmpty() ? "empty" : "not empty");
                        break;
                    case 5:
                        s.displayStack();
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
