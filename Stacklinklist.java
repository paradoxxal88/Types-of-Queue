package module3;

import java.util.*;

// Stack implemented using Linked List
class StackLinkedList {

    // Private inner Node class
    private class Node {
        int data;      // integer data
        Node next;     // pointer to the next node

        // Constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top; // top of stack

    // Constructor
    public StackLinkedList() {
        this.top = null;
    }

    // Push operation
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // Pop operation
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }

    // Print stack
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }

        System.out.print("Stack (Top to Bottom): TOP -> ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("NULL");
    }
}

// Main class
public class Stacklinklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackLinkedList stack = new StackLinkedList();
        int choice = 0;

        while (choice != 5) {
            System.out.println("\n****** Stack Linked List Menu ******");
            System.out.println("1. Push (Add an element)");
            System.out.println("2. Pop (Remove an element)");
            System.out.println("3. Peek (View top element)");
            System.out.println("4. Print Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter value to push: ");
                        int value = scanner.nextInt();
                        stack.push(value);
                        System.out.println(value + " was pushed to the stack.");
                        break;
                    case 2:
                        try {
                            int poppedValue = stack.pop();
                            System.out.println("Popped: " + poppedValue);
                        } catch (EmptyStackException e) {
                            System.out.println("Stack Underflow! The stack is empty.");
                        }
                        break;
                    case 3:
                        try {
                            int topValue = stack.peek();
                            System.out.println("Top element is: " + topValue);
                        } catch (EmptyStackException e) {
                            System.out.println("The stack is empty.");
                        }
                        break;
                    case 4:
                        stack.printStack();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
        scanner.close(); //Close the scanner 
    }
}