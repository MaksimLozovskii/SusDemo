package Demo;

import java.util.Scanner;

public class Menu {
	private String items[];
	private Scanner input;

	public Menu(String data[]) {
		this.items = data;
		this.input = new Scanner(System.in);
	}
	private void display() {
		for(int option=1; option<=items.length; option++) {
			System.out.println(option + ". " + items[option-1] );
		}
		System.out.println();
	}
	public int getUserChoice() {
		boolean validated = false;
		int value = 0;
		do {
			try {
				display();
				System.out.print("Enter Selection: ");
				value = input.nextInt();
				if (value >= 1 && value <= items.length) {
					validated = true;
				}
				else {
					System.out.println("\nPlease enter number between 1 and " +items.length + "\n");
				}
			} catch (Exception error){
				System.out.println("\nInvalid Response - Try Again\n");
				input.nextLine();
			}
		} while (validated != true);
		return value;
	}
}
