package module3;

import java.util.*;

abstract class WaterTank {
	public abstract void watertank();

	public abstract void addWater(float gallons);

	public abstract void removeWater(float gallons);

	public abstract float currentLevel();

	public abstract boolean isFull();

	public abstract boolean isEmpty();
}

public class Module3 extends WaterTank {
	static Scanner console = new Scanner(System.in);
	float level = (float) 0.00;

	public void watertank(){
		level = 10000;
	}

	public void addWater(float gallons) {
		level = level + gallons;
	}

	public void removeWater(float gallons) {
		level = level - gallons;
	}

	public float currentLevel() {
		return level;
	}

	public boolean isFull() {
		if (level == 10000)
			return true;
		else
			return false;
	}

	public boolean isEmpty() {
		if (level == 0.00)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		WaterTank Tank = new Module3();
		int choice;
		char Ans;
		float gallons;
		do {
			System.out.println("Water Tank Maximum Capacity: 10,000 gallons of Water ");
			System.out.println("Water Tank Current Level: " + Tank.currentLevel() + " gallons of water");
			System.out.println("Water Tank Empty: " + Tank.isEmpty());
			System.out.println("WaterTank Full: " + Tank.isFull());
			System.out.println("\n\n");
			System.out.print("MENU OPTIONS\n");
			System.out.print("[1] ADD WATER \n");
			System.out.print("[2] REMOVE WATER \n");
			System.out.print("[3] Exit \n");
			System.out.print("Select <1,2,3> : ");
			choice = console.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Water Tank Current Level: " + Tank.currentLevel() + " gallons of water");
				System.out.print("How many of gallons of water will you add?: ");
				gallons = console.nextFloat();
				if (gallons + Tank.currentLevel() > 10000)
					System.out.println("Water tank will overflow. You exceed the limit.");
				else
					Tank.addWater(gallons);
				break;
			case 2:
				System.out.println("Water Tank Current Level: " + Tank.currentLevel() + " gallons of water");
				System.out.print("How many of gallons of water will you removed?: ");
				gallons = console.nextFloat();
				if (Tank.currentLevel() - gallons < 0)
					System.out.println("No more water in the tank.");
				else
					Tank.removeWater(gallons);
				break;
			case 3:
				System.exit(0);
			}
			System.out.print("\n\n");
			System.out.print("Try again? Press Y or y: ");
			Ans = console.next().charAt(0);
		} while (Ans == 'y' || Ans == 'Y');
	}
}
