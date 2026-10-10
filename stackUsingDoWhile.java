import java.util.Scanner;

class BrowserHistory {
    private String[] pages;
    private int top = -1;

    BrowserHistory(int size) {
        pages = new String[size];
    }

    void visit(String url) {
        if (top == pages.length - 1) {
            System.out.println("History full! Cannot open " + url);
            return;
        }
        pages[++top] = url;
        System.out.println("Opened: " + url);
    }

    void back() {
        if (top <= 0) {
            System.out.println("No previous page to go back to.");
            return;
        }
        String closed = pages[top];
        pages[top--] = null;
        System.out.println("Closed: " + closed);
        System.out.println("Back on: " + pages[top]);
    }

    void current() {
        if (top == -1) System.out.println("No page open.");
        else System.out.println("Current page: " + pages[top]);
    }

    void showHistory() {
        if (top == -1) {
            System.out.println("History is empty.");
            return;
        }
        System.out.println("History (latest first):");
        for (int i = top; i >= 0; i--) {
            System.out.println((i == top ? "  -> " : "     ") + pages[i]);
        }
    }
}

public class stackUsingDoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter history capacity: ");
        int size = sc.nextInt();
        sc.nextLine();

        BrowserHistory b = new BrowserHistory(size);
        int choice;

        do {
            System.out.println("\n=== STACK: Browser History ===");
            System.out.println("1. Visit page");
            System.out.println("2. Back");
            System.out.println("3. Current page");
            System.out.println("4. Show history");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter URL: ");
                    b.visit(sc.nextLine());
                    break;
                case 2:
                    b.back();
                    break;
                case 3:
                    b.current();
                    break;
                case 4:
                    b.showHistory();
                    break;
                case 0:
                    System.out.println("Browser closed.");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}