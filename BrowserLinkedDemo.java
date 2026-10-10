import java.util.Scanner;

class Node {
    String url;
    Node next;

    Node(String url) {
        this.url = url;
        this.next = null;
    }
}

class BrowserHistory {
    private Node top = null;   // top of stack = current page
    private int count = 0;

    void visit(String url) {
        Node n = new Node(url);
        n.next = top;          // new node points to old top
        top = n;               // new node becomes top
        count++;
        System.out.println("Opened: " + url);
    }

    void back() {
        if (top == null || top.next == null) {
            System.out.println("No previous page to go back to.");
            return;
        }
        System.out.println("Closed: " + top.url);
        top = top.next;
        count--;
        System.out.println("Back on: " + top.url);
    }

    void current() {
        if (top == null) System.out.println("No page open.");
        else System.out.println("Current page: " + top.url);
    }

    void showHistory() {
        if (top == null) {
            System.out.println("History is empty.");
            return;
        }
        System.out.println("History (latest first), total " + count + ":");
        Node temp = top;
        while (temp != null) {
            System.out.println((temp == top ? "  -> " : "     ") + temp.url);
            temp = temp.next;
        }
    }
}

public class BrowserLinkedDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BrowserHistory b = new BrowserHistory();
        int choice;

        do {
            System.out.println("\n=== STACK (Linked List): Browser History ===");
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

