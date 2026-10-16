package module3;

import java.util.Scanner;

class node {
	int data;
	node next; 
}

class Stack {
	private node top;

	public Stack() {
		this.top = null;
	}

	public void push(int x) { 
		node node = new node();

		if (node == null) {
			System.out.println("Heap Overflow");
			return;
		}

		System.out.println("Inserting " + x);
		node.data = x;
		node.next = top;
		top = node;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int peek() {
		if (!isEmpty()) {
			return top.data;
		} else {
			System.out.println("The stack is empty");
			return -1;
		}
	}

	public void pop() {
		if (top == null) {
			System.out.println("Stack Underflow");
			return;
		}

		System.out.println("Removing " + peek());
		top = top.next;
	}

	public void printStack() {
		System.out.print("Stack: ");
		node temp = top;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}

public class StackedLinkedList {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Stack stack = new Stack();
		int choice;

		do {
			System.out.println("\n===== STACK LINKED LIST MENU =====");
			System.out.println("1. Push (Insert)");
			System.out.println("2. Pop (Remove)");
			System.out.println("3. Peek (Top Element)");
			System.out.println("4. Check if Empty");
			System.out.println("5. Print Stack");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");

			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.print("Enter value to push: ");
				int val = sc.nextInt();
				stack.push(val);
				break;

			case 2:
				stack.pop();
				break;

			case 3:
				int top = stack.peek();
				if (top != -1)
					System.out.println("Top element is: " + top);
				break;

			case 4:
				System.out.println(stack.isEmpty() ? "Stack is EMPTY" : "Stack is NOT empty");
				break;

			case 5:
				stack.printStack();
				break;

			case 0:
				System.out.println("Exiting program...");
				break;

			default:
				System.out.println("Invalid choice.");
			}

		} while (choice != 0);

		sc.close();
	}
}
