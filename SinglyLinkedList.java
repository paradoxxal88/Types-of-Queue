package module3;

import java.util.Scanner;

public class SinglyLinkedList {

	class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
		}
	}

	Node head = null, tail = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SinglyLinkedList listImpl = new SinglyLinkedList();
		int choice;

		do {
			System.out.println("\n---- SINGLY LINKED LIST MENU ----");
			System.out.println("1. Add Node at End");
			System.out.println("2. Add Node at Start");
			System.out.println("3. Add Node at Certain Index");
			System.out.println("4. Remove Last Node");
			System.out.println("5. Remove First Node");
			System.out.println("6. Remove Node at Certain Index");
			System.out.println("7. Search Value");
			System.out.println("8. Search Value and Return Index");
			System.out.println("9. Print Linked List");
			System.out.println("0. Exit");
			System.out.print("Choose an option: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter value: ");
				listImpl.addNode(sc.nextInt());
				break;

			case 2:
				System.out.print("Enter value: ");
				listImpl.addNodeAtStart(sc.nextInt());
				break;

			case 3:
				System.out.print("Enter value: ");
				int val = sc.nextInt();
				System.out.print("Enter index: ");
				int idx = sc.nextInt();
				listImpl.addNodeAtCertainIndex(val, idx);
				break;

			case 4:
				listImpl.removeNode();
				break;

			case 5:
				listImpl.removeNodeAtStart();
				break;

			case 6:
				System.out.print("Enter index: ");
				listImpl.removeNodeAtCertainIndex(sc.nextInt());
				break;

			case 7:
				System.out.print("Enter target value: ");
				boolean found = listImpl.search(sc.nextInt());
				System.out.println(found ? "Value found." : "Value NOT found.");
				break;

			case 8:
				System.out.print("Enter target value: ");
				int index = listImpl.searchAndReturnIndex(sc.nextInt());
				if (index == -1)
					System.out.println("Value not found.");
				else
					System.out.println("Value found at index: " + index);
				break;

			case 9:
				listImpl.printLinkedList();
				break;

			case 0:
				System.out.println("Exiting program...");
				break;

			default:
				System.out.println("Invalid choice!");
			}

		} while (choice != 0);

		sc.close();
	}

	public void addNode(int val) {
		if (head == null) {
			Node temp = new Node(val);
			head = temp;
			tail = temp;
		} else {
			tail.next = new Node(val);
			tail = tail.next;
		}
	}

	public void addNodeAtStart(int val) {
		if (head == null) {
			Node temp = new Node(val);
			head = temp;
			tail = temp;
		} else {
			Node temp = new Node(val);
			temp.next = head;
			head = temp;
		}
	}

	public void addNodeAtCertainIndex(int val, int index) {
		Node temp = head;
		int count = 0;
		while (temp != null && ++count != index)
			temp = temp.next;
		Node node = new Node(val);
		node.next = temp.next;
		temp.next = node;
	}

	public void removeNode() {
		Node temp = head;
		while (temp.next != null && temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		tail = temp;
	}

	public void removeNodeAtStart() {
		head = head.next;
	}

	public void removeNodeAtCertainIndex(int index) {
		Node temp = head;
		int count = 0;
		while (temp != null && ++count != index)
			temp = temp.next;
		temp.val = temp.next.val;
		temp.next = temp.next.next;
	}

	public boolean search(int target) {
		Node temp = head;
		while (temp != null) {
			if (temp.val == target)
				return true;
			temp = temp.next;
		}
		return false;
	}

	public int searchAndReturnIndex(int target) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			if (temp.val == target)
				return count;
			temp = temp.next;
		}
		return -1;
	}

	public void printLinkedList() {
		System.out.println();
		Node temp = head;
		while (temp != null) {
			System.out.print(" " + temp.val);
			temp = temp.next;
		}
		System.out.println();
	}
}
