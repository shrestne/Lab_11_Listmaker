import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<String> myArrList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String choice;

        do {
            displayMenu();
            choice = SafeInput.getRegExString(in, "Enter a choice: ", "[AaDdIiPpQq]");
            choice = choice.toUpperCase();

            switch (choice) {
                case "A":
                    addItem(in);
                    break;
                case "D":
                    deleteItem(in);
                    break;
                case "I":
                    insertItem(in);
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in, "Are you sure you want to quit?")) {
                        System.out.println("Exiting...");
                    } else {
                        choice = "";
                    }
                    break;
            }
        } while (!choice.equals("Q"));

        in.close();
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("I - Insert an item into the list");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit the program");
        printList();
    }

    private static void addItem(Scanner sc) {
        String item = SafeInput.getNonZeroLenString(sc, "Enter the item to add: ");
        myArrList.add(item);
    }

    private static void deleteItem(Scanner sc) {
        printListWithNumbers();
        int index = SafeInput.getRangedInt(sc, "Enter the item number to delete: ", 1, myArrList.size());
        myArrList.remove(index - 1);
    }

    private static void insertItem(Scanner sc) {
        printListWithNumbers();
        int index = SafeInput.getRangedInt(sc, "Enter the position number to insert the item: ", 1, myArrList.size() + 1);
        String item = SafeInput.getNonZeroLenString(sc, "Enter the item to insert: ");
        myArrList.add(index - 1, item);
    }

    private static void printList() {
        System.out.println("\nCurrent List:");
        for (String item : myArrList) {
            System.out.println(item);
        }
    }

    private static void printListWithNumbers() {
        System.out.println("\nCurrent List:");
        for (int i = 0; i < myArrList.size(); i++) {
            System.out.println((i + 1) + ": " + myArrList.get(i));
        }
    }
}