import java.util.Scanner;
class Node {
    String name;
    Node next;

    Node(String name) {
        this.name = name;
        this.next = null;
    }
}

class TicketCounter {
    private Node front = null;   // first person in line (served first)
    private Node rear = null;    // last person in line (new people join here)
    private int count = 0;

    void join(String name) {
        Node n = new Node(name);
        if (rear == null) {      // line was empty
            front = rear = n;
        } else {
            rear.next = n;       // link after the last person
            rear = n;
        }
        count++;
        System.out.println(name + " joined the line.");
    }

    void serve() {
        if (front == null) {
            System.out.println("No one in line.");
            return;
        }
        System.out.println("Ticket given to: " + front.name);
        front = front.next;
        if (front == null) {     // line became empty
            rear = null;
        }
        count--;
    }

    void showLine() {
        if (front == null) {
            System.out.println("Line is empty.");
            return;
        }
        System.out.print("Line (" + count + "): ");
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.name + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class TicketLinkedDemo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketCounter t = new TicketCounter();
        int choice;

        do {
            System.out.println("\n=== QUEUE (Linked List): Ticket Counter ===");
            System.out.println("1. Join line");
            System.out.println("2. Serve ticket");
            System.out.println("3. Show line");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    t.join(sc.nextLine());
                    break;
                case 2:
                    t.serve();
                    break;
                case 3:
                    t.showLine();
                    break;
                case 0:
                    System.out.println("Counter closed. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 0);

        sc.close();
    }
}
