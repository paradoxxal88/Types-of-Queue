package module3;

import java.util.Scanner;

class Queue {
	private int front, rear, capacity;
	private int[] queue;

	Queue(int size) {
		front = rear = 0;
		capacity = size;
		queue = new int[capacity];
	}

	void queueEnqueue(int item) {
		if (rear == capacity) {
			System.out.printf("\nQueue is full\n");
			return;
		}
		queue[rear] = item;
		rear++;
	}

	int queueDequeue() {
		if (front == rear) {
			System.out.printf("\nQueue is empty\n");
			return Integer.MIN_VALUE;
		}
		int dequeued = queue[front];
		front++;
		return dequeued;
	}

	void queueDisplay() {
		if (front == rear) {
			System.out.printf("Queue is Empty\n");
			return;
		}
		for (int i = front; i < rear; i++) {
			System.out.printf("%d", queue[i]);
			if (i < rear - 1) {
				System.out.printf("-->");
			}
		}
		System.out.println();
	}

	int queueFront() {
		if (front == rear) {
			System.out.printf("Queue is Empty\n");
			return Integer.MIN_VALUE;
		}
		return queue[front];
	}
}

public class Non_Circular_Queue {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the size of the queue: ");
		int size = scanner.nextInt();
		Queue q = new Queue(size);

		while (true) {
			System.out.println("\n1. Enqueue");
			System.out.println("2. Dequeue");
			System.out.println("3. Display Queue");
			System.out.println("4. Display Front Element");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter the element to enqueue: ");
				int element = scanner.nextInt();
				q.queueEnqueue(element);
				q.queueDisplay();
				break;
			case 2:
				q.queueDequeue();
				q.queueDisplay();
				break;
			case 3:
				System.out.println("Queue:");
				q.queueDisplay();
				break;
			case 4:
				System.out.println("Front Element of the queue: " + q.queueFront());
				q.queueDisplay();
				break;
			case 5:
				System.out.println("Exiting...");
				scanner.close();
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
